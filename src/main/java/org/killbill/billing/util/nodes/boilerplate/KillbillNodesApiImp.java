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
import org.killbill.billing.osgi.api.PluginInfo;
import org.killbill.billing.util.nodes.KillbillNodesApi;
import org.killbill.billing.util.nodes.NodeCommand;
import org.killbill.billing.util.nodes.NodeInfo;

@JsonDeserialize( builder = KillbillNodesApiImp.Builder.class )
public class KillbillNodesApiImp implements KillbillNodesApi {

    private static final long serialVersionUID = 0x8FC81437A4796EABL;

    protected NodeInfo currentNodeInfo;
    protected Iterable<NodeInfo> nodesInfo;

    public KillbillNodesApiImp(final KillbillNodesApiImp that) {
        this.currentNodeInfo = that.currentNodeInfo;
        this.nodesInfo = that.nodesInfo;
    }
    protected KillbillNodesApiImp(final KillbillNodesApiImp.Builder<?> builder) {
        this.currentNodeInfo = builder.currentNodeInfo;
        this.nodesInfo = builder.nodesInfo;
    }
    protected KillbillNodesApiImp() { }
    @Override
    public NodeInfo getCurrentNodeInfo() {
        return this.currentNodeInfo;
    }
    @Override
    public Iterable<NodeInfo> getNodesInfo() {
        return this.nodesInfo;
    }
    @Override
    public void notifyPluginChanged(final PluginInfo plugin, final Iterable<PluginInfo> latestPlugins) {
        throw new UnsupportedOperationException("notifyPluginChanged(org.killbill.billing.osgi.api.PluginInfo, java.lang.Iterable<org.killbill.billing.osgi.api.PluginInfo>) must be implemented.");
    }
    @Override
    public void triggerNodeCommand(final NodeCommand nodeCommand, final boolean localNodeOnly) {
        throw new UnsupportedOperationException("triggerNodeCommand(org.killbill.billing.util.nodes.NodeCommand, boolean) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final KillbillNodesApiImp that = (KillbillNodesApiImp) o;
        if( !Objects.equals(this.currentNodeInfo, that.currentNodeInfo) ) {
            return false;
        }
        if( !Objects.equals(this.nodesInfo, that.nodesInfo) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.currentNodeInfo);
        result = ( 31 * result ) + Objects.hashCode(this.nodesInfo);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("currentNodeInfo=").append(this.currentNodeInfo);
        sb.append(", ");
        sb.append("nodesInfo=").append(this.nodesInfo);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends KillbillNodesApiImp.Builder<T>> {

        protected NodeInfo currentNodeInfo;
        protected Iterable<NodeInfo> nodesInfo;

        public Builder() { }
        public Builder(final Builder that) {
            this.currentNodeInfo = that.currentNodeInfo;
            this.nodesInfo = that.nodesInfo;
        }
        public T withCurrentNodeInfo(final NodeInfo currentNodeInfo) {
            this.currentNodeInfo = currentNodeInfo;
            return (T) this;
        }
        public T withNodesInfo(final Iterable<NodeInfo> nodesInfo) {
            this.nodesInfo = nodesInfo;
            return (T) this;
        }
        public T source(final KillbillNodesApi that) {
            this.currentNodeInfo = that.getCurrentNodeInfo();
            this.nodesInfo = that.getNodesInfo();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public KillbillNodesApiImp build() {
            return new KillbillNodesApiImp(this.validate());
        }
    }
}
