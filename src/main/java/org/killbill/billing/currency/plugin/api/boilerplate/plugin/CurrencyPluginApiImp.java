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

package org.killbill.billing.currency.plugin.api.boilerplate.plugin;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import org.joda.time.DateTime;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.currency.api.Rate;
import org.killbill.billing.currency.plugin.api.CurrencyPluginApi;

@JsonDeserialize( builder = CurrencyPluginApiImp.Builder.class )
public class CurrencyPluginApiImp implements CurrencyPluginApi {

    protected Set<Currency> baseCurrencies;

    public CurrencyPluginApiImp(final CurrencyPluginApiImp that) {
        this.baseCurrencies = that.baseCurrencies;
    }
    protected CurrencyPluginApiImp(final CurrencyPluginApiImp.Builder<?> builder) {
        this.baseCurrencies = builder.baseCurrencies;
    }
    protected CurrencyPluginApiImp() { }
    @Override
    public Set<Currency> getBaseCurrencies() {
        return this.baseCurrencies;
    }
    @Override
    public SortedSet<DateTime> getConversionDates(final Currency baseCurrency) {
        throw new UnsupportedOperationException("getConversionDates(org.killbill.billing.catalog.api.Currency) must be implemented.");
    }
    @Override
    public DateTime getLatestConversionDate(final Currency baseCurrency) {
        throw new UnsupportedOperationException("getLatestConversionDate(org.killbill.billing.catalog.api.Currency) must be implemented.");
    }
    @Override
    public Set<Rate> getRates(final Currency baseCurrency, final DateTime conversionDate) {
        throw new UnsupportedOperationException("getRates(org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime) must be implemented.");
    }
    @Override
    public Set<Rate> getCurrentRates(final Currency baseCurrency) {
        throw new UnsupportedOperationException("getCurrentRates(org.killbill.billing.catalog.api.Currency) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final CurrencyPluginApiImp that = (CurrencyPluginApiImp) o;
        if( !Objects.equals(this.baseCurrencies, that.baseCurrencies) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.baseCurrencies);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("baseCurrencies=").append(this.baseCurrencies);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends CurrencyPluginApiImp.Builder<T>> {

        protected Set<Currency> baseCurrencies;

        public Builder() { }
        public Builder(final Builder that) {
            this.baseCurrencies = that.baseCurrencies;
        }
        public T withBaseCurrencies(final Set<Currency> baseCurrencies) {
            this.baseCurrencies = baseCurrencies;
            return (T) this;
        }
        public T source(final CurrencyPluginApi that) {
            this.baseCurrencies = that.getBaseCurrencies();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public CurrencyPluginApiImp build() {
            return new CurrencyPluginApiImp(this.validate());
        }
    }
}
