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

package org.killbill.billing.plugin.core.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Nullable;

import org.killbill.billing.osgi.libs.killbill.OSGIKillbillAPI;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillLogService;
import org.killbill.billing.plugin.api.notification.PluginConfigurationHandler;
import org.killbill.billing.plugin.api.notification.PluginTenantConfigurable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

public abstract class YAMLPluginTenantConfigurationHandler<U, T> extends PluginConfigurationHandler {

    private static final Logger logger = LoggerFactory.getLogger(YAMLPluginTenantConfigurationHandler.class);

    private final Collection<UUID> configuredTenants = new HashSet<>();
    private final PluginTenantConfigurable<T> pluginTenantConfigurable = new PluginTenantConfigurable<>();

    private final String configurationKey;

    public YAMLPluginTenantConfigurationHandler(final String pluginName,
                                                final OSGIKillbillAPI osgiKillbillAPI,
                                                final OSGIKillbillLogService osgiKillbillLogService) {
        this(pluginName, osgiKillbillAPI, osgiKillbillLogService, null);
    }

    public YAMLPluginTenantConfigurationHandler(final String pluginName,
                                                final OSGIKillbillAPI osgiKillbillAPI,
                                                final OSGIKillbillLogService osgiKillbillLogService,
                                                final String configurationKey) {
        super(pluginName, osgiKillbillAPI, osgiKillbillLogService);
        this.configurationKey = configurationKey;
    }

    public String getConfigurationKey() {
        return configurationKey;
    }

    // Allow for later configuration
    public void setDefaultConfigurable(final T defaultConfigurable) {
        this.pluginTenantConfigurable.setDefaultConfigurable(defaultConfigurable);
    }

    @Override
    protected void configure(@Nullable final UUID kbTenantId) {
        final String rawConfiguration = getTenantConfigurationAsString(kbTenantId);
        if (rawConfiguration != null) {
            final U configObject = parseRawConfiguration(rawConfiguration);
            final T configurable = createConfigurable(configObject);
            pluginTenantConfigurable.put(kbTenantId, configurable);
        }
    }

    protected U parseRawConfiguration(final String rawConfiguration) {
        final Yaml yaml = new Yaml();
        final Object configObject = yaml.load(rawConfiguration);
        if (configurationKey != null &&
            configObject instanceof Map) {
            return (U) ((Map) configObject).get(configurationKey);
        } else {
            return (U) configObject;
        }
    }

    protected T createConfigurable(final U configObject) {
        return (T) configObject;
    }

    public T getConfigurable(@Nullable final UUID kbTenantId) {
        // Initial configuration
        if (kbTenantId != null && !configuredTenants.contains(kbTenantId)) {
            // Make sure to initialize the value for the tenant once
            synchronized (configuredTenants) {
                if (!configuredTenants.contains(kbTenantId)) {
                    configure(kbTenantId);
                    configuredTenants.add(kbTenantId);
                }
            }
        }
        return pluginTenantConfigurable.get(kbTenantId);
    }

    protected static Map<String, ?> propertiesToMap(final Properties properties, @Nullable final String prefix) {
        final int trimLength = prefix == null ? 0 : prefix.length();
        final Map<String, String> map = new HashMap<>();
        for (final String name : properties.stringPropertyNames()) {
            if (prefix == null || name.startsWith(prefix)) {
                map.put(name.substring(trimLength), properties.getProperty(name));
            }
        }
        return map;
    }
}
