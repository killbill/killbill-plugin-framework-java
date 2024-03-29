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

package org.killbill.billing.invoice.plugin.api.boilerplate.plugin;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.invoice.plugin.api.InvoiceContext;
import org.killbill.billing.util.callcontext.CallOrigin;
import org.killbill.billing.util.callcontext.UserType;

@JsonDeserialize( builder = InvoiceContextImp.Builder.class )
public class InvoiceContextImp implements InvoiceContext {

    protected UUID accountId;
    protected CallOrigin callOrigin;
    protected String comments;
    protected DateTime createdDate;
    protected List<Invoice> existingInvoices;
    protected Invoice invoice;
    protected boolean isDryRun;
    protected boolean isRescheduled;
    protected String reasonCode;
    protected LocalDate targetDate;
    protected UUID tenantId;
    protected DateTime updatedDate;
    protected String userName;
    protected UUID userToken;
    protected UserType userType;

    public InvoiceContextImp(final InvoiceContextImp that) {
        this.accountId = that.accountId;
        this.callOrigin = that.callOrigin;
        this.comments = that.comments;
        this.createdDate = that.createdDate;
        this.existingInvoices = that.existingInvoices;
        this.invoice = that.invoice;
        this.isDryRun = that.isDryRun;
        this.isRescheduled = that.isRescheduled;
        this.reasonCode = that.reasonCode;
        this.targetDate = that.targetDate;
        this.tenantId = that.tenantId;
        this.updatedDate = that.updatedDate;
        this.userName = that.userName;
        this.userToken = that.userToken;
        this.userType = that.userType;
    }
    protected InvoiceContextImp(final InvoiceContextImp.Builder<?> builder) {
        this.accountId = builder.accountId;
        this.callOrigin = builder.callOrigin;
        this.comments = builder.comments;
        this.createdDate = builder.createdDate;
        this.existingInvoices = builder.existingInvoices;
        this.invoice = builder.invoice;
        this.isDryRun = builder.isDryRun;
        this.isRescheduled = builder.isRescheduled;
        this.reasonCode = builder.reasonCode;
        this.targetDate = builder.targetDate;
        this.tenantId = builder.tenantId;
        this.updatedDate = builder.updatedDate;
        this.userName = builder.userName;
        this.userToken = builder.userToken;
        this.userType = builder.userType;
    }
    protected InvoiceContextImp() { }
    @Override
    public UUID getAccountId() {
        return this.accountId;
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
    public List<Invoice> getExistingInvoices() {
        return this.existingInvoices;
    }
    @Override
    public Invoice getInvoice() {
        return this.invoice;
    }
    @Override
    @JsonGetter("isDryRun")
    public boolean isDryRun() {
        return this.isDryRun;
    }
    @Override
    @JsonGetter("isRescheduled")
    public boolean isRescheduled() {
        return this.isRescheduled;
    }
    @Override
    public String getReasonCode() {
        return this.reasonCode;
    }
    @Override
    public LocalDate getTargetDate() {
        return this.targetDate;
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
        final InvoiceContextImp that = (InvoiceContextImp) o;
        if( !Objects.equals(this.accountId, that.accountId) ) {
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
        if( !Objects.equals(this.existingInvoices, that.existingInvoices) ) {
            return false;
        }
        if( !Objects.equals(this.invoice, that.invoice) ) {
            return false;
        }
        if( this.isDryRun != that.isDryRun ) {
            return false;
        }
        if( this.isRescheduled != that.isRescheduled ) {
            return false;
        }
        if( !Objects.equals(this.reasonCode, that.reasonCode) ) {
            return false;
        }
        if( ( this.targetDate != null ) ? ( 0 != this.targetDate.compareTo(that.targetDate) ) : ( that.targetDate != null ) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.callOrigin);
        result = ( 31 * result ) + Objects.hashCode(this.comments);
        result = ( 31 * result ) + Objects.hashCode(this.createdDate);
        result = ( 31 * result ) + Objects.hashCode(this.existingInvoices);
        result = ( 31 * result ) + Objects.hashCode(this.invoice);
        result = ( 31 * result ) + Objects.hashCode(this.isDryRun);
        result = ( 31 * result ) + Objects.hashCode(this.isRescheduled);
        result = ( 31 * result ) + Objects.hashCode(this.reasonCode);
        result = ( 31 * result ) + Objects.hashCode(this.targetDate);
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
        sb.append("existingInvoices=").append(this.existingInvoices);
        sb.append(", ");
        sb.append("invoice=").append(this.invoice);
        sb.append(", ");
        sb.append("isDryRun=").append(this.isDryRun);
        sb.append(", ");
        sb.append("isRescheduled=").append(this.isRescheduled);
        sb.append(", ");
        sb.append("reasonCode=");
        if( this.reasonCode == null ) {
            sb.append(this.reasonCode);
        }else{
            sb.append("'").append(this.reasonCode).append("'");
        }
        sb.append(", ");
        sb.append("targetDate=").append(this.targetDate);
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
    public static class Builder<T extends InvoiceContextImp.Builder<T>> {

        protected UUID accountId;
        protected CallOrigin callOrigin;
        protected String comments;
        protected DateTime createdDate;
        protected List<Invoice> existingInvoices;
        protected Invoice invoice;
        protected boolean isDryRun;
        protected boolean isRescheduled;
        protected String reasonCode;
        protected LocalDate targetDate;
        protected UUID tenantId;
        protected DateTime updatedDate;
        protected String userName;
        protected UUID userToken;
        protected UserType userType;

        public Builder() { }
        public Builder(final Builder that) {
            this.accountId = that.accountId;
            this.callOrigin = that.callOrigin;
            this.comments = that.comments;
            this.createdDate = that.createdDate;
            this.existingInvoices = that.existingInvoices;
            this.invoice = that.invoice;
            this.isDryRun = that.isDryRun;
            this.isRescheduled = that.isRescheduled;
            this.reasonCode = that.reasonCode;
            this.targetDate = that.targetDate;
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
        public T withExistingInvoices(final List<Invoice> existingInvoices) {
            this.existingInvoices = existingInvoices;
            return (T) this;
        }
        public T withInvoice(final Invoice invoice) {
            this.invoice = invoice;
            return (T) this;
        }
        public T withIsDryRun(final boolean isDryRun) {
            this.isDryRun = isDryRun;
            return (T) this;
        }
        public T withIsRescheduled(final boolean isRescheduled) {
            this.isRescheduled = isRescheduled;
            return (T) this;
        }
        public T withReasonCode(final String reasonCode) {
            this.reasonCode = reasonCode;
            return (T) this;
        }
        public T withTargetDate(final LocalDate targetDate) {
            this.targetDate = targetDate;
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
        public T source(final InvoiceContext that) {
            this.accountId = that.getAccountId();
            this.callOrigin = that.getCallOrigin();
            this.comments = that.getComments();
            this.createdDate = that.getCreatedDate();
            this.existingInvoices = that.getExistingInvoices();
            this.invoice = that.getInvoice();
            this.isDryRun = that.isDryRun();
            this.isRescheduled = that.isRescheduled();
            this.reasonCode = that.getReasonCode();
            this.targetDate = that.getTargetDate();
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
        public InvoiceContextImp build() {
            return new InvoiceContextImp(this.validate());
        }
    }
}
