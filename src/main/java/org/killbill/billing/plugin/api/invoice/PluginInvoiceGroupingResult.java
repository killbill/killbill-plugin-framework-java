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

import java.util.Collections;
import java.util.List;

import org.killbill.billing.invoice.plugin.api.InvoiceGroup;
import org.killbill.billing.invoice.plugin.api.InvoiceGroupingResult;
import org.killbill.billing.payment.api.PluginProperty;

public class PluginInvoiceGroupingResult extends PluginInvoiceResult implements InvoiceGroupingResult {

    private final List<InvoiceGroup> invoiceGroups;

    public PluginInvoiceGroupingResult() {
        this(Collections.emptyList(), null);
    }

    public PluginInvoiceGroupingResult(final List<InvoiceGroup> invoiceGroups, final Iterable<PluginProperty> adjustedPluginProperties) {
        super(adjustedPluginProperties);
        this.invoiceGroups = List.copyOf(invoiceGroups);
    }

    @Override
    public List<InvoiceGroup> getInvoiceGroups() {
        return List.copyOf(invoiceGroups);
    }
}
