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
import java.util.List;
import java.util.Objects;
import org.killbill.billing.util.nodes.NodeCommandMetadata;
import org.killbill.billing.util.nodes.NodeCommandProperty;

@JsonDeserialize( builder = NodeCommandMetadataImp.Builder.class )
public class NodeCommandMetadataImp implements NodeCommandMetadata {

    private static final long serialVersionUID = 0xD541D122123FD230L;

    protected List<NodeCommandProperty> properties;

    public NodeCommandMetadataImp(final NodeCommandMetadataImp that) {
        this.properties = that.properties;
    }
    protected NodeCommandMetadataImp(final NodeCommandMetadataImp.Builder<?> builder) {
        this.properties = builder.properties;
    }
    protected NodeCommandMetadataImp() { }
    @Override
    public List<NodeCommandProperty> getProperties() {
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
        final NodeCommandMetadataImp that = (NodeCommandMetadataImp) o;
        if( !Objects.equals(this.properties, that.properties) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.properties);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("properties=").append(this.properties);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends NodeCommandMetadataImp.Builder<T>> {

        protected List<NodeCommandProperty> properties;

        public Builder() { }
        public Builder(final Builder that) {
            this.properties = that.properties;
        }
        public T withProperties(final List<NodeCommandProperty> properties) {
            this.properties = properties;
            return (T) this;
        }
        public T source(final NodeCommandMetadata that) {
            this.properties = that.getProperties();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public NodeCommandMetadataImp build() {
            return new NodeCommandMetadataImp(this.validate());
        }
    }
}
