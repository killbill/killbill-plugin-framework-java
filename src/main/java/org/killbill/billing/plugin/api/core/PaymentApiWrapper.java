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

package org.killbill.billing.plugin.api.core;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import org.joda.time.DateTime;
import org.killbill.billing.account.api.Account;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillAPI;
import org.killbill.billing.payment.api.Payment;
import org.killbill.billing.payment.api.PaymentApiException;
import org.killbill.billing.payment.api.PaymentOptions;
import org.killbill.billing.payment.api.PaymentTransaction;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.api.TransactionStatus;
import org.killbill.billing.payment.api.TransactionType;
import org.killbill.billing.payment.plugin.api.PaymentPluginStatus;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;

public class PaymentApiWrapper {

    private static final Logger logger = LoggerFactory.getLogger(PaymentApiWrapper.class);

    private final OSGIKillbillAPI osgiKillbillAPI;
    private final boolean withControl;

    public PaymentApiWrapper(final OSGIKillbillAPI osgiKillbillAPIL, final boolean withControl) {
        this.osgiKillbillAPI = osgiKillbillAPIL;
        this.withControl = withControl;
    }

    public List<String> getPaymentControlPluginNames(final UUID kbPaymentId, final TenantContext context) throws PaymentApiException {
        if (!withControl) {
            // Note that we could have decided to always call the control APIs with an empty list, since Kill Bill would have defaulted
            // to the non-control APIs. However, it might be better for the long term to not rely on that specific implementation behavior
            // (we have two APIs after all).
            return null;
        }

        final Payment payment = osgiKillbillAPI.getPaymentApi().getPayment(kbPaymentId, false, true, ImmutableList.<PluginProperty>of(), context);
        if (payment.getPaymentAttempts() != null && !payment.getPaymentAttempts().isEmpty()) {
            return ImmutableList.<String>copyOf(Splitter.on(",").split(payment.getPaymentAttempts().get(0).getPluginName()));
        } else {
            return ImmutableList.<String>of();
        }
    }

    public PaymentTransaction transitionPendingTransaction(final Account account,
                                                           final UUID kbPaymentId,
                                                           final UUID kbPaymentTransactionId,
                                                           final PaymentPluginStatus paymentPluginStatus,
                                                           final CallContext context) throws PaymentApiException {
        final Payment payment;
        final PaymentOptions paymentOptions = getPaymentOptions(kbPaymentId, context);
        if (paymentOptions == null) {
            payment = osgiKillbillAPI.getPaymentApi().notifyPendingTransactionOfStateChanged(account,
                                                                                             kbPaymentTransactionId,
                                                                                             paymentPluginStatus == PaymentPluginStatus.PROCESSED,
                                                                                             context);
        } else {
            payment = osgiKillbillAPI.getPaymentApi().notifyPendingTransactionOfStateChangedWithPaymentControl(account,
                                                                                                               kbPaymentTransactionId,
                                                                                                               paymentPluginStatus == PaymentPluginStatus.PROCESSED,
                                                                                                               paymentOptions,
                                                                                                               context);
        }
        return filterForTransaction(payment, kbPaymentTransactionId);
    }

