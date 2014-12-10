/*
 * Copyright 2014 Groupon, Inc
 * Copyright 2014 The Billing Project, LLC
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

package org.killbill.billing.plugin.api.routing;

import javax.annotation.Nullable;

import org.joda.time.DateTime;
import org.killbill.billing.routing.plugin.api.OnFailurePaymentRoutingResult;

public class PluginOnFailurePaymentRoutingResult implements OnFailurePaymentRoutingResult {

    private final DateTime nextRetryDate;

    public PluginOnFailurePaymentRoutingResult() {
        this(null);
    }

    public PluginOnFailurePaymentRoutingResult(@Nullable final DateTime nextRetryDate) {
        this.nextRetryDate = nextRetryDate;
    }

    @Override
    public DateTime getNextRetryDate() {
        return nextRetryDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PluginOnFailurePaymentRoutingResult{");
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

        PluginOnFailurePaymentRoutingResult that = (PluginOnFailurePaymentRoutingResult) o;

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
