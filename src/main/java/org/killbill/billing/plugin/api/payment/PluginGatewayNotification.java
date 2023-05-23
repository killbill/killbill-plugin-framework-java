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

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.plugin.api.boilerplate.GatewayNotificationImp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize( builder = PluginGatewayNotification.Builder.class )
public class PluginGatewayNotification extends GatewayNotificationImp {

    public PluginGatewayNotification(final String entity) {
        this(null,
             200,
             entity,
             Collections.emptyMap(),
             Collections.emptyList());
    }

    public PluginGatewayNotification(final UUID kbPaymentId,
            final int status,
            final String entity,
            final Map<String, List<String>> headers,
            final List<PluginProperty> properties) {
        this(new Builder<>()
                .withKbPaymentId(kbPaymentId)
                .withStatus(status)
                .withEntity(entity)
                .withHeaders(headers)
                .withProperties(properties)
                .validate());
    }

    protected PluginGatewayNotification(final PluginGatewayNotification.Builder<?> builder) {
        super(builder);
    }

    public PluginGatewayNotification(final PluginGatewayNotification that) {
        super(that);
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PluginGatewayNotification.Builder<T>> 
        extends GatewayNotificationImp.Builder<T> {

        public Builder() {
            this.withStatus(200);
            this.withHeaders(Collections.emptyMap());
            this.withProperties(Collections.emptyList());
        }

        public Builder(final Builder that) {
            super(that);
        }

        @Override
        public Builder validate() {
          return this;
        }

        @Override
        public PluginGatewayNotification build() {
            return new PluginGatewayNotification(validate());
        }
    }
}
