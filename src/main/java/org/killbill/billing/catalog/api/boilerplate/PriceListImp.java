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
import java.util.Collection;
import java.util.Objects;
import org.killbill.billing.catalog.api.BillingPeriod;
import org.killbill.billing.catalog.api.Plan;
import org.killbill.billing.catalog.api.PriceList;
import org.killbill.billing.catalog.api.Product;
import org.killbill.billing.catalog.api.StaticCatalog;

@JsonDeserialize( builder = PriceListImp.Builder.class )
public class PriceListImp implements PriceList {

    private static final long serialVersionUID = 0x5D1F2B634C3D86DCL;

    protected StaticCatalog catalog;
    protected String name;
    protected Collection<Plan> plans;
    protected String prettyName;

    public PriceListImp(final PriceListImp that) {
        this.catalog = that.catalog;
        this.name = that.name;
        this.plans = that.plans;
        this.prettyName = that.prettyName;
    }
    protected PriceListImp(final PriceListImp.Builder<?> builder) {
        this.catalog = builder.catalog;
        this.name = builder.name;
        this.plans = builder.plans;
        this.prettyName = builder.prettyName;
    }
    protected PriceListImp() { }
    @Override
    public StaticCatalog getCatalog() {
        return this.catalog;
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public Collection<Plan> getPlans() {
        return this.plans;
    }
    @Override
    public String getPrettyName() {
        return this.prettyName;
    }
    @Override
    public Collection<Plan> findPlans(final Product product, final BillingPeriod period) {
        throw new UnsupportedOperationException("findPlans(org.killbill.billing.catalog.api.Product, org.killbill.billing.catalog.api.BillingPeriod) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PriceListImp that = (PriceListImp) o;
        if( !Objects.equals(this.catalog, that.catalog) ) {
            return false;
        }
        if( !Objects.equals(this.name, that.name) ) {
            return false;
        }
        if( !Objects.equals(this.plans, that.plans) ) {
            return false;
        }
        if( !Objects.equals(this.prettyName, that.prettyName) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.catalog);
        result = ( 31 * result ) + Objects.hashCode(this.name);
        result = ( 31 * result ) + Objects.hashCode(this.plans);
        result = ( 31 * result ) + Objects.hashCode(this.prettyName);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("catalog=").append(this.catalog);
        sb.append(", ");
        sb.append("name=");
        if( this.name == null ) {
            sb.append(this.name);
        }else{
            sb.append("'").append(this.name).append("'");
        }
        sb.append(", ");
        sb.append("plans=").append(this.plans);
        sb.append(", ");
        sb.append("prettyName=");
        if( this.prettyName == null ) {
            sb.append(this.prettyName);
        }else{
            sb.append("'").append(this.prettyName).append("'");
        }
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PriceListImp.Builder<T>> {

        protected StaticCatalog catalog;
        protected String name;
        protected Collection<Plan> plans;
        protected String prettyName;

        public Builder() { }
        public Builder(final Builder that) {
            this.catalog = that.catalog;
            this.name = that.name;
            this.plans = that.plans;
            this.prettyName = that.prettyName;
        }
        public T withCatalog(final StaticCatalog catalog) {
            this.catalog = catalog;
            return (T) this;
        }
        public T withName(final String name) {
            this.name = name;
            return (T) this;
        }
        public T withPlans(final Collection<Plan> plans) {
            this.plans = plans;
            return (T) this;
        }
        public T withPrettyName(final String prettyName) {
            this.prettyName = prettyName;
            return (T) this;
        }
        public T source(final PriceList that) {
            this.catalog = that.getCatalog();
            this.name = that.getName();
            this.plans = that.getPlans();
            this.prettyName = that.getPrettyName();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PriceListImp build() {
            return new PriceListImp(this.validate());
        }
    }
}
