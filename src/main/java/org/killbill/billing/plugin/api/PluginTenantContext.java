/*
 * Copyright 2014-2015 Groupon, Inc
 * Copyright 2014-2015 The Billing Project, LLC
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

import org.killbill.billing.util.callcontext.TenantContext;

public class PluginTenantContext implements TenantContext {

    protected final UUID tenantId;

    public PluginTenantContext(final UUID tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public UUID getTenantId() {
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PluginTenantContext{");
        sb.append("tenantId=").append(tenantId);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final PluginTenantContext that = (PluginTenantContext) o;

        if (tenantId != null ? !tenantId.equals(that.tenantId) : that.tenantId != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return tenantId != null ? tenantId.hashCode() : 0;
    }
}
