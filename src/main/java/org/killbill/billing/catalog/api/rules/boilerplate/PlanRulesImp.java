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

package org.killbill.billing.catalog.api.rules.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import org.killbill.billing.catalog.api.BillingActionPolicy;
import org.killbill.billing.catalog.api.BillingAlignment;
import org.killbill.billing.catalog.api.CatalogApiException;
import org.killbill.billing.catalog.api.PlanAlignmentCreate;
import org.killbill.billing.catalog.api.PlanChangeResult;
import org.killbill.billing.catalog.api.PlanPhaseSpecifier;
import org.killbill.billing.catalog.api.PlanSpecifier;
import org.killbill.billing.catalog.api.StaticCatalog;
import org.killbill.billing.catalog.api.rules.CaseBillingAlignment;
import org.killbill.billing.catalog.api.rules.CaseCancelPolicy;
import org.killbill.billing.catalog.api.rules.CaseChangePlanAlignment;
import org.killbill.billing.catalog.api.rules.CaseChangePlanPolicy;
import org.killbill.billing.catalog.api.rules.CaseCreateAlignment;
import org.killbill.billing.catalog.api.rules.CasePriceList;
import org.killbill.billing.catalog.api.rules.PlanRules;

@JsonDeserialize( builder = PlanRulesImp.Builder.class )
public class PlanRulesImp implements PlanRules {

    private static final long serialVersionUID = 0x56422BAD281B1B82L;

    protected Iterable<CaseBillingAlignment> caseBillingAlignment;
    protected Iterable<CaseCancelPolicy> caseCancelPolicy;
    protected Iterable<CaseChangePlanAlignment> caseChangePlanAlignment;
    protected Iterable<CaseChangePlanPolicy> caseChangePlanPolicy;
    protected Iterable<CaseCreateAlignment> caseCreateAlignment;
    protected Iterable<CasePriceList> casePriceList;
    protected StaticCatalog catalog;

