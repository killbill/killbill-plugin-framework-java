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
import java.util.Objects;
import org.killbill.billing.catalog.api.CatalogEntity;

@JsonDeserialize( builder = CatalogEntityImp.Builder.class )
public class CatalogEntityImp implements CatalogEntity {

    private static final long serialVersionUID = 0x1EAEAFBDB03087E2L;

    protected String name;
    protected String prettyName;

    public CatalogEntityImp(final CatalogEntityImp that) {
        this.name = that.name;
        this.prettyName = that.prettyName;
    }
    protected CatalogEntityImp(final CatalogEntityImp.Builder<?> builder) {
        this.name = builder.name;
        this.prettyName = builder.prettyName;
    }
    protected CatalogEntityImp() { }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public String getPrettyName() {
        return this.prettyName;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final CatalogEntityImp that = (CatalogEntityImp) o;
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
        result = ( 31 * result ) + Objects.hashCode(this.name);
        result = ( 31 * result ) + Objects.hashCode(this.prettyName);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
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
    public static class Builder<T extends CatalogEntityImp.Builder<T>> {

        protected String name;
        protected String prettyName;

        public Builder() { }
        public Builder(final Builder that) {
            this.name = that.name;
            this.prettyName = that.prettyName;
        }
        public T withName(final String name) {
            this.name = name;
            return (T) this;
        }
        public T withPrettyName(final String prettyName) {
            this.prettyName = prettyName;
            return (T) this;
        }
        public T source(final CatalogEntity that) {
            this.name = that.getName();
            this.prettyName = that.getPrettyName();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public CatalogEntityImp build() {
            return new CatalogEntityImp(this.validate());
        }
    }
}
