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

package org.killbill.billing.payment.plugin.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.plugin.api.HostedPaymentPageFormDescriptor;

@JsonDeserialize( builder = HostedPaymentPageFormDescriptorImp.Builder.class )
public class HostedPaymentPageFormDescriptorImp implements HostedPaymentPageFormDescriptor {

    private static final long serialVersionUID = 0xB11ACD0862E725EBL;

    protected List<PluginProperty> formFields;
    protected String formMethod;
    protected String formUrl;
    protected UUID kbAccountId;
    protected List<PluginProperty> properties;

    public HostedPaymentPageFormDescriptorImp(final HostedPaymentPageFormDescriptorImp that) {
        this.formFields = that.formFields;
        this.formMethod = that.formMethod;
        this.formUrl = that.formUrl;
        this.kbAccountId = that.kbAccountId;
        this.properties = that.properties;
    }
    protected HostedPaymentPageFormDescriptorImp(final HostedPaymentPageFormDescriptorImp.Builder<?> builder) {
        this.formFields = builder.formFields;
        this.formMethod = builder.formMethod;
        this.formUrl = builder.formUrl;
        this.kbAccountId = builder.kbAccountId;
        this.properties = builder.properties;
    }
    protected HostedPaymentPageFormDescriptorImp() { }
    @Override
    public List<PluginProperty> getFormFields() {
        return this.formFields;
    }
    @Override
    public String getFormMethod() {
        return this.formMethod;
    }
    @Override
    public String getFormUrl() {
        return this.formUrl;
    }
    @Override
    public UUID getKbAccountId() {
        return this.kbAccountId;
    }
    @Override
    public List<PluginProperty> getProperties() {
        return this.properties;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final HostedPaymentPageFormDescriptorImp that = (HostedPaymentPageFormDescriptorImp) o;
        if( !Objects.equals(this.formFields, that.formFields) ) {
            return false;
        }
        if( !Objects.equals(this.formMethod, that.formMethod) ) {
            return false;
        }
        if( !Objects.equals(this.formUrl, that.formUrl) ) {
            return false;
        }
        if( !Objects.equals(this.kbAccountId, that.kbAccountId) ) {
            return false;
        }
        if( !Objects.equals(this.properties, that.properties) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.formFields);
        result = ( 31 * result ) + Objects.hashCode(this.formMethod);
        result = ( 31 * result ) + Objects.hashCode(this.formUrl);
        result = ( 31 * result ) + Objects.hashCode(this.kbAccountId);
        result = ( 31 * result ) + Objects.hashCode(this.properties);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("formFields=").append(this.formFields);
        sb.append(", ");
        sb.append("formMethod=");
        if( this.formMethod == null ) {
            sb.append(this.formMethod);
        }else{
            sb.append("'").append(this.formMethod).append("'");
        }
        sb.append(", ");
        sb.append("formUrl=");
        if( this.formUrl == null ) {
            sb.append(this.formUrl);
        }else{
            sb.append("'").append(this.formUrl).append("'");
        }
        sb.append(", ");
        sb.append("kbAccountId=").append(this.kbAccountId);
        sb.append(", ");
        sb.append("properties=").append(this.properties);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends HostedPaymentPageFormDescriptorImp.Builder<T>> {

        protected List<PluginProperty> formFields;
        protected String formMethod;
        protected String formUrl;
        protected UUID kbAccountId;
        protected List<PluginProperty> properties;

        public Builder() { }
        public Builder(final Builder that) {
            this.formFields = that.formFields;
            this.formMethod = that.formMethod;
            this.formUrl = that.formUrl;
            this.kbAccountId = that.kbAccountId;
            this.properties = that.properties;
        }
        public T withFormFields(final List<PluginProperty> formFields) {
            this.formFields = formFields;
            return (T) this;
        }
        public T withFormMethod(final String formMethod) {
            this.formMethod = formMethod;
            return (T) this;
        }
        public T withFormUrl(final String formUrl) {
            this.formUrl = formUrl;
            return (T) this;
        }
        public T withKbAccountId(final UUID kbAccountId) {
            this.kbAccountId = kbAccountId;
            return (T) this;
        }
        public T withProperties(final List<PluginProperty> properties) {
            this.properties = properties;
            return (T) this;
        }
        public T source(final HostedPaymentPageFormDescriptor that) {
            this.formFields = that.getFormFields();
            this.formMethod = that.getFormMethod();
            this.formUrl = that.getFormUrl();
            this.kbAccountId = that.getKbAccountId();
            this.properties = that.getProperties();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public HostedPaymentPageFormDescriptorImp build() {
            return new HostedPaymentPageFormDescriptorImp(this.validate());
        }
    }
}
