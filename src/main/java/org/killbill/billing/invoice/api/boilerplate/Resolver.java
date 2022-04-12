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

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import org.killbill.billing.invoice.api.DryRunArguments;
import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.invoice.api.InvoiceCreationEvent;
import org.killbill.billing.invoice.api.InvoiceItem;
import org.killbill.billing.invoice.api.InvoiceParentChild;
import org.killbill.billing.invoice.api.InvoicePayment;
import org.killbill.billing.invoice.api.InvoiceUserApi;

public class Resolver extends SimpleAbstractTypeResolver {
    public Resolver(){
        this.addMapping(DryRunArguments.class, DryRunArgumentsImp.class);
        this.addMapping(InvoiceCreationEvent.class, InvoiceCreationEventImp.class);
        this.addMapping(Invoice.class, InvoiceImp.class);
        this.addMapping(InvoiceItem.class, InvoiceItemImp.class);
        this.addMapping(InvoiceParentChild.class, InvoiceParentChildImp.class);
        this.addMapping(InvoicePayment.class, InvoicePaymentImp.class);
        this.addMapping(InvoiceUserApi.class, InvoiceUserApiImp.class);
    }
}
