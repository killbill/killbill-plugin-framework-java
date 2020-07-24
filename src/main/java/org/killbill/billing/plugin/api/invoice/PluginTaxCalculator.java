/*
 * Copyright 2014-2020 Groupon, Inc
 * Copyright 2020-2020 Equinix, Inc
 * Copyright 2014-2020 The Billing Project, LLC
 *
 * The Billing Project licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.killbill.billing.plugin.api.invoice;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Nullable;

import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.invoice.api.InvoiceApiException;
import org.killbill.billing.invoice.api.InvoiceItem;
import org.killbill.billing.invoice.api.InvoiceItemType;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillAPI;
import org.killbill.billing.util.callcontext.TenantContext;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;

// This calculator implicitly assumes that tax items are not adjusted, only the taxable items are
// (tax adjustments show up as negative TAX items, linked to the original taxable item).
public abstract class PluginTaxCalculator {

    public static final List<InvoiceItemType> TAXABLE_ITEM_TYPES = ImmutableList.<InvoiceItemType>of(InvoiceItemType.EXTERNAL_CHARGE,
                                                                                                     InvoiceItemType.FIXED,
                                                                                                     InvoiceItemType.RECURRING,
                                                                                                     InvoiceItemType.USAGE);
    public static final List<InvoiceItemType> ADJUSTMENT_ITEM_TYPES = ImmutableList.<InvoiceItemType>of(InvoiceItemType.ITEM_ADJ,
                                                                                                        InvoiceItemType.REPAIR_ADJ);

    protected final OSGIKillbillAPI osgiKillbillAPI;

    public PluginTaxCalculator(final OSGIKillbillAPI osgiKillbillAPI) {
        this.osgiKillbillAPI = osgiKillbillAPI;
    }

    /**
     * For a given invoice, given a set of already taxed items (and adjustments already taken into account), compute the items
     * (with their adjustment(s)) that need to be taxed or returned.
     *
     * @param invoice                          the invoice that is being handled for tax purposes (may or may not be on disk)
     * @param alreadyTaxedItemsWithAdjustments mapping of (already taxed) taxable item id to adjustments already taken into account for tax purposes
     * @param tenantContext                    tenant context
     */
    @SuppressWarnings("StatementWithEmptyBody")
    public List<NewItemToTax> computeTaxItems(final Invoice invoice,
                                              @Nullable final Map<UUID, Set<UUID>> alreadyTaxedItemsWithAdjustments,
                                              final TenantContext tenantContext) throws InvoiceApiException {
        // Invoices look-up map
        final Map<UUID, Invoice> invoicesCache = new HashMap<UUID, Invoice>();
        invoicesCache.put(invoice.getId(), invoice);

        // Invoice items look-up map (not necessarily tied to a single invoice)
        final Map<UUID, InvoiceItem> allItems = new HashMap<UUID, InvoiceItem>();
        // All taxable invoice item ids either on that invoice, or referenced to by that invoice (REPAIR_ADJ usecase)
        final Map<UUID, InvoiceItem> allTaxableItems = new HashMap<UUID, InvoiceItem>();
        // Mapping of invoice item ids to their invoice item adjustment ids. In case of repair, keys may point to taxable items on previous invoices
        final Multimap<UUID, UUID> adjustmentsByLinkedId = HashMultimap.<UUID, UUID>create();
        for (final InvoiceItem invoiceItem : invoice.getInvoiceItems()) {
            allItems.put(invoiceItem.getId(), invoiceItem);
            if (isTaxableItem(invoiceItem)) {
                allTaxableItems.put(invoiceItem.getId(), invoiceItem);
            } else if (isAdjustmentItem(invoiceItem)) {
                adjustmentsByLinkedId.put(invoiceItem.getLinkedItemId(), invoiceItem.getId());
            }
        }

        // Handle REPAIR_ADJ
        // This is the set of taxable items referenced from repair items in this invoice
        final Collection<UUID> prevLinkedItemdIds = new HashSet<UUID>();
        for (final UUID invoiceItemId : adjustmentsByLinkedId.keySet()) {
            if (allItems.get(invoiceItemId) != null) {
                // Adjustment points to an item on that new invoice, nothing to do
                continue;
            }

            // Adjustment points to a different invoice (most likely a REPAIR_ADJ)
            // Before 2020, we used to do the opposite, i.e. pre-load all invoices from the account in memory,
            // while we are now more opportunistic (REPAIR_ADJ isn't that common)
            final Invoice previousInvoice = osgiKillbillAPI.getInvoiceUserApi().getInvoiceByInvoiceItem(invoiceItemId, tenantContext);
            invoicesCache.put(previousInvoice.getId(), previousInvoice);

            boolean foundIt = false;
            for (final InvoiceItem previousInvoiceItem : previousInvoice.getInvoiceItems()) {
                if (!previousInvoiceItem.getId().equals(invoiceItemId)) {
                    continue;
                }

                foundIt = true;
                if (!isTaxableItem(previousInvoiceItem)) {
                    // Unclear if that's even possible? In any case, ignore...
                    break;
                }
                allTaxableItems.put(previousInvoiceItem.getId(), previousInvoiceItem);
                // Note that previousInvoiceItem might also have additional adjustments on that previousInvoice, but we assume
                // 1) These item adjustments have already been taken into account for tax purposes when previousInvoice was processed
                // 2) The repair amount takes into account these item adjustments
                break;
            }
            prevLinkedItemdIds.add(invoiceItemId);
            Preconditions.checkState(foundIt, "Couldn't find linked item %s", invoiceItemId);
        }

        final List<NewItemToTax> newItemsToTax = new LinkedList<NewItemToTax>();
        for (final Entry<UUID, InvoiceItem> entry : allTaxableItems.entrySet()) {
            final UUID taxableItemId = entry.getKey();
            final InvoiceItem taxableItem = entry.getValue();

            // Compute the difference between adjustments already taken into account and new ones
            final Set<UUID> adjustmentsAlreadyTakenIntoAccount = alreadyTaxedItemsWithAdjustments == null ? null : alreadyTaxedItemsWithAdjustments.get(taxableItemId);
            final Collection<UUID> currentAdjustmentIdsForTaxableId = MoreObjects.firstNonNull(adjustmentsByLinkedId.get(taxableItemId), new LinkedList<UUID>());
            if (adjustmentsAlreadyTakenIntoAccount != null) {
                currentAdjustmentIdsForTaxableId.removeAll(adjustmentsAlreadyTakenIntoAccount);
            }

            // New adjustment items: if not empty, some tax must be returned
            final List<InvoiceItem> adjustments = currentAdjustmentIdsForTaxableId.isEmpty() ? null : new LinkedList<InvoiceItem>();
            for (final UUID currentAdjustmentId : currentAdjustmentIdsForTaxableId) {
                adjustments.add(allItems.get(currentAdjustmentId));
            }

            if (adjustmentsAlreadyTakenIntoAccount != null) {
                // This item was already taxed: are there additional adjustments to take into account?
                if (currentAdjustmentIdsForTaxableId.isEmpty()) {
                    // All adjustments already taken into account, nothing to do (idempotency)
                } else {
                    // Already taxed, but some items to return
                    newItemsToTax.add(new NewItemToTax(invoicesCache.get(taxableItem.getInvoiceId()),
                                                       taxableItem,
                                                       adjustments,
                                                       true));
                }
            } else {
                // For repairs, assume the original item was already taxed, so that the caller doesn't have to send us data in alreadyTaxedItemsWithAdjustments spanning on historical invoices
                final boolean returnOnly = prevLinkedItemdIds.contains(taxableItem.getId());

                // If adjustmentsAlreadyTakenIntoAccount is null, this means this is a taxable item not yet taxed (missing entry from alreadyTaxedItemsWithAdjustments)
                newItemsToTax.add(new NewItemToTax(invoicesCache.get(taxableItem.getInvoiceId()),
                                                   taxableItem,
                                                   adjustments,
                                                   returnOnly)); // We might have some adjustments on the first go (e.g. invoice plugin adding ITEM_ADJ)
            }
        }
        return newItemsToTax;
    }

    /**
     * Create an invoice item of type TAX
     *
     * @param originalItem   original item model
     * @param invoiceId      invoice id of the new item
     * @param adjustmentItem adjustment item to use for the service period, if returning the item
     * @param amount         invoice item amount
     * @param description    invoice item description
     * @return TAX invoice item
     */
    protected InvoiceItem buildTaxItem(final InvoiceItem originalItem,
                                       final UUID invoiceId,
                                       @Nullable final InvoiceItem adjustmentItem,
                                       final BigDecimal amount,
                                       @Nullable final String description) {
        if (amount == null || BigDecimal.ZERO.compareTo(amount) == 0) {
            return null;
        } else {
            if (adjustmentItem != null) {
                return PluginInvoiceItem.createTaxItem(originalItem,
                                                       invoiceId,
                                                       adjustmentItem.getStartDate(),
                                                       adjustmentItem.getEndDate(),
                                                       amount,
                                                       MoreObjects.firstNonNull(description, "Tax"));
            } else {
                return PluginInvoiceItem.createTaxItem(originalItem,
                                                       invoiceId,
                                                       amount,
                                                       MoreObjects.firstNonNull(description, "Tax"));
            }
        }
    }

    protected boolean isTaxableItem(final InvoiceItem invoiceItem) {
        return invoiceItem.getAmount() != null &&
               BigDecimal.ZERO.compareTo(invoiceItem.getAmount()) < 0 &&
               TAXABLE_ITEM_TYPES.contains(invoiceItem.getInvoiceItemType());
    }

    protected boolean isTaxItem(final InvoiceItem invoiceItem) {
        return InvoiceItemType.TAX.equals(invoiceItem.getInvoiceItemType());
    }

    protected boolean isAdjustmentItem(final InvoiceItem invoiceItem) {
        return ADJUSTMENT_ITEM_TYPES.contains(invoiceItem.getInvoiceItemType());
    }

    /**
     * Compute the sum of invoice items amount, taking into account adjustments, if any
     *
     * @param invoiceItem     invoice items to sum
     * @param adjustmentItems adjustments for that item, if any
     * @return the adjusted sum of all invoice items amount
     */
    protected BigDecimal netAmount(final InvoiceItem invoiceItem, @Nullable final Iterable<InvoiceItem> adjustmentItems) {
        final BigDecimal adjustedAmount = sum(adjustmentItems);
        return invoiceItem.getAmount() != null ? invoiceItem.getAmount().add(adjustedAmount) : adjustedAmount;
    }

    /**
     * Compute the sum of invoice items amount
     *
     * @param invoiceItems invoice items to sum
     * @return the sum of all invoice items amount
     */
    protected BigDecimal sum(@Nullable final Iterable<InvoiceItem> invoiceItems) {
        BigDecimal sum = BigDecimal.ZERO;
        if (invoiceItems != null) {
            for (final InvoiceItem invoiceItem : invoiceItems) {
                if (invoiceItem.getAmount() != null) {
                    sum = sum.add(invoiceItem.getAmount());
                }
            }
        }
        return sum;
    }

    public static class NewItemToTax {

        private final Invoice invoice;
        private final InvoiceItem taxableItem;
        private final List<InvoiceItem> adjustmentItems;
        private final boolean returnOnly;

        /**
         * Structure describing a new item to take into account for tax purposes.
         * <p>
         * If adjustmentItems is specified and returnOnly is false, this is a corner case when an invoice is being generated
         * and an invoice plugin adds an ITEM_ADJ against that item.
         *
         * @param invoice         invoice associated with taxableItem
         * @param taxableItem     either a new item to tax or an item already taxed but with new adjustments to return
         * @param adjustmentItems new adjustment items associated with taxableItem
         * @param returnOnly      if true, taxableItem has already been taxed: just take into account the adjustments
         *                        if false, taxableItem must also be taxed
         */
        public NewItemToTax(final Invoice invoice,
                            final InvoiceItem taxableItem,
                            @Nullable final List<InvoiceItem> adjustmentItems,
                            final boolean returnOnly) {
            Preconditions.checkNotNull(invoice, "invoice cannot be null");
            Preconditions.checkNotNull(taxableItem, "taxableItem cannot be null");
            Preconditions.checkState(adjustmentItems == null || !adjustmentItems.isEmpty(), "adjustmentItems shouldn't be empty by convention");
            Preconditions.checkState(!returnOnly || adjustmentItems != null, "adjustmentItems cannot be null if returnOnly");
            this.invoice = invoice;
            this.taxableItem = taxableItem;
            this.adjustmentItems = adjustmentItems;
            this.returnOnly = returnOnly;
        }

        public Invoice getInvoice() {
            return invoice;
        }

        public InvoiceItem getTaxableItem() {
            return taxableItem;
        }

        public List<InvoiceItem> getAdjustmentItems() {
            return adjustmentItems;
        }

        public boolean isReturnOnly() {
            return returnOnly;
        }

        @Override
        public String toString() {
            return "NewItemToTax{" +
                   "invoice=" + invoice +
                   ", taxableItem=" + taxableItem +
                   ", adjustmentItems=" + adjustmentItems +
                   ", returnOnly=" + returnOnly +
                   '}';
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            final NewItemToTax that = (NewItemToTax) o;

            if (returnOnly != that.returnOnly) {
                return false;
            }
            if (invoice != null ? !invoice.equals(that.invoice) : that.invoice != null) {
                return false;
            }
            if (taxableItem != null ? !taxableItem.equals(that.taxableItem) : that.taxableItem != null) {
                return false;
            }
            return adjustmentItems != null ? adjustmentItems.equals(that.adjustmentItems) : that.adjustmentItems == null;
        }

        @Override
        public int hashCode() {
            int result = invoice != null ? invoice.hashCode() : 0;
            result = 31 * result + (taxableItem != null ? taxableItem.hashCode() : 0);
            result = 31 * result + (adjustmentItems != null ? adjustmentItems.hashCode() : 0);
            result = 31 * result + (returnOnly ? 1 : 0);
            return result;
        }
    }
}
