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

package org.killbill.billing.util.nodes.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import org.joda.time.DateTime;
import org.killbill.billing.osgi.api.PluginInfo;
import org.killbill.billing.util.nodes.NodeInfo;

@JsonDeserialize( builder = NodeInfoImp.Builder.class )
public class NodeInfoImp implements NodeInfo {

    private static final long serialVersionUID = 0xF60FCF394C2541BBL;

    protected String apiVersion;
    protected DateTime bootTime;
    protected String commonVersion;
    protected String killbillVersion;
    protected DateTime lastUpdatedDate;
    protected String nodeName;
    protected String platformVersion;
    protected String pluginApiVersion;
    protected Iterable<PluginInfo> pluginInfo;

    public NodeInfoImp(final NodeInfoImp that) {
        this.apiVersion = that.apiVersion;
        this.bootTime = that.bootTime;
        this.commonVersion = that.commonVersion;
        this.killbillVersion = that.killbillVersion;
        this.lastUpdatedDate = that.lastUpdatedDate;
        this.nodeName = that.nodeName;
        this.platformVersion = that.platformVersion;
        this.pluginApiVersion = that.pluginApiVersion;
        this.pluginInfo = that.pluginInfo;
    }
    protected NodeInfoImp(final NodeInfoImp.Builder<?> builder) {
        this.apiVersion = builder.apiVersion;
        this.bootTime = builder.bootTime;
        this.commonVersion = builder.commonVersion;
        this.killbillVersion = builder.killbillVersion;
        this.lastUpdatedDate = builder.lastUpdatedDate;
        this.nodeName = builder.nodeName;
        this.platformVersion = builder.platformVersion;
        this.pluginApiVersion = builder.pluginApiVersion;
        this.pluginInfo = builder.pluginInfo;
    }
    protected NodeInfoImp() { }
    @Override
    public String getApiVersion() {
        return this.apiVersion;
    }
    @Override
    public DateTime getBootTime() {
        return this.bootTime;
    }
    @Override
    public String getCommonVersion() {
        return this.commonVersion;
    }
    @Override
    public String getKillbillVersion() {
        return this.killbillVersion;
    }
    @Override
    public DateTime getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }
    @Override
    public String getNodeName() {
        return this.nodeName;
    }
    @Override
    public String getPlatformVersion() {
        return this.platformVersion;
    }
    @Override
    public String getPluginApiVersion() {
        return this.pluginApiVersion;
    }
    @Override
    public Iterable<PluginInfo> getPluginInfo() {
        return this.pluginInfo;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final NodeInfoImp that = (NodeInfoImp) o;
        if( !Objects.equals(this.apiVersion, that.apiVersion) ) {
            return false;
        }
        if( ( this.bootTime != null ) ? ( 0 != this.bootTime.compareTo(that.bootTime) ) : ( that.bootTime != null ) ) {
            return false;
        }
        if( !Objects.equals(this.commonVersion, that.commonVersion) ) {
            return false;
        }
        if( !Objects.equals(this.killbillVersion, that.killbillVersion) ) {
            return false;
        }
        if( ( this.lastUpdatedDate != null ) ? ( 0 != this.lastUpdatedDate.compareTo(that.lastUpdatedDate) ) : ( that.lastUpdatedDate != null ) ) {
            return false;
        }
        if( !Objects.equals(this.nodeName, that.nodeName) ) {
            return false;
        }
        if( !Objects.equals(this.platformVersion, that.platformVersion) ) {
            return false;
        }
        if( !Objects.equals(this.pluginApiVersion, that.pluginApiVersion) ) {
            return false;
        }
        if( !Objects.equals(this.pluginInfo, that.pluginInfo) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.apiVersion);
        result = ( 31 * result ) + Objects.hashCode(this.bootTime);
        result = ( 31 * result ) + Objects.hashCode(this.commonVersion);
        result = ( 31 * result ) + Objects.hashCode(this.killbillVersion);
        result = ( 31 * result ) + Objects.hashCode(this.lastUpdatedDate);
        result = ( 31 * result ) + Objects.hashCode(this.nodeName);
        result = ( 31 * result ) + Objects.hashCode(this.platformVersion);
        result = ( 31 * result ) + Objects.hashCode(this.pluginApiVersion);
        result = ( 31 * result ) + Objects.hashCode(this.pluginInfo);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("apiVersion=");
        if( this.apiVersion == null ) {
            sb.append(this.apiVersion);
        }else{
            sb.append("'").append(this.apiVersion).append("'");
        }
        sb.append(", ");
        sb.append("bootTime=").append(this.bootTime);
        sb.append(", ");
        sb.append("commonVersion=");
        if( this.commonVersion == null ) {
            sb.append(this.commonVersion);
        }else{
            sb.append("'").append(this.commonVersion).append("'");
        }
        sb.append(", ");
        sb.append("killbillVersion=");
        if( this.killbillVersion == null ) {
            sb.append(this.killbillVersion);
        }else{
            sb.append("'").append(this.killbillVersion).append("'");
        }
        sb.append(", ");
        sb.append("lastUpdatedDate=").append(this.lastUpdatedDate);
        sb.append(", ");
        sb.append("nodeName=");
        if( this.nodeName == null ) {
            sb.append(this.nodeName);
        }else{
            sb.append("'").append(this.nodeName).append("'");
        }
        sb.append(", ");
        sb.append("platformVersion=");
        if( this.platformVersion == null ) {
            sb.append(this.platformVersion);
        }else{
            sb.append("'").append(this.platformVersion).append("'");
        }
        sb.append(", ");
        sb.append("pluginApiVersion=");
        if( this.pluginApiVersion == null ) {
            sb.append(this.pluginApiVersion);
        }else{
            sb.append("'").append(this.pluginApiVersion).append("'");
        }
        sb.append(", ");
        sb.append("pluginInfo=").append(this.pluginInfo);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends NodeInfoImp.Builder<T>> {

        protected String apiVersion;
        protected DateTime bootTime;
        protected String commonVersion;
        protected String killbillVersion;
        protected DateTime lastUpdatedDate;
        protected String nodeName;
        protected String platformVersion;
        protected String pluginApiVersion;
        protected Iterable<PluginInfo> pluginInfo;

        public Builder() { }
        public Builder(final Builder that) {
            this.apiVersion = that.apiVersion;
            this.bootTime = that.bootTime;
            this.commonVersion = that.commonVersion;
            this.killbillVersion = that.killbillVersion;
            this.lastUpdatedDate = that.lastUpdatedDate;
            this.nodeName = that.nodeName;
            this.platformVersion = that.platformVersion;
            this.pluginApiVersion = that.pluginApiVersion;
            this.pluginInfo = that.pluginInfo;
        }
        public T withApiVersion(final String apiVersion) {
            this.apiVersion = apiVersion;
            return (T) this;
        }
        public T withBootTime(final DateTime bootTime) {
            this.bootTime = bootTime;
            return (T) this;
        }
        public T withCommonVersion(final String commonVersion) {
            this.commonVersion = commonVersion;
            return (T) this;
        }
        public T withKillbillVersion(final String killbillVersion) {
            this.killbillVersion = killbillVersion;
            return (T) this;
        }
        public T withLastUpdatedDate(final DateTime lastUpdatedDate) {
            this.lastUpdatedDate = lastUpdatedDate;
            return (T) this;
        }
        public T withNodeName(final String nodeName) {
            this.nodeName = nodeName;
            return (T) this;
        }
        public T withPlatformVersion(final String platformVersion) {
            this.platformVersion = platformVersion;
            return (T) this;
        }
        public T withPluginApiVersion(final String pluginApiVersion) {
            this.pluginApiVersion = pluginApiVersion;
            return (T) this;
        }
        public T withPluginInfo(final Iterable<PluginInfo> pluginInfo) {
            this.pluginInfo = pluginInfo;
            return (T) this;
        }
        public T source(final NodeInfo that) {
            this.apiVersion = that.getApiVersion();
            this.bootTime = that.getBootTime();
            this.commonVersion = that.getCommonVersion();
            this.killbillVersion = that.getKillbillVersion();
            this.lastUpdatedDate = that.getLastUpdatedDate();
            this.nodeName = that.getNodeName();
            this.platformVersion = that.getPlatformVersion();
            this.pluginApiVersion = that.getPluginApiVersion();
            this.pluginInfo = that.getPluginInfo();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public NodeInfoImp build() {
            return new NodeInfoImp(this.validate());
        }
    }
}
