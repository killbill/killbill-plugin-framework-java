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
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.killbill.billing.invoice.api.InvoiceParentChild;

@JsonDeserialize( builder = InvoiceParentChildImp.Builder.class )
public class InvoiceParentChildImp implements InvoiceParentChild {

    protected UUID childAccountId;
    protected UUID childInvoiceId;
    protected DateTime createdDate;
    protected UUID id;
    protected UUID parentInvoiceId;
    protected DateTime updatedDate;

    public InvoiceParentChildImp(final InvoiceParentChildImp that) {
        this.childAccountId = that.childAccountId;
        this.childInvoiceId = that.childInvoiceId;
        this.createdDate = that.createdDate;
        this.id = that.id;
        this.parentInvoiceId = that.parentInvoiceId;
        this.updatedDate = that.updatedDate;
    }
    protected InvoiceParentChildImp(final InvoiceParentChildImp.Builder<?> builder) {
        this.childAccountId = builder.childAccountId;
        this.childInvoiceId = builder.childInvoiceId;
        this.createdDate = builder.createdDate;
        this.id = builder.id;
        this.parentInvoiceId = builder.parentInvoiceId;
        this.updatedDate = builder.updatedDate;
    }
    protected InvoiceParentChildImp() { }
    @Override
    public UUID getChildAccountId() {
        return this.childAccountId;
    }
    @Override
    public UUID getChildInvoiceId() {
        return this.childInvoiceId;
    }
    @Override
    public DateTime getCreatedDate() {
        return this.createdDate;
    }
    @Override
    public UUID getId() {
        return this.id;
    }
    @Override
    public UUID getParentInvoiceId() {
        return this.parentInvoiceId;
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
        final InvoiceParentChildImp that = (InvoiceParentChildImp) o;
        if( !Objects.equals(this.childAccountId, that.childAccountId) ) {
            return false;
        }
        if( !Objects.equals(this.childInvoiceId, that.childInvoiceId) ) {
            return false;
        }
        if( ( this.createdDate != null ) ? ( 0 != this.createdDate.compareTo(that.createdDate) ) : ( that.createdDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.id, that.id) ) {
            return false;
        }
        if( !Objects.equals(this.parentInvoiceId, that.parentInvoiceId) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.childAccountId);
        result = ( 31 * result ) + Objects.hashCode(this.childInvoiceId);
        result = ( 31 * result ) + Objects.hashCode(this.createdDate);
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.parentInvoiceId);
        result = ( 31 * result ) + Objects.hashCode(this.updatedDate);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("childAccountId=").append(this.childAccountId);
        sb.append(", ");
        sb.append("childInvoiceId=").append(this.childInvoiceId);
        sb.append(", ");
        sb.append("createdDate=").append(this.createdDate);
        sb.append(", ");
        sb.append("id=").append(this.id);
        sb.append(", ");
        sb.append("parentInvoiceId=").append(this.parentInvoiceId);
        sb.append(", ");
        sb.append("updatedDate=").append(this.updatedDate);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends InvoiceParentChildImp.Builder<T>> {

        protected UUID childAccountId;
        protected UUID childInvoiceId;
        protected DateTime createdDate;
        protected UUID id;
        protected UUID parentInvoiceId;
        protected DateTime updatedDate;

        public Builder() { }
        public Builder(final Builder that) {
            this.childAccountId = that.childAccountId;
            this.childInvoiceId = that.childInvoiceId;
            this.createdDate = that.createdDate;
            this.id = that.id;
            this.parentInvoiceId = that.parentInvoiceId;
            this.updatedDate = that.updatedDate;
        }
        public T withChildAccountId(final UUID childAccountId) {
            this.childAccountId = childAccountId;
            return (T) this;
        }
        public T withChildInvoiceId(final UUID childInvoiceId) {
            this.childInvoiceId = childInvoiceId;
            return (T) this;
        }
        public T withCreatedDate(final DateTime createdDate) {
            this.createdDate = createdDate;
            return (T) this;
        }
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withParentInvoiceId(final UUID parentInvoiceId) {
            this.parentInvoiceId = parentInvoiceId;
            return (T) this;
        }
        public T withUpdatedDate(final DateTime updatedDate) {
            this.updatedDate = updatedDate;
            return (T) this;
        }
        public T source(final InvoiceParentChild that) {
            this.childAccountId = that.getChildAccountId();
            this.childInvoiceId = that.getChildInvoiceId();
            this.createdDate = that.getCreatedDate();
            this.id = that.getId();
            this.parentInvoiceId = that.getParentInvoiceId();
            this.updatedDate = that.getUpdatedDate();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public InvoiceParentChildImp build() {
            return new InvoiceParentChildImp(this.validate());
        }
    }
}
