/*
 * Copyright 2014-2020 Groupon, Inc
 * Copyright 2020-2020 Equinix, Inc
 * Copyright 2014-2020 The Billing Project, LLC
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

import java.util.UUID;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.joda.time.DateTime;
import org.killbill.billing.ObjectType;
import org.killbill.billing.util.tag.Tag;
import org.killbill.billing.util.tag.boilerplate.TagImp;

@JsonDeserialize( builder = PluginTag.Builder.class )
public class PluginTag extends TagImp {

    public PluginTag(final UUID objectId,
            final ObjectType objectType,
            final UUID tagDefinitionId,
            final DateTime date) {
        this(objectId,
                objectType,
                tagDefinitionId,
                null,
                date,
                date);
    }

    public PluginTag(final UUID objectId,
            final ObjectType objectType,
            final UUID tagDefinitionId,
            final UUID id,
            final DateTime createdDate,
            final DateTime updatedDate) {

        this(new Builder<>()
                .withObjectId(objectId)
                .withObjectType(objectType)
                .withTagDefinitionId(tagDefinitionId)
                .withId(id)
                .withCreatedDate(createdDate)
                .withUpdatedDate(updatedDate)
                .validate());
    }

    protected PluginTag(final PluginTag.Builder<?> builder) {
        super(builder);
    }

    public PluginTag(final PluginTag that) {
        super(that);
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PluginTag.Builder<T>> 
        extends TagImp.Builder<T> {

        public Builder() {
        }

        public Builder(final Builder that) {
            super(that);
        }

        @Override
        public Builder validate() {
            return this;
        }

        @Override
        public PluginTag build() {
            return new PluginTag(this.validate());
        }
    }
}
