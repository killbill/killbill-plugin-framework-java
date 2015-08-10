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

import org.joda.time.DateTime;
import org.killbill.billing.control.plugin.api.OnFailurePaymentControlResult;
import org.killbill.billing.payment.api.PluginProperty;

public class PluginOnFailurePaymentControlResult implements OnFailurePaymentControlResult {

    private final DateTime nextRetryDate;
    private final Iterable<PluginProperty> adjustedPluginProperties;

    public PluginOnFailurePaymentControlResult() {
        this(null);
    }

    public PluginOnFailurePaymentControlResult(@Nullable final DateTime nextRetryDate) {
        this(nextRetryDate, null);
    }

    public PluginOnFailurePaymentControlResult(@Nullable final DateTime nextRetryDate, @Nullable final Iterable<PluginProperty> adjustedPluginProperties) {
        this.nextRetryDate = nextRetryDate;
        this.adjustedPluginProperties = adjustedPluginProperties;
    }

    @Override
    public DateTime getNextRetryDate() {
        return nextRetryDate;
    }

    @Override
    public Iterable<PluginProperty> getAdjustedPluginProperties() {
        return adjustedPluginProperties;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PluginOnFailurePaymentControlResult{");
        sb.append("nextRetryDate=").append(nextRetryDate);
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

        PluginOnFailurePaymentControlResult that = (PluginOnFailurePaymentControlResult) o;

        if (nextRetryDate != null ? !nextRetryDate.equals(that.nextRetryDate) : that.nextRetryDate != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return nextRetryDate != null ? nextRetryDate.hashCode() : 0;
    }
}
