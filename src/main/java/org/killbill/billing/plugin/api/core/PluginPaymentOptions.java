/*
 * Copyright 2014-2020 Groupon, Inc
 * Copyright 2020-2020 Equinix, Inc
 * Copyright 2014-2020 The Billing Project, LLC
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

package org.killbill.billing.plugin.api.core;

import java.util.Collections;
import java.util.List;

import org.killbill.billing.payment.api.boilerplate.PaymentOptionsImp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize( builder = PluginPaymentOptions.Builder.class )
public class PluginPaymentOptions extends PaymentOptionsImp {

    public PluginPaymentOptions() {
        this(false, Collections.emptyList());
    }

    public PluginPaymentOptions(final List<String> paymentControlPluginNames) {
        this(false, paymentControlPluginNames);
    }

    public PluginPaymentOptions(final boolean isExternalPayment, final List<String> paymentControlPluginNames) {
        this(new Builder<>()
        .withIsExternalPayment(isExternalPayment)
        .withPaymentControlPluginNames(paymentControlPluginNames)
        .validate());

    }

    protected PluginPaymentOptions(final PluginPaymentOptions.Builder<?> builder) {
        super(builder);
    }

    public PluginPaymentOptions(final PluginPaymentOptions that) {
        super(that);
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PluginPaymentOptions.Builder<T>> 
        extends PaymentOptionsImp.Builder<T> {

        public Builder() {
        }

        public Builder(final Builder that) {
            super(that);
        }

        @Override
        public Builder validate() {
            return this;
        }

        @Override
        public PluginPaymentOptions build() {
            return new PluginPaymentOptions(this.validate());
        }
    }
}
