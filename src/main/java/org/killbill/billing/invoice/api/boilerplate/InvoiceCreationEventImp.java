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

package org.killbill.billing.invoice.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import org.killbill.billing.invoice.api.InvoiceCreationEvent;

@JsonDeserialize( builder = InvoiceCreationEventImp.Builder.class )
public class InvoiceCreationEventImp implements InvoiceCreationEvent, Serializable {

    private static final long serialVersionUID = 0x16BB71F278A6B022L;


    public InvoiceCreationEventImp(final InvoiceCreationEventImp that) {
    }
    protected InvoiceCreationEventImp(final InvoiceCreationEventImp.Builder<?> builder) {
    }
    protected InvoiceCreationEventImp() { }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final InvoiceCreationEventImp that = (InvoiceCreationEventImp) o;
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
    public static class Builder<T extends InvoiceCreationEventImp.Builder<T>> {


        public Builder() { }
        public Builder(final Builder that) {
        }
        public T source(final InvoiceCreationEvent that) {
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public InvoiceCreationEventImp build() {
            return new InvoiceCreationEventImp(this.validate());
        }
    }
}
