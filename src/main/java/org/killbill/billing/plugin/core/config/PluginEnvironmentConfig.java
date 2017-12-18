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

import java.util.Properties;

import com.google.common.base.Strings;

public class PluginEnvironmentConfig {

    public static final String KILL_BILL_NAMESPACE = "org.killbill.";

    public static String getRegion(final Properties properties) {
        // See KillbillServerConfig
        return properties.getProperty(KILL_BILL_NAMESPACE + "server.region");
    }

    public static String getPerRegionOrGlobalProperty(final Properties properties, final String property) {
        final String region = getRegion(properties);
        final String localProperty = properties.getProperty(region + "." + property);
        if (Strings.isNullOrEmpty(localProperty)) {
            return properties.getProperty(property);
        } else {
            return localProperty;
        }
    }
}
