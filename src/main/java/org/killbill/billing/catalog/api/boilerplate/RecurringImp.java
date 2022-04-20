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
import org.killbill.billing.catalog.api.BillingPeriod;
import org.killbill.billing.catalog.api.InternationalPrice;
import org.killbill.billing.catalog.api.Recurring;

@JsonDeserialize( builder = RecurringImp.Builder.class )
public class RecurringImp implements Recurring {

    protected BillingPeriod billingPeriod;
    protected InternationalPrice recurringPrice;

    public RecurringImp(final RecurringImp that) {
        this.billingPeriod = that.billingPeriod;
        this.recurringPrice = that.recurringPrice;
    }
    protected RecurringImp(final RecurringImp.Builder<?> builder) {
        this.billingPeriod = builder.billingPeriod;
        this.recurringPrice = builder.recurringPrice;
    }
    protected RecurringImp() { }
    @Override
    public BillingPeriod getBillingPeriod() {
        return this.billingPeriod;
    }
    @Override
    public InternationalPrice getRecurringPrice() {
        return this.recurringPrice;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final RecurringImp that = (RecurringImp) o;
        if( !Objects.equals(this.billingPeriod, that.billingPeriod) ) {
            return false;
        }
        if( !Objects.equals(this.recurringPrice, that.recurringPrice) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.billingPeriod);
        result = ( 31 * result ) + Objects.hashCode(this.recurringPrice);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("billingPeriod=").append(this.billingPeriod);
        sb.append(", ");
        sb.append("recurringPrice=").append(this.recurringPrice);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends RecurringImp.Builder<T>> {

        protected BillingPeriod billingPeriod;
        protected InternationalPrice recurringPrice;

        public Builder() { }
        public Builder(final Builder that) {
            this.billingPeriod = that.billingPeriod;
            this.recurringPrice = that.recurringPrice;
        }
        public T withBillingPeriod(final BillingPeriod billingPeriod) {
            this.billingPeriod = billingPeriod;
            return (T) this;
        }
        public T withRecurringPrice(final InternationalPrice recurringPrice) {
            this.recurringPrice = recurringPrice;
            return (T) this;
        }
        public T source(final Recurring that) {
            this.billingPeriod = that.getBillingPeriod();
            this.recurringPrice = that.getRecurringPrice();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public RecurringImp build() {
            return new RecurringImp(this.validate());
        }
    }
}
