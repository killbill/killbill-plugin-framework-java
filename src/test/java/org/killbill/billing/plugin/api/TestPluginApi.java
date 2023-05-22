/*
 * Copyright 2020-2023 Equinix, Inc
 * Copyright 2014-2023 The Billing Project, LLC
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

package org.killbill.billing.plugin.api;

import java.util.ArrayList;
import java.util.List;

import org.killbill.billing.entitlement.api.SubscriptionBundle;
import org.killbill.billing.entitlement.api.SubscriptionBundleTimeline;
import org.killbill.billing.entitlement.api.SubscriptionEvent;
import org.killbill.billing.entitlement.api.SubscriptionEventType;
import org.killbill.billing.entitlement.api.boilerplate.SubscriptionBundleImp;
import org.killbill.billing.entitlement.api.boilerplate.SubscriptionBundleTimelineImp;
import org.killbill.billing.entitlement.api.boilerplate.SubscriptionEventImp;
import org.killbill.billing.osgi.libs.killbill.OSGIConfigPropertiesService;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillAPI;
import org.killbill.clock.Clock;
import org.killbill.commons.utils.collect.Iterables;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPluginApi {

    private OSGIKillbillAPI osgiKillbillAPI;
    private OSGIConfigPropertiesService configProperties;
    private Clock clock;

    private PluginApi pluginApi;

    @BeforeMethod(groups = "fast")
    public void beforeMethod() {
        osgiKillbillAPI = Mockito.mock(OSGIKillbillAPI.class);
        configProperties = Mockito.mock(OSGIConfigPropertiesService.class);
        clock = Mockito.mock(Clock.class);

        final PluginApi toSpy = new PluginApi(osgiKillbillAPI, configProperties, clock) {};
        pluginApi = Mockito.spy(toSpy);
    }

    @Test(groups = "fast")
    public void testGetBlockingHistory() {
        final TestGetBlockingHistorySamples samples = new TestGetBlockingHistorySamples();

        Mockito.doReturn(samples.getSample1()).when(pluginApi).getSubscriptionBundlesForAccount(Mockito.any(), Mockito.any());

        Iterable<SubscriptionEvent> history = pluginApi.getBlockingHistory(Mockito.any(), Mockito.any());
        Assert.assertEquals(Iterables.size(history), 14); // 5 + 3 + 6
        history.forEach(evt -> Assert.assertTrue(List.of("A", "C", "E").contains(evt.getServiceName())));

        Mockito.doReturn(samples.getSample2()).when(pluginApi).getSubscriptionBundlesForAccount(Mockito.any(), Mockito.any());

        history = pluginApi.getBlockingHistory(Mockito.any(), Mockito.any());
        Assert.assertEquals(Iterables.size(history), 4); // 2 + 2
        history.forEach(evt -> Assert.assertTrue(List.of("A", "C").contains(evt.getServiceName())));
    }

    private static class TestGetBlockingHistorySamples {

        List<SubscriptionBundle> getSample1() {
            final List<SubscriptionBundle> result = new ArrayList<>();
            result.add(newSubsBundle(0 , null, null)); // [x]
            result.add(newSubsBundle(5 , "A", SubscriptionEventType.START_ENTITLEMENT)); // [v] ObjectType.BLOCKING_STATES
            result.add(newSubsBundle(7 , "B", SubscriptionEventType.START_BILLING)); // [x] ObjectType.SUBSCRIPTION_EVENT
            result.add(newSubsBundle(3 , "C", SubscriptionEventType.PAUSE_ENTITLEMENT)); // [v] ObjectType.BLOCKING_STATES
            result.add(newSubsBundle(10, "D", SubscriptionEventType.CHANGE)); // [x] ObjectType.SUBSCRIPTION_EVENT
            result.add(newSubsBundle(6 , "E", SubscriptionEventType.STOP_ENTITLEMENT)); // [v] ObjectType.BLOCKING_STATES

            return result;
        }

        List<SubscriptionBundle> getSample2() {
            final List<SubscriptionBundle> result = new ArrayList<>();
            result.add(newSubsBundle(2 , "entitlement-service", SubscriptionEventType.START_ENTITLEMENT)); // [x] ObjectType.BLOCKING_STATES
            result.add(newSubsBundle(2 , "entitlement-service", SubscriptionEventType.START_BILLING)); // [x] ObjectType.SUBSCRIPTION_EVENT
            result.add(newSubsBundle(2 , "A", SubscriptionEventType.PAUSE_ENTITLEMENT)); // [v] ObjectType.BLOCKING_STATES
            result.add(newSubsBundle(2 , "B", SubscriptionEventType.CHANGE)); // [x] ObjectType.SUBSCRIPTION_EVENT
            result.add(newSubsBundle(2 , "C", SubscriptionEventType.STOP_ENTITLEMENT)); // [v] ObjectType.BLOCKING_STATES

            return result;
        }

        private SubscriptionBundle newSubsBundle(final int eventCount, final String serviceName, final SubscriptionEventType eventType) {
            final List<SubscriptionEvent> events = new ArrayList<>();
            if (eventCount <= 0) {
                events.add(null);
            } else {
                for (int i = 0; i < eventCount; i++) {
                    events.add(newSubscriptionEvent(serviceName, eventType));
                }
            }

            final SubscriptionBundleTimeline timeline = new SubscriptionBundleTimelineImp.Builder<>().withSubscriptionEvents(events).build();

            return new SubscriptionBundleImp.Builder<>().withTimeline(timeline).build();
        }

        private SubscriptionEvent newSubscriptionEvent(final String serviceName, final SubscriptionEventType eventType) {
            return new SubscriptionEventImp.Builder<>().withServiceName(serviceName).withSubscriptionEventType(eventType).build();
        }
    }
}
