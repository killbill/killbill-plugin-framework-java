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
import java.util.Map;
import java.util.UUID;

import org.killbill.billing.payment.api.PluginProperty;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@Test(groups = { "fast" })
public class TestPluginGatewayNotification {

    private final String entity = "TestEntity";
    private final Map<String, List<String>> headers =  Collections.emptyMap();
    private final UUID kbPaymentId = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private final List<PluginProperty> properties = Collections.emptyList();
    private final int status = 400;

    @Test
    void builderIsEquivalentToConstructor() {

        PluginGatewayNotification a = new PluginGatewayNotification.Builder<>()
            .withKbPaymentId(kbPaymentId)
            .withStatus(status)
            .withEntity(entity)
            .withHeaders(headers)
            .withProperties(properties)
            .build();

        PluginGatewayNotification b = new PluginGatewayNotification(
                kbPaymentId,
                status,
                entity,
                headers,
                properties);

        Assert.assertTrue(a.equals(b));
    }

    @Test
    void differentInstances() {
        PluginGatewayNotification.Builder builder = new PluginGatewayNotification.Builder<>()
            .withKbPaymentId(kbPaymentId)
            .withStatus(status)
            .withEntity(entity)
            .withHeaders(headers)
            .withProperties(properties);
        Assert.assertNotEquals(builder.build(), builder.withStatus(404).build());
    }

    @Test
    void callAllGetters() {
        PluginGatewayNotification a = new PluginGatewayNotification.Builder<>()
            .withKbPaymentId(kbPaymentId)
            .withStatus(status)
            .withEntity(entity)
            .withHeaders(headers)
            .withProperties(properties)
            .build();

        Assert.assertEquals(a.getKbPaymentId(), kbPaymentId);
        Assert.assertEquals(a.getStatus(), status);
        Assert.assertEquals(a.getEntity(), entity);
        Assert.assertEquals(a.getHeaders(), headers);
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

        PluginGatewayNotification a = new PluginGatewayNotification.Builder<>()
            .withKbPaymentId(kbPaymentId)
            .withStatus(status)
            .withEntity(entity)
            .withHeaders(headers)
            .withProperties(properties)
            .build();

        String json =  mapper.writeValueAsString(a);;
        PluginGatewayNotification b = mapper.readValue(json, PluginGatewayNotification.class);

        Assert.assertTrue(a.equals(b));
    }
}
