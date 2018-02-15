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

package org.killbill.billing.plugin.dao;

import java.io.ByteArrayInputStream;

import org.jooq.conf.Settings;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPluginDao {

    @Test(groups = "fast")
    public void testBuildSettings() throws Exception {
        final String settingsXML = "<settings xmlns=\"http://www.jooq.org/xsd/jooq-runtime-3.10.2.xsd\">\n" +
                                   "  <renderMapping>\n" +
                                   "    <schemata>\n" +
                                   "      <schema>\n" +
                                   "        <input>DEV</input>\n" +
                                   "        <tables>\n" +
                                   "          <table>\n" +
                                   "            <input>AUTHOR</input>\n" +
                                   "            <output>MY_APP__AUTHOR</output>\n" +
                                   "          </table>\n" +
                                   "        </tables>\n" +
                                   "      </schema>\n" +
                                   "    </schemata>\n" +
                                   "  </renderMapping>\n" +
                                   "</settings>";
        final Settings settings = PluginDao.getSettings(new ByteArrayInputStream(settingsXML.getBytes()));
        Assert.assertNotNull(settings);
        Assert.assertNotNull(settings.getRenderMapping());
        Assert.assertNotNull(settings.getRenderMapping().getSchemata());
        Assert.assertEquals(settings.getRenderMapping().getSchemata().size(), 1);
        Assert.assertEquals(settings.getRenderMapping().getSchemata().get(0).getInput(), "DEV");
        Assert.assertEquals(settings.getRenderMapping().getSchemata().get(0).getTables().size(), 1);
        Assert.assertEquals(settings.getRenderMapping().getSchemata().get(0).getTables().get(0).getInput(), "AUTHOR");
        Assert.assertEquals(settings.getRenderMapping().getSchemata().get(0).getTables().get(0).getOutput(), "MY_APP__AUTHOR");
    }
}