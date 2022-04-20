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

package org.killbill.billing.payment.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.killbill.billing.payment.api.PaymentMethod;
import org.killbill.billing.payment.api.PaymentMethodPlugin;

@JsonDeserialize( builder = PaymentMethodImp.Builder.class )
public class PaymentMethodImp implements PaymentMethod {

    private static final long serialVersionUID = 0x56F76B45BF91919BL;

    protected UUID accountId;
    protected DateTime createdDate;
    protected String externalKey;
    protected UUID id;
    protected Boolean isActive;
    protected PaymentMethodPlugin pluginDetail;
    protected String pluginName;
    protected DateTime updatedDate;

    public PaymentMethodImp(final PaymentMethodImp that) {
        this.accountId = that.accountId;
        this.createdDate = that.createdDate;
        this.externalKey = that.externalKey;
        this.id = that.id;
        this.isActive = that.isActive;
        this.pluginDetail = that.pluginDetail;
        this.pluginName = that.pluginName;
        this.updatedDate = that.updatedDate;
    }
    protected PaymentMethodImp(final PaymentMethodImp.Builder<?> builder) {
        this.accountId = builder.accountId;
        this.createdDate = builder.createdDate;
        this.externalKey = builder.externalKey;
        this.id = builder.id;
        this.isActive = builder.isActive;
        this.pluginDetail = builder.pluginDetail;
        this.pluginName = builder.pluginName;
        this.updatedDate = builder.updatedDate;
    }
    protected PaymentMethodImp() { }
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
    @JsonGetter("isActive")
    public Boolean isActive() {
        return this.isActive;
    }
    @Override
    public PaymentMethodPlugin getPluginDetail() {
        return this.pluginDetail;
    }
    @Override
    public String getPluginName() {
        return this.pluginName;
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
        final PaymentMethodImp that = (PaymentMethodImp) o;
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
        if( !Objects.equals(this.isActive, that.isActive) ) {
            return false;
        }
        if( !Objects.equals(this.pluginDetail, that.pluginDetail) ) {
            return false;
        }
        if( !Objects.equals(this.pluginName, that.pluginName) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.isActive);
        result = ( 31 * result ) + Objects.hashCode(this.pluginDetail);
        result = ( 31 * result ) + Objects.hashCode(this.pluginName);
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
        sb.append("isActive=").append(this.isActive);
        sb.append(", ");
        sb.append("pluginDetail=").append(this.pluginDetail);
        sb.append(", ");
        sb.append("pluginName=");
        if( this.pluginName == null ) {
            sb.append(this.pluginName);
        }else{
            sb.append("'").append(this.pluginName).append("'");
        }
        sb.append(", ");
        sb.append("updatedDate=").append(this.updatedDate);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PaymentMethodImp.Builder<T>> {

        protected UUID accountId;
        protected DateTime createdDate;
        protected String externalKey;
        protected UUID id;
        protected Boolean isActive;
        protected PaymentMethodPlugin pluginDetail;
        protected String pluginName;
        protected DateTime updatedDate;

        public Builder() { }
        public Builder(final Builder that) {
            this.accountId = that.accountId;
            this.createdDate = that.createdDate;
            this.externalKey = that.externalKey;
            this.id = that.id;
            this.isActive = that.isActive;
            this.pluginDetail = that.pluginDetail;
            this.pluginName = that.pluginName;
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
        public T withIsActive(final Boolean isActive) {
            this.isActive = isActive;
            return (T) this;
        }
        public T withPluginDetail(final PaymentMethodPlugin pluginDetail) {
            this.pluginDetail = pluginDetail;
            return (T) this;
        }
        public T withPluginName(final String pluginName) {
            this.pluginName = pluginName;
            return (T) this;
        }
        public T withUpdatedDate(final DateTime updatedDate) {
            this.updatedDate = updatedDate;
            return (T) this;
        }
        public T source(final PaymentMethod that) {
            this.accountId = that.getAccountId();
            this.createdDate = that.getCreatedDate();
            this.externalKey = that.getExternalKey();
            this.id = that.getId();
            this.isActive = that.isActive();
            this.pluginDetail = that.getPluginDetail();
            this.pluginName = that.getPluginName();
            this.updatedDate = that.getUpdatedDate();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PaymentMethodImp build() {
            return new PaymentMethodImp(this.validate());
        }
    }
}
