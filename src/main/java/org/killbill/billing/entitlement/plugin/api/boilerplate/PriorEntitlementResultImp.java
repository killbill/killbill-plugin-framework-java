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

package org.killbill.billing.entitlement.plugin.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import org.killbill.billing.catalog.api.BillingActionPolicy;
import org.killbill.billing.entitlement.api.BaseEntitlementWithAddOnsSpecifier;
import org.killbill.billing.entitlement.plugin.api.PriorEntitlementResult;
import org.killbill.billing.payment.api.PluginProperty;

@JsonDeserialize( builder = PriorEntitlementResultImp.Builder.class )
public class PriorEntitlementResultImp implements PriorEntitlementResult {

    protected Iterable<BaseEntitlementWithAddOnsSpecifier> adjustedBaseEntitlementWithAddOnsSpecifiers;
    protected BillingActionPolicy adjustedBillingActionPolicy;
    protected Iterable<PluginProperty> adjustedPluginProperties;
    protected boolean isAborted;

    public PriorEntitlementResultImp(final PriorEntitlementResultImp that) {
        this.adjustedBaseEntitlementWithAddOnsSpecifiers = that.adjustedBaseEntitlementWithAddOnsSpecifiers;
        this.adjustedBillingActionPolicy = that.adjustedBillingActionPolicy;
        this.adjustedPluginProperties = that.adjustedPluginProperties;
        this.isAborted = that.isAborted;
    }
    protected PriorEntitlementResultImp(final PriorEntitlementResultImp.Builder<?> builder) {
        this.adjustedBaseEntitlementWithAddOnsSpecifiers = builder.adjustedBaseEntitlementWithAddOnsSpecifiers;
        this.adjustedBillingActionPolicy = builder.adjustedBillingActionPolicy;
        this.adjustedPluginProperties = builder.adjustedPluginProperties;
        this.isAborted = builder.isAborted;
    }
    protected PriorEntitlementResultImp() { }
    @Override
    public Iterable<BaseEntitlementWithAddOnsSpecifier> getAdjustedBaseEntitlementWithAddOnsSpecifiers() {
        return this.adjustedBaseEntitlementWithAddOnsSpecifiers;
    }
    @Override
    public BillingActionPolicy getAdjustedBillingActionPolicy() {
        return this.adjustedBillingActionPolicy;
    }
    @Override
    public Iterable<PluginProperty> getAdjustedPluginProperties() {
        return this.adjustedPluginProperties;
    }
    @Override
    @JsonGetter("isAborted")
    public boolean isAborted() {
        return this.isAborted;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PriorEntitlementResultImp that = (PriorEntitlementResultImp) o;
        if( !Objects.equals(this.adjustedBaseEntitlementWithAddOnsSpecifiers, that.adjustedBaseEntitlementWithAddOnsSpecifiers) ) {
            return false;
        }
        if( !Objects.equals(this.adjustedBillingActionPolicy, that.adjustedBillingActionPolicy) ) {
            return false;
        }
        if( !Objects.equals(this.adjustedPluginProperties, that.adjustedPluginProperties) ) {
            return false;
        }
        if( this.isAborted != that.isAborted ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.adjustedBaseEntitlementWithAddOnsSpecifiers);
        result = ( 31 * result ) + Objects.hashCode(this.adjustedBillingActionPolicy);
        result = ( 31 * result ) + Objects.hashCode(this.adjustedPluginProperties);
        result = ( 31 * result ) + Objects.hashCode(this.isAborted);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("adjustedBaseEntitlementWithAddOnsSpecifiers=").append(this.adjustedBaseEntitlementWithAddOnsSpecifiers);
        sb.append(", ");
        sb.append("adjustedBillingActionPolicy=").append(this.adjustedBillingActionPolicy);
        sb.append(", ");
        sb.append("adjustedPluginProperties=").append(this.adjustedPluginProperties);
        sb.append(", ");
        sb.append("isAborted=").append(this.isAborted);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PriorEntitlementResultImp.Builder<T>> {

        protected Iterable<BaseEntitlementWithAddOnsSpecifier> adjustedBaseEntitlementWithAddOnsSpecifiers;
        protected BillingActionPolicy adjustedBillingActionPolicy;
        protected Iterable<PluginProperty> adjustedPluginProperties;
        protected boolean isAborted;

        public Builder() { }
        public Builder(final Builder that) {
            this.adjustedBaseEntitlementWithAddOnsSpecifiers = that.adjustedBaseEntitlementWithAddOnsSpecifiers;
            this.adjustedBillingActionPolicy = that.adjustedBillingActionPolicy;
            this.adjustedPluginProperties = that.adjustedPluginProperties;
            this.isAborted = that.isAborted;
        }
        public T withAdjustedBaseEntitlementWithAddOnsSpecifiers(final Iterable<BaseEntitlementWithAddOnsSpecifier> adjustedBaseEntitlementWithAddOnsSpecifiers) {
            this.adjustedBaseEntitlementWithAddOnsSpecifiers = adjustedBaseEntitlementWithAddOnsSpecifiers;
            return (T) this;
        }
        public T withAdjustedBillingActionPolicy(final BillingActionPolicy adjustedBillingActionPolicy) {
            this.adjustedBillingActionPolicy = adjustedBillingActionPolicy;
            return (T) this;
        }
        public T withAdjustedPluginProperties(final Iterable<PluginProperty> adjustedPluginProperties) {
            this.adjustedPluginProperties = adjustedPluginProperties;
            return (T) this;
        }
        public T withIsAborted(final boolean isAborted) {
            this.isAborted = isAborted;
            return (T) this;
        }
        public T source(final PriorEntitlementResult that) {
            this.adjustedBaseEntitlementWithAddOnsSpecifiers = that.getAdjustedBaseEntitlementWithAddOnsSpecifiers();
            this.adjustedBillingActionPolicy = that.getAdjustedBillingActionPolicy();
            this.adjustedPluginProperties = that.getAdjustedPluginProperties();
            this.isAborted = that.isAborted();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PriorEntitlementResultImp build() {
            return new PriorEntitlementResultImp(this.validate());
        }
    }
}
