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

package org.killbill.billing.invoice.api.formatters.boilerplate;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class Module extends SimpleModule {
    public Module(){
        this.setAbstractTypes(new Resolver());
    }
    @Override
    public String getModuleName(){
        return "org.killbill.billing.invoice.api.formatters.boilerplate";
    }
}
