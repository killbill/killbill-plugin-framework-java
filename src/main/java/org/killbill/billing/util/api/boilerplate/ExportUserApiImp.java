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

package org.killbill.billing.util.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.killbill.billing.util.api.DatabaseExportOutputStream;
import org.killbill.billing.util.api.ExportUserApi;
import org.killbill.billing.util.callcontext.CallContext;

@JsonDeserialize( builder = ExportUserApiImp.Builder.class )
public class ExportUserApiImp implements ExportUserApi {

    private static final long serialVersionUID = 0x34EA044484F07B17L;


    public ExportUserApiImp(final ExportUserApiImp that) {
    }
    protected ExportUserApiImp(final ExportUserApiImp.Builder<?> builder) {
    }
    protected ExportUserApiImp() { }
    @Override
    public void exportDataAsCSVForAccount(final UUID accountId, final OutputStream out, final CallContext context) {
        throw new UnsupportedOperationException("exportDataAsCSVForAccount(java.util.UUID, java.io.OutputStream, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public void exportDataForAccount(final UUID accountId, final DatabaseExportOutputStream out, final CallContext context) {
        throw new UnsupportedOperationException("exportDataForAccount(java.util.UUID, org.killbill.billing.util.api.DatabaseExportOutputStream, org.killbill.billing.util.callcontext.CallContext) must be implemented.");
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends ExportUserApiImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final ExportUserApi that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public ExportUserApiImp build() {
            return new ExportUserApiImp(this.validate());
        }
    }
}
