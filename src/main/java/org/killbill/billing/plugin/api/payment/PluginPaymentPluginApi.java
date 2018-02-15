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

package org.killbill.billing.plugin.api.payment;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.joda.time.DateTime;
import org.jooq.Table;
import org.jooq.UpdatableRecord;
import org.killbill.billing.osgi.libs.killbill.OSGIConfigPropertiesService;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillAPI;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillLogService;
import org.killbill.billing.payment.api.PaymentMethodPlugin;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.plugin.api.PaymentMethodInfoPlugin;
import org.killbill.billing.payment.plugin.api.PaymentPluginApi;
import org.killbill.billing.payment.plugin.api.PaymentPluginApiException;
import org.killbill.billing.payment.plugin.api.PaymentTransactionInfoPlugin;
import org.killbill.billing.plugin.api.PluginApi;
import org.killbill.billing.plugin.api.PluginProperties;
import org.killbill.billing.plugin.dao.payment.PluginPaymentDao;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;
import org.killbill.billing.util.entity.Pagination;
import org.killbill.clock.Clock;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public abstract class PluginPaymentPluginApi<RESP_R extends UpdatableRecord<RESP_R>, RESP_T extends Table<RESP_R>, PM_R extends UpdatableRecord<PM_R>, PM_T extends Table<PM_R>> extends PluginApi implements PaymentPluginApi {

    // By convention, support the same keys as the Ruby plugins (https://github.com/killbill/killbill-plugin-framework-ruby/blob/master/lib/killbill/helpers/active_merchant/payment_plugin.rb)
    public static final String PROPERTY_TOKEN = "token";
    public static final String PROPERTY_CC_NUMBER = "ccNumber";
    public static final String PROPERTY_CC_TYPE = "ccType";
    public static final String PROPERTY_CC_EXPIRATION_MONTH = "ccExpirationMonth";
    public static final String PROPERTY_CC_EXPIRATION_YEAR = "ccExpirationYear";
    public static final String PROPERTY_CC_START_MONTH = "ccStartMonth";
    public static final String PROPERTY_CC_START_YEAR = "ccStartYear";
    public static final String PROPERTY_CC_VERIFICATION_VALUE = "ccVerificationValue";
    public static final String PROPERTY_CC_ISSUE_NUMBER = "ccIssueNumber";
    public static final String PROPERTY_CC_FIRST_NAME = "ccFirstName";
    public static final String PROPERTY_CC_LAST_NAME = "ccLastName";
    public static final String PROPERTY_CC_TRACK_DATA = "ccTrackData";
    public static final String PROPERTY_ADDRESS1 = "address1";
    public static final String PROPERTY_ADDRESS2 = "address2";
    public static final String PROPERTY_CITY = "city";
    public static final String PROPERTY_STATE = "state";
    public static final String PROPERTY_ZIP = "zip";
    public static final String PROPERTY_COUNTRY = "country";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_CURRENCY = "currency";

    protected final PluginPaymentDao<RESP_R, RESP_T, PM_R, PM_T> dao;

    public PluginPaymentPluginApi(final OSGIKillbillAPI killbillAPI,
                                  final OSGIConfigPropertiesService configProperties,
                                  final OSGIKillbillLogService logService,
                                  final Clock clock,
                                  final PluginPaymentDao<RESP_R, RESP_T, PM_R, PM_T> dao) {
        super(killbillAPI, configProperties, logService, clock);
        this.dao = dao;
    }

    protected abstract PaymentTransactionInfoPlugin buildPaymentTransactionInfoPlugin(final RESP_R record);

    protected abstract PaymentMethodPlugin buildPaymentMethodPlugin(final PM_R record);

    protected abstract PaymentMethodInfoPlugin buildPaymentMethodInfoPlugin(final PM_R record);

    protected abstract String getPaymentMethodId(PM_R input);

    // Payments

    @Override
    public List<PaymentTransactionInfoPlugin> getPaymentInfo(final UUID kbAccountId, final UUID kbPaymentId, final Iterable<PluginProperty> properties, final TenantContext context) throws PaymentPluginApiException {
        final List<RESP_R> records;
        try {
            records = dao.getResponses(kbPaymentId, context.getTenantId());
        } catch (final SQLException e) {
            throw new PaymentPluginApiException("Unable to retrieve payments for kbPaymentId " + kbPaymentId, e);
        }

        return Lists.<RESP_R, PaymentTransactionInfoPlugin>transform(records,
                                                                     new Function<RESP_R, PaymentTransactionInfoPlugin>() {
                                                                         @Override
                                                                         public PaymentTransactionInfoPlugin apply(final RESP_R record) {
                                                                             return buildPaymentTransactionInfoPlugin(record);
                                                                         }
                                                                     });
    }

    @Override
    public Pagination<PaymentTransactionInfoPlugin> searchPayments(final String searchKey, final Long offset, final Long limit, final Iterable<PluginProperty> properties, final TenantContext context) throws PaymentPluginApiException {
        throw new PaymentPluginApiException(null, "SEARCH: unsupported operation");
    }

    // Payment methods

    @Override
    public void addPaymentMethod(final UUID kbAccountId, final UUID kbPaymentMethodId, final PaymentMethodPlugin paymentMethodProps, final boolean setDefault, final Iterable<PluginProperty> properties, final CallContext context) throws PaymentPluginApiException {
        // Note: query parameters have precedence by convention
        final Map<String, String> mergedProperties = PluginProperties.toStringMap(paymentMethodProps.getProperties(), properties);

        final DateTime utcNow = clock.getUTCNow();
        try {
            dao.addPaymentMethod(kbAccountId, kbPaymentMethodId, setDefault, mergedProperties, utcNow, context.getTenantId());
        } catch (final SQLException e) {
            throw new PaymentPluginApiException("Unable to add payment method for kbPaymentMethodId " + kbPaymentMethodId, e);
        }
    }

    @Override
    public void deletePaymentMethod(final UUID kbAccountId, final UUID kbPaymentMethodId, final Iterable<PluginProperty> properties, final CallContext context) throws PaymentPluginApiException {
        final DateTime utcNow = clock.getUTCNow();
        try {
            dao.deletePaymentMethod(kbPaymentMethodId, utcNow, context.getTenantId());
        } catch (final SQLException e) {
            throw new PaymentPluginApiException("Unable to delete payment method for kbPaymentMethodId " + kbPaymentMethodId, e);
        }
    }

    @Override
    public PaymentMethodPlugin getPaymentMethodDetail(final UUID kbAccountId, final UUID kbPaymentMethodId, final Iterable<PluginProperty> properties, final TenantContext context) throws PaymentPluginApiException {
        final PM_R record;
        try {
            record = dao.getPaymentMethod(kbPaymentMethodId, context.getTenantId());
        } catch (final SQLException e) {
            throw new PaymentPluginApiException("Unable to retrieve payment method for kbPaymentMethodId " + kbPaymentMethodId, e);
        }

        return buildPaymentMethodPlugin(record);
    }

    @Override
    public void setDefaultPaymentMethod(final UUID kbAccountId, final UUID kbPaymentMethodId, final Iterable<PluginProperty> properties, final CallContext context) throws PaymentPluginApiException {
        final DateTime utcNow = clock.getUTCNow();
        try {
            dao.setDefaultPaymentMethod(kbAccountId, kbPaymentMethodId, utcNow, context.getTenantId());
        } catch (final SQLException e) {
            throw new PaymentPluginApiException("Unable to set default payment method for kbPaymentMethodId " + kbPaymentMethodId, e);
        }
    }

    @Override
    public List<PaymentMethodInfoPlugin> getPaymentMethods(final UUID kbAccountId, final boolean refreshFromGateway, final Iterable<PluginProperty> properties, final CallContext context) throws PaymentPluginApiException {
        final List<PM_R> records;
        try {
            records = dao.getPaymentMethods(kbAccountId, context.getTenantId());
        } catch (final SQLException e) {
            throw new PaymentPluginApiException("Unable to retrieve payment methods for kbAccountId " + kbAccountId, e);
        }

        return Lists.<PM_R, PaymentMethodInfoPlugin>transform(records,
                                                              new Function<PM_R, PaymentMethodInfoPlugin>() {
                                                                  @Override
                                                                  public PaymentMethodInfoPlugin apply(final PM_R record) {
                                                                      return buildPaymentMethodInfoPlugin(record);
                                                                  }
                                                              });
    }

    @Override
    public Pagination<PaymentMethodPlugin> searchPaymentMethods(final String searchKey, final Long offset, final Long limit, final Iterable<PluginProperty> properties, final TenantContext context) throws PaymentPluginApiException {
        throw new PaymentPluginApiException(null, "SEARCH: unsupported operation");
    }

    @Override
    public void resetPaymentMethods(final UUID kbAccountId, final List<PaymentMethodInfoPlugin> paymentMethods, final Iterable<PluginProperty> properties, final CallContext context) throws PaymentPluginApiException {
        final List<PM_R> records;
        try {
            records = dao.getPaymentMethods(kbAccountId, context.getTenantId());
        } catch (final SQLException e) {
            throw new PaymentPluginApiException("Unable to retrieve payment methods for kbAccountId " + kbAccountId, e);
        }

        final Set<UUID> existingPaymentMethodIds = ImmutableSet.<UUID>copyOf(Iterables.<PM_R, UUID>transform(records,
                                                                                                             new Function<PM_R, UUID>() {
                                                                                                                 @Override
                                                                                                                 public UUID apply(final PM_R input) {
                                                                                                                     return UUID.fromString(getPaymentMethodId(input));
                                                                                                                 }
                                                                                                             }));

        final DateTime utcNow = clock.getUTCNow();
        for (final PaymentMethodInfoPlugin existingPaymentMethod : paymentMethods) {
            if (!existingPaymentMethodIds.contains(existingPaymentMethod.getPaymentMethodId())) {
                try {
                    dao.addPaymentMethod(kbAccountId, existingPaymentMethod.getPaymentMethodId(), existingPaymentMethod.isDefault(), PluginProperties.toStringMap(properties), utcNow, context.getTenantId());
                } catch (final SQLException e) {
                    throw new PaymentPluginApiException("Unable to add payment method for kbPaymentMethodId " + existingPaymentMethod.getPaymentMethodId(), e);
                }
            }
        }
    }
}
