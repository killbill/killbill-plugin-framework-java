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
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.killbill.billing.util.api.ColumnInfo;
import org.killbill.billing.util.api.DatabaseExportOutputStream;

@JsonDeserialize( builder = DatabaseExportOutputStreamImp.Builder.class )
public class DatabaseExportOutputStreamImp implements DatabaseExportOutputStream {


    public DatabaseExportOutputStreamImp(final DatabaseExportOutputStreamImp that) {
    }
    protected DatabaseExportOutputStreamImp(final DatabaseExportOutputStreamImp.Builder<?> builder) {
    }
    protected DatabaseExportOutputStreamImp() { }
    @Override
    public void newTable(final String tableName, final List<ColumnInfo> columnsForTable) {
        throw new UnsupportedOperationException("newTable(java.lang.String, java.util.List<org.killbill.billing.util.api.ColumnInfo>) must be implemented.");
    }
    @Override
    public void write(final Map<String, Object> row) {
        throw new UnsupportedOperationException("write(java.util.Map<java.lang.String, java.lang.Object>) must be implemented.");
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
    public static class Builder<T extends DatabaseExportOutputStreamImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final DatabaseExportOutputStream that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public DatabaseExportOutputStreamImp build() {
            return new DatabaseExportOutputStreamImp(this.validate());
        }
    }
}
