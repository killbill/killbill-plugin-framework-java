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

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.google.common.collect.ImmutableList;
import org.killbill.billing.payment.api.PluginProperty;

public class TestPluginHostedPaymentPageFormDescriptor {

    private final List<PluginProperty> formFields = ImmutableList.<PluginProperty>of();
    private final String formMethod = PluginHostedPaymentPageFormDescriptor.POST;
    private final String formUrl = "https://www.nowhere.com/target";
    private final UUID kbAccountId = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private final List<PluginProperty> properties = ImmutableList.<PluginProperty>of();

    @Test
    void builderIsEquivalentToConstructor() {

        PluginHostedPaymentPageFormDescriptor a = new PluginHostedPaymentPageFormDescriptor.Builder<>()
            .withKbAccountId(kbAccountId)
            .withFormMethod(formMethod)
            .withFormUrl(formUrl)
            .withFormFields(formFields)
            .withProperties(properties)
            .build();

        PluginHostedPaymentPageFormDescriptor b = new PluginHostedPaymentPageFormDescriptor(
                kbAccountId,
                formMethod,
                formUrl,
                formFields,
                properties);

        Assert.assertTrue(a.equals(b));
    }

    @Test
    void differentInstances() {

        PluginHostedPaymentPageFormDescriptor.Builder builder = new PluginHostedPaymentPageFormDescriptor.Builder<>()
            .withKbAccountId(kbAccountId)
            .withFormMethod(formMethod)
            .withFormUrl(formUrl)
            .withFormFields(formFields)
            .withProperties(properties);

        Assert.assertNotEquals(builder.build(), builder.withFormMethod(PluginHostedPaymentPageFormDescriptor.GET).build());
    }

    @Test
    void callAllGetters() {

        PluginHostedPaymentPageFormDescriptor a = new PluginHostedPaymentPageFormDescriptor.Builder<>()
            .withKbAccountId(kbAccountId)
            .withFormMethod(formMethod)
            .withFormUrl(formUrl)
            .withFormFields(formFields)
            .withProperties(properties)
            .build();

        Assert.assertEquals(a.getKbAccountId(), kbAccountId);
        Assert.assertEquals(a.getFormMethod(), formMethod);
        Assert.assertEquals(a.getFormUrl(), formUrl);
        Assert.assertEquals(a.getFormFields(), formFields);
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

        PluginHostedPaymentPageFormDescriptor a = new PluginHostedPaymentPageFormDescriptor.Builder<>()
            .withKbAccountId(kbAccountId)
            .withFormMethod(formMethod)
            .withFormUrl(formUrl)
            .withFormFields(formFields)
            .withProperties(properties)
            .build();

        String json =  mapper.writeValueAsString(a);;
        PluginHostedPaymentPageFormDescriptor b = mapper.readValue(json, PluginHostedPaymentPageFormDescriptor.class);

        Assert.assertTrue(a.equals(b));
    }
}

