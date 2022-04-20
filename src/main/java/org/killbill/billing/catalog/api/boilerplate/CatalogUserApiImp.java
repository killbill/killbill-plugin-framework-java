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

package org.killbill.billing.catalog.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import org.joda.time.DateTime;
import org.killbill.billing.catalog.api.CatalogApiException;
import org.killbill.billing.catalog.api.CatalogUserApi;
import org.killbill.billing.catalog.api.SimplePlanDescriptor;
import org.killbill.billing.catalog.api.StaticCatalog;
import org.killbill.billing.catalog.api.VersionedCatalog;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;

@JsonDeserialize( builder = CatalogUserApiImp.Builder.class )
public class CatalogUserApiImp implements CatalogUserApi {

    private static final long serialVersionUID = 0x3067F07C17AFFCFAL;


    public CatalogUserApiImp(final CatalogUserApiImp that) {
    }
    protected CatalogUserApiImp(final CatalogUserApiImp.Builder<?> builder) {
    }
    protected CatalogUserApiImp() { }
    @Override
    public void addSimplePlan(final SimplePlanDescriptor planDescriptor, final DateTime requestedDate, final CallContext context) {
        throw new UnsupportedOperationException("addSimplePlan(org.killbill.billing.catalog.api.SimplePlanDescriptor, org.joda.time.DateTime, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public StaticCatalog getCurrentCatalog(final String catalogName, final TenantContext context) {
        throw new UnsupportedOperationException("getCurrentCatalog(java.lang.String, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public VersionedCatalog getCatalog(final String catalogName, final TenantContext context) {
        throw new UnsupportedOperationException("getCatalog(java.lang.String, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void createDefaultEmptyCatalog(final DateTime effectiveDate, final CallContext callContext) {
        throw new UnsupportedOperationException("createDefaultEmptyCatalog(org.joda.time.DateTime, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public void deleteCatalog(final CallContext callContext) {
        throw new UnsupportedOperationException("deleteCatalog(org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public void uploadCatalog(final String catalogXML, final CallContext context) {
        throw new UnsupportedOperationException("uploadCatalog(java.lang.String, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
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
    public static class Builder<T extends CatalogUserApiImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final CatalogUserApi that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public CatalogUserApiImp build() {
            return new CatalogUserApiImp(this.validate());
        }
    }
}
