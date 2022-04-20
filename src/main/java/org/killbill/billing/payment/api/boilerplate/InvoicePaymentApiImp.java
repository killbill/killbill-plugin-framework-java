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
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.killbill.billing.account.api.Account;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.invoice.api.InvoicePayment;
import org.killbill.billing.payment.api.InvoicePaymentApi;
import org.killbill.billing.payment.api.PaymentApiException;
import org.killbill.billing.payment.api.PaymentOptions;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;

@JsonDeserialize( builder = InvoicePaymentApiImp.Builder.class )
public class InvoicePaymentApiImp implements InvoicePaymentApi {


    public InvoicePaymentApiImp(final InvoicePaymentApiImp that) {
    }
    protected InvoicePaymentApiImp(final InvoicePaymentApiImp.Builder<?> builder) {
    }
    protected InvoicePaymentApiImp() { }
    @Override
    public InvoicePayment createCreditForInvoicePayment(final boolean isAdjusted, final Map<UUID, BigDecimal> adjustments, final Account account, final UUID originalPaymentId, final UUID paymentMethodId, final UUID paymentId, final BigDecimal amount, final Currency currency, final DateTime effectiveDate, final String paymentExternalKey, final String paymentTransactionExternalKey, final Iterable<PluginProperty> properties, final PaymentOptions paymentOptions, final CallContext context) {
        throw new UnsupportedOperationException("createCreditForInvoicePayment(boolean, java.util.Map<java.util.UUID, java.math.BigDecimal>, org.killbill.billing.account.api.Account, java.util.UUID, java.util.UUID, java.util.UUID, java.math.BigDecimal, org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime, java.lang.String, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.payment.api.PaymentOptions, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public InvoicePayment createPurchaseForInvoicePayment(final Account account, final UUID invoiceId, final UUID paymentMethodId, final UUID paymentId, final BigDecimal amount, final Currency currency, final DateTime effectiveDate, final String paymentExternalKey, final String paymentTransactionExternalKey, final Iterable<PluginProperty> properties, final PaymentOptions paymentOptions, final CallContext context) {
        throw new UnsupportedOperationException("createPurchaseForInvoicePayment(org.killbill.billing.account.api.Account, java.util.UUID, java.util.UUID, java.util.UUID, java.math.BigDecimal, org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime, java.lang.String, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.payment.api.PaymentOptions, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<InvoicePayment> getInvoicePayments(final UUID paymentId, final TenantContext context) {
        throw new UnsupportedOperationException("getInvoicePayments(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public InvoicePayment getInvoicePayment(final UUID invoicePaymentId, final TenantContext context) {
        throw new UnsupportedOperationException("getInvoicePayment(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public InvoicePayment createChargebackReversalForInvoicePayment(final Account account, final UUID paymentId, final DateTime effectiveDate, final String paymentTransactionExternalKey, final Iterable<PluginProperty> properties, final PaymentOptions paymentOptions, final CallContext context) {
        throw new UnsupportedOperationException("createChargebackReversalForInvoicePayment(org.killbill.billing.account.api.Account, java.util.UUID, org.joda.time.DateTime, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.payment.api.PaymentOptions, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public InvoicePayment createRefundForInvoicePayment(final boolean isAdjusted, final Map<UUID, BigDecimal> adjustments, final Account account, final UUID paymentId, final BigDecimal amount, final Currency currency, final DateTime effectiveDate, final String paymentTransactionExternalKey, final Iterable<PluginProperty> properties, final PaymentOptions paymentOptions, final CallContext context) {
        throw new UnsupportedOperationException("createRefundForInvoicePayment(boolean, java.util.Map<java.util.UUID, java.math.BigDecimal>, org.killbill.billing.account.api.Account, java.util.UUID, java.math.BigDecimal, org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.payment.api.PaymentOptions, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<InvoicePayment> getInvoicePaymentsByAccount(final UUID accountId, final TenantContext context) {
        throw new UnsupportedOperationException("getInvoicePaymentsByAccount(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public InvoicePayment createChargebackForInvoicePayment(final Account account, final UUID paymentId, final BigDecimal amount, final Currency currency, final DateTime effectiveDate, final String paymentTransactionExternalKey, final Iterable<PluginProperty> properties, final PaymentOptions paymentOptions, final CallContext context) {
        throw new UnsupportedOperationException("createChargebackForInvoicePayment(org.killbill.billing.account.api.Account, java.util.UUID, java.math.BigDecimal, org.killbill.billing.catalog.api.Currency, org.joda.time.DateTime, java.lang.String, java.lang.Iterable<org.killbill.billing.payment.api.PluginProperty>, org.killbill.billing.payment.api.PaymentOptions, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
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
    public static class Builder<T extends InvoicePaymentApiImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final InvoicePaymentApi that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public InvoicePaymentApiImp build() {
            return new InvoicePaymentApiImp(this.validate());
        }
    }
}
