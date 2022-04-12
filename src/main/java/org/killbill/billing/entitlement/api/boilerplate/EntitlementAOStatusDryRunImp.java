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
import org.killbill.billing.catalog.api.BillingPeriod;
import org.killbill.billing.catalog.api.PhaseType;
import org.killbill.billing.entitlement.api.EntitlementAOStatusDryRun;

@JsonDeserialize( builder = EntitlementAOStatusDryRunImp.Builder.class )
public class EntitlementAOStatusDryRunImp implements EntitlementAOStatusDryRun, Serializable {

    private static final long serialVersionUID = 0xFA53649A6CD7E597L;

    protected BillingPeriod billingPeriod;
    protected UUID id;
    protected PhaseType phaseType;
    protected String priceList;
    protected String productName;
    protected EntitlementAOStatusDryRun.DryRunChangeReason reason;

    public EntitlementAOStatusDryRunImp(final EntitlementAOStatusDryRunImp that) {
        this.billingPeriod = that.billingPeriod;
        this.id = that.id;
        this.phaseType = that.phaseType;
        this.priceList = that.priceList;
        this.productName = that.productName;
        this.reason = that.reason;
    }
    protected EntitlementAOStatusDryRunImp(final EntitlementAOStatusDryRunImp.Builder<?> builder) {
        this.billingPeriod = builder.billingPeriod;
        this.id = builder.id;
        this.phaseType = builder.phaseType;
        this.priceList = builder.priceList;
        this.productName = builder.productName;
        this.reason = builder.reason;
    }
    protected EntitlementAOStatusDryRunImp() { }
    @Override
    public BillingPeriod getBillingPeriod() {
        return this.billingPeriod;
    }
    @Override
    public UUID getId() {
        return this.id;
    }
    @Override
    public PhaseType getPhaseType() {
        return this.phaseType;
    }
    @Override
    public String getPriceList() {
        return this.priceList;
    }
    @Override
    public String getProductName() {
        return this.productName;
    }
    @Override
    public EntitlementAOStatusDryRun.DryRunChangeReason getReason() {
        return this.reason;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final EntitlementAOStatusDryRunImp that = (EntitlementAOStatusDryRunImp) o;
        if( !Objects.equals(this.billingPeriod, that.billingPeriod) ) {
            return false;
        }
        if( !Objects.equals(this.id, that.id) ) {
            return false;
        }
        if( !Objects.equals(this.phaseType, that.phaseType) ) {
            return false;
        }
        if( !Objects.equals(this.priceList, that.priceList) ) {
            return false;
        }
        if( !Objects.equals(this.productName, that.productName) ) {
            return false;
        }
        if( !Objects.equals(this.reason, that.reason) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.billingPeriod);
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.phaseType);
        result = ( 31 * result ) + Objects.hashCode(this.priceList);
        result = ( 31 * result ) + Objects.hashCode(this.productName);
        result = ( 31 * result ) + Objects.hashCode(this.reason);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("billingPeriod=").append(this.billingPeriod);
        sb.append(", ");
        sb.append("id=").append(this.id);
        sb.append(", ");
        sb.append("phaseType=").append(this.phaseType);
        sb.append(", ");
        sb.append("priceList=");
        if( this.priceList == null ) {
            sb.append(this.priceList);
        }else{
            sb.append("'").append(this.priceList).append("'");
        }
        sb.append(", ");
        sb.append("productName=");
        if( this.productName == null ) {
            sb.append(this.productName);
        }else{
            sb.append("'").append(this.productName).append("'");
        }
        sb.append(", ");
        sb.append("reason=").append(this.reason);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends EntitlementAOStatusDryRunImp.Builder<T>> {

        protected BillingPeriod billingPeriod;
        protected UUID id;
        protected PhaseType phaseType;
        protected String priceList;
        protected String productName;
        protected EntitlementAOStatusDryRun.DryRunChangeReason reason;

        public Builder() { }
        public Builder(final Builder that) {
            this.billingPeriod = that.billingPeriod;
            this.id = that.id;
            this.phaseType = that.phaseType;
            this.priceList = that.priceList;
            this.productName = that.productName;
            this.reason = that.reason;
        }
        public T withBillingPeriod(final BillingPeriod billingPeriod) {
            this.billingPeriod = billingPeriod;
            return (T) this;
        }
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withPhaseType(final PhaseType phaseType) {
            this.phaseType = phaseType;
            return (T) this;
        }
        public T withPriceList(final String priceList) {
            this.priceList = priceList;
            return (T) this;
        }
        public T withProductName(final String productName) {
            this.productName = productName;
            return (T) this;
        }
        public T withReason(final EntitlementAOStatusDryRun.DryRunChangeReason reason) {
            this.reason = reason;
            return (T) this;
        }
        public T source(final EntitlementAOStatusDryRun that) {
            this.billingPeriod = that.getBillingPeriod();
            this.id = that.getId();
            this.phaseType = that.getPhaseType();
            this.priceList = that.getPriceList();
            this.productName = that.getProductName();
            this.reason = that.getReason();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public EntitlementAOStatusDryRunImp build() {
            return new EntitlementAOStatusDryRunImp(this.validate());
        }
    }
}
