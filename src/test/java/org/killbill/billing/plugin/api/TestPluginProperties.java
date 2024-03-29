/*
 * Copyright 2014-2020 Groupon, Inc
 * Copyright 2020-2020 Equinix, Inc
 * Copyright 2014-2020 The Billing Project, LLC
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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.commons.utils.collect.Iterables;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPluginProperties {

    private final List<PluginProperty> pluginProperties1 = PluginProperties.buildPluginProperties(Map.of("foo", "bar", "baz", 12L));
    private final List<PluginProperty> pluginProperties2 = PluginProperties.buildPluginProperties(Map.of("foo", "override", "baz2", "something else"));
    private final String encodedPropertyValue = "%7B%22eventType%22%3A%22voidEvent%22%2C%22transactionType%22%3A%22void%22%2C%22contractType%22%3A%22temp%22%7D";
    private final String decodedPropertyValue = "{\"eventType\":\"voidEvent\",\"transactionType\":\"void\",\"contractType\":\"temp\"}";
    private final List<PluginProperty> pluginProperties3 = PluginProperties.buildPluginProperties(Map.of("foo", encodedPropertyValue));

    @Test(groups = "fast")
    public void testMerge() {
        final List<PluginProperty> pluginProperties = sort(PluginProperties.merge(pluginProperties1, pluginProperties2));

        Assert.assertEquals(pluginProperties.size(), 3);
        Assert.assertEquals(pluginProperties.get(0).getKey(), "baz");
        Assert.assertEquals(pluginProperties.get(0).getValue(), 12L);
        Assert.assertFalse(pluginProperties.get(0).getIsUpdatable());
        Assert.assertEquals(pluginProperties.get(1).getKey(), "baz2");
        Assert.assertEquals(pluginProperties.get(1).getValue(), "something else");
        Assert.assertFalse(pluginProperties.get(1).getIsUpdatable());
        Assert.assertEquals(pluginProperties.get(2).getKey(), "foo");
        Assert.assertEquals(pluginProperties.get(2).getValue(), "override");
        Assert.assertFalse(pluginProperties.get(2).getIsUpdatable());

        final Iterable<PluginProperty> pluginPropertiesRaw2 = PluginProperties.merge(PluginProperties.toMap(pluginProperties1), pluginProperties2);
        Assert.assertEquals(sort(pluginPropertiesRaw2), pluginProperties);

        final Iterable<PluginProperty> pluginPropertiesRaw3 = PluginProperties.merge(PluginProperties.toMap(pluginProperties1), pluginProperties1, pluginProperties2);
        Assert.assertEquals(sort(pluginPropertiesRaw3), pluginProperties);

        final Iterable<PluginProperty> pluginPropertiesRaw4 = PluginProperties.merge(PluginProperties.merge(Collections.emptyMap(), pluginProperties1, pluginProperties2));
        Assert.assertEquals(sort(pluginPropertiesRaw4), pluginProperties);

        final Iterable<PluginProperty> pluginPropertiesRaw5 = PluginProperties.merge((Map) null, pluginProperties1, pluginProperties2);
        Assert.assertEquals(sort(pluginPropertiesRaw5), pluginProperties);
    }

    @Test(groups = "fast")
    public void testToMap() throws Exception {
        final Map<String, Object> properties = PluginProperties.toMap(pluginProperties1, pluginProperties2);
        Assert.assertEquals(properties.get("baz"), (Long) 12L);
        Assert.assertEquals(properties.get("baz2"), "something else");
        Assert.assertEquals(properties.get("foo"), "override");
    }

    @Test(groups = "fast")
    public void testToMapWithNull() throws Exception {
        final Map<String, Object> properties = PluginProperties.toMap(null, pluginProperties2);
        Assert.assertNull(properties.get("baz"));
        Assert.assertEquals(properties.get("baz2"), "something else");
        Assert.assertEquals(properties.get("foo"), "override");
    }

    @Test(groups = "fast")
    public void testToStringMap() throws Exception {
        final Map<String, String> properties = PluginProperties.toStringMap(pluginProperties1, pluginProperties2);
        Assert.assertEquals(properties.get("baz"), "12");
        Assert.assertEquals(properties.get("baz2"), "something else");
        Assert.assertEquals(properties.get("foo"), "override");
    }

    @Test(groups = "fast")
    public void testGetValue() throws Exception {
        Assert.assertEquals(PluginProperties.getValue("baz", "NO", pluginProperties1), "12");
        Assert.assertEquals(PluginProperties.getValue("foo", "NO", pluginProperties1), "bar");
        Assert.assertEquals(PluginProperties.getValue("baz2", "YES", pluginProperties1), "YES");
    }

    @Test(groups = "fast")
    public void testFindPluginPropertyValue() throws Exception {
        Assert.assertEquals(PluginProperties.findPluginPropertyValue("baz", pluginProperties1), "12");
        Assert.assertEquals(PluginProperties.findPluginPropertyValue("foo", pluginProperties1), "bar");
        Assert.assertNull(PluginProperties.findPluginPropertyValue("baz2", pluginProperties1));
    }

    @Test(groups = "fast")
    public void testFindAndDecodePluginPropertyValue() throws Exception {
        Assert.assertEquals(PluginProperties.findAndDecodePluginPropertyValue("foo", pluginProperties3), decodedPropertyValue);
    }

    @Test(groups = "fast")
    public void testFindPluginPropertiesUsingString() throws Exception {
        Assert.assertTrue(PluginProperties.findPluginProperties("baz", pluginProperties1).iterator().hasNext());
        Assert.assertFalse(PluginProperties.findPluginProperties("baz2", pluginProperties1).iterator().hasNext());
    }

    @Test(groups = "fast")
    public void testFindPluginPropertiesUsingPattern() throws Exception {
        Assert.assertTrue(PluginProperties.findPluginProperties(Pattern.compile("^b.z$"), pluginProperties1).iterator().hasNext());
        Assert.assertFalse(PluginProperties.findPluginProperties(Pattern.compile("^b.{2}2$"), pluginProperties1).iterator().hasNext());
        Assert.assertTrue(PluginProperties.findPluginProperties(Pattern.compile("^b.{2}2$"), pluginProperties2).iterator().hasNext());
    }

    @Test(groups = "fast")
    public void testBuildPluginProperties() {
        Assert.assertEquals(pluginProperties1.size(), 2);
        Assert.assertTrue(pluginProperties1.stream().anyMatch(i -> "foo".equals(i.getKey())));
        Assert.assertTrue(pluginProperties1.stream().anyMatch(i -> "baz".equals(i.getKey())));

        Assert.assertTrue(pluginProperties1.stream().anyMatch(i -> "bar".equals(i.getValue())));
        Assert.assertTrue(pluginProperties1.stream().anyMatch(i -> i.getValue() != null && "12".equals(i.getValue().toString())));

        // When PluginProperties.buildPluginProperties() called, there's no guarantee that the first added map entry
        // would be the first element of the List. When using guava's ImmutableMap, it's known that guava make its
        // implementation "sorted", so this assertion will always valid. This will not the same with JDK map. For short:
        // - "pluginProperties1.get(0).getKey()" using Guava's ImmutableMap.of() : Will always return "foo"
        // - "pluginProperties1.get(0).getKey()" using JDK Map.of() : No guarantee.
        //
        // Keep old assertion here just in case we need to rethink about this.
        /*
        Assert.assertEquals(pluginProperties1.size(), 2);
        Assert.assertEquals(pluginProperties1.get(0).getKey(), "foo");
        Assert.assertEquals(pluginProperties1.get(0).getValue(), "bar");
        Assert.assertFalse(pluginProperties1.get(0).getIsUpdatable());
        Assert.assertEquals(pluginProperties1.get(1).getKey(), "baz");
        Assert.assertEquals(pluginProperties1.get(1).getValue(), 12L);
        Assert.assertFalse(pluginProperties1.get(1).getIsUpdatable()); */
    }

    private List<PluginProperty> sort(final Iterable<PluginProperty> pluginProperties) {
        return Iterables.toStream(pluginProperties)
                        .sorted(Comparator.comparing(PluginProperty::getKey))
                        .collect(Collectors.toUnmodifiableList());
    }
}
