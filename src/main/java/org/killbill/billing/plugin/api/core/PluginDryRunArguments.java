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

package org.killbill.billing.plugin.api.core;

import java.util.UUID;
import org.joda.time.LocalDate;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.killbill.billing.catalog.api.BillingActionPolicy;
import org.killbill.billing.entitlement.api.EntitlementSpecifier;
import org.killbill.billing.entitlement.api.SubscriptionEventType;
import org.killbill.billing.invoice.api.DryRunArguments;
import org.killbill.billing.invoice.api.DryRunType;
import org.killbill.billing.invoice.api.boilerplate.DryRunArgumentsImp;

@JsonDeserialize( builder = PluginDryRunArguments.Builder.class )
public class PluginDryRunArguments extends DryRunArgumentsImp {

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

        this(new Builder<>()
                .withDryRunType(dryRunType)
                .withEntitlementSpecifier(entitlementSpecifier)
                .withAction(action)
                .withSubscriptionId(subscriptionId)
                .withEffectiveDate(effectiveDate)
                .withBundleId(bundleId)
                .withBillingActionPolicy(billingActionPolicy)
                .validate());
    }

    protected PluginDryRunArguments(final PluginDryRunArguments.Builder<?> builder) {
        super(builder);
    }

    public PluginDryRunArguments(final PluginDryRunArguments that) {
        super(that);
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PluginDryRunArguments.Builder<T>> 
        extends DryRunArgumentsImp.Builder<T> {

        public Builder() {
        }

        public Builder(final Builder that) {
            super(that);
        }

        @Override
        public Builder validate() {
            return this;
        }

        @Override
        public PluginDryRunArguments build() {
            return new PluginDryRunArguments(this.validate());
        }
    }
}
