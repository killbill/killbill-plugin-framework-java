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

package org.killbill.billing.plugin.dao.payment;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.joda.time.DateTime;
import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.TransactionalRunnable;
import org.jooq.UpdatableRecord;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.payment.api.TransactionType;
import org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi;
import org.killbill.billing.plugin.dao.PluginDao;

public abstract class PluginPaymentDao<RESP_R extends UpdatableRecord<RESP_R>, RESP_T extends Table<RESP_R>, PM_R extends UpdatableRecord<PM_R>, PM_T extends Table<PM_R>> extends PluginDao {

    protected static final String KB_PAYMENT_ID = "KB_PAYMENT_ID";
    protected static final String KB_PAYMENT_TRANSACTION_ID = "KB_PAYMENT_TRANSACTION_ID";
    protected static final String AMOUNT = "AMOUNT";
    protected static final String CURRENCY = "CURRENCY";
    protected static final String TRANSACTION_TYPE = "TRANSACTION_TYPE";

    protected static final String RECORD_ID = "RECORD_ID";
    protected static final String KB_ACCOUNT_ID = "KB_ACCOUNT_ID";
    protected static final String KB_PAYMENT_METHOD_ID = "KB_PAYMENT_METHOD_ID";
    protected static final String TOKEN = "TOKEN";
    protected static final String CC_FIRST_NAME = "CC_FIRST_NAME";
    protected static final String CC_LAST_NAME = "CC_LAST_NAME";
    protected static final String CC_TYPE = "CC_TYPE";
    protected static final String CC_EXP_MONTH = "CC_EXP_MONTH";
    protected static final String CC_EXP_YEAR = "CC_EXP_YEAR";
    protected static final String CC_NUMBER = "CC_NUMBER";
    protected static final String CC_LAST_4 = "CC_LAST_4";
    protected static final String CC_START_MONTH = "CC_START_MONTH";
    protected static final String CC_START_YEAR = "CC_START_YEAR";
    protected static final String CC_ISSUE_NUMBER = "CC_ISSUE_NUMBER";
    protected static final String CC_VERIFICATION_VALUE = "CC_VERIFICATION_VALUE";
    protected static final String CC_TRACK_DATA = "CC_TRACK_DATA";
    protected static final String ADDRESS1 = "ADDRESS1";
    protected static final String ADDRESS2 = "ADDRESS2";
    protected static final String CITY = "CITY";
    protected static final String STATE = "STATE";
    protected static final String ZIP = "ZIP";
    protected static final String COUNTRY = "COUNTRY";
    protected static final String IS_DEFAULT = "IS_DEFAULT";
    protected static final String IS_DELETED = "IS_DELETED";
    protected static final String ADDITIONAL_DATA = "ADDITIONAL_DATA";
    protected static final String CREATED_DATE = "CREATED_DATE";
    protected static final String UPDATED_DATE = "UPDATED_DATE";
    protected static final String KB_TENANT_ID = "KB_TENANT_ID";

    protected final RESP_T responsesTable;
    protected final PM_T paymentMethodsTable;

    private final String recordIdFieldName;

    public PluginPaymentDao(final RESP_T responsesTable,
                            final PM_T paymentMethodsTable,
                            final DataSource dataSource) throws SQLException {
        this(responsesTable, paymentMethodsTable, dataSource, RECORD_ID);
    }

    public PluginPaymentDao(final RESP_T responsesTable,
                            final PM_T paymentMethodsTable,
                            final DataSource dataSource,
                            final SQLDialect dialect) throws SQLException {
        this(responsesTable, paymentMethodsTable, dataSource, dialect, RECORD_ID);
    }

    public PluginPaymentDao(final RESP_T responsesTable,
                            final PM_T paymentMethodsTable,
                            final DataSource dataSource,
                            final Settings settings) throws SQLException {
        super(dataSource, settings);
        this.responsesTable = responsesTable;
        this.paymentMethodsTable = paymentMethodsTable;
        this.recordIdFieldName = RECORD_ID;
    }

