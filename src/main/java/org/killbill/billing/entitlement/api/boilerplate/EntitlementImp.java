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
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.killbill.billing.catalog.api.BillingActionPolicy;
import org.killbill.billing.catalog.api.Plan;
import org.killbill.billing.catalog.api.PlanPhase;
import org.killbill.billing.catalog.api.PriceList;
import org.killbill.billing.catalog.api.Product;
import org.killbill.billing.catalog.api.ProductCategory;
import org.killbill.billing.entitlement.api.Entitlement;
import org.killbill.billing.entitlement.api.EntitlementApiException;
import org.killbill.billing.entitlement.api.EntitlementSpecifier;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.util.callcontext.CallContext;

@JsonDeserialize( builder = EntitlementImp.Builder.class )
public class EntitlementImp implements Entitlement {

    private static final long serialVersionUID = 0xA45D9D5CD7043073L;

    protected UUID accountId;
    protected UUID baseEntitlementId;
    protected Integer billCycleDayLocal;
    protected String bundleExternalKey;
    protected UUID bundleId;
    protected DateTime createdDate;
    protected LocalDate effectiveEndDate;
    protected LocalDate effectiveStartDate;
    protected String externalKey;
    protected UUID id;
    protected PlanPhase lastActivePhase;
    protected Plan lastActivePlan;
    protected PriceList lastActivePriceList;
    protected Product lastActiveProduct;
    protected ProductCategory lastActiveProductCategory;
    protected Entitlement.EntitlementSourceType sourceType;
    protected Entitlement.EntitlementState state;
    protected DateTime updatedDate;

