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
import org.killbill.billing.overdue.api.OverdueConfig;
import org.killbill.billing.overdue.api.OverdueStatesAccount;

@JsonDeserialize( builder = OverdueConfigImp.Builder.class )
public class OverdueConfigImp implements OverdueConfig {

    protected OverdueStatesAccount overdueStatesAccount;

    public OverdueConfigImp(final OverdueConfigImp that) {
        this.overdueStatesAccount = that.overdueStatesAccount;
    }
    protected OverdueConfigImp(final OverdueConfigImp.Builder<?> builder) {
        this.overdueStatesAccount = builder.overdueStatesAccount;
    }
    protected OverdueConfigImp() { }
    @Override
    public OverdueStatesAccount getOverdueStatesAccount() {
        return this.overdueStatesAccount;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final OverdueConfigImp that = (OverdueConfigImp) o;
        if( !Objects.equals(this.overdueStatesAccount, that.overdueStatesAccount) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.overdueStatesAccount);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("overdueStatesAccount=").append(this.overdueStatesAccount);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends OverdueConfigImp.Builder<T>> {

        protected OverdueStatesAccount overdueStatesAccount;

        public Builder() { }
        public Builder(final Builder that) {
            this.overdueStatesAccount = that.overdueStatesAccount;
        }
        public T withOverdueStatesAccount(final OverdueStatesAccount overdueStatesAccount) {
            this.overdueStatesAccount = overdueStatesAccount;
            return (T) this;
        }
        public T source(final OverdueConfig that) {
            this.overdueStatesAccount = that.getOverdueStatesAccount();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public OverdueConfigImp build() {
            return new OverdueConfigImp(this.validate());
        }
    }
}
