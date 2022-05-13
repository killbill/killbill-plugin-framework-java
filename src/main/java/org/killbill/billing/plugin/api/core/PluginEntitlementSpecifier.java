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

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.killbill.billing.catalog.api.PlanPhasePriceOverride;
import org.killbill.billing.catalog.api.PlanPhaseSpecifier;
import org.killbill.billing.entitlement.api.EntitlementSpecifier;
import org.killbill.billing.entitlement.api.boilerplate.EntitlementSpecifierImp;

@JsonDeserialize( builder = PluginEntitlementSpecifier.Builder.class )
public class PluginEntitlementSpecifier extends EntitlementSpecifierImp {

    public PluginEntitlementSpecifier(final PlanPhaseSpecifier planPhaseSpecifier,
            final Integer billCycleDay,
            final String externalKey,
            final List<PlanPhasePriceOverride> overrides) {

        this(new Builder<>()
                .withPlanPhaseSpecifier(planPhaseSpecifier)
                .withBillCycleDay(billCycleDay)
                .withExternalKey(externalKey)
                .withOverrides(overrides)
                .validate());
    }

    protected PluginEntitlementSpecifier(final PluginEntitlementSpecifier.Builder<?> builder) {
        super(builder);
    }

    public PluginEntitlementSpecifier(final PluginEntitlementSpecifier that) {
        super(that);
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PluginEntitlementSpecifier.Builder<T>> 
        extends EntitlementSpecifierImp.Builder<T> {

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
        public PluginEntitlementSpecifier build() {
            return new PluginEntitlementSpecifier(this.validate());
        }
    }
}
