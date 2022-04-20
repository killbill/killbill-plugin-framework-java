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

package org.killbill.billing.usage.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.LocalDate;
import org.killbill.billing.usage.api.RolledUpUsage;
import org.killbill.billing.usage.api.SubscriptionUsageRecord;
import org.killbill.billing.usage.api.UsageApiException;
import org.killbill.billing.usage.api.UsageUserApi;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;

@JsonDeserialize( builder = UsageUserApiImp.Builder.class )
public class UsageUserApiImp implements UsageUserApi {


    public UsageUserApiImp(final UsageUserApiImp that) {
    }
    protected UsageUserApiImp(final UsageUserApiImp.Builder<?> builder) {
    }
    protected UsageUserApiImp() { }
    @Override
    public void recordRolledUpUsage(final SubscriptionUsageRecord usage, final CallContext context) {
        throw new UnsupportedOperationException("recordRolledUpUsage(org.killbill.billing.usage.api.SubscriptionUsageRecord, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<RolledUpUsage> getAllUsageForSubscription(final UUID subscriptionId, final List<LocalDate> transitionDates, final TenantContext context) {
        throw new UnsupportedOperationException("getAllUsageForSubscription(java.util.UUID, java.util.List<org.joda.time.LocalDate>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public RolledUpUsage getUsageForSubscription(final UUID subscriptionId, final String unitType, final LocalDate startDate, final LocalDate endDate, final TenantContext context) {
        throw new UnsupportedOperationException("getUsageForSubscription(java.util.UUID, java.lang.String, org.joda.time.LocalDate, org.joda.time.LocalDate, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
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
    public static class Builder<T extends UsageUserApiImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final UsageUserApi that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public UsageUserApiImp build() {
            return new UsageUserApiImp(this.validate());
        }
    }
}
