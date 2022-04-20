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
import org.killbill.billing.catalog.api.BillingMode;
import org.killbill.billing.catalog.api.BillingPeriod;
import org.killbill.billing.catalog.api.Block;
import org.killbill.billing.catalog.api.InternationalPrice;
import org.killbill.billing.catalog.api.Limit;
import org.killbill.billing.catalog.api.StaticCatalog;
import org.killbill.billing.catalog.api.Tier;
import org.killbill.billing.catalog.api.TierBlockPolicy;
import org.killbill.billing.catalog.api.Usage;
import org.killbill.billing.catalog.api.UsageType;

@JsonDeserialize( builder = UsageImp.Builder.class )
public class UsageImp implements Usage {

    protected BillingMode billingMode;
    protected BillingPeriod billingPeriod;
    protected Block[] blocks;
    protected StaticCatalog catalog;
    protected InternationalPrice fixedPrice;
    protected Limit[] limits;
    protected String name;
    protected String prettyName;
    protected InternationalPrice recurringPrice;
    protected TierBlockPolicy tierBlockPolicy;
    protected Tier[] tiers;
    protected UsageType usageType;

    public UsageImp(final UsageImp that) {
        this.billingMode = that.billingMode;
        this.billingPeriod = that.billingPeriod;
        this.blocks = that.blocks;
        this.catalog = that.catalog;
        this.fixedPrice = that.fixedPrice;
        this.limits = that.limits;
        this.name = that.name;
        this.prettyName = that.prettyName;
        this.recurringPrice = that.recurringPrice;
        this.tierBlockPolicy = that.tierBlockPolicy;
        this.tiers = that.tiers;
        this.usageType = that.usageType;
    }
    protected UsageImp(final UsageImp.Builder<?> builder) {
        this.billingMode = builder.billingMode;
        this.billingPeriod = builder.billingPeriod;
        this.blocks = builder.blocks;
        this.catalog = builder.catalog;
        this.fixedPrice = builder.fixedPrice;
        this.limits = builder.limits;
        this.name = builder.name;
        this.prettyName = builder.prettyName;
        this.recurringPrice = builder.recurringPrice;
        this.tierBlockPolicy = builder.tierBlockPolicy;
        this.tiers = builder.tiers;
        this.usageType = builder.usageType;
    }
    protected UsageImp() { }
    @Override
    public BillingMode getBillingMode() {
        return this.billingMode;
    }
    @Override
    public BillingPeriod getBillingPeriod() {
        return this.billingPeriod;
    }
    @Override
    public Block[] getBlocks() {
        return this.blocks;
    }
    @Override
    public StaticCatalog getCatalog() {
        return this.catalog;
    }
    @Override
    public InternationalPrice getFixedPrice() {
        return this.fixedPrice;
    }
    @Override
    public Limit[] getLimits() {
        return this.limits;
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public String getPrettyName() {
        return this.prettyName;
    }
    @Override
    public InternationalPrice getRecurringPrice() {
        return this.recurringPrice;
    }
    @Override
    public TierBlockPolicy getTierBlockPolicy() {
        return this.tierBlockPolicy;
    }
    @Override
    public Tier[] getTiers() {
        return this.tiers;
    }
    @Override
    public UsageType getUsageType() {
        return this.usageType;
    }
    @Override
    public boolean compliesWithLimits(final String unit, final double value) {
        throw new UnsupportedOperationException("compliesWithLimits(java.lang.String, double) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final UsageImp that = (UsageImp) o;
        if( !Objects.equals(this.billingMode, that.billingMode) ) {
            return false;
        }
        if( !Objects.equals(this.billingPeriod, that.billingPeriod) ) {
            return false;
        }
        if( !Arrays.deepEquals(this.blocks, that.blocks) ) {
            return false;
        }
        if( !Objects.equals(this.catalog, that.catalog) ) {
            return false;
        }
        if( !Objects.equals(this.fixedPrice, that.fixedPrice) ) {
            return false;
        }
        if( !Arrays.deepEquals(this.limits, that.limits) ) {
            return false;
        }
        if( !Objects.equals(this.name, that.name) ) {
            return false;
        }
        if( !Objects.equals(this.prettyName, that.prettyName) ) {
            return false;
        }
        if( !Objects.equals(this.recurringPrice, that.recurringPrice) ) {
            return false;
        }
        if( !Objects.equals(this.tierBlockPolicy, that.tierBlockPolicy) ) {
            return false;
        }
        if( !Arrays.deepEquals(this.tiers, that.tiers) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.billingMode);
        result = ( 31 * result ) + Objects.hashCode(this.billingPeriod);
        result = ( 31 * result ) + Arrays.deepHashCode(this.blocks);
        result = ( 31 * result ) + Objects.hashCode(this.catalog);
        result = ( 31 * result ) + Objects.hashCode(this.fixedPrice);
        result = ( 31 * result ) + Arrays.deepHashCode(this.limits);
        result = ( 31 * result ) + Objects.hashCode(this.name);
        result = ( 31 * result ) + Objects.hashCode(this.prettyName);
        result = ( 31 * result ) + Objects.hashCode(this.recurringPrice);
        result = ( 31 * result ) + Objects.hashCode(this.tierBlockPolicy);
        result = ( 31 * result ) + Arrays.deepHashCode(this.tiers);
        result = ( 31 * result ) + Objects.hashCode(this.usageType);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("billingMode=").append(this.billingMode);
        sb.append(", ");
        sb.append("billingPeriod=").append(this.billingPeriod);
        sb.append(", ");
        sb.append("blocks=").append(Arrays.toString(this.blocks));
        sb.append(", ");
        sb.append("catalog=").append(this.catalog);
        sb.append(", ");
        sb.append("fixedPrice=").append(this.fixedPrice);
        sb.append(", ");
        sb.append("limits=").append(Arrays.toString(this.limits));
        sb.append(", ");
        sb.append("name=");
        if( this.name == null ) {
            sb.append(this.name);
        }else{
            sb.append("'").append(this.name).append("'");
        }
        sb.append(", ");
        sb.append("prettyName=");
        if( this.prettyName == null ) {
            sb.append(this.prettyName);
        }else{
            sb.append("'").append(this.prettyName).append("'");
        }
        sb.append(", ");
        sb.append("recurringPrice=").append(this.recurringPrice);
        sb.append(", ");
        sb.append("tierBlockPolicy=").append(this.tierBlockPolicy);
        sb.append(", ");
        sb.append("tiers=").append(Arrays.toString(this.tiers));
        sb.append(", ");
        sb.append("usageType=").append(this.usageType);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends UsageImp.Builder<T>> {

        protected BillingMode billingMode;
        protected BillingPeriod billingPeriod;
        protected Block[] blocks;
        protected StaticCatalog catalog;
        protected InternationalPrice fixedPrice;
        protected Limit[] limits;
        protected String name;
        protected String prettyName;
        protected InternationalPrice recurringPrice;
        protected TierBlockPolicy tierBlockPolicy;
        protected Tier[] tiers;
        protected UsageType usageType;

        public Builder() { }
        public Builder(final Builder that) {
            this.billingMode = that.billingMode;
            this.billingPeriod = that.billingPeriod;
            this.blocks = that.blocks;
            this.catalog = that.catalog;
            this.fixedPrice = that.fixedPrice;
            this.limits = that.limits;
            this.name = that.name;
            this.prettyName = that.prettyName;
            this.recurringPrice = that.recurringPrice;
            this.tierBlockPolicy = that.tierBlockPolicy;
            this.tiers = that.tiers;
            this.usageType = that.usageType;
        }
        public T withBillingMode(final BillingMode billingMode) {
            this.billingMode = billingMode;
            return (T) this;
        }
        public T withBillingPeriod(final BillingPeriod billingPeriod) {
            this.billingPeriod = billingPeriod;
            return (T) this;
        }
        public T withBlocks(final Block[] blocks) {
            this.blocks = blocks;
            return (T) this;
        }
        public T withCatalog(final StaticCatalog catalog) {
            this.catalog = catalog;
            return (T) this;
        }
        public T withFixedPrice(final InternationalPrice fixedPrice) {
            this.fixedPrice = fixedPrice;
            return (T) this;
        }
        public T withLimits(final Limit[] limits) {
            this.limits = limits;
            return (T) this;
        }
        public T withName(final String name) {
            this.name = name;
            return (T) this;
        }
        public T withPrettyName(final String prettyName) {
            this.prettyName = prettyName;
            return (T) this;
        }
        public T withRecurringPrice(final InternationalPrice recurringPrice) {
            this.recurringPrice = recurringPrice;
            return (T) this;
        }
        public T withTierBlockPolicy(final TierBlockPolicy tierBlockPolicy) {
            this.tierBlockPolicy = tierBlockPolicy;
            return (T) this;
        }
        public T withTiers(final Tier[] tiers) {
            this.tiers = tiers;
            return (T) this;
        }
        public T withUsageType(final UsageType usageType) {
            this.usageType = usageType;
            return (T) this;
        }
        public T source(final Usage that) {
            this.billingMode = that.getBillingMode();
            this.billingPeriod = that.getBillingPeriod();
            this.blocks = that.getBlocks();
            this.catalog = that.getCatalog();
            this.fixedPrice = that.getFixedPrice();
            this.limits = that.getLimits();
            this.name = that.getName();
            this.prettyName = that.getPrettyName();
            this.recurringPrice = that.getRecurringPrice();
            this.tierBlockPolicy = that.getTierBlockPolicy();
            this.tiers = that.getTiers();
            this.usageType = that.getUsageType();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public UsageImp build() {
            return new UsageImp(this.validate());
        }
    }
}
