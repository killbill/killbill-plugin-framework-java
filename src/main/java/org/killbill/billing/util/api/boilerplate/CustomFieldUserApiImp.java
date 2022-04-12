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
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.killbill.billing.ObjectType;
import org.killbill.billing.util.api.AuditLevel;
import org.killbill.billing.util.api.CustomFieldApiException;
import org.killbill.billing.util.api.CustomFieldUserApi;
import org.killbill.billing.util.audit.AuditLogWithHistory;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;
import org.killbill.billing.util.customfield.CustomField;
import org.killbill.billing.util.entity.Pagination;

@JsonDeserialize( builder = CustomFieldUserApiImp.Builder.class )
public class CustomFieldUserApiImp implements CustomFieldUserApi, Serializable {

    private static final long serialVersionUID = 0xBDAF40CD5C888F3AL;


    public CustomFieldUserApiImp(final CustomFieldUserApiImp that) {
    }
    protected CustomFieldUserApiImp(final CustomFieldUserApiImp.Builder<?> builder) {
    }
    protected CustomFieldUserApiImp() { }
    @Override
    public void addCustomFields(final List<CustomField> fields, final CallContext context) {
        throw new UnsupportedOperationException("addCustomFields(java.util.List<org.killbill.billing.util.customfield.CustomField>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<CustomField> getCustomFieldsForAccount(final UUID accountId, final TenantContext context) {
        throw new UnsupportedOperationException("getCustomFieldsForAccount(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<AuditLogWithHistory> getCustomFieldAuditLogsWithHistoryForId(final UUID customFieldId, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getCustomFieldAuditLogsWithHistoryForId(java.util.UUID, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void removeCustomFields(final List<CustomField> fields, final CallContext context) {
        throw new UnsupportedOperationException("removeCustomFields(java.util.List<org.killbill.billing.util.customfield.CustomField>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Pagination<CustomField> searchCustomFields(final String fieldName, final String fieldValue, final ObjectType objectType, final Long offset, final Long limit, final TenantContext context) {
        throw new UnsupportedOperationException("searchCustomFields(java.lang.String, java.lang.String, org.killbill.billing.ObjectType, java.lang.Long, java.lang.Long, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<CustomField> getCustomFieldsForAccountType(final UUID accountId, final ObjectType objectType, final TenantContext context) {
        throw new UnsupportedOperationException("getCustomFieldsForAccountType(java.util.UUID, org.killbill.billing.ObjectType, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<CustomField> getCustomFieldsForObject(final UUID objectId, final ObjectType objectType, final TenantContext context) {
        throw new UnsupportedOperationException("getCustomFieldsForObject(java.util.UUID, org.killbill.billing.ObjectType, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Pagination<CustomField> searchCustomFields(final String fieldName, final ObjectType objectType, final Long offset, final Long limit, final TenantContext context) {
        throw new UnsupportedOperationException("searchCustomFields(java.lang.String, org.killbill.billing.ObjectType, java.lang.Long, java.lang.Long, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void updateCustomFields(final List<CustomField> fields, final CallContext context) {
        throw new UnsupportedOperationException("updateCustomFields(java.util.List<org.killbill.billing.util.customfield.CustomField>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Pagination<CustomField> searchCustomFields(final String searchKey, final Long offset, final Long limit, final TenantContext context) {
        throw new UnsupportedOperationException("searchCustomFields(java.lang.String, java.lang.Long, java.lang.Long, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Pagination<CustomField> getCustomFields(final Long offset, final Long limit, final TenantContext context) {
        throw new UnsupportedOperationException("getCustomFields(java.lang.Long, java.lang.Long, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final CustomFieldUserApiImp that = (CustomFieldUserApiImp) o;
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
    public static class Builder<T extends CustomFieldUserApiImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final CustomFieldUserApi that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public CustomFieldUserApiImp build() {
            return new CustomFieldUserApiImp(this.validate());
        }
    }
}
