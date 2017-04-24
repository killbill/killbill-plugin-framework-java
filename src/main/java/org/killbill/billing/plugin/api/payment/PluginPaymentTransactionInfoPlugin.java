/*
 * Copyright 2014 Groupon, Inc
 * Copyright 2014 The Billing Project, LLC
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
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.api.TransactionType;
import org.killbill.billing.payment.plugin.api.PaymentPluginStatus;
import org.killbill.billing.payment.plugin.api.PaymentTransactionInfoPlugin;

public class PluginPaymentTransactionInfoPlugin implements PaymentTransactionInfoPlugin {

    protected final UUID kbPaymentId;
    protected final UUID kbTransactionPaymentPaymentId;
    protected final TransactionType transactionType;
    protected final BigDecimal amount;
    protected final Currency currency;
    protected final PaymentPluginStatus pluginStatus;
    protected final String gatewayError;
    protected final String gatewayErrorCode;
    protected final String firstPaymentReferenceId;
    protected final String secondPaymentReferenceId;
    protected final DateTime createdDate;
    protected final DateTime effectiveDate;
    protected final List<PluginProperty> properties;

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
        this.kbPaymentId = kbPaymentId;
        this.kbTransactionPaymentPaymentId = kbTransactionPaymentPaymentId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.currency = currency;
        this.pluginStatus = pluginStatus;
        this.gatewayError = gatewayError;
        this.gatewayErrorCode = gatewayErrorCode;
        this.firstPaymentReferenceId = firstPaymentReferenceId;
        this.secondPaymentReferenceId = secondPaymentReferenceId;
        this.createdDate = createdDate;
        this.effectiveDate = effectiveDate;
        this.properties = properties;
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
}
