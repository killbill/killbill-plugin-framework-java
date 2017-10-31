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

import java.math.BigDecimal;

import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.catalog.api.PlanPhasePriceOverride;
import org.killbill.billing.catalog.api.PlanPhaseSpecifier;

public class PluginPlanPhasePriceOverride implements PlanPhasePriceOverride {

    private final String phaseName;
    private final PlanPhaseSpecifier planPhaseSpecifier;
    private final Currency currency;
    private final BigDecimal fixedPrice;
    private final BigDecimal recurringPrice;

    public PluginPlanPhasePriceOverride(final String phaseName,
                                        final BigDecimal recurringPrice,
                                        final Currency currency) {
        this(phaseName, null, currency, null, recurringPrice);
    }

    public PluginPlanPhasePriceOverride(final String phaseName,
                                        final PlanPhaseSpecifier planPhaseSpecifier,
                                        final Currency currency,
                                        final BigDecimal fixedPrice,
                                        final BigDecimal recurringPrice) {
        this.phaseName = phaseName;
        this.planPhaseSpecifier = planPhaseSpecifier;
        this.currency = currency;
        this.fixedPrice = fixedPrice;
        this.recurringPrice = recurringPrice;
    }

    @Override
    public String getPhaseName() {
        return phaseName;
    }

    @Override
    public PlanPhaseSpecifier getPlanPhaseSpecifier() {
        return planPhaseSpecifier;
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    @Override
    public BigDecimal getFixedPrice() {
        return fixedPrice;
    }

    @Override
    public BigDecimal getRecurringPrice() {
        return recurringPrice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PluginPlanPhasePriceOverride{");
        sb.append("phaseName='").append(phaseName).append('\'');
        sb.append(", planPhaseSpecifier=").append(planPhaseSpecifier);
        sb.append(", currency=").append(currency);
        sb.append(", fixedPrice=").append(fixedPrice);
        sb.append(", recurringPrice=").append(recurringPrice);
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

        final PluginPlanPhasePriceOverride that = (PluginPlanPhasePriceOverride) o;

        if (phaseName != null ? !phaseName.equals(that.phaseName) : that.phaseName != null) {
            return false;
        }
        if (planPhaseSpecifier != null ? !planPhaseSpecifier.equals(that.planPhaseSpecifier) : that.planPhaseSpecifier != null) {
            return false;
        }
        if (currency != that.currency) {
            return false;
        }
        if (fixedPrice != null ? fixedPrice.compareTo(that.fixedPrice) != 0 : that.fixedPrice != null) {
            return false;
        }
        return recurringPrice != null ? recurringPrice.compareTo(that.recurringPrice) == 0 : that.recurringPrice == null;
    }

    @Override
    public int hashCode() {
        int result = phaseName != null ? phaseName.hashCode() : 0;
        result = 31 * result + (planPhaseSpecifier != null ? planPhaseSpecifier.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (fixedPrice != null ? fixedPrice.hashCode() : 0);
        result = 31 * result + (recurringPrice != null ? recurringPrice.hashCode() : 0);
        return result;
    }
}
