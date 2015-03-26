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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.killbill.billing.account.api.Account;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.invoice.api.InvoiceItem;
import org.killbill.billing.invoice.api.InvoiceItemType;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.plugin.TestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

public class TestPluginTaxCalculator {

    private static final class PluginTaxCalculatorTest extends PluginTaxCalculator {

        @Override
        public List<InvoiceItem> compute(final Account account,
                                         final Invoice newInvoice,
                                         final Invoice invoice,
                                         final Map<UUID, InvoiceItem> taxableItems,
                                         final Map<UUID, Collection<InvoiceItem>> adjustmentItems,
                                         final Iterable<PluginProperty> pluginProperties,
                                         final UUID kbTenantId) {
            return null;
        }
    }

    private PluginTaxCalculatorTest pluginTaxCalculatorTest;

    private InvoiceItem invoice1TaxableItem;
    private InvoiceItem invoice1TaxItem;
    private InvoiceItem invoice1AdjustmentItemForInvoice1TaxableItem;
    private InvoiceItem invoice2AdjustmentItemForInvoice1TaxableItem;

    @BeforeMethod(groups = "fast")
    public void setUp() throws Exception {
        pluginTaxCalculatorTest = new PluginTaxCalculatorTest();

        final Account account = TestUtils.buildAccount(Currency.BTC, "US");

        final Invoice invoice1 = TestUtils.buildInvoice(account);
        invoice1TaxableItem = TestUtils.buildInvoiceItem(invoice1, InvoiceItemType.EXTERNAL_CHARGE, BigDecimal.TEN, null);
        invoice1TaxItem = PluginInvoiceItem.createTaxItem(invoice1TaxableItem, invoice1.getId(), invoice1TaxableItem.getStartDate(), null, BigDecimal.ONE, "TestNG tax");
        invoice1AdjustmentItemForInvoice1TaxableItem = PluginInvoiceItem.createAdjustmentItem(invoice1TaxableItem, invoice1.getId(), invoice1TaxableItem.getStartDate(), null, BigDecimal.ONE.negate(), "Mis-billing 1");
        invoice1.getInvoiceItems().add(invoice1TaxableItem);
        invoice1.getInvoiceItems().add(invoice1TaxItem);
        invoice1.getInvoiceItems().add(invoice1AdjustmentItemForInvoice1TaxableItem);

        final Invoice invoice2 = TestUtils.buildInvoice(account);
        invoice2AdjustmentItemForInvoice1TaxableItem = PluginInvoiceItem.createAdjustmentItem(invoice1TaxableItem, invoice2.getId(), invoice1TaxableItem.getStartDate(), null, BigDecimal.ONE.negate(), "Mis-billing 2");
        invoice2.getInvoiceItems().add(invoice2AdjustmentItemForInvoice1TaxableItem);
    }

    @Test(groups = "fast")
    public void testComputeNewItemsToTaxAndExistingItemsToAdjustWithNewTaxableItemNoAdjustment() throws Exception {
        final Map<UUID, InvoiceItem> taxableItems = ImmutableMap.<UUID, InvoiceItem>of(invoice1TaxItem.getId(), invoice1TaxItem);
        final Map<UUID, Collection<InvoiceItem>> adjustmentItems = ImmutableMap.<UUID, Collection<InvoiceItem>>of(invoice1TaxItem.getId(), ImmutableList.<InvoiceItem>of());
        final Map<UUID, Set<UUID>> alreadyTaxedItemsWithAdjustments = ImmutableMap.<UUID, Set<UUID>>of();

        final Map<UUID, InvoiceItem> newItemsToTax = new HashMap<UUID, InvoiceItem>();
        final Map<UUID, InvoiceItem> existingItemsToAdjust = new HashMap<UUID, InvoiceItem>();
        final Map<UUID, Collection<InvoiceItem>> adjustmentItemsForExistingItems = new HashMap<UUID, Collection<InvoiceItem>>();
        pluginTaxCalculatorTest.computeNewItemsToTaxAndExistingItemsToAdjust(taxableItems, adjustmentItems, alreadyTaxedItemsWithAdjustments, newItemsToTax, existingItemsToAdjust, adjustmentItemsForExistingItems);

        Assert.assertEquals(newItemsToTax.size(), 1);
        Assert.assertEquals(newItemsToTax.get(invoice1TaxItem.getId()), invoice1TaxItem);
        Assert.assertEquals(existingItemsToAdjust.size(), 0);
        Assert.assertEquals(adjustmentItemsForExistingItems.size(), 0);
    }

