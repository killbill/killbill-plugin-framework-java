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

import java.util.Collections;
import java.util.List;

import org.killbill.billing.catalog.api.PlanPhasePriceOverride;
import org.killbill.billing.catalog.api.PlanPhaseSpecifier;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@Test(groups = { "fast" })
public class TestPluginEntitlementSpecifier {

    final private Integer billCycleDay = 1;
    final private String externalKey = "TestExternalKey";
    final private List<PlanPhasePriceOverride> overrides = Collections.emptyList();
    final private PlanPhaseSpecifier planPhaseSpecifier = null;

    @Test
    void builderIsEquivalentToConstructor() {

        PluginEntitlementSpecifier a = new PluginEntitlementSpecifier.Builder<>()
            .withPlanPhaseSpecifier(planPhaseSpecifier)
            .withBillCycleDay(billCycleDay)
            .withExternalKey(externalKey)
            .withOverrides(overrides)
            .build();

        PluginEntitlementSpecifier b = new PluginEntitlementSpecifier(
                planPhaseSpecifier,
                billCycleDay,
                externalKey,
                overrides) ;

        Assert.assertTrue(a.equals(b));
    }

    @Test
    void differentInstances() {

        PluginEntitlementSpecifier.Builder builder = new PluginEntitlementSpecifier.Builder<>()
            .withPlanPhaseSpecifier(planPhaseSpecifier)
            .withBillCycleDay(billCycleDay)
            .withExternalKey(externalKey)
            .withOverrides(overrides);

        Assert.assertNotEquals(builder.build(), builder.withBillCycleDay(15).build());
    }

    @Test
    void callAllGetters() {

        PluginEntitlementSpecifier a = new PluginEntitlementSpecifier.Builder<>()
            .withPlanPhaseSpecifier(planPhaseSpecifier)
            .withBillCycleDay(billCycleDay)
            .withExternalKey(externalKey)
            .withOverrides(overrides)
            .build();

            Assert.assertEquals(a.getPlanPhaseSpecifier(), planPhaseSpecifier);
            Assert.assertEquals(a.getBillCycleDay(), billCycleDay);
            Assert.assertEquals(a.getExternalKey(), externalKey);
            Assert.assertEquals(a.getOverrides(), overrides);
    }

    @Test 
    void roundTripJson() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
        mapper.registerModule(new JodaModule());
        mapper.findAndRegisterModules();

        PluginEntitlementSpecifier a = new PluginEntitlementSpecifier.Builder<>()
            .withPlanPhaseSpecifier(planPhaseSpecifier)
            .withBillCycleDay(billCycleDay)
            .withExternalKey(externalKey)
            .withOverrides(overrides)
            .build();

        String json =  mapper.writeValueAsString(a);;
        PluginEntitlementSpecifier b = mapper.readValue(json, PluginEntitlementSpecifier.class);

        Assert.assertTrue(a.equals(b));
    }
}
