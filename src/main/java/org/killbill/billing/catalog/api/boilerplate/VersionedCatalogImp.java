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
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.killbill.billing.catalog.api.StaticCatalog;
import org.killbill.billing.catalog.api.VersionedCatalog;

@JsonDeserialize( builder = VersionedCatalogImp.Builder.class )
public class VersionedCatalogImp implements VersionedCatalog {

    protected String catalogName;
    protected StaticCatalog currentVersion;
    protected List<StaticCatalog> versions;

    public VersionedCatalogImp(final VersionedCatalogImp that) {
        this.catalogName = that.catalogName;
        this.currentVersion = that.currentVersion;
        this.versions = that.versions;
    }
    protected VersionedCatalogImp(final VersionedCatalogImp.Builder<?> builder) {
        this.catalogName = builder.catalogName;
        this.currentVersion = builder.currentVersion;
        this.versions = builder.versions;
    }
    protected VersionedCatalogImp() { }
    @Override
    public String getCatalogName() {
        return this.catalogName;
    }
    @Override
    public StaticCatalog getCurrentVersion() {
        return this.currentVersion;
    }
    @Override
    public List<StaticCatalog> getVersions() {
        return this.versions;
    }
    @Override
    public StaticCatalog getVersion(final Date targetDate) {
        throw new UnsupportedOperationException("getVersion(java.util.Date) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final VersionedCatalogImp that = (VersionedCatalogImp) o;
        if( !Objects.equals(this.catalogName, that.catalogName) ) {
            return false;
        }
        if( !Objects.equals(this.currentVersion, that.currentVersion) ) {
            return false;
        }
        if( !Objects.equals(this.versions, that.versions) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.catalogName);
        result = ( 31 * result ) + Objects.hashCode(this.currentVersion);
        result = ( 31 * result ) + Objects.hashCode(this.versions);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("catalogName=");
        if( this.catalogName == null ) {
            sb.append(this.catalogName);
        }else{
            sb.append("'").append(this.catalogName).append("'");
        }
        sb.append(", ");
        sb.append("currentVersion=").append(this.currentVersion);
        sb.append(", ");
        sb.append("versions=").append(this.versions);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends VersionedCatalogImp.Builder<T>> {

        protected String catalogName;
        protected StaticCatalog currentVersion;
        protected List<StaticCatalog> versions;

        public Builder() { }
        public Builder(final Builder that) {
            this.catalogName = that.catalogName;
            this.currentVersion = that.currentVersion;
            this.versions = that.versions;
        }
        public T withCatalogName(final String catalogName) {
            this.catalogName = catalogName;
            return (T) this;
        }
        public T withCurrentVersion(final StaticCatalog currentVersion) {
            this.currentVersion = currentVersion;
            return (T) this;
        }
        public T withVersions(final List<StaticCatalog> versions) {
            this.versions = versions;
            return (T) this;
        }
        public T source(final VersionedCatalog that) {
            this.catalogName = that.getCatalogName();
            this.currentVersion = that.getCurrentVersion();
            this.versions = that.getVersions();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public VersionedCatalogImp build() {
            return new VersionedCatalogImp(this.validate());
        }
    }
}
