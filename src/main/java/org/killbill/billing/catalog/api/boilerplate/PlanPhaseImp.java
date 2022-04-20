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
import java.util.Objects;
import org.killbill.billing.catalog.api.Duration;
import org.killbill.billing.catalog.api.Fixed;
import org.killbill.billing.catalog.api.PhaseType;
import org.killbill.billing.catalog.api.PlanPhase;
import org.killbill.billing.catalog.api.Recurring;
import org.killbill.billing.catalog.api.StaticCatalog;
import org.killbill.billing.catalog.api.Usage;

@JsonDeserialize( builder = PlanPhaseImp.Builder.class )
public class PlanPhaseImp implements PlanPhase {

    private static final long serialVersionUID = 0xAF49E600C9BB037DL;

    protected StaticCatalog catalog;
    protected Duration duration;
    protected Fixed fixed;
    protected String name;
    protected PhaseType phaseType;
    protected String prettyName;
    protected Recurring recurring;
    protected Usage[] usages;

    public PlanPhaseImp(final PlanPhaseImp that) {
        this.catalog = that.catalog;
        this.duration = that.duration;
        this.fixed = that.fixed;
        this.name = that.name;
        this.phaseType = that.phaseType;
        this.prettyName = that.prettyName;
        this.recurring = that.recurring;
        this.usages = that.usages;
    }
    protected PlanPhaseImp(final PlanPhaseImp.Builder<?> builder) {
        this.catalog = builder.catalog;
        this.duration = builder.duration;
        this.fixed = builder.fixed;
        this.name = builder.name;
        this.phaseType = builder.phaseType;
        this.prettyName = builder.prettyName;
        this.recurring = builder.recurring;
        this.usages = builder.usages;
    }
    protected PlanPhaseImp() { }
    @Override
    public StaticCatalog getCatalog() {
        return this.catalog;
    }
    @Override
    public Duration getDuration() {
        return this.duration;
    }
    @Override
    public Fixed getFixed() {
        return this.fixed;
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public PhaseType getPhaseType() {
        return this.phaseType;
    }
    @Override
    public String getPrettyName() {
        return this.prettyName;
    }
    @Override
    public Recurring getRecurring() {
        return this.recurring;
    }
    @Override
    public Usage[] getUsages() {
        return this.usages;
    }
    @Override
    public boolean compliesWithLimits(final String unit, final double value) {
        throw new UnsupportedOperationException("compliesWithLimits(java.lang.String, double) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PlanPhaseImp that = (PlanPhaseImp) o;
        if( !Objects.equals(this.catalog, that.catalog) ) {
            return false;
        }
        if( !Objects.equals(this.duration, that.duration) ) {
            return false;
        }
        if( !Objects.equals(this.fixed, that.fixed) ) {
            return false;
        }
        if( !Objects.equals(this.name, that.name) ) {
            return false;
        }
        if( !Objects.equals(this.phaseType, that.phaseType) ) {
            return false;
        }
        if( !Objects.equals(this.prettyName, that.prettyName) ) {
            return false;
        }
        if( !Objects.equals(this.recurring, that.recurring) ) {
            return false;
        }
        if( !Arrays.deepEquals(this.usages, that.usages) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.catalog);
        result = ( 31 * result ) + Objects.hashCode(this.duration);
        result = ( 31 * result ) + Objects.hashCode(this.fixed);
        result = ( 31 * result ) + Objects.hashCode(this.name);
        result = ( 31 * result ) + Objects.hashCode(this.phaseType);
        result = ( 31 * result ) + Objects.hashCode(this.prettyName);
        result = ( 31 * result ) + Objects.hashCode(this.recurring);
        result = ( 31 * result ) + Arrays.deepHashCode(this.usages);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("catalog=").append(this.catalog);
        sb.append(", ");
        sb.append("duration=").append(this.duration);
        sb.append(", ");
        sb.append("fixed=").append(this.fixed);
        sb.append(", ");
        sb.append("name=");
        if( this.name == null ) {
            sb.append(this.name);
        }else{
            sb.append("'").append(this.name).append("'");
        }
        sb.append(", ");
        sb.append("phaseType=").append(this.phaseType);
        sb.append(", ");
        sb.append("prettyName=");
        if( this.prettyName == null ) {
            sb.append(this.prettyName);
        }else{
            sb.append("'").append(this.prettyName).append("'");
        }
        sb.append(", ");
        sb.append("recurring=").append(this.recurring);
        sb.append(", ");
        sb.append("usages=").append(Arrays.toString(this.usages));
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PlanPhaseImp.Builder<T>> {

        protected StaticCatalog catalog;
        protected Duration duration;
        protected Fixed fixed;
        protected String name;
        protected PhaseType phaseType;
        protected String prettyName;
        protected Recurring recurring;
        protected Usage[] usages;

        public Builder() { }
        public Builder(final Builder that) {
            this.catalog = that.catalog;
            this.duration = that.duration;
            this.fixed = that.fixed;
            this.name = that.name;
            this.phaseType = that.phaseType;
            this.prettyName = that.prettyName;
            this.recurring = that.recurring;
            this.usages = that.usages;
        }
        public T withCatalog(final StaticCatalog catalog) {
            this.catalog = catalog;
            return (T) this;
        }
        public T withDuration(final Duration duration) {
            this.duration = duration;
            return (T) this;
        }
        public T withFixed(final Fixed fixed) {
            this.fixed = fixed;
            return (T) this;
        }
        public T withName(final String name) {
            this.name = name;
            return (T) this;
        }
        public T withPhaseType(final PhaseType phaseType) {
            this.phaseType = phaseType;
            return (T) this;
        }
        public T withPrettyName(final String prettyName) {
            this.prettyName = prettyName;
            return (T) this;
        }
        public T withRecurring(final Recurring recurring) {
            this.recurring = recurring;
            return (T) this;
        }
        public T withUsages(final Usage[] usages) {
            this.usages = usages;
            return (T) this;
        }
        public T source(final PlanPhase that) {
            this.catalog = that.getCatalog();
            this.duration = that.getDuration();
            this.fixed = that.getFixed();
            this.name = that.getName();
            this.phaseType = that.getPhaseType();
            this.prettyName = that.getPrettyName();
            this.recurring = that.getRecurring();
            this.usages = that.getUsages();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PlanPhaseImp build() {
            return new PlanPhaseImp(this.validate());
        }
    }
}
