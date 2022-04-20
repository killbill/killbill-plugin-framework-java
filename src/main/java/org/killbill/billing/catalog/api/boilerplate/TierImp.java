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
import org.killbill.billing.catalog.api.InternationalPrice;
import org.killbill.billing.catalog.api.Limit;
import org.killbill.billing.catalog.api.Tier;
import org.killbill.billing.catalog.api.TieredBlock;

@JsonDeserialize( builder = TierImp.Builder.class )
public class TierImp implements Tier {

    private static final long serialVersionUID = 0x920E4CDB395343AEL;

    protected InternationalPrice fixedPrice;
    protected Limit[] limits;
    protected InternationalPrice recurringPrice;
    protected TieredBlock[] tieredBlocks;

    public TierImp(final TierImp that) {
        this.fixedPrice = that.fixedPrice;
        this.limits = that.limits;
        this.recurringPrice = that.recurringPrice;
        this.tieredBlocks = that.tieredBlocks;
    }
    protected TierImp(final TierImp.Builder<?> builder) {
        this.fixedPrice = builder.fixedPrice;
        this.limits = builder.limits;
        this.recurringPrice = builder.recurringPrice;
        this.tieredBlocks = builder.tieredBlocks;
    }
    protected TierImp() { }
    @Override
    public InternationalPrice getFixedPrice() {
        return this.fixedPrice;
    }
    @Override
    public Limit[] getLimits() {
        return this.limits;
    }
    @Override
    public InternationalPrice getRecurringPrice() {
        return this.recurringPrice;
    }
    @Override
    public TieredBlock[] getTieredBlocks() {
        return this.tieredBlocks;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final TierImp that = (TierImp) o;
        if( !Objects.equals(this.fixedPrice, that.fixedPrice) ) {
            return false;
        }
        if( !Arrays.deepEquals(this.limits, that.limits) ) {
            return false;
        }
        if( !Objects.equals(this.recurringPrice, that.recurringPrice) ) {
            return false;
        }
        if( !Arrays.deepEquals(this.tieredBlocks, that.tieredBlocks) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.fixedPrice);
        result = ( 31 * result ) + Arrays.deepHashCode(this.limits);
        result = ( 31 * result ) + Objects.hashCode(this.recurringPrice);
        result = ( 31 * result ) + Arrays.deepHashCode(this.tieredBlocks);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("fixedPrice=").append(this.fixedPrice);
        sb.append(", ");
        sb.append("limits=").append(Arrays.toString(this.limits));
        sb.append(", ");
        sb.append("recurringPrice=").append(this.recurringPrice);
        sb.append(", ");
        sb.append("tieredBlocks=").append(Arrays.toString(this.tieredBlocks));
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends TierImp.Builder<T>> {

        protected InternationalPrice fixedPrice;
        protected Limit[] limits;
        protected InternationalPrice recurringPrice;
        protected TieredBlock[] tieredBlocks;

        public Builder() { }
        public Builder(final Builder that) {
            this.fixedPrice = that.fixedPrice;
            this.limits = that.limits;
            this.recurringPrice = that.recurringPrice;
            this.tieredBlocks = that.tieredBlocks;
        }
        public T withFixedPrice(final InternationalPrice fixedPrice) {
            this.fixedPrice = fixedPrice;
            return (T) this;
        }
        public T withLimits(final Limit[] limits) {
            this.limits = limits;
            return (T) this;
        }
        public T withRecurringPrice(final InternationalPrice recurringPrice) {
            this.recurringPrice = recurringPrice;
            return (T) this;
        }
        public T withTieredBlocks(final TieredBlock[] tieredBlocks) {
            this.tieredBlocks = tieredBlocks;
            return (T) this;
        }
        public T source(final Tier that) {
            this.fixedPrice = that.getFixedPrice();
            this.limits = that.getLimits();
            this.recurringPrice = that.getRecurringPrice();
            this.tieredBlocks = that.getTieredBlocks();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public TierImp build() {
            return new TierImp(this.validate());
        }
    }
}
