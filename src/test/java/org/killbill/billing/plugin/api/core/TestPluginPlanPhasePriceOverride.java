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
package org.killbill.billing.plugin.api.core;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.catalog.api.PlanPhaseSpecifier;
import org.killbill.billing.catalog.api.UsagePriceOverride;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@Test(groups = { "fast" })
public class TestPluginPlanPhasePriceOverride {

    protected Currency currency = Currency.USD;
    protected BigDecimal fixedPrice = new BigDecimal("100000");
    protected String phaseName = "TestPhaseName";
    protected PlanPhaseSpecifier planPhaseSpecifier = null;
    protected BigDecimal recurringPrice = new BigDecimal("200000");
    protected List<UsagePriceOverride> usagePriceOverrides = Collections.emptyList();

    @Test
    void builderIsEquivalentToConstructor() {

        PluginPlanPhasePriceOverride a = new PluginPlanPhasePriceOverride.Builder<>()
            .withPhaseName(phaseName)
            .withPlanPhaseSpecifier(planPhaseSpecifier)
            .withCurrency(currency)
            .withFixedPrice(fixedPrice)
            .withRecurringPrice(recurringPrice)
            .withUsagePriceOverrides(usagePriceOverrides)
            .build();

        PluginPlanPhasePriceOverride b = new PluginPlanPhasePriceOverride(
                phaseName,
                planPhaseSpecifier,
                currency,
                fixedPrice,
                recurringPrice,
                usagePriceOverrides);

        Assert.assertTrue(a.equals(b));
    }

    @Test
    void differentInstances() {

        PluginPlanPhasePriceOverride.Builder builder = new PluginPlanPhasePriceOverride.Builder<>()
            .withPhaseName(phaseName)
            .withPlanPhaseSpecifier(planPhaseSpecifier)
            .withCurrency(currency)
            .withFixedPrice(fixedPrice)
            .withRecurringPrice(recurringPrice)
            .withUsagePriceOverrides(usagePriceOverrides);

        Assert.assertNotEquals(builder.build(), builder.withCurrency(Currency.JPY).build());
    }

    @Test
    void callAllGetters() {

        PluginPlanPhasePriceOverride a = new PluginPlanPhasePriceOverride.Builder<>()
            .withPhaseName(phaseName)
            .withPlanPhaseSpecifier(planPhaseSpecifier)
            .withCurrency(currency)
            .withFixedPrice(fixedPrice)
            .withRecurringPrice(recurringPrice)
            .withUsagePriceOverrides(usagePriceOverrides)
            .build();

        Assert.assertEquals(a.getPhaseName(), phaseName);
        Assert.assertEquals(a.getPlanPhaseSpecifier(), planPhaseSpecifier);
        Assert.assertEquals(a.getCurrency(), currency);
        Assert.assertEquals(a.getFixedPrice(), fixedPrice);
        Assert.assertEquals(a.getRecurringPrice(), recurringPrice);
        Assert.assertEquals(a.getUsagePriceOverrides(), usagePriceOverrides);
    }

    @Test 
    void roundTripJson() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
        mapper.registerModule(new JodaModule());
        mapper.findAndRegisterModules();

        PluginPlanPhasePriceOverride a = new PluginPlanPhasePriceOverride.Builder<>()
            .withPhaseName(phaseName)
            .withPlanPhaseSpecifier(planPhaseSpecifier)
            .withCurrency(currency)
            .withFixedPrice(fixedPrice)
            .withRecurringPrice(recurringPrice)
            .withUsagePriceOverrides(usagePriceOverrides)
            .build();

        String json =  mapper.writeValueAsString(a);;
        PluginPlanPhasePriceOverride b = mapper.readValue(json, PluginPlanPhasePriceOverride.class);

        Assert.assertTrue(a.equals(b));
    }
}
