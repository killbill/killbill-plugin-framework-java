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
import java.util.List;
import java.util.Objects;
import org.killbill.billing.catalog.api.PlanPhasePriceOverride;
import org.killbill.billing.catalog.api.PlanPhaseSpecifier;
import org.killbill.billing.entitlement.api.EntitlementSpecifier;

@JsonDeserialize( builder = EntitlementSpecifierImp.Builder.class )
public class EntitlementSpecifierImp implements EntitlementSpecifier {

    private static final long serialVersionUID = 0x2216884C686BC006L;

    protected Integer billCycleDay;
    protected String externalKey;
    protected List<PlanPhasePriceOverride> overrides;
    protected PlanPhaseSpecifier planPhaseSpecifier;

    public EntitlementSpecifierImp(final EntitlementSpecifierImp that) {
        this.billCycleDay = that.billCycleDay;
        this.externalKey = that.externalKey;
        this.overrides = that.overrides;
        this.planPhaseSpecifier = that.planPhaseSpecifier;
    }
    protected EntitlementSpecifierImp(final EntitlementSpecifierImp.Builder<?> builder) {
        this.billCycleDay = builder.billCycleDay;
        this.externalKey = builder.externalKey;
        this.overrides = builder.overrides;
        this.planPhaseSpecifier = builder.planPhaseSpecifier;
    }
    protected EntitlementSpecifierImp() { }
    @Override
    public Integer getBillCycleDay() {
        return this.billCycleDay;
    }
    @Override
    public String getExternalKey() {
        return this.externalKey;
    }
    @Override
    public List<PlanPhasePriceOverride> getOverrides() {
        return this.overrides;
    }
    @Override
    public PlanPhaseSpecifier getPlanPhaseSpecifier() {
        return this.planPhaseSpecifier;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final EntitlementSpecifierImp that = (EntitlementSpecifierImp) o;
        if( !Objects.equals(this.billCycleDay, that.billCycleDay) ) {
            return false;
        }
        if( !Objects.equals(this.externalKey, that.externalKey) ) {
            return false;
        }
        if( !Objects.equals(this.overrides, that.overrides) ) {
            return false;
        }
        if( !Objects.equals(this.planPhaseSpecifier, that.planPhaseSpecifier) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.billCycleDay);
        result = ( 31 * result ) + Objects.hashCode(this.externalKey);
        result = ( 31 * result ) + Objects.hashCode(this.overrides);
        result = ( 31 * result ) + Objects.hashCode(this.planPhaseSpecifier);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("billCycleDay=").append(this.billCycleDay);
        sb.append(", ");
        sb.append("externalKey=");
        if( this.externalKey == null ) {
            sb.append(this.externalKey);
        }else{
            sb.append("'").append(this.externalKey).append("'");
        }
        sb.append(", ");
        sb.append("overrides=").append(this.overrides);
        sb.append(", ");
        sb.append("planPhaseSpecifier=").append(this.planPhaseSpecifier);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends EntitlementSpecifierImp.Builder<T>> {

        protected Integer billCycleDay;
        protected String externalKey;
        protected List<PlanPhasePriceOverride> overrides;
        protected PlanPhaseSpecifier planPhaseSpecifier;

        public Builder() { }
        public Builder(final Builder that) {
            this.billCycleDay = that.billCycleDay;
            this.externalKey = that.externalKey;
            this.overrides = that.overrides;
            this.planPhaseSpecifier = that.planPhaseSpecifier;
        }
        public T withBillCycleDay(final Integer billCycleDay) {
            this.billCycleDay = billCycleDay;
            return (T) this;
        }
        public T withExternalKey(final String externalKey) {
            this.externalKey = externalKey;
            return (T) this;
        }
        public T withOverrides(final List<PlanPhasePriceOverride> overrides) {
            this.overrides = overrides;
            return (T) this;
        }
        public T withPlanPhaseSpecifier(final PlanPhaseSpecifier planPhaseSpecifier) {
            this.planPhaseSpecifier = planPhaseSpecifier;
            return (T) this;
        }
        public T source(final EntitlementSpecifier that) {
            this.billCycleDay = that.getBillCycleDay();
            this.externalKey = that.getExternalKey();
            this.overrides = that.getOverrides();
            this.planPhaseSpecifier = that.getPlanPhaseSpecifier();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public EntitlementSpecifierImp build() {
            return new EntitlementSpecifierImp(this.validate());
        }
    }
}
