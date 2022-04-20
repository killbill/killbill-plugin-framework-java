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
import org.killbill.billing.catalog.api.BlockPriceOverride;
import org.killbill.billing.catalog.api.Currency;

@JsonDeserialize( builder = BlockPriceOverrideImp.Builder.class )
public class BlockPriceOverrideImp implements BlockPriceOverride {

    private static final long serialVersionUID = 0x3D35C7641AB97F04L;

    protected Currency currency;
    protected BigDecimal price;
    protected Double size;
    protected String unitName;

    public BlockPriceOverrideImp(final BlockPriceOverrideImp that) {
        this.currency = that.currency;
        this.price = that.price;
        this.size = that.size;
        this.unitName = that.unitName;
    }
    protected BlockPriceOverrideImp(final BlockPriceOverrideImp.Builder<?> builder) {
        this.currency = builder.currency;
        this.price = builder.price;
        this.size = builder.size;
        this.unitName = builder.unitName;
    }
    protected BlockPriceOverrideImp() { }
    @Override
    public Currency getCurrency() {
        return this.currency;
    }
    @Override
    public BigDecimal getPrice() {
        return this.price;
    }
    @Override
    public Double getSize() {
        return this.size;
    }
    @Override
    public String getUnitName() {
        return this.unitName;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final BlockPriceOverrideImp that = (BlockPriceOverrideImp) o;
        if( !Objects.equals(this.currency, that.currency) ) {
            return false;
        }
        if( ( this.price != null ) ? ( 0 != this.price.compareTo(that.price) ) : ( that.price != null ) ) {
            return false;
        }
        if( !Objects.equals(this.size, that.size) ) {
            return false;
        }
        if( !Objects.equals(this.unitName, that.unitName) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.currency);
        result = ( 31 * result ) + Objects.hashCode(this.price);
        result = ( 31 * result ) + Objects.hashCode(this.size);
        result = ( 31 * result ) + Objects.hashCode(this.unitName);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("currency=").append(this.currency);
        sb.append(", ");
        sb.append("price=").append(this.price);
        sb.append(", ");
        sb.append("size=").append(this.size);
        sb.append(", ");
        sb.append("unitName=");
        if( this.unitName == null ) {
            sb.append(this.unitName);
        }else{
            sb.append("'").append(this.unitName).append("'");
        }
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends BlockPriceOverrideImp.Builder<T>> {

        protected Currency currency;
        protected BigDecimal price;
        protected Double size;
        protected String unitName;

        public Builder() { }
        public Builder(final Builder that) {
            this.currency = that.currency;
            this.price = that.price;
            this.size = that.size;
            this.unitName = that.unitName;
        }
        public T withCurrency(final Currency currency) {
            this.currency = currency;
            return (T) this;
        }
        public T withPrice(final BigDecimal price) {
            this.price = price;
            return (T) this;
        }
        public T withSize(final Double size) {
            this.size = size;
            return (T) this;
        }
        public T withUnitName(final String unitName) {
            this.unitName = unitName;
            return (T) this;
        }
        public T source(final BlockPriceOverride that) {
            this.currency = that.getCurrency();
            this.price = that.getPrice();
            this.size = that.getSize();
            this.unitName = that.getUnitName();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public BlockPriceOverrideImp build() {
            return new BlockPriceOverrideImp(this.validate());
        }
    }
}
