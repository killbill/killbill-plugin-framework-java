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

package org.killbill.billing.plugin.dao;

import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import javax.sql.DataSource;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
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

    @Test(groups = "fast")
    public void testDates() throws Exception {
        final DateTime jodaDateTime = new DateTime("2020-04-05T12:14:15Z");
        Assert.assertEquals(PluginDao.toTimestamp(jodaDateTime).toString(), "2020-04-05 12:14:15.0");

        final LocalDateTime localDateTime = PluginDao.toLocalDateTime(jodaDateTime);
        final DateTime backToJodaDateTime = new DateTime(localDateTime
                                                                 .atZone(ZoneOffset.UTC)
                                                                 .toInstant()
                                                                 .toEpochMilli(), DateTimeZone.UTC);
        Assert.assertEquals(localDateTime.toString(), "2020-04-05T12:14:15");
        Assert.assertEquals(jodaDateTime.compareTo(backToJodaDateTime), 0);
    }

    public static class PluginDaoTest extends PluginDao {

        public PluginDaoTest(final DataSource dataSource) throws SQLException {
            super(dataSource);
        }
    }
}
