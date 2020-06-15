/*
 * Copyright 2015-2020 Groupon, Inc
 * Copyright 2020-2020 Equinix, Inc
 * Copyright 2015-2020 The Billing Project, LLC
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
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.killbill.billing.account.api.Account;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.invoice.api.InvoiceItem;
import org.killbill.billing.invoice.api.InvoiceItemType;
import org.killbill.billing.invoice.api.InvoiceUserApi;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillAPI;
import org.killbill.billing.plugin.TestUtils;
import org.killbill.billing.plugin.api.invoice.PluginTaxCalculator.NewItemToTax;
import org.killbill.billing.util.callcontext.TenantContext;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

public class TestPluginTaxCalculator {

    private static final class PluginTaxCalculatorTest extends PluginTaxCalculator {

        public PluginTaxCalculatorTest(final OSGIKillbillAPI osgiKillbillAPI) {
            super(osgiKillbillAPI);
        }
    }

    private PluginTaxCalculatorTest pluginTaxCalculatorTest;

    private Invoice invoice1;
    private Invoice invoice2;
    private InvoiceItem invoice1TaxableItem;
    private InvoiceItem invoice1TaxItem;
    private InvoiceItem invoice2TaxItem;
    private InvoiceItem invoice1AdjustmentItemForInvoice1TaxableItem;
    private InvoiceItem invoice2AdjustmentItemForInvoice1TaxableItem;
    private TenantContext tenantContext;

    @BeforeMethod(groups = "fast")
    public void setUp() throws Exception {
        final Account account = TestUtils.buildAccount(Currency.USD, "US");

        final OSGIKillbillAPI osgiKillbillAPI = TestUtils.buildOSGIKillbillAPI(account);
        Mockito.when(osgiKillbillAPI.getInvoiceUserApi()).thenReturn(Mockito.mock(InvoiceUserApi.class));
        pluginTaxCalculatorTest = new PluginTaxCalculatorTest(osgiKillbillAPI);

        invoice1 = TestUtils.buildInvoice(account);
        invoice1TaxableItem = TestUtils.buildInvoiceItem(invoice1, InvoiceItemType.EXTERNAL_CHARGE, BigDecimal.TEN, null);
        invoice1TaxItem = PluginInvoiceItem.createTaxItem(invoice1TaxableItem, invoice1.getId(), BigDecimal.ONE, "TestNG tax");
        invoice1AdjustmentItemForInvoice1TaxableItem = PluginInvoiceItem.createAdjustmentItem(invoice1TaxableItem, invoice1.getId(), invoice1TaxableItem.getStartDate(), null, BigDecimal.ONE.negate(), "Mis-billing 1");

        Mockito.when(osgiKillbillAPI.getInvoiceUserApi().getInvoiceByInvoiceItem(Mockito.eq(invoice1TaxableItem.getId()), Mockito.<TenantContext>any()))
               .thenReturn(invoice1);

        invoice2 = TestUtils.buildInvoice(account);
        invoice2TaxItem = PluginInvoiceItem.createTaxItem(invoice1TaxableItem, invoice2.getId(), new BigDecimal("-0.01"), "TestNG tax");
        invoice2AdjustmentItemForInvoice1TaxableItem = PluginInvoiceItem.createAdjustmentItem(invoice1TaxableItem, invoice2.getId(), invoice1TaxableItem.getStartDate(), null, BigDecimal.ONE.negate(), "Mis-billing 2");

        tenantContext = Mockito.mock(TenantContext.class);
    }

    @Test(groups = "fast")
    public void testComputeWithNewTaxableItemNoAdjustment() throws Exception {
        /*
         * Scenario A:
         *     $10 Taxable item I1
         */
        invoice1.getInvoiceItems().add(invoice1TaxableItem);
        List<NewItemToTax> newItemsToTax = pluginTaxCalculatorTest.computeTaxItems(invoice1, null, tenantContext);
        // 1 item to tax
        Assert.assertEquals(newItemsToTax.size(), 1);
        Assert.assertEquals(newItemsToTax.get(0).getInvoice(), invoice1);
        Assert.assertEquals(newItemsToTax.get(0).getTaxableItem(), invoice1TaxableItem);
        Assert.assertNull(newItemsToTax.get(0).getAdjustmentItems());
        Assert.assertFalse(newItemsToTax.get(0).isReturnOnly());

        /*
         * Scenario B: re-invoice of A (should be idempotent)
         *     $10 Taxable item I1
         *      $1 Tax item I2
         */
        invoice1.getInvoiceItems().add(invoice1TaxItem);
        newItemsToTax = pluginTaxCalculatorTest.computeTaxItems(invoice1, ImmutableMap.<UUID, Set<UUID>>of(invoice1TaxableItem.getId(), ImmutableSet.<UUID>of()), tenantContext);
        // Nothing to do
        Assert.assertEquals(newItemsToTax.size(), 0);
    }

    @Test(groups = "fast")
    public void testComputeWithNewTaxableItemAndNewAdjustment() throws Exception {
        /*
         * Scenario A:
         *     $10 Taxable item I1
         *     -$1 Item adjustment I2
         */
        invoice1.getInvoiceItems().add(invoice1TaxableItem);
        invoice1.getInvoiceItems().add(invoice1AdjustmentItemForInvoice1TaxableItem);
        List<NewItemToTax> newItemsToTax = pluginTaxCalculatorTest.computeTaxItems(invoice1, null, tenantContext);
        // 1 item to tax
        Assert.assertEquals(newItemsToTax.size(), 1);
        Assert.assertEquals(newItemsToTax.get(0).getInvoice(), invoice1);
        Assert.assertEquals(newItemsToTax.get(0).getTaxableItem(), invoice1TaxableItem);
        Assert.assertEquals(newItemsToTax.get(0).getAdjustmentItems().size(), 1);
        Assert.assertEquals(newItemsToTax.get(0).getAdjustmentItems().get(0), invoice1AdjustmentItemForInvoice1TaxableItem);
        Assert.assertFalse(newItemsToTax.get(0).isReturnOnly());

        /*
         * Scenario B: re-invoice of A (should be idempotent)
         *     $10 Taxable item I1
         *     -$1 Item adjustment I2
         *      $1 Tax item I2
         */
        invoice1.getInvoiceItems().add(invoice1TaxItem);
        newItemsToTax = pluginTaxCalculatorTest.computeTaxItems(invoice1, ImmutableMap.<UUID, Set<UUID>>of(invoice1TaxableItem.getId(), ImmutableSet.<UUID>of(invoice1AdjustmentItemForInvoice1TaxableItem.getId())), tenantContext);
        // Nothing to do
        Assert.assertEquals(newItemsToTax.size(), 0);
    }

    @Test(groups = "fast")
    public void testComputeWithTaxableItemAndNewAdjustment() throws Exception {
        /*
         * Scenario A:
         *     $10 Taxable item I1
         *      $1 Tax item I2
         *     -$1 Item adjustment I2
         */
        invoice1.getInvoiceItems().add(invoice1TaxableItem);
        invoice1.getInvoiceItems().add(invoice1AdjustmentItemForInvoice1TaxableItem);
        invoice1.getInvoiceItems().add(invoice1TaxItem);
        final List<NewItemToTax> newItemsToTax = pluginTaxCalculatorTest.computeTaxItems(invoice1, ImmutableMap.<UUID, Set<UUID>>of(invoice1TaxableItem.getId(), ImmutableSet.<UUID>of()), tenantContext);
        // 1 item to return
        Assert.assertEquals(newItemsToTax.size(), 1);
        Assert.assertEquals(newItemsToTax.get(0).getInvoice(), invoice1);
        Assert.assertEquals(newItemsToTax.get(0).getTaxableItem(), invoice1TaxableItem);
        Assert.assertEquals(newItemsToTax.get(0).getAdjustmentItems().size(), 1);
        Assert.assertEquals(newItemsToTax.get(0).getAdjustmentItems().get(0), invoice1AdjustmentItemForInvoice1TaxableItem);
        // Different from the previous scenario!
        Assert.assertTrue(newItemsToTax.get(0).isReturnOnly());
    }

    @Test(groups = "fast")
    public void testComputeWithRepair() throws Exception {
        /*
         * Scenario A:
         *     -$1 Repair I1 (points to taxable item on invoice 1)
         */
        invoice1.getInvoiceItems().add(invoice1TaxableItem);
        invoice2.getInvoiceItems().add(invoice2AdjustmentItemForInvoice1TaxableItem);
        // Note the NULL here: we dont require the caller to pass us the information that the taxable item on the previous invoice was already taxed
        List<NewItemToTax> newItemsToTax = pluginTaxCalculatorTest.computeTaxItems(invoice2, null, tenantContext);
        // 1 item to return
        Assert.assertEquals(newItemsToTax.size(), 1);
        Assert.assertEquals(newItemsToTax.get(0).getInvoice(), invoice1);
        Assert.assertEquals(newItemsToTax.get(0).getTaxableItem(), invoice1TaxableItem);
        Assert.assertEquals(newItemsToTax.get(0).getAdjustmentItems().size(), 1);
        Assert.assertEquals(newItemsToTax.get(0).getAdjustmentItems().get(0), invoice2AdjustmentItemForInvoice1TaxableItem);
        Assert.assertTrue(newItemsToTax.get(0).isReturnOnly());

        /*
         * Scenario B: re-invoice of A (should be idempotent)
         *     -$1    Repair I1 (points to taxable item on invoice 1)
         *     -$0.01 Tax item I2
         */
        invoice2.getInvoiceItems().add(invoice2TaxItem);
        newItemsToTax = pluginTaxCalculatorTest.computeTaxItems(invoice1, ImmutableMap.<UUID, Set<UUID>>of(invoice1TaxableItem.getId(), ImmutableSet.<UUID>of(invoice2AdjustmentItemForInvoice1TaxableItem.getId())), tenantContext);
        // Nothing to do
        Assert.assertEquals(newItemsToTax.size(), 0);
    }

    @Test(groups = "fast")
    public void testNetAmount() throws Exception {
        final BigDecimal sum = pluginTaxCalculatorTest.netAmount(invoice1TaxableItem, ImmutableList.<InvoiceItem>of(invoice1AdjustmentItemForInvoice1TaxableItem));
        Assert.assertEquals(sum.compareTo(new BigDecimal("9")), 0);
    }

    @Test(groups = "fast")
    public void testSum() throws Exception {
        final ImmutableList<InvoiceItem> invoiceItems = ImmutableList.<InvoiceItem>of(invoice1TaxableItem, invoice1TaxItem, invoice1AdjustmentItemForInvoice1TaxableItem);
        final BigDecimal sum = pluginTaxCalculatorTest.sum(invoiceItems);
        Assert.assertEquals(sum.compareTo(BigDecimal.TEN), 0);
    }

    @Test(groups = "fast")
    public void testIsTaxableItem() throws Exception {
        Assert.assertTrue(pluginTaxCalculatorTest.isTaxableItem(invoice1TaxableItem));
        Assert.assertFalse(pluginTaxCalculatorTest.isTaxableItem(invoice1TaxItem));
        Assert.assertFalse(pluginTaxCalculatorTest.isTaxableItem(invoice2TaxItem));
        Assert.assertFalse(pluginTaxCalculatorTest.isTaxableItem(invoice1AdjustmentItemForInvoice1TaxableItem));
        Assert.assertFalse(pluginTaxCalculatorTest.isTaxableItem(invoice2AdjustmentItemForInvoice1TaxableItem));
    }

    @Test(groups = "fast")
    public void testIsTaxItem() throws Exception {
        Assert.assertFalse(pluginTaxCalculatorTest.isTaxItem(invoice1TaxableItem));
        Assert.assertTrue(pluginTaxCalculatorTest.isTaxItem(invoice1TaxItem));
        Assert.assertTrue(pluginTaxCalculatorTest.isTaxItem(invoice2TaxItem));
        Assert.assertFalse(pluginTaxCalculatorTest.isTaxItem(invoice1AdjustmentItemForInvoice1TaxableItem));
        Assert.assertFalse(pluginTaxCalculatorTest.isTaxItem(invoice2AdjustmentItemForInvoice1TaxableItem));
    }

    @Test(groups = "fast")
    public void testIsAdjustmentItem() throws Exception {
        Assert.assertFalse(pluginTaxCalculatorTest.isAdjustmentItem(invoice1TaxableItem));
        Assert.assertFalse(pluginTaxCalculatorTest.isAdjustmentItem(invoice1TaxItem));
        Assert.assertFalse(pluginTaxCalculatorTest.isAdjustmentItem(invoice2TaxItem));
        Assert.assertTrue(pluginTaxCalculatorTest.isAdjustmentItem(invoice1AdjustmentItemForInvoice1TaxableItem));
        Assert.assertTrue(pluginTaxCalculatorTest.isAdjustmentItem(invoice2AdjustmentItemForInvoice1TaxableItem));
    }
}
