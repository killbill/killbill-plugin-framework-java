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
import java.util.Arrays;
import java.util.Objects;
import org.killbill.billing.catalog.api.Duration;
import org.killbill.billing.overdue.api.OverdueApiException;
import org.killbill.billing.overdue.api.OverdueCancellationPolicy;
import org.killbill.billing.overdue.api.OverdueCondition;
import org.killbill.billing.overdue.api.OverdueState;

@JsonDeserialize( builder = OverdueStateImp.Builder.class )
public class OverdueStateImp implements OverdueState {

    private static final long serialVersionUID = 0x3CF6E8406781974EL;

    protected Duration autoReevaluationInterval;
    protected String externalMessage;
    protected boolean isBlockChanges;
    protected boolean isClearState;
    protected boolean isDisableEntitlementAndChangesBlocked;
    protected String name;
    protected OverdueCancellationPolicy overdueCancellationPolicy;
    protected OverdueCondition overdueCondition;

    public OverdueStateImp(final OverdueStateImp that) {
        this.autoReevaluationInterval = that.autoReevaluationInterval;
        this.externalMessage = that.externalMessage;
        this.isBlockChanges = that.isBlockChanges;
        this.isClearState = that.isClearState;
        this.isDisableEntitlementAndChangesBlocked = that.isDisableEntitlementAndChangesBlocked;
        this.name = that.name;
        this.overdueCancellationPolicy = that.overdueCancellationPolicy;
        this.overdueCondition = that.overdueCondition;
    }
    protected OverdueStateImp(final OverdueStateImp.Builder<?> builder) {
        this.autoReevaluationInterval = builder.autoReevaluationInterval;
        this.externalMessage = builder.externalMessage;
        this.isBlockChanges = builder.isBlockChanges;
        this.isClearState = builder.isClearState;
        this.isDisableEntitlementAndChangesBlocked = builder.isDisableEntitlementAndChangesBlocked;
        this.name = builder.name;
        this.overdueCancellationPolicy = builder.overdueCancellationPolicy;
        this.overdueCondition = builder.overdueCondition;
    }
    protected OverdueStateImp() { }
    @Override
    public Duration getAutoReevaluationInterval() {
        return this.autoReevaluationInterval;
    }
    @Override
    public String getExternalMessage() {
        return this.externalMessage;
    }
    @Override
    @JsonGetter("isBlockChanges")
    public boolean isBlockChanges() {
        return this.isBlockChanges;
    }
    @Override
    @JsonGetter("isClearState")
    public boolean isClearState() {
        return this.isClearState;
    }
    @Override
    @JsonGetter("isDisableEntitlementAndChangesBlocked")
    public boolean isDisableEntitlementAndChangesBlocked() {
        return this.isDisableEntitlementAndChangesBlocked;
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public OverdueCancellationPolicy getOverdueCancellationPolicy() {
        return this.overdueCancellationPolicy;
    }
    @Override
    public OverdueCondition getOverdueCondition() {
        return this.overdueCondition;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final OverdueStateImp that = (OverdueStateImp) o;
        if( !Objects.equals(this.autoReevaluationInterval, that.autoReevaluationInterval) ) {
            return false;
        }
        if( !Objects.equals(this.externalMessage, that.externalMessage) ) {
            return false;
        }
        if( this.isBlockChanges != that.isBlockChanges ) {
            return false;
        }
        if( this.isClearState != that.isClearState ) {
            return false;
        }
        if( this.isDisableEntitlementAndChangesBlocked != that.isDisableEntitlementAndChangesBlocked ) {
            return false;
        }
        if( !Objects.equals(this.name, that.name) ) {
            return false;
        }
        if( !Objects.equals(this.overdueCancellationPolicy, that.overdueCancellationPolicy) ) {
            return false;
        }
        if( !Objects.equals(this.overdueCondition, that.overdueCondition) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.autoReevaluationInterval);
        result = ( 31 * result ) + Objects.hashCode(this.externalMessage);
        result = ( 31 * result ) + Objects.hashCode(this.isBlockChanges);
        result = ( 31 * result ) + Objects.hashCode(this.isClearState);
        result = ( 31 * result ) + Objects.hashCode(this.isDisableEntitlementAndChangesBlocked);
        result = ( 31 * result ) + Objects.hashCode(this.name);
        result = ( 31 * result ) + Objects.hashCode(this.overdueCancellationPolicy);
        result = ( 31 * result ) + Objects.hashCode(this.overdueCondition);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("autoReevaluationInterval=").append(this.autoReevaluationInterval);
        sb.append(", ");
        sb.append("externalMessage=");
        if( this.externalMessage == null ) {
            sb.append(this.externalMessage);
        }else{
            sb.append("'").append(this.externalMessage).append("'");
        }
        sb.append(", ");
        sb.append("isBlockChanges=").append(this.isBlockChanges);
        sb.append(", ");
        sb.append("isClearState=").append(this.isClearState);
        sb.append(", ");
        sb.append("isDisableEntitlementAndChangesBlocked=").append(this.isDisableEntitlementAndChangesBlocked);
        sb.append(", ");
        sb.append("name=");
        if( this.name == null ) {
            sb.append(this.name);
        }else{
            sb.append("'").append(this.name).append("'");
        }
        sb.append(", ");
        sb.append("overdueCancellationPolicy=").append(this.overdueCancellationPolicy);
        sb.append(", ");
        sb.append("overdueCondition=").append(this.overdueCondition);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends OverdueStateImp.Builder<T>> {

        protected Duration autoReevaluationInterval;
        protected String externalMessage;
        protected boolean isBlockChanges;
        protected boolean isClearState;
        protected boolean isDisableEntitlementAndChangesBlocked;
        protected String name;
        protected OverdueCancellationPolicy overdueCancellationPolicy;
        protected OverdueCondition overdueCondition;

        public Builder() { }
        public Builder(final Builder that) {
            this.autoReevaluationInterval = that.autoReevaluationInterval;
            this.externalMessage = that.externalMessage;
            this.isBlockChanges = that.isBlockChanges;
            this.isClearState = that.isClearState;
            this.isDisableEntitlementAndChangesBlocked = that.isDisableEntitlementAndChangesBlocked;
            this.name = that.name;
            this.overdueCancellationPolicy = that.overdueCancellationPolicy;
            this.overdueCondition = that.overdueCondition;
        }
        public T withAutoReevaluationInterval(final Duration autoReevaluationInterval) {
            this.autoReevaluationInterval = autoReevaluationInterval;
            return (T) this;
        }
        public T withExternalMessage(final String externalMessage) {
            this.externalMessage = externalMessage;
            return (T) this;
        }
        public T withIsBlockChanges(final boolean isBlockChanges) {
            this.isBlockChanges = isBlockChanges;
            return (T) this;
        }
        public T withIsClearState(final boolean isClearState) {
            this.isClearState = isClearState;
            return (T) this;
        }
        public T withIsDisableEntitlementAndChangesBlocked(final boolean isDisableEntitlementAndChangesBlocked) {
            this.isDisableEntitlementAndChangesBlocked = isDisableEntitlementAndChangesBlocked;
            return (T) this;
        }
        public T withName(final String name) {
            this.name = name;
            return (T) this;
        }
        public T withOverdueCancellationPolicy(final OverdueCancellationPolicy overdueCancellationPolicy) {
            this.overdueCancellationPolicy = overdueCancellationPolicy;
            return (T) this;
        }
        public T withOverdueCondition(final OverdueCondition overdueCondition) {
            this.overdueCondition = overdueCondition;
            return (T) this;
        }
        public T source(final OverdueState that) throws OverdueApiException {
            this.autoReevaluationInterval = that.getAutoReevaluationInterval();
            this.externalMessage = that.getExternalMessage();
            this.isBlockChanges = that.isBlockChanges();
            this.isClearState = that.isClearState();
            this.isDisableEntitlementAndChangesBlocked = that.isDisableEntitlementAndChangesBlocked();
            this.name = that.getName();
            this.overdueCancellationPolicy = that.getOverdueCancellationPolicy();
            this.overdueCondition = that.getOverdueCondition();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public OverdueStateImp build() {
            return new OverdueStateImp(this.validate());
        }
    }
}
