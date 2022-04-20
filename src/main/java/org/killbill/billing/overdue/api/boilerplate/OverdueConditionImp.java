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

package org.killbill.billing.overdue.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import org.killbill.billing.catalog.api.Duration;
import org.killbill.billing.overdue.api.OverdueCondition;
import org.killbill.billing.payment.api.PaymentResponse;
import org.killbill.billing.util.tag.ControlTagType;

@JsonDeserialize( builder = OverdueConditionImp.Builder.class )
public class OverdueConditionImp implements OverdueCondition {

    private static final long serialVersionUID = 0x2AB7DE125D71E096L;

    protected ControlTagType exclusionControlTagType;
    protected ControlTagType inclusionControlTagType;
    protected Integer numberOfUnpaidInvoicesEqualsOrExceeds;
    protected PaymentResponse[] responseForLastFailedPaymentIn;
    protected Duration timeSinceEarliestUnpaidInvoiceEqualsOrExceeds;
    protected BigDecimal totalUnpaidInvoiceBalanceEqualsOrExceeds;

    public OverdueConditionImp(final OverdueConditionImp that) {
        this.exclusionControlTagType = that.exclusionControlTagType;
        this.inclusionControlTagType = that.inclusionControlTagType;
        this.numberOfUnpaidInvoicesEqualsOrExceeds = that.numberOfUnpaidInvoicesEqualsOrExceeds;
        this.responseForLastFailedPaymentIn = that.responseForLastFailedPaymentIn;
        this.timeSinceEarliestUnpaidInvoiceEqualsOrExceeds = that.timeSinceEarliestUnpaidInvoiceEqualsOrExceeds;
        this.totalUnpaidInvoiceBalanceEqualsOrExceeds = that.totalUnpaidInvoiceBalanceEqualsOrExceeds;
    }
    protected OverdueConditionImp(final OverdueConditionImp.Builder<?> builder) {
        this.exclusionControlTagType = builder.exclusionControlTagType;
        this.inclusionControlTagType = builder.inclusionControlTagType;
        this.numberOfUnpaidInvoicesEqualsOrExceeds = builder.numberOfUnpaidInvoicesEqualsOrExceeds;
        this.responseForLastFailedPaymentIn = builder.responseForLastFailedPaymentIn;
        this.timeSinceEarliestUnpaidInvoiceEqualsOrExceeds = builder.timeSinceEarliestUnpaidInvoiceEqualsOrExceeds;
        this.totalUnpaidInvoiceBalanceEqualsOrExceeds = builder.totalUnpaidInvoiceBalanceEqualsOrExceeds;
    }
    protected OverdueConditionImp() { }
    @Override
    public ControlTagType getExclusionControlTagType() {
        return this.exclusionControlTagType;
    }
    @Override
    public ControlTagType getInclusionControlTagType() {
        return this.inclusionControlTagType;
    }
    @Override
    public Integer getNumberOfUnpaidInvoicesEqualsOrExceeds() {
        return this.numberOfUnpaidInvoicesEqualsOrExceeds;
    }
    @Override
    public PaymentResponse[] getResponseForLastFailedPaymentIn() {
        return this.responseForLastFailedPaymentIn;
    }
    @Override
    public Duration getTimeSinceEarliestUnpaidInvoiceEqualsOrExceeds() {
        return this.timeSinceEarliestUnpaidInvoiceEqualsOrExceeds;
    }
    @Override
    public BigDecimal getTotalUnpaidInvoiceBalanceEqualsOrExceeds() {
        return this.totalUnpaidInvoiceBalanceEqualsOrExceeds;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final OverdueConditionImp that = (OverdueConditionImp) o;
        if( !Objects.equals(this.exclusionControlTagType, that.exclusionControlTagType) ) {
            return false;
        }
        if( !Objects.equals(this.inclusionControlTagType, that.inclusionControlTagType) ) {
            return false;
        }
        if( !Objects.equals(this.numberOfUnpaidInvoicesEqualsOrExceeds, that.numberOfUnpaidInvoicesEqualsOrExceeds) ) {
            return false;
        }
        if( !Arrays.deepEquals(this.responseForLastFailedPaymentIn, that.responseForLastFailedPaymentIn) ) {
            return false;
        }
        if( !Objects.equals(this.timeSinceEarliestUnpaidInvoiceEqualsOrExceeds, that.timeSinceEarliestUnpaidInvoiceEqualsOrExceeds) ) {
            return false;
        }
        if( ( this.totalUnpaidInvoiceBalanceEqualsOrExceeds != null ) ? ( 0 != this.totalUnpaidInvoiceBalanceEqualsOrExceeds.compareTo(that.totalUnpaidInvoiceBalanceEqualsOrExceeds) ) : ( that.totalUnpaidInvoiceBalanceEqualsOrExceeds != null ) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.exclusionControlTagType);
        result = ( 31 * result ) + Objects.hashCode(this.inclusionControlTagType);
        result = ( 31 * result ) + Objects.hashCode(this.numberOfUnpaidInvoicesEqualsOrExceeds);
        result = ( 31 * result ) + Arrays.deepHashCode(this.responseForLastFailedPaymentIn);
        result = ( 31 * result ) + Objects.hashCode(this.timeSinceEarliestUnpaidInvoiceEqualsOrExceeds);
        result = ( 31 * result ) + Objects.hashCode(this.totalUnpaidInvoiceBalanceEqualsOrExceeds);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("exclusionControlTagType=").append(this.exclusionControlTagType);
        sb.append(", ");
        sb.append("inclusionControlTagType=").append(this.inclusionControlTagType);
        sb.append(", ");
        sb.append("numberOfUnpaidInvoicesEqualsOrExceeds=").append(this.numberOfUnpaidInvoicesEqualsOrExceeds);
        sb.append(", ");
        sb.append("responseForLastFailedPaymentIn=").append(Arrays.toString(this.responseForLastFailedPaymentIn));
        sb.append(", ");
        sb.append("timeSinceEarliestUnpaidInvoiceEqualsOrExceeds=").append(this.timeSinceEarliestUnpaidInvoiceEqualsOrExceeds);
        sb.append(", ");
        sb.append("totalUnpaidInvoiceBalanceEqualsOrExceeds=").append(this.totalUnpaidInvoiceBalanceEqualsOrExceeds);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends OverdueConditionImp.Builder<T>> {

        protected ControlTagType exclusionControlTagType;
        protected ControlTagType inclusionControlTagType;
        protected Integer numberOfUnpaidInvoicesEqualsOrExceeds;
        protected PaymentResponse[] responseForLastFailedPaymentIn;
        protected Duration timeSinceEarliestUnpaidInvoiceEqualsOrExceeds;
        protected BigDecimal totalUnpaidInvoiceBalanceEqualsOrExceeds;

        public Builder() { }
        public Builder(final Builder that) {
            this.exclusionControlTagType = that.exclusionControlTagType;
            this.inclusionControlTagType = that.inclusionControlTagType;
            this.numberOfUnpaidInvoicesEqualsOrExceeds = that.numberOfUnpaidInvoicesEqualsOrExceeds;
            this.responseForLastFailedPaymentIn = that.responseForLastFailedPaymentIn;
            this.timeSinceEarliestUnpaidInvoiceEqualsOrExceeds = that.timeSinceEarliestUnpaidInvoiceEqualsOrExceeds;
            this.totalUnpaidInvoiceBalanceEqualsOrExceeds = that.totalUnpaidInvoiceBalanceEqualsOrExceeds;
        }
        public T withExclusionControlTagType(final ControlTagType exclusionControlTagType) {
            this.exclusionControlTagType = exclusionControlTagType;
            return (T) this;
        }
        public T withInclusionControlTagType(final ControlTagType inclusionControlTagType) {
            this.inclusionControlTagType = inclusionControlTagType;
            return (T) this;
        }
        public T withNumberOfUnpaidInvoicesEqualsOrExceeds(final Integer numberOfUnpaidInvoicesEqualsOrExceeds) {
            this.numberOfUnpaidInvoicesEqualsOrExceeds = numberOfUnpaidInvoicesEqualsOrExceeds;
            return (T) this;
        }
        public T withResponseForLastFailedPaymentIn(final PaymentResponse[] responseForLastFailedPaymentIn) {
            this.responseForLastFailedPaymentIn = responseForLastFailedPaymentIn;
            return (T) this;
        }
        public T withTimeSinceEarliestUnpaidInvoiceEqualsOrExceeds(final Duration timeSinceEarliestUnpaidInvoiceEqualsOrExceeds) {
            this.timeSinceEarliestUnpaidInvoiceEqualsOrExceeds = timeSinceEarliestUnpaidInvoiceEqualsOrExceeds;
            return (T) this;
        }
        public T withTotalUnpaidInvoiceBalanceEqualsOrExceeds(final BigDecimal totalUnpaidInvoiceBalanceEqualsOrExceeds) {
            this.totalUnpaidInvoiceBalanceEqualsOrExceeds = totalUnpaidInvoiceBalanceEqualsOrExceeds;
            return (T) this;
        }
        public T source(final OverdueCondition that) {
            this.exclusionControlTagType = that.getExclusionControlTagType();
            this.inclusionControlTagType = that.getInclusionControlTagType();
            this.numberOfUnpaidInvoicesEqualsOrExceeds = that.getNumberOfUnpaidInvoicesEqualsOrExceeds();
            this.responseForLastFailedPaymentIn = that.getResponseForLastFailedPaymentIn();
            this.timeSinceEarliestUnpaidInvoiceEqualsOrExceeds = that.getTimeSinceEarliestUnpaidInvoiceEqualsOrExceeds();
            this.totalUnpaidInvoiceBalanceEqualsOrExceeds = that.getTotalUnpaidInvoiceBalanceEqualsOrExceeds();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public OverdueConditionImp build() {
            return new OverdueConditionImp(this.validate());
        }
    }
}
