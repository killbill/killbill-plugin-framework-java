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

package org.killbill.billing.entitlement.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.killbill.billing.entitlement.api.SubscriptionBundleTimeline;
import org.killbill.billing.entitlement.api.SubscriptionEvent;

@JsonDeserialize( builder = SubscriptionBundleTimelineImp.Builder.class )
public class SubscriptionBundleTimelineImp implements SubscriptionBundleTimeline {

    private static final long serialVersionUID = 0x318C9EEE4713FDCAL;

    protected UUID accountId;
    protected UUID bundleId;
    protected String externalKey;
    protected List<SubscriptionEvent> subscriptionEvents;

    public SubscriptionBundleTimelineImp(final SubscriptionBundleTimelineImp that) {
        this.accountId = that.accountId;
        this.bundleId = that.bundleId;
        this.externalKey = that.externalKey;
        this.subscriptionEvents = that.subscriptionEvents;
    }
    protected SubscriptionBundleTimelineImp(final SubscriptionBundleTimelineImp.Builder<?> builder) {
        this.accountId = builder.accountId;
        this.bundleId = builder.bundleId;
        this.externalKey = builder.externalKey;
        this.subscriptionEvents = builder.subscriptionEvents;
    }
    protected SubscriptionBundleTimelineImp() { }
    @Override
    public UUID getAccountId() {
        return this.accountId;
    }
    @Override
    public UUID getBundleId() {
        return this.bundleId;
    }
    @Override
    public String getExternalKey() {
        return this.externalKey;
    }
    @Override
    public List<SubscriptionEvent> getSubscriptionEvents() {
        return this.subscriptionEvents;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final SubscriptionBundleTimelineImp that = (SubscriptionBundleTimelineImp) o;
        if( !Objects.equals(this.accountId, that.accountId) ) {
            return false;
        }
        if( !Objects.equals(this.bundleId, that.bundleId) ) {
            return false;
        }
        if( !Objects.equals(this.externalKey, that.externalKey) ) {
            return false;
        }
        if( !Objects.equals(this.subscriptionEvents, that.subscriptionEvents) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.accountId);
        result = ( 31 * result ) + Objects.hashCode(this.bundleId);
        result = ( 31 * result ) + Objects.hashCode(this.externalKey);
        result = ( 31 * result ) + Objects.hashCode(this.subscriptionEvents);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("accountId=").append(this.accountId);
        sb.append(", ");
        sb.append("bundleId=").append(this.bundleId);
        sb.append(", ");
        sb.append("externalKey=");
        if( this.externalKey == null ) {
            sb.append(this.externalKey);
        }else{
            sb.append("'").append(this.externalKey).append("'");
        }
        sb.append(", ");
        sb.append("subscriptionEvents=").append(this.subscriptionEvents);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends SubscriptionBundleTimelineImp.Builder<T>> {

        protected UUID accountId;
        protected UUID bundleId;
        protected String externalKey;
        protected List<SubscriptionEvent> subscriptionEvents;

        public Builder() { }
        public Builder(final Builder that) {
            this.accountId = that.accountId;
            this.bundleId = that.bundleId;
            this.externalKey = that.externalKey;
            this.subscriptionEvents = that.subscriptionEvents;
        }
        public T withAccountId(final UUID accountId) {
            this.accountId = accountId;
            return (T) this;
        }
        public T withBundleId(final UUID bundleId) {
            this.bundleId = bundleId;
            return (T) this;
        }
        public T withExternalKey(final String externalKey) {
            this.externalKey = externalKey;
            return (T) this;
        }
        public T withSubscriptionEvents(final List<SubscriptionEvent> subscriptionEvents) {
            this.subscriptionEvents = subscriptionEvents;
            return (T) this;
        }
        public T source(final SubscriptionBundleTimeline that) {
            this.accountId = that.getAccountId();
            this.bundleId = that.getBundleId();
            this.externalKey = that.getExternalKey();
            this.subscriptionEvents = that.getSubscriptionEvents();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public SubscriptionBundleTimelineImp build() {
            return new SubscriptionBundleTimelineImp(this.validate());
        }
    }
}
