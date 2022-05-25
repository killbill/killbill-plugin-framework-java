/*
 * Copyright 2022-2022 The Billing Project, LLC
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

import org.testng.Assert;
import org.testng.annotations.Test;
import java.math.BigDecimal;
import java.util.UUID;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.invoice.api.InvoiceItemType;

@Test(groups = { "fast" })
public class TestPluginInvoiceItem {

    private final UUID accountId = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private final BigDecimal amount = new BigDecimal("100000");
    private final UUID bundleId = UUID.fromString("00000000-0000-0000-0000-000000000002");
    private final DateTime catalogEffectiveDate = new DateTime("2011-11-11T11:11");
    private final UUID childAccountId = UUID.fromString("00000000-0000-0000-0000-000000000003");
    private final DateTime createdDate = new DateTime("2011-11-11T11:11");
    private final Currency currency = Currency.USD;
    private final String description = "TestDescription";
    private final LocalDate endDate = new LocalDate("2022-11-11");
    private final UUID id = UUID.fromString("00000000-0000-0000-0000-000000000004");
    private final UUID invoiceId = UUID.fromString("00000000-0000-0000-0000-000000000005");
    private final InvoiceItemType invoiceItemType =  InvoiceItemType.FIXED;
    private final String itemDetails = "TestItemDetails";
    private final UUID linkedItemId = UUID.fromString("00000000-0000-0000-0000-000000000006");
    private final String phaseName = "TestPhaseName";
    private final String planName = "TestPlanName";
    private final String prettyPhaseName ="TestPrettyPhaseName";
    private final String prettyPlanName = "TestPrettyPlanName";
    private final String prettyProductName = "TestPrettyProductName";
    private final String prettyUsageName = "TestPrettyUsageName";
    private final String productName = "TestProductName";
    private final Integer quantity = 1;
    private final BigDecimal rate = new BigDecimal("4.2");
    private final LocalDate startDate = new LocalDate("2011-11-11");
    private final UUID subscriptionId = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private final DateTime updatedDate = new DateTime("2011-11-11T11:11");
    private final String usageName = "TestUsageName";

    @Test
    void builderIsEquivalentToConstructor() {

        PluginInvoiceItem a = new PluginInvoiceItem.Builder<>()
            .withId(id)
            .withInvoiceItemType(invoiceItemType)
            .withInvoiceId(invoiceId)
            .withAccountId(accountId)
            .withChildAccountId(childAccountId)
            .withStartDate(startDate)
            .withEndDate(endDate)
            .withAmount(amount)
            .withCurrency(currency)
            .withDescription(description)
            .withSubscriptionId(subscriptionId)
            .withBundleId(bundleId)
            .withCatalogEffectiveDate(catalogEffectiveDate)
            .withProductName(productName)
            .withPrettyProductName(prettyProductName)
            .withPlanName(planName)
            .withPrettyPlanName(prettyPlanName)
            .withPhaseName(phaseName)
            .withPrettyPhaseName(prettyPhaseName)
            .withRate(rate)
            .withLinkedItemId(linkedItemId)
            .withUsageName(usageName)
            .withPrettyUsageName(prettyUsageName)
            .withQuantity(quantity)
            .withItemDetails(itemDetails)
            .withCreatedDate(createdDate)
            .withUpdatedDate(updatedDate)
            .build();

        PluginInvoiceItem b = new PluginInvoiceItem(
                id,
                invoiceItemType,
                invoiceId,
                accountId,
                childAccountId,
                startDate,
                endDate,
                amount,
                currency,
                description,
                subscriptionId,
                bundleId,
                catalogEffectiveDate,
                productName,
                prettyProductName,
                planName,
                prettyPlanName,
                phaseName,
                prettyPhaseName,
                rate,
                linkedItemId,
                usageName,
                prettyUsageName,
                quantity,
                itemDetails,
                createdDate,
                updatedDate);

        Assert.assertTrue(a.equals(b));
    }

    @Test
    void differentInstances() {

        PluginInvoiceItem.Builder builder = new PluginInvoiceItem.Builder<>()
            .withId(id)
            .withInvoiceItemType(invoiceItemType)
            .withInvoiceId(invoiceId)
            .withAccountId(accountId)
            .withChildAccountId(childAccountId)
            .withStartDate(startDate)
            .withEndDate(endDate)
            .withAmount(amount)
            .withCurrency(currency)
            .withDescription(description)
            .withSubscriptionId(subscriptionId)
            .withBundleId(bundleId)
            .withCatalogEffectiveDate(catalogEffectiveDate)
            .withProductName(productName)
            .withPrettyProductName(prettyProductName)
            .withPlanName(planName)
            .withPrettyPlanName(prettyPlanName)
            .withPhaseName(phaseName)
            .withPrettyPhaseName(prettyPhaseName)
            .withRate(rate)
            .withLinkedItemId(linkedItemId)
            .withUsageName(usageName)
            .withPrettyUsageName(prettyUsageName)
            .withQuantity(quantity)
            .withItemDetails(itemDetails)
            .withCreatedDate(createdDate)
            .withUpdatedDate(updatedDate);

        Assert.assertNotEquals(builder.build(), builder.withCurrency(Currency.JPY).build());
    }

    @Test
    void callAllGetters() {

        PluginInvoiceItem a = new PluginInvoiceItem.Builder<>()
            .withId(id)
            .withInvoiceItemType(invoiceItemType)
            .withInvoiceId(invoiceId)
            .withAccountId(accountId)
            .withChildAccountId(childAccountId)
            .withStartDate(startDate)
            .withEndDate(endDate)
            .withAmount(amount)
            .withCurrency(currency)
            .withDescription(description)
            .withSubscriptionId(subscriptionId)
            .withBundleId(bundleId)
            .withCatalogEffectiveDate(catalogEffectiveDate)
            .withProductName(productName)
            .withPrettyProductName(prettyProductName)
            .withPlanName(planName)
            .withPrettyPlanName(prettyPlanName)
            .withPhaseName(phaseName)
            .withPrettyPhaseName(prettyPhaseName)
            .withRate(rate)
            .withLinkedItemId(linkedItemId)
            .withUsageName(usageName)
            .withPrettyUsageName(prettyUsageName)
            .withQuantity(quantity)
            .withItemDetails(itemDetails)
            .withCreatedDate(createdDate)
            .withUpdatedDate(updatedDate)
            .build();

        Assert.assertEquals(a.getId(), id);
        Assert.assertEquals(a.getInvoiceItemType(), invoiceItemType);
        Assert.assertEquals(a.getInvoiceId(), invoiceId);
        Assert.assertEquals(a.getAccountId(), accountId);
        Assert.assertEquals(a.getChildAccountId(), childAccountId);
        Assert.assertEquals(a.getStartDate(), startDate);
        Assert.assertEquals(a.getEndDate(), endDate);
        Assert.assertEquals(a.getAmount(), amount);
        Assert.assertEquals(a.getCurrency(), currency);
        Assert.assertEquals(a.getDescription(), description);
        Assert.assertEquals(a.getSubscriptionId(), subscriptionId);
        Assert.assertEquals(a.getBundleId(), bundleId);
        Assert.assertEquals(a.getCatalogEffectiveDate(), catalogEffectiveDate);
        Assert.assertEquals(a.getProductName(), productName);
        Assert.assertEquals(a.getPrettyProductName(), prettyProductName);
        Assert.assertEquals(a.getPlanName(), planName);
        Assert.assertEquals(a.getPrettyPlanName(), prettyPlanName);
        Assert.assertEquals(a.getPhaseName(), phaseName);
        Assert.assertEquals(a.getPrettyPhaseName(), prettyPhaseName);
        Assert.assertEquals(a.getRate(), rate);
        Assert.assertEquals(a.getLinkedItemId(), linkedItemId);
        Assert.assertEquals(a.getUsageName(), usageName);
        Assert.assertEquals(a.getPrettyUsageName(), prettyUsageName);
        Assert.assertEquals(a.getQuantity(), quantity);
        Assert.assertEquals(a.getItemDetails(), itemDetails);
        Assert.assertEquals(a.getCreatedDate(), createdDate);
        Assert.assertEquals(a.getUpdatedDate(), updatedDate);
    }

    @Test 
    void roundTripJson() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
        mapper.registerModule(new JodaModule());
        mapper.findAndRegisterModules();

        PluginInvoiceItem a = new PluginInvoiceItem.Builder<>()
            .withId(id)
            .withInvoiceItemType(invoiceItemType)
            .withInvoiceId(invoiceId)
            .withAccountId(accountId)
            .withChildAccountId(childAccountId)
            .withStartDate(startDate)
            .withEndDate(endDate)
            .withAmount(amount)
            .withCurrency(currency)
            .withDescription(description)
            .withSubscriptionId(subscriptionId)
            .withBundleId(bundleId)
            .withCatalogEffectiveDate(catalogEffectiveDate)
            .withProductName(productName)
            .withPrettyProductName(prettyProductName)
            .withPlanName(planName)
            .withPrettyPlanName(prettyPlanName)
            .withPhaseName(phaseName)
            .withPrettyPhaseName(prettyPhaseName)
            .withRate(rate)
            .withLinkedItemId(linkedItemId)
            .withUsageName(usageName)
            .withPrettyUsageName(prettyUsageName)
            .withQuantity(quantity)
            .withItemDetails(itemDetails)
            .withCreatedDate(createdDate)
            .withUpdatedDate(updatedDate)
            .build();

        String json =  mapper.writeValueAsString(a);;
        PluginInvoiceItem b = mapper.readValue(json, PluginInvoiceItem.class);

        Assert.assertTrue(a.equals(b));
    }
}
