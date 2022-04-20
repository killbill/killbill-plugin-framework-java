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

package org.killbill.billing.currency.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.currency.api.CurrencyConversion;
import org.killbill.billing.currency.api.Rate;

@JsonDeserialize( builder = CurrencyConversionImp.Builder.class )
public class CurrencyConversionImp implements CurrencyConversion {

    private static final long serialVersionUID = 0x3137D29113B8AFC2L;

    protected Currency baseCurrency;
    protected Set<Rate> rates;

    public CurrencyConversionImp(final CurrencyConversionImp that) {
        this.baseCurrency = that.baseCurrency;
        this.rates = that.rates;
    }
    protected CurrencyConversionImp(final CurrencyConversionImp.Builder<?> builder) {
        this.baseCurrency = builder.baseCurrency;
        this.rates = builder.rates;
    }
    protected CurrencyConversionImp() { }
    @Override
    public Currency getBaseCurrency() {
        return this.baseCurrency;
    }
    @Override
    public Set<Rate> getRates() {
        return this.rates;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final CurrencyConversionImp that = (CurrencyConversionImp) o;
        if( !Objects.equals(this.baseCurrency, that.baseCurrency) ) {
            return false;
        }
        if( !Objects.equals(this.rates, that.rates) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.baseCurrency);
        result = ( 31 * result ) + Objects.hashCode(this.rates);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("baseCurrency=").append(this.baseCurrency);
        sb.append(", ");
        sb.append("rates=").append(this.rates);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends CurrencyConversionImp.Builder<T>> {

        protected Currency baseCurrency;
        protected Set<Rate> rates;

        public Builder() { }
        public Builder(final Builder that) {
            this.baseCurrency = that.baseCurrency;
            this.rates = that.rates;
        }
        public T withBaseCurrency(final Currency baseCurrency) {
            this.baseCurrency = baseCurrency;
            return (T) this;
        }
        public T withRates(final Set<Rate> rates) {
            this.rates = rates;
            return (T) this;
        }
        public T source(final CurrencyConversion that) {
            this.baseCurrency = that.getBaseCurrency();
            this.rates = that.getRates();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public CurrencyConversionImp build() {
            return new CurrencyConversionImp(this.validate());
        }
    }
}
