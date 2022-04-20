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

package org.killbill.billing.invoice.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.LocalDate;
import org.killbill.billing.catalog.api.BillingActionPolicy;
import org.killbill.billing.entitlement.api.EntitlementSpecifier;
import org.killbill.billing.entitlement.api.SubscriptionEventType;
import org.killbill.billing.invoice.api.DryRunArguments;
import org.killbill.billing.invoice.api.DryRunType;

@JsonDeserialize( builder = DryRunArgumentsImp.Builder.class )
public class DryRunArgumentsImp implements DryRunArguments {

    private static final long serialVersionUID = 0xC0A75EB539775834L;

    protected SubscriptionEventType action;
    protected BillingActionPolicy billingActionPolicy;
    protected UUID bundleId;
    protected DryRunType dryRunType;
    protected LocalDate effectiveDate;
    protected EntitlementSpecifier entitlementSpecifier;
    protected UUID subscriptionId;

    public DryRunArgumentsImp(final DryRunArgumentsImp that) {
        this.action = that.action;
        this.billingActionPolicy = that.billingActionPolicy;
        this.bundleId = that.bundleId;
        this.dryRunType = that.dryRunType;
        this.effectiveDate = that.effectiveDate;
        this.entitlementSpecifier = that.entitlementSpecifier;
        this.subscriptionId = that.subscriptionId;
    }
    protected DryRunArgumentsImp(final DryRunArgumentsImp.Builder<?> builder) {
        this.action = builder.action;
        this.billingActionPolicy = builder.billingActionPolicy;
        this.bundleId = builder.bundleId;
        this.dryRunType = builder.dryRunType;
        this.effectiveDate = builder.effectiveDate;
        this.entitlementSpecifier = builder.entitlementSpecifier;
        this.subscriptionId = builder.subscriptionId;
    }
    protected DryRunArgumentsImp() { }
    @Override
    public SubscriptionEventType getAction() {
        return this.action;
    }
    @Override
    public BillingActionPolicy getBillingActionPolicy() {
        return this.billingActionPolicy;
    }
    @Override
    public UUID getBundleId() {
        return this.bundleId;
    }
    @Override
    public DryRunType getDryRunType() {
        return this.dryRunType;
    }
    @Override
    public LocalDate getEffectiveDate() {
        return this.effectiveDate;
    }
    @Override
    public EntitlementSpecifier getEntitlementSpecifier() {
        return this.entitlementSpecifier;
    }
    @Override
    public UUID getSubscriptionId() {
        return this.subscriptionId;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final DryRunArgumentsImp that = (DryRunArgumentsImp) o;
        if( !Objects.equals(this.action, that.action) ) {
            return false;
        }
        if( !Objects.equals(this.billingActionPolicy, that.billingActionPolicy) ) {
            return false;
        }
        if( !Objects.equals(this.bundleId, that.bundleId) ) {
            return false;
        }
        if( !Objects.equals(this.dryRunType, that.dryRunType) ) {
            return false;
        }
        if( ( this.effectiveDate != null ) ? ( 0 != this.effectiveDate.compareTo(that.effectiveDate) ) : ( that.effectiveDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.entitlementSpecifier, that.entitlementSpecifier) ) {
            return false;
        }
        if( !Objects.equals(this.subscriptionId, that.subscriptionId) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.action);
        result = ( 31 * result ) + Objects.hashCode(this.billingActionPolicy);
        result = ( 31 * result ) + Objects.hashCode(this.bundleId);
        result = ( 31 * result ) + Objects.hashCode(this.dryRunType);
        result = ( 31 * result ) + Objects.hashCode(this.effectiveDate);
        result = ( 31 * result ) + Objects.hashCode(this.entitlementSpecifier);
        result = ( 31 * result ) + Objects.hashCode(this.subscriptionId);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("action=").append(this.action);
        sb.append(", ");
        sb.append("billingActionPolicy=").append(this.billingActionPolicy);
        sb.append(", ");
        sb.append("bundleId=").append(this.bundleId);
        sb.append(", ");
        sb.append("dryRunType=").append(this.dryRunType);
        sb.append(", ");
        sb.append("effectiveDate=").append(this.effectiveDate);
        sb.append(", ");
        sb.append("entitlementSpecifier=").append(this.entitlementSpecifier);
        sb.append(", ");
        sb.append("subscriptionId=").append(this.subscriptionId);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends DryRunArgumentsImp.Builder<T>> {

        protected SubscriptionEventType action;
        protected BillingActionPolicy billingActionPolicy;
        protected UUID bundleId;
        protected DryRunType dryRunType;
        protected LocalDate effectiveDate;
        protected EntitlementSpecifier entitlementSpecifier;
        protected UUID subscriptionId;

        public Builder() { }
        public Builder(final Builder that) {
            this.action = that.action;
            this.billingActionPolicy = that.billingActionPolicy;
            this.bundleId = that.bundleId;
            this.dryRunType = that.dryRunType;
            this.effectiveDate = that.effectiveDate;
            this.entitlementSpecifier = that.entitlementSpecifier;
            this.subscriptionId = that.subscriptionId;
        }
        public T withAction(final SubscriptionEventType action) {
            this.action = action;
            return (T) this;
        }
        public T withBillingActionPolicy(final BillingActionPolicy billingActionPolicy) {
            this.billingActionPolicy = billingActionPolicy;
            return (T) this;
        }
        public T withBundleId(final UUID bundleId) {
            this.bundleId = bundleId;
            return (T) this;
        }
        public T withDryRunType(final DryRunType dryRunType) {
            this.dryRunType = dryRunType;
            return (T) this;
        }
        public T withEffectiveDate(final LocalDate effectiveDate) {
            this.effectiveDate = effectiveDate;
            return (T) this;
        }
        public T withEntitlementSpecifier(final EntitlementSpecifier entitlementSpecifier) {
            this.entitlementSpecifier = entitlementSpecifier;
            return (T) this;
        }
        public T withSubscriptionId(final UUID subscriptionId) {
            this.subscriptionId = subscriptionId;
            return (T) this;
        }
        public T source(final DryRunArguments that) {
            this.action = that.getAction();
            this.billingActionPolicy = that.getBillingActionPolicy();
            this.bundleId = that.getBundleId();
            this.dryRunType = that.getDryRunType();
            this.effectiveDate = that.getEffectiveDate();
            this.entitlementSpecifier = that.getEntitlementSpecifier();
            this.subscriptionId = that.getSubscriptionId();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public DryRunArgumentsImp build() {
            return new DryRunArgumentsImp(this.validate());
        }
    }
}
