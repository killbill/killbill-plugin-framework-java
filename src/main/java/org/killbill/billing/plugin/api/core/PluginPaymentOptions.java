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

package org.killbill.billing.plugin.api.core;

import java.util.List;

import org.killbill.billing.payment.api.PaymentOptions;

import com.google.common.collect.ImmutableList;

public class PluginPaymentOptions implements PaymentOptions {

    private final boolean isExternalPayment;
    private final List<String> paymentControlPluginNames;

    public PluginPaymentOptions() {
        this(false, ImmutableList.<String>of());
    }

    public PluginPaymentOptions(final List<String> paymentControlPluginNames) {
        this(false, paymentControlPluginNames);
    }

    public PluginPaymentOptions(final boolean isExternalPayment, final List<String> paymentControlPluginNames) {
        this.isExternalPayment = isExternalPayment;
        this.paymentControlPluginNames = paymentControlPluginNames;
    }

    @Override
    public boolean isExternalPayment() {
        return isExternalPayment;
    }

    @Override
    public List<String> getPaymentControlPluginNames() {
        return paymentControlPluginNames;
    }

    @Override
    public String toString() {
        return "PluginPaymentOptions{" +
               "isExternalPayment=" + isExternalPayment +
               ", paymentControlPluginNames=" + paymentControlPluginNames +
               '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final PluginPaymentOptions that = (PluginPaymentOptions) o;

        if (isExternalPayment != that.isExternalPayment) {
            return false;
        }
        return paymentControlPluginNames != null ? paymentControlPluginNames.equals(that.paymentControlPluginNames) : that.paymentControlPluginNames == null;
    }

    @Override
    public int hashCode() {
        int result = (isExternalPayment ? 1 : 0);
        result = 31 * result + (paymentControlPluginNames != null ? paymentControlPluginNames.hashCode() : 0);
        return result;
    }
}
