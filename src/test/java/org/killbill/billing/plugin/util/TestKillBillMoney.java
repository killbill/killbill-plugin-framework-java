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

import org.killbill.billing.catalog.api.Currency;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestKillBillMoney {

    @Test(groups = "fast")
    public void testOf() {
        Assert.assertEquals(KillBillMoney.of(new BigDecimal("10.000000000"), Currency.EUR), new BigDecimal("10.00"));
        Assert.assertEquals(KillBillMoney.of(new BigDecimal("10.000000000"), Currency.GBP), new BigDecimal("10.00"));
        Assert.assertEquals(KillBillMoney.of(new BigDecimal("10.000000000"), Currency.JPY), new BigDecimal("10"));
    }

    @Test(groups = "fast")
    public void testToMinorUnits() {
        Assert.assertEquals(KillBillMoney.toMinorUnits("USD", BigDecimal.ZERO), 0L);
        Assert.assertEquals(KillBillMoney.toMinorUnits("USD", BigDecimal.ONE), 100L);
        Assert.assertEquals(KillBillMoney.toMinorUnits("USD", new BigDecimal("0.99")), 99L);
        // See https://github.com/killbill/killbill/issues/494
        Assert.assertEquals(KillBillMoney.toMinorUnits("USD", new BigDecimal("0.999")), 100L);
        Assert.assertEquals(KillBillMoney.toMinorUnits("USD", BigDecimal.TEN), 1000L);
        Assert.assertEquals(KillBillMoney.toMinorUnits("EUR", new BigDecimal("10.000000000")), 1000L);
        Assert.assertEquals(KillBillMoney.toMinorUnits("GBP", new BigDecimal("10.000000000")), 1000L);
        Assert.assertEquals(KillBillMoney.toMinorUnits("JPY", new BigDecimal("10.000000000")), 10);
    }
}
