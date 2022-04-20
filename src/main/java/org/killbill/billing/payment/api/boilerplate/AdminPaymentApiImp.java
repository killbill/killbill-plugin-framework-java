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
import java.util.Objects;
import org.killbill.billing.payment.api.AdminPaymentApi;
import org.killbill.billing.payment.api.Payment;
import org.killbill.billing.payment.api.PaymentApiException;
import org.killbill.billing.payment.api.PaymentTransaction;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.api.TransactionStatus;
import org.killbill.billing.util.callcontext.CallContext;

@JsonDeserialize( builder = AdminPaymentApiImp.Builder.class )
public class AdminPaymentApiImp implements AdminPaymentApi {

    private static final long serialVersionUID = 0xCF79686F682D667FL;


    public AdminPaymentApiImp(final AdminPaymentApiImp that) {
    }
    protected AdminPaymentApiImp(final AdminPaymentApiImp.Builder<?> builder) {
    }
    protected AdminPaymentApiImp() { }
    @Override
    public void fixPaymentTransactionState(final Payment payment, final PaymentTransaction paymentTransaction, final TransactionStatus transactionStatus, final String lastSuccessPaymentState, final String currentPaymentStateName, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("fixPaymentTransactionState(org.killbill.billing.payment.api.Payment, org.killbill.billing.payment.api.PaymentTransaction, org.killbill.billing.payment.api.TransactionStatus, java.lang.String, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends AdminPaymentApiImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final AdminPaymentApi that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public AdminPaymentApiImp build() {
            return new AdminPaymentApiImp(this.validate());
        }
    }
}
