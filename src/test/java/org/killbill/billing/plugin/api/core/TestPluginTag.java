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

import java.util.UUID;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.joda.time.DateTime;
import org.killbill.billing.ObjectType;

@Test(groups = { "fast" })
public class TestPluginTag {

    protected DateTime createdDate = new DateTime("2011-11-11T11:11");
    protected UUID id = UUID.fromString("00000000-0000-0000-0000-000000000001");
    protected UUID objectId = UUID.fromString("00000000-0000-0000-0000-000000000002");
    protected ObjectType objectType =  ObjectType.INVOICE;
    protected UUID tagDefinitionId = UUID.fromString("00000000-0000-0000-0000-000000000003");
    protected DateTime updatedDate = new DateTime("2011-11-11T11:11");

    @Test
    void builderIsEquivalentToConstructor() {

        PluginTag a = new PluginTag.Builder<>()
            .withObjectId(objectId)
            .withObjectType(objectType)
            .withTagDefinitionId(tagDefinitionId)
            .withId(id)
            .withCreatedDate(createdDate)
            .withUpdatedDate(updatedDate)
            .build();

        PluginTag b = new PluginTag(
                objectId,
                objectType,
                tagDefinitionId,
                id,
                createdDate,
                updatedDate);

        Assert.assertTrue(a.equals(b));
    }

    @Test
    void differentInstances() {

        PluginTag.Builder builder = new PluginTag.Builder<>()
            .withObjectId(objectId)
            .withObjectType(objectType)
            .withTagDefinitionId(tagDefinitionId)
            .withId(id)
            .withCreatedDate(createdDate)
            .withUpdatedDate(updatedDate);

            Assert.assertNotEquals(builder.build(), builder.withObjectType(ObjectType.PAYMENT).build());
    }

    @Test
    void callAllGetters() {

        PluginTag a = new PluginTag.Builder<>()
            .withObjectId(objectId)
            .withObjectType(objectType)
            .withTagDefinitionId(tagDefinitionId)
            .withId(id)
            .withCreatedDate(createdDate)
            .withUpdatedDate(updatedDate)
            .build();

        Assert.assertEquals(a.getObjectId(), objectId);
        Assert.assertEquals(a.getObjectType(), objectType);
        Assert.assertEquals(a.getTagDefinitionId(), tagDefinitionId);
        Assert.assertEquals(a.getId(), id);
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

        PluginTag a = new PluginTag.Builder<>()
            .withObjectId(objectId)
            .withObjectType(objectType)
            .withTagDefinitionId(tagDefinitionId)
            .withId(id)
            .withCreatedDate(createdDate)
            .withUpdatedDate(updatedDate)
            .build();

        String json =  mapper.writeValueAsString(a);;
        PluginTag b = mapper.readValue(json, PluginTag.class);

        Assert.assertTrue(a.equals(b));
    }
}
