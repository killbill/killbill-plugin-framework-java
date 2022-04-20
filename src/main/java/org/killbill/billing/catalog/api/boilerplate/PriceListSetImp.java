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
import java.util.List;
import java.util.Objects;
import org.killbill.billing.catalog.api.PriceList;
import org.killbill.billing.catalog.api.PriceListSet;
import org.killbill.billing.catalog.api.StaticCatalog;

@JsonDeserialize( builder = PriceListSetImp.Builder.class )
public class PriceListSetImp implements PriceListSet {

    protected List<PriceList> allPriceLists;
    protected StaticCatalog catalog;

    public PriceListSetImp(final PriceListSetImp that) {
        this.allPriceLists = that.allPriceLists;
        this.catalog = that.catalog;
    }
    protected PriceListSetImp(final PriceListSetImp.Builder<?> builder) {
        this.allPriceLists = builder.allPriceLists;
        this.catalog = builder.catalog;
    }
    protected PriceListSetImp() { }
    @Override
    public List<PriceList> getAllPriceLists() {
        return this.allPriceLists;
    }
    @Override
    public StaticCatalog getCatalog() {
        return this.catalog;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PriceListSetImp that = (PriceListSetImp) o;
        if( !Objects.equals(this.allPriceLists, that.allPriceLists) ) {
            return false;
        }
        if( !Objects.equals(this.catalog, that.catalog) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.allPriceLists);
        result = ( 31 * result ) + Objects.hashCode(this.catalog);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("allPriceLists=").append(this.allPriceLists);
        sb.append(", ");
        sb.append("catalog=").append(this.catalog);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PriceListSetImp.Builder<T>> {

        protected List<PriceList> allPriceLists;
        protected StaticCatalog catalog;

        public Builder() { }
        public Builder(final Builder that) {
            this.allPriceLists = that.allPriceLists;
            this.catalog = that.catalog;
        }
        public T withAllPriceLists(final List<PriceList> allPriceLists) {
            this.allPriceLists = allPriceLists;
            return (T) this;
        }
        public T withCatalog(final StaticCatalog catalog) {
            this.catalog = catalog;
            return (T) this;
        }
        public T source(final PriceListSet that) {
            this.allPriceLists = that.getAllPriceLists();
            this.catalog = that.getCatalog();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PriceListSetImp build() {
            return new PriceListSetImp(this.validate());
        }
    }
}
