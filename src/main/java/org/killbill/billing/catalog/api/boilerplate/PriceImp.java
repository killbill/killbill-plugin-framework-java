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
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.catalog.api.CurrencyValueNull;
import org.killbill.billing.catalog.api.Price;

@JsonDeserialize( builder = PriceImp.Builder.class )
public class PriceImp implements Price {

    private static final long serialVersionUID = 0xD2B8DE0232F22E0EL;

    protected Currency currency;
    protected BigDecimal value;

    public PriceImp(final PriceImp that) {
        this.currency = that.currency;
        this.value = that.value;
    }
    protected PriceImp(final PriceImp.Builder<?> builder) {
        this.currency = builder.currency;
        this.value = builder.value;
    }
    protected PriceImp() { }
    @Override
    public Currency getCurrency() {
        return this.currency;
    }
    @Override
    public BigDecimal getValue() {
        return this.value;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PriceImp that = (PriceImp) o;
        if( !Objects.equals(this.currency, that.currency) ) {
            return false;
        }
        if( ( this.value != null ) ? ( 0 != this.value.compareTo(that.value) ) : ( that.value != null ) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.currency);
        result = ( 31 * result ) + Objects.hashCode(this.value);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("currency=").append(this.currency);
        sb.append(", ");
        sb.append("value=").append(this.value);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PriceImp.Builder<T>> {

        protected Currency currency;
        protected BigDecimal value;

        public Builder() { }
        public Builder(final Builder that) {
            this.currency = that.currency;
            this.value = that.value;
        }
        public T withCurrency(final Currency currency) {
            this.currency = currency;
            return (T) this;
        }
        public T withValue(final BigDecimal value) {
            this.value = value;
            return (T) this;
        }
        public T source(final Price that) throws CurrencyValueNull {
            this.currency = that.getCurrency();
            this.value = that.getValue();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PriceImp build() {
            return new PriceImp(this.validate());
        }
    }
}
