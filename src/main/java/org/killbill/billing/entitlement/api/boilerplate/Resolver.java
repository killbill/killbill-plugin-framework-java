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

package org.killbill.billing.entitlement.api.boilerplate;

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import org.killbill.billing.entitlement.api.BaseEntitlementWithAddOnsSpecifier;
import org.killbill.billing.entitlement.api.Blockable;
import org.killbill.billing.entitlement.api.BlockingState;
import org.killbill.billing.entitlement.api.Entitlement;
import org.killbill.billing.entitlement.api.EntitlementAOStatusDryRun;
import org.killbill.billing.entitlement.api.EntitlementApi;
import org.killbill.billing.entitlement.api.EntitlementSpecifier;
import org.killbill.billing.entitlement.api.Subscription;
import org.killbill.billing.entitlement.api.SubscriptionApi;
import org.killbill.billing.entitlement.api.SubscriptionBundle;
import org.killbill.billing.entitlement.api.SubscriptionBundleTimeline;
import org.killbill.billing.entitlement.api.SubscriptionEvent;

public class Resolver extends SimpleAbstractTypeResolver {
    public Resolver(){
        this.addMapping(BaseEntitlementWithAddOnsSpecifier.class, BaseEntitlementWithAddOnsSpecifierImp.class);
        this.addMapping(Blockable.class, BlockableImp.class);
        this.addMapping(BlockingState.class, BlockingStateImp.class);
        this.addMapping(EntitlementAOStatusDryRun.class, EntitlementAOStatusDryRunImp.class);
        this.addMapping(EntitlementApi.class, EntitlementApiImp.class);
        this.addMapping(Entitlement.class, EntitlementImp.class);
        this.addMapping(EntitlementSpecifier.class, EntitlementSpecifierImp.class);
        this.addMapping(SubscriptionApi.class, SubscriptionApiImp.class);
        this.addMapping(SubscriptionBundle.class, SubscriptionBundleImp.class);
        this.addMapping(SubscriptionBundleTimeline.class, SubscriptionBundleTimelineImp.class);
        this.addMapping(SubscriptionEvent.class, SubscriptionEventImp.class);
        this.addMapping(Subscription.class, SubscriptionImp.class);
    }
}
