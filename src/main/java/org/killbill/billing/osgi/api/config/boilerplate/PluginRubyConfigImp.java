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
import java.util.Arrays;
import java.util.Objects;
import org.killbill.billing.osgi.api.config.PluginConfig;
import org.killbill.billing.osgi.api.config.PluginLanguage;
import org.killbill.billing.osgi.api.config.PluginRubyConfig;
import org.killbill.billing.osgi.api.config.PluginType;

@JsonDeserialize( builder = PluginRubyConfigImp.Builder.class )
public class PluginRubyConfigImp implements PluginRubyConfig {

    private static final long serialVersionUID = 0x901C01B3EBBA102DL;

    protected boolean isDisabled;
    protected boolean isSelectedForStart;
    protected String pluginKey;
    protected PluginLanguage pluginLanguage;
    protected String pluginName;
    protected PluginType pluginType;
    protected File pluginVersionRoot;
    protected String pluginVersionnedName;
    protected String rubyLoadDir;
    protected String rubyMainClass;
    protected String rubyRequire;
    protected String version;

    public PluginRubyConfigImp(final PluginRubyConfigImp that) {
        this.isDisabled = that.isDisabled;
        this.isSelectedForStart = that.isSelectedForStart;
        this.pluginKey = that.pluginKey;
        this.pluginLanguage = that.pluginLanguage;
        this.pluginName = that.pluginName;
        this.pluginType = that.pluginType;
        this.pluginVersionRoot = that.pluginVersionRoot;
        this.pluginVersionnedName = that.pluginVersionnedName;
        this.rubyLoadDir = that.rubyLoadDir;
        this.rubyMainClass = that.rubyMainClass;
        this.rubyRequire = that.rubyRequire;
        this.version = that.version;
    }
    protected PluginRubyConfigImp(final PluginRubyConfigImp.Builder<?> builder) {
        this.isDisabled = builder.isDisabled;
        this.isSelectedForStart = builder.isSelectedForStart;
        this.pluginKey = builder.pluginKey;
        this.pluginLanguage = builder.pluginLanguage;
        this.pluginName = builder.pluginName;
        this.pluginType = builder.pluginType;
        this.pluginVersionRoot = builder.pluginVersionRoot;
        this.pluginVersionnedName = builder.pluginVersionnedName;
        this.rubyLoadDir = builder.rubyLoadDir;
        this.rubyMainClass = builder.rubyMainClass;
        this.rubyRequire = builder.rubyRequire;
        this.version = builder.version;
    }
    protected PluginRubyConfigImp() { }
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
    public String getRubyLoadDir() {
        return this.rubyLoadDir;
    }
    @Override
    public String getRubyMainClass() {
        return this.rubyMainClass;
    }
    @Override
    public String getRubyRequire() {
        return this.rubyRequire;
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
        final PluginRubyConfigImp that = (PluginRubyConfigImp) o;
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
        if( !Objects.equals(this.rubyLoadDir, that.rubyLoadDir) ) {
            return false;
        }
        if( !Objects.equals(this.rubyMainClass, that.rubyMainClass) ) {
            return false;
        }
        if( !Objects.equals(this.rubyRequire, that.rubyRequire) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.isDisabled);
        result = ( 31 * result ) + Objects.hashCode(this.isSelectedForStart);
        result = ( 31 * result ) + Objects.hashCode(this.pluginKey);
        result = ( 31 * result ) + Objects.hashCode(this.pluginLanguage);
        result = ( 31 * result ) + Objects.hashCode(this.pluginName);
        result = ( 31 * result ) + Objects.hashCode(this.pluginType);
        result = ( 31 * result ) + Objects.hashCode(this.pluginVersionRoot);
        result = ( 31 * result ) + Objects.hashCode(this.pluginVersionnedName);
        result = ( 31 * result ) + Objects.hashCode(this.rubyLoadDir);
        result = ( 31 * result ) + Objects.hashCode(this.rubyMainClass);
        result = ( 31 * result ) + Objects.hashCode(this.rubyRequire);
        result = ( 31 * result ) + Objects.hashCode(this.version);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
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
        sb.append("rubyLoadDir=");
        if( this.rubyLoadDir == null ) {
            sb.append(this.rubyLoadDir);
        }else{
            sb.append("'").append(this.rubyLoadDir).append("'");
        }
        sb.append(", ");
        sb.append("rubyMainClass=");
        if( this.rubyMainClass == null ) {
            sb.append(this.rubyMainClass);
        }else{
            sb.append("'").append(this.rubyMainClass).append("'");
        }
        sb.append(", ");
        sb.append("rubyRequire=");
        if( this.rubyRequire == null ) {
            sb.append(this.rubyRequire);
        }else{
            sb.append("'").append(this.rubyRequire).append("'");
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
    public static class Builder<T extends PluginRubyConfigImp.Builder<T>> {

        protected boolean isDisabled;
        protected boolean isSelectedForStart;
        protected String pluginKey;
        protected PluginLanguage pluginLanguage;
        protected String pluginName;
        protected PluginType pluginType;
        protected File pluginVersionRoot;
        protected String pluginVersionnedName;
        protected String rubyLoadDir;
        protected String rubyMainClass;
        protected String rubyRequire;
        protected String version;

        public Builder() { }
        public Builder(final Builder that) {
            this.isDisabled = that.isDisabled;
            this.isSelectedForStart = that.isSelectedForStart;
            this.pluginKey = that.pluginKey;
            this.pluginLanguage = that.pluginLanguage;
            this.pluginName = that.pluginName;
            this.pluginType = that.pluginType;
            this.pluginVersionRoot = that.pluginVersionRoot;
            this.pluginVersionnedName = that.pluginVersionnedName;
            this.rubyLoadDir = that.rubyLoadDir;
            this.rubyMainClass = that.rubyMainClass;
            this.rubyRequire = that.rubyRequire;
            this.version = that.version;
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
        public T withRubyLoadDir(final String rubyLoadDir) {
            this.rubyLoadDir = rubyLoadDir;
            return (T) this;
        }
        public T withRubyMainClass(final String rubyMainClass) {
            this.rubyMainClass = rubyMainClass;
            return (T) this;
        }
        public T withRubyRequire(final String rubyRequire) {
            this.rubyRequire = rubyRequire;
            return (T) this;
        }
        public T withVersion(final String version) {
            this.version = version;
            return (T) this;
        }
        public T source(final PluginRubyConfig that) {
            this.isDisabled = that.isDisabled();
            this.isSelectedForStart = that.isSelectedForStart();
            this.pluginKey = that.getPluginKey();
            this.pluginLanguage = that.getPluginLanguage();
            this.pluginName = that.getPluginName();
            this.pluginType = that.getPluginType();
            this.pluginVersionRoot = that.getPluginVersionRoot();
            this.pluginVersionnedName = that.getPluginVersionnedName();
            this.rubyLoadDir = that.getRubyLoadDir();
            this.rubyMainClass = that.getRubyMainClass();
            this.rubyRequire = that.getRubyRequire();
            this.version = that.getVersion();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PluginRubyConfigImp build() {
            return new PluginRubyConfigImp(this.validate());
        }
    }
}
