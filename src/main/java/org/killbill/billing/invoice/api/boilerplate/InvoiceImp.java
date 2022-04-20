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
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.invoice.api.InvoiceItem;
import org.killbill.billing.invoice.api.InvoicePayment;
import org.killbill.billing.invoice.api.InvoiceStatus;

@JsonDeserialize( builder = InvoiceImp.Builder.class )
public class InvoiceImp implements Invoice {

    protected UUID accountId;
    protected BigDecimal balance;
    protected BigDecimal chargedAmount;
    protected DateTime createdDate;
    protected BigDecimal creditedAmount;
    protected Currency currency;
    protected UUID id;
    protected LocalDate invoiceDate;
    protected List<InvoiceItem> invoiceItems;
    protected Integer invoiceNumber;
    protected boolean isMigrationInvoice;
    protected boolean isParentInvoice;
    protected int numberOfItems;
    protected int numberOfPayments;
    protected BigDecimal originalChargedAmount;
    protected BigDecimal paidAmount;
    protected UUID parentAccountId;
    protected UUID parentInvoiceId;
    protected List<InvoicePayment> payments;
    protected BigDecimal refundedAmount;
    protected InvoiceStatus status;
    protected LocalDate targetDate;
    protected List<String> trackingIds;
    protected DateTime updatedDate;

