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

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.annotation.Nullable;
import javax.sql.DataSource;

import org.joda.time.DateTime;
import org.jooq.SQLDialect;
import org.jooq.conf.MappedSchema;
import org.jooq.conf.RenderMapping;
import org.jooq.conf.RenderNameStyle;
import org.jooq.conf.Settings;
import org.killbill.commons.embeddeddb.EmbeddedDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.common.base.Strings;

public class PluginDao {

    private static final Logger logger = LoggerFactory.getLogger(PluginDao.class);

    public static final byte TRUE = (byte) '1';
    public static final byte FALSE = (byte) '0';

    protected static final String DEFAULT_SCHEMA_NAME = "killbill";

    protected static final ObjectMapper objectMapper = new ObjectMapper();
    protected static final XmlMapper XML_MAPPER = new XmlMapper();

    protected final DataSource dataSource;
    protected final SQLDialect dialect;
    protected final Settings settings;

    public PluginDao(final DataSource dataSource) throws SQLException {
        this(dataSource, getSQLDialect(getDBEngine(dataSource)));
    }

    public PluginDao(final DataSource dataSource, final SQLDialect dialect) throws SQLException {
        this.dataSource = dataSource;
        this.dialect = dialect;

        switch (dialect) {
            case H2:
                final String schema;
                Connection connection = null;
                try {
                    connection = dataSource.getConnection();
                    schema = connection.getSchema();
                } finally {
                    if (connection != null) {
                        connection.close();
                    }
                }

                final MappedSchema mappedSchema = new MappedSchema().withInput(DEFAULT_SCHEMA_NAME) // As defined by the jOOQ codegen
                                                                    .withOutput(schema);
                final RenderMapping renderMapping = new RenderMapping().withSchemata(mappedSchema);
                this.settings = new Settings().withRenderMapping(renderMapping)
                                              .withRenderNameStyle(RenderNameStyle.UPPER);
                break;
            default:
                // For MySQL, schema doesn't matter.
                // For PostgreSQL, assume schema is part of the JDBC url
                this.settings = new Settings().withRenderSchema(false);
                break;
        }
    }

    public PluginDao(final DataSource dataSource, final Settings settings) throws SQLException {
        this(dataSource, getSQLDialect(getDBEngine(dataSource)), settings);
    }

    public PluginDao(final DataSource dataSource, final SQLDialect dialect, final Settings settings) {
        this.dataSource = dataSource;
        this.dialect = dialect;
        this.settings = settings;
    }

    protected static byte fromBoolean(final Boolean bool) {
        return bool ? TRUE : FALSE;
    }

    protected static Timestamp toTimestamp(@Nullable final DateTime dateTime) {
        return dateTime == null ? null : new Timestamp(dateTime.getMillis());
    }

    protected static Timestamp toTimestamp(@Nullable final Date date) {
        return date == null ? null : new Timestamp(date.getTime());
    }

    protected String getProperty(final String key, final Map additionalData) {
        return Strings.emptyToNull(additionalData == null || additionalData.get(key) == null ? null : String.valueOf(additionalData.get(key)));
    }

    protected String asString(final Map additionalData) throws SQLException {
        if (additionalData == null || additionalData.isEmpty()) {
            return null;
        }
        return asString((Object) additionalData);
    }

    protected String asString(final Object additionalData) throws SQLException {
        try {
            return objectMapper.writeValueAsString(additionalData);
        } catch (final JsonProcessingException e) {
            throw new SQLException(e);
        }
    }

    public static SQLDialect getSQLDialect(final EmbeddedDB.DBEngine dbEngine) {
        switch (dbEngine) {
            case H2:
                return SQLDialect.H2;
            case MYSQL:
                return SQLDialect.MARIADB;
            case POSTGRESQL:
                return SQLDialect.POSTGRES;
            case GENERIC:
                logger.warn("Generic DBEngine detected, falling back to SQLDialect.MYSQL");
                return SQLDialect.MYSQL;
            default:
                throw new IllegalArgumentException("Unsupported DB engine: " + dbEngine);
        }
    }

    public static EmbeddedDB.DBEngine getDBEngine(final DataSource dataSource) throws SQLException {
        Connection connection = null;
        String databaseProductName;
        try {
            connection = dataSource.getConnection();
            databaseProductName = connection.getMetaData().getDatabaseProductName();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        final EmbeddedDB.DBEngine dbEngine;
        if ("H2".equalsIgnoreCase(databaseProductName)) {
            dbEngine = EmbeddedDB.DBEngine.H2;
        } else if ("MySQL".equalsIgnoreCase(databaseProductName)) {
            dbEngine = EmbeddedDB.DBEngine.MYSQL;
        } else if ("PostgreSQL".equalsIgnoreCase(databaseProductName)) {
            dbEngine = EmbeddedDB.DBEngine.POSTGRESQL;
        } else {
            dbEngine = EmbeddedDB.DBEngine.GENERIC;
        }
        return dbEngine;
    }

    public static Settings getSettings(final InputStream xml) throws IOException {
        return XML_MAPPER.readValue(xml, Settings.class);
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
