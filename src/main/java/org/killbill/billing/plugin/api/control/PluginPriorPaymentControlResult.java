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

package org.killbill.billing.plugin.api.control;

import java.math.BigDecimal;
import java.util.UUID;

import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.control.plugin.api.PriorPaymentControlResult;
import org.killbill.billing.payment.api.PluginProperty;

public class PluginPriorPaymentControlResult implements PriorPaymentControlResult {

    private final boolean isAborted;
    private final BigDecimal adjustedAmount;
    private final Currency adjustedCurrency;
    private final UUID adjustedPaymentMethodId;
    private final String adjustedPluginName;
    private final Iterable<PluginProperty> adjustedPluginProperties;

    public PluginPriorPaymentControlResult(final boolean isAborted) {
        this(isAborted, null, null, null, null, null);
    }

    public PluginPriorPaymentControlResult(final boolean isAborted,
                                           final BigDecimal adjustedAmount,
                                           final Currency adjustedCurrency,
                                           final UUID adjustedPaymentMethodId,
                                           final String adjustedPluginName,
                                           final Iterable<PluginProperty> adjustedPluginProperties) {
        this.isAborted = isAborted;
        this.adjustedAmount = adjustedAmount;
        this.adjustedCurrency = adjustedCurrency;
        this.adjustedPaymentMethodId = adjustedPaymentMethodId;
        this.adjustedPluginName = adjustedPluginName;
        this.adjustedPluginProperties = adjustedPluginProperties;
    }

    @Override
    public boolean isAborted() {
        return isAborted;
    }

    @Override
    public BigDecimal getAdjustedAmount() {
        return adjustedAmount;
    }

    @Override
    public Currency getAdjustedCurrency() {
        return adjustedCurrency;
    }

    @Override
    public UUID getAdjustedPaymentMethodId() {
        return adjustedPaymentMethodId;
    }

    @Override
    public String getAdjustedPluginName() {
        return adjustedPluginName;
    }

    @Override
    public Iterable<PluginProperty> getAdjustedPluginProperties() {
        return adjustedPluginProperties;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PluginPriorPaymentControlResult{");
        sb.append("isAborted=").append(isAborted);
        sb.append(", adjustedAmount=").append(adjustedAmount);
        sb.append(", adjustedCurrency=").append(adjustedCurrency);
        sb.append(", adjustedPaymentMethodId=").append(adjustedPaymentMethodId);
        sb.append(", adjustedPluginName='").append(adjustedPluginName).append('\'');
        sb.append(", adjustedPluginProperties=").append(adjustedPluginProperties);
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

        final PluginPriorPaymentControlResult that = (PluginPriorPaymentControlResult) o;

        if (isAborted != that.isAborted) {
            return false;
        }
        if (adjustedAmount != null ? adjustedAmount.compareTo(that.adjustedAmount) != 0 : that.adjustedAmount != null) {
            return false;
        }
        if (adjustedCurrency != that.adjustedCurrency) {
            return false;
        }
        if (adjustedPaymentMethodId != null ? !adjustedPaymentMethodId.equals(that.adjustedPaymentMethodId) : that.adjustedPaymentMethodId != null) {
            return false;
        }
        if (adjustedPluginName != null ? !adjustedPluginName.equals(that.adjustedPluginName) : that.adjustedPluginName != null) {
            return false;
        }
        return adjustedPluginProperties != null ? adjustedPluginProperties.equals(that.adjustedPluginProperties) : that.adjustedPluginProperties == null;
    }

    @Override
    public int hashCode() {
        int result = (isAborted ? 1 : 0);
        result = 31 * result + (adjustedAmount != null ? adjustedAmount.hashCode() : 0);
        result = 31 * result + (adjustedCurrency != null ? adjustedCurrency.hashCode() : 0);
        result = 31 * result + (adjustedPaymentMethodId != null ? adjustedPaymentMethodId.hashCode() : 0);
        result = 31 * result + (adjustedPluginName != null ? adjustedPluginName.hashCode() : 0);
        result = 31 * result + (adjustedPluginProperties != null ? adjustedPluginProperties.hashCode() : 0);
        return result;
    }
}
