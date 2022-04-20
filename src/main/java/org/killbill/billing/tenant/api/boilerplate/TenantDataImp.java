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
import org.killbill.billing.tenant.api.TenantData;

@JsonDeserialize( builder = TenantDataImp.Builder.class )
public class TenantDataImp implements TenantData {

    protected String apiKey;
    protected String apiSecret;
    protected String externalKey;

    public TenantDataImp(final TenantDataImp that) {
        this.apiKey = that.apiKey;
        this.apiSecret = that.apiSecret;
        this.externalKey = that.externalKey;
    }
    protected TenantDataImp(final TenantDataImp.Builder<?> builder) {
        this.apiKey = builder.apiKey;
        this.apiSecret = builder.apiSecret;
        this.externalKey = builder.externalKey;
    }
    protected TenantDataImp() { }
    @Override
    public String getApiKey() {
        return this.apiKey;
    }
    @Override
    public String getApiSecret() {
        return this.apiSecret;
    }
    @Override
    public String getExternalKey() {
        return this.externalKey;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final TenantDataImp that = (TenantDataImp) o;
        if( !Objects.equals(this.apiKey, that.apiKey) ) {
            return false;
        }
        if( !Objects.equals(this.apiSecret, that.apiSecret) ) {
            return false;
        }
        if( !Objects.equals(this.externalKey, that.externalKey) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.apiKey);
        result = ( 31 * result ) + Objects.hashCode(this.apiSecret);
        result = ( 31 * result ) + Objects.hashCode(this.externalKey);
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
        sb.append("externalKey=");
        if( this.externalKey == null ) {
            sb.append(this.externalKey);
        }else{
            sb.append("'").append(this.externalKey).append("'");
        }
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends TenantDataImp.Builder<T>> {

        protected String apiKey;
        protected String apiSecret;
        protected String externalKey;

        public Builder() { }
        public Builder(final Builder that) {
            this.apiKey = that.apiKey;
            this.apiSecret = that.apiSecret;
            this.externalKey = that.externalKey;
        }
        public T withApiKey(final String apiKey) {
            this.apiKey = apiKey;
            return (T) this;
        }
        public T withApiSecret(final String apiSecret) {
            this.apiSecret = apiSecret;
            return (T) this;
        }
        public T withExternalKey(final String externalKey) {
            this.externalKey = externalKey;
            return (T) this;
        }
        public T source(final TenantData that) {
            this.apiKey = that.getApiKey();
            this.apiSecret = that.getApiSecret();
            this.externalKey = that.getExternalKey();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public TenantDataImp build() {
            return new TenantDataImp(this.validate());
        }
    }
}
