/*
 * Copyright 2015 Groupon, Inc
 * Copyright 2015 The Billing Project, LLC
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

package org.killbill.billing.plugin.api.notification;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Nullable;

import org.killbill.billing.plugin.api.PluginTenantContext;
import org.killbill.billing.tenant.api.TenantApiException;
import org.killbill.billing.tenant.api.TenantUserApi;
import org.killbill.billing.util.callcontext.TenantContext;
import org.killbill.killbill.osgi.libs.killbill.OSGIKillbillAPI;
import org.killbill.killbill.osgi.libs.killbill.OSGIKillbillLogService;
import org.osgi.service.log.LogService;

public abstract class PluginConfigurationHandler {

    private final String configKeyName;
    private final OSGIKillbillAPI osgiKillbillAPI;
    private final OSGIKillbillLogService osgiKillbillLogService;

    public PluginConfigurationHandler(final String pluginName, final OSGIKillbillAPI osgiKillbillAPI, final OSGIKillbillLogService osgiKillbillLogService) {
        this.configKeyName = "PLUGIN_CONFIG_" + pluginName;
        this.osgiKillbillAPI = osgiKillbillAPI;
        this.osgiKillbillLogService = osgiKillbillLogService;
    }

    protected abstract void configure(@Nullable UUID kbTenantId);

    protected void configure(final String eventConfigKeyName, @Nullable final UUID kbTenantId) {
        if (eventConfigKeyName.equals(configKeyName)) {
            configure(kbTenantId);
        }
    }

    protected Properties getTenantConfigurationAsProperties(@Nullable final UUID kbTenantId) {
        final String tenantConfigurationAsString = getTenantConfigurationAsString(kbTenantId);
        if (tenantConfigurationAsString == null) {
            return null;
        }

        final Properties properties = new Properties();
        try {
            properties.load(new StringReader(tenantConfigurationAsString));
            return properties;
        } catch (final IOException e) {
            osgiKillbillLogService.log(LogService.LOG_WARNING, "Exception while loading properties for key " + configKeyName, e);
            return null;
        }
    }

    protected String getTenantConfigurationAsString(@Nullable final UUID kbTenantId) {
        if (kbTenantId == null) {
            return null;
        }

        final TenantUserApi tenantUserApi = osgiKillbillAPI.getTenantUserApi();
        if (tenantUserApi == null) {
            osgiKillbillLogService.log(LogService.LOG_WARNING, "Unable to retrieve TenantUserApi - skipping reconfiguration for key " + configKeyName);
            return null;
        }

        final TenantContext context = new PluginTenantContext(kbTenantId);
        try {
            final List<String> values = tenantUserApi.getTenantValuesForKey(configKeyName, context);
            return !values.isEmpty() ? values.get(0) : null;
        } catch (final TenantApiException e) {
            osgiKillbillLogService.log(LogService.LOG_WARNING, "Exception while retrieving configuration for key " + configKeyName, e);
            return null;
        }
    }
}