    public PluginPaymentDao(final RESP_T responsesTable,
                            final PM_T paymentMethodsTable,
                            final DataSource dataSource,
                            final SQLDialect dialect,
                            final Settings settings) {
        super(dataSource, dialect, settings);
        this.responsesTable = responsesTable;
        this.paymentMethodsTable = paymentMethodsTable;
        this.recordIdFieldName = RECORD_ID;
    }

    public PluginPaymentDao(final RESP_T responsesTable,
                            final PM_T paymentMethodsTable,
                            final DataSource dataSource,
                            final SQLDialect dialect,
                            final String recordIdFieldName) throws SQLException {
        super(dataSource, dialect);
        this.responsesTable = responsesTable;
        this.paymentMethodsTable = paymentMethodsTable;
        this.recordIdFieldName = recordIdFieldName;
    }

    public PluginPaymentDao(final RESP_T responsesTable,
                            final PM_T paymentMethodsTable,
                            final DataSource dataSource,
                            final String recordIdFieldName) throws SQLException {
        super(dataSource);
        this.responsesTable = responsesTable;
        this.paymentMethodsTable = paymentMethodsTable;
        this.recordIdFieldName = recordIdFieldName;
    }

    // Responses

    public void addResponse(final UUID kbAccountId,
                            final UUID kbPaymentId,
                            final UUID kbPaymentTransactionId,
                            final TransactionType transactionType,
                            final BigDecimal amount,
                            final Currency currency,
                            final Map additionalData,
                            final DateTime utcNow,
                            final UUID kbTenantId) throws SQLException {
        execute(dataSource.getConnection(),
                new WithConnectionCallback<Void>() {
                    @Override
                    public Void withConnection(final Connection conn) throws SQLException {
                        DSL.using(conn, dialect, settings)
                           .insertInto(responsesTable,
                                       DSL.field(KB_ACCOUNT_ID),
                                       DSL.field(KB_PAYMENT_ID),
                                       DSL.field(KB_PAYMENT_TRANSACTION_ID),
                                       DSL.field(TRANSACTION_TYPE),
                                       DSL.field(AMOUNT),
                                       DSL.field(CURRENCY),
                                       DSL.field(ADDITIONAL_DATA),
                                       DSL.field(CREATED_DATE),
                                       DSL.field(KB_TENANT_ID))
                           .values(kbAccountId.toString(),
                                   kbPaymentId.toString(),
                                   kbPaymentTransactionId.toString(),
                                   transactionType.toString(),
                                   amount,
                                   currency == null ? null : currency.name(),
                                   asString(additionalData),
                                   toTimestamp(utcNow),
                                   kbTenantId.toString())
                           .execute();
                        return null;
                    }
                });
    }

    public List<RESP_R> getResponses(final UUID kbPaymentId, final UUID kbTenantId) throws SQLException {
        return execute(dataSource.getConnection(),
                       new WithConnectionCallback<List<RESP_R>>() {
                           @Override
                           public List<RESP_R> withConnection(final Connection conn) throws SQLException {
                               return DSL.using(conn, dialect, settings)
                                         .selectFrom(responsesTable)
                                         .where(DSL.field(KB_PAYMENT_ID).equal(kbPaymentId.toString()))
                                         .and(DSL.field(KB_TENANT_ID).equal(kbTenantId.toString()))
                                         .orderBy(DSL.field(recordIdFieldName).asc())
                                         .fetch();
                           }
                       });
    }

    // Assumes that the last auth was successful
    public RESP_R getSuccessfulAuthorizationResponse(final UUID kbPaymentId, final UUID kbTenantId) throws SQLException {
        return execute(dataSource.getConnection(),
                       new WithConnectionCallback<RESP_R>() {
                           @Override
                           public RESP_R withConnection(final Connection conn) throws SQLException {
                               return DSL.using(conn, dialect, settings)
                                         .selectFrom(responsesTable)
                                         .where(DSL.field(KB_PAYMENT_ID).equal(kbPaymentId.toString()))
                                         .and(DSL.field(TRANSACTION_TYPE).equal(TransactionType.AUTHORIZE.toString()))
                                         .and(DSL.field(KB_TENANT_ID).equal(kbTenantId.toString()))
                                         .orderBy(DSL.field(recordIdFieldName).desc())
                                         .limit(1)
                                         .fetchOne();
                           }
                       });
    }

