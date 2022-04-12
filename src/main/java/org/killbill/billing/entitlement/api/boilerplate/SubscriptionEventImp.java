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

package org.killbill.billing.entitlement.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.LocalDate;
import org.killbill.billing.catalog.api.BillingPeriod;
import org.killbill.billing.catalog.api.Plan;
import org.killbill.billing.catalog.api.PlanPhase;
import org.killbill.billing.catalog.api.PriceList;
import org.killbill.billing.catalog.api.Product;
import org.killbill.billing.entitlement.api.SubscriptionEvent;
import org.killbill.billing.entitlement.api.SubscriptionEventType;

@JsonDeserialize( builder = SubscriptionEventImp.Builder.class )
public class SubscriptionEventImp implements SubscriptionEvent, Serializable {

    private static final long serialVersionUID = 0x8275A9C29D208B9AL;

    protected LocalDate effectiveDate;
    protected UUID entitlementId;
    protected UUID id;
    protected boolean isBlockedBilling;
    protected boolean isBlockedEntitlement;
    protected BillingPeriod nextBillingPeriod;
    protected PlanPhase nextPhase;
    protected Plan nextPlan;
    protected PriceList nextPriceList;
    protected Product nextProduct;
    protected BillingPeriod prevBillingPeriod;
    protected PlanPhase prevPhase;
    protected Plan prevPlan;
    protected PriceList prevPriceList;
    protected Product prevProduct;
    protected String serviceName;
    protected String serviceStateName;
    protected SubscriptionEventType subscriptionEventType;

