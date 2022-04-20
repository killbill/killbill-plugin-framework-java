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

package org.killbill.billing.util.audit.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.killbill.billing.ObjectType;
import org.killbill.billing.util.audit.AccountAuditLogs;
import org.killbill.billing.util.audit.AccountAuditLogsForObjectType;
import org.killbill.billing.util.audit.AuditLog;

@JsonDeserialize( builder = AccountAuditLogsImp.Builder.class )
public class AccountAuditLogsImp implements AccountAuditLogs {

    private static final long serialVersionUID = 0xFBF3458749273B1CL;

    protected List<AuditLog> auditLogs;
    protected List<AuditLog> auditLogsForAccount;

    public AccountAuditLogsImp(final AccountAuditLogsImp that) {
        this.auditLogs = that.auditLogs;
        this.auditLogsForAccount = that.auditLogsForAccount;
    }
    protected AccountAuditLogsImp(final AccountAuditLogsImp.Builder<?> builder) {
        this.auditLogs = builder.auditLogs;
        this.auditLogsForAccount = builder.auditLogsForAccount;
    }
    protected AccountAuditLogsImp() { }
    @Override
    public List<AuditLog> getAuditLogs() {
        return this.auditLogs;
    }
    @Override
    public List<AuditLog> getAuditLogsForAccount() {
        return this.auditLogsForAccount;
    }
    @Override
    public List<AuditLog> getAuditLogsForPaymentMethod(final UUID paymentMethodId) {
        throw new UnsupportedOperationException("getAuditLogsForPaymentMethod(java.util.UUID) must be implemented.");
    }
    @Override
    public List<AuditLog> getAuditLogsForSubscriptionEvent(final UUID subscriptionEventId) {
        throw new UnsupportedOperationException("getAuditLogsForSubscriptionEvent(java.util.UUID) must be implemented.");
    }
    @Override
    public List<AuditLog> getAuditLogsForBlockingState(final UUID blockingStateId) {
        throw new UnsupportedOperationException("getAuditLogsForBlockingState(java.util.UUID) must be implemented.");
    }
    @Override
    public List<AuditLog> getAuditLogsForTag(final UUID tagId) {
        throw new UnsupportedOperationException("getAuditLogsForTag(java.util.UUID) must be implemented.");
    }
    @Override
    public List<AuditLog> getAuditLogsForSubscription(final UUID subscriptionId) {
        throw new UnsupportedOperationException("getAuditLogsForSubscription(java.util.UUID) must be implemented.");
    }
    @Override
    public List<AuditLog> getAuditLogsForCustomField(final UUID customFieldId) {
        throw new UnsupportedOperationException("getAuditLogsForCustomField(java.util.UUID) must be implemented.");
    }
    @Override
    public AccountAuditLogsForObjectType getAuditLogs(final ObjectType objectType) {
        throw new UnsupportedOperationException("getAuditLogs(org.killbill.billing.ObjectType) must be implemented.");
    }
    @Override
    public List<AuditLog> getAuditLogsForInvoiceItem(final UUID invoiceItemId) {
        throw new UnsupportedOperationException("getAuditLogsForInvoiceItem(java.util.UUID) must be implemented.");
    }
    @Override
    public List<AuditLog> getAuditLogsForInvoicePayment(final UUID invoicePaymentId) {
        throw new UnsupportedOperationException("getAuditLogsForInvoicePayment(java.util.UUID) must be implemented.");
    }
    @Override
    public List<AuditLog> getAuditLogsForPayment(final UUID paymentId) {
        throw new UnsupportedOperationException("getAuditLogsForPayment(java.util.UUID) must be implemented.");
    }
    @Override
    public List<AuditLog> getAuditLogsForInvoice(final UUID invoiceId) {
        throw new UnsupportedOperationException("getAuditLogsForInvoice(java.util.UUID) must be implemented.");
    }
    @Override
    public List<AuditLog> getAuditLogsForBundle(final UUID bundleId) {
        throw new UnsupportedOperationException("getAuditLogsForBundle(java.util.UUID) must be implemented.");
    }
    @Override
    public List<AuditLog> getAuditLogsForPaymentAttempt(final UUID paymentAttemptId) {
        throw new UnsupportedOperationException("getAuditLogsForPaymentAttempt(java.util.UUID) must be implemented.");
    }
    @Override
    public List<AuditLog> getAuditLogsForPaymentTransaction(final UUID paymentTransactionId) {
        throw new UnsupportedOperationException("getAuditLogsForPaymentTransaction(java.util.UUID) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final AccountAuditLogsImp that = (AccountAuditLogsImp) o;
        if( !Objects.equals(this.auditLogs, that.auditLogs) ) {
            return false;
        }
        if( !Objects.equals(this.auditLogsForAccount, that.auditLogsForAccount) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.auditLogs);
        result = ( 31 * result ) + Objects.hashCode(this.auditLogsForAccount);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("auditLogs=").append(this.auditLogs);
        sb.append(", ");
        sb.append("auditLogsForAccount=").append(this.auditLogsForAccount);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends AccountAuditLogsImp.Builder<T>> {

        protected List<AuditLog> auditLogs;
        protected List<AuditLog> auditLogsForAccount;

        public Builder() { }
        public Builder(final Builder that) {
            this.auditLogs = that.auditLogs;
            this.auditLogsForAccount = that.auditLogsForAccount;
        }
        public T withAuditLogs(final List<AuditLog> auditLogs) {
            this.auditLogs = auditLogs;
            return (T) this;
        }
        public T withAuditLogsForAccount(final List<AuditLog> auditLogsForAccount) {
            this.auditLogsForAccount = auditLogsForAccount;
            return (T) this;
        }
        public T source(final AccountAuditLogs that) {
            this.auditLogs = that.getAuditLogs();
            this.auditLogsForAccount = that.getAuditLogsForAccount();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public AccountAuditLogsImp build() {
            return new AccountAuditLogsImp(this.validate());
        }
    }
}
