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
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.plugin.api.GatewayNotification;

@JsonDeserialize( builder = GatewayNotificationImp.Builder.class )
public class GatewayNotificationImp implements GatewayNotification {

    private static final long serialVersionUID = 0x4CAF1439F4E546C7L;

    protected String entity;
    protected Map<String, List<String>> headers;
    protected UUID kbPaymentId;
    protected List<PluginProperty> properties;
    protected int status;

    public GatewayNotificationImp(final GatewayNotificationImp that) {
        this.entity = that.entity;
        this.headers = that.headers;
        this.kbPaymentId = that.kbPaymentId;
        this.properties = that.properties;
        this.status = that.status;
    }
    protected GatewayNotificationImp(final GatewayNotificationImp.Builder<?> builder) {
        this.entity = builder.entity;
        this.headers = builder.headers;
        this.kbPaymentId = builder.kbPaymentId;
        this.properties = builder.properties;
        this.status = builder.status;
    }
    protected GatewayNotificationImp() { }
    @Override
    public String getEntity() {
        return this.entity;
    }
    @Override
    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }
    @Override
    public UUID getKbPaymentId() {
        return this.kbPaymentId;
    }
    @Override
    public List<PluginProperty> getProperties() {
        return this.properties;
    }
    @Override
    public int getStatus() {
        return this.status;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final GatewayNotificationImp that = (GatewayNotificationImp) o;
        if( !Objects.equals(this.entity, that.entity) ) {
            return false;
        }
        if( !Objects.equals(this.headers, that.headers) ) {
            return false;
        }
        if( !Objects.equals(this.kbPaymentId, that.kbPaymentId) ) {
            return false;
        }
        if( !Objects.equals(this.properties, that.properties) ) {
            return false;
        }
        if( this.status != that.status ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.entity);
        result = ( 31 * result ) + Objects.hashCode(this.headers);
        result = ( 31 * result ) + Objects.hashCode(this.kbPaymentId);
        result = ( 31 * result ) + Objects.hashCode(this.properties);
        result = ( 31 * result ) + Objects.hashCode(this.status);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("entity=");
        if( this.entity == null ) {
            sb.append(this.entity);
        }else{
            sb.append("'").append(this.entity).append("'");
        }
        sb.append(", ");
        sb.append("headers=").append(this.headers);
        sb.append(", ");
        sb.append("kbPaymentId=").append(this.kbPaymentId);
        sb.append(", ");
        sb.append("properties=").append(this.properties);
        sb.append(", ");
        sb.append("status=").append(this.status);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends GatewayNotificationImp.Builder<T>> {

        protected String entity;
        protected Map<String, List<String>> headers;
        protected UUID kbPaymentId;
        protected List<PluginProperty> properties;
        protected int status;

        public Builder() { }
        public Builder(final Builder that) {
            this.entity = that.entity;
            this.headers = that.headers;
            this.kbPaymentId = that.kbPaymentId;
            this.properties = that.properties;
            this.status = that.status;
        }
        public T withEntity(final String entity) {
            this.entity = entity;
            return (T) this;
        }
        public T withHeaders(final Map<String, List<String>> headers) {
            this.headers = headers;
            return (T) this;
        }
        public T withKbPaymentId(final UUID kbPaymentId) {
            this.kbPaymentId = kbPaymentId;
            return (T) this;
        }
        public T withProperties(final List<PluginProperty> properties) {
            this.properties = properties;
            return (T) this;
        }
        public T withStatus(final int status) {
            this.status = status;
            return (T) this;
        }
        public T source(final GatewayNotification that) {
            this.entity = that.getEntity();
            this.headers = that.getHeaders();
            this.kbPaymentId = that.getKbPaymentId();
            this.properties = that.getProperties();
            this.status = that.getStatus();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public GatewayNotificationImp build() {
            return new GatewayNotificationImp(this.validate());
        }
    }
}
