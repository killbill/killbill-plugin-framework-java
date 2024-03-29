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

package org.killbill.billing.control.plugin.api.boilerplate.plugin;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.control.plugin.api.HPPType;
import org.killbill.billing.control.plugin.api.PaymentApiType;
import org.killbill.billing.control.plugin.api.PaymentControlContext;
import org.killbill.billing.payment.api.TransactionType;
import org.killbill.billing.util.callcontext.CallOrigin;
import org.killbill.billing.util.callcontext.UserType;

@JsonDeserialize( builder = PaymentControlContextImp.Builder.class )
public class PaymentControlContextImp implements PaymentControlContext {

    protected UUID accountId;
    protected BigDecimal amount;
    protected UUID attemptPaymentId;
    protected CallOrigin callOrigin;
    protected String comments;
    protected DateTime createdDate;
    protected Currency currency;
    protected HPPType hPPType;
    protected boolean isApiPayment;
    protected PaymentApiType paymentApiType;
    protected String paymentExternalKey;
    protected UUID paymentId;
    protected UUID paymentMethodId;
    protected String paymentPluginName;
    protected BigDecimal processedAmount;
    protected Currency processedCurrency;
    protected String reasonCode;
    protected UUID tenantId;
    protected String transactionExternalKey;
    protected UUID transactionId;
    protected TransactionType transactionType;
    protected DateTime updatedDate;
    protected String userName;
    protected UUID userToken;
    protected UserType userType;

