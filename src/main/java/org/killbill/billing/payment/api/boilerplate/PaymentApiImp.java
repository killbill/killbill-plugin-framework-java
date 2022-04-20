/* This is generated code, edit with caution! */
/*
 * Copyright 2022-2022 The Billing Project, LLC
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

package org.killbill.billing.payment.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.killbill.billing.account.api.Account;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.payment.api.Payment;
import org.killbill.billing.payment.api.PaymentApi;
import org.killbill.billing.payment.api.PaymentApiException;
import org.killbill.billing.payment.api.PaymentMethod;
import org.killbill.billing.payment.api.PaymentMethodPlugin;
import org.killbill.billing.payment.api.PaymentOptions;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.util.api.AuditLevel;
import org.killbill.billing.util.audit.AuditLogWithHistory;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;
import org.killbill.billing.util.entity.Pagination;

@JsonDeserialize( builder = PaymentApiImp.Builder.class )
public class PaymentApiImp implements PaymentApi {


    public PaymentApiImp(final PaymentApiImp that) {
    }
    protected PaymentApiImp(final PaymentApiImp.Builder<?> builder) {
    }
    protected PaymentApiImp() { }
    @Override
    public Pagination<Payment> getPayments(final Long offset, final Long limit, final String pluginName, final boolean withPluginInfo, final boolean withAttempts, final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("getPayments(java.lang.Long, java.lang.Long, java.lang.String, boolean, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Payment getPayment(final UUID paymentId, final boolean withPluginInfo, final boolean withAttempts, final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("getPayment(java.util.UUID, boolean, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<AuditLogWithHistory> getPaymentMethodAuditLogsWithHistoryForId(final UUID paymentMethodId, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getPaymentMethodAuditLogsWithHistoryForId(java.util.UUID, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Payment createVoidWithPaymentControl(final Account account, final UUID paymentId, final DateTime effectiveDate, final String paymentTransactionExternalKey, final Iterable<PluginProperty> properties, final PaymentOptions paymentOptions, final CallContext context) {
        throw new UnsupportedOperationException("createVoidWithPaymentControl(org.killbill.billing.account.api.Account, java.util.UUID, org.joda.time.DateTime, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.payment.api.PaymentOptions, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Payment createChargeback(final Account account, final UUID paymentId, final BigDecimal amount, final Currency currency, final DateTime effectiveDate, final String paymentTransactionExternalKey, final CallContext context) {
        throw new UnsupportedOperationException("createChargeback(org.killbill.billing.account.api.Account, java.util.UUID, java.math.BigDecimal, org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime, java.lang.String, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<PaymentMethod> refreshPaymentMethods(final Account account, final String pluginName, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("refreshPaymentMethods(org.killbill.billing.account.api.Account, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<AuditLogWithHistory> getPaymentAttemptAuditLogsWithHistoryForId(final UUID paymentAttemptId, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getPaymentAttemptAuditLogsWithHistoryForId(java.util.UUID, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public UUID addPaymentMethodWithPaymentControl(final Account account, final String paymentMethodExternalKey, final String pluginName, final boolean setDefault, final PaymentMethodPlugin paymentMethodInfo, final Iterable<PluginProperty> properties, final PaymentOptions paymentOptions, final CallContext context) {
        throw new UnsupportedOperationException("addPaymentMethodWithPaymentControl(org.killbill.billing.account.api.Account, java.lang.String, java.lang.String, boolean, org.killbill.billing.payment.api.PaymentMethodPlugin, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.payment.api.PaymentOptions, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Payment createCapture(final Account account, final UUID paymentId, final BigDecimal amount, final Currency currency, final DateTime effectiveDate, final String paymentTransactionExternalKey, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("createCapture(org.killbill.billing.account.api.Account, java.util.UUID, java.math.BigDecimal, org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Payment getPaymentByExternalKey(final String paymentExternalKey, final boolean withPluginInfo, final boolean withAttempts, final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("getPaymentByExternalKey(java.lang.String, boolean, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<AuditLogWithHistory> getPaymentAuditLogsWithHistoryForId(final UUID paymentId, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getPaymentAuditLogsWithHistoryForId(java.util.UUID, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Payment createPurchase(final Account account, final UUID paymentMethodId, final UUID paymentId, final BigDecimal amount, final Currency currency, final DateTime effectiveDate, final String paymentExternalKey, final String paymentTransactionExternalKey, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("createPurchase(org.killbill.billing.account.api.Account, java.util.UUID, java.util.UUID, java.math.BigDecimal, org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime, java.lang.String, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<AuditLogWithHistory> getPaymentTransactionAuditLogsWithHistoryForId(final UUID paymentTransactionId, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getPaymentTransactionAuditLogsWithHistoryForId(java.util.UUID, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Payment notifyPendingTransactionOfStateChanged(final Account account, final UUID paymentTransactionId, final boolean isSuccess, final CallContext context) {
        throw new UnsupportedOperationException("notifyPendingTransactionOfStateChanged(org.killbill.billing.account.api.Account, java.util.UUID, boolean, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Pagination<Payment> searchPayments(final String searchKey, final Long offset, final Long limit, final boolean withPluginInfo, final boolean withAttempts, final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("searchPayments(java.lang.String, java.lang.Long, java.lang.Long, boolean, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void cancelScheduledPaymentTransaction(final UUID paymentTransactionId, final CallContext context) {
        throw new UnsupportedOperationException("cancelScheduledPaymentTransaction(java.util.UUID, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Payment createRefundWithPaymentControl(final Account account, final UUID paymentId, final BigDecimal amount, final Currency currency, final DateTime effectiveDate, final String paymentTransactionExternalKey, final Iterable<PluginProperty> properties, final PaymentOptions paymentOptions, final CallContext context) {
        throw new UnsupportedOperationException("createRefundWithPaymentControl(org.killbill.billing.account.api.Account, java.util.UUID, java.math.BigDecimal, org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.payment.api.PaymentOptions, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Payment createCreditWithPaymentControl(final Account account, final UUID paymentMethodId, final UUID paymentId, final BigDecimal amount, final Currency currency, final DateTime effectiveDate, final String paymentExternalKey, final String paymentTransactionExternalKey, final Iterable<PluginProperty> properties, final PaymentOptions paymentOptions, final CallContext context) {
        throw new UnsupportedOperationException("createCreditWithPaymentControl(org.killbill.billing.account.api.Account, java.util.UUID, java.util.UUID, java.math.BigDecimal, org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime, java.lang.String, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.payment.api.PaymentOptions, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Payment getPaymentByTransactionExternalKey(final String transactionExternalKey, final boolean withPluginInfo, final boolean withAttempts, final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("getPaymentByTransactionExternalKey(java.lang.String, boolean, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<PaymentMethod> refreshPaymentMethods(final Account account, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("refreshPaymentMethods(org.killbill.billing.account.api.Account, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public PaymentMethod getPaymentMethodByExternalKey(final String paymentMethodExternalKey, final boolean includedInactive, final boolean withPluginInfo, final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("getPaymentMethodByExternalKey(java.lang.String, boolean, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Pagination<PaymentMethod> searchPaymentMethods(final String searchKey, final Long offset, final Long limit, final String pluginName, final boolean withPluginInfo, final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("searchPaymentMethods(java.lang.String, java.lang.Long, java.lang.Long, java.lang.String, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Payment createChargebackWithPaymentControl(final Account account, final UUID paymentId, final BigDecimal amount, final Currency currency, final DateTime effectiveDate, final String paymentTransactionExternalKey, final PaymentOptions paymentOptions, final CallContext context) {
        throw new UnsupportedOperationException("createChargebackWithPaymentControl(org.killbill.billing.account.api.Account, java.util.UUID, java.math.BigDecimal, org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime, java.lang.String, org.killbill.billing.payment.api.PaymentOptions, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Pagination<PaymentMethod> getPaymentMethods(final Long offset, final Long limit, final String pluginName, final boolean withPluginInfo, final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("getPaymentMethods(java.lang.Long, java.lang.Long, java.lang.String, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public UUID addPaymentMethod(final Account account, final String paymentMethodExternalKey, final String pluginName, final boolean setDefault, final PaymentMethodPlugin paymentMethodInfo, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("addPaymentMethod(org.killbill.billing.account.api.Account, java.lang.String, java.lang.String, boolean, org.killbill.billing.payment.api.PaymentMethodPlugin, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Payment createCredit(final Account account, final UUID paymentMethodId, final UUID paymentId, final BigDecimal amount, final Currency currency, final DateTime effectiveDate, final String paymentExternalKey, final String paymentTransactionExternalKey, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("createCredit(org.killbill.billing.account.api.Account, java.util.UUID, java.util.UUID, java.math.BigDecimal, org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime, java.lang.String, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public void cancelScheduledPaymentTransaction(final String paymentTransactionExternalKey, final CallContext context) {
        throw new UnsupportedOperationException("cancelScheduledPaymentTransaction(java.lang.String, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public void setDefaultPaymentMethod(final Account account, final UUID paymentMethodId, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("setDefaultPaymentMethod(org.killbill.billing.account.api.Account, java.util.UUID, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Payment createAuthorization(final Account account, final UUID paymentMethodId, final UUID paymentId, final BigDecimal amount, final Currency currency, final DateTime effectiveDate, final String paymentExternalKey, final String paymentTransactionExternalKey, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("createAuthorization(org.killbill.billing.account.api.Account, java.util.UUID, java.util.UUID, java.math.BigDecimal, org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime, java.lang.String, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Pagination<PaymentMethod> getPaymentMethods(final Long offset, final Long limit, final boolean withPluginInfo, final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("getPaymentMethods(java.lang.Long, java.lang.Long, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Pagination<PaymentMethod> searchPaymentMethods(final String searchKey, final Long offset, final Long limit, final boolean withPluginInfo, final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("searchPaymentMethods(java.lang.String, java.lang.Long, java.lang.Long, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Payment createVoid(final Account account, final UUID paymentId, final DateTime effectiveDate, final String paymentTransactionExternalKey, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("createVoid(org.killbill.billing.account.api.Account, java.util.UUID, org.joda.time.DateTime, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public void deletePaymentMethod(final Account account, final UUID paymentMethodId, final boolean deleteDefaultPaymentMethodWithAutoPayOff, final boolean forceDefaultPaymentMethodDeletion, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("deletePaymentMethod(org.killbill.billing.account.api.Account, java.util.UUID, boolean, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Payment getPaymentByTransactionId(final UUID transactionId, final boolean withPluginInfo, final boolean withAttempts, final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("getPaymentByTransactionId(java.util.UUID, boolean, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Payment createAuthorizationWithPaymentControl(final Account account, final UUID paymentMethodId, final UUID paymentId, final BigDecimal amount, final Currency currency, final DateTime effectiveDate, final String paymentExternalKey, final String paymentTransactionExternalKey, final Iterable<PluginProperty> properties, final PaymentOptions paymentOptions, final CallContext context) {
        throw new UnsupportedOperationException("createAuthorizationWithPaymentControl(org.killbill.billing.account.api.Account, java.util.UUID, java.util.UUID, java.math.BigDecimal, org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime, java.lang.String, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.payment.api.PaymentOptions, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<Payment> getAccountPayments(final UUID accountId, final boolean withPluginInfo, final boolean withAttempts, final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("getAccountPayments(java.util.UUID, boolean, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Payment createRefund(final Account account, final UUID paymentId, final BigDecimal amount, final Currency currency, final DateTime effectiveDate, final String paymentTransactionExternalKey, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("createRefund(org.killbill.billing.account.api.Account, java.util.UUID, java.math.BigDecimal, org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Pagination<Payment> searchPayments(final String searchKey, final Long offset, final Long limit, final String pluginName, final boolean withPluginInfo, final boolean withAttempts, final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("searchPayments(java.lang.String, java.lang.Long, java.lang.Long, java.lang.String, boolean, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Payment createChargebackReversal(final Account account, final UUID paymentId, final DateTime effectiveDate, final String paymentTransactionExternalKey, final CallContext context) {
        throw new UnsupportedOperationException("createChargebackReversal(org.killbill.billing.account.api.Account, java.util.UUID, org.joda.time.DateTime, java.lang.String, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Payment notifyPendingTransactionOfStateChangedWithPaymentControl(final Account account, final UUID paymentTransactionId, final boolean isSuccess, final PaymentOptions paymentOptions, final CallContext context) {
        throw new UnsupportedOperationException("notifyPendingTransactionOfStateChangedWithPaymentControl(org.killbill.billing.account.api.Account, java.util.UUID, boolean, org.killbill.billing.payment.api.PaymentOptions, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<PaymentMethod> getAccountPaymentMethods(final UUID accountId, final boolean includedInactive, final boolean withPluginInfo, final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("getAccountPaymentMethods(java.util.UUID, boolean, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Pagination<Payment> getPayments(final Long offset, final Long limit, final boolean withPluginInfo, final boolean withAttempts, final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("getPayments(java.lang.Long, java.lang.Long, boolean, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Payment createChargebackReversalWithPaymentControl(final Account account, final UUID paymentId, final DateTime effectiveDate, final String paymentTransactionExternalKey, final PaymentOptions paymentOptions, final CallContext context) {
        throw new UnsupportedOperationException("createChargebackReversalWithPaymentControl(org.killbill.billing.account.api.Account, java.util.UUID, org.joda.time.DateTime, java.lang.String, org.killbill.billing.payment.api.PaymentOptions, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Payment createCaptureWithPaymentControl(final Account account, final UUID paymentId, final BigDecimal amount, final Currency currency, final DateTime effectiveDate, final String paymentTransactionExternalKey, final Iterable<PluginProperty> properties, final PaymentOptions paymentOptions, final CallContext context) {
        throw new UnsupportedOperationException("createCaptureWithPaymentControl(org.killbill.billing.account.api.Account, java.util.UUID, java.math.BigDecimal, org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.payment.api.PaymentOptions, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public PaymentMethod getPaymentMethodById(final UUID paymentMethodId, final boolean includedInactive, final boolean withPluginInfo, final Iterable<PluginProperty> properties, final TenantContext context) {
        throw new UnsupportedOperationException("getPaymentMethodById(java.util.UUID, boolean, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Payment createPurchaseWithPaymentControl(final Account account, final UUID paymentMethodId, final UUID paymentId, final BigDecimal amount, final Currency currency, final DateTime effectiveDate, final String paymentExternalKey, final String paymentTransactionExternalKey, final Iterable<PluginProperty> properties, final PaymentOptions paymentOptions, final CallContext context) {
        throw new UnsupportedOperationException("createPurchaseWithPaymentControl(org.killbill.billing.account.api.Account, java.util.UUID, java.util.UUID, java.math.BigDecimal, org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime, java.lang.String, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.payment.api.PaymentOptions, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PaymentApiImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final PaymentApi that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PaymentApiImp build() {
            return new PaymentApiImp(this.validate());
        }
    }
}
