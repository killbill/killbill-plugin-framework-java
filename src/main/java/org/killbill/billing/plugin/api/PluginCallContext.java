/*
 * Copyright 2014-2020 Groupon, Inc
 * Copyright 2020-2020 Equinix, Inc
 * Copyright 2014-2020 The Billing Project, LLC
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

package org.killbill.billing.plugin.api;

import java.util.UUID;

import org.joda.time.DateTime;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.CallOrigin;
import org.killbill.billing.util.callcontext.UserType;
import org.killbill.billing.util.callcontext.boilerplate.CallContextImp;

@JsonDeserialize( builder = PluginCallContext.Builder.class )
public class PluginCallContext extends CallContextImp {

    public PluginCallContext(final String pluginName, final DateTime utcNow, final UUID accountId, final UUID tenantId) {
        this(UUID.randomUUID(),
                pluginName,
                CallOrigin.EXTERNAL,
                UserType.SYSTEM,
                null,
                null,
                utcNow,
                utcNow,
                accountId,
                tenantId);
    }

    public PluginCallContext(final UUID userToken,
            final String userName,
            final CallOrigin callOrigin,
            final UserType userType,
            final String reasonCode,
            final String comments,
            final DateTime createdDate,
            final DateTime updatedDate,
            final UUID accountId,
            final UUID tenantId) {
        this(new Builder<>() 
                .withUserToken(userToken)
                .withUserName(userName)
                .withCallOrigin(callOrigin)
                .withUserType(userType)
                .withReasonCode(reasonCode)
                .withComments(comments)
                .withCreatedDate(createdDate)
                .withUpdatedDate(updatedDate)
                .withAccountId(accountId)
                .withTenantId(tenantId)
                .validate());
    }

    protected PluginCallContext(final PluginCallContext.Builder<?> builder) {
        super(builder);
    }

    public PluginCallContext(final PluginCallContext that) {
        super(that);
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PluginCallContext.Builder<T>>
        extends CallContextImp.Builder<T> {

        public Builder() {
            this.withUserToken(UUID.randomUUID());
            this.withCallOrigin(CallOrigin.EXTERNAL);
            this.withUserType(UserType.SYSTEM);
        }

        public Builder(final Builder that) {
            super(that);
        }

        @Override
        public Builder validate() {
            return this;
        }

        @Override
        public PluginCallContext build() {
            return new PluginCallContext(this.validate());
        }
    }
}
