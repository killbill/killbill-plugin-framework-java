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
import org.killbill.billing.catalog.api.BillingPeriod;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.catalog.api.ProductCategory;
import org.killbill.billing.catalog.api.SimplePlanDescriptor;
import org.killbill.billing.catalog.api.TimeUnit;

@JsonDeserialize( builder = SimplePlanDescriptorImp.Builder.class )
public class SimplePlanDescriptorImp implements SimplePlanDescriptor {

    private static final long serialVersionUID = 0x87AD39BFF808A74BL;

    protected BigDecimal amount;
    protected List<String> availableBaseProducts;
    protected BillingPeriod billingPeriod;
    protected Currency currency;
    protected String planId;
    protected ProductCategory productCategory;
    protected String productName;
    protected Integer trialLength;
    protected TimeUnit trialTimeUnit;

    public SimplePlanDescriptorImp(final SimplePlanDescriptorImp that) {
        this.amount = that.amount;
        this.availableBaseProducts = that.availableBaseProducts;
        this.billingPeriod = that.billingPeriod;
        this.currency = that.currency;
        this.planId = that.planId;
        this.productCategory = that.productCategory;
        this.productName = that.productName;
        this.trialLength = that.trialLength;
        this.trialTimeUnit = that.trialTimeUnit;
    }
    protected SimplePlanDescriptorImp(final SimplePlanDescriptorImp.Builder<?> builder) {
        this.amount = builder.amount;
        this.availableBaseProducts = builder.availableBaseProducts;
        this.billingPeriod = builder.billingPeriod;
        this.currency = builder.currency;
        this.planId = builder.planId;
        this.productCategory = builder.productCategory;
        this.productName = builder.productName;
        this.trialLength = builder.trialLength;
        this.trialTimeUnit = builder.trialTimeUnit;
    }
    protected SimplePlanDescriptorImp() { }
    @Override
    public BigDecimal getAmount() {
        return this.amount;
    }
    @Override
    public List<String> getAvailableBaseProducts() {
        return this.availableBaseProducts;
    }
    @Override
    public BillingPeriod getBillingPeriod() {
        return this.billingPeriod;
    }
    @Override
    public Currency getCurrency() {
        return this.currency;
    }
    @Override
    public String getPlanId() {
        return this.planId;
    }
    @Override
    public ProductCategory getProductCategory() {
        return this.productCategory;
    }
    @Override
    public String getProductName() {
        return this.productName;
    }
    @Override
    public Integer getTrialLength() {
        return this.trialLength;
    }
    @Override
    public TimeUnit getTrialTimeUnit() {
        return this.trialTimeUnit;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final SimplePlanDescriptorImp that = (SimplePlanDescriptorImp) o;
        if( ( this.amount != null ) ? ( 0 != this.amount.compareTo(that.amount) ) : ( that.amount != null ) ) {
            return false;
        }
        if( !Objects.equals(this.availableBaseProducts, that.availableBaseProducts) ) {
            return false;
        }
        if( !Objects.equals(this.billingPeriod, that.billingPeriod) ) {
            return false;
        }
        if( !Objects.equals(this.currency, that.currency) ) {
            return false;
        }
        if( !Objects.equals(this.planId, that.planId) ) {
            return false;
        }
        if( !Objects.equals(this.productCategory, that.productCategory) ) {
            return false;
        }
        if( !Objects.equals(this.productName, that.productName) ) {
            return false;
        }
        if( !Objects.equals(this.trialLength, that.trialLength) ) {
            return false;
        }
        if( !Objects.equals(this.trialTimeUnit, that.trialTimeUnit) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.amount);
        result = ( 31 * result ) + Objects.hashCode(this.availableBaseProducts);
        result = ( 31 * result ) + Objects.hashCode(this.billingPeriod);
        result = ( 31 * result ) + Objects.hashCode(this.currency);
        result = ( 31 * result ) + Objects.hashCode(this.planId);
        result = ( 31 * result ) + Objects.hashCode(this.productCategory);
        result = ( 31 * result ) + Objects.hashCode(this.productName);
        result = ( 31 * result ) + Objects.hashCode(this.trialLength);
        result = ( 31 * result ) + Objects.hashCode(this.trialTimeUnit);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("amount=").append(this.amount);
        sb.append(", ");
        sb.append("availableBaseProducts=").append(this.availableBaseProducts);
        sb.append(", ");
        sb.append("billingPeriod=").append(this.billingPeriod);
        sb.append(", ");
        sb.append("currency=").append(this.currency);
        sb.append(", ");
        sb.append("planId=");
        if( this.planId == null ) {
            sb.append(this.planId);
        }else{
            sb.append("'").append(this.planId).append("'");
        }
        sb.append(", ");
        sb.append("productCategory=").append(this.productCategory);
        sb.append(", ");
        sb.append("productName=");
        if( this.productName == null ) {
            sb.append(this.productName);
        }else{
            sb.append("'").append(this.productName).append("'");
        }
        sb.append(", ");
        sb.append("trialLength=").append(this.trialLength);
        sb.append(", ");
        sb.append("trialTimeUnit=").append(this.trialTimeUnit);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends SimplePlanDescriptorImp.Builder<T>> {

        protected BigDecimal amount;
        protected List<String> availableBaseProducts;
        protected BillingPeriod billingPeriod;
        protected Currency currency;
        protected String planId;
        protected ProductCategory productCategory;
        protected String productName;
        protected Integer trialLength;
        protected TimeUnit trialTimeUnit;

        public Builder() { }
        public Builder(final Builder that) {
            this.amount = that.amount;
            this.availableBaseProducts = that.availableBaseProducts;
            this.billingPeriod = that.billingPeriod;
            this.currency = that.currency;
            this.planId = that.planId;
            this.productCategory = that.productCategory;
            this.productName = that.productName;
            this.trialLength = that.trialLength;
            this.trialTimeUnit = that.trialTimeUnit;
        }
        public T withAmount(final BigDecimal amount) {
            this.amount = amount;
            return (T) this;
        }
        public T withAvailableBaseProducts(final List<String> availableBaseProducts) {
            this.availableBaseProducts = availableBaseProducts;
            return (T) this;
        }
        public T withBillingPeriod(final BillingPeriod billingPeriod) {
            this.billingPeriod = billingPeriod;
            return (T) this;
        }
        public T withCurrency(final Currency currency) {
            this.currency = currency;
            return (T) this;
        }
        public T withPlanId(final String planId) {
            this.planId = planId;
            return (T) this;
        }
        public T withProductCategory(final ProductCategory productCategory) {
            this.productCategory = productCategory;
            return (T) this;
        }
        public T withProductName(final String productName) {
            this.productName = productName;
            return (T) this;
        }
        public T withTrialLength(final Integer trialLength) {
            this.trialLength = trialLength;
            return (T) this;
        }
        public T withTrialTimeUnit(final TimeUnit trialTimeUnit) {
            this.trialTimeUnit = trialTimeUnit;
            return (T) this;
        }
        public T source(final SimplePlanDescriptor that) {
            this.amount = that.getAmount();
            this.availableBaseProducts = that.getAvailableBaseProducts();
            this.billingPeriod = that.getBillingPeriod();
            this.currency = that.getCurrency();
            this.planId = that.getPlanId();
            this.productCategory = that.getProductCategory();
            this.productName = that.getProductName();
            this.trialLength = that.getTrialLength();
            this.trialTimeUnit = that.getTrialTimeUnit();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public SimplePlanDescriptorImp build() {
            return new SimplePlanDescriptorImp(this.validate());
        }
    }
}
