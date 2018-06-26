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

import org.killbill.billing.catalog.api.PlanPhasePriceOverride;
import org.killbill.billing.catalog.api.PlanPhaseSpecifier;
import org.killbill.billing.entitlement.api.EntitlementSpecifier;

public class PluginEntitlementSpecifier implements EntitlementSpecifier {

    private final PlanPhaseSpecifier planPhaseSpecifier;
    private final Integer billCycleDay;
    private final List<PlanPhasePriceOverride> overrides;

    public PluginEntitlementSpecifier(final PlanPhaseSpecifier planPhaseSpecifier,
                                      final Integer billCycleDay,
                                      final List<PlanPhasePriceOverride> overrides) {
        this.planPhaseSpecifier = planPhaseSpecifier;
        this.billCycleDay = billCycleDay;
        this.overrides = overrides;
    }

    @Override
    public PlanPhaseSpecifier getPlanPhaseSpecifier() {
        return planPhaseSpecifier;
    }

    @Override
    public Integer getBillCycleDay() {
        return billCycleDay;
    }

    @Override
    public List<PlanPhasePriceOverride> getOverrides() {
        return overrides;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PluginEntitlementSpecifier{");
        sb.append("planPhaseSpecifier=").append(planPhaseSpecifier);
        sb.append(", billCycleDay=").append(billCycleDay);
        sb.append(", overrides=").append(overrides);
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

        final PluginEntitlementSpecifier that = (PluginEntitlementSpecifier) o;

        if (planPhaseSpecifier != null ? !planPhaseSpecifier.equals(that.planPhaseSpecifier) : that.planPhaseSpecifier != null) {
            return false;
        }
        if (billCycleDay != null ? !billCycleDay.equals(that.billCycleDay) : that.billCycleDay != null) {
            return false;
        }
        return overrides != null ? overrides.equals(that.overrides) : that.overrides == null;
    }

    @Override
    public int hashCode() {
        int result = planPhaseSpecifier != null ? planPhaseSpecifier.hashCode() : 0;
        result = 31 * result + (billCycleDay != null ? billCycleDay.hashCode() : 0);
        result = 31 * result + (overrides != null ? overrides.hashCode() : 0);
        return result;
    }
}
