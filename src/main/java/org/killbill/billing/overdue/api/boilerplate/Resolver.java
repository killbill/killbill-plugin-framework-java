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

package org.killbill.billing.overdue.api.boilerplate;

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import org.killbill.billing.overdue.api.EmailNotification;
import org.killbill.billing.overdue.api.OverdueApi;
import org.killbill.billing.overdue.api.OverdueCondition;
import org.killbill.billing.overdue.api.OverdueConfig;
import org.killbill.billing.overdue.api.OverdueState;
import org.killbill.billing.overdue.api.OverdueStatesAccount;

public class Resolver extends SimpleAbstractTypeResolver {
    public Resolver(){
        this.addMapping(EmailNotification.class, EmailNotificationImp.class);
        this.addMapping(OverdueApi.class, OverdueApiImp.class);
        this.addMapping(OverdueCondition.class, OverdueConditionImp.class);
        this.addMapping(OverdueConfig.class, OverdueConfigImp.class);
        this.addMapping(OverdueState.class, OverdueStateImp.class);
        this.addMapping(OverdueStatesAccount.class, OverdueStatesAccountImp.class);
    }
}
