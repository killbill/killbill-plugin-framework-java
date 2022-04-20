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
import java.util.Objects;
import java.util.UUID;
import org.joda.time.LocalDate;
import org.killbill.billing.entitlement.api.BaseEntitlementWithAddOnsSpecifier;
import org.killbill.billing.entitlement.api.EntitlementSpecifier;

@JsonDeserialize( builder = BaseEntitlementWithAddOnsSpecifierImp.Builder.class )
public class BaseEntitlementWithAddOnsSpecifierImp implements BaseEntitlementWithAddOnsSpecifier {

    private static final long serialVersionUID = 0x8ACE98B2CF2F0A9EL;

    protected LocalDate billingEffectiveDate;
    protected String bundleExternalKey;
    protected UUID bundleId;
    protected LocalDate entitlementEffectiveDate;
    protected Iterable<EntitlementSpecifier> entitlementSpecifier;
    protected boolean isMigrated;

    public BaseEntitlementWithAddOnsSpecifierImp(final BaseEntitlementWithAddOnsSpecifierImp that) {
        this.billingEffectiveDate = that.billingEffectiveDate;
        this.bundleExternalKey = that.bundleExternalKey;
        this.bundleId = that.bundleId;
        this.entitlementEffectiveDate = that.entitlementEffectiveDate;
        this.entitlementSpecifier = that.entitlementSpecifier;
        this.isMigrated = that.isMigrated;
    }
    protected BaseEntitlementWithAddOnsSpecifierImp(final BaseEntitlementWithAddOnsSpecifierImp.Builder<?> builder) {
        this.billingEffectiveDate = builder.billingEffectiveDate;
        this.bundleExternalKey = builder.bundleExternalKey;
        this.bundleId = builder.bundleId;
        this.entitlementEffectiveDate = builder.entitlementEffectiveDate;
        this.entitlementSpecifier = builder.entitlementSpecifier;
        this.isMigrated = builder.isMigrated;
    }
    protected BaseEntitlementWithAddOnsSpecifierImp() { }
    @Override
    public LocalDate getBillingEffectiveDate() {
        return this.billingEffectiveDate;
    }
    @Override
    public String getBundleExternalKey() {
        return this.bundleExternalKey;
    }
    @Override
    public UUID getBundleId() {
        return this.bundleId;
    }
    @Override
    public LocalDate getEntitlementEffectiveDate() {
        return this.entitlementEffectiveDate;
    }
    @Override
    public Iterable<EntitlementSpecifier> getEntitlementSpecifier() {
        return this.entitlementSpecifier;
    }
    @Override
    @JsonGetter("isMigrated")
    public boolean isMigrated() {
        return this.isMigrated;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final BaseEntitlementWithAddOnsSpecifierImp that = (BaseEntitlementWithAddOnsSpecifierImp) o;
        if( ( this.billingEffectiveDate != null ) ? ( 0 != this.billingEffectiveDate.compareTo(that.billingEffectiveDate) ) : ( that.billingEffectiveDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.bundleExternalKey, that.bundleExternalKey) ) {
            return false;
        }
        if( !Objects.equals(this.bundleId, that.bundleId) ) {
            return false;
        }
        if( ( this.entitlementEffectiveDate != null ) ? ( 0 != this.entitlementEffectiveDate.compareTo(that.entitlementEffectiveDate) ) : ( that.entitlementEffectiveDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.entitlementSpecifier, that.entitlementSpecifier) ) {
            return false;
        }
        if( this.isMigrated != that.isMigrated ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.billingEffectiveDate);
        result = ( 31 * result ) + Objects.hashCode(this.bundleExternalKey);
        result = ( 31 * result ) + Objects.hashCode(this.bundleId);
        result = ( 31 * result ) + Objects.hashCode(this.entitlementEffectiveDate);
        result = ( 31 * result ) + Objects.hashCode(this.entitlementSpecifier);
        result = ( 31 * result ) + Objects.hashCode(this.isMigrated);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("billingEffectiveDate=").append(this.billingEffectiveDate);
        sb.append(", ");
        sb.append("bundleExternalKey=");
        if( this.bundleExternalKey == null ) {
            sb.append(this.bundleExternalKey);
        }else{
            sb.append("'").append(this.bundleExternalKey).append("'");
        }
        sb.append(", ");
        sb.append("bundleId=").append(this.bundleId);
        sb.append(", ");
        sb.append("entitlementEffectiveDate=").append(this.entitlementEffectiveDate);
        sb.append(", ");
        sb.append("entitlementSpecifier=").append(this.entitlementSpecifier);
        sb.append(", ");
        sb.append("isMigrated=").append(this.isMigrated);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends BaseEntitlementWithAddOnsSpecifierImp.Builder<T>> {

        protected LocalDate billingEffectiveDate;
        protected String bundleExternalKey;
        protected UUID bundleId;
        protected LocalDate entitlementEffectiveDate;
        protected Iterable<EntitlementSpecifier> entitlementSpecifier;
        protected boolean isMigrated;

        public Builder() { }
        public Builder(final Builder that) {
            this.billingEffectiveDate = that.billingEffectiveDate;
            this.bundleExternalKey = that.bundleExternalKey;
            this.bundleId = that.bundleId;
            this.entitlementEffectiveDate = that.entitlementEffectiveDate;
            this.entitlementSpecifier = that.entitlementSpecifier;
            this.isMigrated = that.isMigrated;
        }
        public T withBillingEffectiveDate(final LocalDate billingEffectiveDate) {
            this.billingEffectiveDate = billingEffectiveDate;
            return (T) this;
        }
        public T withBundleExternalKey(final String bundleExternalKey) {
            this.bundleExternalKey = bundleExternalKey;
            return (T) this;
        }
        public T withBundleId(final UUID bundleId) {
            this.bundleId = bundleId;
            return (T) this;
        }
        public T withEntitlementEffectiveDate(final LocalDate entitlementEffectiveDate) {
            this.entitlementEffectiveDate = entitlementEffectiveDate;
            return (T) this;
        }
        public T withEntitlementSpecifier(final Iterable<EntitlementSpecifier> entitlementSpecifier) {
            this.entitlementSpecifier = entitlementSpecifier;
            return (T) this;
        }
        public T withIsMigrated(final boolean isMigrated) {
            this.isMigrated = isMigrated;
            return (T) this;
        }
        public T source(final BaseEntitlementWithAddOnsSpecifier that) {
            this.billingEffectiveDate = that.getBillingEffectiveDate();
            this.bundleExternalKey = that.getBundleExternalKey();
            this.bundleId = that.getBundleId();
            this.entitlementEffectiveDate = that.getEntitlementEffectiveDate();
            this.entitlementSpecifier = that.getEntitlementSpecifier();
            this.isMigrated = that.isMigrated();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public BaseEntitlementWithAddOnsSpecifierImp build() {
            return new BaseEntitlementWithAddOnsSpecifierImp(this.validate());
        }
    }
}
