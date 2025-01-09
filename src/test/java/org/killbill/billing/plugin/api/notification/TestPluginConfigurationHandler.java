/*
 * Copyright 2020-2025 Equinix, Inc
 * Copyright 2014-2025 The Billing Project, LLC
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

import java.util.UUID;

import org.killbill.billing.osgi.libs.killbill.OSGIKillbillAPI;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestPluginConfigurationHandler {

    private PluginConfigurationHandler pluginConfigurationHandler;

    @Mock
    private OSGIKillbillAPI osgiKillbillAPI;

    @Mock
    private ObjectMapper objectMapper;

    @BeforeMethod(groups = "fast")
    void setUp() {
        MockitoAnnotations.openMocks(this);

        pluginConfigurationHandler = spy(new PluginConfigurationHandler("email-notification-plugin", osgiKillbillAPI) {
            @Override
            protected void configure(final UUID kbTenantId) {
                // Empty implementation for testing
            }
        });
    }

    @Test(groups = "fast")
    void testConfigure_withValidJsonKey() throws Exception {
        final String eventConfigKeyName = "{\"key\":\"PLUGIN_CONFIG_email-notification-plugin\"}";
        final UUID kbTenantId = UUID.randomUUID();

        final JsonNode mockJsonNode = mock(JsonNode.class);
        when(mockJsonNode.has("key")).thenReturn(true);
        when(mockJsonNode.get("key")).thenReturn(mock(JsonNode.class));
        when(mockJsonNode.get("key").asText()).thenReturn("PLUGIN_CONFIG_email-notification-plugin");

        when(objectMapper.readTree(eventConfigKeyName)).thenReturn(mockJsonNode);

        pluginConfigurationHandler.configure(eventConfigKeyName, kbTenantId);

        verify(pluginConfigurationHandler, times(1)).configure(kbTenantId);
    }

    @Test(groups = "fast")
    void testConfigure_withPlainString() {
        final String eventConfigKeyName = "PLUGIN_CONFIG_email-notification-plugin";
        final UUID kbTenantId = UUID.randomUUID();

        pluginConfigurationHandler.configure(eventConfigKeyName, kbTenantId);

        verify(pluginConfigurationHandler, times(1)).configure(kbTenantId);
    }
}