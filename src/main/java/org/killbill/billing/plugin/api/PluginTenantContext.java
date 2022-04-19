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
import javax.annotation.Nullable;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.killbill.billing.util.callcontext.TenantContext;
import org.killbill.billing.util.callcontext.boilerplate.TenantContextImp;

@JsonDeserialize( builder = PluginTenantContext.Builder.class )
public class PluginTenantContext extends TenantContextImp {

    public PluginTenantContext(@Nullable final UUID accountId, final UUID tenantId) {
        this(new Builder<>()
        .withAccountId(accountId)
        .withTenantId(tenantId)
        .validate());
    }

    protected PluginTenantContext(final PluginTenantContext.Builder<?> builder) {
        super(builder);
    }

    public PluginTenantContext(final PluginTenantContext that) {
        super(that);
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PluginTenantContext.Builder<T>> 
        extends TenantContextImp.Builder<T> {

        public Builder() {
        }

        public Builder(final Builder that) {
            super(that);
        }

        @Override
        public Builder validate() {
            return this;
        }

        @Override
        public PluginTenantContext build() {
            return new PluginTenantContext(this.validate());
        }
    }
}
