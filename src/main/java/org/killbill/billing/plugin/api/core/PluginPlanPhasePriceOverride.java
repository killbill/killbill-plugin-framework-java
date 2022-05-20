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

import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.catalog.api.PlanPhasePriceOverride;
import org.killbill.billing.catalog.api.PlanPhaseSpecifier;
import org.killbill.billing.catalog.api.UsagePriceOverride;
import org.killbill.billing.catalog.api.boilerplate.PlanPhasePriceOverrideImp;

@JsonDeserialize( builder = PluginPlanPhasePriceOverride.Builder.class )
public class PluginPlanPhasePriceOverride extends PlanPhasePriceOverrideImp {

    public PluginPlanPhasePriceOverride(final String phaseName,
            final BigDecimal recurringPrice,
            final Currency currency) {
        this(phaseName, null, currency, null, recurringPrice, null);
    }

    public PluginPlanPhasePriceOverride(final String phaseName,
            final PlanPhaseSpecifier planPhaseSpecifier,
            final Currency currency,
            final BigDecimal fixedPrice,
            final BigDecimal recurringPrice,
            final List<UsagePriceOverride> usagePriceOverrides) {

        this(new Builder<>()
                .withPhaseName(phaseName)
                .withPlanPhaseSpecifier(planPhaseSpecifier)
                .withCurrency(currency)
                .withFixedPrice(fixedPrice)
                .withRecurringPrice(recurringPrice)
                .withUsagePriceOverrides(usagePriceOverrides)
                .validate());
    }

    protected PluginPlanPhasePriceOverride(final PluginPlanPhasePriceOverride.Builder<?> builder) {
        super(builder);
    }

    public PluginPlanPhasePriceOverride(final PluginPlanPhasePriceOverride that) {
        super(that);
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PluginPlanPhasePriceOverride.Builder<T>> 
        extends PlanPhasePriceOverrideImp.Builder<T> {

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
        public PluginPlanPhasePriceOverride build() {
            return new PluginPlanPhasePriceOverride(this.validate());
        }
    }
}
