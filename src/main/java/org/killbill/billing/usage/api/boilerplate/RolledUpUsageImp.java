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
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.LocalDate;
import org.killbill.billing.usage.api.RolledUpUnit;
import org.killbill.billing.usage.api.RolledUpUsage;

@JsonDeserialize( builder = RolledUpUsageImp.Builder.class )
public class RolledUpUsageImp implements RolledUpUsage {

    private static final long serialVersionUID = 0x4A42500A5E79778BL;

    protected LocalDate end;
    protected List<RolledUpUnit> rolledUpUnits;
    protected LocalDate start;
    protected UUID subscriptionId;

    public RolledUpUsageImp(final RolledUpUsageImp that) {
        this.end = that.end;
        this.rolledUpUnits = that.rolledUpUnits;
        this.start = that.start;
        this.subscriptionId = that.subscriptionId;
    }
    protected RolledUpUsageImp(final RolledUpUsageImp.Builder<?> builder) {
        this.end = builder.end;
        this.rolledUpUnits = builder.rolledUpUnits;
        this.start = builder.start;
        this.subscriptionId = builder.subscriptionId;
    }
    protected RolledUpUsageImp() { }
    @Override
    public LocalDate getEnd() {
        return this.end;
    }
    @Override
    public List<RolledUpUnit> getRolledUpUnits() {
        return this.rolledUpUnits;
    }
    @Override
    public LocalDate getStart() {
        return this.start;
    }
    @Override
    public UUID getSubscriptionId() {
        return this.subscriptionId;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final RolledUpUsageImp that = (RolledUpUsageImp) o;
        if( ( this.end != null ) ? ( 0 != this.end.compareTo(that.end) ) : ( that.end != null ) ) {
            return false;
        }
        if( !Objects.equals(this.rolledUpUnits, that.rolledUpUnits) ) {
            return false;
        }
        if( ( this.start != null ) ? ( 0 != this.start.compareTo(that.start) ) : ( that.start != null ) ) {
            return false;
        }
        if( !Objects.equals(this.subscriptionId, that.subscriptionId) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.end);
        result = ( 31 * result ) + Objects.hashCode(this.rolledUpUnits);
        result = ( 31 * result ) + Objects.hashCode(this.start);
        result = ( 31 * result ) + Objects.hashCode(this.subscriptionId);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("end=").append(this.end);
        sb.append(", ");
        sb.append("rolledUpUnits=").append(this.rolledUpUnits);
        sb.append(", ");
        sb.append("start=").append(this.start);
        sb.append(", ");
        sb.append("subscriptionId=").append(this.subscriptionId);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends RolledUpUsageImp.Builder<T>> {

        protected LocalDate end;
        protected List<RolledUpUnit> rolledUpUnits;
        protected LocalDate start;
        protected UUID subscriptionId;

        public Builder() { }
        public Builder(final Builder that) {
            this.end = that.end;
            this.rolledUpUnits = that.rolledUpUnits;
            this.start = that.start;
            this.subscriptionId = that.subscriptionId;
        }
        public T withEnd(final LocalDate end) {
            this.end = end;
            return (T) this;
        }
        public T withRolledUpUnits(final List<RolledUpUnit> rolledUpUnits) {
            this.rolledUpUnits = rolledUpUnits;
            return (T) this;
        }
        public T withStart(final LocalDate start) {
            this.start = start;
            return (T) this;
        }
        public T withSubscriptionId(final UUID subscriptionId) {
            this.subscriptionId = subscriptionId;
            return (T) this;
        }
        public T source(final RolledUpUsage that) {
            this.end = that.getEnd();
            this.rolledUpUnits = that.getRolledUpUnits();
            this.start = that.getStart();
            this.subscriptionId = that.getSubscriptionId();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public RolledUpUsageImp build() {
            return new RolledUpUsageImp(this.validate());
        }
    }
}
