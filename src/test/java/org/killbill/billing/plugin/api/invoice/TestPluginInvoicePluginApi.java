/*
 * Copyright 2014-2017 Groupon, Inc
 * Copyright 2014-2017 The Billing Project, LLC
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
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.killbill.billing.account.api.Account;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.invoice.api.InvoiceItem;
import org.killbill.billing.invoice.api.InvoiceItemType;
import org.killbill.billing.osgi.libs.killbill.OSGIConfigPropertiesService;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillAPI;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillLogService;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.plugin.TestUtils;
import org.killbill.billing.plugin.api.PluginTenantContext;
import org.killbill.billing.util.callcontext.TenantContext;
import org.killbill.clock.Clock;
import org.killbill.clock.DefaultClock;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

public class TestPluginInvoicePluginApi {

    private static final class PluginInvoicePluginApiTest extends PluginInvoicePluginApi {

        public PluginInvoicePluginApiTest(final OSGIKillbillAPI killbillAPI, final OSGIConfigPropertiesService configProperties, final OSGIKillbillLogService logService, final Clock clock) {
            super(killbillAPI, configProperties, logService, clock);
        }
    }

    private final Clock clock = new DefaultClock();
    private final List<PluginProperty> pluginProperties = ImmutableList.<PluginProperty>of();
    private final TenantContext context = new PluginTenantContext(null, UUID.randomUUID());

    private PluginInvoicePluginApi pluginInvoicePluginApi;

    private Account account;
    private Invoice invoice1;
    private InvoiceItem invoice1TaxableItem;
    private InvoiceItem invoice1TaxItem;
    private InvoiceItem invoice1AdjustmentItemForInvoice1TaxableItem;
    private Invoice invoice2;
    private InvoiceItem invoice2TaxableItem;
    private InvoiceItem invoice2AdjustmentItemForInvoice1TaxableItem;

    @BeforeMethod(groups = "fast")
    public void setUp() throws Exception {
        account = TestUtils.buildAccount(Currency.BTC, "US");

        final OSGIKillbillAPI killbillAPI = TestUtils.buildOSGIKillbillAPI(account);
        final OSGIConfigPropertiesService configPropertiesService = Mockito.mock(OSGIConfigPropertiesService.class);
        final OSGIKillbillLogService logService = TestUtils.buildLogService();
        pluginInvoicePluginApi = new PluginInvoicePluginApiTest(killbillAPI, configPropertiesService, logService, clock);

        invoice1 = TestUtils.buildInvoice(account);
        invoice1TaxableItem = TestUtils.buildInvoiceItem(invoice1, InvoiceItemType.EXTERNAL_CHARGE, BigDecimal.TEN, null);
        invoice1TaxItem = PluginInvoiceItem.createTaxItem(invoice1TaxableItem, invoice1.getId(), invoice1TaxableItem.getStartDate(), null, BigDecimal.ONE, "TestNG tax");
        invoice1AdjustmentItemForInvoice1TaxableItem = PluginInvoiceItem.createAdjustmentItem(invoice1TaxableItem, invoice1.getId(), invoice1TaxableItem.getStartDate(), null, BigDecimal.ONE.negate(), "Mis-billing 1");
        invoice1.getInvoiceItems().add(invoice1TaxableItem);
        invoice1.getInvoiceItems().add(invoice1TaxItem);
        invoice1.getInvoiceItems().add(invoice1AdjustmentItemForInvoice1TaxableItem);

        invoice2 = TestUtils.buildInvoice(account);
        invoice2TaxableItem = TestUtils.buildInvoiceItem(invoice2, InvoiceItemType.RECURRING, BigDecimal.TEN, null);
        invoice2AdjustmentItemForInvoice1TaxableItem = PluginInvoiceItem.createAdjustmentItem(invoice1TaxableItem, invoice2.getId(), invoice1TaxableItem.getStartDate(), null, BigDecimal.ONE.negate(), "Mis-billing 2");
        invoice2.getInvoiceItems().add(invoice2TaxableItem);
        invoice2.getInvoiceItems().add(invoice2AdjustmentItemForInvoice1TaxableItem);
    }

    @Test(groups = "fast")
    public void testGetAdditionalTaxInvoiceItems() throws Exception {
        final AtomicInteger invoicesSeen = new AtomicInteger();
        final PluginTaxCalculator pluginTaxCalculator = new PluginTaxCalculator() {

            @Override
            public List<InvoiceItem> compute(final Account calculatorAccount,
                                             final Invoice calculatorNewInvoice,
                                             final Invoice calculatorInvoice,
                                             final Map<UUID, InvoiceItem> taxableItems,
                                             final Map<UUID, Collection<InvoiceItem>> adjustmentItems,
                                             final boolean dryRun,
                                             final Iterable<PluginProperty> calculatorPluginProperties,
                                             final UUID kbTenantId) {
                Assert.assertEquals(calculatorAccount.getId(), account.getId());
                Assert.assertEquals(calculatorNewInvoice.getId(), invoice2.getId());
                Assert.assertEquals(calculatorPluginProperties, pluginProperties);
                Assert.assertEquals(kbTenantId, context.getTenantId());

                if (calculatorInvoice.getId().equals(invoice1.getId())) {
                    Assert.assertEquals(taxableItems.size(), 1);
                    Assert.assertEquals(taxableItems.get(invoice1TaxableItem.getId()).getId(), invoice1TaxableItem.getId());

                    // Two adjustments for item 1
                    Assert.assertEquals(adjustmentItems.size(), 1);
                    final List<InvoiceItem> adjustments = ImmutableList.<InvoiceItem>copyOf(adjustmentItems.get(invoice1TaxableItem.getId()));
                    Assert.assertEquals(adjustments.size(), 2);
                    Assert.assertEquals(adjustments.get(0).getId(), invoice1AdjustmentItemForInvoice1TaxableItem.getId());
                    Assert.assertEquals(adjustments.get(0).getInvoiceId(), invoice1.getId());
                    Assert.assertEquals(adjustments.get(1).getId(), invoice2AdjustmentItemForInvoice1TaxableItem.getId());
                    Assert.assertEquals(adjustments.get(1).getInvoiceId(), invoice2.getId());
                } else if (calculatorInvoice.getId().equals(invoice2.getId())) {
                    Assert.assertEquals(taxableItems.size(), 1);
                    Assert.assertEquals(taxableItems.get(invoice2TaxableItem.getId()).getId(), invoice2TaxableItem.getId());

                    // No adjustment
                    Assert.assertEquals(adjustmentItems.size(), 0);
                } else {
                    Assert.fail("Unknown invoice");
                }

                invoicesSeen.incrementAndGet();
                return ImmutableList.<InvoiceItem>of();
            }
        };

        final List<Invoice> allInvoices = ImmutableList.<Invoice>of(invoice1, invoice2);
        pluginInvoicePluginApi.getAdditionalTaxInvoiceItems(pluginTaxCalculator,
                                                            account,
                                                            allInvoices,
                                                            invoice2,
                                                            false,
                                                            pluginProperties,
                                                            context);
        Assert.assertEquals(invoicesSeen.get(), 2);
    }

    @Test(groups = "fast")
    public void testIsTaxableItem() throws Exception {
        Assert.assertTrue(pluginInvoicePluginApi.isTaxableItem(invoice1TaxableItem));
        Assert.assertFalse(pluginInvoicePluginApi.isTaxableItem(invoice1TaxItem));
        Assert.assertFalse(pluginInvoicePluginApi.isTaxableItem(invoice1AdjustmentItemForInvoice1TaxableItem));
        Assert.assertTrue(pluginInvoicePluginApi.isTaxableItem(invoice2TaxableItem));
        Assert.assertFalse(pluginInvoicePluginApi.isTaxableItem(invoice2AdjustmentItemForInvoice1TaxableItem));
    }

    @Test(groups = "fast")
    public void testIsTaxItem() throws Exception {
        Assert.assertFalse(pluginInvoicePluginApi.isTaxItem(invoice1TaxableItem));
        Assert.assertTrue(pluginInvoicePluginApi.isTaxItem(invoice1TaxItem));
        Assert.assertFalse(pluginInvoicePluginApi.isTaxItem(invoice1AdjustmentItemForInvoice1TaxableItem));
        Assert.assertFalse(pluginInvoicePluginApi.isTaxItem(invoice2TaxableItem));
        Assert.assertFalse(pluginInvoicePluginApi.isTaxItem(invoice2AdjustmentItemForInvoice1TaxableItem));
    }

    @Test(groups = "fast")
    public void testIsAdjustmentItem() throws Exception {
        Assert.assertFalse(pluginInvoicePluginApi.isAdjustmentItem(invoice1TaxableItem));
        Assert.assertFalse(pluginInvoicePluginApi.isAdjustmentItem(invoice1TaxItem));
        Assert.assertTrue(pluginInvoicePluginApi.isAdjustmentItem(invoice1AdjustmentItemForInvoice1TaxableItem));
        Assert.assertFalse(pluginInvoicePluginApi.isAdjustmentItem(invoice2TaxableItem));
        Assert.assertTrue(pluginInvoicePluginApi.isAdjustmentItem(invoice2AdjustmentItemForInvoice1TaxableItem));
    }
}
