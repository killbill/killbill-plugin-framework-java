/*
 *  Generated by https://github.com/killbill/api-pojos. Do not edit!
 *
 *  Copyright 2022-2022 The Billing Project, LLC
 *
 *  The Billing Project licenses this file to you under the Apache License,
 *  version 2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at:
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 *  License for the specific language governing permissions and limitations
 *  under the License.
 */

package org.killbill.billing.catalog.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.killbill.billing.catalog.api.CatalogValidation;
import org.killbill.billing.catalog.api.CatalogValidationError;

@JsonDeserialize( builder = CatalogValidationImp.Builder.class )
public class CatalogValidationImp implements CatalogValidation {

    protected List<CatalogValidationError> validationErrors;

    public CatalogValidationImp(final CatalogValidationImp that) {
        this.validationErrors = that.validationErrors;
    }
    protected CatalogValidationImp(final CatalogValidationImp.Builder<?> builder) {
        this.validationErrors = builder.validationErrors;
    }
    protected CatalogValidationImp() { }
    @Override
    public List<CatalogValidationError> getValidationErrors() {
        return this.validationErrors;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final CatalogValidationImp that = (CatalogValidationImp) o;
        if( !Objects.equals(this.validationErrors, that.validationErrors) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.validationErrors);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("validationErrors=").append(this.validationErrors);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends CatalogValidationImp.Builder<T>> {

        protected List<CatalogValidationError> validationErrors;

        public Builder() { }
        public Builder(final Builder that) {
            this.validationErrors = that.validationErrors;
        }
        public T withValidationErrors(final List<CatalogValidationError> validationErrors) {
            this.validationErrors = validationErrors;
            return (T) this;
        }
        public T source(final CatalogValidation that) {
            this.validationErrors = that.getValidationErrors();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public CatalogValidationImp build() {
            return new CatalogValidationImp(this.validate());
        }
    }
}
