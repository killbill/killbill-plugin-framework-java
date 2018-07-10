/*
 * Copyright 2015-2016 Groupon, Inc
 * Copyright 2015-2016 The Billing Project, LLC
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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.killbill.billing.account.api.Account;
import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.invoice.api.InvoiceItem;
import org.killbill.billing.invoice.api.InvoiceItemType;
import org.killbill.billing.invoice.plugin.api.InvoiceContext;
import org.killbill.billing.invoice.plugin.api.InvoicePluginApi;
import org.killbill.billing.invoice.plugin.api.OnFailureInvoiceResult;
import org.killbill.billing.invoice.plugin.api.OnSuccessInvoiceResult;
import org.killbill.billing.invoice.plugin.api.PriorInvoiceResult;
import org.killbill.billing.osgi.libs.killbill.OSGIConfigPropertiesService;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillAPI;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillLogService;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.plugin.api.PluginApi;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;
import org.killbill.clock.Clock;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

public class PluginInvoicePluginApi extends PluginApi implements InvoicePluginApi {

    protected static final List<InvoiceItemType> TAXABLE_ITEM_TYPES = ImmutableList.<InvoiceItemType>of(InvoiceItemType.EXTERNAL_CHARGE,
                                                                                                        InvoiceItemType.FIXED,
                                                                                                        InvoiceItemType.RECURRING,
                                                                                                        InvoiceItemType.USAGE);
    protected static final List<InvoiceItemType> ADJUSTMENT_ITEM_TYPES = ImmutableList.<InvoiceItemType>of(InvoiceItemType.ITEM_ADJ,
                                                                                                           InvoiceItemType.REPAIR_ADJ);

    public PluginInvoicePluginApi(final OSGIKillbillAPI killbillAPI, final OSGIConfigPropertiesService configProperties, final OSGIKillbillLogService logService, final Clock clock) {
        super(killbillAPI, configProperties, logService, clock);
    }

    @Override
    public PriorInvoiceResult priorCall(final InvoiceContext context, final Iterable<PluginProperty> properties) {
        return new PluginPriorInvoiceResult();
    }

    @Override
    public List<InvoiceItem> getAdditionalInvoiceItems(final Invoice invoice, final boolean dryRun, final Iterable<PluginProperty> properties, final CallContext context) {
        return ImmutableList.<InvoiceItem>of();
    }

    @Override
    public OnSuccessInvoiceResult onSuccessCall(final InvoiceContext context, final Iterable<PluginProperty> properties) {
        return new PluginOnSuccessInvoiceResult();
    }

    @Override
    public OnFailureInvoiceResult onFailureCall(final InvoiceContext context, final Iterable<PluginProperty> properties) {
        return new PluginOnFailureInvoiceResult();
    }

    /**
     * Apply tax calculation on all historical invoices and the current one being processed.
     * This will call the tax calculator once per invoice.
     *
     * @param taxCalculator tax calculator implementation
     * @param newInvoice    Kill Bill invoice being created (latest one, may not be on disk yet)
     * @param dryRun        if true, the invoice won't be persisted
     * @param properties    Kill Bill plugin properties
     * @param context       Kill Bill context
     * @return all tax items that need to be created
     */
    protected List<InvoiceItem> getAdditionalTaxInvoiceItems(final PluginTaxCalculator taxCalculator,
                                                             final Invoice newInvoice,
                                                             final boolean dryRun,
                                                             final Iterable<PluginProperty> properties,
                                                             final TenantContext context) {
        final Account account = getAccount(newInvoice.getAccountId(), context);
        final Collection<Invoice> allInvoices = new LinkedList<Invoice>(getInvoicesByAccountId(newInvoice.getAccountId(), context));
        return getAdditionalTaxInvoiceItems(taxCalculator, account, allInvoices, newInvoice, dryRun, properties, context);
    }

    @VisibleForTesting
    protected List<InvoiceItem> getAdditionalTaxInvoiceItems(final PluginTaxCalculator taxCalculator,
                                                             final Account account,
                                                             final Collection<Invoice> allInvoicesOnDisk,
                                                             final Invoice newInvoice,
                                                             final boolean dryRun,
                                                             final Iterable<PluginProperty> properties,
                                                             final TenantContext context) {
        // Make sure to get the latest state for the new invoice (some items may not be on disk yet)
        // See also https://github.com/killbill/killbill/issues/265
        final Collection<Invoice> allInvoices = new LinkedList<Invoice>();
        for (final Invoice invoice : allInvoicesOnDisk) {
            if (!invoice.getId().equals(newInvoice.getId())) {
                allInvoices.add(invoice);
            }
        }
        allInvoices.add(newInvoice);

        final Map<UUID, InvoiceItem> allTaxableItems = new HashMap<UUID, InvoiceItem>();
        final Map<UUID, Collection<InvoiceItem>> existingAdjustmentItems = new HashMap<UUID, Collection<InvoiceItem>>();
        for (final Invoice invoice : allInvoices) {
            for (final InvoiceItem invoiceItem : invoice.getInvoiceItems()) {
                if (isTaxableItem(invoiceItem)) {
                    allTaxableItems.put(invoiceItem.getId(), invoiceItem);
                }
                if (isAdjustmentItem(invoiceItem)) {
                    if (existingAdjustmentItems.get(invoiceItem.getLinkedItemId()) == null) {
                        existingAdjustmentItems.put(invoiceItem.getLinkedItemId(), new LinkedList<InvoiceItem>());
                    }
                    existingAdjustmentItems.get(invoiceItem.getLinkedItemId()).add(invoiceItem);
                }
            }
        }

        final List<InvoiceItem> additionalTaxInvoiceItems = new LinkedList<InvoiceItem>();
        for (final Invoice invoice : allInvoices) {
            final Map<UUID, InvoiceItem> taxableItems = Maps.<UUID, InvoiceItem>filterEntries(allTaxableItems,
                                                                                              new Predicate<Map.Entry<UUID, InvoiceItem>>() {
                                                                                                  @Override
                                                                                                  public boolean apply(final Map.Entry<UUID, InvoiceItem> taxableItem) {
                                                                                                      return invoice.getId().equals(taxableItem.getValue().getInvoiceId());
                                                                                                  }
                                                                                              });
            final Map<UUID, Collection<InvoiceItem>> adjustmentItems = Maps.<UUID, Collection<InvoiceItem>>filterEntries(existingAdjustmentItems,
                                                                                                                         new Predicate<Map.Entry<UUID, Collection<InvoiceItem>>>() {
                                                                                                                             @Override
                                                                                                                             public boolean apply(final Map.Entry<UUID, Collection<InvoiceItem>> adjustmentItem) {
                                                                                                                                 return taxableItems.keySet().contains(adjustmentItem.getKey());
                                                                                                                             }
                                                                                                                         });
            final List<InvoiceItem> taxInvoiceItems = taxCalculator.compute(account,
                                                                            newInvoice,
                                                                            invoice,
                                                                            taxableItems,
                                                                            adjustmentItems,
                                                                            dryRun,
                                                                            properties,
                                                                            context.getTenantId());
            additionalTaxInvoiceItems.addAll(taxInvoiceItems);
        }

        return additionalTaxInvoiceItems;
    }

    protected boolean isTaxableItem(final InvoiceItem invoiceItem) {
        return invoiceItem.getAmount() != null && BigDecimal.ZERO.compareTo(invoiceItem.getAmount()) < 0 && TAXABLE_ITEM_TYPES.contains(invoiceItem.getInvoiceItemType());
    }

    protected boolean isTaxItem(final InvoiceItem invoiceItem) {
        return InvoiceItemType.TAX.equals(invoiceItem.getInvoiceItemType());
    }

    protected boolean isAdjustmentItem(final InvoiceItem invoiceItem) {
        return ADJUSTMENT_ITEM_TYPES.contains(invoiceItem.getInvoiceItemType());
    }
}
