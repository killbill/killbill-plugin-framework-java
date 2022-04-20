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
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.killbill.billing.entitlement.api.BlockingState;
import org.killbill.billing.entitlement.api.BlockingStateType;

@JsonDeserialize( builder = BlockingStateImp.Builder.class )
public class BlockingStateImp implements BlockingState {

    private static final long serialVersionUID = 0x31C0C2B0A0CB238AL;

    protected UUID blockedId;
    protected DateTime createdDate;
    protected String description;
    protected DateTime effectiveDate;
    protected UUID id;
    protected boolean isBlockBilling;
    protected boolean isBlockChange;
    protected boolean isBlockEntitlement;
    protected String service;
    protected String stateName;
    protected BlockingStateType type;
    protected DateTime updatedDate;

    public BlockingStateImp(final BlockingStateImp that) {
        this.blockedId = that.blockedId;
        this.createdDate = that.createdDate;
        this.description = that.description;
        this.effectiveDate = that.effectiveDate;
        this.id = that.id;
        this.isBlockBilling = that.isBlockBilling;
        this.isBlockChange = that.isBlockChange;
        this.isBlockEntitlement = that.isBlockEntitlement;
        this.service = that.service;
        this.stateName = that.stateName;
        this.type = that.type;
        this.updatedDate = that.updatedDate;
    }
    protected BlockingStateImp(final BlockingStateImp.Builder<?> builder) {
        this.blockedId = builder.blockedId;
        this.createdDate = builder.createdDate;
        this.description = builder.description;
        this.effectiveDate = builder.effectiveDate;
        this.id = builder.id;
        this.isBlockBilling = builder.isBlockBilling;
        this.isBlockChange = builder.isBlockChange;
        this.isBlockEntitlement = builder.isBlockEntitlement;
        this.service = builder.service;
        this.stateName = builder.stateName;
        this.type = builder.type;
        this.updatedDate = builder.updatedDate;
    }
    protected BlockingStateImp() { }
    @Override
    public UUID getBlockedId() {
        return this.blockedId;
    }
    @Override
    public DateTime getCreatedDate() {
        return this.createdDate;
    }
    @Override
    public String getDescription() {
        return this.description;
    }
    @Override
    public DateTime getEffectiveDate() {
        return this.effectiveDate;
    }
    @Override
    public UUID getId() {
        return this.id;
    }
    @Override
    @JsonGetter("isBlockBilling")
    public boolean isBlockBilling() {
        return this.isBlockBilling;
    }
    @Override
    @JsonGetter("isBlockChange")
    public boolean isBlockChange() {
        return this.isBlockChange;
    }
    @Override
    @JsonGetter("isBlockEntitlement")
    public boolean isBlockEntitlement() {
        return this.isBlockEntitlement;
    }
    @Override
    public String getService() {
        return this.service;
    }
    @Override
    public String getStateName() {
        return this.stateName;
    }
    @Override
    public BlockingStateType getType() {
        return this.type;
    }
    @Override
    public DateTime getUpdatedDate() {
        return this.updatedDate;
    }
    @Override
    public int compareTo(final BlockingState arg0) {
        throw new UnsupportedOperationException("compareTo(org.killbill.billing.entitlement.api.BlockingState) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final BlockingStateImp that = (BlockingStateImp) o;
        if( !Objects.equals(this.blockedId, that.blockedId) ) {
            return false;
        }
        if( ( this.createdDate != null ) ? ( 0 != this.createdDate.compareTo(that.createdDate) ) : ( that.createdDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.description, that.description) ) {
            return false;
        }
        if( ( this.effectiveDate != null ) ? ( 0 != this.effectiveDate.compareTo(that.effectiveDate) ) : ( that.effectiveDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.id, that.id) ) {
            return false;
        }
        if( this.isBlockBilling != that.isBlockBilling ) {
            return false;
        }
        if( this.isBlockChange != that.isBlockChange ) {
            return false;
        }
        if( this.isBlockEntitlement != that.isBlockEntitlement ) {
            return false;
        }
        if( !Objects.equals(this.service, that.service) ) {
            return false;
        }
        if( !Objects.equals(this.stateName, that.stateName) ) {
            return false;
        }
        if( !Objects.equals(this.type, that.type) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.blockedId);
        result = ( 31 * result ) + Objects.hashCode(this.createdDate);
        result = ( 31 * result ) + Objects.hashCode(this.description);
        result = ( 31 * result ) + Objects.hashCode(this.effectiveDate);
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.isBlockBilling);
        result = ( 31 * result ) + Objects.hashCode(this.isBlockChange);
        result = ( 31 * result ) + Objects.hashCode(this.isBlockEntitlement);
        result = ( 31 * result ) + Objects.hashCode(this.service);
        result = ( 31 * result ) + Objects.hashCode(this.stateName);
        result = ( 31 * result ) + Objects.hashCode(this.type);
        result = ( 31 * result ) + Objects.hashCode(this.updatedDate);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("blockedId=").append(this.blockedId);
        sb.append(", ");
        sb.append("createdDate=").append(this.createdDate);
        sb.append(", ");
        sb.append("description=");
        if( this.description == null ) {
            sb.append(this.description);
        }else{
            sb.append("'").append(this.description).append("'");
        }
        sb.append(", ");
        sb.append("effectiveDate=").append(this.effectiveDate);
        sb.append(", ");
        sb.append("id=").append(this.id);
        sb.append(", ");
        sb.append("isBlockBilling=").append(this.isBlockBilling);
        sb.append(", ");
        sb.append("isBlockChange=").append(this.isBlockChange);
        sb.append(", ");
        sb.append("isBlockEntitlement=").append(this.isBlockEntitlement);
        sb.append(", ");
        sb.append("service=");
        if( this.service == null ) {
            sb.append(this.service);
        }else{
            sb.append("'").append(this.service).append("'");
        }
        sb.append(", ");
        sb.append("stateName=");
        if( this.stateName == null ) {
            sb.append(this.stateName);
        }else{
            sb.append("'").append(this.stateName).append("'");
        }
        sb.append(", ");
        sb.append("type=").append(this.type);
        sb.append(", ");
        sb.append("updatedDate=").append(this.updatedDate);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends BlockingStateImp.Builder<T>> {

        protected UUID blockedId;
        protected DateTime createdDate;
        protected String description;
        protected DateTime effectiveDate;
        protected UUID id;
        protected boolean isBlockBilling;
        protected boolean isBlockChange;
        protected boolean isBlockEntitlement;
        protected String service;
        protected String stateName;
        protected BlockingStateType type;
        protected DateTime updatedDate;

        public Builder() { }
        public Builder(final Builder that) {
            this.blockedId = that.blockedId;
            this.createdDate = that.createdDate;
            this.description = that.description;
            this.effectiveDate = that.effectiveDate;
            this.id = that.id;
            this.isBlockBilling = that.isBlockBilling;
            this.isBlockChange = that.isBlockChange;
            this.isBlockEntitlement = that.isBlockEntitlement;
            this.service = that.service;
            this.stateName = that.stateName;
            this.type = that.type;
            this.updatedDate = that.updatedDate;
        }
        public T withBlockedId(final UUID blockedId) {
            this.blockedId = blockedId;
            return (T) this;
        }
        public T withCreatedDate(final DateTime createdDate) {
            this.createdDate = createdDate;
            return (T) this;
        }
        public T withDescription(final String description) {
            this.description = description;
            return (T) this;
        }
        public T withEffectiveDate(final DateTime effectiveDate) {
            this.effectiveDate = effectiveDate;
            return (T) this;
        }
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withIsBlockBilling(final boolean isBlockBilling) {
            this.isBlockBilling = isBlockBilling;
            return (T) this;
        }
        public T withIsBlockChange(final boolean isBlockChange) {
            this.isBlockChange = isBlockChange;
            return (T) this;
        }
        public T withIsBlockEntitlement(final boolean isBlockEntitlement) {
            this.isBlockEntitlement = isBlockEntitlement;
            return (T) this;
        }
        public T withService(final String service) {
            this.service = service;
            return (T) this;
        }
        public T withStateName(final String stateName) {
            this.stateName = stateName;
            return (T) this;
        }
        public T withType(final BlockingStateType type) {
            this.type = type;
            return (T) this;
        }
        public T withUpdatedDate(final DateTime updatedDate) {
            this.updatedDate = updatedDate;
            return (T) this;
        }
        public T source(final BlockingState that) {
            this.blockedId = that.getBlockedId();
            this.createdDate = that.getCreatedDate();
            this.description = that.getDescription();
            this.effectiveDate = that.getEffectiveDate();
            this.id = that.getId();
            this.isBlockBilling = that.isBlockBilling();
            this.isBlockChange = that.isBlockChange();
            this.isBlockEntitlement = that.isBlockEntitlement();
            this.service = that.getService();
            this.stateName = that.getStateName();
            this.type = that.getType();
            this.updatedDate = that.getUpdatedDate();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public BlockingStateImp build() {
            return new BlockingStateImp(this.validate());
        }
    }
}
