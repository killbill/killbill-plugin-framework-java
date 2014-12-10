/*
 * Copyright 2014 Groupon, Inc
 * Copyright 2014 The Billing Project, LLC
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

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Map;

import javax.annotation.Nullable;
import javax.sql.DataSource;

import org.joda.time.DateTime;
import org.jooq.SQLDialect;
import org.jooq.conf.MappedSchema;
import org.jooq.conf.RenderMapping;
import org.jooq.conf.Settings;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;

public class PluginDao {

    public static final byte TRUE = (byte) '1';
    public static final byte FALSE = (byte) '0';

    protected static final String DEFAULT_SCHEMA_NAME = "killbill";

    protected static final ObjectMapper objectMapper = new ObjectMapper();

    protected final DataSource dataSource;
    protected final SQLDialect dialect;
    protected final Settings settings;

    public PluginDao(final DataSource dataSource) throws SQLException {
        this(dataSource, SQLDialect.MYSQL);
    }

    public PluginDao(final DataSource dataSource, final SQLDialect dialect) throws SQLException {
        this.dataSource = dataSource;
        this.dialect = dialect;

        final String schema;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            schema = connection.getCatalog();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        this.settings = new Settings().withRenderMapping(new RenderMapping().withSchemata(new MappedSchema().withInput(DEFAULT_SCHEMA_NAME).withOutput(schema)));
    }

    protected static byte fromBoolean(final Boolean bool) {
        return bool ? TRUE : FALSE;
    }

    protected static Timestamp toTimestamp(@Nullable final DateTime dateTime) {
        return dateTime == null ? null : new Timestamp(dateTime.getMillis());
    }

    protected String getProperty(final String key, final Map additionalData) {
        return Strings.emptyToNull(additionalData == null || additionalData.get(key) == null ? null : String.valueOf(additionalData.get(key)));
    }

    protected String asString(final Map additionalData) throws SQLException {
        if (additionalData == null || additionalData.isEmpty()) {
            return null;
        }

        try {
            return objectMapper.writeValueAsString(additionalData);
        } catch (final JsonProcessingException e) {
            throw new SQLException(e);
        }
    }

    protected interface WithConnectionCallback<T> {

        public T withConnection(final Connection conn) throws SQLException;
    }

    protected <T> T execute(final Connection conn, final WithConnectionCallback<T> callback) throws SQLException {
        try {
            return callback.withConnection(conn);
        } finally {
            conn.close();
        }
    }
}
