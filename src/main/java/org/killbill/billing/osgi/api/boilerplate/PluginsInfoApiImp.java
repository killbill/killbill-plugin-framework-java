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
import org.killbill.billing.osgi.api.PluginInfo;
import org.killbill.billing.osgi.api.PluginStateChange;
import org.killbill.billing.osgi.api.PluginsInfoApi;
import org.killbill.billing.osgi.api.config.PluginLanguage;

@JsonDeserialize( builder = PluginsInfoApiImp.Builder.class )
public class PluginsInfoApiImp implements PluginsInfoApi {

    protected Iterable<PluginInfo> pluginsInfo;

    public PluginsInfoApiImp(final PluginsInfoApiImp that) {
        this.pluginsInfo = that.pluginsInfo;
    }
    protected PluginsInfoApiImp(final PluginsInfoApiImp.Builder<?> builder) {
        this.pluginsInfo = builder.pluginsInfo;
    }
    protected PluginsInfoApiImp() { }
    @Override
    public Iterable<PluginInfo> getPluginsInfo() {
        return this.pluginsInfo;
    }
    @Override
    public void notifyOfStateChanged(final PluginStateChange newState, final String pluginKey, final String pluginName, final String pluginVersion, final PluginLanguage pluginLanguage) {
        throw new UnsupportedOperationException("notifyOfStateChanged(org.killbill.billing.osgi.api.PluginStateChange, java.lang.String, java.lang.String, java.lang.String, org.killbill.billing.osgi.api.config.PluginLanguage) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PluginsInfoApiImp that = (PluginsInfoApiImp) o;
        if( !Objects.equals(this.pluginsInfo, that.pluginsInfo) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.pluginsInfo);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("pluginsInfo=").append(this.pluginsInfo);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PluginsInfoApiImp.Builder<T>> {

        protected Iterable<PluginInfo> pluginsInfo;

        public Builder() { }
        public Builder(final Builder that) {
            this.pluginsInfo = that.pluginsInfo;
        }
        public T withPluginsInfo(final Iterable<PluginInfo> pluginsInfo) {
            this.pluginsInfo = pluginsInfo;
            return (T) this;
        }
        public T source(final PluginsInfoApi that) {
            this.pluginsInfo = that.getPluginsInfo();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PluginsInfoApiImp build() {
            return new PluginsInfoApiImp(this.validate());
        }
    }
}
