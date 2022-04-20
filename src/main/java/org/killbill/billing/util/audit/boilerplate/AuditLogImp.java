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

package org.killbill.billing.util.audit.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.killbill.billing.ObjectType;
import org.killbill.billing.util.audit.AuditLog;
import org.killbill.billing.util.audit.ChangeType;

@JsonDeserialize( builder = AuditLogImp.Builder.class )
public class AuditLogImp implements AuditLog {

    protected UUID auditedEntityId;
    protected ObjectType auditedObjectType;
    protected ChangeType changeType;
    protected String comment;
    protected DateTime createdDate;
    protected UUID id;
    protected String reasonCode;
    protected DateTime updatedDate;
    protected String userName;
    protected String userToken;

    public AuditLogImp(final AuditLogImp that) {
        this.auditedEntityId = that.auditedEntityId;
        this.auditedObjectType = that.auditedObjectType;
        this.changeType = that.changeType;
        this.comment = that.comment;
        this.createdDate = that.createdDate;
        this.id = that.id;
        this.reasonCode = that.reasonCode;
        this.updatedDate = that.updatedDate;
        this.userName = that.userName;
        this.userToken = that.userToken;
    }
    protected AuditLogImp(final AuditLogImp.Builder<?> builder) {
        this.auditedEntityId = builder.auditedEntityId;
        this.auditedObjectType = builder.auditedObjectType;
        this.changeType = builder.changeType;
        this.comment = builder.comment;
        this.createdDate = builder.createdDate;
        this.id = builder.id;
        this.reasonCode = builder.reasonCode;
        this.updatedDate = builder.updatedDate;
        this.userName = builder.userName;
        this.userToken = builder.userToken;
    }
    protected AuditLogImp() { }
    @Override
    public UUID getAuditedEntityId() {
        return this.auditedEntityId;
    }
    @Override
    public ObjectType getAuditedObjectType() {
        return this.auditedObjectType;
    }
    @Override
    public ChangeType getChangeType() {
        return this.changeType;
    }
    @Override
    public String getComment() {
        return this.comment;
    }
    @Override
    public DateTime getCreatedDate() {
        return this.createdDate;
    }
    @Override
    public UUID getId() {
        return this.id;
    }
    @Override
    public String getReasonCode() {
        return this.reasonCode;
    }
    @Override
    public DateTime getUpdatedDate() {
        return this.updatedDate;
    }
    @Override
    public String getUserName() {
        return this.userName;
    }
    @Override
    public String getUserToken() {
        return this.userToken;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final AuditLogImp that = (AuditLogImp) o;
        if( !Objects.equals(this.auditedEntityId, that.auditedEntityId) ) {
            return false;
        }
        if( !Objects.equals(this.auditedObjectType, that.auditedObjectType) ) {
            return false;
        }
        if( !Objects.equals(this.changeType, that.changeType) ) {
            return false;
        }
        if( !Objects.equals(this.comment, that.comment) ) {
            return false;
        }
        if( ( this.createdDate != null ) ? ( 0 != this.createdDate.compareTo(that.createdDate) ) : ( that.createdDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.id, that.id) ) {
            return false;
        }
        if( !Objects.equals(this.reasonCode, that.reasonCode) ) {
            return false;
        }
        if( ( this.updatedDate != null ) ? ( 0 != this.updatedDate.compareTo(that.updatedDate) ) : ( that.updatedDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.userName, that.userName) ) {
            return false;
        }
        if( !Objects.equals(this.userToken, that.userToken) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.auditedEntityId);
        result = ( 31 * result ) + Objects.hashCode(this.auditedObjectType);
        result = ( 31 * result ) + Objects.hashCode(this.changeType);
        result = ( 31 * result ) + Objects.hashCode(this.comment);
        result = ( 31 * result ) + Objects.hashCode(this.createdDate);
        result = ( 31 * result ) + Objects.hashCode(this.id);
        result = ( 31 * result ) + Objects.hashCode(this.reasonCode);
        result = ( 31 * result ) + Objects.hashCode(this.updatedDate);
        result = ( 31 * result ) + Objects.hashCode(this.userName);
        result = ( 31 * result ) + Objects.hashCode(this.userToken);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("auditedEntityId=").append(this.auditedEntityId);
        sb.append(", ");
        sb.append("auditedObjectType=").append(this.auditedObjectType);
        sb.append(", ");
        sb.append("changeType=").append(this.changeType);
        sb.append(", ");
        sb.append("comment=");
        if( this.comment == null ) {
            sb.append(this.comment);
        }else{
            sb.append("'").append(this.comment).append("'");
        }
        sb.append(", ");
        sb.append("createdDate=").append(this.createdDate);
        sb.append(", ");
        sb.append("id=").append(this.id);
        sb.append(", ");
        sb.append("reasonCode=");
        if( this.reasonCode == null ) {
            sb.append(this.reasonCode);
        }else{
            sb.append("'").append(this.reasonCode).append("'");
        }
        sb.append(", ");
        sb.append("updatedDate=").append(this.updatedDate);
        sb.append(", ");
        sb.append("userName=");
        if( this.userName == null ) {
            sb.append(this.userName);
        }else{
            sb.append("'").append(this.userName).append("'");
        }
        sb.append(", ");
        sb.append("userToken=");
        if( this.userToken == null ) {
            sb.append(this.userToken);
        }else{
            sb.append("'").append(this.userToken).append("'");
        }
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends AuditLogImp.Builder<T>> {

        protected UUID auditedEntityId;
        protected ObjectType auditedObjectType;
        protected ChangeType changeType;
        protected String comment;
        protected DateTime createdDate;
        protected UUID id;
        protected String reasonCode;
        protected DateTime updatedDate;
        protected String userName;
        protected String userToken;

        public Builder() { }
        public Builder(final Builder that) {
            this.auditedEntityId = that.auditedEntityId;
            this.auditedObjectType = that.auditedObjectType;
            this.changeType = that.changeType;
            this.comment = that.comment;
            this.createdDate = that.createdDate;
            this.id = that.id;
            this.reasonCode = that.reasonCode;
            this.updatedDate = that.updatedDate;
            this.userName = that.userName;
            this.userToken = that.userToken;
        }
        public T withAuditedEntityId(final UUID auditedEntityId) {
            this.auditedEntityId = auditedEntityId;
            return (T) this;
        }
        public T withAuditedObjectType(final ObjectType auditedObjectType) {
            this.auditedObjectType = auditedObjectType;
            return (T) this;
        }
        public T withChangeType(final ChangeType changeType) {
            this.changeType = changeType;
            return (T) this;
        }
        public T withComment(final String comment) {
            this.comment = comment;
            return (T) this;
        }
        public T withCreatedDate(final DateTime createdDate) {
            this.createdDate = createdDate;
            return (T) this;
        }
        public T withId(final UUID id) {
            this.id = id;
            return (T) this;
        }
        public T withReasonCode(final String reasonCode) {
            this.reasonCode = reasonCode;
            return (T) this;
        }
        public T withUpdatedDate(final DateTime updatedDate) {
            this.updatedDate = updatedDate;
            return (T) this;
        }
        public T withUserName(final String userName) {
            this.userName = userName;
            return (T) this;
        }
        public T withUserToken(final String userToken) {
            this.userToken = userToken;
            return (T) this;
        }
        public T source(final AuditLog that) {
            this.auditedEntityId = that.getAuditedEntityId();
            this.auditedObjectType = that.getAuditedObjectType();
            this.changeType = that.getChangeType();
            this.comment = that.getComment();
            this.createdDate = that.getCreatedDate();
            this.id = that.getId();
            this.reasonCode = that.getReasonCode();
            this.updatedDate = that.getUpdatedDate();
            this.userName = that.getUserName();
            this.userToken = that.getUserToken();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public AuditLogImp build() {
            return new AuditLogImp(this.validate());
        }
    }
}
