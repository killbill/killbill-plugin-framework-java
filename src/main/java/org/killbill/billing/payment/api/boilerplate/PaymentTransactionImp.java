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
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.payment.api.PaymentTransaction;
import org.killbill.billing.payment.api.TransactionStatus;
import org.killbill.billing.payment.api.TransactionType;
import org.killbill.billing.payment.plugin.api.PaymentTransactionInfoPlugin;

@JsonDeserialize( builder = PaymentTransactionImp.Builder.class )
public class PaymentTransactionImp implements PaymentTransaction {

    protected BigDecimal amount;
    protected DateTime createdDate;
    protected Currency currency;
    protected DateTime effectiveDate;
    protected String externalKey;
    protected String gatewayErrorCode;
    protected String gatewayErrorMsg;
    protected UUID id;
    protected UUID paymentId;
    protected PaymentTransactionInfoPlugin paymentInfoPlugin;
    protected BigDecimal processedAmount;
    protected Currency processedCurrency;
    protected TransactionStatus transactionStatus;
    protected TransactionType transactionType;
    protected DateTime updatedDate;

    public PaymentTransactionImp(final PaymentTransactionImp that) {
        this.amount = that.amount;
        this.createdDate = that.createdDate;
        this.currency = that.currency;
        this.effectiveDate = that.effectiveDate;
        this.externalKey = that.externalKey;
        this.gatewayErrorCode = that.gatewayErrorCode;
        this.gatewayErrorMsg = that.gatewayErrorMsg;
        this.id = that.id;
        this.paymentId = that.paymentId;
        this.paymentInfoPlugin = that.paymentInfoPlugin;
        this.processedAmount = that.processedAmount;
        this.processedCurrency = that.processedCurrency;
        this.transactionStatus = that.transactionStatus;
        this.transactionType = that.transactionType;
        this.updatedDate = that.updatedDate;
    }
    protected PaymentTransactionImp(final PaymentTransactionImp.Builder<?> builder) {
        this.amount = builder.amount;
        this.createdDate = builder.createdDate;
        this.currency = builder.currency;
        this.effectiveDate = builder.effectiveDate;
        this.externalKey = builder.externalKey;
        this.gatewayErrorCode = builder.gatewayErrorCode;
        this.gatewayErrorMsg = builder.gatewayErrorMsg;
        this.id = builder.id;
        this.paymentId = builder.paymentId;
        this.paymentInfoPlugin = builder.paymentInfoPlugin;
        this.processedAmount = builder.processedAmount;
        this.processedCurrency = builder.processedCurrency;
        this.transactionStatus = builder.transactionStatus;
        this.transactionType = builder.transactionType;
        this.updatedDate = builder.updatedDate;
    }
    protected PaymentTransactionImp() { }
    @Override
    public BigDecimal getAmount() {
        return this.amount;
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
    public DateTime getEffectiveDate() {
        return this.effectiveDate;
    }
    @Override
    public String getExternalKey() {
        return this.externalKey;
    }
    @Override
    public String getGatewayErrorCode() {
        return this.gatewayErrorCode;
    }
    @Override
    public String getGatewayErrorMsg() {
        return this.gatewayErrorMsg;
    }
    @Override
    public UUID getId() {
        return this.id;
    }
    @Override
    public UUID getPaymentId() {
        return this.paymentId;
    }
    @Override
    public PaymentTransactionInfoPlugin getPaymentInfoPlugin() {
        return this.paymentInfoPlugin;
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
    public TransactionStatus getTransactionStatus() {
        return this.transactionStatus;
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
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PaymentTransactionImp that = (PaymentTransactionImp) o;
        if( ( this.amount != null ) ? ( 0 != this.amount.compareTo(that.amount) ) : ( that.amount != null ) ) {
            return false;
        }
        if( ( this.createdDate != null ) ? ( 0 != this.createdDate.compareTo(that.createdDate) ) : ( that.createdDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.currency, that.currency) ) {
            return false;
        }
        if( ( this.effectiveDate != null ) ? ( 0 != this.effectiveDate.compareTo(that.effectiveDate) ) : ( that.effectiveDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.externalKey, that.externalKey) ) {
            return false;
        }
        if( !Objects.equals(this.gatewayErrorCode, that.gatewayErrorCode) ) {
            return false;
        }
        if( !Objects.equals(this.gatewayErrorMsg, that.gatewayErrorMsg) ) {
            return false;
        }
        if( !Objects.equals(this.id, that.id) ) {
            return false;
        }
        if( !Objects.equals(this.paymentId, that.paymentId) ) {
            return false;
        }
        if( !Objects.equals(this.paymentInfoPlugin, that.paymentInfoPlugin) ) {
            return false;
        }
        if( ( this.processedAmount != null ) ? ( 0 != this.processedAmount.compareTo(that.processedAmount) ) : ( that.processedAmount != null ) ) {
            return false;
        }
        if( !Objects.equals(this.processedCurrency, that.processedCurrency) ) {
            return false;
        }
        if( !Objects.equals(this.transactionStatus, that.transactionStatus) ) {
            return false;
        }
        if( !Objects.equals(this.transactionType, that.transactionType) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.amount);
        result = ( 31 * result ) + Objects.hashCode(this.createdDate);
        result = ( 31 * result ) + Objects.hashCode(this.currency);
        result = ( 31 * result ) + Objects.hashCode(this.effectiveDate);
        result = ( 31 * result ) + Objects.hashCode(this.externalKey);
        result = ( 31 * result ) + Objects.hashCode(this.gatewayErrorCode);
        result = ( 31 * result ) + Objects.hashCode(this.gatewayErrorMsg);
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.paymentId);
        result = ( 31 * result ) + Objects.hashCode(this.paymentInfoPlugin);
        result = ( 31 * result ) + Objects.hashCode(this.processedAmount);
        result = ( 31 * result ) + Objects.hashCode(this.processedCurrency);
        result = ( 31 * result ) + Objects.hashCode(this.transactionStatus);
        result = ( 31 * result ) + Objects.hashCode(this.transactionType);
        result = ( 31 * result ) + Objects.hashCode(this.updatedDate);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("amount=").append(this.amount);
        sb.append(", ");
        sb.append("createdDate=").append(this.createdDate);
        sb.append(", ");
        sb.append("currency=").append(this.currency);
        sb.append(", ");
        sb.append("effectiveDate=").append(this.effectiveDate);
        sb.append(", ");
        sb.append("externalKey=");
        if( this.externalKey == null ) {
            sb.append(this.externalKey);
        }else{
            sb.append("'").append(this.externalKey).append("'");
        }
        sb.append(", ");
        sb.append("gatewayErrorCode=");
        if( this.gatewayErrorCode == null ) {
            sb.append(this.gatewayErrorCode);
        }else{
            sb.append("'").append(this.gatewayErrorCode).append("'");
        }
        sb.append(", ");
        sb.append("gatewayErrorMsg=");
        if( this.gatewayErrorMsg == null ) {
            sb.append(this.gatewayErrorMsg);
        }else{
            sb.append("'").append(this.gatewayErrorMsg).append("'");
        }
        sb.append(", ");
        sb.append("id=").append(this.id);
        sb.append(", ");
        sb.append("paymentId=").append(this.paymentId);
        sb.append(", ");
        sb.append("paymentInfoPlugin=").append(this.paymentInfoPlugin);
        sb.append(", ");
        sb.append("processedAmount=").append(this.processedAmount);
        sb.append(", ");
        sb.append("processedCurrency=").append(this.processedCurrency);
        sb.append(", ");
        sb.append("transactionStatus=").append(this.transactionStatus);
        sb.append(", ");
        sb.append("transactionType=").append(this.transactionType);
        sb.append(", ");
        sb.append("updatedDate=").append(this.updatedDate);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PaymentTransactionImp.Builder<T>> {

        protected BigDecimal amount;
        protected DateTime createdDate;
        protected Currency currency;
        protected DateTime effectiveDate;
        protected String externalKey;
        protected String gatewayErrorCode;
        protected String gatewayErrorMsg;
        protected UUID id;
        protected UUID paymentId;
        protected PaymentTransactionInfoPlugin paymentInfoPlugin;
        protected BigDecimal processedAmount;
        protected Currency processedCurrency;
        protected TransactionStatus transactionStatus;
        protected TransactionType transactionType;
        protected DateTime updatedDate;

        public Builder() { }
        public Builder(final Builder that) {
            this.amount = that.amount;
            this.createdDate = that.createdDate;
            this.currency = that.currency;
            this.effectiveDate = that.effectiveDate;
            this.externalKey = that.externalKey;
            this.gatewayErrorCode = that.gatewayErrorCode;
            this.gatewayErrorMsg = that.gatewayErrorMsg;
            this.id = that.id;
            this.paymentId = that.paymentId;
            this.paymentInfoPlugin = that.paymentInfoPlugin;
            this.processedAmount = that.processedAmount;
            this.processedCurrency = that.processedCurrency;
            this.transactionStatus = that.transactionStatus;
            this.transactionType = that.transactionType;
            this.updatedDate = that.updatedDate;
        }
        public T withAmount(final BigDecimal amount) {
            this.amount = amount;
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
        public T withEffectiveDate(final DateTime effectiveDate) {
            this.effectiveDate = effectiveDate;
            return (T) this;
        }
        public T withExternalKey(final String externalKey) {
            this.externalKey = externalKey;
            return (T) this;
        }
        public T withGatewayErrorCode(final String gatewayErrorCode) {
            this.gatewayErrorCode = gatewayErrorCode;
            return (T) this;
        }
        public T withGatewayErrorMsg(final String gatewayErrorMsg) {
            this.gatewayErrorMsg = gatewayErrorMsg;
            return (T) this;
        }
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withPaymentId(final UUID paymentId) {
            this.paymentId = paymentId;
            return (T) this;
        }
        public T withPaymentInfoPlugin(final PaymentTransactionInfoPlugin paymentInfoPlugin) {
            this.paymentInfoPlugin = paymentInfoPlugin;
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
        public T withTransactionStatus(final TransactionStatus transactionStatus) {
            this.transactionStatus = transactionStatus;
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
        public T source(final PaymentTransaction that) {
            this.amount = that.getAmount();
            this.createdDate = that.getCreatedDate();
            this.currency = that.getCurrency();
            this.effectiveDate = that.getEffectiveDate();
            this.externalKey = that.getExternalKey();
            this.gatewayErrorCode = that.getGatewayErrorCode();
            this.gatewayErrorMsg = that.getGatewayErrorMsg();
            this.id = that.getId();
            this.paymentId = that.getPaymentId();
            this.paymentInfoPlugin = that.getPaymentInfoPlugin();
            this.processedAmount = that.getProcessedAmount();
            this.processedCurrency = that.getProcessedCurrency();
            this.transactionStatus = that.getTransactionStatus();
            this.transactionType = that.getTransactionType();
            this.updatedDate = that.getUpdatedDate();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PaymentTransactionImp build() {
            return new PaymentTransactionImp(this.validate());
        }
    }
}
