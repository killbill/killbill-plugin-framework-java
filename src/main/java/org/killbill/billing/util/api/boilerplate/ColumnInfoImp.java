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
import java.util.Arrays;
import java.util.Objects;
import org.killbill.billing.util.api.ColumnInfo;

@JsonDeserialize( builder = ColumnInfoImp.Builder.class )
public class ColumnInfoImp implements ColumnInfo {

    protected String columnName;
    protected String dataType;
    protected String tableName;

    public ColumnInfoImp(final ColumnInfoImp that) {
        this.columnName = that.columnName;
        this.dataType = that.dataType;
        this.tableName = that.tableName;
    }
    protected ColumnInfoImp(final ColumnInfoImp.Builder<?> builder) {
        this.columnName = builder.columnName;
        this.dataType = builder.dataType;
        this.tableName = builder.tableName;
    }
    protected ColumnInfoImp() { }
    @Override
    public String getColumnName() {
        return this.columnName;
    }
    @Override
    public String getDataType() {
        return this.dataType;
    }
    @Override
    public String getTableName() {
        return this.tableName;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final ColumnInfoImp that = (ColumnInfoImp) o;
        if( !Objects.equals(this.columnName, that.columnName) ) {
            return false;
        }
        if( !Objects.equals(this.dataType, that.dataType) ) {
            return false;
        }
        if( !Objects.equals(this.tableName, that.tableName) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.columnName);
        result = ( 31 * result ) + Objects.hashCode(this.dataType);
        result = ( 31 * result ) + Objects.hashCode(this.tableName);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("columnName=");
        if( this.columnName == null ) {
            sb.append(this.columnName);
        }else{
            sb.append("'").append(this.columnName).append("'");
        }
        sb.append(", ");
        sb.append("dataType=");
        if( this.dataType == null ) {
            sb.append(this.dataType);
        }else{
            sb.append("'").append(this.dataType).append("'");
        }
        sb.append(", ");
        sb.append("tableName=");
        if( this.tableName == null ) {
            sb.append(this.tableName);
        }else{
            sb.append("'").append(this.tableName).append("'");
        }
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends ColumnInfoImp.Builder<T>> {

        protected String columnName;
        protected String dataType;
        protected String tableName;

        public Builder() { }
        public Builder(final Builder that) {
            this.columnName = that.columnName;
            this.dataType = that.dataType;
            this.tableName = that.tableName;
        }
        public T withColumnName(final String columnName) {
            this.columnName = columnName;
            return (T) this;
        }
        public T withDataType(final String dataType) {
            this.dataType = dataType;
            return (T) this;
        }
        public T withTableName(final String tableName) {
            this.tableName = tableName;
            return (T) this;
        }
        public T source(final ColumnInfo that) {
            this.columnName = that.getColumnName();
            this.dataType = that.getDataType();
            this.tableName = that.getTableName();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public ColumnInfoImp build() {
            return new ColumnInfoImp(this.validate());
        }
    }
}
