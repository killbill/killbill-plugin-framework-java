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
import org.killbill.billing.osgi.api.PluginServiceInfo;

@JsonDeserialize( builder = PluginServiceInfoImp.Builder.class )
public class PluginServiceInfoImp implements PluginServiceInfo {

    protected String registrationName;
    protected String serviceTypeName;

    public PluginServiceInfoImp(final PluginServiceInfoImp that) {
        this.registrationName = that.registrationName;
        this.serviceTypeName = that.serviceTypeName;
    }
    protected PluginServiceInfoImp(final PluginServiceInfoImp.Builder<?> builder) {
        this.registrationName = builder.registrationName;
        this.serviceTypeName = builder.serviceTypeName;
    }
    protected PluginServiceInfoImp() { }
    @Override
    public String getRegistrationName() {
        return this.registrationName;
    }
    @Override
    public String getServiceTypeName() {
        return this.serviceTypeName;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final PluginServiceInfoImp that = (PluginServiceInfoImp) o;
        if( !Objects.equals(this.registrationName, that.registrationName) ) {
            return false;
        }
        if( !Objects.equals(this.serviceTypeName, that.serviceTypeName) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.registrationName);
        result = ( 31 * result ) + Objects.hashCode(this.serviceTypeName);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("registrationName=");
        if( this.registrationName == null ) {
            sb.append(this.registrationName);
        }else{
            sb.append("'").append(this.registrationName).append("'");
        }
        sb.append(", ");
        sb.append("serviceTypeName=");
        if( this.serviceTypeName == null ) {
            sb.append(this.serviceTypeName);
        }else{
            sb.append("'").append(this.serviceTypeName).append("'");
        }
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PluginServiceInfoImp.Builder<T>> {

        protected String registrationName;
        protected String serviceTypeName;

        public Builder() { }
        public Builder(final Builder that) {
            this.registrationName = that.registrationName;
            this.serviceTypeName = that.serviceTypeName;
        }
        public T withRegistrationName(final String registrationName) {
            this.registrationName = registrationName;
            return (T) this;
        }
        public T withServiceTypeName(final String serviceTypeName) {
            this.serviceTypeName = serviceTypeName;
            return (T) this;
        }
        public T source(final PluginServiceInfo that) {
            this.registrationName = that.getRegistrationName();
            this.serviceTypeName = that.getServiceTypeName();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PluginServiceInfoImp build() {
            return new PluginServiceInfoImp(this.validate());
        }
    }
}