    @Test(groups = "fast")
    public void testComputeNewItemsToTaxAndExistingItemsToAdjustWithNewTaxableItemAndAdjustment() throws Exception {
        final Map<UUID, InvoiceItem> taxableItems = ImmutableMap.<UUID, InvoiceItem>of(invoice1TaxItem.getId(), invoice1TaxItem);
        final Map<UUID, Collection<InvoiceItem>> adjustmentItems = ImmutableMap.<UUID, Collection<InvoiceItem>>of(invoice1TaxItem.getId(), ImmutableList.<InvoiceItem>of(invoice1AdjustmentItemForInvoice1TaxableItem));
        final Map<UUID, Set<UUID>> alreadyTaxedItemsWithAdjustments = ImmutableMap.<UUID, Set<UUID>>of();

        final Map<UUID, InvoiceItem> newItemsToTax = new HashMap<UUID, InvoiceItem>();
        final Map<UUID, InvoiceItem> existingItemsToAdjust = new HashMap<UUID, InvoiceItem>();
        final Map<UUID, Collection<InvoiceItem>> adjustmentItemsForExistingItems = new HashMap<UUID, Collection<InvoiceItem>>();
        pluginTaxCalculatorTest.computeNewItemsToTaxAndExistingItemsToAdjust(taxableItems, adjustmentItems, alreadyTaxedItemsWithAdjustments, newItemsToTax, existingItemsToAdjust, adjustmentItemsForExistingItems);

        Assert.assertEquals(newItemsToTax.size(), 1);
        Assert.assertEquals(newItemsToTax.get(invoice1TaxItem.getId()), invoice1TaxItem);
        Assert.assertEquals(existingItemsToAdjust.size(), 1);
        Assert.assertEquals(existingItemsToAdjust.get(invoice1TaxItem.getId()), invoice1TaxItem);
        Assert.assertEquals(adjustmentItemsForExistingItems.size(), 1);
        Assert.assertEquals(adjustmentItemsForExistingItems.get(invoice1TaxItem.getId()).size(), 1);
        Assert.assertEquals(adjustmentItemsForExistingItems.get(invoice1TaxItem.getId()).iterator().next(), invoice1AdjustmentItemForInvoice1TaxableItem);
    }

    @Test(groups = "fast")
    public void testComputeNewItemsToTaxAndExistingItemsToAdjustWithNewTaxableItemAndAdjustments() throws Exception {
        final Map<UUID, InvoiceItem> taxableItems = ImmutableMap.<UUID, InvoiceItem>of(invoice1TaxItem.getId(), invoice1TaxItem);
        final Map<UUID, Collection<InvoiceItem>> adjustmentItems = ImmutableMap.<UUID, Collection<InvoiceItem>>of(invoice1TaxItem.getId(), ImmutableList.<InvoiceItem>of(invoice1AdjustmentItemForInvoice1TaxableItem, invoice2AdjustmentItemForInvoice1TaxableItem));
        final Map<UUID, Set<UUID>> alreadyTaxedItemsWithAdjustments = ImmutableMap.<UUID, Set<UUID>>of();

        final Map<UUID, InvoiceItem> newItemsToTax = new HashMap<UUID, InvoiceItem>();
        final Map<UUID, InvoiceItem> existingItemsToAdjust = new HashMap<UUID, InvoiceItem>();
        final Map<UUID, Collection<InvoiceItem>> adjustmentItemsForExistingItems = new HashMap<UUID, Collection<InvoiceItem>>();
        pluginTaxCalculatorTest.computeNewItemsToTaxAndExistingItemsToAdjust(taxableItems, adjustmentItems, alreadyTaxedItemsWithAdjustments, newItemsToTax, existingItemsToAdjust, adjustmentItemsForExistingItems);

        Assert.assertEquals(newItemsToTax.size(), 1);
        Assert.assertEquals(newItemsToTax.get(invoice1TaxItem.getId()), invoice1TaxItem);
        Assert.assertEquals(existingItemsToAdjust.size(), 1);
        Assert.assertEquals(existingItemsToAdjust.get(invoice1TaxItem.getId()), invoice1TaxItem);
        Assert.assertEquals(adjustmentItemsForExistingItems.size(), 1);
        Assert.assertEquals(adjustmentItemsForExistingItems.get(invoice1TaxItem.getId()).size(), 2);
    }

    @Test(groups = "fast")
    public void testComputeNewItemsToTaxAndExistingItemsToAdjustWithNoChange() throws Exception {
        final Map<UUID, InvoiceItem> taxableItems = ImmutableMap.<UUID, InvoiceItem>of(invoice1TaxItem.getId(), invoice1TaxItem);
        final Map<UUID, Collection<InvoiceItem>> adjustmentItems = ImmutableMap.<UUID, Collection<InvoiceItem>>of(invoice1TaxItem.getId(), ImmutableList.<InvoiceItem>of(invoice1AdjustmentItemForInvoice1TaxableItem, invoice2AdjustmentItemForInvoice1TaxableItem));
        final Map<UUID, Set<UUID>> alreadyTaxedItemsWithAdjustments = ImmutableMap.<UUID, Set<UUID>>of(invoice1TaxItem.getId(), ImmutableSet.<UUID>of(invoice1AdjustmentItemForInvoice1TaxableItem.getId(), invoice2AdjustmentItemForInvoice1TaxableItem.getId()));

        final Map<UUID, InvoiceItem> newItemsToTax = new HashMap<UUID, InvoiceItem>();
        final Map<UUID, InvoiceItem> existingItemsToAdjust = new HashMap<UUID, InvoiceItem>();
        final Map<UUID, Collection<InvoiceItem>> adjustmentItemsForExistingItems = new HashMap<UUID, Collection<InvoiceItem>>();
        pluginTaxCalculatorTest.computeNewItemsToTaxAndExistingItemsToAdjust(taxableItems, adjustmentItems, alreadyTaxedItemsWithAdjustments, newItemsToTax, existingItemsToAdjust, adjustmentItemsForExistingItems);

        Assert.assertEquals(newItemsToTax.size(), 0);
        Assert.assertEquals(existingItemsToAdjust.size(), 0);
        Assert.assertEquals(adjustmentItemsForExistingItems.size(), 0);
    }

