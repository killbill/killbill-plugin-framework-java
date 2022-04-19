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
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.killbill.billing.catalog.api.TierPriceOverride;
import org.killbill.billing.catalog.api.TieredBlockPriceOverride;

@JsonDeserialize( builder = TierPriceOverrideImp.Builder.class )
public class TierPriceOverrideImp implements TierPriceOverride, Serializable {

    private static final long serialVersionUID = 0x500AF08EB554052AL;

    protected List<TieredBlockPriceOverride> tieredBlockPriceOverrides;

    public TierPriceOverrideImp(final TierPriceOverrideImp that) {
        this.tieredBlockPriceOverrides = that.tieredBlockPriceOverrides;
    }
    protected TierPriceOverrideImp(final TierPriceOverrideImp.Builder<?> builder) {
        this.tieredBlockPriceOverrides = builder.tieredBlockPriceOverrides;
    }
    protected TierPriceOverrideImp() { }
    @Override
    public List<TieredBlockPriceOverride> getTieredBlockPriceOverrides() {
        return this.tieredBlockPriceOverrides;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final TierPriceOverrideImp that = (TierPriceOverrideImp) o;
        if( !Objects.equals(this.tieredBlockPriceOverrides, that.tieredBlockPriceOverrides) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.tieredBlockPriceOverrides);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("tieredBlockPriceOverrides=").append(this.tieredBlockPriceOverrides);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends TierPriceOverrideImp.Builder<T>> {

        protected List<TieredBlockPriceOverride> tieredBlockPriceOverrides;

        public Builder() { }
        public Builder(final Builder that) {
            this.tieredBlockPriceOverrides = that.tieredBlockPriceOverrides;
        }
        public T withTieredBlockPriceOverrides(final List<TieredBlockPriceOverride> tieredBlockPriceOverrides) {
            this.tieredBlockPriceOverrides = tieredBlockPriceOverrides;
            return (T) this;
        }
        public T source(final TierPriceOverride that) {
            this.tieredBlockPriceOverrides = that.getTieredBlockPriceOverrides();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public TierPriceOverrideImp build() {
            return new TierPriceOverrideImp(this.validate());
        }
    }
}
