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
import java.util.Objects;

import org.killbill.billing.invoice.api.InvoiceItem;
import org.killbill.billing.invoice.plugin.api.AdditionalItemsResult;
import org.killbill.billing.payment.api.PluginProperty;

public class PluginAdditionalItemsResult extends PluginInvoiceResult implements AdditionalItemsResult {

    private final List<InvoiceItem> additionalItems;

    public PluginAdditionalItemsResult() {
        this(Collections.emptyList(), null);
    }

    public PluginAdditionalItemsResult(final List<InvoiceItem> additionalItems, final Iterable<PluginProperty> adjustedPluginProperties) {
        super(adjustedPluginProperties);
        this.additionalItems = additionalItems;
    }

    @Override
    public List<InvoiceItem> getAdditionalItems() {
        return additionalItems;
    }

    @Override
    public String toString() {
        return "PluginAdditionalItemsResult{" +
               "additionalItems=" + additionalItems +
               ", adjustedPluginProperties=" + adjustedPluginProperties +
               '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PluginAdditionalItemsResult)) {
            return false;
        }
        final PluginAdditionalItemsResult that = (PluginAdditionalItemsResult) o;
        return Objects.equals(additionalItems, that.additionalItems) && Objects.equals(adjustedPluginProperties, that.adjustedPluginProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalItems, adjustedPluginProperties);
    }
}