    public PaymentTransaction fixPaymentTransactionState(final Payment payment,
                                                         final PaymentPluginStatus paymentPluginStatus,
                                                         final PaymentTransaction updatedPaymentTransaction,
                                                         final CallContext context) throws PaymentApiException {
        final String currentPaymentStateName = String.format("%s_%s", updatedPaymentTransaction.getTransactionType() == TransactionType.AUTHORIZE ? "AUTH" : updatedPaymentTransaction.getTransactionType(), paymentPluginStatus == PaymentPluginStatus.PROCESSED ? "SUCCESS" : "FAILED");
        final String lastSuccessfulPaymentStateName = paymentPluginStatus == PaymentPluginStatus.PROCESSED ? currentPaymentStateName : null;

        final TransactionStatus transactionStatus;
        switch (paymentPluginStatus) {
            case PROCESSED:
                transactionStatus = TransactionStatus.SUCCESS;
                break;
            case PENDING:
                transactionStatus = TransactionStatus.PENDING;
                break;
            case ERROR:
                transactionStatus = TransactionStatus.PAYMENT_FAILURE;
                break;
            case CANCELED:
                transactionStatus = TransactionStatus.PLUGIN_FAILURE;
                break;
            default:
                transactionStatus = TransactionStatus.UNKNOWN;
                break;
        }

        logger.warn("Forcing transition paymentTransactionExternalKey='{}', oldPaymentPluginStatus='{}', newPaymentPluginStatus='{}'",
                    updatedPaymentTransaction.getExternalKey(),
                    updatedPaymentTransaction.getPaymentInfoPlugin().getStatus(),
                    paymentPluginStatus);

        osgiKillbillAPI.getAdminPaymentApi().fixPaymentTransactionState(payment, updatedPaymentTransaction, transactionStatus, lastSuccessfulPaymentStateName, currentPaymentStateName, ImmutableList.<PluginProperty>of(), context);
        final Payment fixedPayment = osgiKillbillAPI.getPaymentApi().getPayment(payment.getId(), true, false, ImmutableList.<PluginProperty>of(), context);
        return filterForTransaction(fixedPayment, updatedPaymentTransaction.getId());
    }

