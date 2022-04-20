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
import org.joda.time.Period;
import org.killbill.billing.overdue.api.OverdueState;
import org.killbill.billing.overdue.api.OverdueStatesAccount;

@JsonDeserialize( builder = OverdueStatesAccountImp.Builder.class )
public class OverdueStatesAccountImp implements OverdueStatesAccount {

    protected Period initialReevaluationInterval;
    protected OverdueState[] states;

    public OverdueStatesAccountImp(final OverdueStatesAccountImp that) {
        this.initialReevaluationInterval = that.initialReevaluationInterval;
        this.states = that.states;
    }
    protected OverdueStatesAccountImp(final OverdueStatesAccountImp.Builder<?> builder) {
        this.initialReevaluationInterval = builder.initialReevaluationInterval;
        this.states = builder.states;
    }
    protected OverdueStatesAccountImp() { }
    @Override
    public Period getInitialReevaluationInterval() {
        return this.initialReevaluationInterval;
    }
    @Override
    public OverdueState[] getStates() {
        return this.states;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final OverdueStatesAccountImp that = (OverdueStatesAccountImp) o;
        if( !Objects.equals(this.initialReevaluationInterval, that.initialReevaluationInterval) ) {
            return false;
        }
        if( !Arrays.deepEquals(this.states, that.states) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.initialReevaluationInterval);
        result = ( 31 * result ) + Arrays.deepHashCode(this.states);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("initialReevaluationInterval=").append(this.initialReevaluationInterval);
        sb.append(", ");
        sb.append("states=").append(Arrays.toString(this.states));
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends OverdueStatesAccountImp.Builder<T>> {

        protected Period initialReevaluationInterval;
        protected OverdueState[] states;

        public Builder() { }
        public Builder(final Builder that) {
            this.initialReevaluationInterval = that.initialReevaluationInterval;
            this.states = that.states;
        }
        public T withInitialReevaluationInterval(final Period initialReevaluationInterval) {
            this.initialReevaluationInterval = initialReevaluationInterval;
            return (T) this;
        }
        public T withStates(final OverdueState[] states) {
            this.states = states;
            return (T) this;
        }
        public T source(final OverdueStatesAccount that) {
            this.initialReevaluationInterval = that.getInitialReevaluationInterval();
            this.states = that.getStates();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public OverdueStatesAccountImp build() {
            return new OverdueStatesAccountImp(this.validate());
        }
    }
}