    public EntitlementImp(final EntitlementImp that) {
        this.accountId = that.accountId;
        this.baseEntitlementId = that.baseEntitlementId;
        this.billCycleDayLocal = that.billCycleDayLocal;
        this.bundleExternalKey = that.bundleExternalKey;
        this.bundleId = that.bundleId;
        this.createdDate = that.createdDate;
        this.effectiveEndDate = that.effectiveEndDate;
        this.effectiveStartDate = that.effectiveStartDate;
        this.externalKey = that.externalKey;
        this.id = that.id;
        this.lastActivePhase = that.lastActivePhase;
        this.lastActivePlan = that.lastActivePlan;
        this.lastActivePriceList = that.lastActivePriceList;
        this.lastActiveProduct = that.lastActiveProduct;
        this.lastActiveProductCategory = that.lastActiveProductCategory;
        this.sourceType = that.sourceType;
        this.state = that.state;
        this.updatedDate = that.updatedDate;
    }
    protected EntitlementImp(final EntitlementImp.Builder<?> builder) {
        this.accountId = builder.accountId;
        this.baseEntitlementId = builder.baseEntitlementId;
        this.billCycleDayLocal = builder.billCycleDayLocal;
        this.bundleExternalKey = builder.bundleExternalKey;
        this.bundleId = builder.bundleId;
        this.createdDate = builder.createdDate;
        this.effectiveEndDate = builder.effectiveEndDate;
        this.effectiveStartDate = builder.effectiveStartDate;
        this.externalKey = builder.externalKey;
        this.id = builder.id;
        this.lastActivePhase = builder.lastActivePhase;
        this.lastActivePlan = builder.lastActivePlan;
        this.lastActivePriceList = builder.lastActivePriceList;
        this.lastActiveProduct = builder.lastActiveProduct;
        this.lastActiveProductCategory = builder.lastActiveProductCategory;
        this.sourceType = builder.sourceType;
        this.state = builder.state;
        this.updatedDate = builder.updatedDate;
    }
    protected EntitlementImp() { }
    @Override
    public UUID getAccountId() {
        return this.accountId;
    }
    @Override
    public UUID getBaseEntitlementId() {
        return this.baseEntitlementId;
    }
    @Override
    public Integer getBillCycleDayLocal() {
        return this.billCycleDayLocal;
    }
    @Override
    public String getBundleExternalKey() {
        return this.bundleExternalKey;
    }
    @Override
    public UUID getBundleId() {
        return this.bundleId;
    }
    @Override
    public DateTime getCreatedDate() {
        return this.createdDate;
    }
    @Override
    public LocalDate getEffectiveEndDate() {
        return this.effectiveEndDate;
    }
    @Override
    public LocalDate getEffectiveStartDate() {
        return this.effectiveStartDate;
    }
    @Override
    public String getExternalKey() {
        return this.externalKey;
    }
    @Override
    public UUID getId() {
        return this.id;
    }
    @Override
    public PlanPhase getLastActivePhase() {
        return this.lastActivePhase;
    }
    @Override
    public Plan getLastActivePlan() {
        return this.lastActivePlan;
    }
    @Override
    public PriceList getLastActivePriceList() {
        return this.lastActivePriceList;
    }
    @Override
    public Product getLastActiveProduct() {
        return this.lastActiveProduct;
    }
    @Override
    public ProductCategory getLastActiveProductCategory() {
        return this.lastActiveProductCategory;
    }
    @Override
    public Entitlement.EntitlementSourceType getSourceType() {
        return this.sourceType;
    }
    @Override
    public Entitlement.EntitlementState getState() {
        return this.state;
    }
    @Override
    public DateTime getUpdatedDate() {
        return this.updatedDate;
    }
    @Override
    public void uncancelEntitlement(final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("uncancelEntitlement(java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Entitlement changePlanOverrideBillingPolicy(final EntitlementSpecifier spec, final LocalDate effectiveDate, final BillingActionPolicy billingPolicy, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("changePlanOverrideBillingPolicy(org.killbill.billing.entitlement.api.EntitlementSpecifier, org.joda.time.LocalDate, org.killbill.billing.catalog.api.BillingActionPolicy, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Entitlement changePlan(final EntitlementSpecifier spec, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("changePlan(org.killbill.billing.entitlement.api.EntitlementSpecifier, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public void undoChangePlan(final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("undoChangePlan(java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Entitlement cancelEntitlementWithPolicyOverrideBillingPolicy(final Entitlement.EntitlementActionPolicy policy, final BillingActionPolicy billingPolicy, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("cancelEntitlementWithPolicyOverrideBillingPolicy(org.killbill.billing.entitlement.api.Entitlement.EntitlementActionPolicy, org.killbill.billing.catalog.api.BillingActionPolicy, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Entitlement cancelEntitlementWithDate(final LocalDate effectiveDate, final boolean overrideBillingEffectiveDate, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("cancelEntitlementWithDate(org.joda.time.LocalDate, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Entitlement cancelEntitlementWithPolicy(final Entitlement.EntitlementActionPolicy policy, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("cancelEntitlementWithPolicy(org.killbill.billing.entitlement.api.Entitlement.EntitlementActionPolicy, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Entitlement cancelEntitlementWithDateOverrideBillingPolicy(final LocalDate effectiveDate, final BillingActionPolicy billingPolicy, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("cancelEntitlementWithDateOverrideBillingPolicy(org.joda.time.LocalDate, org.killbill.billing.catalog.api.BillingActionPolicy, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public void updateBCD(final int bcd, final LocalDate effectiveFromDate, final CallContext context) {
        throw new UnsupportedOperationException("updateBCD(int, org.joda.time.LocalDate, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Entitlement changePlanWithDate(final EntitlementSpecifier spec, final LocalDate effectiveDate, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("changePlanWithDate(org.killbill.billing.entitlement.api.EntitlementSpecifier, org.joda.time.LocalDate, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final EntitlementImp that = (EntitlementImp) o;
        if( !Objects.equals(this.accountId, that.accountId) ) {
            return false;
        }
        if( !Objects.equals(this.baseEntitlementId, that.baseEntitlementId) ) {
            return false;
        }
        if( !Objects.equals(this.billCycleDayLocal, that.billCycleDayLocal) ) {
            return false;
        }
        if( !Objects.equals(this.bundleExternalKey, that.bundleExternalKey) ) {
            return false;
        }
        if( !Objects.equals(this.bundleId, that.bundleId) ) {
            return false;
        }
        if( ( this.createdDate != null ) ? ( 0 != this.createdDate.compareTo(that.createdDate) ) : ( that.createdDate != null ) ) {
            return false;
        }
        if( ( this.effectiveEndDate != null ) ? ( 0 != this.effectiveEndDate.compareTo(that.effectiveEndDate) ) : ( that.effectiveEndDate != null ) ) {
            return false;
        }
        if( ( this.effectiveStartDate != null ) ? ( 0 != this.effectiveStartDate.compareTo(that.effectiveStartDate) ) : ( that.effectiveStartDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.externalKey, that.externalKey) ) {
            return false;
        }
        if( !Objects.equals(this.id, that.id) ) {
            return false;
        }
        if( !Objects.equals(this.lastActivePhase, that.lastActivePhase) ) {
            return false;
        }
        if( !Objects.equals(this.lastActivePlan, that.lastActivePlan) ) {
            return false;
        }
        if( !Objects.equals(this.lastActivePriceList, that.lastActivePriceList) ) {
            return false;
        }
        if( !Objects.equals(this.lastActiveProduct, that.lastActiveProduct) ) {
            return false;
        }
        if( !Objects.equals(this.lastActiveProductCategory, that.lastActiveProductCategory) ) {
            return false;
        }
        if( !Objects.equals(this.sourceType, that.sourceType) ) {
            return false;
        }
        if( !Objects.equals(this.state, that.state) ) {
            return false;
        }
        if( ( this.updatedDate != null ) ? ( 0 != this.updatedDate.compareTo(that.updatedDate) ) : ( that.updatedDate != null ) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.accountId);
        result = ( 31 * result ) + Objects.hashCode(this.baseEntitlementId);
        result = ( 31 * result ) + Objects.hashCode(this.billCycleDayLocal);
        result = ( 31 * result ) + Objects.hashCode(this.bundleExternalKey);
        result = ( 31 * result ) + Objects.hashCode(this.bundleId);
        result = ( 31 * result ) + Objects.hashCode(this.createdDate);
        result = ( 31 * result ) + Objects.hashCode(this.effectiveEndDate);
        result = ( 31 * result ) + Objects.hashCode(this.effectiveStartDate);
        result = ( 31 * result ) + Objects.hashCode(this.externalKey);
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.lastActivePhase);
        result = ( 31 * result ) + Objects.hashCode(this.lastActivePlan);
        result = ( 31 * result ) + Objects.hashCode(this.lastActivePriceList);
        result = ( 31 * result ) + Objects.hashCode(this.lastActiveProduct);
        result = ( 31 * result ) + Objects.hashCode(this.lastActiveProductCategory);
        result = ( 31 * result ) + Objects.hashCode(this.sourceType);
        result = ( 31 * result ) + Objects.hashCode(this.state);
        result = ( 31 * result ) + Objects.hashCode(this.updatedDate);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("accountId=").append(this.accountId);
        sb.append(", ");
        sb.append("baseEntitlementId=").append(this.baseEntitlementId);
        sb.append(", ");
        sb.append("billCycleDayLocal=").append(this.billCycleDayLocal);
        sb.append(", ");
        sb.append("bundleExternalKey=");
        if( this.bundleExternalKey == null ) {
            sb.append(this.bundleExternalKey);
        }else{
            sb.append("'").append(this.bundleExternalKey).append("'");
        }
        sb.append(", ");
        sb.append("bundleId=").append(this.bundleId);
        sb.append(", ");
        sb.append("createdDate=").append(this.createdDate);
        sb.append(", ");
        sb.append("effectiveEndDate=").append(this.effectiveEndDate);
        sb.append(", ");
        sb.append("effectiveStartDate=").append(this.effectiveStartDate);
        sb.append(", ");
        sb.append("externalKey=");
        if( this.externalKey == null ) {
            sb.append(this.externalKey);
        }else{
            sb.append("'").append(this.externalKey).append("'");
        }
        sb.append(", ");
        sb.append("id=").append(this.id);
        sb.append(", ");
        sb.append("lastActivePhase=").append(this.lastActivePhase);
        sb.append(", ");
        sb.append("lastActivePlan=").append(this.lastActivePlan);
        sb.append(", ");
        sb.append("lastActivePriceList=").append(this.lastActivePriceList);
        sb.append(", ");
        sb.append("lastActiveProduct=").append(this.lastActiveProduct);
        sb.append(", ");
        sb.append("lastActiveProductCategory=").append(this.lastActiveProductCategory);
        sb.append(", ");
        sb.append("sourceType=").append(this.sourceType);
        sb.append(", ");
        sb.append("state=").append(this.state);
        sb.append(", ");
        sb.append("updatedDate=").append(this.updatedDate);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends EntitlementImp.Builder<T>> {

        protected UUID accountId;
        protected UUID baseEntitlementId;
        protected Integer billCycleDayLocal;
        protected String bundleExternalKey;
        protected UUID bundleId;
        protected DateTime createdDate;
        protected LocalDate effectiveEndDate;
        protected LocalDate effectiveStartDate;
        protected String externalKey;
        protected UUID id;
        protected PlanPhase lastActivePhase;
        protected Plan lastActivePlan;
        protected PriceList lastActivePriceList;
        protected Product lastActiveProduct;
        protected ProductCategory lastActiveProductCategory;
        protected Entitlement.EntitlementSourceType sourceType;
        protected Entitlement.EntitlementState state;
        protected DateTime updatedDate;

        public Builder() { }
        public Builder(final Builder that) {
            this.accountId = that.accountId;
            this.baseEntitlementId = that.baseEntitlementId;
            this.billCycleDayLocal = that.billCycleDayLocal;
            this.bundleExternalKey = that.bundleExternalKey;
            this.bundleId = that.bundleId;
            this.createdDate = that.createdDate;
            this.effectiveEndDate = that.effectiveEndDate;
            this.effectiveStartDate = that.effectiveStartDate;
            this.externalKey = that.externalKey;
            this.id = that.id;
            this.lastActivePhase = that.lastActivePhase;
            this.lastActivePlan = that.lastActivePlan;
            this.lastActivePriceList = that.lastActivePriceList;
            this.lastActiveProduct = that.lastActiveProduct;
            this.lastActiveProductCategory = that.lastActiveProductCategory;
            this.sourceType = that.sourceType;
            this.state = that.state;
            this.updatedDate = that.updatedDate;
        }
        public T withAccountId(final UUID accountId) {
            this.accountId = accountId;
            return (T) this;
        }
        public T withBaseEntitlementId(final UUID baseEntitlementId) {
            this.baseEntitlementId = baseEntitlementId;
            return (T) this;
        }
        public T withBillCycleDayLocal(final Integer billCycleDayLocal) {
            this.billCycleDayLocal = billCycleDayLocal;
            return (T) this;
        }
        public T withBundleExternalKey(final String bundleExternalKey) {
            this.bundleExternalKey = bundleExternalKey;
            return (T) this;
        }
        public T withBundleId(final UUID bundleId) {
            this.bundleId = bundleId;
            return (T) this;
        }
        public T withCreatedDate(final DateTime createdDate) {
            this.createdDate = createdDate;
            return (T) this;
        }
        public T withEffectiveEndDate(final LocalDate effectiveEndDate) {
            this.effectiveEndDate = effectiveEndDate;
            return (T) this;
        }
        public T withEffectiveStartDate(final LocalDate effectiveStartDate) {
            this.effectiveStartDate = effectiveStartDate;
            return (T) this;
        }
        public T withExternalKey(final String externalKey) {
            this.externalKey = externalKey;
            return (T) this;
        }
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withLastActivePhase(final PlanPhase lastActivePhase) {
            this.lastActivePhase = lastActivePhase;
            return (T) this;
        }
        public T withLastActivePlan(final Plan lastActivePlan) {
            this.lastActivePlan = lastActivePlan;
            return (T) this;
        }
        public T withLastActivePriceList(final PriceList lastActivePriceList) {
            this.lastActivePriceList = lastActivePriceList;
            return (T) this;
        }
        public T withLastActiveProduct(final Product lastActiveProduct) {
            this.lastActiveProduct = lastActiveProduct;
            return (T) this;
        }
        public T withLastActiveProductCategory(final ProductCategory lastActiveProductCategory) {
            this.lastActiveProductCategory = lastActiveProductCategory;
            return (T) this;
        }
        public T withSourceType(final Entitlement.EntitlementSourceType sourceType) {
            this.sourceType = sourceType;
            return (T) this;
        }
        public T withState(final Entitlement.EntitlementState state) {
            this.state = state;
            return (T) this;
        }
        public T withUpdatedDate(final DateTime updatedDate) {
            this.updatedDate = updatedDate;
            return (T) this;
        }
        public T source(final Entitlement that) {
            this.accountId = that.getAccountId();
            this.baseEntitlementId = that.getBaseEntitlementId();
            this.billCycleDayLocal = that.getBillCycleDayLocal();
            this.bundleExternalKey = that.getBundleExternalKey();
            this.bundleId = that.getBundleId();
            this.createdDate = that.getCreatedDate();
            this.effectiveEndDate = that.getEffectiveEndDate();
            this.effectiveStartDate = that.getEffectiveStartDate();
            this.externalKey = that.getExternalKey();
            this.id = that.getId();
            this.lastActivePhase = that.getLastActivePhase();
            this.lastActivePlan = that.getLastActivePlan();
            this.lastActivePriceList = that.getLastActivePriceList();
            this.lastActiveProduct = that.getLastActiveProduct();
            this.lastActiveProductCategory = that.getLastActiveProductCategory();
            this.sourceType = that.getSourceType();
            this.state = that.getState();
            this.updatedDate = that.getUpdatedDate();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public EntitlementImp build() {
            return new EntitlementImp(this.validate());
        }
    }
}
