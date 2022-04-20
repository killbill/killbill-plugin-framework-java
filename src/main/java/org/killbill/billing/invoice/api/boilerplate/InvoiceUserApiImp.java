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

package org.killbill.billing.invoice.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.LocalDate;
import org.killbill.billing.account.api.AccountApiException;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.invoice.api.DryRunArguments;
import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.invoice.api.InvoiceApiException;
import org.killbill.billing.invoice.api.InvoiceItem;
import org.killbill.billing.invoice.api.InvoiceUserApi;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.util.api.AuditLevel;
import org.killbill.billing.util.api.TagApiException;
import org.killbill.billing.util.audit.AuditLogWithHistory;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;
import org.killbill.billing.util.entity.Pagination;

@JsonDeserialize( builder = InvoiceUserApiImp.Builder.class )
public class InvoiceUserApiImp implements InvoiceUserApi {

    private static final long serialVersionUID = 0x43B28676FD363526L;


    public InvoiceUserApiImp(final InvoiceUserApiImp that) {
    }
    protected InvoiceUserApiImp(final InvoiceUserApiImp.Builder<?> builder) {
    }
    protected InvoiceUserApiImp() { }
    @Override
    public List<InvoiceItem> insertExternalCharges(final UUID accountId, final LocalDate effectiveDate, final Iterable<InvoiceItem> charges, final boolean autoCommit, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("insertExternalCharges(java.util.UUID, org.joda.time.LocalDate, java.lang.Iterable<org.killbill.billing.invoice.api.InvoiceItem>, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public void transferChildCreditToParent(final UUID childAccountId, final CallContext context) {
        throw new UnsupportedOperationException("transferChildCreditToParent(java.util.UUID, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public String getInvoiceAsHTML(final UUID invoiceId, final TenantContext context) {
        throw new UnsupportedOperationException("getInvoiceAsHTML(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Invoice getInvoiceByPayment(final UUID paymentId, final TenantContext context) {
        throw new UnsupportedOperationException("getInvoiceByPayment(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Pagination<Invoice> searchInvoices(final String searchKey, final Long offset, final Long limit, final TenantContext context) {
        throw new UnsupportedOperationException("searchInvoices(java.lang.String, java.lang.Long, java.lang.Long, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<Invoice> getInvoicesByAccount(final UUID accountId, final boolean includesMigrated, final boolean includeVoidedInvoices, final TenantContext context) {
        throw new UnsupportedOperationException("getInvoicesByAccount(java.util.UUID, boolean, boolean, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public UUID createMigrationInvoice(final UUID accountId, final LocalDate invoiceDate, final Iterable<InvoiceItem> items, final CallContext context) {
        throw new UnsupportedOperationException("createMigrationInvoice(java.util.UUID, org.joda.time.LocalDate, java.lang.Iterable<org.killbill.billing.invoice.api.InvoiceItem>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public BigDecimal getAccountCBA(final UUID accountId, final TenantContext context) {
        throw new UnsupportedOperationException("getAccountCBA(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<InvoiceItem> getInvoiceItemsByParentInvoice(final UUID parentInvoiceId, final TenantContext context) {
        throw new UnsupportedOperationException("getInvoiceItemsByParentInvoice(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Invoice triggerDryRunInvoiceGeneration(final UUID accountId, final LocalDate targetDate, final DryRunArguments dryRunArguments, final CallContext context) {
        throw new UnsupportedOperationException("triggerDryRunInvoiceGeneration(java.util.UUID, org.joda.time.LocalDate, org.killbill.billing.invoice.api.DryRunArguments, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Invoice triggerInvoiceGeneration(final UUID accountId, final LocalDate targetDate, final CallContext context) {
        throw new UnsupportedOperationException("triggerInvoiceGeneration(java.util.UUID, org.joda.time.LocalDate, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<AuditLogWithHistory> getInvoicePaymentAuditLogsWithHistoryForId(final UUID invoicePaymentId, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getInvoicePaymentAuditLogsWithHistoryForId(java.util.UUID, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void deleteCBA(final UUID accountId, final UUID invoiceId, final UUID invoiceItemId, final CallContext context) {
        throw new UnsupportedOperationException("deleteCBA(java.util.UUID, java.util.UUID, java.util.UUID, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Invoice getInvoiceByInvoiceItem(final UUID invoiceItemId, final TenantContext context) {
        throw new UnsupportedOperationException("getInvoiceByInvoiceItem(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void consumeExistingCBAOnAccountWithUnpaidInvoices(final UUID accountId, final CallContext context) {
        throw new UnsupportedOperationException("consumeExistingCBAOnAccountWithUnpaidInvoices(java.util.UUID, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public InvoiceItem insertInvoiceItemAdjustment(final UUID accountId, final UUID invoiceId, final UUID invoiceItemId, final LocalDate effectiveDate, final BigDecimal amount, final Currency currency, final String description, final String itemDetails, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("insertInvoiceItemAdjustment(java.util.UUID, java.util.UUID, java.util.UUID, org.joda.time.LocalDate, java.math.BigDecimal, org.killbill.billing.catalog.api.Currency, java.lang.String, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public InvoiceItem getExternalChargeById(final UUID externalChargeId, final TenantContext context) {
        throw new UnsupportedOperationException("getExternalChargeById(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Invoice getInvoiceByNumber(final Integer number, final TenantContext context) {
        throw new UnsupportedOperationException("getInvoiceByNumber(java.lang.Integer, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Pagination<Invoice> getInvoices(final Long offset, final Long limit, final TenantContext context) {
        throw new UnsupportedOperationException("getInvoices(java.lang.Long, java.lang.Long, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<InvoiceItem> insertCredits(final UUID accountId, final LocalDate effectiveDate, final Iterable<InvoiceItem> creditItems, final boolean autoCommit, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("insertCredits(java.util.UUID, org.joda.time.LocalDate, java.lang.Iterable<org.killbill.billing.invoice.api.InvoiceItem>, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public InvoiceItem getCreditById(final UUID creditId, final TenantContext context) {
        throw new UnsupportedOperationException("getCreditById(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public InvoiceItem insertInvoiceItemAdjustment(final UUID accountId, final UUID invoiceId, final UUID invoiceItemId, final LocalDate effectiveDate, final String description, final String itemDetails, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("insertInvoiceItemAdjustment(java.util.UUID, java.util.UUID, java.util.UUID, org.joda.time.LocalDate, java.lang.String, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Invoice getInvoice(final UUID invoiceId, final TenantContext context) {
        throw new UnsupportedOperationException("getInvoice(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void voidInvoice(final UUID invoiceId, final CallContext context) {
        throw new UnsupportedOperationException("voidInvoice(java.util.UUID, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<AuditLogWithHistory> getInvoiceAuditLogsWithHistoryForId(final UUID invoiceId, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getInvoiceAuditLogsWithHistoryForId(java.util.UUID, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<Invoice> getInvoicesByAccount(final UUID accountId, final LocalDate fromDate, final LocalDate upToDate, final boolean includeVoidedInvoices, final TenantContext context) {
        throw new UnsupportedOperationException("getInvoicesByAccount(java.util.UUID, org.joda.time.LocalDate, org.joda.time.LocalDate, boolean, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void tagInvoiceAsWrittenOff(final UUID invoiceId, final CallContext context) {
        throw new UnsupportedOperationException("tagInvoiceAsWrittenOff(java.util.UUID, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<InvoiceItem> insertTaxItems(final UUID accountId, final LocalDate effectiveDate, final Iterable<InvoiceItem> taxes, final boolean autoCommit, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("insertTaxItems(java.util.UUID, org.joda.time.LocalDate, java.lang.Iterable<org.killbill.billing.invoice.api.InvoiceItem>, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<AuditLogWithHistory> getInvoiceItemAuditLogsWithHistoryForId(final UUID invoiceItemId, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getInvoiceItemAuditLogsWithHistoryForId(java.util.UUID, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void tagInvoiceAsNotWrittenOff(final UUID invoiceId, final CallContext context) {
        throw new UnsupportedOperationException("tagInvoiceAsNotWrittenOff(java.util.UUID, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public BigDecimal getAccountBalance(final UUID accountId, final TenantContext context) {
        throw new UnsupportedOperationException("getAccountBalance(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void commitInvoice(final UUID invoiceId, final CallContext context) {
        throw new UnsupportedOperationException("commitInvoice(java.util.UUID, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Collection<Invoice> getUnpaidInvoicesByAccountId(final UUID accountId, final LocalDate fromDate, final LocalDate upToDate, final TenantContext context) {
        throw new UnsupportedOperationException("getUnpaidInvoicesByAccountId(java.util.UUID, org.joda.time.LocalDate, org.joda.time.LocalDate, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
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
    public static class Builder<T extends InvoiceUserApiImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final InvoiceUserApi that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public InvoiceUserApiImp build() {
            return new InvoiceUserApiImp(this.validate());
        }
    }
}
