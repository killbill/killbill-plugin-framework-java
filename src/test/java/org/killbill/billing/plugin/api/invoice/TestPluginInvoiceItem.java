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

import org.killbill.billing.account.api.Account;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.invoice.api.InvoiceItem;
import org.killbill.billing.invoice.api.InvoiceItemType;
import org.killbill.billing.plugin.TestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPluginInvoiceItem {

    private Account account;
    private Invoice invoice1;
    private InvoiceItem invoice1TaxableItem;
    private InvoiceItem invoice1TaxItem;

    @BeforeMethod(groups = "fast")
    public void setUp() throws Exception {
        account = TestUtils.buildAccount(Currency.BTC, "US");

        invoice1 = TestUtils.buildInvoice(account);
        invoice1TaxableItem = TestUtils.buildInvoiceItem(invoice1, InvoiceItemType.EXTERNAL_CHARGE, BigDecimal.TEN, null);
        invoice1TaxItem = PluginInvoiceItem.createTaxItem(invoice1TaxableItem, invoice1.getId(), BigDecimal.ONE, "TestNG tax");
        invoice1.getInvoiceItems().add(invoice1TaxableItem);
        invoice1.getInvoiceItems().add(invoice1TaxItem);
    }

    @Test(groups = "fast")
    public void testBuildTaxItem() throws Exception {
        // Overrides
        Assert.assertEquals(invoice1TaxItem.getInvoiceItemType(), InvoiceItemType.TAX);
        Assert.assertEquals(invoice1TaxItem.getStartDate(), invoice1TaxableItem.getStartDate());
        Assert.assertNull(invoice1TaxItem.getEndDate());
        Assert.assertEquals(invoice1TaxItem.getAmount().compareTo(BigDecimal.ONE), 0);
        Assert.assertEquals(invoice1TaxItem.getDescription(), "TestNG tax");
        Assert.assertEquals(invoice1TaxItem.getLinkedItemId(), invoice1TaxableItem.getId());
        Assert.assertNull(invoice1TaxItem.getRate());

        // Copies
        Assert.assertEquals(invoice1TaxItem.getInvoiceId(), invoice1TaxableItem.getInvoiceId());
        Assert.assertEquals(invoice1TaxItem.getAccountId(), invoice1TaxableItem.getAccountId());
        Assert.assertEquals(invoice1TaxItem.getCurrency(), invoice1TaxableItem.getCurrency());
        Assert.assertEquals(invoice1TaxItem.getBundleId(), invoice1TaxableItem.getBundleId());
        Assert.assertEquals(invoice1TaxItem.getSubscriptionId(), invoice1TaxableItem.getSubscriptionId());
        Assert.assertEquals(invoice1TaxItem.getPlanName(), invoice1TaxableItem.getPlanName());
        Assert.assertEquals(invoice1TaxItem.getPhaseName(), invoice1TaxableItem.getPhaseName());
        Assert.assertEquals(invoice1TaxItem.getUsageName(), invoice1TaxableItem.getUsageName());
    }
}
