/*
 * Copyright 2015-2016 Groupon, Inc
 * Copyright 2015-2016 The Billing Project, LLC
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

import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Nullable;

import org.killbill.billing.osgi.libs.killbill.OSGIKillbillAPI;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillLogService;

public abstract class PluginTenantConfigurableConfigurationHandler<C> extends PluginConfigurationHandler {

    private final Collection<UUID> configuredTenants = new HashSet<UUID>();
    private final PluginTenantConfigurable<C> pluginTenantConfigurable = new PluginTenantConfigurable<C>();

    public PluginTenantConfigurableConfigurationHandler(final String pluginName,
                                                        final OSGIKillbillAPI osgiKillbillAPI,
                                                        final OSGIKillbillLogService osgiKillbillLogService) {
        super(pluginName, osgiKillbillAPI, osgiKillbillLogService);
    }

    protected abstract C createConfigurable(final Properties properties);

    // Allow for later configuration
    public void setDefaultConfigurable(final C defaultConfigurable) {
        this.pluginTenantConfigurable.setDefaultConfigurable(defaultConfigurable);
    }

    @Override
    protected void configure(@Nullable final UUID kbTenantId) {
        final Properties properties = getTenantConfigurationAsProperties(kbTenantId);
        if (properties == null) {
            // Invalid configuration or tenant not configured, we will default to the global configurable (or previous configuration)
            return;
        }

        final C configurable = createConfigurable(properties);
        pluginTenantConfigurable.put(kbTenantId, configurable);
    }

    public C getConfigurable(@Nullable final UUID kbTenantId) {
        // Initial configuration
        if (kbTenantId != null && !configuredTenants.contains(kbTenantId)) {
            configure(kbTenantId);
            configuredTenants.add(kbTenantId);
        }
        return pluginTenantConfigurable.get(kbTenantId);
    }
}
