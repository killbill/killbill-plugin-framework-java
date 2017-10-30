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
import org.killbill.billing.util.tag.Tag;

public class PluginTag implements Tag {

    protected final UUID objectId;
    protected final ObjectType objectType;
    protected final UUID tagDefinitionId;
    protected final UUID id;
    protected final DateTime createdDate;
    protected final DateTime updatedDate;

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
        this.objectId = objectId;
        this.objectType = objectType;
        this.tagDefinitionId = tagDefinitionId;
        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    @Override
    public UUID getTagDefinitionId() {
        return tagDefinitionId;
    }

    @Override
    public ObjectType getObjectType() {
        return objectType;
    }

    @Override
    public UUID getObjectId() {
        return objectId;
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
        final StringBuilder sb = new StringBuilder("PluginTag{");
        sb.append("objectId=").append(objectId);
        sb.append(", objectType=").append(objectType);
        sb.append(", tagDefinitionId=").append(tagDefinitionId);
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

        final PluginTag pluginTag = (PluginTag) o;

        if (objectId != null ? !objectId.equals(pluginTag.objectId) : pluginTag.objectId != null) {
            return false;
        }
        if (objectType != pluginTag.objectType) {
            return false;
        }
        if (tagDefinitionId != null ? !tagDefinitionId.equals(pluginTag.tagDefinitionId) : pluginTag.tagDefinitionId != null) {
            return false;
        }
        if (id != null ? !id.equals(pluginTag.id) : pluginTag.id != null) {
            return false;
        }
        if (createdDate != null ? createdDate.compareTo(pluginTag.createdDate) != 0 : pluginTag.createdDate != null) {
            return false;
        }
        return updatedDate != null ? updatedDate.compareTo(pluginTag.updatedDate) == 0 : pluginTag.updatedDate == null;
    }

    @Override
    public int hashCode() {
        int result = objectId != null ? objectId.hashCode() : 0;
        result = 31 * result + (objectType != null ? objectType.hashCode() : 0);
        result = 31 * result + (tagDefinitionId != null ? tagDefinitionId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        return result;
    }
}
