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
import org.joda.time.DateTimeZone;
import org.killbill.billing.account.api.ImmutableAccountData;
import org.killbill.billing.catalog.api.Currency;

@JsonDeserialize( builder = ImmutableAccountDataImp.Builder.class )
public class ImmutableAccountDataImp implements ImmutableAccountData {

    protected Currency currency;
    protected String externalKey;
    protected DateTimeZone fixedOffsetTimeZone;
    protected UUID id;
    protected DateTime referenceTime;
    protected DateTimeZone timeZone;

    public ImmutableAccountDataImp(final ImmutableAccountDataImp that) {
        this.currency = that.currency;
        this.externalKey = that.externalKey;
        this.fixedOffsetTimeZone = that.fixedOffsetTimeZone;
        this.id = that.id;
        this.referenceTime = that.referenceTime;
        this.timeZone = that.timeZone;
    }
    protected ImmutableAccountDataImp(final ImmutableAccountDataImp.Builder<?> builder) {
        this.currency = builder.currency;
        this.externalKey = builder.externalKey;
        this.fixedOffsetTimeZone = builder.fixedOffsetTimeZone;
        this.id = builder.id;
        this.referenceTime = builder.referenceTime;
        this.timeZone = builder.timeZone;
    }
    protected ImmutableAccountDataImp() { }
    @Override
    public Currency getCurrency() {
        return this.currency;
    }
    @Override
    public String getExternalKey() {
        return this.externalKey;
    }
    @Override
    public DateTimeZone getFixedOffsetTimeZone() {
        return this.fixedOffsetTimeZone;
    }
    @Override
    public UUID getId() {
        return this.id;
    }
    @Override
    public DateTime getReferenceTime() {
        return this.referenceTime;
    }
    @Override
    public DateTimeZone getTimeZone() {
        return this.timeZone;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final ImmutableAccountDataImp that = (ImmutableAccountDataImp) o;
        if( !Objects.equals(this.currency, that.currency) ) {
            return false;
        }
        if( !Objects.equals(this.externalKey, that.externalKey) ) {
            return false;
        }
        if( !Objects.equals(this.fixedOffsetTimeZone, that.fixedOffsetTimeZone) ) {
            return false;
        }
        if( !Objects.equals(this.id, that.id) ) {
            return false;
        }
        if( ( this.referenceTime != null ) ? ( 0 != this.referenceTime.compareTo(that.referenceTime) ) : ( that.referenceTime != null ) ) {
            return false;
        }
        if( !Objects.equals(this.timeZone, that.timeZone) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.currency);
        result = ( 31 * result ) + Objects.hashCode(this.externalKey);
        result = ( 31 * result ) + Objects.hashCode(this.fixedOffsetTimeZone);
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.referenceTime);
        result = ( 31 * result ) + Objects.hashCode(this.timeZone);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("currency=").append(this.currency);
        sb.append(", ");
        sb.append("externalKey=");
        if( this.externalKey == null ) {
            sb.append(this.externalKey);
        }else{
            sb.append("'").append(this.externalKey).append("'");
        }
        sb.append(", ");
        sb.append("fixedOffsetTimeZone=").append(this.fixedOffsetTimeZone);
        sb.append(", ");
        sb.append("id=").append(this.id);
        sb.append(", ");
        sb.append("referenceTime=").append(this.referenceTime);
        sb.append(", ");
        sb.append("timeZone=").append(this.timeZone);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends ImmutableAccountDataImp.Builder<T>> {

        protected Currency currency;
        protected String externalKey;
        protected DateTimeZone fixedOffsetTimeZone;
        protected UUID id;
        protected DateTime referenceTime;
        protected DateTimeZone timeZone;

        public Builder() { }
        public Builder(final Builder that) {
            this.currency = that.currency;
            this.externalKey = that.externalKey;
            this.fixedOffsetTimeZone = that.fixedOffsetTimeZone;
            this.id = that.id;
            this.referenceTime = that.referenceTime;
            this.timeZone = that.timeZone;
        }
        public T withCurrency(final Currency currency) {
            this.currency = currency;
            return (T) this;
        }
        public T withExternalKey(final String externalKey) {
            this.externalKey = externalKey;
            return (T) this;
        }
        public T withFixedOffsetTimeZone(final DateTimeZone fixedOffsetTimeZone) {
            this.fixedOffsetTimeZone = fixedOffsetTimeZone;
            return (T) this;
        }
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withReferenceTime(final DateTime referenceTime) {
            this.referenceTime = referenceTime;
            return (T) this;
        }
        public T withTimeZone(final DateTimeZone timeZone) {
            this.timeZone = timeZone;
            return (T) this;
        }
        public T source(final ImmutableAccountData that) {
            this.currency = that.getCurrency();
            this.externalKey = that.getExternalKey();
            this.fixedOffsetTimeZone = that.getFixedOffsetTimeZone();
            this.id = that.getId();
            this.referenceTime = that.getReferenceTime();
            this.timeZone = that.getTimeZone();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public ImmutableAccountDataImp build() {
            return new ImmutableAccountDataImp(this.validate());
        }
    }
}
