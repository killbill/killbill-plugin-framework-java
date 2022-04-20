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
import org.killbill.billing.catalog.api.BillingPeriod;
import org.killbill.billing.catalog.api.PhaseType;
import org.killbill.billing.catalog.api.PlanAlignmentChange;
import org.killbill.billing.catalog.api.PriceList;
import org.killbill.billing.catalog.api.Product;
import org.killbill.billing.catalog.api.ProductCategory;
import org.killbill.billing.catalog.api.StaticCatalog;
import org.killbill.billing.catalog.api.rules.CaseChangePlanAlignment;

@JsonDeserialize( builder = CaseChangePlanAlignmentImp.Builder.class )
public class CaseChangePlanAlignmentImp implements CaseChangePlanAlignment {

    protected PlanAlignmentChange alignment;
    protected StaticCatalog catalog;
    protected BillingPeriod fromBillingPeriod;
    protected PriceList fromPriceList;
    protected Product fromProduct;
    protected ProductCategory fromProductCategory;
    protected PhaseType phaseType;
    protected BillingPeriod toBillingPeriod;
    protected PriceList toPriceList;
    protected Product toProduct;
    protected ProductCategory toProductCategory;

    public CaseChangePlanAlignmentImp(final CaseChangePlanAlignmentImp that) {
        this.alignment = that.alignment;
        this.catalog = that.catalog;
        this.fromBillingPeriod = that.fromBillingPeriod;
        this.fromPriceList = that.fromPriceList;
        this.fromProduct = that.fromProduct;
        this.fromProductCategory = that.fromProductCategory;
        this.phaseType = that.phaseType;
        this.toBillingPeriod = that.toBillingPeriod;
        this.toPriceList = that.toPriceList;
        this.toProduct = that.toProduct;
        this.toProductCategory = that.toProductCategory;
    }
    protected CaseChangePlanAlignmentImp(final CaseChangePlanAlignmentImp.Builder<?> builder) {
        this.alignment = builder.alignment;
        this.catalog = builder.catalog;
        this.fromBillingPeriod = builder.fromBillingPeriod;
        this.fromPriceList = builder.fromPriceList;
        this.fromProduct = builder.fromProduct;
        this.fromProductCategory = builder.fromProductCategory;
        this.phaseType = builder.phaseType;
        this.toBillingPeriod = builder.toBillingPeriod;
        this.toPriceList = builder.toPriceList;
        this.toProduct = builder.toProduct;
        this.toProductCategory = builder.toProductCategory;
    }
    protected CaseChangePlanAlignmentImp() { }
    @Override
    public PlanAlignmentChange getAlignment() {
        return this.alignment;
    }
    @Override
    public StaticCatalog getCatalog() {
        return this.catalog;
    }
    @Override
    public BillingPeriod getFromBillingPeriod() {
        return this.fromBillingPeriod;
    }
    @Override
    public PriceList getFromPriceList() {
        return this.fromPriceList;
    }
    @Override
    public Product getFromProduct() {
        return this.fromProduct;
    }
    @Override
    public ProductCategory getFromProductCategory() {
        return this.fromProductCategory;
    }
    @Override
    public PhaseType getPhaseType() {
        return this.phaseType;
    }
    @Override
    public BillingPeriod getToBillingPeriod() {
        return this.toBillingPeriod;
    }
    @Override
    public PriceList getToPriceList() {
        return this.toPriceList;
    }
    @Override
    public Product getToProduct() {
        return this.toProduct;
    }
    @Override
    public ProductCategory getToProductCategory() {
        return this.toProductCategory;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final CaseChangePlanAlignmentImp that = (CaseChangePlanAlignmentImp) o;
        if( !Objects.equals(this.alignment, that.alignment) ) {
            return false;
        }
        if( !Objects.equals(this.catalog, that.catalog) ) {
            return false;
        }
        if( !Objects.equals(this.fromBillingPeriod, that.fromBillingPeriod) ) {
            return false;
        }
        if( !Objects.equals(this.fromPriceList, that.fromPriceList) ) {
            return false;
        }
        if( !Objects.equals(this.fromProduct, that.fromProduct) ) {
            return false;
        }
        if( !Objects.equals(this.fromProductCategory, that.fromProductCategory) ) {
            return false;
        }
        if( !Objects.equals(this.phaseType, that.phaseType) ) {
            return false;
        }
        if( !Objects.equals(this.toBillingPeriod, that.toBillingPeriod) ) {
            return false;
        }
        if( !Objects.equals(this.toPriceList, that.toPriceList) ) {
            return false;
        }
        if( !Objects.equals(this.toProduct, that.toProduct) ) {
            return false;
        }
        if( !Objects.equals(this.toProductCategory, that.toProductCategory) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.alignment);
        result = ( 31 * result ) + Objects.hashCode(this.catalog);
        result = ( 31 * result ) + Objects.hashCode(this.fromBillingPeriod);
        result = ( 31 * result ) + Objects.hashCode(this.fromPriceList);
        result = ( 31 * result ) + Objects.hashCode(this.fromProduct);
        result = ( 31 * result ) + Objects.hashCode(this.fromProductCategory);
        result = ( 31 * result ) + Objects.hashCode(this.phaseType);
        result = ( 31 * result ) + Objects.hashCode(this.toBillingPeriod);
        result = ( 31 * result ) + Objects.hashCode(this.toPriceList);
        result = ( 31 * result ) + Objects.hashCode(this.toProduct);
        result = ( 31 * result ) + Objects.hashCode(this.toProductCategory);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("alignment=").append(this.alignment);
        sb.append(", ");
        sb.append("catalog=").append(this.catalog);
        sb.append(", ");
        sb.append("fromBillingPeriod=").append(this.fromBillingPeriod);
        sb.append(", ");
        sb.append("fromPriceList=").append(this.fromPriceList);
        sb.append(", ");
        sb.append("fromProduct=").append(this.fromProduct);
        sb.append(", ");
        sb.append("fromProductCategory=").append(this.fromProductCategory);
        sb.append(", ");
        sb.append("phaseType=").append(this.phaseType);
        sb.append(", ");
        sb.append("toBillingPeriod=").append(this.toBillingPeriod);
        sb.append(", ");
        sb.append("toPriceList=").append(this.toPriceList);
        sb.append(", ");
        sb.append("toProduct=").append(this.toProduct);
        sb.append(", ");
        sb.append("toProductCategory=").append(this.toProductCategory);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends CaseChangePlanAlignmentImp.Builder<T>> {

        protected PlanAlignmentChange alignment;
        protected StaticCatalog catalog;
        protected BillingPeriod fromBillingPeriod;
        protected PriceList fromPriceList;
        protected Product fromProduct;
        protected ProductCategory fromProductCategory;
        protected PhaseType phaseType;
        protected BillingPeriod toBillingPeriod;
        protected PriceList toPriceList;
        protected Product toProduct;
        protected ProductCategory toProductCategory;

        public Builder() { }
        public Builder(final Builder that) {
            this.alignment = that.alignment;
            this.catalog = that.catalog;
            this.fromBillingPeriod = that.fromBillingPeriod;
            this.fromPriceList = that.fromPriceList;
            this.fromProduct = that.fromProduct;
            this.fromProductCategory = that.fromProductCategory;
            this.phaseType = that.phaseType;
            this.toBillingPeriod = that.toBillingPeriod;
            this.toPriceList = that.toPriceList;
            this.toProduct = that.toProduct;
            this.toProductCategory = that.toProductCategory;
        }
        public T withAlignment(final PlanAlignmentChange alignment) {
            this.alignment = alignment;
            return (T) this;
        }
        public T withCatalog(final StaticCatalog catalog) {
            this.catalog = catalog;
            return (T) this;
        }
        public T withFromBillingPeriod(final BillingPeriod fromBillingPeriod) {
            this.fromBillingPeriod = fromBillingPeriod;
            return (T) this;
        }
        public T withFromPriceList(final PriceList fromPriceList) {
            this.fromPriceList = fromPriceList;
            return (T) this;
        }
        public T withFromProduct(final Product fromProduct) {
            this.fromProduct = fromProduct;
            return (T) this;
        }
        public T withFromProductCategory(final ProductCategory fromProductCategory) {
            this.fromProductCategory = fromProductCategory;
            return (T) this;
        }
        public T withPhaseType(final PhaseType phaseType) {
            this.phaseType = phaseType;
            return (T) this;
        }
        public T withToBillingPeriod(final BillingPeriod toBillingPeriod) {
            this.toBillingPeriod = toBillingPeriod;
            return (T) this;
        }
        public T withToPriceList(final PriceList toPriceList) {
            this.toPriceList = toPriceList;
            return (T) this;
        }
        public T withToProduct(final Product toProduct) {
            this.toProduct = toProduct;
            return (T) this;
        }
        public T withToProductCategory(final ProductCategory toProductCategory) {
            this.toProductCategory = toProductCategory;
            return (T) this;
        }
        public T source(final CaseChangePlanAlignment that) {
            this.alignment = that.getAlignment();
            this.catalog = that.getCatalog();
            this.fromBillingPeriod = that.getFromBillingPeriod();
            this.fromPriceList = that.getFromPriceList();
            this.fromProduct = that.getFromProduct();
            this.fromProductCategory = that.getFromProductCategory();
            this.phaseType = that.getPhaseType();
            this.toBillingPeriod = that.getToBillingPeriod();
            this.toPriceList = that.getToPriceList();
            this.toProduct = that.getToProduct();
            this.toProductCategory = that.getToProductCategory();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public CaseChangePlanAlignmentImp build() {
            return new CaseChangePlanAlignmentImp(this.validate());
        }
    }
}
