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

package org.killbill.billing.plugin.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.killbill.billing.catalog.api.Currency;

public abstract class KillBillMoney {

    private KillBillMoney() {}

    public static BigDecimal of(final BigDecimal amount, final Currency currency) {
        final CurrencyUnit currencyUnit = CurrencyUnit.of(currency.toString());
        return amount.setScale(currencyUnit.getDecimalPlaces(), BigDecimal.ROUND_HALF_UP);
    }

    public static long toMinorUnits(final String currencyIsoCode, final BigDecimal amountBD) {
        return toMinorUnits(currencyIsoCode, amountBD, RoundingMode.HALF_UP);
    }

    public static long toMinorUnits(final String currencyIsoCode, final BigDecimal amountBD, final RoundingMode roundingMode) {
        // The payment amount specified in minor units, without the decimal separator
        final CurrencyUnit currencyUnit = CurrencyUnit.of(currencyIsoCode);
        return Money.of(currencyUnit, amountBD, roundingMode).getAmountMinorLong();
    }

    public static BigDecimal fromMinorUnits(final String currencyIsoCode, final long amountBD) {
        final CurrencyUnit currencyUnit = CurrencyUnit.of(currencyIsoCode);
        return Money.ofMinor(currencyUnit, amountBD).getAmount();
    }
}
