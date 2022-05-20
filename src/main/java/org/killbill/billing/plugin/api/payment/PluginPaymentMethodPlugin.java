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

package org.killbill.billing.plugin.api.payment;

import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.killbill.billing.payment.api.PaymentMethodPlugin;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.api.boilerplate.PaymentMethodPluginImp;

@JsonDeserialize( builder = PluginPaymentMethodPlugin.Builder.class )
public class PluginPaymentMethodPlugin extends PaymentMethodPluginImp {

    public PluginPaymentMethodPlugin(final UUID kbPaymentMethodId,
            final String externalPaymentMethodId,
            final boolean isDefaultPaymentMethod,
            final List<PluginProperty> properties) {

        this(new Builder<>()
                .withKbPaymentMethodId(kbPaymentMethodId)
                .withExternalPaymentMethodId(externalPaymentMethodId)
                .withIsDefaultPaymentMethod(isDefaultPaymentMethod)
                .withProperties(properties)
                .validate());
    }

    protected PluginPaymentMethodPlugin(final PluginPaymentMethodPlugin.Builder<?> builder) {
        super(builder);
    }

    public PluginPaymentMethodPlugin(final PluginPaymentMethodPlugin that) {
        super(that);
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PluginPaymentMethodPlugin.Builder<T>> 
        extends PaymentMethodPluginImp.Builder<T> {

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
        public PluginPaymentMethodPlugin build() {
            return new PluginPaymentMethodPlugin(this.validate());
        }
    }
}
