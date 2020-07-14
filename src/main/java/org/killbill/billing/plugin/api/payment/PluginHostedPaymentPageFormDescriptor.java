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

package org.killbill.billing.plugin.api.payment;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.plugin.api.HostedPaymentPageFormDescriptor;
import org.killbill.billing.plugin.util.http.QueryComputer;
import org.killbill.billing.plugin.util.http.URIUtils;

import com.google.common.collect.ImmutableList;

public class PluginHostedPaymentPageFormDescriptor implements HostedPaymentPageFormDescriptor {

    public static final String GET = "GET";
    public static final String POST = "POST";

    private final UUID kbAccountId;
    private final String formMethod;
    private final String formUrl;
    private final List<PluginProperty> formFields;
    private final List<PluginProperty> properties;

    public PluginHostedPaymentPageFormDescriptor(final UUID kbAccountId, final String formUrl) {
        this(kbAccountId, GET, formUrl, ImmutableList.<PluginProperty>of());
    }

    public PluginHostedPaymentPageFormDescriptor(final UUID kbAccountId, final String formUrl, final List<PluginProperty> formFields) {
        this(kbAccountId, POST, formUrl, formFields);
    }

    public PluginHostedPaymentPageFormDescriptor(final UUID kbAccountId, final String formMethod, final String formUrl, final List<PluginProperty> formFields) {
        this(kbAccountId, formMethod, formUrl, formFields, ImmutableList.<PluginProperty>of());
    }

    public PluginHostedPaymentPageFormDescriptor(final UUID kbAccountId,
                                                 final String formMethod,
                                                 final String formUrl,
                                                 final List<PluginProperty> formFields,
                                                 final List<PluginProperty> properties) {
        this.kbAccountId = kbAccountId;
        this.formMethod = formMethod;
        this.formUrl = formUrl;
        this.formFields = formFields;
        this.properties = properties;
    }

    public PluginHostedPaymentPageFormDescriptor(final UUID kbAccountId, final String formUrl, final Map<String, String> queryParams) throws URISyntaxException {
        this(kbAccountId, GET, formUrl, queryParams);
    }

    public PluginHostedPaymentPageFormDescriptor(final UUID kbAccountId, final String formMethod, final String formUrl, final Map<String, String> queryParams) throws URISyntaxException {
        final URI rawUrl = new URI(formUrl);
        final String fullQueryString = QueryComputer.URL_ENCODING_ENABLED_QUERY_COMPUTER.computeFullQueryString(rawUrl.getQuery(), queryParams);
        final String fullUrl = URIUtils.buildURI(rawUrl.getScheme(), rawUrl.getUserInfo(), rawUrl.getHost(), rawUrl.getPort(), rawUrl.getAuthority(), rawUrl.getPath(), fullQueryString, rawUrl.getFragment());

        this.kbAccountId = kbAccountId;
        this.formMethod = formMethod;
        this.formUrl = fullUrl;
        this.formFields = ImmutableList.<PluginProperty>of();
        this.properties = ImmutableList.<PluginProperty>of();
    }

    @Override
    public UUID getKbAccountId() {
        return kbAccountId;
    }

    @Override
    public String getFormMethod() {
        return formMethod;
    }

    @Override
    public String getFormUrl() {
        return formUrl;
    }

    @Override
    public List<PluginProperty> getFormFields() {
        return formFields;
    }

    @Override
    public List<PluginProperty> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PluginHostedPaymentPageFormDescriptor{");
        sb.append("kbAccountId=").append(kbAccountId);
        sb.append(", formMethod='").append(formMethod).append('\'');
        sb.append(", formUrl='").append(formUrl).append('\'');
        sb.append(", formFields=").append(formFields);
        sb.append(", properties=").append(properties);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final PluginHostedPaymentPageFormDescriptor that = (PluginHostedPaymentPageFormDescriptor) o;

        if (formFields != null ? !formFields.equals(that.formFields) : that.formFields != null) {
            return false;
        }
        if (formMethod != null ? !formMethod.equals(that.formMethod) : that.formMethod != null) {
            return false;
        }
        if (formUrl != null ? !formUrl.equals(that.formUrl) : that.formUrl != null) {
            return false;
        }
        if (kbAccountId != null ? !kbAccountId.equals(that.kbAccountId) : that.kbAccountId != null) {
            return false;
        }
        if (properties != null ? !properties.equals(that.properties) : that.properties != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = kbAccountId != null ? kbAccountId.hashCode() : 0;
        result = 31 * result + (formMethod != null ? formMethod.hashCode() : 0);
        result = 31 * result + (formUrl != null ? formUrl.hashCode() : 0);
        result = 31 * result + (formFields != null ? formFields.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }
}
