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

import org.killbill.billing.notification.plugin.api.ExtBusEvent;
import org.killbill.billing.notification.plugin.api.ExtBusEventType;
import org.killbill.killbill.osgi.libs.killbill.OSGIKillbillEventDispatcher;

public class PluginConfigurationEventHandler implements OSGIKillbillEventDispatcher.OSGIKillbillEventHandler {

    private final PluginConfigurationHandler[] pluginConfigurationHandlers;

    public PluginConfigurationEventHandler(final PluginConfigurationHandler... pluginConfigurationHandlers) {
        this.pluginConfigurationHandlers = pluginConfigurationHandlers;
    }

    @Override
    public void handleKillbillEvent(final ExtBusEvent extBusEvent) {
        if (ExtBusEventType.TENANT_CONFIG_CHANGE.equals(extBusEvent.getEventType()) ||
            ExtBusEventType.TENANT_CONFIG_DELETION.equals(extBusEvent.getEventType())) {
            for (final PluginConfigurationHandler pluginConfigurationHandler : pluginConfigurationHandlers) {
                pluginConfigurationHandler.configure(extBusEvent.getMetaData(), extBusEvent.getTenantId());
            }
        }
    }
}
