/*
 * Copyright 2014-2018 Groupon, Inc
 * Copyright 2014-2018 The Billing Project, LLC
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

package org.killbill.billing.plugin.api.invoice;

import org.joda.time.DateTime;
import org.killbill.billing.invoice.plugin.api.PriorInvoiceResult;

public class PluginPriorInvoiceResult implements PriorInvoiceResult {

    private final boolean isAborted;
    private final DateTime rescheduleDate;

    public PluginPriorInvoiceResult() {
        this(false);
    }

    public PluginPriorInvoiceResult(final boolean isAborted) {
        this(isAborted, null);
    }

    public PluginPriorInvoiceResult(final DateTime rescheduleDate) {
        this(false, rescheduleDate);
    }

    public PluginPriorInvoiceResult(final boolean isAborted, final DateTime rescheduleDate) {
        this.isAborted = isAborted;
        this.rescheduleDate = rescheduleDate;
    }

    @Override
    public boolean isAborted() {
        return isAborted;
    }

    @Override
    public DateTime getRescheduleDate() {
        return rescheduleDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PluginPriorInvoiceResult{");
        sb.append("isAborted=").append(isAborted);
        sb.append(", rescheduleDate=").append(rescheduleDate);
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

        final PluginPriorInvoiceResult that = (PluginPriorInvoiceResult) o;

        if (isAborted != that.isAborted) {
            return false;
        }
        return rescheduleDate != null ? rescheduleDate.compareTo(that.rescheduleDate) == 0 : that.rescheduleDate == null;
    }

    @Override
    public int hashCode() {
        int result = (isAborted ? 1 : 0);
        result = 31 * result + (rescheduleDate != null ? rescheduleDate.hashCode() : 0);
        return result;
    }
}
