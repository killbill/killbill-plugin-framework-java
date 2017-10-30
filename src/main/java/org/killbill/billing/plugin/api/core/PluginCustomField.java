/*
 * Copyright 2014-2017 Groupon, Inc
 * Copyright 2014-2017 The Billing Project, LLC
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
import org.killbill.billing.ObjectType;
import org.killbill.billing.util.customfield.CustomField;

public class PluginCustomField implements CustomField {

    protected final UUID objectId;
    protected final ObjectType objectType;
    protected final String fieldName;
    protected final String fieldValue;
    protected final UUID id;
    protected final DateTime createdDate;
    protected final DateTime updatedDate;

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
        this.objectId = objectId;
        this.objectType = objectType;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    @Override
    public UUID getObjectId() {
        return objectId;
    }

    @Override
    public ObjectType getObjectType() {
        return objectType;
    }

    @Override
    public String getFieldName() {
        return fieldName;
    }

    @Override
    public String getFieldValue() {
        return fieldValue;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public DateTime getUpdatedDate() {
        return updatedDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PluginCustomField{");
        sb.append("objectId=").append(objectId);
        sb.append(", objectType=").append(objectType);
        sb.append(", fieldName='").append(fieldName).append('\'');
        sb.append(", fieldValue='").append(fieldValue).append('\'');
        sb.append(", id=").append(id);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final PluginCustomField that = (PluginCustomField) o;

        if (objectId != null ? !objectId.equals(that.objectId) : that.objectId != null) {
            return false;
        }
        if (objectType != that.objectType) {
            return false;
        }
        if (fieldName != null ? !fieldName.equals(that.fieldName) : that.fieldName != null) {
            return false;
        }
        if (fieldValue != null ? !fieldValue.equals(that.fieldValue) : that.fieldValue != null) {
            return false;
        }
        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (createdDate != null ? createdDate.compareTo(that.createdDate) != 0 : that.createdDate != null) {
            return false;
        }
        return updatedDate != null ? updatedDate.compareTo(that.updatedDate) == 0 : that.updatedDate == null;
    }

    @Override
    public int hashCode() {
        int result = objectId != null ? objectId.hashCode() : 0;
        result = 31 * result + (objectType != null ? objectType.hashCode() : 0);
        result = 31 * result + (fieldName != null ? fieldName.hashCode() : 0);
        result = 31 * result + (fieldValue != null ? fieldValue.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        return result;
    }
}
