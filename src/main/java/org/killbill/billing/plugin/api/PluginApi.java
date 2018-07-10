/*
 * Copyright 2014-2017 Groupon, Inc
 * Copyright 2014-2017 The Billing Project, LLC
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

package org.killbill.billing.plugin.api;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.joda.time.LocalDate;
import org.killbill.billing.ObjectType;
import org.killbill.billing.account.api.Account;
import org.killbill.billing.account.api.AccountApiException;
import org.killbill.billing.account.api.AccountUserApi;
import org.killbill.billing.catalog.api.Catalog;
import org.killbill.billing.catalog.api.CatalogApiException;
import org.killbill.billing.catalog.api.CatalogUserApi;
import org.killbill.billing.catalog.api.Plan;
import org.killbill.billing.catalog.api.PlanPhase;
import org.killbill.billing.entitlement.api.SubscriptionApi;
import org.killbill.billing.entitlement.api.SubscriptionApiException;
import org.killbill.billing.entitlement.api.SubscriptionBundle;
import org.killbill.billing.entitlement.api.SubscriptionEvent;
import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.invoice.api.InvoiceItem;
import org.killbill.billing.invoice.api.InvoicePayment;
import org.killbill.billing.invoice.api.InvoiceUserApi;
import org.killbill.billing.osgi.libs.killbill.OSGIConfigPropertiesService;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillAPI;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillLogService;
import org.killbill.billing.osgi.libs.killbill.OSGIServiceNotAvailable;
import org.killbill.billing.payment.api.InvoicePaymentApi;
import org.killbill.billing.payment.api.Payment;
import org.killbill.billing.payment.api.PaymentApi;
import org.killbill.billing.payment.api.PaymentApiException;
import org.killbill.billing.payment.api.PaymentMethod;
import org.killbill.billing.payment.api.PaymentTransaction;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.util.api.AuditLevel;
import org.killbill.billing.util.api.AuditUserApi;
import org.killbill.billing.util.api.CustomFieldUserApi;
import org.killbill.billing.util.api.RecordIdApi;
import org.killbill.billing.util.api.TagUserApi;
import org.killbill.billing.util.audit.AccountAuditLogs;
import org.killbill.billing.util.audit.AuditLog;
import org.killbill.billing.util.audit.ChangeType;
import org.killbill.billing.util.callcontext.TenantContext;
import org.killbill.billing.util.customfield.CustomField;
import org.killbill.billing.util.tag.Tag;
import org.killbill.billing.util.tag.TagDefinition;
import org.killbill.clock.Clock;
import org.osgi.service.log.LogService;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

public abstract class PluginApi {

    // See EntitlementService
    protected static final String ENTITLEMENT_SERVICE_NAME = "entitlement-service";
    // See DefaultSubscriptionBundleTimeline
    protected static final String BILLING_SERVICE_NAME = "billing-service";
    protected static final String ENTITLEMENT_BILLING_SERVICE_NAME = "entitlement+billing-service";

    // See convention in InternalCallContextFactory
    protected static final long INTERNAL_TENANT_RECORD_ID = 0L;

    protected static final Iterable<PluginProperty> PLUGIN_PROPERTIES = ImmutableList.<PluginProperty>of();

    protected final OSGIKillbillAPI killbillAPI;
    protected final OSGIConfigPropertiesService configProperties;
    protected final OSGIKillbillLogService logService;
    protected final Clock clock;

    protected PluginApi(final OSGIKillbillAPI killbillAPI, final OSGIConfigPropertiesService configProperties, final OSGIKillbillLogService logService, final Clock clock) {
        this.killbillAPI = killbillAPI;
        this.configProperties = configProperties;
        this.logService = logService;
        this.clock = clock;
    }

    //
    // TENANT
    //

    protected Long getTenantRecordId(final TenantContext context) throws OSGIServiceNotAvailable {
        if (context.getTenantId() == null) {
            return INTERNAL_TENANT_RECORD_ID;
        } else {
            final RecordIdApi recordIdUserApi = getRecordIdUserApi();
            return recordIdUserApi.getRecordId(context.getTenantId(), ObjectType.TENANT, context);
        }
    }

    //
    // ACCOUNT
    //

    protected Account getAccount(final UUID accountId, final TenantContext context) throws OSGIServiceNotAvailable {
        final AccountUserApi accountUserApi = getAccountUserApi();

        try {
            return accountUserApi.getAccountById(accountId, context);
        } catch (final AccountApiException e) {
            logService.log(LogService.LOG_WARNING, "Error retrieving account for id " + accountId, e);
            throw new OSGIServiceNotAvailable(e);
        }
    }

    protected AccountAuditLogs getAccountAuditLogs(final UUID accountId, final TenantContext context) throws OSGIServiceNotAvailable {
        final AuditUserApi auditUserApi = getAuditUserApi();
        return auditUserApi.getAccountAuditLogs(accountId, AuditLevel.MINIMAL, context);
    }

    protected AuditLog getAccountCreationAuditLog(final UUID accountId, final AccountAuditLogs accountAuditLogs) throws OSGIServiceNotAvailable {
        final List<AuditLog> auditLogsForAccount = accountAuditLogs.getAuditLogsForAccount();
        for (final AuditLog auditLog : auditLogsForAccount) {
            if (auditLog.getChangeType().equals(ChangeType.INSERT)) {
                return auditLog;
            }
        }

        logService.log(LogService.LOG_WARNING, "Unable to find Account creation audit log for id " + accountId);
        return null;
    }

    protected Long getAccountRecordId(final UUID accountId, final TenantContext context) throws OSGIServiceNotAvailable {
        final RecordIdApi recordIdUserApi = getRecordIdUserApi();
        return recordIdUserApi.getRecordId(accountId, ObjectType.ACCOUNT, context);
    }

    //
    // SUBSCRIPTION
    //

    protected List<SubscriptionBundle> getSubscriptionBundlesForAccount(final UUID accountId, final TenantContext context) throws OSGIServiceNotAvailable {
        final SubscriptionApi subscriptionApi = getSubscriptionApi();

        try {
            return subscriptionApi.getSubscriptionBundlesForAccountId(accountId, context);
        } catch (final SubscriptionApiException e) {
            logService.log(LogService.LOG_WARNING, "Error retrieving bundles for account id " + accountId, e);
            throw new OSGIServiceNotAvailable(e);
        }
    }

    protected SubscriptionBundle getLatestSubscriptionBundleForExternalKey(final String bundleExternalKey, final TenantContext context) throws OSGIServiceNotAvailable {
        final SubscriptionApi subscriptionApi = getSubscriptionApi();

        try {
            final List<SubscriptionBundle> bundles = subscriptionApi.getSubscriptionBundlesForExternalKey(bundleExternalKey, context);
            if (bundles.isEmpty()) {
                throw new OSGIServiceNotAvailable("Unable to retrieve latest bundle for bundle external key " + bundleExternalKey);
            }
            return bundles.get(bundles.size() - 1);
        } catch (final SubscriptionApiException e) {
            logService.log(LogService.LOG_WARNING, "Error retrieving bundles for bundle external key " + bundleExternalKey, e);
            throw new OSGIServiceNotAvailable(e);
        }
    }

    protected Long getBundleRecordId(final UUID bundleId, final TenantContext context) throws OSGIServiceNotAvailable {
        final RecordIdApi recordIdUserApi = getRecordIdUserApi();
        return recordIdUserApi.getRecordId(bundleId, ObjectType.BUNDLE, context);
    }

    protected AuditLog getBundleCreationAuditLog(final UUID bundleId, final AccountAuditLogs accountAuditLogs) throws OSGIServiceNotAvailable {
        final List<AuditLog> auditLogsForBundle = accountAuditLogs.getAuditLogsForBundle(bundleId);
        for (final AuditLog auditLog : auditLogsForBundle) {
            if (auditLog.getChangeType().equals(ChangeType.INSERT)) {
                return auditLog;
            }
        }

        logService.log(LogService.LOG_WARNING, "Unable to find Bundle creation audit log for id " + bundleId);
        return null;
    }

    protected AuditLog getSubscriptionEventCreationAuditLog(final UUID subscriptionEventId, final ObjectType objectType, final AccountAuditLogs accountAuditLogs) throws OSGIServiceNotAvailable {
        final List<AuditLog> auditLogsForSubscriptionEvent = accountAuditLogs.getAuditLogs(objectType).getAuditLogs(subscriptionEventId);
        for (final AuditLog auditLog : auditLogsForSubscriptionEvent) {
            if (auditLog.getChangeType().equals(ChangeType.INSERT)) {
                return auditLog;
            }
        }

        logService.log(LogService.LOG_WARNING, "Unable to find Subscription event creation audit log for id " + subscriptionEventId);
        return null;
    }

    protected Long getSubscriptionEventRecordId(final UUID subscriptionEventId, final ObjectType objectType, final TenantContext context) throws OSGIServiceNotAvailable {
        final RecordIdApi recordIdUserApi = getRecordIdUserApi();
        return recordIdUserApi.getRecordId(subscriptionEventId, objectType, context);
    }

    //
    // OVERDUE
    //

    protected Iterable<SubscriptionEvent> getBlockingHistory(final UUID accountId, final TenantContext context) throws OSGIServiceNotAvailable {
        final List<SubscriptionBundle> bundles = getSubscriptionBundlesForAccount(accountId, context);

        // Find all subscription events for that account
        final Iterable<SubscriptionEvent> subscriptionEvents = Iterables.<SubscriptionEvent>concat(Iterables.<SubscriptionBundle, List<SubscriptionEvent>>transform(bundles,
                                                                                                                                                                    new Function<SubscriptionBundle, List<SubscriptionEvent>>() {
                                                                                                                                                                        @Override
                                                                                                                                                                        public List<SubscriptionEvent> apply(final SubscriptionBundle bundle) {
                                                                                                                                                                            return bundle.getTimeline().getSubscriptionEvents();
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                   ));

        // Filter all service state changes
        return Iterables.<SubscriptionEvent>filter(subscriptionEvents,
                                                   new Predicate<SubscriptionEvent>() {
                                                       @Override
                                                       public boolean apply(final SubscriptionEvent event) {
                                                           return event.getSubscriptionEventType() != null &&
                                                                  // We want events coming from the blocking states table...
                                                                  ObjectType.BLOCKING_STATES.equals(event.getSubscriptionEventType().getObjectType()) &&
                                                                  // ...that are for any service but entitlement
                                                                  !ENTITLEMENT_SERVICE_NAME.equals(event.getServiceName());
                                                       }
                                                   }
                                                  );
    }

    //
    // BLOCKING STATES
    //

    protected AuditLog getBlockingStateCreationAuditLog(final UUID blockingStateId, final AccountAuditLogs accountAuditLogs) throws OSGIServiceNotAvailable {
        final List<AuditLog> auditLogsForBlockingState = accountAuditLogs.getAuditLogsForBlockingState(blockingStateId);
        for (final AuditLog auditLog : auditLogsForBlockingState) {
            if (auditLog.getChangeType().equals(ChangeType.INSERT)) {
                return auditLog;
            }
        }

        logService.log(LogService.LOG_WARNING, "Unable to find Blocking state creation audit log for id " + blockingStateId);
        return null;
    }

    protected Long getBlockingStateRecordId(final UUID blockingStateId, final TenantContext context) throws OSGIServiceNotAvailable {
        final RecordIdApi recordIdUserApi = getRecordIdUserApi();
        return recordIdUserApi.getRecordId(blockingStateId, ObjectType.BLOCKING_STATES, context);
    }

    //
    // INVOICE
    //

    protected AuditLog getInvoiceCreationAuditLog(final UUID invoiceId, final AccountAuditLogs accountAuditLogs) throws OSGIServiceNotAvailable {
        final List<AuditLog> auditLogsForInvoice = accountAuditLogs.getAuditLogsForInvoice(invoiceId);
        for (final AuditLog auditLog : auditLogsForInvoice) {
            if (auditLog.getChangeType().equals(ChangeType.INSERT)) {
                return auditLog;
            }
        }

        logService.log(LogService.LOG_WARNING, "Unable to find Invoice creation audit log for id " + invoiceId);
        return null;
    }

    protected Long getInvoiceRecordId(final UUID invoiceId, final TenantContext context) throws OSGIServiceNotAvailable {
        final RecordIdApi recordIdUserApi = getRecordIdUserApi();
        return recordIdUserApi.getRecordId(invoiceId, ObjectType.INVOICE, context);
    }

    protected AuditLog getInvoiceItemCreationAuditLog(final UUID invoiceItemId, final AccountAuditLogs accountAuditLogs) throws OSGIServiceNotAvailable {
        final List<AuditLog> auditLogsForInvoiceItem = accountAuditLogs.getAuditLogsForInvoiceItem(invoiceItemId);
        for (final AuditLog auditLog : auditLogsForInvoiceItem) {
            if (auditLog.getChangeType().equals(ChangeType.INSERT)) {
                return auditLog;
            }
        }

        logService.log(LogService.LOG_WARNING, "Unable to find Invoice item creation audit log for id " + invoiceItemId);
        return null;
    }

    protected Long getInvoiceItemRecordId(final UUID invoiceItemId, final TenantContext context) throws OSGIServiceNotAvailable {
        final RecordIdApi recordIdUserApi = getRecordIdUserApi();
        return recordIdUserApi.getRecordId(invoiceItemId, ObjectType.INVOICE_ITEM, context);
    }

    protected Collection<Invoice> getInvoicesByAccountId(final UUID accountId, final TenantContext context) throws OSGIServiceNotAvailable {
        final InvoiceUserApi invoiceUserApi = getInvoiceUserApi();
        return invoiceUserApi.getInvoicesByAccount(accountId, false, false, context);
    }

    protected BigDecimal getAccountBalance(final UUID accountId, final TenantContext context) throws OSGIServiceNotAvailable {
        final InvoiceUserApi invoiceUserApi = getInvoiceUserApi();
        return invoiceUserApi.getAccountBalance(accountId, context);
    }

    protected Plan getPlanFromInvoiceItem(final InvoiceItem invoiceItem, final TenantContext context) throws OSGIServiceNotAvailable {
        try {
            final Catalog catalog = getCatalog(context);
            return catalog.findPlan(invoiceItem.getPlanName(), invoiceItem.getStartDate().toDateTimeAtStartOfDay());
        } catch (final CatalogApiException e) {
            logService.log(LogService.LOG_INFO, "Unable to retrieve plan for invoice item " + invoiceItem.getId(), e);
            return null;
        }
    }

    protected PlanPhase getPlanPhaseFromInvoiceItem(final InvoiceItem invoiceItem, final LocalDate subscriptionStartDate, final TenantContext context) throws OSGIServiceNotAvailable {
        try {
            final Catalog catalog = getCatalog(context);
            // TODO - Inaccurate timing
            return catalog.findPhase(invoiceItem.getPhaseName(), invoiceItem.getStartDate().toDateTimeAtStartOfDay(), subscriptionStartDate.toDateTimeAtStartOfDay());
        } catch (final CatalogApiException e) {
            logService.log(LogService.LOG_INFO, "Unable to retrieve phase for invoice item " + invoiceItem.getId(), e);
            return null;
        }
    }

    //
    // CATALOG
    //

    protected Catalog getCatalog(final TenantContext context) throws OSGIServiceNotAvailable {
        final CatalogUserApi catalogUserApi = getCatalogUserApi();
        try {
            return catalogUserApi.getCatalog(null, null, context);
        } catch (final CatalogApiException e) {
            logService.log(LogService.LOG_INFO, "Unable to retrieve catalog for tenant " + context.getTenantId(), e);
            return null;
        }
    }

    //
    // INVOICE PAYMENT
    //

    protected Map<UUID, List<InvoicePayment>> getAccountInvoicePayments(final Iterable<Payment> payments, final TenantContext context) throws OSGIServiceNotAvailable {
        final InvoicePaymentApi invoicePaymentApi = getInvoicePaymentUserApi();

        final Map<UUID, List<InvoicePayment>> allInvoicePaymentsByPaymentId = new HashMap<UUID, List<InvoicePayment>>();
        for (final Payment payment : payments) {
            // Retrieve all invoice payment types (including refunds and chargebacks) for that payment
            allInvoicePaymentsByPaymentId.put(payment.getId(), invoicePaymentApi.getInvoicePayments(payment.getId(), context));
        }

        return allInvoicePaymentsByPaymentId;
    }

    protected AuditLog getInvoicePaymentCreationAuditLog(final UUID invoicePaymentId, final AccountAuditLogs accountAuditLogs) throws OSGIServiceNotAvailable {
        final List<AuditLog> auditLogsForInvoicePayment = accountAuditLogs.getAuditLogsForInvoicePayment(invoicePaymentId);
        for (final AuditLog auditLog : auditLogsForInvoicePayment) {
            if (auditLog.getChangeType().equals(ChangeType.INSERT)) {
                return auditLog;
            }
        }

        logService.log(LogService.LOG_WARNING, "Unable to find Invoice payment creation audit log for id " + invoicePaymentId);
        return null;
    }

    protected Long getInvoicePaymentRecordId(final UUID invoicePaymentId, final TenantContext context) throws OSGIServiceNotAvailable {
        final RecordIdApi recordIdUserApi = getRecordIdUserApi();
        return recordIdUserApi.getRecordId(invoicePaymentId, ObjectType.INVOICE_PAYMENT, context);
    }

    //
    // PAYMENT
    //

    protected Collection<Payment> getPaymentsWithPluginInfoByAccountId(final UUID accountId, final TenantContext context) throws OSGIServiceNotAvailable {
        final PaymentApi paymentApi = getPaymentUserApi();
        try {
            return paymentApi.getAccountPayments(accountId, true, false, PLUGIN_PROPERTIES, context);
        } catch (final PaymentApiException e) {
            logService.log(LogService.LOG_WARNING, "Error retrieving payments for account id " + accountId, e);
            throw new OSGIServiceNotAvailable(e);
        }
    }

    protected List<PaymentMethod> getPaymentMethodsForAccount(final UUID accountId, final TenantContext context) throws OSGIServiceNotAvailable {
        final PaymentApi paymentApi = getPaymentUserApi();

        try {
            // Try to get all payment methods, with plugin information
            // TODO this will not return deleted payment methods
            return paymentApi.getAccountPaymentMethods(accountId, false, true, PLUGIN_PROPERTIES, context);
        } catch (final PaymentApiException e) {
            logService.log(LogService.LOG_INFO, "Error retrieving payment methods for accountId " + accountId + ": " + e.getMessage());
            throw new OSGIServiceNotAvailable(e);
        }
    }

    protected PaymentMethod getPaymentMethod(final UUID paymentMethodId, final TenantContext context) throws OSGIServiceNotAvailable {
        final PaymentApi paymentApi = getPaymentUserApi();

        try {
            return paymentApi.getPaymentMethodById(paymentMethodId, true, false, PLUGIN_PROPERTIES, context);
        } catch (final PaymentApiException e) {
            logService.log(LogService.LOG_INFO, "Error retrieving payment method for paymentMethodId " + paymentMethodId + ": " + e.getMessage());
            throw new OSGIServiceNotAvailable(e);
        }
    }

    protected AuditLog getPaymentCreationAuditLog(final UUID paymentId, final AccountAuditLogs accountAuditLogs) throws OSGIServiceNotAvailable {
        final List<AuditLog> auditLogsForPayment = accountAuditLogs.getAuditLogsForPayment(paymentId);
        for (final AuditLog auditLog : auditLogsForPayment) {
            if (auditLog.getChangeType().equals(ChangeType.INSERT)) {
                return auditLog;
            }
        }

        logService.log(LogService.LOG_WARNING, "Unable to find payment creation audit log for id " + paymentId);
        return null;
    }

    protected PaymentTransaction getPaymentTransaction(final UUID kbPaymentId, final UUID kbTransactionId, final TenantContext context) throws OSGIServiceNotAvailable {
        final Payment payment;
        try {
            payment = getPaymentUserApi().getPayment(kbPaymentId, false, false, PLUGIN_PROPERTIES, context);
        } catch (final PaymentApiException e) {
            logService.log(LogService.LOG_INFO, "Error retrieving payment for paymentId " + kbPaymentId + ": " + e.getMessage());
            throw new OSGIServiceNotAvailable(e);
        }

        return getPaymentTransaction(kbTransactionId, payment);
    }

    protected PaymentTransaction getPaymentTransaction(final UUID kbTransactionId, final Payment payment) throws OSGIServiceNotAvailable {
        return Iterables.<PaymentTransaction>find(payment.getTransactions(),
                                                  new Predicate<PaymentTransaction>() {
                                                      @Override
                                                      public boolean apply(final PaymentTransaction input) {
                                                          return kbTransactionId.equals(input.getId());
                                                      }
                                                  });
    }

    protected Long getPaymentRecordId(final UUID paymentId, final TenantContext context) throws OSGIServiceNotAvailable {
        final RecordIdApi recordIdUserApi = getRecordIdUserApi();
        return recordIdUserApi.getRecordId(paymentId, ObjectType.PAYMENT, context);
    }

    //
    // FIELD
    //

    protected Collection<CustomField> getFieldsForAccount(final UUID accountId, final TenantContext context) throws OSGIServiceNotAvailable {
        final CustomFieldUserApi tagUserApi = getCustomFieldUserApi();
        return tagUserApi.getCustomFieldsForAccount(accountId, context);
    }

    protected AuditLog getFieldCreationAuditLog(final UUID fieldId, final AccountAuditLogs accountAuditLogs) throws OSGIServiceNotAvailable {
        final List<AuditLog> auditLogsForTag = accountAuditLogs.getAuditLogsForCustomField(fieldId);
        for (final AuditLog auditLog : auditLogsForTag) {
            if (auditLog.getChangeType().equals(ChangeType.INSERT)) {
                return auditLog;
            }
        }

        logService.log(LogService.LOG_WARNING, "Unable to find Field creation audit log for id " + fieldId);
        return null;
    }

    protected Long getFieldRecordId(final UUID fieldId, final TenantContext context) throws OSGIServiceNotAvailable {
        final RecordIdApi recordIdUserApi = getRecordIdUserApi();
        return recordIdUserApi.getRecordId(fieldId, ObjectType.CUSTOM_FIELD, context);
    }

    //
    // TAG
    //

    protected Collection<Tag> getTagsForAccount(final UUID accountId, final TenantContext context) throws OSGIServiceNotAvailable {
        final TagUserApi tagUserApi = getTagUserApi();
        return tagUserApi.getTagsForAccount(accountId, false, context);
    }

    protected List<TagDefinition> getTagDefinitions(final TenantContext context) throws OSGIServiceNotAvailable {
        final TagUserApi tagUserApi = getTagUserApi();
        return tagUserApi.getTagDefinitions(context);
    }

    protected AuditLog getTagCreationAuditLog(final UUID tagId, final AccountAuditLogs accountAuditLogs) throws OSGIServiceNotAvailable {
        final List<AuditLog> auditLogsForTag = accountAuditLogs.getAuditLogsForTag(tagId);
        for (final AuditLog auditLog : auditLogsForTag) {
            if (auditLog.getChangeType().equals(ChangeType.INSERT)) {
                return auditLog;
            }
        }

        logService.log(LogService.LOG_WARNING, "Unable to find Tag creation audit log for id " + tagId);
        return null;
    }

    protected Long getTagRecordId(final UUID tagId, final TenantContext context) throws OSGIServiceNotAvailable {
        final RecordIdApi recordIdUserApi = getRecordIdUserApi();
        return recordIdUserApi.getRecordId(tagId, ObjectType.TAG, context);
    }

    //
    // APIs
    //

    protected AccountUserApi getAccountUserApi() throws OSGIServiceNotAvailable {
        final AccountUserApi accountUserApi = killbillAPI.getAccountUserApi();
        if (accountUserApi == null) {
            throw new OSGIServiceNotAvailable("Error retrieving accountUserApi");
        }
        return accountUserApi;
    }

    protected SubscriptionApi getSubscriptionApi() throws OSGIServiceNotAvailable {
        final SubscriptionApi subscriptionApi = killbillAPI.getSubscriptionApi();
        if (subscriptionApi == null) {
            throw new OSGIServiceNotAvailable("Error retrieving subscriptionApi");
        }
        return subscriptionApi;
    }

    protected InvoiceUserApi getInvoiceUserApi() throws OSGIServiceNotAvailable {
        final InvoiceUserApi invoiceUserApi = killbillAPI.getInvoiceUserApi();
        if (invoiceUserApi == null) {
            throw new OSGIServiceNotAvailable("Error retrieving invoiceUserApi");
        }
        return invoiceUserApi;
    }

    protected CatalogUserApi getCatalogUserApi() throws OSGIServiceNotAvailable {
        final CatalogUserApi catalogUserApi = killbillAPI.getCatalogUserApi();
        if (catalogUserApi == null) {
            throw new OSGIServiceNotAvailable("Error retrieving catalogUserApi");
        }
        return catalogUserApi;
    }

    protected PaymentApi getPaymentUserApi() throws OSGIServiceNotAvailable {
        final PaymentApi paymentApi = killbillAPI.getPaymentApi();
        if (paymentApi == null) {
            throw new OSGIServiceNotAvailable("Error retrieving paymentApi");
        }
        return paymentApi;
    }

    protected InvoicePaymentApi getInvoicePaymentUserApi() throws OSGIServiceNotAvailable {
        final InvoicePaymentApi invoicePaymentApi = killbillAPI.getInvoicePaymentApi();
        if (invoicePaymentApi == null) {
            throw new OSGIServiceNotAvailable("Error retrieving invoicePaymentApi");
        }
        return invoicePaymentApi;
    }

    protected CustomFieldUserApi getCustomFieldUserApi() throws OSGIServiceNotAvailable {
        final CustomFieldUserApi fieldUserApi = killbillAPI.getCustomFieldUserApi();
        if (fieldUserApi == null) {
            throw new OSGIServiceNotAvailable("Error retrieving fieldUserApi");
        }
        return fieldUserApi;
    }

    protected TagUserApi getTagUserApi() throws OSGIServiceNotAvailable {
        final TagUserApi tagUserApi = killbillAPI.getTagUserApi();
        if (tagUserApi == null) {
            throw new OSGIServiceNotAvailable("Error retrieving tagUserApi");
        }
        return tagUserApi;
    }

    protected RecordIdApi getRecordIdUserApi() throws OSGIServiceNotAvailable {
        final RecordIdApi recordIdApi = killbillAPI.getRecordIdApi();
        if (recordIdApi == null) {
            throw new OSGIServiceNotAvailable("Error retrieving recordIdApi");
        }
        return recordIdApi;
    }

    protected AuditUserApi getAuditUserApi() throws OSGIServiceNotAvailable {
        final AuditUserApi auditUserApi = killbillAPI.getAuditUserApi();
        if (auditUserApi == null) {
            throw new OSGIServiceNotAvailable("Error retrieving auditUserApi");
        }
        return auditUserApi;
    }
}
