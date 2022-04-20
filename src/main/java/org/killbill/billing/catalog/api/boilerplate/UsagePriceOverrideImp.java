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
import java.util.List;
import java.util.Objects;
import org.killbill.billing.catalog.api.TierPriceOverride;
import org.killbill.billing.catalog.api.UsagePriceOverride;
import org.killbill.billing.catalog.api.UsageType;

@JsonDeserialize( builder = UsagePriceOverrideImp.Builder.class )
public class UsagePriceOverrideImp implements UsagePriceOverride {

    private static final long serialVersionUID = 0x8569E26A79BC90A8L;

    protected String name;
    protected List<TierPriceOverride> tierPriceOverrides;
    protected UsageType usageType;

    public UsagePriceOverrideImp(final UsagePriceOverrideImp that) {
        this.name = that.name;
        this.tierPriceOverrides = that.tierPriceOverrides;
        this.usageType = that.usageType;
    }
    protected UsagePriceOverrideImp(final UsagePriceOverrideImp.Builder<?> builder) {
        this.name = builder.name;
        this.tierPriceOverrides = builder.tierPriceOverrides;
        this.usageType = builder.usageType;
    }
    protected UsagePriceOverrideImp() { }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public List<TierPriceOverride> getTierPriceOverrides() {
        return this.tierPriceOverrides;
    }
    @Override
    public UsageType getUsageType() {
        return this.usageType;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final UsagePriceOverrideImp that = (UsagePriceOverrideImp) o;
        if( !Objects.equals(this.name, that.name) ) {
            return false;
        }
        if( !Objects.equals(this.tierPriceOverrides, that.tierPriceOverrides) ) {
            return false;
        }
        if( !Objects.equals(this.usageType, that.usageType) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.name);
        result = ( 31 * result ) + Objects.hashCode(this.tierPriceOverrides);
        result = ( 31 * result ) + Objects.hashCode(this.usageType);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("name=");
        if( this.name == null ) {
            sb.append(this.name);
        }else{
            sb.append("'").append(this.name).append("'");
        }
        sb.append(", ");
        sb.append("tierPriceOverrides=").append(this.tierPriceOverrides);
        sb.append(", ");
        sb.append("usageType=").append(this.usageType);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends UsagePriceOverrideImp.Builder<T>> {

        protected String name;
        protected List<TierPriceOverride> tierPriceOverrides;
        protected UsageType usageType;

        public Builder() { }
        public Builder(final Builder that) {
            this.name = that.name;
            this.tierPriceOverrides = that.tierPriceOverrides;
            this.usageType = that.usageType;
        }
        public T withName(final String name) {
            this.name = name;
            return (T) this;
        }
        public T withTierPriceOverrides(final List<TierPriceOverride> tierPriceOverrides) {
            this.tierPriceOverrides = tierPriceOverrides;
            return (T) this;
        }
        public T withUsageType(final UsageType usageType) {
            this.usageType = usageType;
            return (T) this;
        }
        public T source(final UsagePriceOverride that) {
            this.name = that.getName();
            this.tierPriceOverrides = that.getTierPriceOverrides();
            this.usageType = that.getUsageType();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public UsagePriceOverrideImp build() {
            return new UsagePriceOverrideImp(this.validate());
        }
    }
}