    public SubscriptionEventImp(final SubscriptionEventImp that) {
        this.effectiveDate = that.effectiveDate;
        this.entitlementId = that.entitlementId;
        this.id = that.id;
        this.isBlockedBilling = that.isBlockedBilling;
        this.isBlockedEntitlement = that.isBlockedEntitlement;
        this.nextBillingPeriod = that.nextBillingPeriod;
        this.nextPhase = that.nextPhase;
        this.nextPlan = that.nextPlan;
        this.nextPriceList = that.nextPriceList;
        this.nextProduct = that.nextProduct;
        this.prevBillingPeriod = that.prevBillingPeriod;
        this.prevPhase = that.prevPhase;
        this.prevPlan = that.prevPlan;
        this.prevPriceList = that.prevPriceList;
        this.prevProduct = that.prevProduct;
        this.serviceName = that.serviceName;
        this.serviceStateName = that.serviceStateName;
        this.subscriptionEventType = that.subscriptionEventType;
    }
    protected SubscriptionEventImp(final SubscriptionEventImp.Builder<?> builder) {
        this.effectiveDate = builder.effectiveDate;
        this.entitlementId = builder.entitlementId;
        this.id = builder.id;
        this.isBlockedBilling = builder.isBlockedBilling;
        this.isBlockedEntitlement = builder.isBlockedEntitlement;
        this.nextBillingPeriod = builder.nextBillingPeriod;
        this.nextPhase = builder.nextPhase;
        this.nextPlan = builder.nextPlan;
        this.nextPriceList = builder.nextPriceList;
        this.nextProduct = builder.nextProduct;
        this.prevBillingPeriod = builder.prevBillingPeriod;
        this.prevPhase = builder.prevPhase;
        this.prevPlan = builder.prevPlan;
        this.prevPriceList = builder.prevPriceList;
        this.prevProduct = builder.prevProduct;
        this.serviceName = builder.serviceName;
        this.serviceStateName = builder.serviceStateName;
        this.subscriptionEventType = builder.subscriptionEventType;
    }
    protected SubscriptionEventImp() { }
    @Override
    public LocalDate getEffectiveDate() {
        return this.effectiveDate;
    }
    @Override
    public UUID getEntitlementId() {
        return this.entitlementId;
    }
    @Override
    public UUID getId() {
        return this.id;
    }
    @Override
    @JsonGetter("isBlockedBilling")
    public boolean isBlockedBilling() {
        return this.isBlockedBilling;
    }
    @Override
    @JsonGetter("isBlockedEntitlement")
    public boolean isBlockedEntitlement() {
        return this.isBlockedEntitlement;
    }
    @Override
    public BillingPeriod getNextBillingPeriod() {
        return this.nextBillingPeriod;
    }
    @Override
    public PlanPhase getNextPhase() {
        return this.nextPhase;
    }
    @Override
    public Plan getNextPlan() {
        return this.nextPlan;
    }
    @Override
    public PriceList getNextPriceList() {
        return this.nextPriceList;
    }
    @Override
    public Product getNextProduct() {
        return this.nextProduct;
    }
    @Override
    public BillingPeriod getPrevBillingPeriod() {
        return this.prevBillingPeriod;
    }
    @Override
    public PlanPhase getPrevPhase() {
        return this.prevPhase;
    }
    @Override
    public Plan getPrevPlan() {
        return this.prevPlan;
    }
    @Override
    public PriceList getPrevPriceList() {
        return this.prevPriceList;
    }
    @Override
    public Product getPrevProduct() {
        return this.prevProduct;
    }
    @Override
    public String getServiceName() {
        return this.serviceName;
    }
    @Override
    public String getServiceStateName() {
        return this.serviceStateName;
    }
    @Override
    public SubscriptionEventType getSubscriptionEventType() {
        return this.subscriptionEventType;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final SubscriptionEventImp that = (SubscriptionEventImp) o;
        if( ( this.effectiveDate != null ) ? ( 0 != this.effectiveDate.compareTo(that.effectiveDate) ) : ( that.effectiveDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.entitlementId, that.entitlementId) ) {
            return false;
        }
        if( !Objects.equals(this.id, that.id) ) {
            return false;
        }
        if( this.isBlockedBilling != that.isBlockedBilling ) {
            return false;
        }
        if( this.isBlockedEntitlement != that.isBlockedEntitlement ) {
            return false;
        }
        if( !Objects.equals(this.nextBillingPeriod, that.nextBillingPeriod) ) {
            return false;
        }
        if( !Objects.equals(this.nextPhase, that.nextPhase) ) {
            return false;
        }
        if( !Objects.equals(this.nextPlan, that.nextPlan) ) {
            return false;
        }
        if( !Objects.equals(this.nextPriceList, that.nextPriceList) ) {
            return false;
        }
        if( !Objects.equals(this.nextProduct, that.nextProduct) ) {
            return false;
        }
        if( !Objects.equals(this.prevBillingPeriod, that.prevBillingPeriod) ) {
            return false;
        }
        if( !Objects.equals(this.prevPhase, that.prevPhase) ) {
            return false;
        }
        if( !Objects.equals(this.prevPlan, that.prevPlan) ) {
            return false;
        }
        if( !Objects.equals(this.prevPriceList, that.prevPriceList) ) {
            return false;
        }
        if( !Objects.equals(this.prevProduct, that.prevProduct) ) {
            return false;
        }
        if( !Objects.equals(this.serviceName, that.serviceName) ) {
            return false;
        }
        if( !Objects.equals(this.serviceStateName, that.serviceStateName) ) {
            return false;
        }
        if( !Objects.equals(this.subscriptionEventType, that.subscriptionEventType) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.effectiveDate);
        result = ( 31 * result ) + Objects.hashCode(this.entitlementId);
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.isBlockedBilling);
        result = ( 31 * result ) + Objects.hashCode(this.isBlockedEntitlement);
        result = ( 31 * result ) + Objects.hashCode(this.nextBillingPeriod);
        result = ( 31 * result ) + Objects.hashCode(this.nextPhase);
        result = ( 31 * result ) + Objects.hashCode(this.nextPlan);
        result = ( 31 * result ) + Objects.hashCode(this.nextPriceList);
        result = ( 31 * result ) + Objects.hashCode(this.nextProduct);
        result = ( 31 * result ) + Objects.hashCode(this.prevBillingPeriod);
        result = ( 31 * result ) + Objects.hashCode(this.prevPhase);
        result = ( 31 * result ) + Objects.hashCode(this.prevPlan);
        result = ( 31 * result ) + Objects.hashCode(this.prevPriceList);
        result = ( 31 * result ) + Objects.hashCode(this.prevProduct);
        result = ( 31 * result ) + Objects.hashCode(this.serviceName);
        result = ( 31 * result ) + Objects.hashCode(this.serviceStateName);
        result = ( 31 * result ) + Objects.hashCode(this.subscriptionEventType);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("effectiveDate=").append(this.effectiveDate);
        sb.append(", ");
        sb.append("entitlementId=").append(this.entitlementId);
        sb.append(", ");
        sb.append("id=").append(this.id);
        sb.append(", ");
        sb.append("isBlockedBilling=").append(this.isBlockedBilling);
        sb.append(", ");
        sb.append("isBlockedEntitlement=").append(this.isBlockedEntitlement);
        sb.append(", ");
        sb.append("nextBillingPeriod=").append(this.nextBillingPeriod);
        sb.append(", ");
        sb.append("nextPhase=").append(this.nextPhase);
        sb.append(", ");
        sb.append("nextPlan=").append(this.nextPlan);
        sb.append(", ");
        sb.append("nextPriceList=").append(this.nextPriceList);
        sb.append(", ");
        sb.append("nextProduct=").append(this.nextProduct);
        sb.append(", ");
        sb.append("prevBillingPeriod=").append(this.prevBillingPeriod);
        sb.append(", ");
        sb.append("prevPhase=").append(this.prevPhase);
        sb.append(", ");
        sb.append("prevPlan=").append(this.prevPlan);
        sb.append(", ");
        sb.append("prevPriceList=").append(this.prevPriceList);
        sb.append(", ");
        sb.append("prevProduct=").append(this.prevProduct);
        sb.append(", ");
        sb.append("serviceName=");
        if( this.serviceName == null ) {
            sb.append(this.serviceName);
        }else{
            sb.append("'").append(this.serviceName).append("'");
        }
        sb.append(", ");
        sb.append("serviceStateName=");
        if( this.serviceStateName == null ) {
            sb.append(this.serviceStateName);
        }else{
            sb.append("'").append(this.serviceStateName).append("'");
        }
        sb.append(", ");
        sb.append("subscriptionEventType=").append(this.subscriptionEventType);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends SubscriptionEventImp.Builder<T>> {

        protected LocalDate effectiveDate;
        protected UUID entitlementId;
        protected UUID id;
        protected boolean isBlockedBilling;
        protected boolean isBlockedEntitlement;
        protected BillingPeriod nextBillingPeriod;
        protected PlanPhase nextPhase;
        protected Plan nextPlan;
        protected PriceList nextPriceList;
        protected Product nextProduct;
        protected BillingPeriod prevBillingPeriod;
        protected PlanPhase prevPhase;
        protected Plan prevPlan;
        protected PriceList prevPriceList;
        protected Product prevProduct;
        protected String serviceName;
        protected String serviceStateName;
        protected SubscriptionEventType subscriptionEventType;

        public Builder() { }
        public Builder(final Builder that) {
            this.effectiveDate = that.effectiveDate;
            this.entitlementId = that.entitlementId;
            this.id = that.id;
            this.isBlockedBilling = that.isBlockedBilling;
            this.isBlockedEntitlement = that.isBlockedEntitlement;
            this.nextBillingPeriod = that.nextBillingPeriod;
            this.nextPhase = that.nextPhase;
            this.nextPlan = that.nextPlan;
            this.nextPriceList = that.nextPriceList;
            this.nextProduct = that.nextProduct;
            this.prevBillingPeriod = that.prevBillingPeriod;
            this.prevPhase = that.prevPhase;
            this.prevPlan = that.prevPlan;
            this.prevPriceList = that.prevPriceList;
            this.prevProduct = that.prevProduct;
            this.serviceName = that.serviceName;
            this.serviceStateName = that.serviceStateName;
            this.subscriptionEventType = that.subscriptionEventType;
        }
        public T withEffectiveDate(final LocalDate effectiveDate) {
            this.effectiveDate = effectiveDate;
            return (T) this;
        }
        public T withEntitlementId(final UUID entitlementId) {
            this.entitlementId = entitlementId;
            return (T) this;
        }
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withIsBlockedBilling(final boolean isBlockedBilling) {
            this.isBlockedBilling = isBlockedBilling;
            return (T) this;
        }
        public T withIsBlockedEntitlement(final boolean isBlockedEntitlement) {
            this.isBlockedEntitlement = isBlockedEntitlement;
            return (T) this;
        }
        public T withNextBillingPeriod(final BillingPeriod nextBillingPeriod) {
            this.nextBillingPeriod = nextBillingPeriod;
            return (T) this;
        }
        public T withNextPhase(final PlanPhase nextPhase) {
            this.nextPhase = nextPhase;
            return (T) this;
        }
        public T withNextPlan(final Plan nextPlan) {
            this.nextPlan = nextPlan;
            return (T) this;
        }
        public T withNextPriceList(final PriceList nextPriceList) {
            this.nextPriceList = nextPriceList;
            return (T) this;
        }
        public T withNextProduct(final Product nextProduct) {
            this.nextProduct = nextProduct;
            return (T) this;
        }
        public T withPrevBillingPeriod(final BillingPeriod prevBillingPeriod) {
            this.prevBillingPeriod = prevBillingPeriod;
            return (T) this;
        }
        public T withPrevPhase(final PlanPhase prevPhase) {
            this.prevPhase = prevPhase;
            return (T) this;
        }
        public T withPrevPlan(final Plan prevPlan) {
            this.prevPlan = prevPlan;
            return (T) this;
        }
        public T withPrevPriceList(final PriceList prevPriceList) {
            this.prevPriceList = prevPriceList;
            return (T) this;
        }
        public T withPrevProduct(final Product prevProduct) {
            this.prevProduct = prevProduct;
            return (T) this;
        }
        public T withServiceName(final String serviceName) {
            this.serviceName = serviceName;
            return (T) this;
        }
        public T withServiceStateName(final String serviceStateName) {
            this.serviceStateName = serviceStateName;
            return (T) this;
        }
        public T withSubscriptionEventType(final SubscriptionEventType subscriptionEventType) {
            this.subscriptionEventType = subscriptionEventType;
            return (T) this;
        }
        public T source(final SubscriptionEvent that) {
            this.effectiveDate = that.getEffectiveDate();
            this.entitlementId = that.getEntitlementId();
            this.id = that.getId();
            this.isBlockedBilling = that.isBlockedBilling();
            this.isBlockedEntitlement = that.isBlockedEntitlement();
            this.nextBillingPeriod = that.getNextBillingPeriod();
            this.nextPhase = that.getNextPhase();
            this.nextPlan = that.getNextPlan();
            this.nextPriceList = that.getNextPriceList();
            this.nextProduct = that.getNextProduct();
            this.prevBillingPeriod = that.getPrevBillingPeriod();
            this.prevPhase = that.getPrevPhase();
            this.prevPlan = that.getPrevPlan();
            this.prevPriceList = that.getPrevPriceList();
            this.prevProduct = that.getPrevProduct();
            this.serviceName = that.getServiceName();
            this.serviceStateName = that.getServiceStateName();
            this.subscriptionEventType = that.getSubscriptionEventType();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public SubscriptionEventImp build() {
            return new SubscriptionEventImp(this.validate());
        }
    }
}
