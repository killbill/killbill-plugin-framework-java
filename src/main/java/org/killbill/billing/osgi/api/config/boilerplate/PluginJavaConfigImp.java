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

package org.killbill.billing.osgi.api.config.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import org.killbill.billing.osgi.api.config.PluginConfig;
import org.killbill.billing.osgi.api.config.PluginJavaConfig;
import org.killbill.billing.osgi.api.config.PluginLanguage;
import org.killbill.billing.osgi.api.config.PluginType;

@JsonDeserialize( builder = PluginJavaConfigImp.Builder.class )
public class PluginJavaConfigImp implements PluginJavaConfig, Serializable {

    private static final long serialVersionUID = 0xBEB2603DF892B0A4L;

    protected String bundleJarPath;
    protected boolean isDisabled;
    protected boolean isSelectedForStart;
    protected String pluginKey;
    protected PluginLanguage pluginLanguage;
    protected String pluginName;
    protected PluginType pluginType;
    protected File pluginVersionRoot;
    protected String pluginVersionnedName;
    protected String version;

    public PluginJavaConfigImp(final PluginJavaConfigImp that) {
        this.bundleJarPath = that.bundleJarPath;
        this.isDisabled = that.isDisabled;
        this.isSelectedForStart = that.isSelectedForStart;
        this.pluginKey = that.pluginKey;
        this.pluginLanguage = that.pluginLanguage;
        this.pluginName = that.pluginName;
        this.pluginType = that.pluginType;
        this.pluginVersionRoot = that.pluginVersionRoot;
        this.pluginVersionnedName = that.pluginVersionnedName;
        this.version = that.version;
    }
    protected PluginJavaConfigImp(final PluginJavaConfigImp.Builder<?> builder) {
        this.bundleJarPath = builder.bundleJarPath;
        this.isDisabled = builder.isDisabled;
        this.isSelectedForStart = builder.isSelectedForStart;
        this.pluginKey = builder.pluginKey;
        this.pluginLanguage = builder.pluginLanguage;
        this.pluginName = builder.pluginName;
        this.pluginType = builder.pluginType;
        this.pluginVersionRoot = builder.pluginVersionRoot;
        this.pluginVersionnedName = builder.pluginVersionnedName;
        this.version = builder.version;
    }
    protected PluginJavaConfigImp() { }
    @Override
    public String getBundleJarPath() {
        return this.bundleJarPath;
    }
    @Override
    @JsonGetter("isDisabled")
    public boolean isDisabled() {
        return this.isDisabled;
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
    public PluginLanguage getPluginLanguage() {
        return this.pluginLanguage;
    }
    @Override
    public String getPluginName() {
        return this.pluginName;
    }
    @Override
    public PluginType getPluginType() {
        return this.pluginType;
    }
    @Override
    public File getPluginVersionRoot() {
        return this.pluginVersionRoot;
    }
    @Override
    public String getPluginVersionnedName() {
        return this.pluginVersionnedName;
    }
    @Override
    public String getVersion() {
        return this.version;
    }
    @Override
    public int compareTo(final PluginConfig a) {
        throw new UnsupportedOperationException("compareTo(org.killbill.billing.osgi.api.config.PluginConfig) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PluginJavaConfigImp that = (PluginJavaConfigImp) o;
        if( !Objects.equals(this.bundleJarPath, that.bundleJarPath) ) {
            return false;
        }
        if( this.isDisabled != that.isDisabled ) {
            return false;
        }
        if( this.isSelectedForStart != that.isSelectedForStart ) {
            return false;
        }
        if( !Objects.equals(this.pluginKey, that.pluginKey) ) {
            return false;
        }
        if( !Objects.equals(this.pluginLanguage, that.pluginLanguage) ) {
            return false;
        }
        if( !Objects.equals(this.pluginName, that.pluginName) ) {
            return false;
        }
        if( !Objects.equals(this.pluginType, that.pluginType) ) {
            return false;
        }
        if( !Objects.equals(this.pluginVersionRoot, that.pluginVersionRoot) ) {
            return false;
        }
        if( !Objects.equals(this.pluginVersionnedName, that.pluginVersionnedName) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.bundleJarPath);
        result = ( 31 * result ) + Objects.hashCode(this.isDisabled);
        result = ( 31 * result ) + Objects.hashCode(this.isSelectedForStart);
        result = ( 31 * result ) + Objects.hashCode(this.pluginKey);
        result = ( 31 * result ) + Objects.hashCode(this.pluginLanguage);
        result = ( 31 * result ) + Objects.hashCode(this.pluginName);
        result = ( 31 * result ) + Objects.hashCode(this.pluginType);
        result = ( 31 * result ) + Objects.hashCode(this.pluginVersionRoot);
        result = ( 31 * result ) + Objects.hashCode(this.pluginVersionnedName);
        result = ( 31 * result ) + Objects.hashCode(this.version);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("bundleJarPath=");
        if( this.bundleJarPath == null ) {
            sb.append(this.bundleJarPath);
        }else{
            sb.append("'").append(this.bundleJarPath).append("'");
        }
        sb.append(", ");
        sb.append("isDisabled=").append(this.isDisabled);
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
        sb.append("pluginLanguage=").append(this.pluginLanguage);
        sb.append(", ");
        sb.append("pluginName=");
        if( this.pluginName == null ) {
            sb.append(this.pluginName);
        }else{
            sb.append("'").append(this.pluginName).append("'");
        }
        sb.append(", ");
        sb.append("pluginType=").append(this.pluginType);
        sb.append(", ");
        sb.append("pluginVersionRoot=").append(this.pluginVersionRoot);
        sb.append(", ");
        sb.append("pluginVersionnedName=");
        if( this.pluginVersionnedName == null ) {
            sb.append(this.pluginVersionnedName);
        }else{
            sb.append("'").append(this.pluginVersionnedName).append("'");
        }
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
    public static class Builder<T extends PluginJavaConfigImp.Builder<T>> {

        protected String bundleJarPath;
        protected boolean isDisabled;
        protected boolean isSelectedForStart;
        protected String pluginKey;
        protected PluginLanguage pluginLanguage;
        protected String pluginName;
        protected PluginType pluginType;
        protected File pluginVersionRoot;
        protected String pluginVersionnedName;
        protected String version;

        public Builder() { }
        public Builder(final Builder that) {
            this.bundleJarPath = that.bundleJarPath;
            this.isDisabled = that.isDisabled;
            this.isSelectedForStart = that.isSelectedForStart;
            this.pluginKey = that.pluginKey;
            this.pluginLanguage = that.pluginLanguage;
            this.pluginName = that.pluginName;
            this.pluginType = that.pluginType;
            this.pluginVersionRoot = that.pluginVersionRoot;
            this.pluginVersionnedName = that.pluginVersionnedName;
            this.version = that.version;
        }
        public T withBundleJarPath(final String bundleJarPath) {
            this.bundleJarPath = bundleJarPath;
            return (T) this;
        }
        public T withIsDisabled(final boolean isDisabled) {
            this.isDisabled = isDisabled;
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
        public T withPluginLanguage(final PluginLanguage pluginLanguage) {
            this.pluginLanguage = pluginLanguage;
            return (T) this;
        }
        public T withPluginName(final String pluginName) {
            this.pluginName = pluginName;
            return (T) this;
        }
        public T withPluginType(final PluginType pluginType) {
            this.pluginType = pluginType;
            return (T) this;
        }
        public T withPluginVersionRoot(final File pluginVersionRoot) {
            this.pluginVersionRoot = pluginVersionRoot;
            return (T) this;
        }
        public T withPluginVersionnedName(final String pluginVersionnedName) {
            this.pluginVersionnedName = pluginVersionnedName;
            return (T) this;
        }
        public T withVersion(final String version) {
            this.version = version;
            return (T) this;
        }
        public T source(final PluginJavaConfig that) {
            this.bundleJarPath = that.getBundleJarPath();
            this.isDisabled = that.isDisabled();
            this.isSelectedForStart = that.isSelectedForStart();
            this.pluginKey = that.getPluginKey();
            this.pluginLanguage = that.getPluginLanguage();
            this.pluginName = that.getPluginName();
            this.pluginType = that.getPluginType();
            this.pluginVersionRoot = that.getPluginVersionRoot();
            this.pluginVersionnedName = that.getPluginVersionnedName();
            this.version = that.getVersion();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PluginJavaConfigImp build() {
            return new PluginJavaConfigImp(this.validate());
        }
    }
}
