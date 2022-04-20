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
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.catalog.api.PlanPhasePriceOverride;
import org.killbill.billing.catalog.api.PlanPhaseSpecifier;
import org.killbill.billing.catalog.api.UsagePriceOverride;

@JsonDeserialize( builder = PlanPhasePriceOverrideImp.Builder.class )
public class PlanPhasePriceOverrideImp implements PlanPhasePriceOverride {

    private static final long serialVersionUID = 0x7AAF7FEE20AC0469L;

    protected Currency currency;
    protected BigDecimal fixedPrice;
    protected String phaseName;
    protected PlanPhaseSpecifier planPhaseSpecifier;
    protected BigDecimal recurringPrice;
    protected List<UsagePriceOverride> usagePriceOverrides;

    public PlanPhasePriceOverrideImp(final PlanPhasePriceOverrideImp that) {
        this.currency = that.currency;
        this.fixedPrice = that.fixedPrice;
        this.phaseName = that.phaseName;
        this.planPhaseSpecifier = that.planPhaseSpecifier;
        this.recurringPrice = that.recurringPrice;
        this.usagePriceOverrides = that.usagePriceOverrides;
    }
    protected PlanPhasePriceOverrideImp(final PlanPhasePriceOverrideImp.Builder<?> builder) {
        this.currency = builder.currency;
        this.fixedPrice = builder.fixedPrice;
        this.phaseName = builder.phaseName;
        this.planPhaseSpecifier = builder.planPhaseSpecifier;
        this.recurringPrice = builder.recurringPrice;
        this.usagePriceOverrides = builder.usagePriceOverrides;
    }
    protected PlanPhasePriceOverrideImp() { }
    @Override
    public Currency getCurrency() {
        return this.currency;
    }
    @Override
    public BigDecimal getFixedPrice() {
        return this.fixedPrice;
    }
    @Override
    public String getPhaseName() {
        return this.phaseName;
    }
    @Override
    public PlanPhaseSpecifier getPlanPhaseSpecifier() {
        return this.planPhaseSpecifier;
    }
    @Override
    public BigDecimal getRecurringPrice() {
        return this.recurringPrice;
    }
    @Override
    public List<UsagePriceOverride> getUsagePriceOverrides() {
        return this.usagePriceOverrides;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PlanPhasePriceOverrideImp that = (PlanPhasePriceOverrideImp) o;
        if( !Objects.equals(this.currency, that.currency) ) {
            return false;
        }
        if( ( this.fixedPrice != null ) ? ( 0 != this.fixedPrice.compareTo(that.fixedPrice) ) : ( that.fixedPrice != null ) ) {
            return false;
        }
        if( !Objects.equals(this.phaseName, that.phaseName) ) {
            return false;
        }
        if( !Objects.equals(this.planPhaseSpecifier, that.planPhaseSpecifier) ) {
            return false;
        }
        if( ( this.recurringPrice != null ) ? ( 0 != this.recurringPrice.compareTo(that.recurringPrice) ) : ( that.recurringPrice != null ) ) {
            return false;
        }
        if( !Objects.equals(this.usagePriceOverrides, that.usagePriceOverrides) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.currency);
        result = ( 31 * result ) + Objects.hashCode(this.fixedPrice);
        result = ( 31 * result ) + Objects.hashCode(this.phaseName);
        result = ( 31 * result ) + Objects.hashCode(this.planPhaseSpecifier);
        result = ( 31 * result ) + Objects.hashCode(this.recurringPrice);
        result = ( 31 * result ) + Objects.hashCode(this.usagePriceOverrides);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("currency=").append(this.currency);
        sb.append(", ");
        sb.append("fixedPrice=").append(this.fixedPrice);
        sb.append(", ");
        sb.append("phaseName=");
        if( this.phaseName == null ) {
            sb.append(this.phaseName);
        }else{
            sb.append("'").append(this.phaseName).append("'");
        }
        sb.append(", ");
        sb.append("planPhaseSpecifier=").append(this.planPhaseSpecifier);
        sb.append(", ");
        sb.append("recurringPrice=").append(this.recurringPrice);
        sb.append(", ");
        sb.append("usagePriceOverrides=").append(this.usagePriceOverrides);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PlanPhasePriceOverrideImp.Builder<T>> {

        protected Currency currency;
        protected BigDecimal fixedPrice;
        protected String phaseName;
        protected PlanPhaseSpecifier planPhaseSpecifier;
        protected BigDecimal recurringPrice;
        protected List<UsagePriceOverride> usagePriceOverrides;

        public Builder() { }
        public Builder(final Builder that) {
            this.currency = that.currency;
            this.fixedPrice = that.fixedPrice;
            this.phaseName = that.phaseName;
            this.planPhaseSpecifier = that.planPhaseSpecifier;
            this.recurringPrice = that.recurringPrice;
            this.usagePriceOverrides = that.usagePriceOverrides;
        }
        public T withCurrency(final Currency currency) {
            this.currency = currency;
            return (T) this;
        }
        public T withFixedPrice(final BigDecimal fixedPrice) {
            this.fixedPrice = fixedPrice;
            return (T) this;
        }
        public T withPhaseName(final String phaseName) {
            this.phaseName = phaseName;
            return (T) this;
        }
        public T withPlanPhaseSpecifier(final PlanPhaseSpecifier planPhaseSpecifier) {
            this.planPhaseSpecifier = planPhaseSpecifier;
            return (T) this;
        }
        public T withRecurringPrice(final BigDecimal recurringPrice) {
            this.recurringPrice = recurringPrice;
            return (T) this;
        }
        public T withUsagePriceOverrides(final List<UsagePriceOverride> usagePriceOverrides) {
            this.usagePriceOverrides = usagePriceOverrides;
            return (T) this;
        }
        public T source(final PlanPhasePriceOverride that) {
            this.currency = that.getCurrency();
            this.fixedPrice = that.getFixedPrice();
            this.phaseName = that.getPhaseName();
            this.planPhaseSpecifier = that.getPlanPhaseSpecifier();
            this.recurringPrice = that.getRecurringPrice();
            this.usagePriceOverrides = that.getUsagePriceOverrides();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PlanPhasePriceOverrideImp build() {
            return new PlanPhasePriceOverrideImp(this.validate());
        }
    }
}