    public InvoiceImp(final InvoiceImp that) {
        this.accountId = that.accountId;
        this.balance = that.balance;
        this.chargedAmount = that.chargedAmount;
        this.createdDate = that.createdDate;
        this.creditedAmount = that.creditedAmount;
        this.currency = that.currency;
        this.id = that.id;
        this.invoiceDate = that.invoiceDate;
        this.invoiceItems = that.invoiceItems;
        this.invoiceNumber = that.invoiceNumber;
        this.isMigrationInvoice = that.isMigrationInvoice;
        this.isParentInvoice = that.isParentInvoice;
        this.numberOfItems = that.numberOfItems;
        this.numberOfPayments = that.numberOfPayments;
        this.originalChargedAmount = that.originalChargedAmount;
        this.paidAmount = that.paidAmount;
        this.parentAccountId = that.parentAccountId;
        this.parentInvoiceId = that.parentInvoiceId;
        this.payments = that.payments;
        this.refundedAmount = that.refundedAmount;
        this.status = that.status;
        this.targetDate = that.targetDate;
        this.trackingIds = that.trackingIds;
        this.updatedDate = that.updatedDate;
    }
    protected InvoiceImp(final InvoiceImp.Builder<?> builder) {
        this.accountId = builder.accountId;
        this.balance = builder.balance;
        this.chargedAmount = builder.chargedAmount;
        this.createdDate = builder.createdDate;
        this.creditedAmount = builder.creditedAmount;
        this.currency = builder.currency;
        this.id = builder.id;
        this.invoiceDate = builder.invoiceDate;
        this.invoiceItems = builder.invoiceItems;
        this.invoiceNumber = builder.invoiceNumber;
        this.isMigrationInvoice = builder.isMigrationInvoice;
        this.isParentInvoice = builder.isParentInvoice;
        this.numberOfItems = builder.numberOfItems;
        this.numberOfPayments = builder.numberOfPayments;
        this.originalChargedAmount = builder.originalChargedAmount;
        this.paidAmount = builder.paidAmount;
        this.parentAccountId = builder.parentAccountId;
        this.parentInvoiceId = builder.parentInvoiceId;
        this.payments = builder.payments;
        this.refundedAmount = builder.refundedAmount;
        this.status = builder.status;
        this.targetDate = builder.targetDate;
        this.trackingIds = builder.trackingIds;
        this.updatedDate = builder.updatedDate;
    }
    protected InvoiceImp() { }
    @Override
    public UUID getAccountId() {
        return this.accountId;
    }
    @Override
    public BigDecimal getBalance() {
        return this.balance;
    }
    @Override
    public BigDecimal getChargedAmount() {
        return this.chargedAmount;
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
    public UUID getId() {
        return this.id;
    }
    @Override
    public LocalDate getInvoiceDate() {
        return this.invoiceDate;
    }
    @Override
    public List<InvoiceItem> getInvoiceItems() {
        return this.invoiceItems;
    }
    @Override
    public Integer getInvoiceNumber() {
        return this.invoiceNumber;
    }
    @Override
    @JsonGetter("isMigrationInvoice")
    public boolean isMigrationInvoice() {
        return this.isMigrationInvoice;
    }
    @Override
    @JsonGetter("isParentInvoice")
    public boolean isParentInvoice() {
        return this.isParentInvoice;
    }
    @Override
    public int getNumberOfItems() {
        return this.numberOfItems;
    }
    @Override
    public int getNumberOfPayments() {
        return this.numberOfPayments;
    }
    @Override
    public BigDecimal getOriginalChargedAmount() {
        return this.originalChargedAmount;
    }
    @Override
    public BigDecimal getPaidAmount() {
        return this.paidAmount;
    }
    @Override
    public UUID getParentAccountId() {
        return this.parentAccountId;
    }
    @Override
    public UUID getParentInvoiceId() {
        return this.parentInvoiceId;
    }
    @Override
    public List<InvoicePayment> getPayments() {
        return this.payments;
    }
    @Override
    public BigDecimal getRefundedAmount() {
        return this.refundedAmount;
    }
    @Override
    public InvoiceStatus getStatus() {
        return this.status;
    }
    @Override
    public LocalDate getTargetDate() {
        return this.targetDate;
    }
    @Override
    public List<String> getTrackingIds() {
        return this.trackingIds;
    }
    @Override
    public DateTime getUpdatedDate() {
        return this.updatedDate;
    }
    @Override
    public boolean addInvoiceItem(final InvoiceItem item) {
        throw new UnsupportedOperationException("addInvoiceItem(org.killbill.billing.invoice.api.InvoiceItem) must be implemented.");
    }
    @Override
    public boolean addInvoiceItems(final Collection<InvoiceItem> items) {
        throw new UnsupportedOperationException("addInvoiceItems(java.util.Collection<org.killbill.billing.invoice.api.InvoiceItem>) must be implemented.");
    }
    @Override
    public boolean addPayment(final InvoicePayment payment) {
        throw new UnsupportedOperationException("addPayment(org.killbill.billing.invoice.api.InvoicePayment) must be implemented.");
    }
    @Override
    public boolean addTrackingIds(final Collection<String> trackingIds) {
        throw new UnsupportedOperationException("addTrackingIds(java.util.Collection<java.lang.String>) must be implemented.");
    }
    @Override
    public <T extends InvoiceItem> List<InvoiceItem> getInvoiceItems(final Class<T> clazz) {
        throw new UnsupportedOperationException("getInvoiceItems(java.lang.Class<java.lang.Object>) must be implemented.");
    }
    @Override
    public boolean addPayments(final Collection<InvoicePayment> payments) {
        throw new UnsupportedOperationException("addPayments(java.util.Collection<org.killbill.billing.invoice.api.InvoicePayment>) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final InvoiceImp that = (InvoiceImp) o;
        if( !Objects.equals(this.accountId, that.accountId) ) {
            return false;
        }
        if( ( this.balance != null ) ? ( 0 != this.balance.compareTo(that.balance) ) : ( that.balance != null ) ) {
            return false;
        }
        if( ( this.chargedAmount != null ) ? ( 0 != this.chargedAmount.compareTo(that.chargedAmount) ) : ( that.chargedAmount != null ) ) {
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
        if( !Objects.equals(this.id, that.id) ) {
            return false;
        }
        if( ( this.invoiceDate != null ) ? ( 0 != this.invoiceDate.compareTo(that.invoiceDate) ) : ( that.invoiceDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.invoiceItems, that.invoiceItems) ) {
            return false;
        }
        if( !Objects.equals(this.invoiceNumber, that.invoiceNumber) ) {
            return false;
        }
        if( this.isMigrationInvoice != that.isMigrationInvoice ) {
            return false;
        }
        if( this.isParentInvoice != that.isParentInvoice ) {
            return false;
        }
        if( this.numberOfItems != that.numberOfItems ) {
            return false;
        }
        if( this.numberOfPayments != that.numberOfPayments ) {
            return false;
        }
        if( ( this.originalChargedAmount != null ) ? ( 0 != this.originalChargedAmount.compareTo(that.originalChargedAmount) ) : ( that.originalChargedAmount != null ) ) {
            return false;
        }
        if( ( this.paidAmount != null ) ? ( 0 != this.paidAmount.compareTo(that.paidAmount) ) : ( that.paidAmount != null ) ) {
            return false;
        }
        if( !Objects.equals(this.parentAccountId, that.parentAccountId) ) {
            return false;
        }
        if( !Objects.equals(this.parentInvoiceId, that.parentInvoiceId) ) {
            return false;
        }
        if( !Objects.equals(this.payments, that.payments) ) {
            return false;
        }
        if( ( this.refundedAmount != null ) ? ( 0 != this.refundedAmount.compareTo(that.refundedAmount) ) : ( that.refundedAmount != null ) ) {
            return false;
        }
        if( !Objects.equals(this.status, that.status) ) {
            return false;
        }
        if( ( this.targetDate != null ) ? ( 0 != this.targetDate.compareTo(that.targetDate) ) : ( that.targetDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.trackingIds, that.trackingIds) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.balance);
        result = ( 31 * result ) + Objects.hashCode(this.chargedAmount);
        result = ( 31 * result ) + Objects.hashCode(this.createdDate);
        result = ( 31 * result ) + Objects.hashCode(this.creditedAmount);
        result = ( 31 * result ) + Objects.hashCode(this.currency);
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.invoiceDate);
        result = ( 31 * result ) + Objects.hashCode(this.invoiceItems);
        result = ( 31 * result ) + Objects.hashCode(this.invoiceNumber);
        result = ( 31 * result ) + Objects.hashCode(this.isMigrationInvoice);
        result = ( 31 * result ) + Objects.hashCode(this.isParentInvoice);
        result = ( 31 * result ) + Objects.hashCode(this.numberOfItems);
        result = ( 31 * result ) + Objects.hashCode(this.numberOfPayments);
        result = ( 31 * result ) + Objects.hashCode(this.originalChargedAmount);
        result = ( 31 * result ) + Objects.hashCode(this.paidAmount);
        result = ( 31 * result ) + Objects.hashCode(this.parentAccountId);
        result = ( 31 * result ) + Objects.hashCode(this.parentInvoiceId);
        result = ( 31 * result ) + Objects.hashCode(this.payments);
        result = ( 31 * result ) + Objects.hashCode(this.refundedAmount);
        result = ( 31 * result ) + Objects.hashCode(this.status);
        result = ( 31 * result ) + Objects.hashCode(this.targetDate);
        result = ( 31 * result ) + Objects.hashCode(this.trackingIds);
        result = ( 31 * result ) + Objects.hashCode(this.updatedDate);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("accountId=").append(this.accountId);
        sb.append(", ");
        sb.append("balance=").append(this.balance);
        sb.append(", ");
        sb.append("chargedAmount=").append(this.chargedAmount);
        sb.append(", ");
        sb.append("createdDate=").append(this.createdDate);
        sb.append(", ");
        sb.append("creditedAmount=").append(this.creditedAmount);
        sb.append(", ");
        sb.append("currency=").append(this.currency);
        sb.append(", ");
        sb.append("id=").append(this.id);
        sb.append(", ");
        sb.append("invoiceDate=").append(this.invoiceDate);
        sb.append(", ");
        sb.append("invoiceItems=").append(this.invoiceItems);
        sb.append(", ");
        sb.append("invoiceNumber=").append(this.invoiceNumber);
        sb.append(", ");
        sb.append("isMigrationInvoice=").append(this.isMigrationInvoice);
        sb.append(", ");
        sb.append("isParentInvoice=").append(this.isParentInvoice);
        sb.append(", ");
        sb.append("numberOfItems=").append(this.numberOfItems);
        sb.append(", ");
        sb.append("numberOfPayments=").append(this.numberOfPayments);
        sb.append(", ");
        sb.append("originalChargedAmount=").append(this.originalChargedAmount);
        sb.append(", ");
        sb.append("paidAmount=").append(this.paidAmount);
        sb.append(", ");
        sb.append("parentAccountId=").append(this.parentAccountId);
        sb.append(", ");
        sb.append("parentInvoiceId=").append(this.parentInvoiceId);
        sb.append(", ");
        sb.append("payments=").append(this.payments);
        sb.append(", ");
        sb.append("refundedAmount=").append(this.refundedAmount);
        sb.append(", ");
        sb.append("status=").append(this.status);
        sb.append(", ");
        sb.append("targetDate=").append(this.targetDate);
        sb.append(", ");
        sb.append("trackingIds=").append(this.trackingIds);
        sb.append(", ");
        sb.append("updatedDate=").append(this.updatedDate);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends InvoiceImp.Builder<T>> {

        protected UUID accountId;
        protected BigDecimal balance;
        protected BigDecimal chargedAmount;
        protected DateTime createdDate;
        protected BigDecimal creditedAmount;
        protected Currency currency;
        protected UUID id;
        protected LocalDate invoiceDate;
        protected List<InvoiceItem> invoiceItems;
        protected Integer invoiceNumber;
        protected boolean isMigrationInvoice;
        protected boolean isParentInvoice;
        protected int numberOfItems;
        protected int numberOfPayments;
        protected BigDecimal originalChargedAmount;
        protected BigDecimal paidAmount;
        protected UUID parentAccountId;
        protected UUID parentInvoiceId;
        protected List<InvoicePayment> payments;
        protected BigDecimal refundedAmount;
        protected InvoiceStatus status;
        protected LocalDate targetDate;
        protected List<String> trackingIds;
        protected DateTime updatedDate;

        public Builder() { }
        public Builder(final Builder that) {
            this.accountId = that.accountId;
            this.balance = that.balance;
            this.chargedAmount = that.chargedAmount;
            this.createdDate = that.createdDate;
            this.creditedAmount = that.creditedAmount;
            this.currency = that.currency;
            this.id = that.id;
            this.invoiceDate = that.invoiceDate;
            this.invoiceItems = that.invoiceItems;
            this.invoiceNumber = that.invoiceNumber;
            this.isMigrationInvoice = that.isMigrationInvoice;
            this.isParentInvoice = that.isParentInvoice;
            this.numberOfItems = that.numberOfItems;
            this.numberOfPayments = that.numberOfPayments;
            this.originalChargedAmount = that.originalChargedAmount;
            this.paidAmount = that.paidAmount;
            this.parentAccountId = that.parentAccountId;
            this.parentInvoiceId = that.parentInvoiceId;
            this.payments = that.payments;
            this.refundedAmount = that.refundedAmount;
            this.status = that.status;
            this.targetDate = that.targetDate;
            this.trackingIds = that.trackingIds;
            this.updatedDate = that.updatedDate;
        }
        public T withAccountId(final UUID accountId) {
            this.accountId = accountId;
            return (T) this;
        }
        public T withBalance(final BigDecimal balance) {
            this.balance = balance;
            return (T) this;
        }
        public T withChargedAmount(final BigDecimal chargedAmount) {
            this.chargedAmount = chargedAmount;
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
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withInvoiceDate(final LocalDate invoiceDate) {
            this.invoiceDate = invoiceDate;
            return (T) this;
        }
        public T withInvoiceItems(final List<InvoiceItem> invoiceItems) {
            this.invoiceItems = invoiceItems;
            return (T) this;
        }
        public T withInvoiceNumber(final Integer invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return (T) this;
        }
        public T withIsMigrationInvoice(final boolean isMigrationInvoice) {
            this.isMigrationInvoice = isMigrationInvoice;
            return (T) this;
        }
        public T withIsParentInvoice(final boolean isParentInvoice) {
            this.isParentInvoice = isParentInvoice;
            return (T) this;
        }
        public T withNumberOfItems(final int numberOfItems) {
            this.numberOfItems = numberOfItems;
            return (T) this;
        }
        public T withNumberOfPayments(final int numberOfPayments) {
            this.numberOfPayments = numberOfPayments;
            return (T) this;
        }
        public T withOriginalChargedAmount(final BigDecimal originalChargedAmount) {
            this.originalChargedAmount = originalChargedAmount;
            return (T) this;
        }
        public T withPaidAmount(final BigDecimal paidAmount) {
            this.paidAmount = paidAmount;
            return (T) this;
        }
        public T withParentAccountId(final UUID parentAccountId) {
            this.parentAccountId = parentAccountId;
            return (T) this;
        }
        public T withParentInvoiceId(final UUID parentInvoiceId) {
            this.parentInvoiceId = parentInvoiceId;
            return (T) this;
        }
        public T withPayments(final List<InvoicePayment> payments) {
            this.payments = payments;
            return (T) this;
        }
        public T withRefundedAmount(final BigDecimal refundedAmount) {
            this.refundedAmount = refundedAmount;
            return (T) this;
        }
        public T withStatus(final InvoiceStatus status) {
            this.status = status;
            return (T) this;
        }
        public T withTargetDate(final LocalDate targetDate) {
            this.targetDate = targetDate;
            return (T) this;
        }
        public T withTrackingIds(final List<String> trackingIds) {
            this.trackingIds = trackingIds;
            return (T) this;
        }
        public T withUpdatedDate(final DateTime updatedDate) {
            this.updatedDate = updatedDate;
            return (T) this;
        }
        public T source(final Invoice that) {
            this.accountId = that.getAccountId();
            this.balance = that.getBalance();
            this.chargedAmount = that.getChargedAmount();
            this.createdDate = that.getCreatedDate();
            this.creditedAmount = that.getCreditedAmount();
            this.currency = that.getCurrency();
            this.id = that.getId();
            this.invoiceDate = that.getInvoiceDate();
            this.invoiceItems = that.getInvoiceItems();
            this.invoiceNumber = that.getInvoiceNumber();
            this.isMigrationInvoice = that.isMigrationInvoice();
            this.isParentInvoice = that.isParentInvoice();
            this.numberOfItems = that.getNumberOfItems();
            this.numberOfPayments = that.getNumberOfPayments();
            this.originalChargedAmount = that.getOriginalChargedAmount();
            this.paidAmount = that.getPaidAmount();
            this.parentAccountId = that.getParentAccountId();
            this.parentInvoiceId = that.getParentInvoiceId();
            this.payments = that.getPayments();
            this.refundedAmount = that.getRefundedAmount();
            this.status = that.getStatus();
            this.targetDate = that.getTargetDate();
            this.trackingIds = that.getTrackingIds();
            this.updatedDate = that.getUpdatedDate();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public InvoiceImp build() {
            return new InvoiceImp(this.validate());
        }
    }
}
