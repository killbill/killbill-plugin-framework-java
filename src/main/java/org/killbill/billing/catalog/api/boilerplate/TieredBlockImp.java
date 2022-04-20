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
import org.killbill.billing.catalog.api.BlockType;
import org.killbill.billing.catalog.api.CatalogApiException;
import org.killbill.billing.catalog.api.InternationalPrice;
import org.killbill.billing.catalog.api.TieredBlock;
import org.killbill.billing.catalog.api.Unit;

@JsonDeserialize( builder = TieredBlockImp.Builder.class )
public class TieredBlockImp implements TieredBlock {

    private static final long serialVersionUID = 0xD94B1A0BE079B80L;

    protected Double max;
    protected Double minTopUpCredit;
    protected InternationalPrice price;
    protected Double size;
    protected BlockType type;
    protected Unit unit;

    public TieredBlockImp(final TieredBlockImp that) {
        this.max = that.max;
        this.minTopUpCredit = that.minTopUpCredit;
        this.price = that.price;
        this.size = that.size;
        this.type = that.type;
        this.unit = that.unit;
    }
    protected TieredBlockImp(final TieredBlockImp.Builder<?> builder) {
        this.max = builder.max;
        this.minTopUpCredit = builder.minTopUpCredit;
        this.price = builder.price;
        this.size = builder.size;
        this.type = builder.type;
        this.unit = builder.unit;
    }
    protected TieredBlockImp() { }
    @Override
    public Double getMax() {
        return this.max;
    }
    @Override
    public Double getMinTopUpCredit() {
        return this.minTopUpCredit;
    }
    @Override
    public InternationalPrice getPrice() {
        return this.price;
    }
    @Override
    public Double getSize() {
        return this.size;
    }
    @Override
    public BlockType getType() {
        return this.type;
    }
    @Override
    public Unit getUnit() {
        return this.unit;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final TieredBlockImp that = (TieredBlockImp) o;
        if( !Objects.equals(this.max, that.max) ) {
            return false;
        }
        if( !Objects.equals(this.minTopUpCredit, that.minTopUpCredit) ) {
            return false;
        }
        if( !Objects.equals(this.price, that.price) ) {
            return false;
        }
        if( !Objects.equals(this.size, that.size) ) {
            return false;
        }
        if( !Objects.equals(this.type, that.type) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.minTopUpCredit);
        result = ( 31 * result ) + Objects.hashCode(this.price);
        result = ( 31 * result ) + Objects.hashCode(this.size);
        result = ( 31 * result ) + Objects.hashCode(this.type);
        result = ( 31 * result ) + Objects.hashCode(this.unit);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("max=").append(this.max);
        sb.append(", ");
        sb.append("minTopUpCredit=").append(this.minTopUpCredit);
        sb.append(", ");
        sb.append("price=").append(this.price);
        sb.append(", ");
        sb.append("size=").append(this.size);
        sb.append(", ");
        sb.append("type=").append(this.type);
        sb.append(", ");
        sb.append("unit=").append(this.unit);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends TieredBlockImp.Builder<T>> {

        protected Double max;
        protected Double minTopUpCredit;
        protected InternationalPrice price;
        protected Double size;
        protected BlockType type;
        protected Unit unit;

        public Builder() { }
        public Builder(final Builder that) {
            this.max = that.max;
            this.minTopUpCredit = that.minTopUpCredit;
            this.price = that.price;
            this.size = that.size;
            this.type = that.type;
            this.unit = that.unit;
        }
        public T withMax(final Double max) {
            this.max = max;
            return (T) this;
        }
        public T withMinTopUpCredit(final Double minTopUpCredit) {
            this.minTopUpCredit = minTopUpCredit;
            return (T) this;
        }
        public T withPrice(final InternationalPrice price) {
            this.price = price;
            return (T) this;
        }
        public T withSize(final Double size) {
            this.size = size;
            return (T) this;
        }
        public T withType(final BlockType type) {
            this.type = type;
            return (T) this;
        }
        public T withUnit(final Unit unit) {
            this.unit = unit;
            return (T) this;
        }
        public T source(final TieredBlock that) throws CatalogApiException {
            this.max = that.getMax();
            this.minTopUpCredit = that.getMinTopUpCredit();
            this.price = that.getPrice();
            this.size = that.getSize();
            this.type = that.getType();
            this.unit = that.getUnit();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public TieredBlockImp build() {
            return new TieredBlockImp(this.validate());
        }
    }
}
