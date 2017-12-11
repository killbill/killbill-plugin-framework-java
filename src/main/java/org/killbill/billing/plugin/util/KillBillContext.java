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

package org.killbill.billing.plugin.util;

import java.util.UUID;

import org.slf4j.MDC;

import com.google.common.base.MoreObjects;

public abstract class KillBillContext {

    // See KillbillMDCInsertingServletFilter
    private static final String MDC_REQUEST_ID = "req.requestId";

    private KillBillContext() {}

    public static String getXRequestId() {
        // We know Kill Bill passed the X-Request-Id from the user in the slf4j MDC. Maybe one day, there will be a real API for it?
        return MoreObjects.firstNonNull(MDC.get(MDC_REQUEST_ID), UUID.randomUUID().toString());
    }
}
