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

package org.killbill.billing.entitlement.plugin.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.killbill.billing.catalog.api.BillingActionPolicy;
import org.killbill.billing.entitlement.api.BaseEntitlementWithAddOnsSpecifier;
import org.killbill.billing.entitlement.plugin.api.EntitlementContext;
import org.killbill.billing.entitlement.plugin.api.OperationType;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.util.callcontext.CallOrigin;
import org.killbill.billing.util.callcontext.UserType;

@JsonDeserialize( builder = EntitlementContextImp.Builder.class )
public class EntitlementContextImp implements EntitlementContext {

    protected UUID accountId;
    protected Iterable<BaseEntitlementWithAddOnsSpecifier> baseEntitlementWithAddOnsSpecifiers;
    protected BillingActionPolicy billingActionPolicy;
    protected CallOrigin callOrigin;
    protected String comments;
    protected DateTime createdDate;
    protected UUID destinationAccountId;
    protected OperationType operationType;
    protected Iterable<PluginProperty> pluginProperties;
    protected String reasonCode;
    protected UUID tenantId;
    protected DateTime updatedDate;
    protected String userName;
    protected UUID userToken;
    protected UserType userType;

    public EntitlementContextImp(final EntitlementContextImp that) {
        this.accountId = that.accountId;
        this.baseEntitlementWithAddOnsSpecifiers = that.baseEntitlementWithAddOnsSpecifiers;
        this.billingActionPolicy = that.billingActionPolicy;
        this.callOrigin = that.callOrigin;
        this.comments = that.comments;
        this.createdDate = that.createdDate;
        this.destinationAccountId = that.destinationAccountId;
        this.operationType = that.operationType;
        this.pluginProperties = that.pluginProperties;
        this.reasonCode = that.reasonCode;
        this.tenantId = that.tenantId;
        this.updatedDate = that.updatedDate;
        this.userName = that.userName;
        this.userToken = that.userToken;
        this.userType = that.userType;
    }
    protected EntitlementContextImp(final EntitlementContextImp.Builder<?> builder) {
        this.accountId = builder.accountId;
        this.baseEntitlementWithAddOnsSpecifiers = builder.baseEntitlementWithAddOnsSpecifiers;
        this.billingActionPolicy = builder.billingActionPolicy;
        this.callOrigin = builder.callOrigin;
        this.comments = builder.comments;
        this.createdDate = builder.createdDate;
        this.destinationAccountId = builder.destinationAccountId;
        this.operationType = builder.operationType;
        this.pluginProperties = builder.pluginProperties;
        this.reasonCode = builder.reasonCode;
        this.tenantId = builder.tenantId;
        this.updatedDate = builder.updatedDate;
        this.userName = builder.userName;
        this.userToken = builder.userToken;
        this.userType = builder.userType;
    }
    protected EntitlementContextImp() { }
    @Override
    public UUID getAccountId() {
        return this.accountId;
    }
    @Override
    public Iterable<BaseEntitlementWithAddOnsSpecifier> getBaseEntitlementWithAddOnsSpecifiers() {
        return this.baseEntitlementWithAddOnsSpecifiers;
    }
    @Override
    public BillingActionPolicy getBillingActionPolicy() {
        return this.billingActionPolicy;
    }
    @Override
    public CallOrigin getCallOrigin() {
        return this.callOrigin;
    }
    @Override
    public String getComments() {
        return this.comments;
    }
    @Override
    public DateTime getCreatedDate() {
        return this.createdDate;
    }
    @Override
    public UUID getDestinationAccountId() {
        return this.destinationAccountId;
    }
    @Override
    public OperationType getOperationType() {
        return this.operationType;
    }
    @Override
    public Iterable<PluginProperty> getPluginProperties() {
        return this.pluginProperties;
    }
    @Override
    public String getReasonCode() {
        return this.reasonCode;
    }
    @Override
    public UUID getTenantId() {
        return this.tenantId;
    }
    @Override
    public DateTime getUpdatedDate() {
        return this.updatedDate;
    }
    @Override
    public String getUserName() {
        return this.userName;
    }
    @Override
    public UUID getUserToken() {
        return this.userToken;
    }
    @Override
    public UserType getUserType() {
        return this.userType;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final EntitlementContextImp that = (EntitlementContextImp) o;
        if( !Objects.equals(this.accountId, that.accountId) ) {
            return false;
        }
        if( !Objects.equals(this.baseEntitlementWithAddOnsSpecifiers, that.baseEntitlementWithAddOnsSpecifiers) ) {
            return false;
        }
        if( !Objects.equals(this.billingActionPolicy, that.billingActionPolicy) ) {
            return false;
        }
        if( !Objects.equals(this.callOrigin, that.callOrigin) ) {
            return false;
        }
        if( !Objects.equals(this.comments, that.comments) ) {
            return false;
        }
        if( ( this.createdDate != null ) ? ( 0 != this.createdDate.compareTo(that.createdDate) ) : ( that.createdDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.destinationAccountId, that.destinationAccountId) ) {
            return false;
        }
        if( !Objects.equals(this.operationType, that.operationType) ) {
            return false;
        }
        if( !Objects.equals(this.pluginProperties, that.pluginProperties) ) {
            return false;
        }
        if( !Objects.equals(this.reasonCode, that.reasonCode) ) {
            return false;
        }
        if( !Objects.equals(this.tenantId, that.tenantId) ) {
            return false;
        }
        if( ( this.updatedDate != null ) ? ( 0 != this.updatedDate.compareTo(that.updatedDate) ) : ( that.updatedDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.userName, that.userName) ) {
            return false;
        }
        if( !Objects.equals(this.userToken, that.userToken) ) {
            return false;
        }
        if( !Objects.equals(this.userType, that.userType) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.accountId);
        result = ( 31 * result ) + Objects.hashCode(this.baseEntitlementWithAddOnsSpecifiers);
        result = ( 31 * result ) + Objects.hashCode(this.billingActionPolicy);
        result = ( 31 * result ) + Objects.hashCode(this.callOrigin);
        result = ( 31 * result ) + Objects.hashCode(this.comments);
        result = ( 31 * result ) + Objects.hashCode(this.createdDate);
        result = ( 31 * result ) + Objects.hashCode(this.destinationAccountId);
        result = ( 31 * result ) + Objects.hashCode(this.operationType);
        result = ( 31 * result ) + Objects.hashCode(this.pluginProperties);
        result = ( 31 * result ) + Objects.hashCode(this.reasonCode);
        result = ( 31 * result ) + Objects.hashCode(this.tenantId);
        result = ( 31 * result ) + Objects.hashCode(this.updatedDate);
        result = ( 31 * result ) + Objects.hashCode(this.userName);
        result = ( 31 * result ) + Objects.hashCode(this.userToken);
        result = ( 31 * result ) + Objects.hashCode(this.userType);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("accountId=").append(this.accountId);
        sb.append(", ");
        sb.append("baseEntitlementWithAddOnsSpecifiers=").append(this.baseEntitlementWithAddOnsSpecifiers);
        sb.append(", ");
        sb.append("billingActionPolicy=").append(this.billingActionPolicy);
        sb.append(", ");
        sb.append("callOrigin=").append(this.callOrigin);
        sb.append(", ");
        sb.append("comments=");
        if( this.comments == null ) {
            sb.append(this.comments);
        }else{
            sb.append("'").append(this.comments).append("'");
        }
        sb.append(", ");
        sb.append("createdDate=").append(this.createdDate);
        sb.append(", ");
        sb.append("destinationAccountId=").append(this.destinationAccountId);
        sb.append(", ");
        sb.append("operationType=").append(this.operationType);
        sb.append(", ");
        sb.append("pluginProperties=").append(this.pluginProperties);
        sb.append(", ");
        sb.append("reasonCode=");
        if( this.reasonCode == null ) {
            sb.append(this.reasonCode);
        }else{
            sb.append("'").append(this.reasonCode).append("'");
        }
        sb.append(", ");
        sb.append("tenantId=").append(this.tenantId);
        sb.append(", ");
        sb.append("updatedDate=").append(this.updatedDate);
        sb.append(", ");
        sb.append("userName=");
        if( this.userName == null ) {
            sb.append(this.userName);
        }else{
            sb.append("'").append(this.userName).append("'");
        }
        sb.append(", ");
        sb.append("userToken=").append(this.userToken);
        sb.append(", ");
        sb.append("userType=").append(this.userType);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends EntitlementContextImp.Builder<T>> {

        protected UUID accountId;
        protected Iterable<BaseEntitlementWithAddOnsSpecifier> baseEntitlementWithAddOnsSpecifiers;
        protected BillingActionPolicy billingActionPolicy;
        protected CallOrigin callOrigin;
        protected String comments;
        protected DateTime createdDate;
        protected UUID destinationAccountId;
        protected OperationType operationType;
        protected Iterable<PluginProperty> pluginProperties;
        protected String reasonCode;
        protected UUID tenantId;
        protected DateTime updatedDate;
        protected String userName;
        protected UUID userToken;
        protected UserType userType;

        public Builder() { }
        public Builder(final Builder that) {
            this.accountId = that.accountId;
            this.baseEntitlementWithAddOnsSpecifiers = that.baseEntitlementWithAddOnsSpecifiers;
            this.billingActionPolicy = that.billingActionPolicy;
            this.callOrigin = that.callOrigin;
            this.comments = that.comments;
            this.createdDate = that.createdDate;
            this.destinationAccountId = that.destinationAccountId;
            this.operationType = that.operationType;
            this.pluginProperties = that.pluginProperties;
            this.reasonCode = that.reasonCode;
            this.tenantId = that.tenantId;
            this.updatedDate = that.updatedDate;
            this.userName = that.userName;
            this.userToken = that.userToken;
            this.userType = that.userType;
        }
        public T withAccountId(final UUID accountId) {
            this.accountId = accountId;
            return (T) this;
        }
        public T withBaseEntitlementWithAddOnsSpecifiers(final Iterable<BaseEntitlementWithAddOnsSpecifier> baseEntitlementWithAddOnsSpecifiers) {
            this.baseEntitlementWithAddOnsSpecifiers = baseEntitlementWithAddOnsSpecifiers;
            return (T) this;
        }
        public T withBillingActionPolicy(final BillingActionPolicy billingActionPolicy) {
            this.billingActionPolicy = billingActionPolicy;
            return (T) this;
        }
        public T withCallOrigin(final CallOrigin callOrigin) {
            this.callOrigin = callOrigin;
            return (T) this;
        }
        public T withComments(final String comments) {
            this.comments = comments;
            return (T) this;
        }
        public T withCreatedDate(final DateTime createdDate) {
            this.createdDate = createdDate;
            return (T) this;
        }
        public T withDestinationAccountId(final UUID destinationAccountId) {
            this.destinationAccountId = destinationAccountId;
            return (T) this;
        }
        public T withOperationType(final OperationType operationType) {
            this.operationType = operationType;
            return (T) this;
        }
        public T withPluginProperties(final Iterable<PluginProperty> pluginProperties) {
            this.pluginProperties = pluginProperties;
            return (T) this;
        }
        public T withReasonCode(final String reasonCode) {
            this.reasonCode = reasonCode;
            return (T) this;
        }
        public T withTenantId(final UUID tenantId) {
            this.tenantId = tenantId;
            return (T) this;
        }
        public T withUpdatedDate(final DateTime updatedDate) {
            this.updatedDate = updatedDate;
            return (T) this;
        }
        public T withUserName(final String userName) {
            this.userName = userName;
            return (T) this;
        }
        public T withUserToken(final UUID userToken) {
            this.userToken = userToken;
            return (T) this;
        }
        public T withUserType(final UserType userType) {
            this.userType = userType;
            return (T) this;
        }
        public T source(final EntitlementContext that) {
            this.accountId = that.getAccountId();
            this.baseEntitlementWithAddOnsSpecifiers = that.getBaseEntitlementWithAddOnsSpecifiers();
            this.billingActionPolicy = that.getBillingActionPolicy();
            this.callOrigin = that.getCallOrigin();
            this.comments = that.getComments();
            this.createdDate = that.getCreatedDate();
            this.destinationAccountId = that.getDestinationAccountId();
            this.operationType = that.getOperationType();
            this.pluginProperties = that.getPluginProperties();
            this.reasonCode = that.getReasonCode();
            this.tenantId = that.getTenantId();
            this.updatedDate = that.getUpdatedDate();
            this.userName = that.getUserName();
            this.userToken = that.getUserToken();
            this.userType = that.getUserType();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public EntitlementContextImp build() {
            return new EntitlementContextImp(this.validate());
        }
    }
}
