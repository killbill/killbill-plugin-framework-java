/*
 * Copyright 2015 Groupon, Inc
 * Copyright 2015 The Billing Project, LLC
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
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.payment.api.PaymentMethodPlugin;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.api.TransactionType;
import org.killbill.billing.payment.plugin.api.GatewayNotification;
import org.killbill.billing.payment.plugin.api.HostedPaymentPageFormDescriptor;
import org.killbill.billing.payment.plugin.api.PaymentMethodInfoPlugin;
import org.killbill.billing.payment.plugin.api.PaymentPluginApiException;
import org.killbill.billing.payment.plugin.api.PaymentPluginStatus;
import org.killbill.billing.payment.plugin.api.PaymentTransactionInfoPlugin;
import org.killbill.billing.plugin.TestUtils;
import org.killbill.billing.plugin.api.payment.PluginPaymentMethodInfoPlugin;
import org.killbill.billing.plugin.api.payment.PluginPaymentMethodPlugin;
import org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi;
import org.killbill.billing.plugin.api.payment.PluginPaymentTransactionInfoPlugin;
import org.killbill.billing.plugin.dao.payment.gen.tables.TestPaymentMethods;
import org.killbill.billing.plugin.dao.payment.gen.tables.TestResponses;
import org.killbill.billing.plugin.dao.payment.gen.tables.records.TestPaymentMethodsRecord;
import org.killbill.billing.plugin.dao.payment.gen.tables.records.TestResponsesRecord;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.clock.Clock;
import org.killbill.killbill.osgi.libs.killbill.OSGIConfigPropertiesService;
import org.killbill.killbill.osgi.libs.killbill.OSGIKillbillAPI;
import org.killbill.killbill.osgi.libs.killbill.OSGIKillbillLogService;

import com.google.common.base.Strings;

public class TestPaymentPluginApi
extends PluginPaymentPluginApi<TestResponsesRecord,
                               TestResponses,
                               TestPaymentMethodsRecord,
                               TestPaymentMethods> {

    protected final TestPluginPaymentDao dao;

    /* ====================================================================== */

    public TestPaymentPluginApi(final OSGIKillbillAPI killbillAPI,
                                final OSGIConfigPropertiesService configProperties,
                                final OSGIKillbillLogService logService,
                                final Clock clock,
                                final TestPluginPaymentDao dao) {
        super(killbillAPI, configProperties, logService, clock, dao);
        this.dao = dao;
    }

    /* ====================================================================== *
     * INHERITED FROM PluginPaymentPluginApi                                  *
     * ====================================================================== */

    /* Used by getPaymentInfo(...) */
    @Override
    protected PaymentTransactionInfoPlugin buildPaymentTransactionInfoPlugin(final TestResponsesRecord record) {

        final DateTime createdDate = new DateTime(record.getCreatedDate(), DateTimeZone.UTC);
        final List<PluginProperty> properties = TestUtils.buildPluginProperties(record.getAdditionalData());

        return new PluginPaymentTransactionInfoPlugin(UUID.fromString(record.getKbPaymentId()),
                                                      UUID.fromString(record.getKbPaymentTransactionId()),
                                                      TransactionType.valueOf(record.getTransactionType()),
                                                      record.getAmount(),
                                                      Strings.isNullOrEmpty(record.getCurrency()) ? null : Currency.valueOf(record.getCurrency()),
                                                      PaymentPluginStatus.UNDEFINED,
                                                      null, // String gatewayError
                                                      null, // String gatewayErrorCode
                                                      null, // String firstPaymentReferenceId
                                                      null, // String secondPaymentReferenceId
                                                      createdDate,
                                                      createdDate,
                                                      properties);
    }

    /* Used by getPaymentMethodDetail(...) */
    @Override
    protected PaymentMethodPlugin buildPaymentMethodPlugin(final TestPaymentMethodsRecord record) {
        return new PluginPaymentMethodPlugin(UUID.fromString(record.getKbPaymentMethodId()),
                                             record.getToken(),
                                             record.getIsDefault() == PluginPaymentDao.TRUE,
                                             TestUtils.buildPluginProperties(record.getAdditionalData()));
    }

    /* Used by getPaymentMethods(...) */
    @Override
    protected PaymentMethodInfoPlugin buildPaymentMethodInfoPlugin(final TestPaymentMethodsRecord record) {
        return new PluginPaymentMethodInfoPlugin(UUID.fromString(record.getKbAccountId()),
                                                 UUID.fromString(record.getKbPaymentMethodId()),
                                                 record.getIsDefault() == PluginPaymentDao.TRUE,
                                                 record.getToken());
    }

    /* Used by resetPaymentMethods(...) */
    @Override
    protected String getPaymentMethodId(final TestPaymentMethodsRecord record) {
        return record.getKbPaymentMethodId();
    }

    /* ====================================================================== *
     * UNSUPPORTED OPERATIONS                                                 *
     * ====================================================================== */

    @Override
    public PaymentTransactionInfoPlugin purchasePayment(final UUID kbAccountId,
                                                        final UUID kbPaymentId,
                                                        final UUID kbTransactionId,
                                                        final UUID kbPaymentMethodId,
                                                        final BigDecimal amount,
                                                        final Currency currency,
                                                        final Iterable<PluginProperty> properties,
                                                        final CallContext context)
    throws PaymentPluginApiException {
        throw new PaymentPluginApiException(null, "Unsupported operation");
    }

    @Override
    public PaymentTransactionInfoPlugin authorizePayment(final UUID kbAccountId,
                                                         final UUID kbPaymentId,
                                                         final UUID kbTransactionId,
                                                         final UUID kbPaymentMethodId,
                                                         final BigDecimal amount,
                                                         final Currency currency,
                                                         final Iterable<PluginProperty> properties,
                                                         final CallContext context)
    throws PaymentPluginApiException {
        throw new PaymentPluginApiException(null, "Unsupported operation");
    }

    @Override
    public PaymentTransactionInfoPlugin capturePayment(final UUID kbAccountId,
                                                       final UUID kbPaymentId,
                                                       final UUID kbTransactionId,
                                                       final UUID kbPaymentMethodId,
                                                       final BigDecimal amount,
                                                       final Currency currency,
                                                       final Iterable<PluginProperty> properties,
                                                       final CallContext context)
   throws PaymentPluginApiException {
        throw new PaymentPluginApiException(null, "Unsupported operation");
    }

    @Override
    public PaymentTransactionInfoPlugin refundPayment(final UUID kbAccountId,
                                                      final UUID kbPaymentId,
                                                      final UUID kbTransactionId,
                                                      final UUID kbPaymentMethodId,
                                                      final BigDecimal amount,
                                                      final Currency currency,
                                                      final Iterable<PluginProperty> properties,
                                                      final CallContext context)
    throws PaymentPluginApiException {
        throw new PaymentPluginApiException(null, "Unsupported operation");
    }

    @Override
    public PaymentTransactionInfoPlugin voidPayment(final UUID kbAccountId,
                                                    final UUID kbPaymentId,
                                                    final UUID kbTransactionId,
                                                    final UUID kbPaymentMethodId,
                                                    final Iterable<PluginProperty> properties,
                                                    final CallContext context)
    throws PaymentPluginApiException {
        throw new PaymentPluginApiException(null, "Unsupported operation");
    }

    @Override
    public PaymentTransactionInfoPlugin creditPayment(final UUID kbAccountId,
                                                      final UUID kbPaymentId,
                                                      final UUID kbTransactionId,
                                                      final UUID kbPaymentMethodId,
                                                      final BigDecimal amount,
                                                      final Currency currency,
                                                      final Iterable<PluginProperty> properties,
                                                      final CallContext context)
    throws PaymentPluginApiException {
        throw new PaymentPluginApiException(null, "Unsupported operation");
    }

    @Override
    public HostedPaymentPageFormDescriptor buildFormDescriptor(final UUID kbAccountId,
                                                               final Iterable<PluginProperty> customFields,
                                                               final Iterable<PluginProperty> properties,
                                                               final CallContext context)
    throws PaymentPluginApiException {
        throw new PaymentPluginApiException(null, "Unsupported operation");
    }

    @Override
    public GatewayNotification processNotification(final String notification,
                                                   final Iterable<PluginProperty> properties,
                                                   final CallContext context)
    throws PaymentPluginApiException {
        throw new PaymentPluginApiException(null, "Unsupported operation");
    }
}
