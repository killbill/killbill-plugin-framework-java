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

package org.killbill.billing.plugin;

import org.killbill.billing.platform.test.PlatformDBTestingHelper;
import org.killbill.commons.embeddeddb.EmbeddedDB;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestWithEmbeddedDBBase {

    protected static final String DDL_FILE_NAME = "ddl.sql";

    protected EmbeddedDB embeddedDB;

    @BeforeClass(groups = "slow")
    public void setUpBeforeClass() throws Exception {
        embeddedDB = PlatformDBTestingHelper.get().getInstance();
        embeddedDB.initialize();
        embeddedDB.start();

        final String ddl = TestUtils.toString(getDdlFileName());
        embeddedDB.executeScript(ddl);
        embeddedDB.refreshTableNames();
    }

    protected String getDdlFileName() {
        return DDL_FILE_NAME;
    }

    @BeforeMethod(groups = "slow")
    public void setUpBeforeMethod() throws Exception {
        embeddedDB.cleanupAllTables();
    }

    @AfterClass(groups = "slow")
    public void tearDownAfterClass() throws Exception {
        embeddedDB.stop();
    }
}
