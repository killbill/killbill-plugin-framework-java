/*
 *  Generated by https://github.com/killbill/api-pojos. Do not edit!
 *
 *  Copyright 2022-2022 The Billing Project, LLC
 *
 *  The Billing Project licenses this file to you under the Apache License,
 *  version 2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at:
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 *  License for the specific language governing permissions and limitations
 *  under the License.
 */

package org.killbill.billing.usage.plugin.api.boilerplate.plugin;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.LocalDate;
import org.killbill.billing.invoice.api.DryRunType;
import org.killbill.billing.usage.plugin.api.UsageContext;

@JsonDeserialize( builder = UsageContextImp.Builder.class )
public class UsageContextImp implements UsageContext {

    protected UUID accountId;
    protected DryRunType dryRunType;
    protected LocalDate inputTargetDate;
    protected UUID tenantId;

    public UsageContextImp(final UsageContextImp that) {
        this.accountId = that.accountId;
        this.dryRunType = that.dryRunType;
        this.inputTargetDate = that.inputTargetDate;
        this.tenantId = that.tenantId;
    }
    protected UsageContextImp(final UsageContextImp.Builder<?> builder) {
        this.accountId = builder.accountId;
        this.dryRunType = builder.dryRunType;
        this.inputTargetDate = builder.inputTargetDate;
        this.tenantId = builder.tenantId;
    }
    protected UsageContextImp() { }
    @Override
    public UUID getAccountId() {
        return this.accountId;
    }
    @Override
    public DryRunType getDryRunType() {
        return this.dryRunType;
    }
    @Override
    public LocalDate getInputTargetDate() {
        return this.inputTargetDate;
    }
    @Override
    public UUID getTenantId() {
        return this.tenantId;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final UsageContextImp that = (UsageContextImp) o;
        if( !Objects.equals(this.accountId, that.accountId) ) {
            return false;
        }
        if( !Objects.equals(this.dryRunType, that.dryRunType) ) {
            return false;
        }
        if( ( this.inputTargetDate != null ) ? ( 0 != this.inputTargetDate.compareTo(that.inputTargetDate) ) : ( that.inputTargetDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.tenantId, that.tenantId) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.accountId);
        result = ( 31 * result ) + Objects.hashCode(this.dryRunType);
        result = ( 31 * result ) + Objects.hashCode(this.inputTargetDate);
        result = ( 31 * result ) + Objects.hashCode(this.tenantId);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("accountId=").append(this.accountId);
        sb.append(", ");
        sb.append("dryRunType=").append(this.dryRunType);
        sb.append(", ");
        sb.append("inputTargetDate=").append(this.inputTargetDate);
        sb.append(", ");
        sb.append("tenantId=").append(this.tenantId);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends UsageContextImp.Builder<T>> {

        protected UUID accountId;
        protected DryRunType dryRunType;
        protected LocalDate inputTargetDate;
        protected UUID tenantId;

        public Builder() { }
        public Builder(final Builder that) {
            this.accountId = that.accountId;
            this.dryRunType = that.dryRunType;
            this.inputTargetDate = that.inputTargetDate;
            this.tenantId = that.tenantId;
        }
        public T withAccountId(final UUID accountId) {
            this.accountId = accountId;
            return (T) this;
        }
        public T withDryRunType(final DryRunType dryRunType) {
            this.dryRunType = dryRunType;
            return (T) this;
        }
        public T withInputTargetDate(final LocalDate inputTargetDate) {
            this.inputTargetDate = inputTargetDate;
            return (T) this;
        }
        public T withTenantId(final UUID tenantId) {
            this.tenantId = tenantId;
            return (T) this;
        }
        public T source(final UsageContext that) {
            this.accountId = that.getAccountId();
            this.dryRunType = that.getDryRunType();
            this.inputTargetDate = that.getInputTargetDate();
            this.tenantId = that.getTenantId();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public UsageContextImp build() {
            return new UsageContextImp(this.validate());
        }
    }
}
