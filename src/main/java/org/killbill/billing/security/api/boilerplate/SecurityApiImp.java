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

package org.killbill.billing.security.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.killbill.billing.security.Logical;
import org.killbill.billing.security.Permission;
import org.killbill.billing.security.SecurityApiException;
import org.killbill.billing.security.api.SecurityApi;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;

@JsonDeserialize( builder = SecurityApiImp.Builder.class )
public class SecurityApiImp implements SecurityApi {

    protected boolean isSubjectAuthenticated;

    public SecurityApiImp(final SecurityApiImp that) {
        this.isSubjectAuthenticated = that.isSubjectAuthenticated;
    }
    protected SecurityApiImp(final SecurityApiImp.Builder<?> builder) {
        this.isSubjectAuthenticated = builder.isSubjectAuthenticated;
    }
    protected SecurityApiImp() { }
    @Override
    @JsonGetter("isSubjectAuthenticated")
    public boolean isSubjectAuthenticated() {
        return this.isSubjectAuthenticated;
    }
    @Override
    public void addUserRoles(final String username, final String clearPassword, final List<String> roles, final CallContext context) {
        throw new UnsupportedOperationException("addUserRoles(java.lang.String, java.lang.String, java.util.List<java.lang.String>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public void checkCurrentUserPermissions(final List<Permission> permissions, final Logical logical, final TenantContext context) {
        throw new UnsupportedOperationException("checkCurrentUserPermissions(java.util.List<org.killbill.billing.security.Permission>, org.killbill.billing.security.Logical, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public Set<String> getCurrentUserPermissions(final TenantContext context) {
        throw new UnsupportedOperationException("getCurrentUserPermissions(org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void login(final Object principal, final Object credentials) {
        throw new UnsupportedOperationException("login(java.lang.Object, java.lang.Object) must be implemented.");
    }
    @Override
    public void logout() {
        throw new UnsupportedOperationException("logout() must be implemented.");
    }
    @Override
    public List<String> getRoleDefinition(final String role, final TenantContext tenantContext) {
        throw new UnsupportedOperationException("getRoleDefinition(java.lang.String, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void updateRoleDefinition(final String role, final List<String> permissions, final CallContext context) {
        throw new UnsupportedOperationException("updateRoleDefinition(java.lang.String, java.util.List<java.lang.String>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public void invalidateUser(final String username, final CallContext context) {
        throw new UnsupportedOperationException("invalidateUser(java.lang.String, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public List<String> getUserRoles(final String username, final TenantContext tenantContext) {
        throw new UnsupportedOperationException("getUserRoles(java.lang.String, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void updateUserRoles(final String username, final List<String> roles, final CallContext context) {
        throw new UnsupportedOperationException("updateUserRoles(java.lang.String, java.util.List<java.lang.String>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public void addRoleDefinition(final String role, final List<String> permissions, final CallContext context) {
        throw new UnsupportedOperationException("addRoleDefinition(java.lang.String, java.util.List<java.lang.String>, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public void updateUserPassword(final String username, final String clearPassword, final CallContext context) {
        throw new UnsupportedOperationException("updateUserPassword(java.lang.String, java.lang.String, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final SecurityApiImp that = (SecurityApiImp) o;
        if( this.isSubjectAuthenticated != that.isSubjectAuthenticated ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.isSubjectAuthenticated);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("isSubjectAuthenticated=").append(this.isSubjectAuthenticated);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends SecurityApiImp.Builder<T>> {

        protected boolean isSubjectAuthenticated;

        public Builder() { }
        public Builder(final Builder that) {
            this.isSubjectAuthenticated = that.isSubjectAuthenticated;
        }
        public T withIsSubjectAuthenticated(final boolean isSubjectAuthenticated) {
            this.isSubjectAuthenticated = isSubjectAuthenticated;
            return (T) this;
        }
        public T source(final SecurityApi that) {
            this.isSubjectAuthenticated = that.isSubjectAuthenticated();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public SecurityApiImp build() {
            return new SecurityApiImp(this.validate());
        }
    }
}
