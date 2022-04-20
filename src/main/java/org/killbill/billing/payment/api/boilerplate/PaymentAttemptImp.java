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
import org.killbill.billing.payment.api.PaymentAttempt;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.api.TransactionType;

@JsonDeserialize( builder = PaymentAttemptImp.Builder.class )
public class PaymentAttemptImp implements PaymentAttempt {

    private static final long serialVersionUID = 0x6754E4EB5E9F551L;

    protected UUID accountId;
    protected BigDecimal amount;
    protected DateTime createdDate;
    protected Currency currency;
    protected DateTime effectiveDate;
    protected UUID id;
    protected String paymentExternalKey;
    protected UUID paymentMethodId;
    protected String pluginName;
    protected List<PluginProperty> pluginProperties;
    protected String stateName;
    protected String transactionExternalKey;
    protected UUID transactionId;
    protected TransactionType transactionType;
    protected DateTime updatedDate;

    public PaymentAttemptImp(final PaymentAttemptImp that) {
        this.accountId = that.accountId;
        this.amount = that.amount;
        this.createdDate = that.createdDate;
        this.currency = that.currency;
        this.effectiveDate = that.effectiveDate;
        this.id = that.id;
        this.paymentExternalKey = that.paymentExternalKey;
        this.paymentMethodId = that.paymentMethodId;
        this.pluginName = that.pluginName;
        this.pluginProperties = that.pluginProperties;
        this.stateName = that.stateName;
        this.transactionExternalKey = that.transactionExternalKey;
        this.transactionId = that.transactionId;
        this.transactionType = that.transactionType;
        this.updatedDate = that.updatedDate;
    }
    protected PaymentAttemptImp(final PaymentAttemptImp.Builder<?> builder) {
        this.accountId = builder.accountId;
        this.amount = builder.amount;
        this.createdDate = builder.createdDate;
        this.currency = builder.currency;
        this.effectiveDate = builder.effectiveDate;
        this.id = builder.id;
        this.paymentExternalKey = builder.paymentExternalKey;
        this.paymentMethodId = builder.paymentMethodId;
        this.pluginName = builder.pluginName;
        this.pluginProperties = builder.pluginProperties;
        this.stateName = builder.stateName;
        this.transactionExternalKey = builder.transactionExternalKey;
        this.transactionId = builder.transactionId;
        this.transactionType = builder.transactionType;
        this.updatedDate = builder.updatedDate;
    }
    protected PaymentAttemptImp() { }
    @Override
    public UUID getAccountId() {
        return this.accountId;
    }
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
    public UUID getId() {
        return this.id;
    }
    @Override
    public String getPaymentExternalKey() {
        return this.paymentExternalKey;
    }
    @Override
    public UUID getPaymentMethodId() {
        return this.paymentMethodId;
    }
    @Override
    public String getPluginName() {
        return this.pluginName;
    }
    @Override
    public List<PluginProperty> getPluginProperties() {
        return this.pluginProperties;
    }
    @Override
    public String getStateName() {
        return this.stateName;
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
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PaymentAttemptImp that = (PaymentAttemptImp) o;
        if( !Objects.equals(this.accountId, that.accountId) ) {
            return false;
        }
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
        if( !Objects.equals(this.id, that.id) ) {
            return false;
        }
        if( !Objects.equals(this.paymentExternalKey, that.paymentExternalKey) ) {
            return false;
        }
        if( !Objects.equals(this.paymentMethodId, that.paymentMethodId) ) {
            return false;
        }
        if( !Objects.equals(this.pluginName, that.pluginName) ) {
            return false;
        }
        if( !Objects.equals(this.pluginProperties, that.pluginProperties) ) {
            return false;
        }
        if( !Objects.equals(this.stateName, that.stateName) ) {
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
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.accountId);
        result = ( 31 * result ) + Objects.hashCode(this.amount);
        result = ( 31 * result ) + Objects.hashCode(this.createdDate);
        result = ( 31 * result ) + Objects.hashCode(this.currency);
        result = ( 31 * result ) + Objects.hashCode(this.effectiveDate);
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.paymentExternalKey);
        result = ( 31 * result ) + Objects.hashCode(this.paymentMethodId);
        result = ( 31 * result ) + Objects.hashCode(this.pluginName);
        result = ( 31 * result ) + Objects.hashCode(this.pluginProperties);
        result = ( 31 * result ) + Objects.hashCode(this.stateName);
        result = ( 31 * result ) + Objects.hashCode(this.transactionExternalKey);
        result = ( 31 * result ) + Objects.hashCode(this.transactionId);
        result = ( 31 * result ) + Objects.hashCode(this.transactionType);
        result = ( 31 * result ) + Objects.hashCode(this.updatedDate);
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
        sb.append("createdDate=").append(this.createdDate);
        sb.append(", ");
        sb.append("currency=").append(this.currency);
        sb.append(", ");
        sb.append("effectiveDate=").append(this.effectiveDate);
        sb.append(", ");
        sb.append("id=").append(this.id);
        sb.append(", ");
        sb.append("paymentExternalKey=");
        if( this.paymentExternalKey == null ) {
            sb.append(this.paymentExternalKey);
        }else{
            sb.append("'").append(this.paymentExternalKey).append("'");
        }
        sb.append(", ");
        sb.append("paymentMethodId=").append(this.paymentMethodId);
        sb.append(", ");
        sb.append("pluginName=");
        if( this.pluginName == null ) {
            sb.append(this.pluginName);
        }else{
            sb.append("'").append(this.pluginName).append("'");
        }
        sb.append(", ");
        sb.append("pluginProperties=").append(this.pluginProperties);
        sb.append(", ");
        sb.append("stateName=");
        if( this.stateName == null ) {
            sb.append(this.stateName);
        }else{
            sb.append("'").append(this.stateName).append("'");
        }
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
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PaymentAttemptImp.Builder<T>> {

        protected UUID accountId;
        protected BigDecimal amount;
        protected DateTime createdDate;
        protected Currency currency;
        protected DateTime effectiveDate;
        protected UUID id;
        protected String paymentExternalKey;
        protected UUID paymentMethodId;
        protected String pluginName;
        protected List<PluginProperty> pluginProperties;
        protected String stateName;
        protected String transactionExternalKey;
        protected UUID transactionId;
        protected TransactionType transactionType;
        protected DateTime updatedDate;

        public Builder() { }
        public Builder(final Builder that) {
            this.accountId = that.accountId;
            this.amount = that.amount;
            this.createdDate = that.createdDate;
            this.currency = that.currency;
            this.effectiveDate = that.effectiveDate;
            this.id = that.id;
            this.paymentExternalKey = that.paymentExternalKey;
            this.paymentMethodId = that.paymentMethodId;
            this.pluginName = that.pluginName;
            this.pluginProperties = that.pluginProperties;
            this.stateName = that.stateName;
            this.transactionExternalKey = that.transactionExternalKey;
            this.transactionId = that.transactionId;
            this.transactionType = that.transactionType;
            this.updatedDate = that.updatedDate;
        }
        public T withAccountId(final UUID accountId) {
            this.accountId = accountId;
            return (T) this;
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
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withPaymentExternalKey(final String paymentExternalKey) {
            this.paymentExternalKey = paymentExternalKey;
            return (T) this;
        }
        public T withPaymentMethodId(final UUID paymentMethodId) {
            this.paymentMethodId = paymentMethodId;
            return (T) this;
        }
        public T withPluginName(final String pluginName) {
            this.pluginName = pluginName;
            return (T) this;
        }
        public T withPluginProperties(final List<PluginProperty> pluginProperties) {
            this.pluginProperties = pluginProperties;
            return (T) this;
        }
        public T withStateName(final String stateName) {
            this.stateName = stateName;
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
        public T source(final PaymentAttempt that) {
            this.accountId = that.getAccountId();
            this.amount = that.getAmount();
            this.createdDate = that.getCreatedDate();
            this.currency = that.getCurrency();
            this.effectiveDate = that.getEffectiveDate();
            this.id = that.getId();
            this.paymentExternalKey = that.getPaymentExternalKey();
            this.paymentMethodId = that.getPaymentMethodId();
            this.pluginName = that.getPluginName();
            this.pluginProperties = that.getPluginProperties();
            this.stateName = that.getStateName();
            this.transactionExternalKey = that.getTransactionExternalKey();
            this.transactionId = that.getTransactionId();
            this.transactionType = that.getTransactionType();
            this.updatedDate = that.getUpdatedDate();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PaymentAttemptImp build() {
            return new PaymentAttemptImp(this.validate());
        }
    }
}
