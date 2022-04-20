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

package org.killbill.billing.entitlement.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.LocalDate;
import org.killbill.billing.OrderingType;
import org.killbill.billing.entitlement.api.BlockingState;
import org.killbill.billing.entitlement.api.BlockingStateType;
import org.killbill.billing.entitlement.api.EntitlementApiException;
import org.killbill.billing.entitlement.api.Subscription;
import org.killbill.billing.entitlement.api.SubscriptionApi;
import org.killbill.billing.entitlement.api.SubscriptionApiException;
import org.killbill.billing.entitlement.api.SubscriptionBundle;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.util.api.AuditLevel;
import org.killbill.billing.util.audit.AuditLogWithHistory;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;
import org.killbill.billing.util.entity.Pagination;

@JsonDeserialize( builder = SubscriptionApiImp.Builder.class )
public class SubscriptionApiImp implements SubscriptionApi {

    private static final long serialVersionUID = 0xE8DBB39D0E927238L;


    public SubscriptionApiImp(final SubscriptionApiImp that) {
    }
    protected SubscriptionApiImp(final SubscriptionApiImp.Builder<?> builder) {
    }
    protected SubscriptionApiImp() { }
    @Override
    public void updateExternalKey(final UUID bundleId, final String newExternalKey, final CallContext context) {
        throw new UnsupportedOperationException("updateExternalKey(java.util.UUID, java.lang.String, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public Pagination<SubscriptionBundle> searchSubscriptionBundles(final String searchKey, final Long offset, final Long limit, final TenantContext context) {
        throw new UnsupportedOperationException("searchSubscriptionBundles(java.lang.String, java.lang.Long, java.lang.Long, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Subscription getSubscriptionForEntitlementId(final UUID entitlementId, final TenantContext context) {
        throw new UnsupportedOperationException("getSubscriptionForEntitlementId(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public SubscriptionBundle getActiveSubscriptionBundleForExternalKey(final String externalKey, final TenantContext context) {
        throw new UnsupportedOperationException("getActiveSubscriptionBundleForExternalKey(java.lang.String, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<AuditLogWithHistory> getSubscriptionEventAuditLogsWithHistoryForId(final UUID EventId, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getSubscriptionEventAuditLogsWithHistoryForId(java.util.UUID, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<SubscriptionBundle> getSubscriptionBundlesForExternalKey(final String externalKey, final TenantContext context) {
        throw new UnsupportedOperationException("getSubscriptionBundlesForExternalKey(java.lang.String, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Subscription getSubscriptionForExternalKey(final String externalKey, final TenantContext context) {
        throw new UnsupportedOperationException("getSubscriptionForExternalKey(java.lang.String, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public SubscriptionBundle getSubscriptionBundle(final UUID bundleId, final TenantContext context) {
        throw new UnsupportedOperationException("getSubscriptionBundle(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<AuditLogWithHistory> getBlockingStateAuditLogsWithHistoryForId(final UUID blockingId, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getBlockingStateAuditLogsWithHistoryForId(java.util.UUID, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<SubscriptionBundle> getSubscriptionBundlesForAccountId(final UUID accountId, final TenantContext context) {
        throw new UnsupportedOperationException("getSubscriptionBundlesForAccountId(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void addBlockingState(final BlockingState blockingState, final LocalDate effectiveDate, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("addBlockingState(org.killbill.billing.entitlement.api.BlockingState, org.joda.time.LocalDate, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<AuditLogWithHistory> getSubscriptionAuditLogsWithHistoryForId(final UUID entitlementId, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getSubscriptionAuditLogsWithHistoryForId(java.util.UUID, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Pagination<SubscriptionBundle> getSubscriptionBundles(final Long offset, final Long limit, final TenantContext context) {
        throw new UnsupportedOperationException("getSubscriptionBundles(java.lang.Long, java.lang.Long, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<SubscriptionBundle> getSubscriptionBundlesForAccountIdAndExternalKey(final UUID accountId, final String externalKey, final TenantContext context) {
        throw new UnsupportedOperationException("getSubscriptionBundlesForAccountIdAndExternalKey(java.util.UUID, java.lang.String, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<AuditLogWithHistory> getSubscriptionBundleAuditLogsWithHistoryForId(final UUID bundleId, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getSubscriptionBundleAuditLogsWithHistoryForId(java.util.UUID, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Iterable<BlockingState> getBlockingStates(final UUID accountId, final List<BlockingStateType> typeFilter, final List<String> svcsFilter, final OrderingType orderingType, final int timeFilter, final TenantContext context) {
        throw new UnsupportedOperationException("getBlockingStates(java.util.UUID, java.util.List<org.killbill.billing.entitlement.api.BlockingStateType>, java.util.List<java.lang.String>, org.killbill.billing.OrderingType, int, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
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
    public static class Builder<T extends SubscriptionApiImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final SubscriptionApi that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public SubscriptionApiImp build() {
            return new SubscriptionApiImp(this.validate());
        }
    }
}
