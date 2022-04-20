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
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.killbill.billing.catalog.api.CatalogApiException;
import org.killbill.billing.catalog.api.Duration;
import org.killbill.billing.catalog.api.TimeUnit;

@JsonDeserialize( builder = DurationImp.Builder.class )
public class DurationImp implements Duration {

    private static final long serialVersionUID = 0x960B032F06518C3EL;

    protected int number;
    protected TimeUnit unit;

    public DurationImp(final DurationImp that) {
        this.number = that.number;
        this.unit = that.unit;
    }
    protected DurationImp(final DurationImp.Builder<?> builder) {
        this.number = builder.number;
        this.unit = builder.unit;
    }
    protected DurationImp() { }
    @Override
    public int getNumber() {
        return this.number;
    }
    @Override
    public TimeUnit getUnit() {
        return this.unit;
    }
    @Override
    public LocalDate addToLocalDate(final LocalDate localDate) {
        throw new UnsupportedOperationException("addToLocalDate(org.joda.time.LocalDate) must be implemented.");
    }
    @Override
    public Period toJodaPeriod() {
        throw new UnsupportedOperationException("toJodaPeriod() must be implemented.");
    }
    @Override
    public DateTime addToDateTime(final DateTime dateTime) {
        throw new UnsupportedOperationException("addToDateTime(org.joda.time.DateTime) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final DurationImp that = (DurationImp) o;
        if( this.number != that.number ) {
            return false;
        }
        if( !Objects.equals(this.unit, that.unit) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.number);
        result = ( 31 * result ) + Objects.hashCode(this.unit);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("number=").append(this.number);
        sb.append(", ");
        sb.append("unit=").append(this.unit);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends DurationImp.Builder<T>> {

        protected int number;
        protected TimeUnit unit;

        public Builder() { }
        public Builder(final Builder that) {
            this.number = that.number;
            this.unit = that.unit;
        }
        public T withNumber(final int number) {
            this.number = number;
            return (T) this;
        }
        public T withUnit(final TimeUnit unit) {
            this.unit = unit;
            return (T) this;
        }
        public T source(final Duration that) {
            this.number = that.getNumber();
            this.unit = that.getUnit();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public DurationImp build() {
            return new DurationImp(this.validate());
        }
    }
}
