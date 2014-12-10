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

package org.killbill.billing.plugin.dao.payment;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.joda.time.DateTime;
import org.jooq.Configuration;
import org.jooq.Table;
import org.jooq.TransactionalRunnable;
import org.jooq.UpdatableRecord;
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

    public PluginPaymentDao(final RESP_T responsesTable, final PM_T paymentMethodsTable, final DataSource dataSource) throws SQLException {
        super(dataSource);
        this.responsesTable = responsesTable;
        this.paymentMethodsTable = paymentMethodsTable;
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
                                       DSL.field(responsesTable.getName() + "." + KB_ACCOUNT_ID),
                                       DSL.field(responsesTable.getName() + "." + KB_PAYMENT_ID),
                                       DSL.field(responsesTable.getName() + "." + KB_PAYMENT_TRANSACTION_ID),
                                       DSL.field(responsesTable.getName() + "." + TRANSACTION_TYPE),
                                       DSL.field(responsesTable.getName() + "." + AMOUNT),
                                       DSL.field(responsesTable.getName() + "." + CURRENCY),
                                       DSL.field(responsesTable.getName() + "." + ADDITIONAL_DATA),
                                       DSL.field(responsesTable.getName() + "." + CREATED_DATE),
                                       DSL.field(responsesTable.getName() + "." + KB_TENANT_ID))
                           .values(kbAccountId.toString(),
                                   kbPaymentId.toString(),
                                   kbPaymentTransactionId.toString(),
                                   transactionType.toString(),
                                   amount,
                                   currency,
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
                                         .where(DSL.field(responsesTable.getName() + "." + KB_PAYMENT_ID).equal(kbPaymentId.toString()))
                                         .and(DSL.field(responsesTable.getName() + "." + KB_TENANT_ID).equal(kbTenantId.toString()))
                                         .orderBy(DSL.field(responsesTable.getName() + "." + RECORD_ID).asc())
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
                                         .where(DSL.field(responsesTable.getName() + "." + KB_PAYMENT_ID).equal(kbPaymentId.toString()))
                                         .and(DSL.field(responsesTable.getName() + "." + TRANSACTION_TYPE).equal(TransactionType.AUTHORIZE.toString()))
                                         .and(DSL.field(responsesTable.getName() + "." + KB_TENANT_ID).equal(kbTenantId.toString()))
                                         .orderBy(DSL.field(responsesTable.getName() + "." + RECORD_ID).desc())
                                         .fetchOne();
                           }
                       });
    }

    // Payment methods

    public void addPaymentMethod(final UUID kbAccountId, final UUID kbPaymentMethodId, final boolean isDefault, final Map<String, String> properties, final DateTime utcNow, final UUID kbTenantId) throws SQLException {
        final String ccNumber = getProperty(PluginPaymentPluginApi.PROPERTY_CC_NUMBER, properties);
        final String ccLast4 = ccNumber == null ? null : ccNumber.substring(ccNumber.length() - 5, ccNumber.length() - 1);

        execute(dataSource.getConnection(),
                new WithConnectionCallback<Void>() {
                    @Override
                    public Void withConnection(final Connection conn) throws SQLException {
                        DSL.using(conn, dialect, settings)
                           .insertInto(paymentMethodsTable,
                                       DSL.field(paymentMethodsTable.getName() + "." + KB_ACCOUNT_ID),
                                       DSL.field(paymentMethodsTable.getName() + "." + KB_PAYMENT_METHOD_ID),
                                       DSL.field(paymentMethodsTable.getName() + "." + TOKEN),
                                       DSL.field(paymentMethodsTable.getName() + "." + CC_FIRST_NAME),
                                       DSL.field(paymentMethodsTable.getName() + "." + CC_LAST_NAME),
                                       DSL.field(paymentMethodsTable.getName() + "." + CC_TYPE),
                                       DSL.field(paymentMethodsTable.getName() + "." + CC_EXP_MONTH),
                                       DSL.field(paymentMethodsTable.getName() + "." + CC_EXP_YEAR),
                                       DSL.field(paymentMethodsTable.getName() + "." + CC_NUMBER),
                                       DSL.field(paymentMethodsTable.getName() + "." + CC_LAST_4),
                                       DSL.field(paymentMethodsTable.getName() + "." + CC_START_MONTH),
                                       DSL.field(paymentMethodsTable.getName() + "." + CC_START_YEAR),
                                       DSL.field(paymentMethodsTable.getName() + "." + CC_ISSUE_NUMBER),
                                       DSL.field(paymentMethodsTable.getName() + "." + CC_VERIFICATION_VALUE),
                                       DSL.field(paymentMethodsTable.getName() + "." + CC_TRACK_DATA),
                                       DSL.field(paymentMethodsTable.getName() + "." + ADDRESS1),
                                       DSL.field(paymentMethodsTable.getName() + "." + ADDRESS2),
                                       DSL.field(paymentMethodsTable.getName() + "." + CITY),
                                       DSL.field(paymentMethodsTable.getName() + "." + STATE),
                                       DSL.field(paymentMethodsTable.getName() + "." + ZIP),
                                       DSL.field(paymentMethodsTable.getName() + "." + COUNTRY),
                                       DSL.field(paymentMethodsTable.getName() + "." + IS_DEFAULT),
                                       DSL.field(paymentMethodsTable.getName() + "." + IS_DELETED),
                                       DSL.field(paymentMethodsTable.getName() + "." + ADDITIONAL_DATA),
                                       DSL.field(paymentMethodsTable.getName() + "." + CREATED_DATE),
                                       DSL.field(paymentMethodsTable.getName() + "." + UPDATED_DATE),
                                       DSL.field(paymentMethodsTable.getName() + "." + KB_TENANT_ID))
                           .values(kbAccountId.toString(),
                                   kbPaymentMethodId.toString(),
                                   getProperty(PluginPaymentPluginApi.PROPERTY_TOKEN, properties),
                                   getProperty(PluginPaymentPluginApi.PROPERTY_CC_FIRST_NAME, properties),
                                   getProperty(PluginPaymentPluginApi.PROPERTY_CC_LAST_NAME, properties),
                                   getProperty(PluginPaymentPluginApi.PROPERTY_CC_TYPE, properties),
                                   getProperty(PluginPaymentPluginApi.PROPERTY_CC_EXPIRATION_MONTH, properties),
                                   getProperty(PluginPaymentPluginApi.PROPERTY_CC_EXPIRATION_YEAR, properties),
                                   ccNumber,
                                   ccLast4,
                                   getProperty(PluginPaymentPluginApi.PROPERTY_CC_START_MONTH, properties),
                                   getProperty(PluginPaymentPluginApi.PROPERTY_CC_START_YEAR, properties),
                                   getProperty(PluginPaymentPluginApi.PROPERTY_CC_ISSUE_NUMBER, properties),
                                   getProperty(PluginPaymentPluginApi.PROPERTY_CC_VERIFICATION_VALUE, properties),
                                   getProperty(PluginPaymentPluginApi.PROPERTY_CC_TRACK_DATA, properties),
                                   getProperty(PluginPaymentPluginApi.PROPERTY_ADDRESS1, properties),
                                   getProperty(PluginPaymentPluginApi.PROPERTY_ADDRESS2, properties),
                                   getProperty(PluginPaymentPluginApi.PROPERTY_CITY, properties),
                                   getProperty(PluginPaymentPluginApi.PROPERTY_STATE, properties),
                                   getProperty(PluginPaymentPluginApi.PROPERTY_ZIP, properties),
                                   getProperty(PluginPaymentPluginApi.PROPERTY_COUNTRY, properties),
                                   fromBoolean(isDefault),
                                   FALSE,
                                   asString(properties),
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
                           .set(DSL.field(paymentMethodsTable.getName() + "." + IS_DELETED), TRUE)
                           .set(DSL.field(paymentMethodsTable.getName() + "." + UPDATED_DATE), toTimestamp(utcNow))
                           .where(DSL.field(paymentMethodsTable.getName() + "." + KB_PAYMENT_METHOD_ID).equal(kbPaymentMethodId.toString()))
                           .and(DSL.field(paymentMethodsTable.getName() + "." + KB_TENANT_ID).equal(kbTenantId.toString()))
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
                                         .where(DSL.field(paymentMethodsTable.getName() + "." + KB_PAYMENT_METHOD_ID).equal(kbPaymentMethodId.toString()))
                                         .and(DSL.field(paymentMethodsTable.getName() + "." + KB_TENANT_ID).equal(kbTenantId.toString()))
                                         .orderBy(DSL.field(paymentMethodsTable.getName() + "." + RECORD_ID).desc())
                                         .fetchOne();
                           }
                       });
    }

    public void setDefaultPaymentMethod(final UUID kbPaymentMethodId, final DateTime utcNow, final UUID kbTenantId) throws SQLException {
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
                                      .set(DSL.field(paymentMethodsTable.getName() + "." + IS_DEFAULT), FALSE)
                                      .set(DSL.field(paymentMethodsTable.getName() + "." + UPDATED_DATE), toTimestamp(utcNow))
                                      .where(DSL.field(paymentMethodsTable.getName() + "." + KB_PAYMENT_METHOD_ID).notEqual(kbPaymentMethodId.toString()))
                                      .and(DSL.field(paymentMethodsTable.getName() + "." + KB_TENANT_ID).equal(kbTenantId.toString()))
                                      .execute();

                                   DSL.using(conn, dialect, settings)
                                      .update(paymentMethodsTable)
                                      .set(DSL.field(paymentMethodsTable.getName() + "." + IS_DEFAULT), TRUE)
                                      .set(DSL.field(paymentMethodsTable.getName() + "." + UPDATED_DATE), toTimestamp(utcNow))
                                      .where(DSL.field(paymentMethodsTable.getName() + "." + KB_PAYMENT_METHOD_ID).equal(kbPaymentMethodId.toString()))
                                      .and(DSL.field(paymentMethodsTable.getName() + "." + KB_TENANT_ID).equal(kbTenantId.toString()))
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
                                         .where(DSL.field(paymentMethodsTable.getName() + "." + KB_ACCOUNT_ID).equal(kbAccountId.toString()))
                                         .and(DSL.field(paymentMethodsTable.getName() + "." + KB_TENANT_ID).equal(kbTenantId.toString()))
                                         .orderBy(DSL.field(paymentMethodsTable.getName() + "." + RECORD_ID).asc())
                                         .fetch();
                           }
                       });
    }
}
