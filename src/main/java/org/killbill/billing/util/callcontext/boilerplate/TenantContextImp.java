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

package org.killbill.billing.util.callcontext.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.killbill.billing.util.callcontext.TenantContext;

@JsonDeserialize( builder = TenantContextImp.Builder.class )
public class TenantContextImp implements TenantContext {

    protected UUID accountId;
    protected UUID tenantId;

    public TenantContextImp(final TenantContextImp that) {
        this.accountId = that.accountId;
        this.tenantId = that.tenantId;
    }
    protected TenantContextImp(final TenantContextImp.Builder<?> builder) {
        this.accountId = builder.accountId;
        this.tenantId = builder.tenantId;
    }
    protected TenantContextImp() { }
    @Override
    public UUID getAccountId() {
        return this.accountId;
    }
    @Override
    public UUID getTenantId() {
        return this.tenantId;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final TenantContextImp that = (TenantContextImp) o;
        if( !Objects.equals(this.accountId, that.accountId) ) {
            return false;
        }
        if( !Objects.equals(this.tenantId, that.tenantId) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.accountId);
        result = ( 31 * result ) + Objects.hashCode(this.tenantId);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("accountId=").append(this.accountId);
        sb.append(", ");
        sb.append("tenantId=").append(this.tenantId);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends TenantContextImp.Builder<T>> {

        protected UUID accountId;
        protected UUID tenantId;

        public Builder() { }
        public Builder(final Builder that) {
            this.accountId = that.accountId;
            this.tenantId = that.tenantId;
        }
        public T withAccountId(final UUID accountId) {
            this.accountId = accountId;
            return (T) this;
        }
        public T withTenantId(final UUID tenantId) {
            this.tenantId = tenantId;
            return (T) this;
        }
        public T source(final TenantContext that) {
            this.accountId = that.getAccountId();
            this.tenantId = that.getTenantId();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public TenantContextImp build() {
            return new TenantContextImp(this.validate());
        }
    }
}