    public PaymentControlContextImp(final PaymentControlContextImp that) {
        this.accountId = that.accountId;
        this.amount = that.amount;
        this.attemptPaymentId = that.attemptPaymentId;
        this.callOrigin = that.callOrigin;
        this.comments = that.comments;
        this.createdDate = that.createdDate;
        this.currency = that.currency;
        this.hPPType = that.hPPType;
        this.isApiPayment = that.isApiPayment;
        this.paymentApiType = that.paymentApiType;
        this.paymentExternalKey = that.paymentExternalKey;
        this.paymentId = that.paymentId;
        this.paymentMethodId = that.paymentMethodId;
        this.paymentPluginName = that.paymentPluginName;
        this.processedAmount = that.processedAmount;
        this.processedCurrency = that.processedCurrency;
        this.reasonCode = that.reasonCode;
        this.tenantId = that.tenantId;
        this.transactionExternalKey = that.transactionExternalKey;
        this.transactionId = that.transactionId;
        this.transactionType = that.transactionType;
        this.updatedDate = that.updatedDate;
        this.userName = that.userName;
        this.userToken = that.userToken;
        this.userType = that.userType;
    }
    protected PaymentControlContextImp(final PaymentControlContextImp.Builder<?> builder) {
        this.accountId = builder.accountId;
        this.amount = builder.amount;
        this.attemptPaymentId = builder.attemptPaymentId;
        this.callOrigin = builder.callOrigin;
        this.comments = builder.comments;
        this.createdDate = builder.createdDate;
        this.currency = builder.currency;
        this.hPPType = builder.hPPType;
        this.isApiPayment = builder.isApiPayment;
        this.paymentApiType = builder.paymentApiType;
        this.paymentExternalKey = builder.paymentExternalKey;
        this.paymentId = builder.paymentId;
        this.paymentMethodId = builder.paymentMethodId;
        this.paymentPluginName = builder.paymentPluginName;
        this.processedAmount = builder.processedAmount;
        this.processedCurrency = builder.processedCurrency;
        this.reasonCode = builder.reasonCode;
        this.tenantId = builder.tenantId;
        this.transactionExternalKey = builder.transactionExternalKey;
        this.transactionId = builder.transactionId;
        this.transactionType = builder.transactionType;
        this.updatedDate = builder.updatedDate;
        this.userName = builder.userName;
        this.userToken = builder.userToken;
        this.userType = builder.userType;
    }
    protected PaymentControlContextImp() { }
    @Override
    public UUID getAccountId() {
        return this.accountId;
    }
    @Override
    public BigDecimal getAmount() {
        return this.amount;
    }
    @Override
    public UUID getAttemptPaymentId() {
        return this.attemptPaymentId;
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
    public Currency getCurrency() {
        return this.currency;
    }
    @Override
    public HPPType getHPPType() {
        return this.hPPType;
    }
    @Override
    @JsonGetter("isApiPayment")
    public boolean isApiPayment() {
        return this.isApiPayment;
    }
    @Override
    public PaymentApiType getPaymentApiType() {
        return this.paymentApiType;
    }
    @Override
    public String getPaymentExternalKey() {
        return this.paymentExternalKey;
    }
    @Override
    public UUID getPaymentId() {
        return this.paymentId;
    }
    @Override
    public UUID getPaymentMethodId() {
        return this.paymentMethodId;
    }
    @Override
    public String getPaymentPluginName() {
        return this.paymentPluginName;
    }
    @Override
    public BigDecimal getProcessedAmount() {
        return this.processedAmount;
    }
    @Override
    public Currency getProcessedCurrency() {
        return this.processedCurrency;
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
    public String getTransactionExternalKey() {
        return this.transactionExternalKey;
    }
    @Override
    public UUID getTransactionId() {
        return this.transactionId;
    }
    @Override
    public TransactionType getTransactionType() {
        return this.transactionType;
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
        final PaymentControlContextImp that = (PaymentControlContextImp) o;
        if( !Objects.equals(this.accountId, that.accountId) ) {
            return false;
        }
        if( ( this.amount != null ) ? ( 0 != this.amount.compareTo(that.amount) ) : ( that.amount != null ) ) {
            return false;
        }
        if( !Objects.equals(this.attemptPaymentId, that.attemptPaymentId) ) {
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
        if( !Objects.equals(this.currency, that.currency) ) {
            return false;
        }
        if( !Objects.equals(this.hPPType, that.hPPType) ) {
            return false;
        }
        if( this.isApiPayment != that.isApiPayment ) {
            return false;
        }
        if( !Objects.equals(this.paymentApiType, that.paymentApiType) ) {
            return false;
        }
        if( !Objects.equals(this.paymentExternalKey, that.paymentExternalKey) ) {
            return false;
        }
        if( !Objects.equals(this.paymentId, that.paymentId) ) {
            return false;
        }
        if( !Objects.equals(this.paymentMethodId, that.paymentMethodId) ) {
            return false;
        }
        if( !Objects.equals(this.paymentPluginName, that.paymentPluginName) ) {
            return false;
        }
        if( ( this.processedAmount != null ) ? ( 0 != this.processedAmount.compareTo(that.processedAmount) ) : ( that.processedAmount != null ) ) {
            return false;
        }
        if( !Objects.equals(this.processedCurrency, that.processedCurrency) ) {
            return false;
        }
        if( !Objects.equals(this.reasonCode, that.reasonCode) ) {
            return false;
        }
        if( !Objects.equals(this.tenantId, that.tenantId) ) {
            return false;
        }
        if( !Objects.equals(this.transactionExternalKey, that.transactionExternalKey) ) {
            return false;
        }
        if( !Objects.equals(this.transactionId, that.transactionId) ) {
            return false;
        }
        if( !Objects.equals(this.transactionType, that.transactionType) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.amount);
        result = ( 31 * result ) + Objects.hashCode(this.attemptPaymentId);
        result = ( 31 * result ) + Objects.hashCode(this.callOrigin);
        result = ( 31 * result ) + Objects.hashCode(this.comments);
        result = ( 31 * result ) + Objects.hashCode(this.createdDate);
        result = ( 31 * result ) + Objects.hashCode(this.currency);
        result = ( 31 * result ) + Objects.hashCode(this.hPPType);
        result = ( 31 * result ) + Objects.hashCode(this.isApiPayment);
        result = ( 31 * result ) + Objects.hashCode(this.paymentApiType);
        result = ( 31 * result ) + Objects.hashCode(this.paymentExternalKey);
        result = ( 31 * result ) + Objects.hashCode(this.paymentId);
        result = ( 31 * result ) + Objects.hashCode(this.paymentMethodId);
        result = ( 31 * result ) + Objects.hashCode(this.paymentPluginName);
        result = ( 31 * result ) + Objects.hashCode(this.processedAmount);
        result = ( 31 * result ) + Objects.hashCode(this.processedCurrency);
        result = ( 31 * result ) + Objects.hashCode(this.reasonCode);
        result = ( 31 * result ) + Objects.hashCode(this.tenantId);
        result = ( 31 * result ) + Objects.hashCode(this.transactionExternalKey);
        result = ( 31 * result ) + Objects.hashCode(this.transactionId);
        result = ( 31 * result ) + Objects.hashCode(this.transactionType);
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
        sb.append("amount=").append(this.amount);
        sb.append(", ");
        sb.append("attemptPaymentId=").append(this.attemptPaymentId);
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
        sb.append("currency=").append(this.currency);
        sb.append(", ");
        sb.append("hPPType=").append(this.hPPType);
        sb.append(", ");
        sb.append("isApiPayment=").append(this.isApiPayment);
        sb.append(", ");
        sb.append("paymentApiType=").append(this.paymentApiType);
        sb.append(", ");
        sb.append("paymentExternalKey=");
        if( this.paymentExternalKey == null ) {
            sb.append(this.paymentExternalKey);
        }else{
            sb.append("'").append(this.paymentExternalKey).append("'");
        }
        sb.append(", ");
        sb.append("paymentId=").append(this.paymentId);
        sb.append(", ");
        sb.append("paymentMethodId=").append(this.paymentMethodId);
        sb.append(", ");
        sb.append("paymentPluginName=");
        if( this.paymentPluginName == null ) {
            sb.append(this.paymentPluginName);
        }else{
            sb.append("'").append(this.paymentPluginName).append("'");
        }
        sb.append(", ");
        sb.append("processedAmount=").append(this.processedAmount);
        sb.append(", ");
        sb.append("processedCurrency=").append(this.processedCurrency);
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
        sb.append("transactionExternalKey=");
        if( this.transactionExternalKey == null ) {
            sb.append(this.transactionExternalKey);
        }else{
            sb.append("'").append(this.transactionExternalKey).append("'");
        }
        sb.append(", ");
        sb.append("transactionId=").append(this.transactionId);
        sb.append(", ");
        sb.append("transactionType=").append(this.transactionType);
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
    public static class Builder<T extends PaymentControlContextImp.Builder<T>> {

        protected UUID accountId;
        protected BigDecimal amount;
        protected UUID attemptPaymentId;
        protected CallOrigin callOrigin;
        protected String comments;
        protected DateTime createdDate;
        protected Currency currency;
        protected HPPType hPPType;
        protected boolean isApiPayment;
        protected PaymentApiType paymentApiType;
        protected String paymentExternalKey;
        protected UUID paymentId;
        protected UUID paymentMethodId;
        protected String paymentPluginName;
        protected BigDecimal processedAmount;
        protected Currency processedCurrency;
        protected String reasonCode;
        protected UUID tenantId;
        protected String transactionExternalKey;
        protected UUID transactionId;
        protected TransactionType transactionType;
        protected DateTime updatedDate;
        protected String userName;
        protected UUID userToken;
        protected UserType userType;

        public Builder() { }
        public Builder(final Builder that) {
            this.accountId = that.accountId;
            this.amount = that.amount;
            this.attemptPaymentId = that.attemptPaymentId;
            this.callOrigin = that.callOrigin;
            this.comments = that.comments;
            this.createdDate = that.createdDate;
            this.currency = that.currency;
            this.hPPType = that.hPPType;
            this.isApiPayment = that.isApiPayment;
            this.paymentApiType = that.paymentApiType;
            this.paymentExternalKey = that.paymentExternalKey;
            this.paymentId = that.paymentId;
            this.paymentMethodId = that.paymentMethodId;
            this.paymentPluginName = that.paymentPluginName;
            this.processedAmount = that.processedAmount;
            this.processedCurrency = that.processedCurrency;
            this.reasonCode = that.reasonCode;
            this.tenantId = that.tenantId;
            this.transactionExternalKey = that.transactionExternalKey;
            this.transactionId = that.transactionId;
            this.transactionType = that.transactionType;
            this.updatedDate = that.updatedDate;
            this.userName = that.userName;
            this.userToken = that.userToken;
            this.userType = that.userType;
        }
        public T withAccountId(final UUID accountId) {
            this.accountId = accountId;
            return (T) this;
        }
        public T withAmount(final BigDecimal amount) {
            this.amount = amount;
            return (T) this;
        }
        public T withAttemptPaymentId(final UUID attemptPaymentId) {
            this.attemptPaymentId = attemptPaymentId;
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
        public T withCurrency(final Currency currency) {
            this.currency = currency;
            return (T) this;
        }
        public T withHPPType(final HPPType hPPType) {
            this.hPPType = hPPType;
            return (T) this;
        }
        public T withIsApiPayment(final boolean isApiPayment) {
            this.isApiPayment = isApiPayment;
            return (T) this;
        }
        public T withPaymentApiType(final PaymentApiType paymentApiType) {
            this.paymentApiType = paymentApiType;
            return (T) this;
        }
        public T withPaymentExternalKey(final String paymentExternalKey) {
            this.paymentExternalKey = paymentExternalKey;
            return (T) this;
        }
        public T withPaymentId(final UUID paymentId) {
            this.paymentId = paymentId;
            return (T) this;
        }
        public T withPaymentMethodId(final UUID paymentMethodId) {
            this.paymentMethodId = paymentMethodId;
            return (T) this;
        }
        public T withPaymentPluginName(final String paymentPluginName) {
            this.paymentPluginName = paymentPluginName;
            return (T) this;
        }
        public T withProcessedAmount(final BigDecimal processedAmount) {
            this.processedAmount = processedAmount;
            return (T) this;
        }
        public T withProcessedCurrency(final Currency processedCurrency) {
            this.processedCurrency = processedCurrency;
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
        public T withTransactionExternalKey(final String transactionExternalKey) {
            this.transactionExternalKey = transactionExternalKey;
            return (T) this;
        }
        public T withTransactionId(final UUID transactionId) {
            this.transactionId = transactionId;
            return (T) this;
        }
        public T withTransactionType(final TransactionType transactionType) {
            this.transactionType = transactionType;
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
        public T source(final PaymentControlContext that) {
            this.accountId = that.getAccountId();
            this.amount = that.getAmount();
            this.attemptPaymentId = that.getAttemptPaymentId();
            this.callOrigin = that.getCallOrigin();
            this.comments = that.getComments();
            this.createdDate = that.getCreatedDate();
            this.currency = that.getCurrency();
            this.hPPType = that.getHPPType();
            this.isApiPayment = that.isApiPayment();
            this.paymentApiType = that.getPaymentApiType();
            this.paymentExternalKey = that.getPaymentExternalKey();
            this.paymentId = that.getPaymentId();
            this.paymentMethodId = that.getPaymentMethodId();
            this.paymentPluginName = that.getPaymentPluginName();
            this.processedAmount = that.getProcessedAmount();
            this.processedCurrency = that.getProcessedCurrency();
            this.reasonCode = that.getReasonCode();
            this.tenantId = that.getTenantId();
            this.transactionExternalKey = that.getTransactionExternalKey();
            this.transactionId = that.getTransactionId();
            this.transactionType = that.getTransactionType();
            this.updatedDate = that.getUpdatedDate();
            this.userName = that.getUserName();
            this.userToken = that.getUserToken();
            this.userType = that.getUserType();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PaymentControlContextImp build() {
            return new PaymentControlContextImp(this.validate());
        }
    }
}
