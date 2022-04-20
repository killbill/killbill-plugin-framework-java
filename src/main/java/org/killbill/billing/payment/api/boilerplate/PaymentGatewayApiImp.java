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
import java.util.UUID;
import org.killbill.billing.account.api.Account;
import org.killbill.billing.payment.api.PaymentApiException;
import org.killbill.billing.payment.api.PaymentGatewayApi;
import org.killbill.billing.payment.api.PaymentOptions;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.plugin.api.GatewayNotification;
import org.killbill.billing.payment.plugin.api.HostedPaymentPageFormDescriptor;
import org.killbill.billing.util.callcontext.CallContext;

@JsonDeserialize( builder = PaymentGatewayApiImp.Builder.class )
public class PaymentGatewayApiImp implements PaymentGatewayApi {


    public PaymentGatewayApiImp(final PaymentGatewayApiImp that) {
    }
    protected PaymentGatewayApiImp(final PaymentGatewayApiImp.Builder<?> builder) {
    }
    protected PaymentGatewayApiImp() { }
    @Override
    public GatewayNotification processNotification(final String notification, final String pluginName, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("processNotification(java.lang.String, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public HostedPaymentPageFormDescriptor buildFormDescriptor(final Account account, final UUID paymentMethodId, final Iterable<PluginProperty> customFields, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("buildFormDescriptor(org.killbill.billing.account.api.Account, java.util.UUID, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public HostedPaymentPageFormDescriptor buildFormDescriptorWithPaymentControl(final Account account, final UUID paymentMethodId, final Iterable<PluginProperty> customFields, final Iterable<PluginProperty> properties, final PaymentOptions paymentOptions, final CallContext context) {
        throw new UnsupportedOperationException("buildFormDescriptorWithPaymentControl(org.killbill.billing.account.api.Account, java.util.UUID, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.payment.api.PaymentOptions, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public GatewayNotification processNotificationWithPaymentControl(final String notification, final String pluginName, final Iterable<PluginProperty> properties, final PaymentOptions paymentOptions, final CallContext context) {
        throw new UnsupportedOperationException("processNotificationWithPaymentControl(java.lang.String, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.payment.api.PaymentOptions, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
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
    public static class Builder<T extends PaymentGatewayApiImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final PaymentGatewayApi that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PaymentGatewayApiImp build() {
            return new PaymentGatewayApiImp(this.validate());
        }
    }
}
