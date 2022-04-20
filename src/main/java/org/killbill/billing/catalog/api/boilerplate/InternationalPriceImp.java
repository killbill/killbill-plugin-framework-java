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
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import org.killbill.billing.catalog.api.CatalogApiException;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.catalog.api.InternationalPrice;
import org.killbill.billing.catalog.api.Price;

@JsonDeserialize( builder = InternationalPriceImp.Builder.class )
public class InternationalPriceImp implements InternationalPrice {

    private static final long serialVersionUID = 0xF5CA9ADDE8F2DC3BL;

    protected boolean isZero;
    protected Price[] prices;

    public InternationalPriceImp(final InternationalPriceImp that) {
        this.isZero = that.isZero;
        this.prices = that.prices;
    }
    protected InternationalPriceImp(final InternationalPriceImp.Builder<?> builder) {
        this.isZero = builder.isZero;
        this.prices = builder.prices;
    }
    protected InternationalPriceImp() { }
    @Override
    @JsonGetter("isZero")
    public boolean isZero() {
        return this.isZero;
    }
    @Override
    public Price[] getPrices() {
        return this.prices;
    }
    @Override
    public BigDecimal getPrice(final Currency currency) {
        throw new UnsupportedOperationException("getPrice(org.killbill.billing.catalog.api.Currency) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final InternationalPriceImp that = (InternationalPriceImp) o;
        if( this.isZero != that.isZero ) {
            return false;
        }
        if( !Arrays.deepEquals(this.prices, that.prices) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.isZero);
        result = ( 31 * result ) + Arrays.deepHashCode(this.prices);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("isZero=").append(this.isZero);
        sb.append(", ");
        sb.append("prices=").append(Arrays.toString(this.prices));
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends InternationalPriceImp.Builder<T>> {

        protected boolean isZero;
        protected Price[] prices;

        public Builder() { }
        public Builder(final Builder that) {
            this.isZero = that.isZero;
            this.prices = that.prices;
        }
        public T withIsZero(final boolean isZero) {
            this.isZero = isZero;
            return (T) this;
        }
        public T withPrices(final Price[] prices) {
            this.prices = prices;
            return (T) this;
        }
        public T source(final InternationalPrice that) {
            this.isZero = that.isZero();
            this.prices = that.getPrices();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public InternationalPriceImp build() {
            return new InternationalPriceImp(this.validate());
        }
    }
}
