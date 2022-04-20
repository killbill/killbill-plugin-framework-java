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
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.killbill.billing.tenant.api.Tenant;

@JsonDeserialize( builder = TenantImp.Builder.class )
public class TenantImp implements Tenant {

    protected String apiKey;
    protected String apiSecret;
    protected DateTime createdDate;
    protected String externalKey;
    protected UUID id;
    protected DateTime updatedDate;

    public TenantImp(final TenantImp that) {
        this.apiKey = that.apiKey;
        this.apiSecret = that.apiSecret;
        this.createdDate = that.createdDate;
        this.externalKey = that.externalKey;
        this.id = that.id;
        this.updatedDate = that.updatedDate;
    }
    protected TenantImp(final TenantImp.Builder<?> builder) {
        this.apiKey = builder.apiKey;
        this.apiSecret = builder.apiSecret;
        this.createdDate = builder.createdDate;
        this.externalKey = builder.externalKey;
        this.id = builder.id;
        this.updatedDate = builder.updatedDate;
    }
    protected TenantImp() { }
    @Override
    public String getApiKey() {
        return this.apiKey;
    }
    @Override
    public String getApiSecret() {
        return this.apiSecret;
    }
    @Override
    public DateTime getCreatedDate() {
        return this.createdDate;
    }
    @Override
    public String getExternalKey() {
        return this.externalKey;
    }
    @Override
    public UUID getId() {
        return this.id;
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
        final TenantImp that = (TenantImp) o;
        if( !Objects.equals(this.apiKey, that.apiKey) ) {
            return false;
        }
        if( !Objects.equals(this.apiSecret, that.apiSecret) ) {
            return false;
        }
        if( ( this.createdDate != null ) ? ( 0 != this.createdDate.compareTo(that.createdDate) ) : ( that.createdDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.externalKey, that.externalKey) ) {
            return false;
        }
        if( !Objects.equals(this.id, that.id) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.apiKey);
        result = ( 31 * result ) + Objects.hashCode(this.apiSecret);
        result = ( 31 * result ) + Objects.hashCode(this.createdDate);
        result = ( 31 * result ) + Objects.hashCode(this.externalKey);
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.updatedDate);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("apiKey=");
        if( this.apiKey == null ) {
            sb.append(this.apiKey);
        }else{
            sb.append("'").append(this.apiKey).append("'");
        }
        sb.append(", ");
        sb.append("apiSecret=");
        if( this.apiSecret == null ) {
            sb.append(this.apiSecret);
        }else{
            sb.append("'").append(this.apiSecret).append("'");
        }
        sb.append(", ");
        sb.append("createdDate=").append(this.createdDate);
        sb.append(", ");
        sb.append("externalKey=");
        if( this.externalKey == null ) {
            sb.append(this.externalKey);
        }else{
            sb.append("'").append(this.externalKey).append("'");
        }
        sb.append(", ");
        sb.append("id=").append(this.id);
        sb.append(", ");
        sb.append("updatedDate=").append(this.updatedDate);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends TenantImp.Builder<T>> {

        protected String apiKey;
        protected String apiSecret;
        protected DateTime createdDate;
        protected String externalKey;
        protected UUID id;
        protected DateTime updatedDate;

        public Builder() { }
        public Builder(final Builder that) {
            this.apiKey = that.apiKey;
            this.apiSecret = that.apiSecret;
            this.createdDate = that.createdDate;
            this.externalKey = that.externalKey;
            this.id = that.id;
            this.updatedDate = that.updatedDate;
        }
        public T withApiKey(final String apiKey) {
            this.apiKey = apiKey;
            return (T) this;
        }
        public T withApiSecret(final String apiSecret) {
            this.apiSecret = apiSecret;
            return (T) this;
        }
        public T withCreatedDate(final DateTime createdDate) {
            this.createdDate = createdDate;
            return (T) this;
        }
        public T withExternalKey(final String externalKey) {
            this.externalKey = externalKey;
            return (T) this;
        }
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withUpdatedDate(final DateTime updatedDate) {
            this.updatedDate = updatedDate;
            return (T) this;
        }
        public T source(final Tenant that) {
            this.apiKey = that.getApiKey();
            this.apiSecret = that.getApiSecret();
            this.createdDate = that.getCreatedDate();
            this.externalKey = that.getExternalKey();
            this.id = that.getId();
            this.updatedDate = that.getUpdatedDate();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public TenantImp build() {
            return new TenantImp(this.validate());
        }
    }
}
