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

package org.killbill.billing.payment.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.payment.api.Payment;
import org.killbill.billing.payment.api.PaymentAttempt;
import org.killbill.billing.payment.api.PaymentTransaction;

@JsonDeserialize( builder = PaymentImp.Builder.class )
public class PaymentImp implements Payment {

    private static final long serialVersionUID = 0x7D2CBDE629F0CD4FL;

    protected UUID accountId;
    protected BigDecimal authAmount;
    protected BigDecimal capturedAmount;
    protected DateTime createdDate;
    protected BigDecimal creditedAmount;
    protected Currency currency;
    protected String externalKey;
    protected UUID id;
    protected Boolean isAuthVoided;
    protected List<PaymentAttempt> paymentAttempts;
    protected UUID paymentMethodId;
    protected Integer paymentNumber;
    protected BigDecimal purchasedAmount;
    protected BigDecimal refundedAmount;
    protected List<PaymentTransaction> transactions;
    protected DateTime updatedDate;

    public PaymentImp(final PaymentImp that) {
        this.accountId = that.accountId;
        this.authAmount = that.authAmount;
        this.capturedAmount = that.capturedAmount;
        this.createdDate = that.createdDate;
        this.creditedAmount = that.creditedAmount;
        this.currency = that.currency;
        this.externalKey = that.externalKey;
        this.id = that.id;
        this.isAuthVoided = that.isAuthVoided;
        this.paymentAttempts = that.paymentAttempts;
        this.paymentMethodId = that.paymentMethodId;
        this.paymentNumber = that.paymentNumber;
        this.purchasedAmount = that.purchasedAmount;
        this.refundedAmount = that.refundedAmount;
        this.transactions = that.transactions;
        this.updatedDate = that.updatedDate;
    }
    protected PaymentImp(final PaymentImp.Builder<?> builder) {
        this.accountId = builder.accountId;
        this.authAmount = builder.authAmount;
        this.capturedAmount = builder.capturedAmount;
        this.createdDate = builder.createdDate;
        this.creditedAmount = builder.creditedAmount;
        this.currency = builder.currency;
        this.externalKey = builder.externalKey;
        this.id = builder.id;
        this.isAuthVoided = builder.isAuthVoided;
        this.paymentAttempts = builder.paymentAttempts;
        this.paymentMethodId = builder.paymentMethodId;
        this.paymentNumber = builder.paymentNumber;
        this.purchasedAmount = builder.purchasedAmount;
        this.refundedAmount = builder.refundedAmount;
        this.transactions = builder.transactions;
        this.updatedDate = builder.updatedDate;
    }
    protected PaymentImp() { }
    @Override
    public UUID getAccountId() {
        return this.accountId;
    }
    @Override
    public BigDecimal getAuthAmount() {
        return this.authAmount;
    }
    @Override
    public BigDecimal getCapturedAmount() {
        return this.capturedAmount;
    }
    @Override
    public DateTime getCreatedDate() {
        return this.createdDate;
    }
    @Override
    public BigDecimal getCreditedAmount() {
        return this.creditedAmount;
    }
    @Override
    public Currency getCurrency() {
        return this.currency;
    }
    @Override
    public String getExternalKey() {
        return this.externalKey;
    }
    @Override
    public UUID getId() {
        return this.id;
    }
    @Override
    @JsonGetter("isAuthVoided")
    public Boolean isAuthVoided() {
        return this.isAuthVoided;
    }
    @Override
    public List<PaymentAttempt> getPaymentAttempts() {
        return this.paymentAttempts;
    }
    @Override
    public UUID getPaymentMethodId() {
        return this.paymentMethodId;
    }
    @Override
    public Integer getPaymentNumber() {
        return this.paymentNumber;
    }
    @Override
    public BigDecimal getPurchasedAmount() {
        return this.purchasedAmount;
    }
    @Override
    public BigDecimal getRefundedAmount() {
        return this.refundedAmount;
    }
    @Override
    public List<PaymentTransaction> getTransactions() {
        return this.transactions;
    }
    @Override
    public DateTime getUpdatedDate() {
        return this.updatedDate;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PaymentImp that = (PaymentImp) o;
        if( !Objects.equals(this.accountId, that.accountId) ) {
            return false;
        }
        if( ( this.authAmount != null ) ? ( 0 != this.authAmount.compareTo(that.authAmount) ) : ( that.authAmount != null ) ) {
            return false;
        }
        if( ( this.capturedAmount != null ) ? ( 0 != this.capturedAmount.compareTo(that.capturedAmount) ) : ( that.capturedAmount != null ) ) {
            return false;
        }
        if( ( this.createdDate != null ) ? ( 0 != this.createdDate.compareTo(that.createdDate) ) : ( that.createdDate != null ) ) {
            return false;
        }
        if( ( this.creditedAmount != null ) ? ( 0 != this.creditedAmount.compareTo(that.creditedAmount) ) : ( that.creditedAmount != null ) ) {
            return false;
        }
        if( !Objects.equals(this.currency, that.currency) ) {
            return false;
        }
        if( !Objects.equals(this.externalKey, that.externalKey) ) {
            return false;
        }
        if( !Objects.equals(this.id, that.id) ) {
            return false;
        }
        if( !Objects.equals(this.isAuthVoided, that.isAuthVoided) ) {
            return false;
        }
        if( !Objects.equals(this.paymentAttempts, that.paymentAttempts) ) {
            return false;
        }
        if( !Objects.equals(this.paymentMethodId, that.paymentMethodId) ) {
            return false;
        }
        if( !Objects.equals(this.paymentNumber, that.paymentNumber) ) {
            return false;
        }
        if( ( this.purchasedAmount != null ) ? ( 0 != this.purchasedAmount.compareTo(that.purchasedAmount) ) : ( that.purchasedAmount != null ) ) {
            return false;
        }
        if( ( this.refundedAmount != null ) ? ( 0 != this.refundedAmount.compareTo(that.refundedAmount) ) : ( that.refundedAmount != null ) ) {
            return false;
        }
        if( !Objects.equals(this.transactions, that.transactions) ) {
            return false;
        }
        if( ( this.updatedDate != null ) ? ( 0 != this.updatedDate.compareTo(that.updatedDate) ) : ( that.updatedDate != null ) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.accountId);
        result = ( 31 * result ) + Objects.hashCode(this.authAmount);
        result = ( 31 * result ) + Objects.hashCode(this.capturedAmount);
        result = ( 31 * result ) + Objects.hashCode(this.createdDate);
        result = ( 31 * result ) + Objects.hashCode(this.creditedAmount);
        result = ( 31 * result ) + Objects.hashCode(this.currency);
        result = ( 31 * result ) + Objects.hashCode(this.externalKey);
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.isAuthVoided);
        result = ( 31 * result ) + Objects.hashCode(this.paymentAttempts);
        result = ( 31 * result ) + Objects.hashCode(this.paymentMethodId);
        result = ( 31 * result ) + Objects.hashCode(this.paymentNumber);
        result = ( 31 * result ) + Objects.hashCode(this.purchasedAmount);
        result = ( 31 * result ) + Objects.hashCode(this.refundedAmount);
        result = ( 31 * result ) + Objects.hashCode(this.transactions);
        result = ( 31 * result ) + Objects.hashCode(this.updatedDate);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("accountId=").append(this.accountId);
        sb.append(", ");
        sb.append("authAmount=").append(this.authAmount);
        sb.append(", ");
        sb.append("capturedAmount=").append(this.capturedAmount);
        sb.append(", ");
        sb.append("createdDate=").append(this.createdDate);
        sb.append(", ");
        sb.append("creditedAmount=").append(this.creditedAmount);
        sb.append(", ");
        sb.append("currency=").append(this.currency);
        sb.append(", ");
        sb.append("externalKey=");
        if( this.externalKey == null ) {
            sb.append(this.externalKey);
        }else{
            sb.append("'").append(this.externalKey).append("'");
        }
        sb.append(", ");
        sb.append("id=").append(this.id);
        sb.append(", ");
        sb.append("isAuthVoided=").append(this.isAuthVoided);
        sb.append(", ");
        sb.append("paymentAttempts=").append(this.paymentAttempts);
        sb.append(", ");
        sb.append("paymentMethodId=").append(this.paymentMethodId);
        sb.append(", ");
        sb.append("paymentNumber=").append(this.paymentNumber);
        sb.append(", ");
        sb.append("purchasedAmount=").append(this.purchasedAmount);
        sb.append(", ");
        sb.append("refundedAmount=").append(this.refundedAmount);
        sb.append(", ");
        sb.append("transactions=").append(this.transactions);
        sb.append(", ");
        sb.append("updatedDate=").append(this.updatedDate);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PaymentImp.Builder<T>> {

        protected UUID accountId;
        protected BigDecimal authAmount;
        protected BigDecimal capturedAmount;
        protected DateTime createdDate;
        protected BigDecimal creditedAmount;
        protected Currency currency;
        protected String externalKey;
        protected UUID id;
        protected Boolean isAuthVoided;
        protected List<PaymentAttempt> paymentAttempts;
        protected UUID paymentMethodId;
        protected Integer paymentNumber;
        protected BigDecimal purchasedAmount;
        protected BigDecimal refundedAmount;
        protected List<PaymentTransaction> transactions;
        protected DateTime updatedDate;

        public Builder() { }
        public Builder(final Builder that) {
            this.accountId = that.accountId;
            this.authAmount = that.authAmount;
            this.capturedAmount = that.capturedAmount;
            this.createdDate = that.createdDate;
            this.creditedAmount = that.creditedAmount;
            this.currency = that.currency;
            this.externalKey = that.externalKey;
            this.id = that.id;
            this.isAuthVoided = that.isAuthVoided;
            this.paymentAttempts = that.paymentAttempts;
            this.paymentMethodId = that.paymentMethodId;
            this.paymentNumber = that.paymentNumber;
            this.purchasedAmount = that.purchasedAmount;
            this.refundedAmount = that.refundedAmount;
            this.transactions = that.transactions;
            this.updatedDate = that.updatedDate;
        }
        public T withAccountId(final UUID accountId) {
            this.accountId = accountId;
            return (T) this;
        }
        public T withAuthAmount(final BigDecimal authAmount) {
            this.authAmount = authAmount;
            return (T) this;
        }
        public T withCapturedAmount(final BigDecimal capturedAmount) {
            this.capturedAmount = capturedAmount;
            return (T) this;
        }
        public T withCreatedDate(final DateTime createdDate) {
            this.createdDate = createdDate;
            return (T) this;
        }
        public T withCreditedAmount(final BigDecimal creditedAmount) {
            this.creditedAmount = creditedAmount;
            return (T) this;
        }
        public T withCurrency(final Currency currency) {
            this.currency = currency;
            return (T) this;
        }
        public T withExternalKey(final String externalKey) {
            this.externalKey = externalKey;
            return (T) this;
        }
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withIsAuthVoided(final Boolean isAuthVoided) {
            this.isAuthVoided = isAuthVoided;
            return (T) this;
        }
        public T withPaymentAttempts(final List<PaymentAttempt> paymentAttempts) {
            this.paymentAttempts = paymentAttempts;
            return (T) this;
        }
        public T withPaymentMethodId(final UUID paymentMethodId) {
            this.paymentMethodId = paymentMethodId;
            return (T) this;
        }
        public T withPaymentNumber(final Integer paymentNumber) {
            this.paymentNumber = paymentNumber;
            return (T) this;
        }
        public T withPurchasedAmount(final BigDecimal purchasedAmount) {
            this.purchasedAmount = purchasedAmount;
            return (T) this;
        }
        public T withRefundedAmount(final BigDecimal refundedAmount) {
            this.refundedAmount = refundedAmount;
            return (T) this;
        }
        public T withTransactions(final List<PaymentTransaction> transactions) {
            this.transactions = transactions;
            return (T) this;
        }
        public T withUpdatedDate(final DateTime updatedDate) {
            this.updatedDate = updatedDate;
            return (T) this;
        }
        public T source(final Payment that) {
            this.accountId = that.getAccountId();
            this.authAmount = that.getAuthAmount();
            this.capturedAmount = that.getCapturedAmount();
            this.createdDate = that.getCreatedDate();
            this.creditedAmount = that.getCreditedAmount();
            this.currency = that.getCurrency();
            this.externalKey = that.getExternalKey();
            this.id = that.getId();
            this.isAuthVoided = that.isAuthVoided();
            this.paymentAttempts = that.getPaymentAttempts();
            this.paymentMethodId = that.getPaymentMethodId();
            this.paymentNumber = that.getPaymentNumber();
            this.purchasedAmount = that.getPurchasedAmount();
            this.refundedAmount = that.getRefundedAmount();
            this.transactions = that.getTransactions();
            this.updatedDate = that.getUpdatedDate();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PaymentImp build() {
            return new PaymentImp(this.validate());
        }
    }
}
