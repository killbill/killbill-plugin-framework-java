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
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.LocalDate;
import org.killbill.billing.catalog.api.BillingActionPolicy;
import org.killbill.billing.entitlement.api.BaseEntitlementWithAddOnsSpecifier;
import org.killbill.billing.entitlement.api.Entitlement;
import org.killbill.billing.entitlement.api.EntitlementAOStatusDryRun;
import org.killbill.billing.entitlement.api.EntitlementApi;
import org.killbill.billing.entitlement.api.EntitlementApiException;
import org.killbill.billing.entitlement.api.EntitlementSpecifier;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;

@JsonDeserialize( builder = EntitlementApiImp.Builder.class )
public class EntitlementApiImp implements EntitlementApi, Serializable {

    private static final long serialVersionUID = 0x377EE5F1D9AD91C2L;


    public EntitlementApiImp(final EntitlementApiImp that) {
    }
    protected EntitlementApiImp(final EntitlementApiImp.Builder<?> builder) {
    }
    protected EntitlementApiImp() { }
    @Override
    public List<Entitlement> getAllEntitlementsForAccountId(final UUID accountId, final TenantContext context) {
        throw new UnsupportedOperationException("getAllEntitlementsForAccountId(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<Entitlement> getAllEntitlementsForBundle(final UUID bundleId, final TenantContext context) {
        throw new UnsupportedOperationException("getAllEntitlementsForBundle(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Entitlement getEntitlementForId(final UUID id, final TenantContext context) {
        throw new UnsupportedOperationException("getEntitlementForId(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void resume(final UUID bundleId, final LocalDate effectiveDate, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("resume(java.util.UUID, org.joda.time.LocalDate, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<EntitlementAOStatusDryRun> getDryRunStatusForChange(final UUID bundleId, final String targetProductName, final LocalDate effectiveDate, final TenantContext context) {
        throw new UnsupportedOperationException("getDryRunStatusForChange(java.util.UUID, java.lang.String, org.joda.time.LocalDate, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void pause(final UUID bundleId, final LocalDate effectiveDate, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("pause(java.util.UUID, org.joda.time.LocalDate, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public UUID transferEntitlements(final UUID sourceAccountId, final UUID destAccountId, final String bundleExternalKey, final LocalDate effectiveDate, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("transferEntitlements(java.util.UUID, java.util.UUID, java.lang.String, org.joda.time.LocalDate, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public UUID transferEntitlementsOverrideBillingPolicy(final UUID sourceAccountId, final UUID destAccountId, final String bundleExternalKey, final LocalDate effectiveDate, final BillingActionPolicy billingPolicy, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("transferEntitlementsOverrideBillingPolicy(java.util.UUID, java.util.UUID, java.lang.String, org.joda.time.LocalDate, org.killbill.billing.catalog.api.BillingActionPolicy, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<Entitlement> getAllEntitlementsForAccountIdAndBundleExternalKey(final UUID accountId, final String bundleExternalKey, final TenantContext context) {
        throw new UnsupportedOperationException("getAllEntitlementsForAccountIdAndBundleExternalKey(java.util.UUID, java.lang.String, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public UUID createBaseEntitlement(final UUID accountId, final EntitlementSpecifier spec, final String bundleExternalKey, final LocalDate entitlementEffectiveDate, final LocalDate billingEffectiveDate, final boolean isMigrated, final boolean renameCancelledBundleIfExist, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("createBaseEntitlement(java.util.UUID, org.killbill.billing.entitlement.api.EntitlementSpecifier, java.lang.String, org.joda.time.LocalDate, org.joda.time.LocalDate, boolean, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public UUID addEntitlement(final UUID bundleId, final EntitlementSpecifier spec, final LocalDate entitlementEffectiveDate, final LocalDate billingEffectiveDate, final boolean isMigrated, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("addEntitlement(java.util.UUID, org.killbill.billing.entitlement.api.EntitlementSpecifier, org.joda.time.LocalDate, org.joda.time.LocalDate, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<UUID> createBaseEntitlementsWithAddOns(final UUID accountId, final Iterable<BaseEntitlementWithAddOnsSpecifier> baseEntitlementWithAddOnsSpecifier, final boolean renameCancelledBundleIfExist, final Iterable<PluginProperty> properties, final CallContext context) {
        throw new UnsupportedOperationException("createBaseEntitlementsWithAddOns(java.util.UUID, java.lang.Iterable<org.killbill.billing.entitlement.api.BaseEntitlementWithAddOnsSpecifier>, boolean, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final EntitlementApiImp that = (EntitlementApiImp) o;
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
    public static class Builder<T extends EntitlementApiImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final EntitlementApi that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public EntitlementApiImp build() {
            return new EntitlementApiImp(this.validate());
        }
    }
}
