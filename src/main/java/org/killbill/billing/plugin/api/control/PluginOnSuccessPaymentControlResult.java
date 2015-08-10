/*
 * Copyright 2014-2015 Groupon, Inc
 * Copyright 2014-2015 The Billing Project, LLC
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

package org.killbill.billing.plugin.api.control;

import javax.annotation.Nullable;

import org.killbill.billing.control.plugin.api.OnSuccessPaymentControlResult;
import org.killbill.billing.payment.api.PluginProperty;

public class PluginOnSuccessPaymentControlResult implements OnSuccessPaymentControlResult {

    private final Iterable<PluginProperty> adjustedPluginProperties;

    public PluginOnSuccessPaymentControlResult() {
        this(null);
    }

    public PluginOnSuccessPaymentControlResult(@Nullable final Iterable<PluginProperty> adjustedPluginProperties) {
        this.adjustedPluginProperties = adjustedPluginProperties;
    }

    @Override
    public Iterable<PluginProperty> getAdjustedPluginProperties() {
        return adjustedPluginProperties;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PluginOnSuccessPaymentControlResult{");
        sb.append("adjustedPluginProperties=").append(adjustedPluginProperties);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PluginOnSuccessPaymentControlResult that = (PluginOnSuccessPaymentControlResult) o;

        return !(adjustedPluginProperties != null ? !adjustedPluginProperties.equals(that.adjustedPluginProperties) : that.adjustedPluginProperties != null);

    }

    @Override
    public int hashCode() {
        return adjustedPluginProperties != null ? adjustedPluginProperties.hashCode() : 0;
    }
}
