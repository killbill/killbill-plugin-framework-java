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

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Nullable;

import org.killbill.billing.osgi.libs.killbill.OSGIKillbillAPI;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillLogService;
import org.killbill.billing.plugin.api.notification.PluginConfigurationHandler;
import org.killbill.billing.plugin.api.notification.PluginTenantConfigurable;
import org.osgi.service.log.LogService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public abstract class PaymentPluginTenantConfigurationHandler<T> extends PluginConfigurationHandler {

    private static ObjectMapper yamlObjectMapper = new ObjectMapper(new YAMLFactory());

    private final Collection<UUID> configuredTenants = new HashSet<>();
    private final PluginTenantConfigurable<T> pluginTenantConfigurable = new PluginTenantConfigurable<>();

    private final ObjectReader yamlObjectReader;
    private final String configurationKey;
    private LogService osgiKillbillLogService;

    public PaymentPluginTenantConfigurationHandler(final String pluginName,
                                                   final OSGIKillbillAPI osgiKillbillAPI,
                                                   final OSGIKillbillLogService osgiKillbillLogService,
                                                   final String configurationKey) {
        super(pluginName, osgiKillbillAPI, osgiKillbillLogService);
        this.osgiKillbillLogService = osgiKillbillLogService;

        this.configurationKey = configurationKey;
        final MapType mapType = TypeFactory
                .defaultInstance().constructMapType(Map.class, String.class, Map.class);
        this.yamlObjectReader = yamlObjectMapper.readerFor(mapType);
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
            try {
                final Map<String, Map<String, Object>> configObject = yamlObjectReader.readValue(rawConfiguration);
                final T configurable = createConfigurable(configObject.getOrDefault(configurationKey, Collections
                        .emptyMap()));
                pluginTenantConfigurable.put(kbTenantId, configurable);
            } catch (IOException e) {
                osgiKillbillLogService.log(LogService.LOG_INFO, "Error while parsing YAML configuration, falling back to parsing Properties", e);

                final Properties properties = getTenantConfigurationAsProperties(kbTenantId);
                if (properties != null) {
                    final T configurable = createConfigurable(properties);
                    pluginTenantConfigurable.put(kbTenantId, configurable);
                }
            }
        }
    }

    protected abstract T createConfigurable(final Properties properties);

    protected abstract T createConfigurable(final Map<String, ?> configObject);

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
}
