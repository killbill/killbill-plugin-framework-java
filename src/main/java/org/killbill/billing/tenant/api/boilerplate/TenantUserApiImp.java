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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.killbill.billing.tenant.api.Tenant;
import org.killbill.billing.tenant.api.TenantApiException;
import org.killbill.billing.tenant.api.TenantData;
import org.killbill.billing.tenant.api.TenantUserApi;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;

@JsonDeserialize( builder = TenantUserApiImp.Builder.class )
public class TenantUserApiImp implements TenantUserApi {

    private static final long serialVersionUID = 0x59CEA9C2896AAEABL;


    public TenantUserApiImp(final TenantUserApiImp that) {
    }
    protected TenantUserApiImp(final TenantUserApiImp.Builder<?> builder) {
    }
    protected TenantUserApiImp() { }
    @Override
    public void updateTenantKeyValue(final String key, final String value, final CallContext context) {
        throw new UnsupportedOperationException("updateTenantKeyValue(java.lang.String, java.lang.String, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public void addTenantKeyValue(final String key, final String value, final CallContext context) {
        throw new UnsupportedOperationException("addTenantKeyValue(java.lang.String, java.lang.String, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public void deleteTenantKey(final String key, final CallContext context) {
        throw new UnsupportedOperationException("deleteTenantKey(java.lang.String, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Tenant createTenant(final TenantData data, final CallContext context) {
        throw new UnsupportedOperationException("createTenant(org.killbill.billing.tenant.api.TenantData, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Tenant getTenantByApiKey(final String key) {
        throw new UnsupportedOperationException("getTenantByApiKey(java.lang.String) must be implemented.");
    }
    @Override
    public List<String> getTenantValuesForKey(final String key, final TenantContext context) {
        throw new UnsupportedOperationException("getTenantValuesForKey(java.lang.String, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Map<String, List<String>> searchTenantKeyValues(final String searchKey, final TenantContext context) {
        throw new UnsupportedOperationException("searchTenantKeyValues(java.lang.String, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Tenant getTenantById(final UUID tenantId) {
        throw new UnsupportedOperationException("getTenantById(java.util.UUID) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends TenantUserApiImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final TenantUserApi that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public TenantUserApiImp build() {
            return new TenantUserApiImp(this.validate());
        }
    }
}
