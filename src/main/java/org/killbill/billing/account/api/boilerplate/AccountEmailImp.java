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

package org.killbill.billing.account.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.killbill.billing.account.api.AccountEmail;

@JsonDeserialize( builder = AccountEmailImp.Builder.class )
public class AccountEmailImp implements AccountEmail {

    private static final long serialVersionUID = 0x89ADE56213E92CA8L;

    protected UUID accountId;
    protected DateTime createdDate;
    protected String email;
    protected UUID id;
    protected DateTime updatedDate;

    public AccountEmailImp(final AccountEmailImp that) {
        this.accountId = that.accountId;
        this.createdDate = that.createdDate;
        this.email = that.email;
        this.id = that.id;
        this.updatedDate = that.updatedDate;
    }
    protected AccountEmailImp(final AccountEmailImp.Builder<?> builder) {
        this.accountId = builder.accountId;
        this.createdDate = builder.createdDate;
        this.email = builder.email;
        this.id = builder.id;
        this.updatedDate = builder.updatedDate;
    }
    protected AccountEmailImp() { }
    @Override
    public UUID getAccountId() {
        return this.accountId;
    }
    @Override
    public DateTime getCreatedDate() {
        return this.createdDate;
    }
    @Override
    public String getEmail() {
        return this.email;
    }
    @Override
    public UUID getId() {
        return this.id;
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
        final AccountEmailImp that = (AccountEmailImp) o;
        if( !Objects.equals(this.accountId, that.accountId) ) {
            return false;
        }
        if( ( this.createdDate != null ) ? ( 0 != this.createdDate.compareTo(that.createdDate) ) : ( that.createdDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.email, that.email) ) {
            return false;
        }
        if( !Objects.equals(this.id, that.id) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.createdDate);
        result = ( 31 * result ) + Objects.hashCode(this.email);
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.updatedDate);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("accountId=").append(this.accountId);
        sb.append(", ");
        sb.append("createdDate=").append(this.createdDate);
        sb.append(", ");
        sb.append("email=");
        if( this.email == null ) {
            sb.append(this.email);
        }else{
            sb.append("'").append(this.email).append("'");
        }
        sb.append(", ");
        sb.append("id=").append(this.id);
        sb.append(", ");
        sb.append("updatedDate=").append(this.updatedDate);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends AccountEmailImp.Builder<T>> {

        protected UUID accountId;
        protected DateTime createdDate;
        protected String email;
        protected UUID id;
        protected DateTime updatedDate;

        public Builder() { }
        public Builder(final Builder that) {
            this.accountId = that.accountId;
            this.createdDate = that.createdDate;
            this.email = that.email;
            this.id = that.id;
            this.updatedDate = that.updatedDate;
        }
        public T withAccountId(final UUID accountId) {
            this.accountId = accountId;
            return (T) this;
        }
        public T withCreatedDate(final DateTime createdDate) {
            this.createdDate = createdDate;
            return (T) this;
        }
        public T withEmail(final String email) {
            this.email = email;
            return (T) this;
        }
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withUpdatedDate(final DateTime updatedDate) {
            this.updatedDate = updatedDate;
            return (T) this;
        }
        public T source(final AccountEmail that) {
            this.accountId = that.getAccountId();
            this.createdDate = that.getCreatedDate();
            this.email = that.getEmail();
            this.id = that.getId();
            this.updatedDate = that.getUpdatedDate();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public AccountEmailImp build() {
            return new AccountEmailImp(this.validate());
        }
    }
}
