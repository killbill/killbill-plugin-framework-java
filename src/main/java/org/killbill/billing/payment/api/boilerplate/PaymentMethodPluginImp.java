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

package org.killbill.billing.payment.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.killbill.billing.payment.api.PaymentMethodPlugin;
import org.killbill.billing.payment.api.PluginProperty;

@JsonDeserialize( builder = PaymentMethodPluginImp.Builder.class )
public class PaymentMethodPluginImp implements PaymentMethodPlugin {

    private static final long serialVersionUID = 0x42CEDE7E9AF09E20L;

    protected String externalPaymentMethodId;
    protected boolean isDefaultPaymentMethod;
    protected UUID kbPaymentMethodId;
    protected List<PluginProperty> properties;

    public PaymentMethodPluginImp(final PaymentMethodPluginImp that) {
        this.externalPaymentMethodId = that.externalPaymentMethodId;
        this.isDefaultPaymentMethod = that.isDefaultPaymentMethod;
        this.kbPaymentMethodId = that.kbPaymentMethodId;
        this.properties = that.properties;
    }
    protected PaymentMethodPluginImp(final PaymentMethodPluginImp.Builder<?> builder) {
        this.externalPaymentMethodId = builder.externalPaymentMethodId;
        this.isDefaultPaymentMethod = builder.isDefaultPaymentMethod;
        this.kbPaymentMethodId = builder.kbPaymentMethodId;
        this.properties = builder.properties;
    }
    protected PaymentMethodPluginImp() { }
    @Override
    public String getExternalPaymentMethodId() {
        return this.externalPaymentMethodId;
    }
    @Override
    @JsonGetter("isDefaultPaymentMethod")
    public boolean isDefaultPaymentMethod() {
        return this.isDefaultPaymentMethod;
    }
    @Override
    public UUID getKbPaymentMethodId() {
        return this.kbPaymentMethodId;
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
        final PaymentMethodPluginImp that = (PaymentMethodPluginImp) o;
        if( !Objects.equals(this.externalPaymentMethodId, that.externalPaymentMethodId) ) {
            return false;
        }
        if( this.isDefaultPaymentMethod != that.isDefaultPaymentMethod ) {
            return false;
        }
        if( !Objects.equals(this.kbPaymentMethodId, that.kbPaymentMethodId) ) {
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
        result = ( 31 * result ) + Objects.hashCode(this.externalPaymentMethodId);
        result = ( 31 * result ) + Objects.hashCode(this.isDefaultPaymentMethod);
        result = ( 31 * result ) + Objects.hashCode(this.kbPaymentMethodId);
        result = ( 31 * result ) + Objects.hashCode(this.properties);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("externalPaymentMethodId=");
        if( this.externalPaymentMethodId == null ) {
            sb.append(this.externalPaymentMethodId);
        }else{
            sb.append("'").append(this.externalPaymentMethodId).append("'");
        }
        sb.append(", ");
        sb.append("isDefaultPaymentMethod=").append(this.isDefaultPaymentMethod);
        sb.append(", ");
        sb.append("kbPaymentMethodId=").append(this.kbPaymentMethodId);
        sb.append(", ");
        sb.append("properties=").append(this.properties);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PaymentMethodPluginImp.Builder<T>> {

        protected String externalPaymentMethodId;
        protected boolean isDefaultPaymentMethod;
        protected UUID kbPaymentMethodId;
        protected List<PluginProperty> properties;

        public Builder() { }
        public Builder(final Builder that) {
            this.externalPaymentMethodId = that.externalPaymentMethodId;
            this.isDefaultPaymentMethod = that.isDefaultPaymentMethod;
            this.kbPaymentMethodId = that.kbPaymentMethodId;
            this.properties = that.properties;
        }
        public T withExternalPaymentMethodId(final String externalPaymentMethodId) {
            this.externalPaymentMethodId = externalPaymentMethodId;
            return (T) this;
        }
        public T withIsDefaultPaymentMethod(final boolean isDefaultPaymentMethod) {
            this.isDefaultPaymentMethod = isDefaultPaymentMethod;
            return (T) this;
        }
        public T withKbPaymentMethodId(final UUID kbPaymentMethodId) {
            this.kbPaymentMethodId = kbPaymentMethodId;
            return (T) this;
        }
        public T withProperties(final List<PluginProperty> properties) {
            this.properties = properties;
            return (T) this;
        }
        public T source(final PaymentMethodPlugin that) {
            this.externalPaymentMethodId = that.getExternalPaymentMethodId();
            this.isDefaultPaymentMethod = that.isDefaultPaymentMethod();
            this.kbPaymentMethodId = that.getKbPaymentMethodId();
            this.properties = that.getProperties();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public PaymentMethodPluginImp build() {
            return new PaymentMethodPluginImp(this.validate());
        }
    }
}
