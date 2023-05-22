/*
 *  Generated by https://github.com/killbill/api-pojos. Do not edit!
 *
 *  Copyright 2022-2022 The Billing Project, LLC
 *
 *  The Billing Project licenses this file to you under the Apache License,
 *  version 2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at:
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 *  License for the specific language governing permissions and limitations
 *  under the License.
 */

package org.killbill.billing.invoice.plugin.api.boilerplate.plugin;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import org.killbill.billing.invoice.plugin.api.OnSuccessInvoiceResult;
import org.killbill.billing.payment.api.PluginProperty;

@JsonDeserialize( builder = OnSuccessInvoiceResultImp.Builder.class )
public class OnSuccessInvoiceResultImp implements OnSuccessInvoiceResult {

    protected Iterable<PluginProperty> adjustedPluginProperties;

    public OnSuccessInvoiceResultImp(final OnSuccessInvoiceResultImp that) {
        this.adjustedPluginProperties = that.adjustedPluginProperties;
    }
    protected OnSuccessInvoiceResultImp(final OnSuccessInvoiceResultImp.Builder<?> builder) {
        this.adjustedPluginProperties = builder.adjustedPluginProperties;
    }
    protected OnSuccessInvoiceResultImp() { }
    @Override
    public Iterable<PluginProperty> getAdjustedPluginProperties() {
        return this.adjustedPluginProperties;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final OnSuccessInvoiceResultImp that = (OnSuccessInvoiceResultImp) o;
        if( !Objects.equals(this.adjustedPluginProperties, that.adjustedPluginProperties) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.adjustedPluginProperties);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("adjustedPluginProperties=").append(this.adjustedPluginProperties);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends OnSuccessInvoiceResultImp.Builder<T>> {

        protected Iterable<PluginProperty> adjustedPluginProperties;

        public Builder() { }
        public Builder(final Builder that) {
            this.adjustedPluginProperties = that.adjustedPluginProperties;
        }
        public T withAdjustedPluginProperties(final Iterable<PluginProperty> adjustedPluginProperties) {
            this.adjustedPluginProperties = adjustedPluginProperties;
            return (T) this;
        }
        public T source(final OnSuccessInvoiceResult that) {
            this.adjustedPluginProperties = that.getAdjustedPluginProperties();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public OnSuccessInvoiceResultImp build() {
            return new OnSuccessInvoiceResultImp(this.validate());
        }
    }
}