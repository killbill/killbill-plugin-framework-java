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
import org.killbill.billing.catalog.api.Listing;
import org.killbill.billing.catalog.api.Plan;
import org.killbill.billing.catalog.api.PriceList;

@JsonDeserialize( builder = ListingImp.Builder.class )
public class ListingImp implements Listing {

    private static final long serialVersionUID = 0x2C0F0703EA4BBDB7L;

    protected Plan plan;
    protected PriceList priceList;

    public ListingImp(final ListingImp that) {
        this.plan = that.plan;
        this.priceList = that.priceList;
    }
    protected ListingImp(final ListingImp.Builder<?> builder) {
        this.plan = builder.plan;
        this.priceList = builder.priceList;
    }
    protected ListingImp() { }
    @Override
    public Plan getPlan() {
        return this.plan;
    }
    @Override
    public PriceList getPriceList() {
        return this.priceList;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final ListingImp that = (ListingImp) o;
        if( !Objects.equals(this.plan, that.plan) ) {
            return false;
        }
        if( !Objects.equals(this.priceList, that.priceList) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.plan);
        result = ( 31 * result ) + Objects.hashCode(this.priceList);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("plan=").append(this.plan);
        sb.append(", ");
        sb.append("priceList=").append(this.priceList);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends ListingImp.Builder<T>> {

        protected Plan plan;
        protected PriceList priceList;

        public Builder() { }
        public Builder(final Builder that) {
            this.plan = that.plan;
            this.priceList = that.priceList;
        }
        public T withPlan(final Plan plan) {
            this.plan = plan;
            return (T) this;
        }
        public T withPriceList(final PriceList priceList) {
            this.priceList = priceList;
            return (T) this;
        }
        public T source(final Listing that) {
            this.plan = that.getPlan();
            this.priceList = that.getPriceList();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public ListingImp build() {
            return new ListingImp(this.validate());
        }
    }
}