    @Test(groups = "fast")
    public void testComputeNewItemsToTaxAndExistingItemsToAdjustWithNewAdjustment() throws Exception {
        final Map<UUID, InvoiceItem> taxableItems = ImmutableMap.<UUID, InvoiceItem>of(invoice1TaxItem.getId(), invoice1TaxItem);
        final Map<UUID, Collection<InvoiceItem>> adjustmentItems = ImmutableMap.<UUID, Collection<InvoiceItem>>of(invoice1TaxItem.getId(), ImmutableList.<InvoiceItem>of(invoice1AdjustmentItemForInvoice1TaxableItem, invoice2AdjustmentItemForInvoice1TaxableItem));
        final Map<UUID, Set<UUID>> alreadyTaxedItemsWithAdjustments = ImmutableMap.<UUID, Set<UUID>>of(invoice1TaxItem.getId(), ImmutableSet.<UUID>of(invoice1AdjustmentItemForInvoice1TaxableItem.getId()));

        final Map<UUID, InvoiceItem> newItemsToTax = new HashMap<UUID, InvoiceItem>();
        final Map<UUID, InvoiceItem> existingItemsToAdjust = new HashMap<UUID, InvoiceItem>();
        final Map<UUID, Collection<InvoiceItem>> adjustmentItemsForExistingItems = new HashMap<UUID, Collection<InvoiceItem>>();
        pluginTaxCalculatorTest.computeNewItemsToTaxAndExistingItemsToAdjust(taxableItems, adjustmentItems, alreadyTaxedItemsWithAdjustments, newItemsToTax, existingItemsToAdjust, adjustmentItemsForExistingItems);

        Assert.assertEquals(newItemsToTax.size(), 0);
        Assert.assertEquals(existingItemsToAdjust.size(), 1);
        Assert.assertEquals(existingItemsToAdjust.get(invoice1TaxItem.getId()), invoice1TaxItem);
        Assert.assertEquals(adjustmentItemsForExistingItems.size(), 1);
        Assert.assertEquals(adjustmentItemsForExistingItems.get(invoice1TaxItem.getId()).size(), 1);
        Assert.assertEquals(adjustmentItemsForExistingItems.get(invoice1TaxItem.getId()).iterator().next(), invoice2AdjustmentItemForInvoice1TaxableItem);
    }

    @Test(groups = "fast")
    public void testComputeNewItemsToTaxAndExistingItemsToAdjustWithNewAdjustments() throws Exception {
        final Map<UUID, InvoiceItem> taxableItems = ImmutableMap.<UUID, InvoiceItem>of(invoice1TaxItem.getId(), invoice1TaxItem);
        final Map<UUID, Collection<InvoiceItem>> adjustmentItems = ImmutableMap.<UUID, Collection<InvoiceItem>>of(invoice1TaxItem.getId(), ImmutableList.<InvoiceItem>of(invoice1AdjustmentItemForInvoice1TaxableItem, invoice2AdjustmentItemForInvoice1TaxableItem));
        final Map<UUID, Set<UUID>> alreadyTaxedItemsWithAdjustments = ImmutableMap.<UUID, Set<UUID>>of(invoice1TaxItem.getId(), ImmutableSet.<UUID>of());

        final Map<UUID, InvoiceItem> newItemsToTax = new HashMap<UUID, InvoiceItem>();
        final Map<UUID, InvoiceItem> existingItemsToAdjust = new HashMap<UUID, InvoiceItem>();
        final Map<UUID, Collection<InvoiceItem>> adjustmentItemsForExistingItems = new HashMap<UUID, Collection<InvoiceItem>>();
        pluginTaxCalculatorTest.computeNewItemsToTaxAndExistingItemsToAdjust(taxableItems, adjustmentItems, alreadyTaxedItemsWithAdjustments, newItemsToTax, existingItemsToAdjust, adjustmentItemsForExistingItems);

        Assert.assertEquals(newItemsToTax.size(), 0);
        Assert.assertEquals(existingItemsToAdjust.size(), 1);
        Assert.assertEquals(existingItemsToAdjust.get(invoice1TaxItem.getId()), invoice1TaxItem);
        Assert.assertEquals(adjustmentItemsForExistingItems.size(), 1);
        Assert.assertEquals(adjustmentItemsForExistingItems.get(invoice1TaxItem.getId()).size(), 2);
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
}
