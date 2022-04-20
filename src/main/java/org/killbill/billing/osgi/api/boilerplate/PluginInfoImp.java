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

package org.killbill.billing.osgi.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import org.killbill.billing.osgi.api.PluginInfo;
import org.killbill.billing.osgi.api.PluginServiceInfo;
import org.killbill.billing.osgi.api.PluginState;

@JsonDeserialize( builder = PluginInfoImp.Builder.class )
public class PluginInfoImp implements PluginInfo {

    protected String bundleSymbolicName;
    protected boolean isSelectedForStart;
    protected String pluginKey;
    protected String pluginName;
    protected PluginState pluginState;
    protected Set<PluginServiceInfo> services;
    protected String version;

    public PluginInfoImp(final PluginInfoImp that) {
        this.bundleSymbolicName = that.bundleSymbolicName;
        this.isSelectedForStart = that.isSelectedForStart;
        this.pluginKey = that.pluginKey;
        this.pluginName = that.pluginName;
        this.pluginState = that.pluginState;
        this.services = that.services;
        this.version = that.version;
    }
    protected PluginInfoImp(final PluginInfoImp.Builder<?> builder) {
        this.bundleSymbolicName = builder.bundleSymbolicName;
        this.isSelectedForStart = builder.isSelectedForStart;
        this.pluginKey = builder.pluginKey;
        this.pluginName = builder.pluginName;
        this.pluginState = builder.pluginState;
        this.services = builder.services;
        this.version = builder.version;
    }
    protected PluginInfoImp() { }
    @Override
    public String getBundleSymbolicName() {
        return this.bundleSymbolicName;
    }
    @Override
    @JsonGetter("isSelectedForStart")
    public boolean isSelectedForStart() {
        return this.isSelectedForStart;
    }
    @Override
    public String getPluginKey() {
        return this.pluginKey;
    }
    @Override
    public String getPluginName() {
        return this.pluginName;
    }
    @Override
    public PluginState getPluginState() {
        return this.pluginState;
    }
    @Override
    public Set<PluginServiceInfo> getServices() {
        return this.services;
    }
    @Override
    public String getVersion() {
        return this.version;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PluginInfoImp that = (PluginInfoImp) o;
        if( !Objects.equals(this.bundleSymbolicName, that.bundleSymbolicName) ) {
            return false;
        }
        if( this.isSelectedForStart != that.isSelectedForStart ) {
            return false;
        }
        if( !Objects.equals(this.pluginKey, that.pluginKey) ) {
            return false;
        }
        if( !Objects.equals(this.pluginName, that.pluginName) ) {
            return false;
        }
        if( !Objects.equals(this.pluginState, that.pluginState) ) {
            return false;
        }
        if( !Objects.equals(this.services, that.services) ) {
            return false;
        }
        if( !Objects.equals(this.version, that.version) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.bundleSymbolicName);
        result = ( 31 * result ) + Objects.hashCode(this.isSelectedForStart);
        result = ( 31 * result ) + Objects.hashCode(this.pluginKey);
        result = ( 31 * result ) + Objects.hashCode(this.pluginName);
        result = ( 31 * result ) + Objects.hashCode(this.pluginState);
        result = ( 31 * result ) + Objects.hashCode(this.services);
        result = ( 31 * result ) + Objects.hashCode(this.version);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("bundleSymbolicName=");
        if( this.bundleSymbolicName == null ) {
            sb.append(this.bundleSymbolicName);
        }else{
            sb.append("'").append(this.bundleSymbolicName).append("'");
        }
        sb.append(", ");
        sb.append("isSelectedForStart=").append(this.isSelectedForStart);
        sb.append(", ");
        sb.append("pluginKey=");
        if( this.pluginKey == null ) {
            sb.append(this.pluginKey);
        }else{
            sb.append("'").append(this.pluginKey).append("'");
        }
        sb.append(", ");
        sb.append("pluginName=");
        if( this.pluginName == null ) {
            sb.append(this.pluginName);
        }else{
            sb.append("'").append(this.pluginName).append("'");
        }
        sb.append(", ");
        sb.append("pluginState=").append(this.pluginState);
        sb.append(", ");
        sb.append("services=").append(this.services);
        sb.append(", ");
        sb.append("version=");
        if( this.version == null ) {
            sb.append(this.version);
        }else{
            sb.append("'").append(this.version).append("'");
        }
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PluginInfoImp.Builder<T>> {

        protected String bundleSymbolicName;
        protected boolean isSelectedForStart;
        protected String pluginKey;
        protected String pluginName;
        protected PluginState pluginState;
        protected Set<PluginServiceInfo> services;
        protected String version;

        public Builder() { }
        public Builder(final Builder that) {
            this.bundleSymbolicName = that.bundleSymbolicName;
            this.isSelectedForStart = that.isSelectedForStart;
            this.pluginKey = that.pluginKey;
            this.pluginName = that.pluginName;
            this.pluginState = that.pluginState;
            this.services = that.services;
            this.version = that.version;
        }
        public T withBundleSymbolicName(final String bundleSymbolicName) {
            this.bundleSymbolicName = bundleSymbolicName;
            return (T) this;
        }
        public T withIsSelectedForStart(final boolean isSelectedForStart) {
            this.isSelectedForStart = isSelectedForStart;
            return (T) this;
        }
        public T withPluginKey(final String pluginKey) {
            this.pluginKey = pluginKey;
            return (T) this;
        }
        public T withPluginName(final String pluginName) {
            this.pluginName = pluginName;
            return (T) this;
        }
        public T withPluginState(final PluginState pluginState) {
            this.pluginState = pluginState;
            return (T) this;
        }
        public T withServices(final Set<PluginServiceInfo> services) {
            this.services = services;
            return (T) this;
        }
        public T withVersion(final String version) {
            this.version = version;
            return (T) this;
        }
        public T source(final PluginInfo that) {
            this.bundleSymbolicName = that.getBundleSymbolicName();
            this.isSelectedForStart = that.isSelectedForStart();
            this.pluginKey = that.getPluginKey();
            this.pluginName = that.getPluginName();
            this.pluginState = that.getPluginState();
            this.services = that.getServices();
            this.version = that.getVersion();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PluginInfoImp build() {
            return new PluginInfoImp(this.validate());
        }
    }
}
