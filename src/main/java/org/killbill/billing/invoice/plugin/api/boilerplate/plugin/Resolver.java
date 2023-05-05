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

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import org.killbill.billing.invoice.plugin.api.AdditionalItemsResult;
import org.killbill.billing.invoice.plugin.api.InvoiceContext;
import org.killbill.billing.invoice.plugin.api.InvoiceGroup;
import org.killbill.billing.invoice.plugin.api.InvoiceGroupingResult;
import org.killbill.billing.invoice.plugin.api.InvoicePluginApi;
import org.killbill.billing.invoice.plugin.api.InvoiceResult;
import org.killbill.billing.invoice.plugin.api.OnFailureInvoiceResult;
import org.killbill.billing.invoice.plugin.api.OnSuccessInvoiceResult;
import org.killbill.billing.invoice.plugin.api.PriorInvoiceResult;

public class Resolver extends SimpleAbstractTypeResolver {
    public Resolver(){
        this.addMapping(AdditionalItemsResult.class, AdditionalItemsResultImp.class);
        this.addMapping(InvoiceContext.class, InvoiceContextImp.class);
        this.addMapping(InvoiceGroup.class, InvoiceGroupImp.class);
        this.addMapping(InvoiceGroupingResult.class, InvoiceGroupingResultImp.class);
        this.addMapping(InvoicePluginApi.class, InvoicePluginApiImp.class);
        this.addMapping(InvoiceResult.class, InvoiceResultImp.class);
        this.addMapping(OnFailureInvoiceResult.class, OnFailureInvoiceResultImp.class);
        this.addMapping(OnSuccessInvoiceResult.class, OnSuccessInvoiceResultImp.class);
        this.addMapping(PriorInvoiceResult.class, PriorInvoiceResultImp.class);
    }
}
