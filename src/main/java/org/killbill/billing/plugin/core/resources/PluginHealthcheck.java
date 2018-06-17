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

package org.killbill.billing.plugin.core.resources;

import java.util.Map;

import javax.annotation.Nullable;

import org.jooby.MediaType;
import org.jooby.Result;
import org.jooby.Results;
import org.jooby.Status;
import org.killbill.billing.osgi.api.Healthcheck;
import org.killbill.billing.osgi.api.Healthcheck.HealthStatus;
import org.killbill.billing.tenant.api.Tenant;

// Specified in the concrete class
//@Singleton
//@Path("/healthcheck")
public abstract class PluginHealthcheck {

    private static final String CACHE_CONTROL = "Cache-Control";
    private static final String DEFAULT_CACHE_CONTROL = "private, no-cache, no-store, no-transform, must-revalidate";

    protected Result check(final Healthcheck healthcheck, @Nullable final Tenant tenant, @Nullable final Map properties) {
        final HealthStatus healthStatus = healthcheck.getHealthStatus(tenant, properties);
        return buildHealthcheckResponse(healthStatus);
    }

    protected Result buildHealthcheckResponse(final HealthStatus healthStatus) {
        return Results.with(healthStatus.getDetails(), healthStatus.isHealthy() ? Status.OK : Status.SERVICE_UNAVAILABLE)
                      .header(CACHE_CONTROL, DEFAULT_CACHE_CONTROL)
                      .type(MediaType.json);
    }
}
