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
import org.killbill.billing.catalog.api.Limit;
import org.killbill.billing.catalog.api.Unit;

@JsonDeserialize( builder = LimitImp.Builder.class )
public class LimitImp implements Limit {

    private static final long serialVersionUID = 0xEDC0423E78E935EL;

    protected Double max;
    protected Double min;
    protected Unit unit;

    public LimitImp(final LimitImp that) {
        this.max = that.max;
        this.min = that.min;
        this.unit = that.unit;
    }
    protected LimitImp(final LimitImp.Builder<?> builder) {
        this.max = builder.max;
        this.min = builder.min;
        this.unit = builder.unit;
    }
    protected LimitImp() { }
    @Override
    public Double getMax() {
        return this.max;
    }
    @Override
    public Double getMin() {
        return this.min;
    }
    @Override
    public Unit getUnit() {
        return this.unit;
    }
    @Override
    public boolean compliesWith(final double value) {
        throw new UnsupportedOperationException("compliesWith(double) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final LimitImp that = (LimitImp) o;
        if( !Objects.equals(this.max, that.max) ) {
            return false;
        }
        if( !Objects.equals(this.min, that.min) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.max);
        result = ( 31 * result ) + Objects.hashCode(this.min);
        result = ( 31 * result ) + Objects.hashCode(this.unit);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("max=").append(this.max);
        sb.append(", ");
        sb.append("min=").append(this.min);
        sb.append(", ");
        sb.append("unit=").append(this.unit);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends LimitImp.Builder<T>> {

        protected Double max;
        protected Double min;
        protected Unit unit;

        public Builder() { }
        public Builder(final Builder that) {
            this.max = that.max;
            this.min = that.min;
            this.unit = that.unit;
        }
        public T withMax(final Double max) {
            this.max = max;
            return (T) this;
        }
        public T withMin(final Double min) {
            this.min = min;
            return (T) this;
        }
        public T withUnit(final Unit unit) {
            this.unit = unit;
            return (T) this;
        }
        public T source(final Limit that) {
            this.max = that.getMax();
            this.min = that.getMin();
            this.unit = that.getUnit();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public LimitImp build() {
            return new LimitImp(this.validate());
        }
    }
}
