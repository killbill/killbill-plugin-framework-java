/* This is generated code, edit with caution! */
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

package org.killbill.billing.util.tag.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.killbill.billing.ObjectType;
import org.killbill.billing.util.tag.Tag;

@JsonDeserialize( builder = TagImp.Builder.class )
public class TagImp implements Tag {

    protected DateTime createdDate;
    protected UUID id;
    protected UUID objectId;
    protected ObjectType objectType;
    protected UUID tagDefinitionId;
    protected DateTime updatedDate;

    public TagImp(final TagImp that) {
        this.createdDate = that.createdDate;
        this.id = that.id;
        this.objectId = that.objectId;
        this.objectType = that.objectType;
        this.tagDefinitionId = that.tagDefinitionId;
        this.updatedDate = that.updatedDate;
    }
    protected TagImp(final TagImp.Builder<?> builder) {
        this.createdDate = builder.createdDate;
        this.id = builder.id;
        this.objectId = builder.objectId;
        this.objectType = builder.objectType;
        this.tagDefinitionId = builder.tagDefinitionId;
        this.updatedDate = builder.updatedDate;
    }
    protected TagImp() { }
    @Override
    public DateTime getCreatedDate() {
        return this.createdDate;
    }
    @Override
    public UUID getId() {
        return this.id;
    }
    @Override
    public UUID getObjectId() {
        return this.objectId;
    }
    @Override
    public ObjectType getObjectType() {
        return this.objectType;
    }
    @Override
    public UUID getTagDefinitionId() {
        return this.tagDefinitionId;
    }
    @Override
    public DateTime getUpdatedDate() {
        return this.updatedDate;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final TagImp that = (TagImp) o;
        if( ( this.createdDate != null ) ? ( 0 != this.createdDate.compareTo(that.createdDate) ) : ( that.createdDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.id, that.id) ) {
            return false;
        }
        if( !Objects.equals(this.objectId, that.objectId) ) {
            return false;
        }
        if( !Objects.equals(this.objectType, that.objectType) ) {
            return false;
        }
        if( !Objects.equals(this.tagDefinitionId, that.tagDefinitionId) ) {
            return false;
        }
        if( ( this.updatedDate != null ) ? ( 0 != this.updatedDate.compareTo(that.updatedDate) ) : ( that.updatedDate != null ) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.createdDate);
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.objectId);
        result = ( 31 * result ) + Objects.hashCode(this.objectType);
        result = ( 31 * result ) + Objects.hashCode(this.tagDefinitionId);
        result = ( 31 * result ) + Objects.hashCode(this.updatedDate);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("createdDate=").append(this.createdDate);
        sb.append(", ");
        sb.append("id=").append(this.id);
        sb.append(", ");
        sb.append("objectId=").append(this.objectId);
        sb.append(", ");
        sb.append("objectType=").append(this.objectType);
        sb.append(", ");
        sb.append("tagDefinitionId=").append(this.tagDefinitionId);
        sb.append(", ");
        sb.append("updatedDate=").append(this.updatedDate);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends TagImp.Builder<T>> {

        protected DateTime createdDate;
        protected UUID id;
        protected UUID objectId;
        protected ObjectType objectType;
        protected UUID tagDefinitionId;
        protected DateTime updatedDate;

        public Builder() { }
        public Builder(final Builder that) {
            this.createdDate = that.createdDate;
            this.id = that.id;
            this.objectId = that.objectId;
            this.objectType = that.objectType;
            this.tagDefinitionId = that.tagDefinitionId;
            this.updatedDate = that.updatedDate;
        }
        public T withCreatedDate(final DateTime createdDate) {
            this.createdDate = createdDate;
            return (T) this;
        }
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withObjectId(final UUID objectId) {
            this.objectId = objectId;
            return (T) this;
        }
        public T withObjectType(final ObjectType objectType) {
            this.objectType = objectType;
            return (T) this;
        }
        public T withTagDefinitionId(final UUID tagDefinitionId) {
            this.tagDefinitionId = tagDefinitionId;
            return (T) this;
        }
        public T withUpdatedDate(final DateTime updatedDate) {
            this.updatedDate = updatedDate;
            return (T) this;
        }
        public T source(final Tag that) {
            this.createdDate = that.getCreatedDate();
            this.id = that.getId();
            this.objectId = that.getObjectId();
            this.objectType = that.getObjectType();
            this.tagDefinitionId = that.getTagDefinitionId();
            this.updatedDate = that.getUpdatedDate();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public TagImp build() {
            return new TagImp(this.validate());
        }
    }
}
