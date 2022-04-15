/*
 * Copyright 2014-2020 Groupon, Inc
 * Copyright 2020-2020 Equinix, Inc
 * Copyright 2014-2020 The Billing Project, LLC
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

package org.killbill.billing.plugin.api.payment;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.api.TransactionType;
import org.killbill.billing.payment.plugin.api.PaymentPluginStatus;
import org.killbill.billing.payment.plugin.api.PaymentTransactionInfoPlugin;
import org.killbill.billing.payment.plugin.api.boilerplate.PaymentTransactionInfoPluginImp;

@JsonDeserialize( builder = PluginPaymentTransactionInfoPlugin.Builder.class )
public class PluginPaymentTransactionInfoPlugin implements PaymentTransactionInfoPlugin {

    final protected UUID kbPaymentId;
    final protected UUID kbTransactionPaymentPaymentId;   // non-conformant name, expected 'kbTransactionPaymentId'
    final protected TransactionType transactionType;
    final protected BigDecimal amount;
    final protected Currency currency;
    final protected PaymentPluginStatus pluginStatus;     // non-conformant name, expected 'status'
    final protected String gatewayError;
    final protected String gatewayErrorCode;
    final protected String firstPaymentReferenceId;
    final protected String secondPaymentReferenceId;
    final protected DateTime createdDate;
    final protected DateTime effectiveDate;
    final protected List<PluginProperty> properties;

    public PluginPaymentTransactionInfoPlugin(final UUID kbPaymentId,
            final UUID kbTransactionPaymentPaymentId,
            final TransactionType transactionType,
            final BigDecimal amount,
            final Currency currency,
            final PaymentPluginStatus pluginStatus,
            final String gatewayError,
            final String gatewayErrorCode,
            final String firstPaymentReferenceId,
            final String secondPaymentReferenceId,
            final DateTime createdDate,
            final DateTime effectiveDate,
            final List<PluginProperty> properties) {

        this(new Builder<>()
                .withKbPaymentId(kbPaymentId)
                .withKbTransactionPaymentId(kbTransactionPaymentPaymentId)
                .withTransactionType(transactionType)
                .withAmount(amount)
                .withCurrency(currency)
                .withStatus(pluginStatus)
                .withGatewayError(gatewayError)
                .withGatewayErrorCode(gatewayErrorCode)
                .withFirstPaymentReferenceId(firstPaymentReferenceId)
                .withSecondPaymentReferenceId(secondPaymentReferenceId)
                .withCreatedDate(createdDate)
                .withEffectiveDate(effectiveDate)
                .withProperties(properties)
                .validate());
    }

    public PluginPaymentTransactionInfoPlugin(final PluginPaymentTransactionInfoPlugin that) {
        this.amount = that.amount;
        this.createdDate = that.createdDate;
        this.currency = that.currency;
        this.effectiveDate = that.effectiveDate;
        this.firstPaymentReferenceId = that.firstPaymentReferenceId;
        this.gatewayError = that.gatewayError;
        this.gatewayErrorCode = that.gatewayErrorCode;
        this.kbPaymentId = that.kbPaymentId;
        this.kbTransactionPaymentPaymentId = that.kbTransactionPaymentPaymentId;
        this.properties = that.properties;
        this.secondPaymentReferenceId = that.secondPaymentReferenceId;
        this.pluginStatus = that.pluginStatus;
        this.transactionType = that.transactionType;
    }

    protected PluginPaymentTransactionInfoPlugin(final PluginPaymentTransactionInfoPlugin.Builder<?> builder) {
        this.amount = builder.amount;
        this.createdDate = builder.createdDate;
        this.currency = builder.currency;
        this.effectiveDate = builder.effectiveDate;
        this.firstPaymentReferenceId = builder.firstPaymentReferenceId;
        this.gatewayError = builder.gatewayError;
        this.gatewayErrorCode = builder.gatewayErrorCode;
        this.kbPaymentId = builder.kbPaymentId;
        this.kbTransactionPaymentPaymentId = builder.kbTransactionPaymentId;
        this.properties = builder.properties;
        this.secondPaymentReferenceId = builder.secondPaymentReferenceId;
        this.pluginStatus = builder.status;
        this.transactionType = builder.transactionType;
    }

    @Override
    public UUID getKbPaymentId() {
        return kbPaymentId;
    }

    @Override
    public UUID getKbTransactionPaymentId() {
        return kbTransactionPaymentPaymentId;
    }

    @Override
    public TransactionType getTransactionType() {
        return transactionType;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    @Override
    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public DateTime getEffectiveDate() {
        return effectiveDate;
    }

    @Override
    public PaymentPluginStatus getStatus() {
        return pluginStatus;
    }

    @Override
    public String getGatewayError() {
        return gatewayError;
    }

    @Override
    public String getGatewayErrorCode() {
        return gatewayErrorCode;
    }

    @Override
    public String getFirstPaymentReferenceId() {
        return firstPaymentReferenceId;
    }

    @Override
    public String getSecondPaymentReferenceId() {
        return secondPaymentReferenceId;
    }

    @Override
    public List<PluginProperty> getProperties() {
        return properties;
    }

    /*
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PluginPaymentTransactionInfoPlugin{");
        sb.append("kbPaymentId=").append(kbPaymentId);
        sb.append(", kbTransactionPaymentPaymentId=").append(kbTransactionPaymentPaymentId);
        sb.append(", transactionType=").append(transactionType);
        sb.append(", amount=").append(amount);
        sb.append(", currency=").append(currency);
        sb.append(", pluginStatus=").append(pluginStatus);
        sb.append(", gatewayError='").append(gatewayError).append('\'');
        sb.append(", gatewayErrorCode='").append(gatewayErrorCode).append('\'');
        sb.append(", firstPaymentReferenceId='").append(firstPaymentReferenceId).append('\'');
        sb.append(", secondPaymentReferenceId='").append(secondPaymentReferenceId).append('\'');
        sb.append(", createdDate=").append(createdDate);
        sb.append(", effectiveDate=").append(effectiveDate);
        sb.append(", properties=").append(properties);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PluginPaymentTransactionInfoPlugin that = (PluginPaymentTransactionInfoPlugin) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) {
            return false;
        }
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) {
            return false;
        }
        if (currency != that.currency) {
            return false;
        }
        if (effectiveDate != null ? !effectiveDate.equals(that.effectiveDate) : that.effectiveDate != null) {
            return false;
        }
        if (firstPaymentReferenceId != null ? !firstPaymentReferenceId.equals(that.firstPaymentReferenceId) : that.firstPaymentReferenceId != null) {
            return false;
        }
        if (gatewayError != null ? !gatewayError.equals(that.gatewayError) : that.gatewayError != null) {
            return false;
        }
        if (gatewayErrorCode != null ? !gatewayErrorCode.equals(that.gatewayErrorCode) : that.gatewayErrorCode != null) {
            return false;
        }
        if (kbPaymentId != null ? !kbPaymentId.equals(that.kbPaymentId) : that.kbPaymentId != null) {
            return false;
        }
        if (kbTransactionPaymentPaymentId != null ? !kbTransactionPaymentPaymentId.equals(that.kbTransactionPaymentPaymentId) : that.kbTransactionPaymentPaymentId != null) {
            return false;
        }
        if (pluginStatus != that.pluginStatus) {
            return false;
        }
        if (properties != null ? !properties.equals(that.properties) : that.properties != null) {
            return false;
        }
        if (secondPaymentReferenceId != null ? !secondPaymentReferenceId.equals(that.secondPaymentReferenceId) : that.secondPaymentReferenceId != null) {
            return false;
        }
        if (transactionType != that.transactionType) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = kbPaymentId != null ? kbPaymentId.hashCode() : 0;
        result = 31 * result + (kbTransactionPaymentPaymentId != null ? kbTransactionPaymentPaymentId.hashCode() : 0);
        result = 31 * result + (transactionType != null ? transactionType.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (pluginStatus != null ? pluginStatus.hashCode() : 0);
        result = 31 * result + (gatewayError != null ? gatewayError.hashCode() : 0);
        result = 31 * result + (gatewayErrorCode != null ? gatewayErrorCode.hashCode() : 0);
        result = 31 * result + (firstPaymentReferenceId != null ? firstPaymentReferenceId.hashCode() : 0);
        result = 31 * result + (secondPaymentReferenceId != null ? secondPaymentReferenceId.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }
    */

    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PluginPaymentTransactionInfoPlugin that = (PluginPaymentTransactionInfoPlugin) o;
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
        if( !Objects.equals(this.firstPaymentReferenceId, that.firstPaymentReferenceId) ) {
            return false;
        }
        if( !Objects.equals(this.gatewayError, that.gatewayError) ) {
            return false;
        }
        if( !Objects.equals(this.gatewayErrorCode, that.gatewayErrorCode) ) {
            return false;
        }
        if( !Objects.equals(this.kbPaymentId, that.kbPaymentId) ) {
            return false;
        }
        if( !Objects.equals(this.kbTransactionPaymentPaymentId, that.kbTransactionPaymentPaymentId) ) {
            return false;
        }
        if( !Objects.equals(this.properties, that.properties) ) {
            return false;
        }
        if( !Objects.equals(this.secondPaymentReferenceId, that.secondPaymentReferenceId) ) {
            return false;
        }
        if( !Objects.equals(this.pluginStatus, that.pluginStatus) ) {
            return false;
        }
        if( !Objects.equals(this.transactionType, that.transactionType) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.firstPaymentReferenceId);
        result = ( 31 * result ) + Objects.hashCode(this.gatewayError);
        result = ( 31 * result ) + Objects.hashCode(this.gatewayErrorCode);
        result = ( 31 * result ) + Objects.hashCode(this.kbPaymentId);
        result = ( 31 * result ) + Objects.hashCode(this.kbTransactionPaymentPaymentId);
        result = ( 31 * result ) + Objects.hashCode(this.properties);
        result = ( 31 * result ) + Objects.hashCode(this.secondPaymentReferenceId);
        result = ( 31 * result ) + Objects.hashCode(this.pluginStatus);
        result = ( 31 * result ) + Objects.hashCode(this.transactionType);
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
        sb.append("firstPaymentReferenceId=");
        if( this.firstPaymentReferenceId == null ) {
            sb.append(this.firstPaymentReferenceId);
        }else{
            sb.append("'").append(this.firstPaymentReferenceId).append("'");
        }
        sb.append(", ");
        sb.append("gatewayError=");
        if( this.gatewayError == null ) {
            sb.append(this.gatewayError);
        }else{
            sb.append("'").append(this.gatewayError).append("'");
        }
        sb.append(", ");
        sb.append("gatewayErrorCode=");
        if( this.gatewayErrorCode == null ) {
            sb.append(this.gatewayErrorCode);
        }else{
            sb.append("'").append(this.gatewayErrorCode).append("'");
        }
        sb.append(", ");
        sb.append("kbPaymentId=").append(this.kbPaymentId);
        sb.append(", ");
        sb.append("kbTransactionPaymentId=").append(this.kbTransactionPaymentPaymentId);
        sb.append(", ");
        sb.append("properties=").append(this.properties);
        sb.append(", ");
        sb.append("secondPaymentReferenceId=");
        if( this.secondPaymentReferenceId == null ) {
            sb.append(this.secondPaymentReferenceId);
        }else{
            sb.append("'").append(this.secondPaymentReferenceId).append("'");
        }
        sb.append(", ");
        sb.append("status=").append(this.pluginStatus);
        sb.append(", ");
        sb.append("transactionType=").append(this.transactionType);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PluginPaymentTransactionInfoPlugin.Builder<T>> {

        protected BigDecimal amount;
        protected DateTime createdDate;
        protected Currency currency;
        protected DateTime effectiveDate;
        protected String firstPaymentReferenceId;
        protected String gatewayError;
        protected String gatewayErrorCode;
        protected UUID kbPaymentId;
        protected UUID kbTransactionPaymentId;
        protected List<PluginProperty> properties;
        protected String secondPaymentReferenceId;
        protected PaymentPluginStatus status;
        protected TransactionType transactionType;

        public Builder() { }

        public Builder(final Builder that) {
            this.amount = that.amount;
            this.createdDate = that.createdDate;
            this.currency = that.currency;
            this.effectiveDate = that.effectiveDate;
            this.firstPaymentReferenceId = that.firstPaymentReferenceId;
            this.gatewayError = that.gatewayError;
            this.gatewayErrorCode = that.gatewayErrorCode;
            this.kbPaymentId = that.kbPaymentId;
            this.kbTransactionPaymentId = that.kbTransactionPaymentId;
            this.properties = that.properties;
            this.secondPaymentReferenceId = that.secondPaymentReferenceId;
            this.status = that.status;
            this.transactionType = that.transactionType;
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

        public T withFirstPaymentReferenceId(final String firstPaymentReferenceId) {
            this.firstPaymentReferenceId = firstPaymentReferenceId;
            return (T) this;
        }

        public T withGatewayError(final String gatewayError) {
            this.gatewayError = gatewayError;
            return (T) this;
        }

        public T withGatewayErrorCode(final String gatewayErrorCode) {
            this.gatewayErrorCode = gatewayErrorCode;
            return (T) this;
        }

        public T withKbPaymentId(final UUID kbPaymentId) {
            this.kbPaymentId = kbPaymentId;
            return (T) this;
        }

        public T withKbTransactionPaymentId(final UUID kbTransactionPaymentId) {
            this.kbTransactionPaymentId = kbTransactionPaymentId;
            return (T) this;
        }

        public T withProperties(final List<PluginProperty> properties) {
            this.properties = properties;
            return (T) this;
        }

        public T withSecondPaymentReferenceId(final String secondPaymentReferenceId) {
            this.secondPaymentReferenceId = secondPaymentReferenceId;
            return (T) this;
        }

        public T withStatus(final PaymentPluginStatus status) {
            this.status = status;
            return (T) this;
        }

        public T withTransactionType(final TransactionType transactionType) {
            this.transactionType = transactionType;
            return (T) this;
        }

        public T source(final PaymentTransactionInfoPlugin that) {
            this.amount = that.getAmount();
            this.createdDate = that.getCreatedDate();
            this.currency = that.getCurrency();
            this.effectiveDate = that.getEffectiveDate();
            this.firstPaymentReferenceId = that.getFirstPaymentReferenceId();
            this.gatewayError = that.getGatewayError();
            this.gatewayErrorCode = that.getGatewayErrorCode();
            this.kbPaymentId = that.getKbPaymentId();
            this.kbTransactionPaymentId = that.getKbTransactionPaymentId();
            this.properties = that.getProperties();
            this.secondPaymentReferenceId = that.getSecondPaymentReferenceId();
            this.status = that.getStatus();
            this.transactionType = that.getTransactionType();
            return (T) this;
        }

        protected Builder validate() {
            return this;
        }

        public PluginPaymentTransactionInfoPlugin build() {
            return new PluginPaymentTransactionInfoPlugin(this.validate());
        }
    }

}
