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

package org.killbill.billing.account.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.killbill.billing.account.api.Account;
import org.killbill.billing.account.api.AccountApiException;
import org.killbill.billing.account.api.AccountData;
import org.killbill.billing.account.api.AccountEmail;
import org.killbill.billing.account.api.AccountUserApi;
import org.killbill.billing.util.api.AuditLevel;
import org.killbill.billing.util.audit.AuditLogWithHistory;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;
import org.killbill.billing.util.entity.Pagination;

@JsonDeserialize( builder = AccountUserApiImp.Builder.class )
public class AccountUserApiImp implements AccountUserApi {


    public AccountUserApiImp(final AccountUserApiImp that) {
    }
    protected AccountUserApiImp(final AccountUserApiImp.Builder<?> builder) {
    }
    protected AccountUserApiImp() { }
    @Override
    public Account getAccountById(final UUID accountId, final TenantContext context) {
        throw new UnsupportedOperationException("getAccountById(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void updateAccount(final UUID accountId, final AccountData accountData, final CallContext context) {
        throw new UnsupportedOperationException("updateAccount(java.util.UUID, org.killbill.billing.account.api.AccountData, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<AccountEmail> getEmails(final UUID accountId, final TenantContext context) {
        throw new UnsupportedOperationException("getEmails(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<Account> getChildrenAccounts(final UUID parentAccountId, final TenantContext context) {
        throw new UnsupportedOperationException("getChildrenAccounts(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<AuditLogWithHistory> getEmailAuditLogsWithHistoryForId(final UUID accountEmailId, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getEmailAuditLogsWithHistoryForId(java.util.UUID, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void addEmail(final UUID accountId, final AccountEmail email, final CallContext context) {
        throw new UnsupportedOperationException("addEmail(java.util.UUID, org.killbill.billing.account.api.AccountEmail, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public void updateAccount(final String key, final AccountData accountData, final CallContext context) {
        throw new UnsupportedOperationException("updateAccount(java.lang.String, org.killbill.billing.account.api.AccountData, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Account getAccountByKey(final String key, final TenantContext context) {
        throw new UnsupportedOperationException("getAccountByKey(java.lang.String, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public UUID getIdFromKey(final String externalKey, final TenantContext context) {
        throw new UnsupportedOperationException("getIdFromKey(java.lang.String, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void removeEmail(final UUID accountId, final AccountEmail email, final CallContext context) {
        throw new UnsupportedOperationException("removeEmail(java.util.UUID, org.killbill.billing.account.api.AccountEmail, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<AuditLogWithHistory> getAuditLogsWithHistoryForId(final UUID accountId, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getAuditLogsWithHistoryForId(java.util.UUID, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Pagination<Account> searchAccounts(final String searchKey, final Long offset, final Long limit, final TenantContext context) {
        throw new UnsupportedOperationException("searchAccounts(java.lang.String, java.lang.Long, java.lang.Long, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Pagination<Account> getAccounts(final Long offset, final Long limit, final TenantContext context) {
        throw new UnsupportedOperationException("getAccounts(java.lang.Long, java.lang.Long, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void updateAccount(final Account account, final CallContext context) {
        throw new UnsupportedOperationException("updateAccount(org.killbill.billing.account.api.Account, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Account createAccount(final AccountData data, final CallContext context) {
        throw new UnsupportedOperationException("createAccount(org.killbill.billing.account.api.AccountData, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
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
    public static class Builder<T extends AccountUserApiImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final AccountUserApi that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public AccountUserApiImp build() {
            return new AccountUserApiImp(this.validate());
        }
    }
}