    public PaymentTransaction createPayment(final TransactionType transactionType,
                                            final Account account,
                                            final UUID kbPaymentMethodId,
                                            @Nullable final UUID kbPaymentId,
                                            final BigDecimal amount,
                                            final Currency currency,
                                            final String paymentExternalKey,
                                            final String paymentTransactionExternalKey,
                                            final Iterable<PluginProperty> pluginProperties,
                                            final CallContext context) throws PaymentApiException {
        final PaymentOptions paymentOptions;
        if (kbPaymentId != null) {
            paymentOptions = getPaymentOptions(kbPaymentId, context);
        } else {
            paymentOptions = null;
        }

        final DateTime effectiveDate = context.getCreatedDate();
        final Payment createdPayment;
        switch (transactionType) {
            case AUTHORIZE:
                if (paymentOptions == null) {
                    createdPayment = osgiKillbillAPI.getPaymentApi().createAuthorization(account,
                                                                                         kbPaymentMethodId,
                                                                                         kbPaymentId,
                                                                                         amount,
                                                                                         currency,
                                                                                         effectiveDate,
                                                                                         paymentExternalKey,
                                                                                         paymentTransactionExternalKey,
                                                                                         pluginProperties,
                                                                                         context);
                } else {
                    createdPayment = osgiKillbillAPI.getPaymentApi().createAuthorizationWithPaymentControl(account,
                                                                                                           kbPaymentMethodId,
                                                                                                           kbPaymentId,
                                                                                                           amount,
                                                                                                           currency,
                                                                                                           effectiveDate,
                                                                                                           paymentExternalKey,
                                                                                                           paymentTransactionExternalKey,
                                                                                                           pluginProperties,
                                                                                                           paymentOptions,
                                                                                                           context);
                }
                break;
            case CAPTURE:
                if (paymentOptions == null) {
                    createdPayment = osgiKillbillAPI.getPaymentApi().createCapture(account,
                                                                                   kbPaymentId,
                                                                                   amount,
                                                                                   currency,
                                                                                   effectiveDate,
                                                                                   paymentTransactionExternalKey,
                                                                                   pluginProperties,
                                                                                   context);

                } else {
                    createdPayment = osgiKillbillAPI.getPaymentApi().createCaptureWithPaymentControl(account,
                                                                                                     kbPaymentId,
                                                                                                     amount,
                                                                                                     currency,
                                                                                                     effectiveDate,
                                                                                                     paymentTransactionExternalKey,
                                                                                                     pluginProperties,
                                                                                                     paymentOptions,
                                                                                                     context);
                }
                break;
            case CHARGEBACK:
                if (paymentOptions == null) {
                    createdPayment = osgiKillbillAPI.getPaymentApi().createChargeback(account,
                                                                                      kbPaymentId,
                                                                                      amount,
                                                                                      currency,
                                                                                      effectiveDate,
                                                                                      paymentTransactionExternalKey,
                                                                                      context);
                } else {
                    createdPayment = osgiKillbillAPI.getPaymentApi().createChargebackWithPaymentControl(account,
                                                                                                        kbPaymentId,
                                                                                                        amount,
                                                                                                        currency,
                                                                                                        effectiveDate,
                                                                                                        paymentTransactionExternalKey,
                                                                                                        paymentOptions,
                                                                                                        context);
                }
                break;
            case CREDIT:
                if (paymentOptions == null) {
                    createdPayment = osgiKillbillAPI.getPaymentApi().createCredit(account,
                                                                                  kbPaymentMethodId,
                                                                                  kbPaymentId,
                                                                                  amount,
                                                                                  currency,
                                                                                  effectiveDate,
                                                                                  paymentExternalKey,
                                                                                  paymentTransactionExternalKey,
                                                                                  pluginProperties,
                                                                                  context);
                } else {
                    createdPayment = osgiKillbillAPI.getPaymentApi().createCreditWithPaymentControl(account,
                                                                                                    kbPaymentMethodId,
                                                                                                    kbPaymentId,
                                                                                                    amount,
                                                                                                    currency,
                                                                                                    effectiveDate,
                                                                                                    paymentExternalKey,
                                                                                                    paymentTransactionExternalKey,
                                                                                                    pluginProperties,
                                                                                                    paymentOptions,
                                                                                                    context);
                }
                break;
            case PURCHASE:
                if (paymentOptions == null) {
                    createdPayment = osgiKillbillAPI.getPaymentApi().createPurchase(account,
                                                                                    kbPaymentMethodId,
                                                                                    kbPaymentId,
                                                                                    amount,
                                                                                    currency,
                                                                                    effectiveDate,
                                                                                    paymentExternalKey,
                                                                                    paymentTransactionExternalKey,
                                                                                    pluginProperties,
                                                                                    context);
                } else {
                    createdPayment = osgiKillbillAPI.getPaymentApi().createPurchaseWithPaymentControl(account,
                                                                                                      kbPaymentMethodId,
                                                                                                      kbPaymentId,
                                                                                                      amount,
                                                                                                      currency,
                                                                                                      effectiveDate,
                                                                                                      paymentExternalKey,
                                                                                                      paymentTransactionExternalKey,
                                                                                                      pluginProperties,
                                                                                                      paymentOptions,
                                                                                                      context);
                }
                break;
            case REFUND:
                if (paymentOptions == null) {
                    createdPayment = osgiKillbillAPI.getPaymentApi().createRefund(account,
                                                                                  kbPaymentId,
                                                                                  amount,
                                                                                  currency,
                                                                                  effectiveDate,
                                                                                  paymentTransactionExternalKey,
                                                                                  pluginProperties,
                                                                                  context);
                } else {
                    createdPayment = osgiKillbillAPI.getPaymentApi().createRefundWithPaymentControl(account,
                                                                                                    kbPaymentId,
                                                                                                    amount,
                                                                                                    currency,
                                                                                                    effectiveDate,
                                                                                                    paymentTransactionExternalKey,
                                                                                                    pluginProperties,
                                                                                                    paymentOptions,
                                                                                                    context);
                }
                break;
            case VOID:
                if (paymentOptions == null) {
                    createdPayment = osgiKillbillAPI.getPaymentApi().createVoid(account,
                                                                                kbPaymentId,
                                                                                effectiveDate,
                                                                                paymentTransactionExternalKey,
                                                                                pluginProperties,
                                                                                context);
                } else {
                    createdPayment = osgiKillbillAPI.getPaymentApi().createVoidWithPaymentControl(account,
                                                                                                  kbPaymentId,
                                                                                                  effectiveDate,
                                                                                                  paymentTransactionExternalKey,
                                                                                                  pluginProperties,
                                                                                                  paymentOptions,
                                                                                                  context);
                }
                break;
            default:
                throw new IllegalStateException("Should never happen");
        }
        return filterForLastTransaction(createdPayment);
    }

