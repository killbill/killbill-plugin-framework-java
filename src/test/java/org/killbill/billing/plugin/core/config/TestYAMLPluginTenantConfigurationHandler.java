/*
 * Copyright 2014-2018 Groupon, Inc
 * Copyright 2014-2018 The Billing Project, LLC
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

import java.net.URL;
import java.util.Date;
import java.util.Map;

import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestYAMLPluginTenantConfigurationHandler {

    // Per-region, no specific POJO (Map)
    private static final String RAW_CONFIGURATION_V1 = "local: &default\n" +
                                                       "  serverPort: 8080\n" +
                                                       "\n" +
                                                       "eu-central-1:\n" +
                                                       "  <<: *default\n" +
                                                       "  serverHost: http://kb.eu\n" +
                                                       "\n" +
                                                       "ap-northeast-2:\n" +
                                                       "  <<: *default\n" +
                                                       "  serverHost: http://kb.apac";

    // Per-region, specific POJOs
    private static final String RAW_CONFIGURATION_V2 = "local: !!org.killbill.billing.plugin.core.config.TestYAMLPluginTenantConfigurationHandler$PluginConfigForTest\n" +
                                                       "  &default\n" +
                                                       "  timeout: 60\n" +
                                                       "  effectiveDate: 2017-08-01T12:12:43Z\n" +
                                                       "\n" +
                                                       "eu-central-1: !!org.killbill.billing.plugin.core.config.TestYAMLPluginTenantConfigurationHandler$PluginConfigForTest\n" +
                                                       "  <<: *default\n" +
                                                       "  serverHost: http://kb.eu:80\n" +
                                                       "\n" +
                                                       "ap-northeast-2: !!org.killbill.billing.plugin.core.config.TestYAMLPluginTenantConfigurationHandler$PluginConfigForTest\n" +
                                                       "  <<: *default\n" +
                                                       "  serverHost: http://kb.apac:80";

    // No region, specific POJOs
    private static final String RAW_CONFIGURATION_V3 = "!!org.killbill.billing.plugin.core.config.TestYAMLPluginTenantConfigurationHandler$PluginConfigForTest\n" +
                                                       "  serverHost: http://localhost:8080\n" +
                                                       "  timeout: 60\n" +
                                                       "  effectiveDate: 2017-08-01T12:12:43Z";

    @Test(groups = "fast")
    public void testParseRawConfigurationV1() {
        Map parsedConfiguration = new YAMLPluginTenantConfigurationHandlerForTestMap("foo").parseRawConfiguration(RAW_CONFIGURATION_V1);
        Assert.assertNull(parsedConfiguration);

        parsedConfiguration = new YAMLPluginTenantConfigurationHandlerForTestMap("local").parseRawConfiguration(RAW_CONFIGURATION_V1);
        Assert.assertNull(parsedConfiguration.get("serverHost"));
        Assert.assertEquals(parsedConfiguration.get("serverPort"), 8080);

        parsedConfiguration = new YAMLPluginTenantConfigurationHandlerForTestMap("eu-central-1").parseRawConfiguration(RAW_CONFIGURATION_V1);
        Assert.assertEquals(parsedConfiguration.get("serverHost"), "http://kb.eu");
        Assert.assertEquals(parsedConfiguration.get("serverPort"), 8080);

        parsedConfiguration = new YAMLPluginTenantConfigurationHandlerForTestMap("ap-northeast-2").parseRawConfiguration(RAW_CONFIGURATION_V1);
        Assert.assertEquals(parsedConfiguration.get("serverHost"), "http://kb.apac");
        Assert.assertEquals(parsedConfiguration.get("serverPort"), 8080);
    }

    @Test(groups = "fast")
    public void testParseRawConfigurationV2() {
        PluginConfigForTest parsedConfiguration = new YAMLPluginTenantConfigurationHandlerForTestPojo("foo").parseRawConfiguration(RAW_CONFIGURATION_V2);
        Assert.assertNull(parsedConfiguration);

        parsedConfiguration = new YAMLPluginTenantConfigurationHandlerForTestPojo("local").parseRawConfiguration(RAW_CONFIGURATION_V2);
        Assert.assertNull(parsedConfiguration.serverHost);
        Assert.assertEquals(parsedConfiguration.timeout, 60);
        Assert.assertEquals(parsedConfiguration.effectiveDate.compareTo(new DateTime("2017-08-01T12:12:43Z").toDate()), 0);

        parsedConfiguration = new YAMLPluginTenantConfigurationHandlerForTestPojo("eu-central-1").parseRawConfiguration(RAW_CONFIGURATION_V2);
        Assert.assertEquals(parsedConfiguration.serverHost.getHost(), "kb.eu");
        Assert.assertEquals(parsedConfiguration.serverHost.getPort(), 80);
        Assert.assertEquals(parsedConfiguration.timeout, 60);
        Assert.assertEquals(parsedConfiguration.effectiveDate.compareTo(new DateTime("2017-08-01T12:12:43Z").toDate()), 0);

        parsedConfiguration = new YAMLPluginTenantConfigurationHandlerForTestPojo("ap-northeast-2").parseRawConfiguration(RAW_CONFIGURATION_V2);
        Assert.assertEquals(parsedConfiguration.serverHost.getHost(), "kb.apac");
        Assert.assertEquals(parsedConfiguration.serverHost.getPort(), 80);
        Assert.assertEquals(parsedConfiguration.timeout, 60);
        Assert.assertEquals(parsedConfiguration.effectiveDate.compareTo(new DateTime("2017-08-01T12:12:43Z").toDate()), 0);
    }

    @Test(groups = "fast")
    public void testParseRawConfigurationV3() {
        final PluginConfigForTest parsedConfiguration = new YAMLPluginTenantConfigurationHandlerForTestPojo(null).parseRawConfiguration(RAW_CONFIGURATION_V3);
        Assert.assertEquals(parsedConfiguration.serverHost.getHost(), "localhost");
        Assert.assertEquals(parsedConfiguration.serverHost.getPort(), 8080);
        Assert.assertEquals(parsedConfiguration.timeout, 60);
        Assert.assertEquals(parsedConfiguration.effectiveDate.compareTo(new DateTime("2017-08-01T12:12:43Z").toDate()), 0);
    }

    private static final class YAMLPluginTenantConfigurationHandlerForTestMap extends YAMLPluginTenantConfigurationHandler<Map, Map> {

        public YAMLPluginTenantConfigurationHandlerForTestMap(final String configurationKey) {
            super(null, null, null, configurationKey);
        }
    }

    private static final class YAMLPluginTenantConfigurationHandlerForTestPojo extends YAMLPluginTenantConfigurationHandler<PluginConfigForTest, PluginConfigForTest> {

        public YAMLPluginTenantConfigurationHandlerForTestPojo(final String configurationKey) {
            super(null, null, null, configurationKey);
        }
    }

    private static final class PluginConfigForTest {

        public URL serverHost;
        public int timeout;
        public Date effectiveDate;
    }
}
