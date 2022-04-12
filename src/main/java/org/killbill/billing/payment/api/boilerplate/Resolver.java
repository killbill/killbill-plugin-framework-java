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

package org.killbill.billing.payment.api.boilerplate;

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import org.killbill.billing.payment.api.AdminPaymentApi;
import org.killbill.billing.payment.api.InvoicePaymentApi;
import org.killbill.billing.payment.api.Payment;
import org.killbill.billing.payment.api.PaymentApi;
import org.killbill.billing.payment.api.PaymentAttempt;
import org.killbill.billing.payment.api.PaymentGatewayApi;
import org.killbill.billing.payment.api.PaymentMethod;
import org.killbill.billing.payment.api.PaymentMethodPlugin;
import org.killbill.billing.payment.api.PaymentOptions;
import org.killbill.billing.payment.api.PaymentTransaction;

public class Resolver extends SimpleAbstractTypeResolver {
    public Resolver(){
        this.addMapping(AdminPaymentApi.class, AdminPaymentApiImp.class);
        this.addMapping(InvoicePaymentApi.class, InvoicePaymentApiImp.class);
        this.addMapping(PaymentApi.class, PaymentApiImp.class);
        this.addMapping(PaymentAttempt.class, PaymentAttemptImp.class);
        this.addMapping(PaymentGatewayApi.class, PaymentGatewayApiImp.class);
        this.addMapping(Payment.class, PaymentImp.class);
        this.addMapping(PaymentMethod.class, PaymentMethodImp.class);
        this.addMapping(PaymentMethodPlugin.class, PaymentMethodPluginImp.class);
        this.addMapping(PaymentOptions.class, PaymentOptionsImp.class);
        this.addMapping(PaymentTransaction.class, PaymentTransactionImp.class);
    }
}
