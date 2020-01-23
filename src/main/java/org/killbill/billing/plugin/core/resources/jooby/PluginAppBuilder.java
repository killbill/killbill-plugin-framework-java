/*
 * Copyright 2014-2020 Groupon, Inc
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

package org.killbill.billing.plugin.core.resources.jooby;

import java.util.LinkedList;
import java.util.List;

import org.jooby.json.Jackson;
import org.jooby.servlet.ServerInitializer;
import org.killbill.billing.osgi.libs.killbill.OSGIConfigPropertiesService;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillAPI;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillClock;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillDataSource;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillLogService;
import org.killbill.billing.plugin.core.resources.PluginHealthcheck;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValueFactory;

public class PluginAppBuilder {

    public static final ObjectMapper DEFAULT_OBJECT_MAPPER = new ObjectMapper();

    static {
        DEFAULT_OBJECT_MAPPER.registerModule(new JodaModule());
        DEFAULT_OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    private final List<Object> services = new LinkedList<Object>();
    private final List<Class> routeClasses = new LinkedList<Class>();

    private Jackson jackson;
    private Config config;

    public PluginAppBuilder(final String pluginName) {
        withConfig(ConfigFactory.empty()
                                .withValue("application.path", ConfigValueFactory.fromAnyRef(String.format("/plugins/%s/", pluginName)))
                                .withValue("server.module", ConfigValueFactory.fromAnyRef(ServerInitializer.ServletModule.class.getName())));

        withObjectMapper(DEFAULT_OBJECT_MAPPER);
    }

    public PluginAppBuilder(final String pluginName,
                            final OSGIKillbillAPI killbillAPI,
                            final OSGIKillbillLogService logService,
                            final OSGIKillbillDataSource dataSource,
                            final OSGIKillbillClock clock,
                            final OSGIConfigPropertiesService configProperties) {
        this(pluginName);

        withService(killbillAPI);
        withService(logService);
        withService(dataSource);
        withService(clock);
        withService(configProperties);

        withRouteClass(PluginHealthcheck.class);
    }

    public PluginAppBuilder withObjectMapper(final ObjectMapper objectMapper) {
        this.jackson = new Jackson(objectMapper);
        return this;
    }

    public PluginAppBuilder withJackson(final Jackson jackson) {
        this.jackson = jackson;
        return this;
    }

    public PluginAppBuilder withService(final Object service) {
        services.add(service);
        return this;
    }

    public PluginAppBuilder withRouteClass(final Class routeClass) {
        routeClasses.add(routeClass);
        return this;
    }

    public PluginAppBuilder withConfig(final Config config) {
        this.config = config;
        return this;
    }

    public PluginAppBuilder withConfigValue(final String path, final Object value) {
        this.config = this.config.withValue(path, ConfigValueFactory.fromAnyRef(value));
        return this;
    }

    public PluginApp build() {
        final PluginApp app = new PluginApp(jackson, services, routeClasses);
        app.use(config);
        return app;
    }
}