    public PaymentTransaction createChargeback(final Account account,
                                               final UUID kbPaymentId,
                                               final BigDecimal amount,
                                               final Currency currency,
                                               final String paymentTransactionExternalKey,
                                               final CallContext context) throws PaymentApiException {
        final DateTime effectiveDate = context.getCreatedDate();
        final Payment chargeback;
        final PaymentOptions paymentOptions = getPaymentOptions(kbPaymentId, context);
        if (paymentOptions == null) {
            chargeback = osgiKillbillAPI.getPaymentApi().createChargeback(account,
                                                                          kbPaymentId,
                                                                          amount,
                                                                          currency,
                                                                          effectiveDate,
                                                                          paymentTransactionExternalKey,
                                                                          context);

        } else {
            chargeback = osgiKillbillAPI.getPaymentApi().createChargebackWithPaymentControl(account,
                                                                                            kbPaymentId,
                                                                                            amount,
                                                                                            currency,
                                                                                            effectiveDate,
                                                                                            paymentTransactionExternalKey,
                                                                                            paymentOptions,
                                                                                            context);
        }
        return filterForLastTransaction(chargeback);
    }

    public PaymentTransaction createChargebackReversal(final Account account,
                                                       final UUID kbPaymentId,
                                                       final PaymentTransaction chargeback,
                                                       final CallContext context) throws PaymentApiException {
        final DateTime effectiveDate = context.getCreatedDate();
        final String paymentTransactionExternalKey = chargeback.getExternalKey();

        final Payment chargebackReversal;
        final PaymentOptions paymentOptions = getPaymentOptions(kbPaymentId, context);
        if (paymentOptions == null) {
            chargebackReversal = osgiKillbillAPI.getPaymentApi().createChargebackReversal(account,
                                                                                          kbPaymentId,
                                                                                          effectiveDate,
                                                                                          paymentTransactionExternalKey,
                                                                                          context);
        } else {
            chargebackReversal = osgiKillbillAPI.getPaymentApi().createChargebackReversalWithPaymentControl(account,
                                                                                                            kbPaymentId,
                                                                                                            effectiveDate,
                                                                                                            paymentTransactionExternalKey,
                                                                                                            paymentOptions,
                                                                                                            context);
        }
        return filterForLastTransaction(chargebackReversal);
    }

    protected PluginPaymentOptions getPaymentOptions(final UUID kbPaymentId, final TenantContext context) throws PaymentApiException {
        final List<String> paymentControlPluginNames = getPaymentControlPluginNames(kbPaymentId, context);
        if (paymentControlPluginNames == null) {
            return null;
        } else {
            return new PluginPaymentOptions(paymentControlPluginNames);
        }
    }

    public static PaymentTransaction filterForLastTransaction(final Payment payment) {
        final int numberOfTransaction = payment.getTransactions().size();
        return payment.getTransactions().get(numberOfTransaction - 1);
    }

    public static PaymentTransaction filterForTransaction(final Payment payment, final UUID kbTransactionId) {
        for (final PaymentTransaction paymentTransaction : payment.getTransactions()) {
            if (paymentTransaction.getId().equals(kbTransactionId)) {
                return paymentTransaction;
            }
        }
        return null;
    }

    public static PaymentTransaction filterForTransaction(final Payment payment, final TransactionType transactionType) {
        for (final PaymentTransaction paymentTransaction : payment.getTransactions()) {
            if (paymentTransaction.getTransactionType().equals(transactionType)) {
                return paymentTransaction;
            }
        }
        return null;
    }
}
