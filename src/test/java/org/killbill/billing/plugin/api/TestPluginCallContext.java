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

import java.util.Locale;
import java.util.UUID;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.joda.time.DateTime;

import org.killbill.billing.util.callcontext.CallOrigin;
import org.killbill.billing.util.callcontext.UserType;

@Test(groups = { "fast" })
public class TestPluginCallContext {

    private final UUID accountId = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private final CallOrigin callOrigin = CallOrigin.INTERNAL;
    private final String comments = "Test Comments";
    private final DateTime createdDate = new DateTime("2011-11-11T11:11");
    private final String reasonCode = "Testing";
    private final UUID tenantId = UUID.fromString("00000000-0000-0000-0000-000000000002");
    private final DateTime updatedDate =  new DateTime("2011-11-11T11:11");
    private final String userName = "TestUserName";
    private final UUID userToken = UUID.fromString("00000000-0000-0000-0000-000000000003");
    private final UserType userType = UserType.ADMIN;

    @Test
    void builderIsEquivalentToConstructor() {

        PluginCallContext a = new PluginCallContext.Builder<>()
            .withUserToken(userToken)
            .withUserName(userName)
            .withCallOrigin(callOrigin)
            .withUserType(userType)
            .withReasonCode(reasonCode)
            .withComments(comments)
            .withCreatedDate(createdDate)
            .withUpdatedDate(updatedDate)
            .withAccountId(accountId)
            .withTenantId(tenantId)
            .build();

        PluginCallContext b = new PluginCallContext(
                userToken,
                userName,
                callOrigin,
                userType,
                reasonCode,
                comments,
                createdDate,
                updatedDate,
                accountId,
                tenantId);

        Assert.assertTrue(a.equals(b));
    }

    @Test
    void differentInstances() {

        PluginCallContext.Builder builder = new PluginCallContext.Builder<>()
            .withUserToken(userToken)
            .withUserName(userName)
            .withCallOrigin(callOrigin)
            .withUserType(userType)
            .withReasonCode(reasonCode)
            .withComments(comments)
            .withCreatedDate(createdDate)
            .withUpdatedDate(updatedDate)
            .withAccountId(accountId)
            .withTenantId(tenantId);

        Assert.assertNotEquals(builder.build(), builder.withUserName("DifferentTestUserName").build());
    }

    @Test
    void callAllGetters() {

        PluginCallContext a = new PluginCallContext.Builder<>()
            .withUserToken(userToken)
            .withUserName(userName)
            .withCallOrigin(callOrigin)
            .withUserType(userType)
            .withReasonCode(reasonCode)
            .withComments(comments)
            .withCreatedDate(createdDate)
            .withUpdatedDate(updatedDate)
            .withAccountId(accountId)
            .withTenantId(tenantId)
            .build();

        Assert.assertEquals(a.getUserToken(), userToken);
        Assert.assertEquals(a.getUserName(), userName);
        Assert.assertEquals(a.getCallOrigin(), callOrigin);
        Assert.assertEquals(a.getUserType(), userType);
        Assert.assertEquals(a.getReasonCode(), reasonCode);
        Assert.assertEquals(a.getComments(), comments);
        Assert.assertEquals(a.getCreatedDate(), createdDate);
        Assert.assertEquals(a.getUpdatedDate(), updatedDate);
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

        PluginCallContext a = new PluginCallContext.Builder<>()
            .withUserToken(userToken)
            .withUserName(userName)
            .withCallOrigin(callOrigin)
            .withUserType(userType)
            .withReasonCode(reasonCode)
            .withComments(comments)
            .withCreatedDate(createdDate)
            .withUpdatedDate(updatedDate)
            .withAccountId(accountId)
            .withTenantId(tenantId)
            .build();

        String json =  mapper.writeValueAsString(a);;
        PluginCallContext b = mapper.readValue(json, PluginCallContext.class);

        Assert.assertTrue(a.equals(b));
    }
}
