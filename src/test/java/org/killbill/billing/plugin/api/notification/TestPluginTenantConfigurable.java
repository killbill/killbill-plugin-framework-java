/*
 * Copyright 2014-2020 Groupon, Inc
 * Copyright 2020-2020 Equinix, Inc
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

package org.killbill.billing.plugin.api.notification;

import java.util.UUID;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPluginTenantConfigurable {

    @Test(groups = "fast")
    public void testConfigurationForTenant() throws Exception {
        final UUID kbTenantIdA = UUID.randomUUID();
        final UUID kbTenantIdB = UUID.randomUUID();

        final String defaultString = "DEFAULT";
        final PluginTenantConfigurable<String> testTenantConfigurable = new PluginTenantConfigurable<String>(defaultString);

        // Tenant not yet configured, default to the fallback value
        Assert.assertEquals(testTenantConfigurable.get(kbTenantIdA), defaultString);

        // Configure another tenant
        testTenantConfigurable.put(kbTenantIdB, "B");
        Assert.assertEquals(testTenantConfigurable.get(kbTenantIdA), defaultString);
        Assert.assertEquals(testTenantConfigurable.get(kbTenantIdB), "B");

        // Configure the initial tenant
        testTenantConfigurable.put(kbTenantIdA, "A");
        Assert.assertEquals(testTenantConfigurable.get(kbTenantIdA), "A");
        Assert.assertEquals(testTenantConfigurable.get(kbTenantIdB), "B");
    }

    @Test(groups = "fast")
    public void testCloseable() throws Exception {
        final UUID kbTenantIdA = UUID.randomUUID();
        final UUID kbTenantIdB = UUID.randomUUID();

        final CloseableTest defaultCloseableTest = new CloseableTest();
        final PluginTenantConfigurable<CloseableTest> testTenantConfigurable = new PluginTenantConfigurable<CloseableTest>(defaultCloseableTest);

        testTenantConfigurable.put(kbTenantIdA, null);
        Assert.assertFalse(defaultCloseableTest.isClosed());

        final CloseableTest closeableTestA1 = new CloseableTest();
        testTenantConfigurable.put(kbTenantIdA, closeableTestA1);
        Assert.assertFalse(defaultCloseableTest.isClosed());
        Assert.assertFalse(closeableTestA1.isClosed());

        final CloseableTest closeableTestA2 = new CloseableTest();
        testTenantConfigurable.put(kbTenantIdA, closeableTestA2);
        Assert.assertFalse(defaultCloseableTest.isClosed());
        Assert.assertTrue(closeableTestA1.isClosed());
        Assert.assertFalse(closeableTestA2.isClosed());

        final CloseableTest closeableTestB = new CloseableTest();
        testTenantConfigurable.put(kbTenantIdB, closeableTestB);
        Assert.assertFalse(defaultCloseableTest.isClosed());
        Assert.assertTrue(closeableTestA1.isClosed());
        Assert.assertFalse(closeableTestA2.isClosed());
        Assert.assertFalse(closeableTestB.isClosed());

        testTenantConfigurable.put(kbTenantIdA, null);
        Assert.assertFalse(defaultCloseableTest.isClosed());
        Assert.assertTrue(closeableTestA1.isClosed());
        Assert.assertTrue(closeableTestA2.isClosed());
        Assert.assertFalse(closeableTestB.isClosed());

        testTenantConfigurable.put(kbTenantIdA, defaultCloseableTest);
        Assert.assertFalse(defaultCloseableTest.isClosed());
        Assert.assertTrue(closeableTestA1.isClosed());
        Assert.assertTrue(closeableTestA2.isClosed());
        Assert.assertFalse(closeableTestB.isClosed());
    }

    @Test (groups = "fast")
    public void testDeleteWitDefault() {
        final UUID kbTenantIdA = UUID.randomUUID();

        final CloseableTest defaultCloseableTest = new CloseableTest();
        final PluginTenantConfigurable<CloseableTest> testTenantConfigurable = new PluginTenantConfigurable<CloseableTest>(defaultCloseableTest);
        final CloseableTest closeableTest = new CloseableTest();

        testTenantConfigurable.put(kbTenantIdA, closeableTest);
        Assert.assertFalse(closeableTest.isClosed());
        Assert.assertFalse(defaultCloseableTest.isClosed());

        // simulate TENANT_CONFIG_DELETION
        testTenantConfigurable.put(kbTenantIdA, null);
        Assert.assertTrue(closeableTest.isClosed());
        Assert.assertFalse(defaultCloseableTest.isClosed());
    }
    @Test (groups = "fast")
    public void testDeleteWithoutDefault() {
        final UUID kbTenantIdA = UUID.randomUUID();

        final PluginTenantConfigurable<CloseableTest> testTenantConfigurable = new PluginTenantConfigurable<CloseableTest>();
        final CloseableTest closeableTest = new CloseableTest();

        testTenantConfigurable.put(kbTenantIdA, closeableTest);
        Assert.assertFalse(closeableTest.isClosed());

        // simulate TENANT_CONFIG_DELETION
        testTenantConfigurable.put(kbTenantIdA, null);
        Assert.assertTrue(closeableTest.isClosed());
    }
}
