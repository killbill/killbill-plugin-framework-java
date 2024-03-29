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
import java.util.Objects;
import org.killbill.billing.catalog.api.CatalogValidationError;

@JsonDeserialize( builder = CatalogValidationErrorImp.Builder.class )
public class CatalogValidationErrorImp implements CatalogValidationError {

    protected String errorDescription;

    public CatalogValidationErrorImp(final CatalogValidationErrorImp that) {
        this.errorDescription = that.errorDescription;
    }
    protected CatalogValidationErrorImp(final CatalogValidationErrorImp.Builder<?> builder) {
        this.errorDescription = builder.errorDescription;
    }
    protected CatalogValidationErrorImp() { }
    @Override
    public String getErrorDescription() {
        return this.errorDescription;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final CatalogValidationErrorImp that = (CatalogValidationErrorImp) o;
        if( !Objects.equals(this.errorDescription, that.errorDescription) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.errorDescription);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("errorDescription=");
        if( this.errorDescription == null ) {
            sb.append(this.errorDescription);
        }else{
            sb.append("'").append(this.errorDescription).append("'");
        }
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends CatalogValidationErrorImp.Builder<T>> {

        protected String errorDescription;

        public Builder() { }
        public Builder(final Builder that) {
            this.errorDescription = that.errorDescription;
        }
        public T withErrorDescription(final String errorDescription) {
            this.errorDescription = errorDescription;
            return (T) this;
        }
        public T source(final CatalogValidationError that) {
            this.errorDescription = that.getErrorDescription();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public CatalogValidationErrorImp build() {
            return new CatalogValidationErrorImp(this.validate());
        }
    }
}
