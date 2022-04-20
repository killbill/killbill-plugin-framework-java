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

package org.killbill.billing.usage.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.LocalDate;
import org.killbill.billing.usage.api.RawUsageRecord;

@JsonDeserialize( builder = RawUsageRecordImp.Builder.class )
public class RawUsageRecordImp implements RawUsageRecord {

    protected Long amount;
    protected LocalDate date;
    protected UUID subscriptionId;
    protected String trackingId;
    protected String unitType;

    public RawUsageRecordImp(final RawUsageRecordImp that) {
        this.amount = that.amount;
        this.date = that.date;
        this.subscriptionId = that.subscriptionId;
        this.trackingId = that.trackingId;
        this.unitType = that.unitType;
    }
    protected RawUsageRecordImp(final RawUsageRecordImp.Builder<?> builder) {
        this.amount = builder.amount;
        this.date = builder.date;
        this.subscriptionId = builder.subscriptionId;
        this.trackingId = builder.trackingId;
        this.unitType = builder.unitType;
    }
    protected RawUsageRecordImp() { }
    @Override
    public Long getAmount() {
        return this.amount;
    }
    @Override
    public LocalDate getDate() {
        return this.date;
    }
    @Override
    public UUID getSubscriptionId() {
        return this.subscriptionId;
    }
    @Override
    public String getTrackingId() {
        return this.trackingId;
    }
    @Override
    public String getUnitType() {
        return this.unitType;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final RawUsageRecordImp that = (RawUsageRecordImp) o;
        if( !Objects.equals(this.amount, that.amount) ) {
            return false;
        }
        if( ( this.date != null ) ? ( 0 != this.date.compareTo(that.date) ) : ( that.date != null ) ) {
            return false;
        }
        if( !Objects.equals(this.subscriptionId, that.subscriptionId) ) {
            return false;
        }
        if( !Objects.equals(this.trackingId, that.trackingId) ) {
            return false;
        }
        if( !Objects.equals(this.unitType, that.unitType) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.amount);
        result = ( 31 * result ) + Objects.hashCode(this.date);
        result = ( 31 * result ) + Objects.hashCode(this.subscriptionId);
        result = ( 31 * result ) + Objects.hashCode(this.trackingId);
        result = ( 31 * result ) + Objects.hashCode(this.unitType);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("amount=").append(this.amount);
        sb.append(", ");
        sb.append("date=").append(this.date);
        sb.append(", ");
        sb.append("subscriptionId=").append(this.subscriptionId);
        sb.append(", ");
        sb.append("trackingId=");
        if( this.trackingId == null ) {
            sb.append(this.trackingId);
        }else{
            sb.append("'").append(this.trackingId).append("'");
        }
        sb.append(", ");
        sb.append("unitType=");
        if( this.unitType == null ) {
            sb.append(this.unitType);
        }else{
            sb.append("'").append(this.unitType).append("'");
        }
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends RawUsageRecordImp.Builder<T>> {

        protected Long amount;
        protected LocalDate date;
        protected UUID subscriptionId;
        protected String trackingId;
        protected String unitType;

        public Builder() { }
        public Builder(final Builder that) {
            this.amount = that.amount;
            this.date = that.date;
            this.subscriptionId = that.subscriptionId;
            this.trackingId = that.trackingId;
            this.unitType = that.unitType;
        }
        public T withAmount(final Long amount) {
            this.amount = amount;
            return (T) this;
        }
        public T withDate(final LocalDate date) {
            this.date = date;
            return (T) this;
        }
        public T withSubscriptionId(final UUID subscriptionId) {
            this.subscriptionId = subscriptionId;
            return (T) this;
        }
        public T withTrackingId(final String trackingId) {
            this.trackingId = trackingId;
            return (T) this;
        }
        public T withUnitType(final String unitType) {
            this.unitType = unitType;
            return (T) this;
        }
        public T source(final RawUsageRecord that) {
            this.amount = that.getAmount();
            this.date = that.getDate();
            this.subscriptionId = that.getSubscriptionId();
            this.trackingId = that.getTrackingId();
            this.unitType = that.getUnitType();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public RawUsageRecordImp build() {
            return new RawUsageRecordImp(this.validate());
        }
    }
}
