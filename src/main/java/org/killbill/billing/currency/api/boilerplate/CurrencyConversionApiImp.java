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
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import org.joda.time.DateTime;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.currency.api.CurrencyConversion;
import org.killbill.billing.currency.api.CurrencyConversionApi;
import org.killbill.billing.currency.api.CurrencyConversionException;

@JsonDeserialize( builder = CurrencyConversionApiImp.Builder.class )
public class CurrencyConversionApiImp implements CurrencyConversionApi, Serializable {

    private static final long serialVersionUID = 0xC831A56BB2A16681L;

    protected Set<Currency> baseRates;

    public CurrencyConversionApiImp(final CurrencyConversionApiImp that) {
        this.baseRates = that.baseRates;
    }
    protected CurrencyConversionApiImp(final CurrencyConversionApiImp.Builder<?> builder) {
        this.baseRates = builder.baseRates;
    }
    protected CurrencyConversionApiImp() { }
    @Override
    public Set<Currency> getBaseRates() {
        return this.baseRates;
    }
    @Override
    public CurrencyConversion getCurrentCurrencyConversion(final Currency baseCurrency) {
        throw new UnsupportedOperationException("getCurrentCurrencyConversion(org.killbill.billing.catalog.api.Currency) must be implemented.");
    }
    @Override
    public CurrencyConversion getCurrencyConversion(final Currency baseCurrency, final DateTime dateConversion) {
        throw new UnsupportedOperationException("getCurrencyConversion(org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final CurrencyConversionApiImp that = (CurrencyConversionApiImp) o;
        if( !Objects.equals(this.baseRates, that.baseRates) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.baseRates);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("baseRates=").append(this.baseRates);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends CurrencyConversionApiImp.Builder<T>> {

        protected Set<Currency> baseRates;

        public Builder() { }
        public Builder(final Builder that) {
            this.baseRates = that.baseRates;
        }
        public T withBaseRates(final Set<Currency> baseRates) {
            this.baseRates = baseRates;
            return (T) this;
        }
        public T source(final CurrencyConversionApi that) throws CurrencyConversionException {
            this.baseRates = that.getBaseRates();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public CurrencyConversionApiImp build() {
            return new CurrencyConversionApiImp(this.validate());
        }
    }
}
