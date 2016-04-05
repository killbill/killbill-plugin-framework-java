/*
 * Copyright 2014 Groupon, Inc
 * Copyright 2014 The Billing Project, LLC
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.plugin.util.http.UTF8UrlDecoder;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

public abstract class PluginProperties {

    // Last one has precedence
    public static Iterable<PluginProperty> merge(final Iterable<PluginProperty>... propertiesLists) {
        return buildPluginProperties(toMap(propertiesLists));
    }

    // Last one has precedence
    public static Map<String, Object> toMap(final Iterable<PluginProperty>... propertiesLists) {
        final Map<String, Object> mergedProperties = new HashMap<String, Object>();
        for (final Iterable<PluginProperty> propertiesList : propertiesLists) {
            for (final PluginProperty pluginProperty : propertiesList) {
                if (pluginProperty.getKey() != null && pluginProperty.getValue() != null) {
                    mergedProperties.put(pluginProperty.getKey(), pluginProperty.getValue());
                }
            }
        }
        return mergedProperties;
    }

    // Last one has precedence
    public static Map<String, String> toStringMap(final Iterable<PluginProperty>... propertiesLists) {
        return Maps.transformValues(toMap(propertiesLists),
                                    new Function<Object, String>() {
                                        @Nullable
                                        @Override
                                        public String apply(@Nullable final Object input) {
                                            return input == null ? null : input.toString();
                                        }
                                    });
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

        final PluginProperty pluginProperty = Iterables.tryFind(properties,
                                                                new Predicate<PluginProperty>() {
                                                                    @Override
                                                                    public boolean apply(final PluginProperty input) {
                                                                        return pluginPropertyName.equals(input.getKey());
                                                                    }
                                                                }).orNull();

        if (pluginProperty == null || pluginProperty.getValue() == null) {
            return null;
        }
        final String pluginPropertyString = String.valueOf(pluginProperty.getValue());
        return Strings.isNullOrEmpty(pluginPropertyString) ? null : pluginPropertyString;
    }

    public static String findAndDecodePluginPropertyValue(final String pluginPropertyName, @Nullable final Iterable<PluginProperty> properties) {
        String undecodedValue = findPluginPropertyValue(pluginPropertyName, properties);
        return Strings.isNullOrEmpty(undecodedValue) ? null : UTF8UrlDecoder.decode(undecodedValue).toString();
    }

    public static Iterable<PluginProperty> findPluginProperties(final String key, @Nullable final Iterable<PluginProperty> properties) {
        if (properties == null) {
            return null;
        }

        return Iterables.filter(properties,
                                new Predicate<PluginProperty>() {
                                    @Override
                                    public boolean apply(final PluginProperty input) {
                                        return key.equals(input.getKey());
                                    }
                                });
    }

    public static Iterable<PluginProperty> findPluginProperties(final Pattern keyPattern, @Nullable final Iterable<PluginProperty> properties) {
        if (properties == null) {
            return null;
        }

        return Iterables.filter(properties,
                                new Predicate<PluginProperty>() {
                                    @Override
                                    public boolean apply(final PluginProperty input) {
                                        return keyPattern.matcher(input.getKey()).matches();
                                    }
                                });
    }

    public static List<PluginProperty> buildPluginProperties(@Nullable final Map data) {
        final ImmutableList.Builder<PluginProperty> propertiesBuilder = ImmutableList.builder();
        if (data != null) {
            for (final Object key : data.keySet()) {
                if (key != null) {
                    final PluginProperty property = new PluginProperty(key.toString(), data.get(key), false);
                    propertiesBuilder.add(property);
                }
            }
        }
        return propertiesBuilder.build();
    }
}
