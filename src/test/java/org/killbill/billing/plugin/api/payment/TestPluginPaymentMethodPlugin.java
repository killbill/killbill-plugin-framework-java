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

package org.killbill.billing.plugin.api.payment;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.killbill.billing.payment.api.PluginProperty;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@Test(groups = { "fast" })
public class TestPluginPaymentMethodPlugin {

    private final String externalPaymentMethodId = "TestExternalPaymentMethodId";
    private final boolean isDefaultPaymentMethod = true;
    private final UUID kbPaymentMethodId = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private final List<PluginProperty> properties = Collections.emptyList();

    @Test
    void builderIsEquivalentToConstructor() {

        PluginPaymentMethodPlugin a = new PluginPaymentMethodPlugin.Builder<>()
            .withKbPaymentMethodId(kbPaymentMethodId)
            .withExternalPaymentMethodId(externalPaymentMethodId)
            .withIsDefaultPaymentMethod(isDefaultPaymentMethod)
            .withProperties(properties)
            .build();

        PluginPaymentMethodPlugin b = new PluginPaymentMethodPlugin(
                kbPaymentMethodId,
                externalPaymentMethodId,
                isDefaultPaymentMethod,
                properties) ;


        Assert.assertTrue(a.equals(b));
    }

    @Test
    void differentInstances() {

        PluginPaymentMethodPlugin.Builder builder = new PluginPaymentMethodPlugin.Builder<>()
            .withKbPaymentMethodId(kbPaymentMethodId)
            .withExternalPaymentMethodId(externalPaymentMethodId)
            .withIsDefaultPaymentMethod(isDefaultPaymentMethod)
            .withProperties(properties);

        Assert.assertNotEquals(builder.build(), builder.withIsDefaultPaymentMethod(false).build());
    }

    @Test
    void callAllGetters() {

        PluginPaymentMethodPlugin a = new PluginPaymentMethodPlugin.Builder<>()
            .withKbPaymentMethodId(kbPaymentMethodId)
            .withExternalPaymentMethodId(externalPaymentMethodId)
            .withIsDefaultPaymentMethod(isDefaultPaymentMethod)
            .withProperties(properties)
            .build();

            Assert.assertEquals(a.getKbPaymentMethodId(), kbPaymentMethodId);
            Assert.assertEquals(a.getExternalPaymentMethodId(), externalPaymentMethodId);
            Assert.assertEquals(a.isDefaultPaymentMethod(), isDefaultPaymentMethod);
            Assert.assertEquals(a.getProperties(), properties);
    }

    @Test 
    void roundTripJson() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
        mapper.registerModule(new JodaModule());
        mapper.findAndRegisterModules();

        PluginPaymentMethodPlugin a = new PluginPaymentMethodPlugin.Builder<>()
            .withKbPaymentMethodId(kbPaymentMethodId)
            .withExternalPaymentMethodId(externalPaymentMethodId)
            .withIsDefaultPaymentMethod(isDefaultPaymentMethod)
            .withProperties(properties)
            .build();

        String json =  mapper.writeValueAsString(a);;
        PluginPaymentMethodPlugin b = mapper.readValue(json, PluginPaymentMethodPlugin.class);

        Assert.assertTrue(a.equals(b));
    }
}
