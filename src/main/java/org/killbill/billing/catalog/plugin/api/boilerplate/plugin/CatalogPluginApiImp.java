/*
 *  Generated by https://github.com/killbill/api-pojos. Do not edit!
 *
 *  Copyright 2022-2022 The Billing Project, LLC
 *
 *  The Billing Project licenses this file to you under the Apache License,
 *  version 2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at:
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 *  License for the specific language governing permissions and limitations
 *  under the License.
 */

package org.killbill.billing.catalog.plugin.api.boilerplate.plugin;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import org.joda.time.DateTime;
import org.killbill.billing.catalog.plugin.api.CatalogPluginApi;
import org.killbill.billing.catalog.plugin.api.VersionedPluginCatalog;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.util.callcontext.TenantContext;

@JsonDeserialize( builder = CatalogPluginApiImp.Builder.class )
public class CatalogPluginApiImp implements CatalogPluginApi {


    public CatalogPluginApiImp(final CatalogPluginApiImp that) {
    }
    protected CatalogPluginApiImp(final CatalogPluginApiImp.Builder<?> builder) {
    }
    protected CatalogPluginApiImp() { }
    @Override
    public VersionedPluginCatalog getVersionedPluginCatalog(final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("getVersionedPluginCatalog(java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public DateTime getLatestCatalogVersion(final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("getLatestCatalogVersion(java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
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
    public static class Builder<T extends CatalogPluginApiImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final CatalogPluginApi that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public CatalogPluginApiImp build() {
            return new CatalogPluginApiImp(this.validate());
        }
    }
}
