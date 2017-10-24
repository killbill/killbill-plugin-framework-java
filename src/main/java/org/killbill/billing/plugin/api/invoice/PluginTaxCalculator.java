/*
 * Copyright 2015 Groupon, Inc
 * Copyright 2015 The Billing Project, LLC
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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Nullable;

import org.joda.time.LocalDate;
import org.killbill.billing.account.api.Account;
import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.invoice.api.InvoiceItem;
import org.killbill.billing.payment.api.PluginProperty;

import com.google.common.base.MoreObjects;

// This calculator implicitly assumes that tax items are not adjusted, only the taxable items are
// (tax adjustments show up as negative TAX items, linked to the original taxable item).
public abstract class PluginTaxCalculator {

    /**
     * Compute tax items (positive or negative, for adjustments) for a given invoice. Implementation is expected to be idempotent,
     * i.e. subsequent calls with the same input should yield an empty list.
     *
     * Note that <b>taxable</b> here means <i>what could be taxed</i>. The business will dictate whether the item(s)
     * should actually be taxed (and whether on the whole amount or a subset).
     *
     * @param account          Kill Bill account
     * @param newInvoice       Kill Bill invoice being created (latest one, may not be on disk yet)
     * @param invoice          Kill Bill historical invoice associated with the taxable items
     * @param taxableItems     taxable invoice items associated with that historical invoice
     * @param adjustmentItems  invoice item adjustments per taxable item (across all invoices), if any
     * @param dryRun           if true, the invoice won't be persisted
     * @param pluginProperties Kill Bill plugin properties
     * @param kbTenantId       Kill Bill tenant
     */
    public abstract List<InvoiceItem> compute(Account account,
                                              Invoice newInvoice,
                                              Invoice invoice,
                                              Map<UUID, InvoiceItem> taxableItems,
                                              Map<UUID, Collection<InvoiceItem>> adjustmentItems,
                                              boolean dryRun,
                                              Iterable<PluginProperty> pluginProperties,
                                              UUID kbTenantId);


    // Utility methods

    /**
     * Create an invoice item of type TAX
     *
     * @param originalItem original item model
     * @param invoiceId    invoice id of the new item
     * @param date         invoice item date
     * @param amount       invoice item amount
     * @param description  invoice item description
     * @return TAX invoice item
     */
    protected InvoiceItem buildTaxItem(final InvoiceItem originalItem, final UUID invoiceId, final LocalDate date, final BigDecimal amount, @Nullable final String description) {
        if (amount == null || BigDecimal.ZERO.compareTo(amount) == 0) {
            return null;
        } else {
            return PluginInvoiceItem.createTaxItem(originalItem, invoiceId, date, null, amount, MoreObjects.firstNonNull(description, "Tax"));
        }
    }

    /**
     * Given a map of already taxed items associated with their adjustments already taken into account, and the full list of taxable
     * items and their adjustments for that invoice, compute the difference, i.e. the set of new items that need to be taxed
     * and the taxed items (with the new adjustments not yet taken into account) that need to be adjusted.
     *
     * @param taxableItems                     taxable invoice items associated with a given historical invoice
     * @param adjustmentItems                  invoice item adjustments associated (across all invoices)
     * @param alreadyTaxedItemsWithAdjustments list of already taxed items and their adjustments
     * @param newItemsToTax                    will be populated with the new invoice items to tax
     * @param existingItemsToAdjust            will be populated with the (already taxed) invoice items that need to be adjusted
     * @param adjustmentItemsForExistingItems  will be populated with the new adjustment items to take into consideration for existingItemsToAdjust
     */
    protected void computeNewItemsToTaxAndExistingItemsToAdjust(final Map<UUID, InvoiceItem> taxableItems,
                                                                @Nullable final Map<UUID, Collection<InvoiceItem>> adjustmentItems,
                                                                final Map<UUID, Set<UUID>> alreadyTaxedItemsWithAdjustments,
                                                                final Map<UUID, InvoiceItem> newItemsToTax,
                                                                final Map<UUID, InvoiceItem> existingItemsToAdjust,
                                                                final Map<UUID, Collection<InvoiceItem>> adjustmentItemsForExistingItems) {
        for (final InvoiceItem taxableItem : taxableItems.values()) {
            final Collection<InvoiceItem> taxableItemAdjustments = adjustmentItems == null ? null : adjustmentItems.get(taxableItem.getId());
            final Set<UUID> alreadyCommittedAdjustments = alreadyTaxedItemsWithAdjustments.get(taxableItem.getId());

            if (alreadyCommittedAdjustments == null) {
                // New item to tax
                if (taxableItemAdjustments != null && !taxableItemAdjustments.isEmpty()) {
                    // New adjustment
                    if (adjustmentItemsForExistingItems.get(taxableItem.getId()) == null) {
                        adjustmentItemsForExistingItems.put(taxableItem.getId(), new LinkedList<InvoiceItem>());
                    }
                    adjustmentItemsForExistingItems.get(taxableItem.getId()).addAll(taxableItemAdjustments);
                    existingItemsToAdjust.put(taxableItem.getId(), taxableItem);
                }
                newItemsToTax.put(taxableItem.getId(), taxableItem);
            } else {
                // Item already taxed, check if new adjustments came up
                if (taxableItemAdjustments != null) {
                    for (final InvoiceItem adjustmentItem : taxableItemAdjustments) {
                        if (!alreadyCommittedAdjustments.contains(adjustmentItem.getId())) {
                            // New adjustment
                            if (adjustmentItemsForExistingItems.get(taxableItem.getId()) == null) {
                                adjustmentItemsForExistingItems.put(taxableItem.getId(), new LinkedList<InvoiceItem>());
                            }
                            adjustmentItemsForExistingItems.get(taxableItem.getId()).add(adjustmentItem);
                        }
                    }
                    if (adjustmentItemsForExistingItems.get(taxableItem.getId()) != null) {
                        // At least one new adjustment to take into account
                        existingItemsToAdjust.put(taxableItem.getId(), taxableItem);
                    }
                } else {
                    // No adjustment in Kill Bill, and since these cannot be deleted, there is nothing to do
                }
            }
        }
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
}
