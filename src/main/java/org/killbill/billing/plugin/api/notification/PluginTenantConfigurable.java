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

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Nullable;

import com.google.common.base.MoreObjects;

public class PluginTenantConfigurable<C> {

    private static final String MONO_TENANT = "MONO_TENANT";

    private final Map<String, C> perTenantConfigurable = new ConcurrentHashMap<String, C>();

    private C defaultConfigurable;

    public PluginTenantConfigurable() {
        this(null);
    }

    public PluginTenantConfigurable(@Nullable final C defaultConfigurable) {
        this.defaultConfigurable = defaultConfigurable;
    }

    public C getDefaultConfigurable() {
        return defaultConfigurable;
    }

    // Allow for later configuration
    public void setDefaultConfigurable(final C defaultConfigurable) {
        this.defaultConfigurable = defaultConfigurable;
    }

    public C get(@Nullable final UUID kbTenantId) {
        final String key = getKey(kbTenantId);
        final C configurableForTenant = perTenantConfigurable.get(key);
        return MoreObjects.firstNonNull(configurableForTenant, defaultConfigurable);
    }

    public void put(@Nullable final UUID kbTenantId, @Nullable final C configurableForTenant) {
        final String key = getKey(kbTenantId);
        final C oldConfigurable = perTenantConfigurable.put(key, MoreObjects.firstNonNull(configurableForTenant, defaultConfigurable));

        // Cleanup the old value
        if (oldConfigurable != null && oldConfigurable instanceof Closeable && oldConfigurable != defaultConfigurable) {
            try {
                ((Closeable) oldConfigurable).close();
            } catch (final IOException ignored) {
            }
        }
    }

    private String getKey(@Nullable final UUID kbTenantId) {
        return kbTenantId == null ? MONO_TENANT : kbTenantId.toString();
    }
}
