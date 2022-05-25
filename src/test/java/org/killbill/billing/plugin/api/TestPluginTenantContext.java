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

package org.killbill.billing.plugin.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;
import javax.annotation.Nullable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.databind.util.StdDateFormat;

@Test(groups = { "fast" })
public class TestPluginTenantContext {

    final private UUID accountId = UUID.fromString("00000000-0000-0000-0000-000000000001");
    final private UUID tenantId = UUID.fromString("00000000-0000-0000-0000-000000000002");

    @Test
    void builderIsEquivalentToConstructor() {

        PluginTenantContext a = new PluginTenantContext.Builder<>()
            .withAccountId(accountId)
            .withTenantId(tenantId)
            .build();

        PluginTenantContext b = new PluginTenantContext(accountId, tenantId) ;

        Assert.assertTrue(a.equals(b));
    }

    @Test
    void differentInstances() {

        PluginTenantContext.Builder builder = new PluginTenantContext.Builder<>()
            .withAccountId(accountId)
            .withTenantId(tenantId);

            Assert.assertNotEquals(builder.build(), 
                    builder.withAccountId(UUID.fromString("00000000-0000-0000-0000-000000000003")).build());
    }

    @Test
    void callAllGetters() {

        PluginTenantContext a = new PluginTenantContext.Builder<>()
            .withAccountId(accountId)
            .withTenantId(tenantId)
            .build();

        Assert.assertEquals(a.getAccountId(), accountId);
        Assert.assertEquals(a.getTenantId(), tenantId);
    }

    @Test 
    void roundTripJson() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
        mapper.registerModule(new JodaModule());
        mapper.findAndRegisterModules();

        PluginTenantContext a = new PluginTenantContext.Builder<>()
            .withAccountId(accountId)
            .withTenantId(tenantId)
            .build();

        String json =  mapper.writeValueAsString(a);;
        PluginTenantContext b = mapper.readValue(json, PluginTenantContext.class);

        Assert.assertTrue(a.equals(b));
    }
}
