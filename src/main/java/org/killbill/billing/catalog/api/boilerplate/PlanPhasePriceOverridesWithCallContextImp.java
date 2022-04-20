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

package org.killbill.billing.catalog.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.killbill.billing.catalog.api.PlanPhasePriceOverride;
import org.killbill.billing.catalog.api.PlanPhasePriceOverridesWithCallContext;
import org.killbill.billing.util.callcontext.CallContext;

@JsonDeserialize( builder = PlanPhasePriceOverridesWithCallContextImp.Builder.class )
public class PlanPhasePriceOverridesWithCallContextImp implements PlanPhasePriceOverridesWithCallContext {

    protected CallContext callContext;
    protected List<PlanPhasePriceOverride> overrides;

    public PlanPhasePriceOverridesWithCallContextImp(final PlanPhasePriceOverridesWithCallContextImp that) {
        this.callContext = that.callContext;
        this.overrides = that.overrides;
    }
    protected PlanPhasePriceOverridesWithCallContextImp(final PlanPhasePriceOverridesWithCallContextImp.Builder<?> builder) {
        this.callContext = builder.callContext;
        this.overrides = builder.overrides;
    }
    protected PlanPhasePriceOverridesWithCallContextImp() { }
    @Override
    public CallContext getCallContext() {
        return this.callContext;
    }
    @Override
    public List<PlanPhasePriceOverride> getOverrides() {
        return this.overrides;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PlanPhasePriceOverridesWithCallContextImp that = (PlanPhasePriceOverridesWithCallContextImp) o;
        if( !Objects.equals(this.callContext, that.callContext) ) {
            return false;
        }
        if( !Objects.equals(this.overrides, that.overrides) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.callContext);
        result = ( 31 * result ) + Objects.hashCode(this.overrides);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("callContext=").append(this.callContext);
        sb.append(", ");
        sb.append("overrides=").append(this.overrides);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PlanPhasePriceOverridesWithCallContextImp.Builder<T>> {

        protected CallContext callContext;
        protected List<PlanPhasePriceOverride> overrides;

        public Builder() { }
        public Builder(final Builder that) {
            this.callContext = that.callContext;
            this.overrides = that.overrides;
        }
        public T withCallContext(final CallContext callContext) {
            this.callContext = callContext;
            return (T) this;
        }
        public T withOverrides(final List<PlanPhasePriceOverride> overrides) {
            this.overrides = overrides;
            return (T) this;
        }
        public T source(final PlanPhasePriceOverridesWithCallContext that) {
            this.callContext = that.getCallContext();
            this.overrides = that.getOverrides();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PlanPhasePriceOverridesWithCallContextImp build() {
            return new PlanPhasePriceOverridesWithCallContextImp(this.validate());
        }
    }
}
