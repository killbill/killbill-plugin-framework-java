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

import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.google.common.collect.ImmutableList;

@Test(groups = { "fast" })
public class TestPluginPaymentOptions {

    final private boolean isExternalPayment = true;
    final private List<String> paymentControlPluginNames = ImmutableList.<String>of();

    @Test
    void builderIsEquivalentToConstructor() {

        PluginPaymentOptions a = new PluginPaymentOptions.Builder<>()
            .withIsExternalPayment(isExternalPayment)
            .withPaymentControlPluginNames(paymentControlPluginNames)
            .build();

        PluginPaymentOptions b = new PluginPaymentOptions(isExternalPayment, paymentControlPluginNames);

        Assert.assertTrue(a.equals(b));
    }

    @Test
    void differentInstances() {

        PluginPaymentOptions.Builder builder = new PluginPaymentOptions.Builder<>()
            .withIsExternalPayment(isExternalPayment)
            .withPaymentControlPluginNames(paymentControlPluginNames);

        Assert.assertNotEquals(builder.build(), builder.withIsExternalPayment(false).build());
    }

    @Test
    void callAllGetters() {

        PluginPaymentOptions a = new PluginPaymentOptions.Builder<>()
            .withIsExternalPayment(isExternalPayment)
            .withPaymentControlPluginNames(paymentControlPluginNames)
            .build();

        Assert.assertEquals(a.isExternalPayment(), isExternalPayment);
        Assert.assertEquals(a.getPaymentControlPluginNames(), paymentControlPluginNames);
    }

    @Test 
    void roundTripJson() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
        mapper.registerModule(new JodaModule());
        mapper.findAndRegisterModules();

        PluginPaymentOptions a = new PluginPaymentOptions.Builder<>()
            .withIsExternalPayment(isExternalPayment)
            .withPaymentControlPluginNames(paymentControlPluginNames)
            .build();

        String json =  mapper.writeValueAsString(a);;
        PluginPaymentOptions b = mapper.readValue(json, PluginPaymentOptions.class);

        Assert.assertTrue(a.equals(b));
    }
}
