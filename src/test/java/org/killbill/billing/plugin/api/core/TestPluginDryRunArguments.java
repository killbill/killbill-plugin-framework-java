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

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.UUID;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.joda.time.LocalDate;
import org.killbill.billing.catalog.api.BillingActionPolicy;
import org.killbill.billing.entitlement.api.EntitlementSpecifier;
import org.killbill.billing.entitlement.api.SubscriptionEventType;
import org.killbill.billing.invoice.api.DryRunType;

@Test(groups = { "fast" })
public class TestPluginDryRunArguments {

    final private SubscriptionEventType action = SubscriptionEventType.START_BILLING;
    final private BillingActionPolicy billingActionPolicy =  BillingActionPolicy.IMMEDIATE;
    final private UUID bundleId = UUID.fromString("00000000-0000-0000-0000-000000000001");
    final private DryRunType dryRunType = DryRunType.UPCOMING_INVOICE;
    final private LocalDate effectiveDate = new LocalDate("2011-11-11");
    final private EntitlementSpecifier entitlementSpecifier = null;
    final private UUID subscriptionId = UUID.fromString("00000000-0000-0000-0000-000000000002");

    @Test
    void builderIsEquivalentToConstructor() {

        PluginDryRunArguments a = new PluginDryRunArguments.Builder<>()
            .withDryRunType(dryRunType)
            .withEntitlementSpecifier(entitlementSpecifier)
            .withAction(action)
            .withSubscriptionId(subscriptionId)
            .withEffectiveDate(effectiveDate)
            .withBundleId(bundleId)
            .withBillingActionPolicy(billingActionPolicy)
            .build();

        PluginDryRunArguments b = new PluginDryRunArguments(
                dryRunType,
                entitlementSpecifier,
                action,
                subscriptionId,
                effectiveDate,
                bundleId,
                billingActionPolicy);

        Assert.assertTrue(a.equals(b));
    }

    @Test
    void differentInstances() {

        PluginDryRunArguments.Builder builder = new PluginDryRunArguments.Builder<>()
            .withDryRunType(dryRunType)
            .withEntitlementSpecifier(entitlementSpecifier)
            .withAction(action)
            .withSubscriptionId(subscriptionId)
            .withEffectiveDate(effectiveDate)
            .withBundleId(bundleId)
            .withBillingActionPolicy(billingActionPolicy);


        Assert.assertNotEquals(builder.build(), builder.withDryRunType(DryRunType.TARGET_DATE).build());
    }

    @Test
    void callAllGetters() {

        PluginDryRunArguments a = new PluginDryRunArguments.Builder<>()
            .withDryRunType(dryRunType)
            .withEntitlementSpecifier(entitlementSpecifier)
            .withAction(action)
            .withSubscriptionId(subscriptionId)
            .withEffectiveDate(effectiveDate)
            .withBundleId(bundleId)
            .withBillingActionPolicy(billingActionPolicy)
            .build();

        Assert.assertEquals(a.getDryRunType(), dryRunType);
        Assert.assertEquals(a.getEntitlementSpecifier(), entitlementSpecifier);
        Assert.assertEquals(a.getAction(), action);
        Assert.assertEquals(a.getSubscriptionId(), subscriptionId);
        Assert.assertEquals(a.getEffectiveDate(), effectiveDate);
        Assert.assertEquals(a.getBundleId(), bundleId);
        Assert.assertEquals(a.getBillingActionPolicy(), billingActionPolicy);
    }

    @Test 
    void roundTripJson() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
        mapper.registerModule(new JodaModule());
        mapper.findAndRegisterModules();

        PluginDryRunArguments a = new PluginDryRunArguments.Builder<>()
            .withDryRunType(dryRunType)
            .withEntitlementSpecifier(entitlementSpecifier)
            .withAction(action)
            .withSubscriptionId(subscriptionId)
            .withEffectiveDate(effectiveDate)
            .withBundleId(bundleId)
            .withBillingActionPolicy(billingActionPolicy)
            .build();

        String json =  mapper.writeValueAsString(a);;
        PluginDryRunArguments b = mapper.readValue(json, PluginDryRunArguments.class);

        Assert.assertTrue(a.equals(b));
    }
}
