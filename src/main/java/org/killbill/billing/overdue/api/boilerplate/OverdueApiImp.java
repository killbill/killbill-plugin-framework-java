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

package org.killbill.billing.overdue.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.killbill.billing.overdue.api.OverdueApi;
import org.killbill.billing.overdue.api.OverdueApiException;
import org.killbill.billing.overdue.api.OverdueConfig;
import org.killbill.billing.overdue.api.OverdueState;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;

@JsonDeserialize( builder = OverdueApiImp.Builder.class )
public class OverdueApiImp implements OverdueApi {

    private static final long serialVersionUID = 0xB51D1B98180BE0EBL;


    public OverdueApiImp(final OverdueApiImp that) {
    }
    protected OverdueApiImp(final OverdueApiImp.Builder<?> builder) {
    }
    protected OverdueApiImp() { }
    @Override
    public void uploadOverdueConfig(final OverdueConfig overdueConfig, final CallContext callContext) {
        throw new UnsupportedOperationException("uploadOverdueConfig(org.killbill.billing.overdue.api.OverdueConfig, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public OverdueState getOverdueStateFor(final UUID accountId, final TenantContext context) {
        throw new UnsupportedOperationException("getOverdueStateFor(java.util.UUID, org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
    }
    @Override
    public void uploadOverdueConfig(final String overdueXML, final CallContext context) {
        throw new UnsupportedOperationException("uploadOverdueConfig(java.lang.String, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public OverdueConfig getOverdueConfig(final TenantContext context) {
        throw new UnsupportedOperationException("getOverdueConfig(org.killbill.billing.util.callcontext.TenantContext) must be implemented.");
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
    public static class Builder<T extends OverdueApiImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final OverdueApi that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public OverdueApiImp build() {
            return new OverdueApiImp(this.validate());
        }
    }
}
