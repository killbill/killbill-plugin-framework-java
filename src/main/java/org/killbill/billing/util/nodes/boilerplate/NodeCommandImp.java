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
import org.killbill.billing.util.nodes.NodeCommand;
import org.killbill.billing.util.nodes.NodeCommandMetadata;

@JsonDeserialize( builder = NodeCommandImp.Builder.class )
public class NodeCommandImp implements NodeCommand {

    private static final long serialVersionUID = 0xACC5A6CA0AF22EEFL;

    protected boolean isSystemCommandType;
    protected NodeCommandMetadata nodeCommandMetadata;
    protected String nodeCommandType;

    public NodeCommandImp(final NodeCommandImp that) {
        this.isSystemCommandType = that.isSystemCommandType;
        this.nodeCommandMetadata = that.nodeCommandMetadata;
        this.nodeCommandType = that.nodeCommandType;
    }
    protected NodeCommandImp(final NodeCommandImp.Builder<?> builder) {
        this.isSystemCommandType = builder.isSystemCommandType;
        this.nodeCommandMetadata = builder.nodeCommandMetadata;
        this.nodeCommandType = builder.nodeCommandType;
    }
    protected NodeCommandImp() { }
    @Override
    @JsonGetter("isSystemCommandType")
    public boolean isSystemCommandType() {
        return this.isSystemCommandType;
    }
    @Override
    public NodeCommandMetadata getNodeCommandMetadata() {
        return this.nodeCommandMetadata;
    }
    @Override
    public String getNodeCommandType() {
        return this.nodeCommandType;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final NodeCommandImp that = (NodeCommandImp) o;
        if( this.isSystemCommandType != that.isSystemCommandType ) {
            return false;
        }
        if( !Objects.equals(this.nodeCommandMetadata, that.nodeCommandMetadata) ) {
            return false;
        }
        if( !Objects.equals(this.nodeCommandType, that.nodeCommandType) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.isSystemCommandType);
        result = ( 31 * result ) + Objects.hashCode(this.nodeCommandMetadata);
        result = ( 31 * result ) + Objects.hashCode(this.nodeCommandType);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("isSystemCommandType=").append(this.isSystemCommandType);
        sb.append(", ");
        sb.append("nodeCommandMetadata=").append(this.nodeCommandMetadata);
        sb.append(", ");
        sb.append("nodeCommandType=");
        if( this.nodeCommandType == null ) {
            sb.append(this.nodeCommandType);
        }else{
            sb.append("'").append(this.nodeCommandType).append("'");
        }
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends NodeCommandImp.Builder<T>> {

        protected boolean isSystemCommandType;
        protected NodeCommandMetadata nodeCommandMetadata;
        protected String nodeCommandType;

        public Builder() { }
        public Builder(final Builder that) {
            this.isSystemCommandType = that.isSystemCommandType;
            this.nodeCommandMetadata = that.nodeCommandMetadata;
            this.nodeCommandType = that.nodeCommandType;
        }
        public T withIsSystemCommandType(final boolean isSystemCommandType) {
            this.isSystemCommandType = isSystemCommandType;
            return (T) this;
        }
        public T withNodeCommandMetadata(final NodeCommandMetadata nodeCommandMetadata) {
            this.nodeCommandMetadata = nodeCommandMetadata;
            return (T) this;
        }
        public T withNodeCommandType(final String nodeCommandType) {
            this.nodeCommandType = nodeCommandType;
            return (T) this;
        }
        public T source(final NodeCommand that) {
            this.isSystemCommandType = that.isSystemCommandType();
            this.nodeCommandMetadata = that.getNodeCommandMetadata();
            this.nodeCommandType = that.getNodeCommandType();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public NodeCommandImp build() {
            return new NodeCommandImp(this.validate());
        }
    }
}
