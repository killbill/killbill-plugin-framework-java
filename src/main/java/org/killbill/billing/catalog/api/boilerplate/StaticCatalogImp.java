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
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.killbill.billing.catalog.api.CatalogApiException;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.catalog.api.Listing;
import org.killbill.billing.catalog.api.Plan;
import org.killbill.billing.catalog.api.PlanPhase;
import org.killbill.billing.catalog.api.PlanPhasePriceOverridesWithCallContext;
import org.killbill.billing.catalog.api.PlanSpecifier;
import org.killbill.billing.catalog.api.PriceList;
import org.killbill.billing.catalog.api.PriceListSet;
import org.killbill.billing.catalog.api.Product;
import org.killbill.billing.catalog.api.StaticCatalog;
import org.killbill.billing.catalog.api.Unit;
import org.killbill.billing.catalog.api.rules.PlanRules;

@JsonDeserialize( builder = StaticCatalogImp.Builder.class )
public class StaticCatalogImp implements StaticCatalog {

    private static final long serialVersionUID = 0xE722A02C87A2AC87L;

    protected List<Listing> availableBasePlanListings;
    protected String catalogName;
    protected Date effectiveDate;
    protected PlanRules planRules;
    protected Collection<Plan> plans;
    protected PriceListSet priceLists;
    protected Collection<Product> products;
    protected Currency[] supportedCurrencies;
    protected Unit[] units;

