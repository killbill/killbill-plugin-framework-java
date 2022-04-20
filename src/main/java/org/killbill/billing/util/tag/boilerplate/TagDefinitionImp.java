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
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.killbill.billing.ObjectType;
import org.killbill.billing.util.tag.TagDefinition;

@JsonDeserialize( builder = TagDefinitionImp.Builder.class )
public class TagDefinitionImp implements TagDefinition {

    private static final long serialVersionUID = 0x1E675F37B641DBABL;

    protected List<ObjectType> applicableObjectTypes;
    protected DateTime createdDate;
    protected String description;
    protected UUID id;
    protected Boolean isControlTag;
    protected String name;
    protected DateTime updatedDate;

    public TagDefinitionImp(final TagDefinitionImp that) {
        this.applicableObjectTypes = that.applicableObjectTypes;
        this.createdDate = that.createdDate;
        this.description = that.description;
        this.id = that.id;
        this.isControlTag = that.isControlTag;
        this.name = that.name;
        this.updatedDate = that.updatedDate;
    }
    protected TagDefinitionImp(final TagDefinitionImp.Builder<?> builder) {
        this.applicableObjectTypes = builder.applicableObjectTypes;
        this.createdDate = builder.createdDate;
        this.description = builder.description;
        this.id = builder.id;
        this.isControlTag = builder.isControlTag;
        this.name = builder.name;
        this.updatedDate = builder.updatedDate;
    }
    protected TagDefinitionImp() { }
    @Override
    public List<ObjectType> getApplicableObjectTypes() {
        return this.applicableObjectTypes;
    }
    @Override
    public DateTime getCreatedDate() {
        return this.createdDate;
    }
    @Override
    public String getDescription() {
        return this.description;
    }
    @Override
    public UUID getId() {
        return this.id;
    }
    @Override
    @JsonGetter("isControlTag")
    public Boolean isControlTag() {
        return this.isControlTag;
    }
    @Override
    public String getName() {
        return this.name;
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
        final TagDefinitionImp that = (TagDefinitionImp) o;
        if( !Objects.equals(this.applicableObjectTypes, that.applicableObjectTypes) ) {
            return false;
        }
        if( ( this.createdDate != null ) ? ( 0 != this.createdDate.compareTo(that.createdDate) ) : ( that.createdDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.description, that.description) ) {
            return false;
        }
        if( !Objects.equals(this.id, that.id) ) {
            return false;
        }
        if( !Objects.equals(this.isControlTag, that.isControlTag) ) {
            return false;
        }
        if( !Objects.equals(this.name, that.name) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.applicableObjectTypes);
        result = ( 31 * result ) + Objects.hashCode(this.createdDate);
        result = ( 31 * result ) + Objects.hashCode(this.description);
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.isControlTag);
        result = ( 31 * result ) + Objects.hashCode(this.name);
        result = ( 31 * result ) + Objects.hashCode(this.updatedDate);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("applicableObjectTypes=").append(this.applicableObjectTypes);
        sb.append(", ");
        sb.append("createdDate=").append(this.createdDate);
        sb.append(", ");
        sb.append("description=");
        if( this.description == null ) {
            sb.append(this.description);
        }else{
            sb.append("'").append(this.description).append("'");
        }
        sb.append(", ");
        sb.append("id=").append(this.id);
        sb.append(", ");
        sb.append("isControlTag=").append(this.isControlTag);
        sb.append(", ");
        sb.append("name=");
        if( this.name == null ) {
            sb.append(this.name);
        }else{
            sb.append("'").append(this.name).append("'");
        }
        sb.append(", ");
        sb.append("updatedDate=").append(this.updatedDate);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends TagDefinitionImp.Builder<T>> {

        protected List<ObjectType> applicableObjectTypes;
        protected DateTime createdDate;
        protected String description;
        protected UUID id;
        protected Boolean isControlTag;
        protected String name;
        protected DateTime updatedDate;

        public Builder() { }
        public Builder(final Builder that) {
            this.applicableObjectTypes = that.applicableObjectTypes;
            this.createdDate = that.createdDate;
            this.description = that.description;
            this.id = that.id;
            this.isControlTag = that.isControlTag;
            this.name = that.name;
            this.updatedDate = that.updatedDate;
        }
        public T withApplicableObjectTypes(final List<ObjectType> applicableObjectTypes) {
            this.applicableObjectTypes = applicableObjectTypes;
            return (T) this;
        }
        public T withCreatedDate(final DateTime createdDate) {
            this.createdDate = createdDate;
            return (T) this;
        }
        public T withDescription(final String description) {
            this.description = description;
            return (T) this;
        }
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withIsControlTag(final Boolean isControlTag) {
            this.isControlTag = isControlTag;
            return (T) this;
        }
        public T withName(final String name) {
            this.name = name;
            return (T) this;
        }
        public T withUpdatedDate(final DateTime updatedDate) {
            this.updatedDate = updatedDate;
            return (T) this;
        }
        public T source(final TagDefinition that) {
            this.applicableObjectTypes = that.getApplicableObjectTypes();
            this.createdDate = that.getCreatedDate();
            this.description = that.getDescription();
            this.id = that.getId();
            this.isControlTag = that.isControlTag();
            this.name = that.getName();
            this.updatedDate = that.getUpdatedDate();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public TagDefinitionImp build() {
            return new TagDefinitionImp(this.validate());
        }
    }
}
