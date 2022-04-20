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
import java.util.Objects;
import org.killbill.billing.catalog.api.Limit;
import org.killbill.billing.catalog.api.Product;
import org.killbill.billing.catalog.api.ProductCategory;
import org.killbill.billing.catalog.api.StaticCatalog;

@JsonDeserialize( builder = ProductImp.Builder.class )
public class ProductImp implements Product {

    private static final long serialVersionUID = 0x25986204CF11F2C6L;

    protected Collection<Product> available;
    protected StaticCatalog catalog;
    protected String catalogName;
    protected ProductCategory category;
    protected Collection<Product> included;
    protected Limit[] limits;
    protected String name;
    protected String prettyName;

    public ProductImp(final ProductImp that) {
        this.available = that.available;
        this.catalog = that.catalog;
        this.catalogName = that.catalogName;
        this.category = that.category;
        this.included = that.included;
        this.limits = that.limits;
        this.name = that.name;
        this.prettyName = that.prettyName;
    }
    protected ProductImp(final ProductImp.Builder<?> builder) {
        this.available = builder.available;
        this.catalog = builder.catalog;
        this.catalogName = builder.catalogName;
        this.category = builder.category;
        this.included = builder.included;
        this.limits = builder.limits;
        this.name = builder.name;
        this.prettyName = builder.prettyName;
    }
    protected ProductImp() { }
    @Override
    public Collection<Product> getAvailable() {
        return this.available;
    }
    @Override
    public StaticCatalog getCatalog() {
        return this.catalog;
    }
    @Override
    public String getCatalogName() {
        return this.catalogName;
    }
    @Override
    public ProductCategory getCategory() {
        return this.category;
    }
    @Override
    public Collection<Product> getIncluded() {
        return this.included;
    }
    @Override
    public Limit[] getLimits() {
        return this.limits;
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public String getPrettyName() {
        return this.prettyName;
    }
    @Override
    public boolean compliesWithLimits(final String unit, final double value) {
        throw new UnsupportedOperationException("compliesWithLimits(java.lang.String, double) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final ProductImp that = (ProductImp) o;
        if( !Objects.equals(this.available, that.available) ) {
            return false;
        }
        if( !Objects.equals(this.catalog, that.catalog) ) {
            return false;
        }
        if( !Objects.equals(this.catalogName, that.catalogName) ) {
            return false;
        }
        if( !Objects.equals(this.category, that.category) ) {
            return false;
        }
        if( !Objects.equals(this.included, that.included) ) {
            return false;
        }
        if( !Arrays.deepEquals(this.limits, that.limits) ) {
            return false;
        }
        if( !Objects.equals(this.name, that.name) ) {
            return false;
        }
        if( !Objects.equals(this.prettyName, that.prettyName) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.available);
        result = ( 31 * result ) + Objects.hashCode(this.catalog);
        result = ( 31 * result ) + Objects.hashCode(this.catalogName);
        result = ( 31 * result ) + Objects.hashCode(this.category);
        result = ( 31 * result ) + Objects.hashCode(this.included);
        result = ( 31 * result ) + Arrays.deepHashCode(this.limits);
        result = ( 31 * result ) + Objects.hashCode(this.name);
        result = ( 31 * result ) + Objects.hashCode(this.prettyName);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("available=").append(this.available);
        sb.append(", ");
        sb.append("catalog=").append(this.catalog);
        sb.append(", ");
        sb.append("catalogName=");
        if( this.catalogName == null ) {
            sb.append(this.catalogName);
        }else{
            sb.append("'").append(this.catalogName).append("'");
        }
        sb.append(", ");
        sb.append("category=").append(this.category);
        sb.append(", ");
        sb.append("included=").append(this.included);
        sb.append(", ");
        sb.append("limits=").append(Arrays.toString(this.limits));
        sb.append(", ");
        sb.append("name=");
        if( this.name == null ) {
            sb.append(this.name);
        }else{
            sb.append("'").append(this.name).append("'");
        }
        sb.append(", ");
        sb.append("prettyName=");
        if( this.prettyName == null ) {
            sb.append(this.prettyName);
        }else{
            sb.append("'").append(this.prettyName).append("'");
        }
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends ProductImp.Builder<T>> {

        protected Collection<Product> available;
        protected StaticCatalog catalog;
        protected String catalogName;
        protected ProductCategory category;
        protected Collection<Product> included;
        protected Limit[] limits;
        protected String name;
        protected String prettyName;

        public Builder() { }
        public Builder(final Builder that) {
            this.available = that.available;
            this.catalog = that.catalog;
            this.catalogName = that.catalogName;
            this.category = that.category;
            this.included = that.included;
            this.limits = that.limits;
            this.name = that.name;
            this.prettyName = that.prettyName;
        }
        public T withAvailable(final Collection<Product> available) {
            this.available = available;
            return (T) this;
        }
        public T withCatalog(final StaticCatalog catalog) {
            this.catalog = catalog;
            return (T) this;
        }
        public T withCatalogName(final String catalogName) {
            this.catalogName = catalogName;
            return (T) this;
        }
        public T withCategory(final ProductCategory category) {
            this.category = category;
            return (T) this;
        }
        public T withIncluded(final Collection<Product> included) {
            this.included = included;
            return (T) this;
        }
        public T withLimits(final Limit[] limits) {
            this.limits = limits;
            return (T) this;
        }
        public T withName(final String name) {
            this.name = name;
            return (T) this;
        }
        public T withPrettyName(final String prettyName) {
            this.prettyName = prettyName;
            return (T) this;
        }
        public T source(final Product that) {
            this.available = that.getAvailable();
            this.catalog = that.getCatalog();
            this.catalogName = that.getCatalogName();
            this.category = that.getCategory();
            this.included = that.getIncluded();
            this.limits = that.getLimits();
            this.name = that.getName();
            this.prettyName = that.getPrettyName();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public ProductImp build() {
            return new ProductImp(this.validate());
        }
    }
}
