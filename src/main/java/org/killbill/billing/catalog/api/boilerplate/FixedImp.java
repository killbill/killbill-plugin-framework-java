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
import org.killbill.billing.catalog.api.Fixed;
import org.killbill.billing.catalog.api.FixedType;
import org.killbill.billing.catalog.api.InternationalPrice;

@JsonDeserialize( builder = FixedImp.Builder.class )
public class FixedImp implements Fixed {

    private static final long serialVersionUID = 0xE56482B05D5C48E9L;

    protected InternationalPrice price;
    protected FixedType type;

    public FixedImp(final FixedImp that) {
        this.price = that.price;
        this.type = that.type;
    }
    protected FixedImp(final FixedImp.Builder<?> builder) {
        this.price = builder.price;
        this.type = builder.type;
    }
    protected FixedImp() { }
    @Override
    public InternationalPrice getPrice() {
        return this.price;
    }
    @Override
    public FixedType getType() {
        return this.type;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final FixedImp that = (FixedImp) o;
        if( !Objects.equals(this.price, that.price) ) {
            return false;
        }
        if( !Objects.equals(this.type, that.type) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.price);
        result = ( 31 * result ) + Objects.hashCode(this.type);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("price=").append(this.price);
        sb.append(", ");
        sb.append("type=").append(this.type);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends FixedImp.Builder<T>> {

        protected InternationalPrice price;
        protected FixedType type;

        public Builder() { }
        public Builder(final Builder that) {
            this.price = that.price;
            this.type = that.type;
        }
        public T withPrice(final InternationalPrice price) {
            this.price = price;
            return (T) this;
        }
        public T withType(final FixedType type) {
            this.type = type;
            return (T) this;
        }
        public T source(final Fixed that) {
            this.price = that.getPrice();
            this.type = that.getType();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public FixedImp build() {
            return new FixedImp(this.validate());
        }
    }
}
