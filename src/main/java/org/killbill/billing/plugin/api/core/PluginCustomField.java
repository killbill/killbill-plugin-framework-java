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
import org.joda.time.DateTime;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.killbill.billing.ObjectType;
import org.killbill.billing.util.customfield.CustomField;
import org.killbill.billing.util.customfield.boilerplate.CustomFieldImp;

@JsonDeserialize( builder = PluginCustomField.Builder.class )
public class PluginCustomField extends CustomFieldImp {

    public PluginCustomField(final UUID objectId,
            final ObjectType objectType,
            final String fieldName,
            final String fieldValue,
            final DateTime date) {
        this(objectId,
                objectType,
                fieldName,
                fieldValue,
                null,
                date,
                date);
    }

    public PluginCustomField(final UUID objectId,
            final ObjectType objectType,
            final String fieldName,
            final String fieldValue,
            final UUID id,
            final DateTime createdDate,
            final DateTime updatedDate) {

        this(new Builder<>()
                .withObjectId(objectId)
                .withObjectType(objectType)
                .withFieldName(fieldName)
                .withFieldValue(fieldValue)
                .withId(id)
                .withCreatedDate(createdDate)
                .withUpdatedDate(updatedDate)
                .validate());
    }

    protected PluginCustomField(final PluginCustomField.Builder<?> builder) {
        super(builder);
    }

    public PluginCustomField(final PluginCustomField that) {
        super(that);
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PluginCustomField.Builder<T>> 
        extends CustomFieldImp.Builder<T> {

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
        public PluginCustomField build() {
            return new PluginCustomField(this.validate());
        }
    }
}