    public PlanRulesImp(final PlanRulesImp that) {
        this.caseBillingAlignment = that.caseBillingAlignment;
        this.caseCancelPolicy = that.caseCancelPolicy;
        this.caseChangePlanAlignment = that.caseChangePlanAlignment;
        this.caseChangePlanPolicy = that.caseChangePlanPolicy;
        this.caseCreateAlignment = that.caseCreateAlignment;
        this.casePriceList = that.casePriceList;
        this.catalog = that.catalog;
    }
    protected PlanRulesImp(final PlanRulesImp.Builder<?> builder) {
        this.caseBillingAlignment = builder.caseBillingAlignment;
        this.caseCancelPolicy = builder.caseCancelPolicy;
        this.caseChangePlanAlignment = builder.caseChangePlanAlignment;
        this.caseChangePlanPolicy = builder.caseChangePlanPolicy;
        this.caseCreateAlignment = builder.caseCreateAlignment;
        this.casePriceList = builder.casePriceList;
        this.catalog = builder.catalog;
    }
    protected PlanRulesImp() { }
    @Override
    public Iterable<CaseBillingAlignment> getCaseBillingAlignment() {
        return this.caseBillingAlignment;
    }
    @Override
    public Iterable<CaseCancelPolicy> getCaseCancelPolicy() {
        return this.caseCancelPolicy;
    }
    @Override
    public Iterable<CaseChangePlanAlignment> getCaseChangePlanAlignment() {
        return this.caseChangePlanAlignment;
    }
    @Override
    public Iterable<CaseChangePlanPolicy> getCaseChangePlanPolicy() {
        return this.caseChangePlanPolicy;
    }
    @Override
    public Iterable<CaseCreateAlignment> getCaseCreateAlignment() {
        return this.caseCreateAlignment;
    }
    @Override
    public Iterable<CasePriceList> getCasePriceList() {
        return this.casePriceList;
    }
    @Override
    public StaticCatalog getCatalog() {
        return this.catalog;
    }
    @Override
    public PlanAlignmentCreate getPlanCreateAlignment(final PlanSpecifier specifier) {
        throw new UnsupportedOperationException("getPlanCreateAlignment(org.killbill.billing.catalog.api.PlanSpecifier) must be implemented.");
    }
    @Override
    public BillingAlignment getBillingAlignment(final PlanPhaseSpecifier planPhase) {
        throw new UnsupportedOperationException("getBillingAlignment(org.killbill.billing.catalog.api.PlanPhaseSpecifier) must be implemented.");
    }
    @Override
    public PlanChangeResult getPlanChangeResult(final PlanPhaseSpecifier from, final PlanSpecifier to) {
        throw new UnsupportedOperationException("getPlanChangeResult(org.killbill.billing.catalog.api.PlanPhaseSpecifier, org.killbill.billing.catalog.api.PlanSpecifier) must be implemented.");
    }
    @Override
    public BillingActionPolicy getPlanCancelPolicy(final PlanPhaseSpecifier planPhase) {
        throw new UnsupportedOperationException("getPlanCancelPolicy(org.killbill.billing.catalog.api.PlanPhaseSpecifier) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PlanRulesImp that = (PlanRulesImp) o;
        if( !Objects.equals(this.caseBillingAlignment, that.caseBillingAlignment) ) {
            return false;
        }
        if( !Objects.equals(this.caseCancelPolicy, that.caseCancelPolicy) ) {
            return false;
        }
        if( !Objects.equals(this.caseChangePlanAlignment, that.caseChangePlanAlignment) ) {
            return false;
        }
        if( !Objects.equals(this.caseChangePlanPolicy, that.caseChangePlanPolicy) ) {
            return false;
        }
        if( !Objects.equals(this.caseCreateAlignment, that.caseCreateAlignment) ) {
            return false;
        }
        if( !Objects.equals(this.casePriceList, that.casePriceList) ) {
            return false;
        }
        if( !Objects.equals(this.catalog, that.catalog) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.caseBillingAlignment);
        result = ( 31 * result ) + Objects.hashCode(this.caseCancelPolicy);
        result = ( 31 * result ) + Objects.hashCode(this.caseChangePlanAlignment);
        result = ( 31 * result ) + Objects.hashCode(this.caseChangePlanPolicy);
        result = ( 31 * result ) + Objects.hashCode(this.caseCreateAlignment);
        result = ( 31 * result ) + Objects.hashCode(this.casePriceList);
        result = ( 31 * result ) + Objects.hashCode(this.catalog);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("caseBillingAlignment=").append(this.caseBillingAlignment);
        sb.append(", ");
        sb.append("caseCancelPolicy=").append(this.caseCancelPolicy);
        sb.append(", ");
        sb.append("caseChangePlanAlignment=").append(this.caseChangePlanAlignment);
        sb.append(", ");
        sb.append("caseChangePlanPolicy=").append(this.caseChangePlanPolicy);
        sb.append(", ");
        sb.append("caseCreateAlignment=").append(this.caseCreateAlignment);
        sb.append(", ");
        sb.append("casePriceList=").append(this.casePriceList);
        sb.append(", ");
        sb.append("catalog=").append(this.catalog);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PlanRulesImp.Builder<T>> {

        protected Iterable<CaseBillingAlignment> caseBillingAlignment;
        protected Iterable<CaseCancelPolicy> caseCancelPolicy;
        protected Iterable<CaseChangePlanAlignment> caseChangePlanAlignment;
        protected Iterable<CaseChangePlanPolicy> caseChangePlanPolicy;
        protected Iterable<CaseCreateAlignment> caseCreateAlignment;
        protected Iterable<CasePriceList> casePriceList;
        protected StaticCatalog catalog;

        public Builder() { }
        public Builder(final Builder that) {
            this.caseBillingAlignment = that.caseBillingAlignment;
            this.caseCancelPolicy = that.caseCancelPolicy;
            this.caseChangePlanAlignment = that.caseChangePlanAlignment;
            this.caseChangePlanPolicy = that.caseChangePlanPolicy;
            this.caseCreateAlignment = that.caseCreateAlignment;
            this.casePriceList = that.casePriceList;
            this.catalog = that.catalog;
        }
        public T withCaseBillingAlignment(final Iterable<CaseBillingAlignment> caseBillingAlignment) {
            this.caseBillingAlignment = caseBillingAlignment;
            return (T) this;
        }
        public T withCaseCancelPolicy(final Iterable<CaseCancelPolicy> caseCancelPolicy) {
            this.caseCancelPolicy = caseCancelPolicy;
            return (T) this;
        }
        public T withCaseChangePlanAlignment(final Iterable<CaseChangePlanAlignment> caseChangePlanAlignment) {
            this.caseChangePlanAlignment = caseChangePlanAlignment;
            return (T) this;
        }
        public T withCaseChangePlanPolicy(final Iterable<CaseChangePlanPolicy> caseChangePlanPolicy) {
            this.caseChangePlanPolicy = caseChangePlanPolicy;
            return (T) this;
        }
        public T withCaseCreateAlignment(final Iterable<CaseCreateAlignment> caseCreateAlignment) {
            this.caseCreateAlignment = caseCreateAlignment;
            return (T) this;
        }
        public T withCasePriceList(final Iterable<CasePriceList> casePriceList) {
            this.casePriceList = casePriceList;
            return (T) this;
        }
        public T withCatalog(final StaticCatalog catalog) {
            this.catalog = catalog;
            return (T) this;
        }
        public T source(final PlanRules that) {
            this.caseBillingAlignment = that.getCaseBillingAlignment();
            this.caseCancelPolicy = that.getCaseCancelPolicy();
            this.caseChangePlanAlignment = that.getCaseChangePlanAlignment();
            this.caseChangePlanPolicy = that.getCaseChangePlanPolicy();
            this.caseCreateAlignment = that.getCaseCreateAlignment();
            this.casePriceList = that.getCasePriceList();
            this.catalog = that.getCatalog();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PlanRulesImp build() {
            return new PlanRulesImp(this.validate());
        }
    }
}
