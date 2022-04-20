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

package org.killbill.billing.payment.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.killbill.billing.payment.api.PaymentOptions;

@JsonDeserialize( builder = PaymentOptionsImp.Builder.class )
public class PaymentOptionsImp implements PaymentOptions {

    private static final long serialVersionUID = 0xE4101CDCE0CB5796L;

    protected boolean isExternalPayment;
    protected List<String> paymentControlPluginNames;

    public PaymentOptionsImp(final PaymentOptionsImp that) {
        this.isExternalPayment = that.isExternalPayment;
        this.paymentControlPluginNames = that.paymentControlPluginNames;
    }
    protected PaymentOptionsImp(final PaymentOptionsImp.Builder<?> builder) {
        this.isExternalPayment = builder.isExternalPayment;
        this.paymentControlPluginNames = builder.paymentControlPluginNames;
    }
    protected PaymentOptionsImp() { }
    @Override
    @JsonGetter("isExternalPayment")
    public boolean isExternalPayment() {
        return this.isExternalPayment;
    }
    @Override
    public List<String> getPaymentControlPluginNames() {
        return this.paymentControlPluginNames;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PaymentOptionsImp that = (PaymentOptionsImp) o;
        if( this.isExternalPayment != that.isExternalPayment ) {
            return false;
        }
        if( !Objects.equals(this.paymentControlPluginNames, that.paymentControlPluginNames) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.isExternalPayment);
        result = ( 31 * result ) + Objects.hashCode(this.paymentControlPluginNames);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("isExternalPayment=").append(this.isExternalPayment);
        sb.append(", ");
        sb.append("paymentControlPluginNames=").append(this.paymentControlPluginNames);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PaymentOptionsImp.Builder<T>> {

        protected boolean isExternalPayment;
        protected List<String> paymentControlPluginNames;

        public Builder() { }
        public Builder(final Builder that) {
            this.isExternalPayment = that.isExternalPayment;
            this.paymentControlPluginNames = that.paymentControlPluginNames;
        }
        public T withIsExternalPayment(final boolean isExternalPayment) {
            this.isExternalPayment = isExternalPayment;
            return (T) this;
        }
        public T withPaymentControlPluginNames(final List<String> paymentControlPluginNames) {
            this.paymentControlPluginNames = paymentControlPluginNames;
            return (T) this;
        }
        public T source(final PaymentOptions that) {
            this.isExternalPayment = that.isExternalPayment();
            this.paymentControlPluginNames = that.getPaymentControlPluginNames();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PaymentOptionsImp build() {
            return new PaymentOptionsImp(this.validate());
        }
    }
}
