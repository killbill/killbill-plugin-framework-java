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

package org.killbill.billing.usage.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import org.killbill.billing.usage.api.RolledUpUnit;

@JsonDeserialize( builder = RolledUpUnitImp.Builder.class )
public class RolledUpUnitImp implements RolledUpUnit {

    private static final long serialVersionUID = 0xCD9ED4CA8356C279L;

    protected Long amount;
    protected String unitType;

    public RolledUpUnitImp(final RolledUpUnitImp that) {
        this.amount = that.amount;
        this.unitType = that.unitType;
    }
    protected RolledUpUnitImp(final RolledUpUnitImp.Builder<?> builder) {
        this.amount = builder.amount;
        this.unitType = builder.unitType;
    }
    protected RolledUpUnitImp() { }
    @Override
    public Long getAmount() {
        return this.amount;
    }
    @Override
    public String getUnitType() {
        return this.unitType;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final RolledUpUnitImp that = (RolledUpUnitImp) o;
        if( !Objects.equals(this.amount, that.amount) ) {
            return false;
        }
        if( !Objects.equals(this.unitType, that.unitType) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.amount);
        result = ( 31 * result ) + Objects.hashCode(this.unitType);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("amount=").append(this.amount);
        sb.append(", ");
        sb.append("unitType=");
        if( this.unitType == null ) {
            sb.append(this.unitType);
        }else{
            sb.append("'").append(this.unitType).append("'");
        }
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends RolledUpUnitImp.Builder<T>> {

        protected Long amount;
        protected String unitType;

        public Builder() { }
        public Builder(final Builder that) {
            this.amount = that.amount;
            this.unitType = that.unitType;
        }
        public T withAmount(final Long amount) {
            this.amount = amount;
            return (T) this;
        }
        public T withUnitType(final String unitType) {
            this.unitType = unitType;
            return (T) this;
        }
        public T source(final RolledUpUnit that) {
            this.amount = that.getAmount();
            this.unitType = that.getUnitType();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public RolledUpUnitImp build() {
            return new RolledUpUnitImp(this.validate());
        }
    }
}
