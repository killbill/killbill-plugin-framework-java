/*
 * Copyright 2014-2017 Groupon, Inc
 * Copyright 2014-2017 The Billing Project, LLC
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

import java.util.UUID;

import org.joda.time.LocalDate;
import org.killbill.billing.catalog.api.BillingActionPolicy;
import org.killbill.billing.entitlement.api.EntitlementSpecifier;
import org.killbill.billing.entitlement.api.SubscriptionEventType;
import org.killbill.billing.invoice.api.DryRunArguments;
import org.killbill.billing.invoice.api.DryRunType;

public class PluginDryRunArguments implements DryRunArguments {

    private final DryRunType dryRunType;
    private final EntitlementSpecifier entitlementSpecifier;
    private final SubscriptionEventType action;
    private final UUID subscriptionId;
    private final LocalDate effectiveDate;
    private final UUID bundleId;
    private final BillingActionPolicy billingActionPolicy;

    public PluginDryRunArguments(final UUID bundleId, final UUID subscriptionId) {
        this(DryRunType.UPCOMING_INVOICE,
             null,
             null,
             subscriptionId,
             null,
             bundleId,
             null);
    }

    public PluginDryRunArguments(final DryRunType dryRunType,
                                 final EntitlementSpecifier entitlementSpecifier,
                                 final SubscriptionEventType action,
                                 final UUID subscriptionId,
                                 final LocalDate effectiveDate,
                                 final UUID bundleId,
                                 final BillingActionPolicy billingActionPolicy) {
        this.dryRunType = dryRunType;
        this.entitlementSpecifier = entitlementSpecifier;
        this.action = action;
        this.subscriptionId = subscriptionId;
        this.effectiveDate = effectiveDate;
        this.bundleId = bundleId;
        this.billingActionPolicy = billingActionPolicy;
    }

    @Override
    public DryRunType getDryRunType() {
        return dryRunType;
    }

    @Override
    public EntitlementSpecifier getEntitlementSpecifier() {
        return entitlementSpecifier;
    }

    @Override
    public SubscriptionEventType getAction() {
        return action;
    }

    @Override
    public UUID getSubscriptionId() {
        return subscriptionId;
    }

    @Override
    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    @Override
    public UUID getBundleId() {
        return bundleId;
    }

    @Override
    public BillingActionPolicy getBillingActionPolicy() {
        return billingActionPolicy;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PluginDryRunArguments{");
        sb.append("dryRunType=").append(dryRunType);
        sb.append(", entitlementSpecifier=").append(entitlementSpecifier);
        sb.append(", action=").append(action);
        sb.append(", subscriptionId=").append(subscriptionId);
        sb.append(", effectiveDate=").append(effectiveDate);
        sb.append(", bundleId=").append(bundleId);
        sb.append(", billingActionPolicy=").append(billingActionPolicy);
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

        final PluginDryRunArguments that = (PluginDryRunArguments) o;

        if (dryRunType != that.dryRunType) {
            return false;
        }
        if (entitlementSpecifier != null ? !entitlementSpecifier.equals(that.entitlementSpecifier) : that.entitlementSpecifier != null) {
            return false;
        }
        if (action != that.action) {
            return false;
        }
        if (subscriptionId != null ? !subscriptionId.equals(that.subscriptionId) : that.subscriptionId != null) {
            return false;
        }
        if (effectiveDate != null ? effectiveDate.compareTo(that.effectiveDate) != 0 : that.effectiveDate != null) {
            return false;
        }
        if (bundleId != null ? !bundleId.equals(that.bundleId) : that.bundleId != null) {
            return false;
        }
        return billingActionPolicy == that.billingActionPolicy;
    }

    @Override
    public int hashCode() {
        int result = dryRunType != null ? dryRunType.hashCode() : 0;
        result = 31 * result + (entitlementSpecifier != null ? entitlementSpecifier.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (subscriptionId != null ? subscriptionId.hashCode() : 0);
        result = 31 * result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
        result = 31 * result + (bundleId != null ? bundleId.hashCode() : 0);
        result = 31 * result + (billingActionPolicy != null ? billingActionPolicy.hashCode() : 0);
        return result;
    }
}
