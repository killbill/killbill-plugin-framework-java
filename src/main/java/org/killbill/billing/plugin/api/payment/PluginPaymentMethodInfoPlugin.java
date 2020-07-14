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

import java.util.UUID;

import org.killbill.billing.payment.plugin.api.PaymentMethodInfoPlugin;

public class PluginPaymentMethodInfoPlugin implements PaymentMethodInfoPlugin {

    protected final UUID accountId;
    protected final UUID paymentMethodId;
    protected final boolean isDefault;
    protected final String externalPaymentMethodId;

    public PluginPaymentMethodInfoPlugin(final UUID accountId,
                                         final UUID paymentMethodId,
                                         final boolean isDefault,
                                         final String externalPaymentMethodId) {
        this.accountId = accountId;
        this.paymentMethodId = paymentMethodId;
        this.isDefault = isDefault;
        this.externalPaymentMethodId = externalPaymentMethodId;
    }

    @Override
    public UUID getAccountId() {
        return accountId;
    }

    @Override
    public UUID getPaymentMethodId() {
        return paymentMethodId;
    }

    @Override
    public boolean isDefault() {
        return isDefault;
    }

    @Override
    public String getExternalPaymentMethodId() {
        return externalPaymentMethodId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PluginPaymentMethodInfoPlugin{");
        sb.append("accountId=").append(accountId);
        sb.append(", paymentMethodId=").append(paymentMethodId);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", externalPaymentMethodId='").append(externalPaymentMethodId).append('\'');
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

        final PluginPaymentMethodInfoPlugin that = (PluginPaymentMethodInfoPlugin) o;

        if (isDefault != that.isDefault) {
            return false;
        }
        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) {
            return false;
        }
        if (externalPaymentMethodId != null ? !externalPaymentMethodId.equals(that.externalPaymentMethodId) : that.externalPaymentMethodId != null) {
            return false;
        }
        if (paymentMethodId != null ? !paymentMethodId.equals(that.paymentMethodId) : that.paymentMethodId != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountId != null ? accountId.hashCode() : 0;
        result = 31 * result + (paymentMethodId != null ? paymentMethodId.hashCode() : 0);
        result = 31 * result + (isDefault ? 1 : 0);
        result = 31 * result + (externalPaymentMethodId != null ? externalPaymentMethodId.hashCode() : 0);
        return result;
    }
}
