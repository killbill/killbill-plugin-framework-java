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

package org.killbill.billing.invoice.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.invoice.api.InvoicePayment;
import org.killbill.billing.invoice.api.InvoicePaymentType;

@JsonDeserialize( builder = InvoicePaymentImp.Builder.class )
public class InvoicePaymentImp implements InvoicePayment {

    private static final long serialVersionUID = 0xC42E4426E09BB7ADL;

    protected BigDecimal amount;
    protected DateTime createdDate;
    protected Currency currency;
    protected UUID id;
    protected UUID invoiceId;
    protected Boolean isSuccess;
    protected UUID linkedInvoicePaymentId;
    protected String paymentCookieId;
    protected DateTime paymentDate;
    protected UUID paymentId;
    protected Currency processedCurrency;
    protected InvoicePaymentType type;
    protected DateTime updatedDate;

    public InvoicePaymentImp(final InvoicePaymentImp that) {
        this.amount = that.amount;
        this.createdDate = that.createdDate;
        this.currency = that.currency;
        this.id = that.id;
        this.invoiceId = that.invoiceId;
        this.isSuccess = that.isSuccess;
        this.linkedInvoicePaymentId = that.linkedInvoicePaymentId;
        this.paymentCookieId = that.paymentCookieId;
        this.paymentDate = that.paymentDate;
        this.paymentId = that.paymentId;
        this.processedCurrency = that.processedCurrency;
        this.type = that.type;
        this.updatedDate = that.updatedDate;
    }
    protected InvoicePaymentImp(final InvoicePaymentImp.Builder<?> builder) {
        this.amount = builder.amount;
        this.createdDate = builder.createdDate;
        this.currency = builder.currency;
        this.id = builder.id;
        this.invoiceId = builder.invoiceId;
        this.isSuccess = builder.isSuccess;
        this.linkedInvoicePaymentId = builder.linkedInvoicePaymentId;
        this.paymentCookieId = builder.paymentCookieId;
        this.paymentDate = builder.paymentDate;
        this.paymentId = builder.paymentId;
        this.processedCurrency = builder.processedCurrency;
        this.type = builder.type;
        this.updatedDate = builder.updatedDate;
    }
    protected InvoicePaymentImp() { }
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
    public UUID getId() {
        return this.id;
    }
    @Override
    public UUID getInvoiceId() {
        return this.invoiceId;
    }
    @Override
    @JsonGetter("isSuccess")
    public Boolean isSuccess() {
        return this.isSuccess;
    }
    @Override
    public UUID getLinkedInvoicePaymentId() {
        return this.linkedInvoicePaymentId;
    }
    @Override
    public String getPaymentCookieId() {
        return this.paymentCookieId;
    }
    @Override
    public DateTime getPaymentDate() {
        return this.paymentDate;
    }
    @Override
    public UUID getPaymentId() {
        return this.paymentId;
    }
    @Override
    public Currency getProcessedCurrency() {
        return this.processedCurrency;
    }
    @Override
    public InvoicePaymentType getType() {
        return this.type;
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
        final InvoicePaymentImp that = (InvoicePaymentImp) o;
        if( ( this.amount != null ) ? ( 0 != this.amount.compareTo(that.amount) ) : ( that.amount != null ) ) {
            return false;
        }
        if( ( this.createdDate != null ) ? ( 0 != this.createdDate.compareTo(that.createdDate) ) : ( that.createdDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.currency, that.currency) ) {
            return false;
        }
        if( !Objects.equals(this.id, that.id) ) {
            return false;
        }
        if( !Objects.equals(this.invoiceId, that.invoiceId) ) {
            return false;
        }
        if( !Objects.equals(this.isSuccess, that.isSuccess) ) {
            return false;
        }
        if( !Objects.equals(this.linkedInvoicePaymentId, that.linkedInvoicePaymentId) ) {
            return false;
        }
        if( !Objects.equals(this.paymentCookieId, that.paymentCookieId) ) {
            return false;
        }
        if( ( this.paymentDate != null ) ? ( 0 != this.paymentDate.compareTo(that.paymentDate) ) : ( that.paymentDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.paymentId, that.paymentId) ) {
            return false;
        }
        if( !Objects.equals(this.processedCurrency, that.processedCurrency) ) {
            return false;
        }
        if( !Objects.equals(this.type, that.type) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.invoiceId);
        result = ( 31 * result ) + Objects.hashCode(this.isSuccess);
        result = ( 31 * result ) + Objects.hashCode(this.linkedInvoicePaymentId);
        result = ( 31 * result ) + Objects.hashCode(this.paymentCookieId);
        result = ( 31 * result ) + Objects.hashCode(this.paymentDate);
        result = ( 31 * result ) + Objects.hashCode(this.paymentId);
        result = ( 31 * result ) + Objects.hashCode(this.processedCurrency);
        result = ( 31 * result ) + Objects.hashCode(this.type);
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
        sb.append("id=").append(this.id);
        sb.append(", ");
        sb.append("invoiceId=").append(this.invoiceId);
        sb.append(", ");
        sb.append("isSuccess=").append(this.isSuccess);
        sb.append(", ");
        sb.append("linkedInvoicePaymentId=").append(this.linkedInvoicePaymentId);
        sb.append(", ");
        sb.append("paymentCookieId=");
        if( this.paymentCookieId == null ) {
            sb.append(this.paymentCookieId);
        }else{
            sb.append("'").append(this.paymentCookieId).append("'");
        }
        sb.append(", ");
        sb.append("paymentDate=").append(this.paymentDate);
        sb.append(", ");
        sb.append("paymentId=").append(this.paymentId);
        sb.append(", ");
        sb.append("processedCurrency=").append(this.processedCurrency);
        sb.append(", ");
        sb.append("type=").append(this.type);
        sb.append(", ");
        sb.append("updatedDate=").append(this.updatedDate);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends InvoicePaymentImp.Builder<T>> {

        protected BigDecimal amount;
        protected DateTime createdDate;
        protected Currency currency;
        protected UUID id;
        protected UUID invoiceId;
        protected Boolean isSuccess;
        protected UUID linkedInvoicePaymentId;
        protected String paymentCookieId;
        protected DateTime paymentDate;
        protected UUID paymentId;
        protected Currency processedCurrency;
        protected InvoicePaymentType type;
        protected DateTime updatedDate;

        public Builder() { }
        public Builder(final Builder that) {
            this.amount = that.amount;
            this.createdDate = that.createdDate;
            this.currency = that.currency;
            this.id = that.id;
            this.invoiceId = that.invoiceId;
            this.isSuccess = that.isSuccess;
            this.linkedInvoicePaymentId = that.linkedInvoicePaymentId;
            this.paymentCookieId = that.paymentCookieId;
            this.paymentDate = that.paymentDate;
            this.paymentId = that.paymentId;
            this.processedCurrency = that.processedCurrency;
            this.type = that.type;
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
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withInvoiceId(final UUID invoiceId) {
            this.invoiceId = invoiceId;
            return (T) this;
        }
        public T withIsSuccess(final Boolean isSuccess) {
            this.isSuccess = isSuccess;
            return (T) this;
        }
        public T withLinkedInvoicePaymentId(final UUID linkedInvoicePaymentId) {
            this.linkedInvoicePaymentId = linkedInvoicePaymentId;
            return (T) this;
        }
        public T withPaymentCookieId(final String paymentCookieId) {
            this.paymentCookieId = paymentCookieId;
            return (T) this;
        }
        public T withPaymentDate(final DateTime paymentDate) {
            this.paymentDate = paymentDate;
            return (T) this;
        }
        public T withPaymentId(final UUID paymentId) {
            this.paymentId = paymentId;
            return (T) this;
        }
        public T withProcessedCurrency(final Currency processedCurrency) {
            this.processedCurrency = processedCurrency;
            return (T) this;
        }
        public T withType(final InvoicePaymentType type) {
            this.type = type;
            return (T) this;
        }
        public T withUpdatedDate(final DateTime updatedDate) {
            this.updatedDate = updatedDate;
            return (T) this;
        }
        public T source(final InvoicePayment that) {
            this.amount = that.getAmount();
            this.createdDate = that.getCreatedDate();
            this.currency = that.getCurrency();
            this.id = that.getId();
            this.invoiceId = that.getInvoiceId();
            this.isSuccess = that.isSuccess();
            this.linkedInvoicePaymentId = that.getLinkedInvoicePaymentId();
            this.paymentCookieId = that.getPaymentCookieId();
            this.paymentDate = that.getPaymentDate();
            this.paymentId = that.getPaymentId();
            this.processedCurrency = that.getProcessedCurrency();
            this.type = that.getType();
            this.updatedDate = that.getUpdatedDate();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public InvoicePaymentImp build() {
            return new InvoicePaymentImp(this.validate());
        }
    }
}
