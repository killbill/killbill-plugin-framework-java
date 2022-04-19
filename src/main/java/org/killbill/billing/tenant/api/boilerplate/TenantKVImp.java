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

package org.killbill.billing.tenant.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.killbill.billing.tenant.api.TenantKV;

@JsonDeserialize( builder = TenantKVImp.Builder.class )
public class TenantKVImp implements TenantKV, Serializable {

    private static final long serialVersionUID = 0x16584FF3DA31393BL;

    protected DateTime createdDate;
    protected UUID id;
    protected String key;
    protected DateTime updatedDate;
    protected String value;

    public TenantKVImp(final TenantKVImp that) {
        this.createdDate = that.createdDate;
        this.id = that.id;
        this.key = that.key;
        this.updatedDate = that.updatedDate;
        this.value = that.value;
    }
    protected TenantKVImp(final TenantKVImp.Builder<?> builder) {
        this.createdDate = builder.createdDate;
        this.id = builder.id;
        this.key = builder.key;
        this.updatedDate = builder.updatedDate;
        this.value = builder.value;
    }
    protected TenantKVImp() { }
    @Override
    public DateTime getCreatedDate() {
        return this.createdDate;
    }
    @Override
    public UUID getId() {
        return this.id;
    }
    @Override
    public String getKey() {
        return this.key;
    }
    @Override
    public DateTime getUpdatedDate() {
        return this.updatedDate;
    }
    @Override
    public String getValue() {
        return this.value;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final TenantKVImp that = (TenantKVImp) o;
        if( ( this.createdDate != null ) ? ( 0 != this.createdDate.compareTo(that.createdDate) ) : ( that.createdDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.id, that.id) ) {
            return false;
        }
        if( !Objects.equals(this.key, that.key) ) {
            return false;
        }
        if( ( this.updatedDate != null ) ? ( 0 != this.updatedDate.compareTo(that.updatedDate) ) : ( that.updatedDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.value, that.value) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.createdDate);
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.key);
        result = ( 31 * result ) + Objects.hashCode(this.updatedDate);
        result = ( 31 * result ) + Objects.hashCode(this.value);
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
        sb.append("key=");
        if( this.key == null ) {
            sb.append(this.key);
        }else{
            sb.append("'").append(this.key).append("'");
        }
        sb.append(", ");
        sb.append("updatedDate=").append(this.updatedDate);
        sb.append(", ");
        sb.append("value=");
        if( this.value == null ) {
            sb.append(this.value);
        }else{
            sb.append("'").append(this.value).append("'");
        }
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends TenantKVImp.Builder<T>> {

        protected DateTime createdDate;
        protected UUID id;
        protected String key;
        protected DateTime updatedDate;
        protected String value;

        public Builder() { }
        public Builder(final Builder that) {
            this.createdDate = that.createdDate;
            this.id = that.id;
            this.key = that.key;
            this.updatedDate = that.updatedDate;
            this.value = that.value;
        }
        public T withCreatedDate(final DateTime createdDate) {
            this.createdDate = createdDate;
            return (T) this;
        }
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withKey(final String key) {
            this.key = key;
            return (T) this;
        }
        public T withUpdatedDate(final DateTime updatedDate) {
            this.updatedDate = updatedDate;
            return (T) this;
        }
        public T withValue(final String value) {
            this.value = value;
            return (T) this;
        }
        public T source(final TenantKV that) {
            this.createdDate = that.getCreatedDate();
            this.id = that.getId();
            this.key = that.getKey();
            this.updatedDate = that.getUpdatedDate();
            this.value = that.getValue();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public TenantKVImp build() {
            return new TenantKVImp(this.validate());
        }
    }
}