    public StaticCatalogImp(final StaticCatalogImp that) {
        this.availableBasePlanListings = that.availableBasePlanListings;
        this.catalogName = that.catalogName;
        this.effectiveDate = that.effectiveDate;
        this.planRules = that.planRules;
        this.plans = that.plans;
        this.priceLists = that.priceLists;
        this.products = that.products;
        this.supportedCurrencies = that.supportedCurrencies;
        this.units = that.units;
    }
    protected StaticCatalogImp(final StaticCatalogImp.Builder<?> builder) {
        this.availableBasePlanListings = builder.availableBasePlanListings;
        this.catalogName = builder.catalogName;
        this.effectiveDate = builder.effectiveDate;
        this.planRules = builder.planRules;
        this.plans = builder.plans;
        this.priceLists = builder.priceLists;
        this.products = builder.products;
        this.supportedCurrencies = builder.supportedCurrencies;
        this.units = builder.units;
    }
    protected StaticCatalogImp() { }
    @Override
    public List<Listing> getAvailableBasePlanListings() {
        return this.availableBasePlanListings;
    }
    @Override
    public String getCatalogName() {
        return this.catalogName;
    }
    @Override
    public Date getEffectiveDate() {
        return this.effectiveDate;
    }
    @Override
    public PlanRules getPlanRules() {
        return this.planRules;
    }
    @Override
    public Collection<Plan> getPlans() {
        return this.plans;
    }
    @Override
    public PriceListSet getPriceLists() {
        return this.priceLists;
    }
    @Override
    public Collection<Product> getProducts() {
        return this.products;
    }
    @Override
    public Currency[] getSupportedCurrencies() {
        return this.supportedCurrencies;
    }
    @Override
    public Unit[] getUnits() {
        return this.units;
    }
    @Override
    public Plan findPlan(final String name) {
        throw new UnsupportedOperationException("findPlan(java.lang.String) must be implemented.");
    }
    @Override
    public Plan createOrFindPlan(final PlanSpecifier spec, final PlanPhasePriceOverridesWithCallContext overrides) {
        throw new UnsupportedOperationException("createOrFindPlan(org.killbill.billing.catalog.api.PlanSpecifier, org.killbill.billing.catalog.api.PlanPhasePriceOverridesWithCallContext) must be implemented.");
    }
    @Override
    public List<Listing> getAvailableAddOnListings(final String baseProductName, final String priceListName) {
        throw new UnsupportedOperationException("getAvailableAddOnListings(java.lang.String, java.lang.String) must be implemented.");
    }
    @Override
    public PlanPhase findPhase(final String name) {
        throw new UnsupportedOperationException("findPhase(java.lang.String) must be implemented.");
    }
    @Override
    public Product findProduct(final String name) {
        throw new UnsupportedOperationException("findProduct(java.lang.String) must be implemented.");
    }
    @Override
    public PriceList findPriceList(final String name) {
        throw new UnsupportedOperationException("findPriceList(java.lang.String) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final StaticCatalogImp that = (StaticCatalogImp) o;
        if( !Objects.equals(this.availableBasePlanListings, that.availableBasePlanListings) ) {
            return false;
        }
        if( !Objects.equals(this.catalogName, that.catalogName) ) {
            return false;
        }
        if( !Objects.equals(this.effectiveDate, that.effectiveDate) ) {
            return false;
        }
        if( !Objects.equals(this.planRules, that.planRules) ) {
            return false;
        }
        if( !Objects.equals(this.plans, that.plans) ) {
            return false;
        }
        if( !Objects.equals(this.priceLists, that.priceLists) ) {
            return false;
        }
        if( !Objects.equals(this.products, that.products) ) {
            return false;
        }
        if( !Arrays.deepEquals(this.supportedCurrencies, that.supportedCurrencies) ) {
            return false;
        }
        if( !Arrays.deepEquals(this.units, that.units) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.availableBasePlanListings);
        result = ( 31 * result ) + Objects.hashCode(this.catalogName);
        result = ( 31 * result ) + Objects.hashCode(this.effectiveDate);
        result = ( 31 * result ) + Objects.hashCode(this.planRules);
        result = ( 31 * result ) + Objects.hashCode(this.plans);
        result = ( 31 * result ) + Objects.hashCode(this.priceLists);
        result = ( 31 * result ) + Objects.hashCode(this.products);
        result = ( 31 * result ) + Arrays.deepHashCode(this.supportedCurrencies);
        result = ( 31 * result ) + Arrays.deepHashCode(this.units);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("availableBasePlanListings=").append(this.availableBasePlanListings);
        sb.append(", ");
        sb.append("catalogName=");
        if( this.catalogName == null ) {
            sb.append(this.catalogName);
        }else{
            sb.append("'").append(this.catalogName).append("'");
        }
        sb.append(", ");
        sb.append("effectiveDate=").append(this.effectiveDate);
        sb.append(", ");
        sb.append("planRules=").append(this.planRules);
        sb.append(", ");
        sb.append("plans=").append(this.plans);
        sb.append(", ");
        sb.append("priceLists=").append(this.priceLists);
        sb.append(", ");
        sb.append("products=").append(this.products);
        sb.append(", ");
        sb.append("supportedCurrencies=").append(Arrays.toString(this.supportedCurrencies));
        sb.append(", ");
        sb.append("units=").append(Arrays.toString(this.units));
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends StaticCatalogImp.Builder<T>> {

        protected List<Listing> availableBasePlanListings;
        protected String catalogName;
        protected Date effectiveDate;
        protected PlanRules planRules;
        protected Collection<Plan> plans;
        protected PriceListSet priceLists;
        protected Collection<Product> products;
        protected Currency[] supportedCurrencies;
        protected Unit[] units;

        public Builder() { }
        public Builder(final Builder that) {
            this.availableBasePlanListings = that.availableBasePlanListings;
            this.catalogName = that.catalogName;
            this.effectiveDate = that.effectiveDate;
            this.planRules = that.planRules;
            this.plans = that.plans;
            this.priceLists = that.priceLists;
            this.products = that.products;
            this.supportedCurrencies = that.supportedCurrencies;
            this.units = that.units;
        }
        public T withAvailableBasePlanListings(final List<Listing> availableBasePlanListings) {
            this.availableBasePlanListings = availableBasePlanListings;
            return (T) this;
        }
        public T withCatalogName(final String catalogName) {
            this.catalogName = catalogName;
            return (T) this;
        }
        public T withEffectiveDate(final Date effectiveDate) {
            this.effectiveDate = effectiveDate;
            return (T) this;
        }
        public T withPlanRules(final PlanRules planRules) {
            this.planRules = planRules;
            return (T) this;
        }
        public T withPlans(final Collection<Plan> plans) {
            this.plans = plans;
            return (T) this;
        }
        public T withPriceLists(final PriceListSet priceLists) {
            this.priceLists = priceLists;
            return (T) this;
        }
        public T withProducts(final Collection<Product> products) {
            this.products = products;
            return (T) this;
        }
        public T withSupportedCurrencies(final Currency[] supportedCurrencies) {
            this.supportedCurrencies = supportedCurrencies;
            return (T) this;
        }
        public T withUnits(final Unit[] units) {
            this.units = units;
            return (T) this;
        }
        public T source(final StaticCatalog that) throws CatalogApiException {
            this.availableBasePlanListings = that.getAvailableBasePlanListings();
            this.catalogName = that.getCatalogName();
            this.effectiveDate = that.getEffectiveDate();
            this.planRules = that.getPlanRules();
            this.plans = that.getPlans();
            this.priceLists = that.getPriceLists();
            this.products = that.getProducts();
            this.supportedCurrencies = that.getSupportedCurrencies();
            this.units = that.getUnits();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public StaticCatalogImp build() {
            return new StaticCatalogImp(this.validate());
        }
    }
}
