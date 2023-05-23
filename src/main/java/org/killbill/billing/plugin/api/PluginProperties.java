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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.plugin.util.http.UTF8UrlDecoder;
import org.killbill.commons.utils.Strings;
import org.killbill.commons.utils.collect.Iterables;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public abstract class PluginProperties {

    // Last one has precedence
    @SafeVarargs
    public static Iterable<PluginProperty> merge(final Iterable<PluginProperty>... propertiesLists) {
        return buildPluginProperties(toMap(propertiesLists));
    }

    // Last one has precedence
    @SafeVarargs
    public static <K, V> Iterable<PluginProperty> merge(@Nullable final Map<K, V> data, final Iterable<PluginProperty>... propertiesLists) {
        return merge(buildPluginProperties(data), merge(propertiesLists));
    }

    // Last one has precedence
    @SafeVarargs
    public static Map<String, Object> toMap(final Iterable<PluginProperty>... propertiesLists) {
        final Map<String, Object> mergedProperties = new HashMap<>();
        for (final Iterable<PluginProperty> propertiesList : propertiesLists) {
            if (propertiesList == null) {
                continue;
            }
            for (final PluginProperty pluginProperty : propertiesList) {
                if (pluginProperty.getKey() != null && pluginProperty.getValue() != null) {
                    mergedProperties.put(pluginProperty.getKey(), pluginProperty.getValue());
                }
            }
        }
        return mergedProperties;
    }

    // Last one has precedence
    @SafeVarargs
    public static Map<String, String> toStringMap(final Iterable<PluginProperty>... propertiesLists) {
        return toMap(propertiesLists)
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Entry::getKey, entry -> entry.getValue() == null ? null : entry.getValue().toString()));
    }

    // Return the value from the plugin properties if it exists, or the fallback otherwise
    public static String getValue(final String pluginPropertyName, final String fallbackValue, final Iterable<PluginProperty> properties) {
        final String pluginPropertyValue = findPluginPropertyValue(pluginPropertyName, properties);
        return pluginPropertyValue == null ? fallbackValue : pluginPropertyValue;
    }

    public static String findPluginPropertyValue(final String pluginPropertyName, @Nullable final Iterable<PluginProperty> properties) {
        if (properties == null) {
            return null;
        }

        final PluginProperty pluginProperty = Iterables.toStream(properties)
                                                       .filter(input -> input != null && pluginPropertyName.equals(input.getKey()))
                                                       .findFirst().orElse(null);

        if (pluginProperty == null || pluginProperty.getValue() == null) {
            return null;
        }
        final String pluginPropertyString = String.valueOf(pluginProperty.getValue());
        return Strings.isNullOrEmpty(pluginPropertyString) ? null : pluginPropertyString;
    }

    public static String findAndDecodePluginPropertyValue(final String pluginPropertyName, @Nullable final Iterable<PluginProperty> properties) {
        final String undecodedValue = findPluginPropertyValue(pluginPropertyName, properties);
        return undecodedValue == null ? null : UTF8UrlDecoder.decode(undecodedValue).toString();
    }

    public static Iterable<PluginProperty> findPluginProperties(final String key, @Nullable final Iterable<PluginProperty> properties) {
        if (properties == null) {
            return null;
        }

        return Iterables.toStream(properties)
                        .filter(input -> key != null && input != null && key.equals(input.getKey()))
                        .collect(Collectors.toUnmodifiableSet());
    }

    public static Iterable<PluginProperty> findPluginProperties(final Pattern keyPattern, @Nullable final Iterable<PluginProperty> properties) {
        if (properties == null) {
            return null;
        }

        return Iterables.toStream(properties)
                        .filter(input -> keyPattern != null && input != null && keyPattern.matcher(input.getKey()).matches())
                        .collect(Collectors.toUnmodifiableSet());
    }

    @SuppressFBWarnings("WMI_WRONG_MAP_ITERATOR")
    public static <K, V> List<PluginProperty> buildPluginProperties(@Nullable final Map<K, V> data) {
        if (data == null || data.isEmpty()) {
            return Collections.emptyList();
        }
        return data.entrySet().stream()
                   .map(entry -> new PluginProperty(entry.getKey().toString(), entry.getValue(), false))
                   .collect(Collectors.toUnmodifiableList());
    }
}
