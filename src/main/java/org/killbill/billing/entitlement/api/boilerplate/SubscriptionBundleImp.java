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
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.killbill.billing.entitlement.api.Subscription;
import org.killbill.billing.entitlement.api.SubscriptionBundle;
import org.killbill.billing.entitlement.api.SubscriptionBundleTimeline;

@JsonDeserialize( builder = SubscriptionBundleImp.Builder.class )
public class SubscriptionBundleImp implements SubscriptionBundle, Serializable {

    private static final long serialVersionUID = 0x31F82D72491256B4L;

    protected UUID accountId;
    protected DateTime createdDate;
    protected String externalKey;
    protected UUID id;
    protected DateTime originalCreatedDate;
    protected List<Subscription> subscriptions;
    protected SubscriptionBundleTimeline timeline;
    protected DateTime updatedDate;

    public SubscriptionBundleImp(final SubscriptionBundleImp that) {
        this.accountId = that.accountId;
        this.createdDate = that.createdDate;
        this.externalKey = that.externalKey;
        this.id = that.id;
        this.originalCreatedDate = that.originalCreatedDate;
        this.subscriptions = that.subscriptions;
        this.timeline = that.timeline;
        this.updatedDate = that.updatedDate;
    }
    protected SubscriptionBundleImp(final SubscriptionBundleImp.Builder<?> builder) {
        this.accountId = builder.accountId;
        this.createdDate = builder.createdDate;
        this.externalKey = builder.externalKey;
        this.id = builder.id;
        this.originalCreatedDate = builder.originalCreatedDate;
        this.subscriptions = builder.subscriptions;
        this.timeline = builder.timeline;
        this.updatedDate = builder.updatedDate;
    }
    protected SubscriptionBundleImp() { }
    @Override
    public UUID getAccountId() {
        return this.accountId;
    }
    @Override
    public DateTime getCreatedDate() {
        return this.createdDate;
    }
    @Override
    public String getExternalKey() {
        return this.externalKey;
    }
    @Override
    public UUID getId() {
        return this.id;
    }
    @Override
    public DateTime getOriginalCreatedDate() {
        return this.originalCreatedDate;
    }
    @Override
    public List<Subscription> getSubscriptions() {
        return this.subscriptions;
    }
    @Override
    public SubscriptionBundleTimeline getTimeline() {
        return this.timeline;
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
        final SubscriptionBundleImp that = (SubscriptionBundleImp) o;
        if( !Objects.equals(this.accountId, that.accountId) ) {
            return false;
        }
        if( ( this.createdDate != null ) ? ( 0 != this.createdDate.compareTo(that.createdDate) ) : ( that.createdDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.externalKey, that.externalKey) ) {
            return false;
        }
        if( !Objects.equals(this.id, that.id) ) {
            return false;
        }
        if( ( this.originalCreatedDate != null ) ? ( 0 != this.originalCreatedDate.compareTo(that.originalCreatedDate) ) : ( that.originalCreatedDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.subscriptions, that.subscriptions) ) {
            return false;
        }
        if( !Objects.equals(this.timeline, that.timeline) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.externalKey);
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.originalCreatedDate);
        result = ( 31 * result ) + Objects.hashCode(this.subscriptions);
        result = ( 31 * result ) + Objects.hashCode(this.timeline);
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
        sb.append("externalKey=");
        if( this.externalKey == null ) {
            sb.append(this.externalKey);
        }else{
            sb.append("'").append(this.externalKey).append("'");
        }
        sb.append(", ");
        sb.append("id=").append(this.id);
        sb.append(", ");
        sb.append("originalCreatedDate=").append(this.originalCreatedDate);
        sb.append(", ");
        sb.append("subscriptions=").append(this.subscriptions);
        sb.append(", ");
        sb.append("timeline=").append(this.timeline);
        sb.append(", ");
        sb.append("updatedDate=").append(this.updatedDate);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends SubscriptionBundleImp.Builder<T>> {

        protected UUID accountId;
        protected DateTime createdDate;
        protected String externalKey;
        protected UUID id;
        protected DateTime originalCreatedDate;
        protected List<Subscription> subscriptions;
        protected SubscriptionBundleTimeline timeline;
        protected DateTime updatedDate;

        public Builder() { }
        public Builder(final Builder that) {
            this.accountId = that.accountId;
            this.createdDate = that.createdDate;
            this.externalKey = that.externalKey;
            this.id = that.id;
            this.originalCreatedDate = that.originalCreatedDate;
            this.subscriptions = that.subscriptions;
            this.timeline = that.timeline;
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
        public T withExternalKey(final String externalKey) {
            this.externalKey = externalKey;
            return (T) this;
        }
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withOriginalCreatedDate(final DateTime originalCreatedDate) {
            this.originalCreatedDate = originalCreatedDate;
            return (T) this;
        }
        public T withSubscriptions(final List<Subscription> subscriptions) {
            this.subscriptions = subscriptions;
            return (T) this;
        }
        public T withTimeline(final SubscriptionBundleTimeline timeline) {
            this.timeline = timeline;
            return (T) this;
        }
        public T withUpdatedDate(final DateTime updatedDate) {
            this.updatedDate = updatedDate;
            return (T) this;
        }
        public T source(final SubscriptionBundle that) {
            this.accountId = that.getAccountId();
            this.createdDate = that.getCreatedDate();
            this.externalKey = that.getExternalKey();
            this.id = that.getId();
            this.originalCreatedDate = that.getOriginalCreatedDate();
            this.subscriptions = that.getSubscriptions();
            this.timeline = that.getTimeline();
            this.updatedDate = that.getUpdatedDate();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public SubscriptionBundleImp build() {
            return new SubscriptionBundleImp(this.validate());
        }
    }
}
