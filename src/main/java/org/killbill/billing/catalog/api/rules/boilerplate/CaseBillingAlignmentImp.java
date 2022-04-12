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
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import org.killbill.billing.catalog.api.BillingAlignment;
import org.killbill.billing.catalog.api.BillingPeriod;
import org.killbill.billing.catalog.api.PhaseType;
import org.killbill.billing.catalog.api.PriceList;
import org.killbill.billing.catalog.api.Product;
import org.killbill.billing.catalog.api.ProductCategory;
import org.killbill.billing.catalog.api.StaticCatalog;
import org.killbill.billing.catalog.api.rules.CaseBillingAlignment;

@JsonDeserialize( builder = CaseBillingAlignmentImp.Builder.class )
public class CaseBillingAlignmentImp implements CaseBillingAlignment, Serializable {

    private static final long serialVersionUID = 0xD6A4C0E45541455L;

    protected BillingAlignment billingAlignment;
    protected BillingPeriod billingPeriod;
    protected StaticCatalog catalog;
    protected PhaseType phaseType;
    protected PriceList priceList;
    protected Product product;
    protected ProductCategory productCategory;

    public CaseBillingAlignmentImp(final CaseBillingAlignmentImp that) {
        this.billingAlignment = that.billingAlignment;
        this.billingPeriod = that.billingPeriod;
        this.catalog = that.catalog;
        this.phaseType = that.phaseType;
        this.priceList = that.priceList;
        this.product = that.product;
        this.productCategory = that.productCategory;
    }
    protected CaseBillingAlignmentImp(final CaseBillingAlignmentImp.Builder<?> builder) {
        this.billingAlignment = builder.billingAlignment;
        this.billingPeriod = builder.billingPeriod;
        this.catalog = builder.catalog;
        this.phaseType = builder.phaseType;
        this.priceList = builder.priceList;
        this.product = builder.product;
        this.productCategory = builder.productCategory;
    }
    protected CaseBillingAlignmentImp() { }
    @Override
    public BillingAlignment getBillingAlignment() {
        return this.billingAlignment;
    }
    @Override
    public BillingPeriod getBillingPeriod() {
        return this.billingPeriod;
    }
    @Override
    public StaticCatalog getCatalog() {
        return this.catalog;
    }
    @Override
    public PhaseType getPhaseType() {
        return this.phaseType;
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
    public ProductCategory getProductCategory() {
        return this.productCategory;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final CaseBillingAlignmentImp that = (CaseBillingAlignmentImp) o;
        if( !Objects.equals(this.billingAlignment, that.billingAlignment) ) {
            return false;
        }
        if( !Objects.equals(this.billingPeriod, that.billingPeriod) ) {
            return false;
        }
        if( !Objects.equals(this.catalog, that.catalog) ) {
            return false;
        }
        if( !Objects.equals(this.phaseType, that.phaseType) ) {
            return false;
        }
        if( !Objects.equals(this.priceList, that.priceList) ) {
            return false;
        }
        if( !Objects.equals(this.product, that.product) ) {
            return false;
        }
        if( !Objects.equals(this.productCategory, that.productCategory) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.billingAlignment);
        result = ( 31 * result ) + Objects.hashCode(this.billingPeriod);
        result = ( 31 * result ) + Objects.hashCode(this.catalog);
        result = ( 31 * result ) + Objects.hashCode(this.phaseType);
        result = ( 31 * result ) + Objects.hashCode(this.priceList);
        result = ( 31 * result ) + Objects.hashCode(this.product);
        result = ( 31 * result ) + Objects.hashCode(this.productCategory);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("billingAlignment=").append(this.billingAlignment);
        sb.append(", ");
        sb.append("billingPeriod=").append(this.billingPeriod);
        sb.append(", ");
        sb.append("catalog=").append(this.catalog);
        sb.append(", ");
        sb.append("phaseType=").append(this.phaseType);
        sb.append(", ");
        sb.append("priceList=").append(this.priceList);
        sb.append(", ");
        sb.append("product=").append(this.product);
        sb.append(", ");
        sb.append("productCategory=").append(this.productCategory);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends CaseBillingAlignmentImp.Builder<T>> {

        protected BillingAlignment billingAlignment;
        protected BillingPeriod billingPeriod;
        protected StaticCatalog catalog;
        protected PhaseType phaseType;
        protected PriceList priceList;
        protected Product product;
        protected ProductCategory productCategory;

        public Builder() { }
        public Builder(final Builder that) {
            this.billingAlignment = that.billingAlignment;
            this.billingPeriod = that.billingPeriod;
            this.catalog = that.catalog;
            this.phaseType = that.phaseType;
            this.priceList = that.priceList;
            this.product = that.product;
            this.productCategory = that.productCategory;
        }
        public T withBillingAlignment(final BillingAlignment billingAlignment) {
            this.billingAlignment = billingAlignment;
            return (T) this;
        }
        public T withBillingPeriod(final BillingPeriod billingPeriod) {
            this.billingPeriod = billingPeriod;
            return (T) this;
        }
        public T withCatalog(final StaticCatalog catalog) {
            this.catalog = catalog;
            return (T) this;
        }
        public T withPhaseType(final PhaseType phaseType) {
            this.phaseType = phaseType;
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
        public T withProductCategory(final ProductCategory productCategory) {
            this.productCategory = productCategory;
            return (T) this;
        }
        public T source(final CaseBillingAlignment that) {
            this.billingAlignment = that.getBillingAlignment();
            this.billingPeriod = that.getBillingPeriod();
            this.catalog = that.getCatalog();
            this.phaseType = that.getPhaseType();
            this.priceList = that.getPriceList();
            this.product = that.getProduct();
            this.productCategory = that.getProductCategory();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public CaseBillingAlignmentImp build() {
            return new CaseBillingAlignmentImp(this.validate());
        }
    }
}
