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

package org.killbill.billing.util.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.killbill.billing.ObjectType;
import org.killbill.billing.util.api.AuditLevel;
import org.killbill.billing.util.api.AuditUserApi;
import org.killbill.billing.util.audit.AccountAuditLogs;
import org.killbill.billing.util.audit.AccountAuditLogsForObjectType;
import org.killbill.billing.util.audit.AuditLog;
import org.killbill.billing.util.callcontext.TenantContext;

@JsonDeserialize( builder = AuditUserApiImp.Builder.class )
public class AuditUserApiImp implements AuditUserApi {


    public AuditUserApiImp(final AuditUserApiImp that) {
    }
    protected AuditUserApiImp(final AuditUserApiImp.Builder<?> builder) {
    }
    protected AuditUserApiImp() { }
    @Override
    public AccountAuditLogs getAccountAuditLogs(final UUID accountId, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getAccountAuditLogs(java.util.UUID, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public AccountAuditLogsForObjectType getAccountAuditLogs(final UUID accountId, final ObjectType objectType, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getAccountAuditLogs(java.util.UUID, org.killbill.billing.ObjectType, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<AuditLog> getAuditLogs(final UUID objectId, final ObjectType objectType, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getAuditLogs(java.util.UUID, org.killbill.billing.ObjectType, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
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
    public static class Builder<T extends AuditUserApiImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final AuditUserApi that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public AuditUserApiImp build() {
            return new AuditUserApiImp(this.validate());
        }
    }
}
