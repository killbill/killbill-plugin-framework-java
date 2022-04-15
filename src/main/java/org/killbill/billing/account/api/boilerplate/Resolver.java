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

package org.killbill.billing.account.api.boilerplate;

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import org.killbill.billing.account.api.Account;
import org.killbill.billing.account.api.AccountData;
import org.killbill.billing.account.api.AccountEmail;
import org.killbill.billing.account.api.AccountUserApi;
import org.killbill.billing.account.api.ImmutableAccountData;
import org.killbill.billing.account.api.MutableAccountData;

public class Resolver extends SimpleAbstractTypeResolver {
    public Resolver(){
        this.addMapping(AccountData.class, AccountDataImp.class);
        this.addMapping(AccountEmail.class, AccountEmailImp.class);
        this.addMapping(Account.class, AccountImp.class);
        this.addMapping(AccountUserApi.class, AccountUserApiImp.class);
        this.addMapping(ImmutableAccountData.class, ImmutableAccountDataImp.class);
        this.addMapping(MutableAccountData.class, MutableAccountDataImp.class);
    }
}