    // Payment methods

    public void addPaymentMethod(final UUID kbAccountId, final UUID kbPaymentMethodId, final boolean isDefault, final Map<String, String> properties, final DateTime utcNow, final UUID kbTenantId) throws SQLException {
        /* Clone our properties, what we have been given might be unmodifiable */
        final Map<String, String> clonedProperties = new HashMap<String, String>(properties);

        /* Extract and remove known values from the properties map that will become "additional data" */
        final String token               = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_TOKEN);
        final String ccFirstName         = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_CC_FIRST_NAME);
        final String ccLastName          = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_CC_LAST_NAME);
        final String ccType              = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_CC_TYPE);
        final String ccExpirationMonth   = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_CC_EXPIRATION_MONTH);
        final String ccExpirationYear    = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_CC_EXPIRATION_YEAR);
        final String ccNumber            = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_CC_NUMBER);
        final String ccStartMonth        = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_CC_START_MONTH);
        final String ccStartYear         = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_CC_START_YEAR);
        final String ccIssueNumber       = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_CC_ISSUE_NUMBER);
        final String ccVerificationValue = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_CC_VERIFICATION_VALUE);
        final String ccTrackData         = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_CC_TRACK_DATA);
        final String address1            = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_ADDRESS1);
        final String address2            = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_ADDRESS2);
        final String city                = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_CITY);
        final String state               = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_STATE);
        final String zip                 = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_ZIP);
        final String country             = clonedProperties.remove(PluginPaymentPluginApi.PROPERTY_COUNTRY);

        /* Calculate last 4 digits of the credit card number */
        final String ccLast4 = ccNumber == null ? null : ccNumber.substring(ccNumber.length() - 4, ccNumber.length());

        /* Calculate the additional data to store */
        final String additionalData = asString(clonedProperties);

        /* Store computed data */
        execute(dataSource.getConnection(),
                new WithConnectionCallback<Void>() {
                    @Override
                    public Void withConnection(final Connection conn) throws SQLException {
                        DSL.using(conn, dialect, settings)
                           .insertInto(paymentMethodsTable,
                                       DSL.field(KB_ACCOUNT_ID),
                                       DSL.field(KB_PAYMENT_METHOD_ID),
                                       DSL.field(TOKEN),
                                       DSL.field(CC_FIRST_NAME),
                                       DSL.field(CC_LAST_NAME),
                                       DSL.field(CC_TYPE),
                                       DSL.field(CC_EXP_MONTH),
                                       DSL.field(CC_EXP_YEAR),
                                       DSL.field(CC_NUMBER),
                                       DSL.field(CC_LAST_4),
                                       DSL.field(CC_START_MONTH),
                                       DSL.field(CC_START_YEAR),
                                       DSL.field(CC_ISSUE_NUMBER),
                                       DSL.field(CC_VERIFICATION_VALUE),
                                       DSL.field(CC_TRACK_DATA),
                                       DSL.field(ADDRESS1),
                                       DSL.field(ADDRESS2),
                                       DSL.field(CITY),
                                       DSL.field(STATE),
                                       DSL.field(ZIP),
                                       DSL.field(COUNTRY),
                                       DSL.field(IS_DEFAULT),
                                       DSL.field(IS_DELETED),
                                       DSL.field(ADDITIONAL_DATA),
                                       DSL.field(CREATED_DATE),
                                       DSL.field(UPDATED_DATE),
                                       DSL.field(KB_TENANT_ID))
                           .values(kbAccountId.toString(),
                                   kbPaymentMethodId.toString(),
                                   token,
                                   ccFirstName,
                                   ccLastName,
                                   ccType,
                                   ccExpirationMonth,
                                   ccExpirationYear,
                                   ccNumber,
                                   ccLast4,
                                   ccStartMonth,
                                   ccStartYear,
                                   ccIssueNumber,
                                   ccVerificationValue,
                                   ccTrackData,
                                   address1,
                                   address2,
                                   city,
                                   state,
                                   zip,
                                   country,
                                   fromBoolean(isDefault),
                                   FALSE,
                                   additionalData,
                                   toTimestamp(utcNow),
                                   toTimestamp(utcNow),
                                   kbTenantId.toString())
                           .execute();
                        return null;
                    }
                });
    }

    public void deletePaymentMethod(final UUID kbPaymentMethodId, final DateTime utcNow, final UUID kbTenantId) throws SQLException {
        execute(dataSource.getConnection(),
                new WithConnectionCallback<Void>() {
                    @Override
                    public Void withConnection(final Connection conn) throws SQLException {
                        DSL.using(conn, dialect, settings)
                           .update(paymentMethodsTable)
                           .set(DSL.field(IS_DELETED), TRUE)
                           .set(DSL.field(UPDATED_DATE), toTimestamp(utcNow))
                           .where(DSL.field(KB_PAYMENT_METHOD_ID).equal(kbPaymentMethodId.toString()))
                           .and(DSL.field(KB_TENANT_ID).equal(kbTenantId.toString()))
                           .execute();
                        return null;
                    }
                });
    }

    public PM_R getPaymentMethod(final UUID kbPaymentMethodId, final UUID kbTenantId) throws SQLException {
        return execute(dataSource.getConnection(),
                       new WithConnectionCallback<PM_R>() {
                           @Override
                           public PM_R withConnection(final Connection conn) throws SQLException {
                               return DSL.using(conn, dialect, settings)
                                         .selectFrom(paymentMethodsTable)
                                         .where(DSL.field(KB_PAYMENT_METHOD_ID).equal(kbPaymentMethodId.toString()))
                                         .and(DSL.field(IS_DELETED).equal(FALSE))
                                         .and(DSL.field(KB_TENANT_ID).equal(kbTenantId.toString()))
                                         .orderBy(DSL.field(recordIdFieldName).desc())
                                         .fetchOne();
                           }
                       });
    }

    public void setDefaultPaymentMethod(final UUID kbAccountId, final UUID kbPaymentMethodId, final DateTime utcNow, final UUID kbTenantId) throws SQLException {
        execute(dataSource.getConnection(),
                new WithConnectionCallback<Void>() {
                    @Override
                    public Void withConnection(final Connection conn) throws SQLException {
                        DSL.using(conn, dialect, settings)
                           .transaction(new TransactionalRunnable() {
                               @Override
                               public void run(final Configuration configuration) throws Exception {
                                   DSL.using(conn, dialect, settings)
                                      .update(paymentMethodsTable)
                                      .set(DSL.field(IS_DEFAULT), FALSE)
                                      .set(DSL.field(UPDATED_DATE), toTimestamp(utcNow))
                                      .where(DSL.field(KB_PAYMENT_METHOD_ID).notEqual(kbPaymentMethodId.toString()))
                                      .and(DSL.field(KB_ACCOUNT_ID).equal(kbAccountId.toString()))
                                      .and(DSL.field(KB_TENANT_ID).equal(kbTenantId.toString()))
                                      .execute();

                                   DSL.using(conn, dialect, settings)
                                      .update(paymentMethodsTable)
                                      .set(DSL.field(IS_DEFAULT), TRUE)
                                      .set(DSL.field(UPDATED_DATE), toTimestamp(utcNow))
                                      .where(DSL.field(KB_PAYMENT_METHOD_ID).equal(kbPaymentMethodId.toString()))
                                      .and(DSL.field(KB_TENANT_ID).equal(kbTenantId.toString()))
                                      .execute();
                               }
                           });
                        return null;
                    }
                });
    }

    public List<PM_R> getPaymentMethods(final UUID kbAccountId, final UUID kbTenantId) throws SQLException {
        return execute(dataSource.getConnection(),
                       new WithConnectionCallback<List<PM_R>>() {
                           @Override
                           public List<PM_R> withConnection(final Connection conn) throws SQLException {
                               return DSL.using(conn, dialect, settings)
                                         .selectFrom(paymentMethodsTable)
                                         .where(DSL.field(KB_ACCOUNT_ID).equal(kbAccountId.toString()))
                                         .and(DSL.field(IS_DELETED).equal(FALSE))
                                         .and(DSL.field(KB_TENANT_ID).equal(kbTenantId.toString()))
                                         .orderBy(DSL.field(recordIdFieldName).asc())
                                         .fetch();
                           }
                       });
    }
}
