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
import java.util.Map;
import java.util.UUID;

import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.plugin.api.GatewayNotification;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class PluginGatewayNotification implements GatewayNotification {

    protected final UUID kbPaymentId;
    protected final int status;
    protected final String entity;
    protected final Map<String, List<String>> headers;
    protected final List<PluginProperty> properties;

    public PluginGatewayNotification(final String entity) {
        this(null,
             200,
             entity,
             ImmutableMap.<String, List<String>>of(),
             ImmutableList.<PluginProperty>of());
    }

    public PluginGatewayNotification(final UUID kbPaymentId,
                                     final int status,
                                     final String entity,
                                     final Map<String, List<String>> headers,
                                     final List<PluginProperty> properties) {
        this.kbPaymentId = kbPaymentId;
        this.status = status;
        this.entity = entity;
        this.headers = headers;
        this.properties = properties;
    }

    @Override
    public UUID getKbPaymentId() {
        return kbPaymentId;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getEntity() {
        return entity;
    }

    @Override
    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    @Override
    public List<PluginProperty> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PluginGatewayNotification{");
        sb.append("kbPaymentId=").append(kbPaymentId);
        sb.append(", status=").append(status);
        sb.append(", entity='").append(entity).append('\'');
        sb.append(", headers=").append(headers);
        sb.append(", properties=").append(properties);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final PluginGatewayNotification that = (PluginGatewayNotification) o;

        if (status != that.status) {
            return false;
        }
        if (entity != null ? !entity.equals(that.entity) : that.entity != null) {
            return false;
        }
        if (headers != null ? !headers.equals(that.headers) : that.headers != null) {
            return false;
        }
        if (kbPaymentId != null ? !kbPaymentId.equals(that.kbPaymentId) : that.kbPaymentId != null) {
            return false;
        }
        if (properties != null ? !properties.equals(that.properties) : that.properties != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = kbPaymentId != null ? kbPaymentId.hashCode() : 0;
        result = 31 * result + status;
        result = 31 * result + (entity != null ? entity.hashCode() : 0);
        result = 31 * result + (headers != null ? headers.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }
}
