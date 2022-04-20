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
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;
import org.joda.time.DateTime;
import org.killbill.billing.catalog.api.BillingMode;
import org.killbill.billing.catalog.api.BillingPeriod;
import org.killbill.billing.catalog.api.CatalogApiException;
import org.killbill.billing.catalog.api.PhaseType;
import org.killbill.billing.catalog.api.Plan;
import org.killbill.billing.catalog.api.PlanPhase;
import org.killbill.billing.catalog.api.PriceList;
import org.killbill.billing.catalog.api.Product;
import org.killbill.billing.catalog.api.StaticCatalog;

@JsonDeserialize( builder = PlanImp.Builder.class )
public class PlanImp implements Plan {

    protected PlanPhase[] allPhases;
    protected StaticCatalog catalog;
    protected Date effectiveDateForExistingSubscriptions;
    protected PlanPhase finalPhase;
    protected Iterator<PlanPhase> initialPhaseIterator;
    protected PlanPhase[] initialPhases;
    protected String name;
    protected int plansAllowedInBundle;
    protected String prettyName;
    protected PriceList priceList;
    protected Product product;
    protected BillingMode recurringBillingMode;
    protected BillingPeriod recurringBillingPeriod;

    public PlanImp(final PlanImp that) {
        this.allPhases = that.allPhases;
        this.catalog = that.catalog;
        this.effectiveDateForExistingSubscriptions = that.effectiveDateForExistingSubscriptions;
        this.finalPhase = that.finalPhase;
        this.initialPhaseIterator = that.initialPhaseIterator;
        this.initialPhases = that.initialPhases;
        this.name = that.name;
        this.plansAllowedInBundle = that.plansAllowedInBundle;
        this.prettyName = that.prettyName;
        this.priceList = that.priceList;
        this.product = that.product;
        this.recurringBillingMode = that.recurringBillingMode;
        this.recurringBillingPeriod = that.recurringBillingPeriod;
    }
    protected PlanImp(final PlanImp.Builder<?> builder) {
        this.allPhases = builder.allPhases;
        this.catalog = builder.catalog;
        this.effectiveDateForExistingSubscriptions = builder.effectiveDateForExistingSubscriptions;
        this.finalPhase = builder.finalPhase;
        this.initialPhaseIterator = builder.initialPhaseIterator;
        this.initialPhases = builder.initialPhases;
        this.name = builder.name;
        this.plansAllowedInBundle = builder.plansAllowedInBundle;
        this.prettyName = builder.prettyName;
        this.priceList = builder.priceList;
        this.product = builder.product;
        this.recurringBillingMode = builder.recurringBillingMode;
        this.recurringBillingPeriod = builder.recurringBillingPeriod;
    }
    protected PlanImp() { }
    @Override
    public PlanPhase[] getAllPhases() {
        return this.allPhases;
    }
    @Override
    public StaticCatalog getCatalog() {
        return this.catalog;
    }
    @Override
    public Date getEffectiveDateForExistingSubscriptions() {
        return this.effectiveDateForExistingSubscriptions;
    }
    @Override
    public PlanPhase getFinalPhase() {
        return this.finalPhase;
    }
    @Override
    public Iterator<PlanPhase> getInitialPhaseIterator() {
        return this.initialPhaseIterator;
    }
    @Override
    public PlanPhase[] getInitialPhases() {
        return this.initialPhases;
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public int getPlansAllowedInBundle() {
        return this.plansAllowedInBundle;
    }
    @Override
    public String getPrettyName() {
        return this.prettyName;
    }
    @Override
    public PriceList getPriceList() {
        return this.priceList;
    }
    @Override
    public Product getProduct() {
        return this.product;
    }
    @Override
    public BillingMode getRecurringBillingMode() {
        return this.recurringBillingMode;
    }
    @Override
    public BillingPeriod getRecurringBillingPeriod() {
        return this.recurringBillingPeriod;
    }
    @Override
    public DateTime dateOfFirstRecurringNonZeroCharge(final DateTime subscriptionStartDate, final PhaseType intialPhaseType) {
        throw new UnsupportedOperationException("dateOfFirstRecurringNonZeroCharge(org.joda.time.DateTime, org.killbill.billing.catalog.api.PhaseType) must be implemented.");
    }
    @Override
    public PlanPhase findPhase(final String name) {
        throw new UnsupportedOperationException("findPhase(java.lang.String) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PlanImp that = (PlanImp) o;
        if( !Arrays.deepEquals(this.allPhases, that.allPhases) ) {
            return false;
        }
        if( !Objects.equals(this.catalog, that.catalog) ) {
            return false;
        }
        if( !Objects.equals(this.effectiveDateForExistingSubscriptions, that.effectiveDateForExistingSubscriptions) ) {
            return false;
        }
        if( !Objects.equals(this.finalPhase, that.finalPhase) ) {
            return false;
        }
        if( !Objects.equals(this.initialPhaseIterator, that.initialPhaseIterator) ) {
            return false;
        }
        if( !Arrays.deepEquals(this.initialPhases, that.initialPhases) ) {
            return false;
        }
        if( !Objects.equals(this.name, that.name) ) {
            return false;
        }
        if( this.plansAllowedInBundle != that.plansAllowedInBundle ) {
            return false;
        }
        if( !Objects.equals(this.prettyName, that.prettyName) ) {
            return false;
        }
        if( !Objects.equals(this.priceList, that.priceList) ) {
            return false;
        }
        if( !Objects.equals(this.product, that.product) ) {
            return false;
        }
        if( !Objects.equals(this.recurringBillingMode, that.recurringBillingMode) ) {
            return false;
        }
        if( !Objects.equals(this.recurringBillingPeriod, that.recurringBillingPeriod) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Arrays.deepHashCode(this.allPhases);
        result = ( 31 * result ) + Objects.hashCode(this.catalog);
        result = ( 31 * result ) + Objects.hashCode(this.effectiveDateForExistingSubscriptions);
        result = ( 31 * result ) + Objects.hashCode(this.finalPhase);
        result = ( 31 * result ) + Objects.hashCode(this.initialPhaseIterator);
        result = ( 31 * result ) + Arrays.deepHashCode(this.initialPhases);
        result = ( 31 * result ) + Objects.hashCode(this.name);
        result = ( 31 * result ) + Objects.hashCode(this.plansAllowedInBundle);
        result = ( 31 * result ) + Objects.hashCode(this.prettyName);
        result = ( 31 * result ) + Objects.hashCode(this.priceList);
        result = ( 31 * result ) + Objects.hashCode(this.product);
        result = ( 31 * result ) + Objects.hashCode(this.recurringBillingMode);
        result = ( 31 * result ) + Objects.hashCode(this.recurringBillingPeriod);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("allPhases=").append(Arrays.toString(this.allPhases));
        sb.append(", ");
        sb.append("catalog=").append(this.catalog);
        sb.append(", ");
        sb.append("effectiveDateForExistingSubscriptions=").append(this.effectiveDateForExistingSubscriptions);
        sb.append(", ");
        sb.append("finalPhase=").append(this.finalPhase);
        sb.append(", ");
        sb.append("initialPhaseIterator=").append(this.initialPhaseIterator);
        sb.append(", ");
        sb.append("initialPhases=").append(Arrays.toString(this.initialPhases));
        sb.append(", ");
        sb.append("name=");
        if( this.name == null ) {
            sb.append(this.name);
        }else{
            sb.append("'").append(this.name).append("'");
        }
        sb.append(", ");
        sb.append("plansAllowedInBundle=").append(this.plansAllowedInBundle);
        sb.append(", ");
        sb.append("prettyName=");
        if( this.prettyName == null ) {
            sb.append(this.prettyName);
        }else{
            sb.append("'").append(this.prettyName).append("'");
        }
        sb.append(", ");
        sb.append("priceList=").append(this.priceList);
        sb.append(", ");
        sb.append("product=").append(this.product);
        sb.append(", ");
        sb.append("recurringBillingMode=").append(this.recurringBillingMode);
        sb.append(", ");
        sb.append("recurringBillingPeriod=").append(this.recurringBillingPeriod);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PlanImp.Builder<T>> {

        protected PlanPhase[] allPhases;
        protected StaticCatalog catalog;
        protected Date effectiveDateForExistingSubscriptions;
        protected PlanPhase finalPhase;
        protected Iterator<PlanPhase> initialPhaseIterator;
        protected PlanPhase[] initialPhases;
        protected String name;
        protected int plansAllowedInBundle;
        protected String prettyName;
        protected PriceList priceList;
        protected Product product;
        protected BillingMode recurringBillingMode;
        protected BillingPeriod recurringBillingPeriod;

        public Builder() { }
        public Builder(final Builder that) {
            this.allPhases = that.allPhases;
            this.catalog = that.catalog;
            this.effectiveDateForExistingSubscriptions = that.effectiveDateForExistingSubscriptions;
            this.finalPhase = that.finalPhase;
            this.initialPhaseIterator = that.initialPhaseIterator;
            this.initialPhases = that.initialPhases;
            this.name = that.name;
            this.plansAllowedInBundle = that.plansAllowedInBundle;
            this.prettyName = that.prettyName;
            this.priceList = that.priceList;
            this.product = that.product;
            this.recurringBillingMode = that.recurringBillingMode;
            this.recurringBillingPeriod = that.recurringBillingPeriod;
        }
        public T withAllPhases(final PlanPhase[] allPhases) {
            this.allPhases = allPhases;
            return (T) this;
        }
        public T withCatalog(final StaticCatalog catalog) {
            this.catalog = catalog;
            return (T) this;
        }
        public T withEffectiveDateForExistingSubscriptions(final Date effectiveDateForExistingSubscriptions) {
            this.effectiveDateForExistingSubscriptions = effectiveDateForExistingSubscriptions;
            return (T) this;
        }
        public T withFinalPhase(final PlanPhase finalPhase) {
            this.finalPhase = finalPhase;
            return (T) this;
        }
        public T withInitialPhaseIterator(final Iterator<PlanPhase> initialPhaseIterator) {
            this.initialPhaseIterator = initialPhaseIterator;
            return (T) this;
        }
        public T withInitialPhases(final PlanPhase[] initialPhases) {
            this.initialPhases = initialPhases;
            return (T) this;
        }
        public T withName(final String name) {
            this.name = name;
            return (T) this;
        }
        public T withPlansAllowedInBundle(final int plansAllowedInBundle) {
            this.plansAllowedInBundle = plansAllowedInBundle;
            return (T) this;
        }
        public T withPrettyName(final String prettyName) {
            this.prettyName = prettyName;
            return (T) this;
        }
        public T withPriceList(final PriceList priceList) {
            this.priceList = priceList;
            return (T) this;
        }
        public T withProduct(final Product product) {
            this.product = product;
            return (T) this;
        }
        public T withRecurringBillingMode(final BillingMode recurringBillingMode) {
            this.recurringBillingMode = recurringBillingMode;
            return (T) this;
        }
        public T withRecurringBillingPeriod(final BillingPeriod recurringBillingPeriod) {
            this.recurringBillingPeriod = recurringBillingPeriod;
            return (T) this;
        }
        public T source(final Plan that) {
            this.allPhases = that.getAllPhases();
            this.catalog = that.getCatalog();
            this.effectiveDateForExistingSubscriptions = that.getEffectiveDateForExistingSubscriptions();
            this.finalPhase = that.getFinalPhase();
            this.initialPhaseIterator = that.getInitialPhaseIterator();
            this.initialPhases = that.getInitialPhases();
            this.name = that.getName();
            this.plansAllowedInBundle = that.getPlansAllowedInBundle();
            this.prettyName = that.getPrettyName();
            this.priceList = that.getPriceList();
            this.product = that.getProduct();
            this.recurringBillingMode = that.getRecurringBillingMode();
            this.recurringBillingPeriod = that.getRecurringBillingPeriod();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PlanImp build() {
            return new PlanImp(this.validate());
        }
    }
}
