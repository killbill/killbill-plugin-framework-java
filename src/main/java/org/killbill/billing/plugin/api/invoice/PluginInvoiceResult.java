/*
 * Copyright 2020-2022 Equinix, Inc
 * Copyright 2014-2022 The Billing Project, LLC
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

import org.killbill.billing.invoice.plugin.api.InvoiceResult;
import org.killbill.billing.payment.api.PluginProperty;

public class PluginInvoiceResult implements InvoiceResult {

    final Iterable<PluginProperty> adjustedPluginProperties;

    public PluginInvoiceResult() {
        this(null);
    }

    public PluginInvoiceResult(final Iterable<PluginProperty> adjustedPluginProperties) {
        this.adjustedPluginProperties = adjustedPluginProperties;
    }

    @Override
    public Iterable<PluginProperty> getAdjustedPluginProperties() {
        return adjustedPluginProperties;
    }
}
