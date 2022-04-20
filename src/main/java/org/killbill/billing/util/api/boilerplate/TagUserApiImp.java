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

package org.killbill.billing.util.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import org.killbill.billing.ObjectType;
import org.killbill.billing.util.api.AuditLevel;
import org.killbill.billing.util.api.TagApiException;
import org.killbill.billing.util.api.TagDefinitionApiException;
import org.killbill.billing.util.api.TagUserApi;
import org.killbill.billing.util.audit.AuditLogWithHistory;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;
import org.killbill.billing.util.entity.Pagination;
import org.killbill.billing.util.tag.Tag;
import org.killbill.billing.util.tag.TagDefinition;

@JsonDeserialize( builder = TagUserApiImp.Builder.class )
public class TagUserApiImp implements TagUserApi {

    private static final long serialVersionUID = 0xEDC141D1F9BD398AL;


    public TagUserApiImp(final TagUserApiImp that) {
    }
    protected TagUserApiImp(final TagUserApiImp.Builder<?> builder) {
    }
    protected TagUserApiImp() { }
    @Override
    public void addTags(final UUID objectId, final ObjectType objectType, final Collection<UUID> tagDefinitionIds, final CallContext context) {
        throw new UnsupportedOperationException("addTags(java.util.UUID, org.killbill.billing.ObjectType, java.util.Collection<java.util.UUID>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public void removeTags(final UUID objectId, final ObjectType objectType, final Collection<UUID> tagDefinitions, final CallContext context) {
        throw new UnsupportedOperationException("removeTags(java.util.UUID, org.killbill.billing.ObjectType, java.util.Collection<java.util.UUID>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<TagDefinition> getTagDefinitions(final TenantContext context) {
        throw new UnsupportedOperationException("getTagDefinitions(org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Pagination<Tag> searchTags(final String searchKey, final Long offset, final Long limit, final TenantContext context) {
        throw new UnsupportedOperationException("searchTags(java.lang.String, java.lang.Long, java.lang.Long, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<Tag> getTagsForObject(final UUID objectId, final ObjectType objectType, final boolean includedDeleted, final TenantContext context) {
        throw new UnsupportedOperationException("getTagsForObject(java.util.UUID, org.killbill.billing.ObjectType, boolean, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Pagination<Tag> getTags(final Long offset, final Long limit, final TenantContext context) {
        throw new UnsupportedOperationException("getTags(java.lang.Long, java.lang.Long, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<TagDefinition> getTagDefinitions(final Collection<UUID> tagDefinitionIds, final TenantContext context) {
        throw new UnsupportedOperationException("getTagDefinitions(java.util.Collection<java.util.UUID>, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public TagDefinition createTagDefinition(final String definitionName, final String description, final Set<ObjectType> applicableObjectTypes, final CallContext context) {
        throw new UnsupportedOperationException("createTagDefinition(java.lang.String, java.lang.String, java.util.Set<org.killbill.billing.ObjectType>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<Tag> getTagsForAccount(final UUID accountId, final boolean includedDeleted, final TenantContext context) {
        throw new UnsupportedOperationException("getTagsForAccount(java.util.UUID, boolean, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public TagDefinition getTagDefinition(final UUID tagDefinitionId, final TenantContext context) {
        throw new UnsupportedOperationException("getTagDefinition(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<Tag> getTagsForAccountType(final UUID accountId, final ObjectType objectType, final boolean includedDeleted, final TenantContext context) {
        throw new UnsupportedOperationException("getTagsForAccountType(java.util.UUID, org.killbill.billing.ObjectType, boolean, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void deleteTagDefinition(final UUID tagDefinitionId, final CallContext context) {
        throw new UnsupportedOperationException("deleteTagDefinition(java.util.UUID, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<AuditLogWithHistory> getTagAuditLogsWithHistoryForId(final UUID tagId, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getTagAuditLogsWithHistoryForId(java.util.UUID, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void addTag(final UUID objectId, final ObjectType objectType, final UUID tagDefinitionId, final CallContext context) {
        throw new UnsupportedOperationException("addTag(java.util.UUID, org.killbill.billing.ObjectType, java.util.UUID, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public TagDefinition getTagDefinitionForName(final String tageDefinitionName, final TenantContext context) {
        throw new UnsupportedOperationException("getTagDefinitionForName(java.lang.String, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public List<AuditLogWithHistory> getTagDefinitionAuditLogsWithHistoryForId(final UUID tagDefinitionId, final AuditLevel auditLevel, final TenantContext context) {
        throw new UnsupportedOperationException("getTagDefinitionAuditLogsWithHistoryForId(java.util.UUID, org.killbill.billing.util.api.AuditLevel, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void removeTag(final UUID objectId, final ObjectType objectType, final UUID tagDefinitionId, final CallContext context) {
        throw new UnsupportedOperationException("removeTag(java.util.UUID, org.killbill.billing.ObjectType, java.util.UUID, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends TagUserApiImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final TagUserApi that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public TagUserApiImp build() {
            return new TagUserApiImp(this.validate());
        }
    }
}
