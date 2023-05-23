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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.plugin.api.boilerplate.HostedPaymentPageFormDescriptorImp;
import org.killbill.billing.plugin.util.http.QueryComputer;
import org.killbill.billing.plugin.util.http.URIUtils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize( builder = PluginHostedPaymentPageFormDescriptor.Builder.class )
public class PluginHostedPaymentPageFormDescriptor extends HostedPaymentPageFormDescriptorImp {

    public static final String GET = "GET";
    public static final String POST = "POST";

    public PluginHostedPaymentPageFormDescriptor(final UUID kbAccountId, final String formUrl) {
        this(kbAccountId, GET, formUrl, Collections.emptyList());
    }

    public PluginHostedPaymentPageFormDescriptor(final UUID kbAccountId, final String formUrl, final List<PluginProperty> formFields) {
        this(kbAccountId, POST, formUrl, formFields);
    }

    public PluginHostedPaymentPageFormDescriptor(final UUID kbAccountId, final String formMethod, final String formUrl, final List<PluginProperty> formFields) {
        this(kbAccountId, formMethod, formUrl, formFields, Collections.emptyList());
    }

    public PluginHostedPaymentPageFormDescriptor(final UUID kbAccountId, final String formUrl, final Map<String, String> queryParams) throws URISyntaxException {
        this(kbAccountId, GET, formUrl, queryParams);
    }

    public PluginHostedPaymentPageFormDescriptor(final UUID kbAccountId, final String formMethod, final String formUrl, final Map<String, String> queryParams) throws URISyntaxException {
        this(kbAccountId,formMethod, toFullUrl(formUrl, queryParams), Collections.emptyList(), Collections.emptyList());
    }

    public PluginHostedPaymentPageFormDescriptor(final UUID kbAccountId,
                                                 final String formMethod,
                                                 final String formUrl,
                                                 final List<PluginProperty> formFields,
                                                 final List<PluginProperty> properties) {

      this(new Builder<>()
        .withKbAccountId(kbAccountId)
        .withFormMethod(formMethod)
        .withFormUrl(formUrl)
        .withFormFields(formFields)
        .withProperties(properties)
        .validate());
    }

    protected PluginHostedPaymentPageFormDescriptor(final PluginHostedPaymentPageFormDescriptor.Builder<?> builder) {
        super(builder);
    }

    public PluginHostedPaymentPageFormDescriptor(final PluginHostedPaymentPageFormDescriptor that) {
        super(that);
    }

    private static String toFullUrl(final String formUrl, final Map<String, String> queryParams) throws URISyntaxException {
        final URI rawUrl = new URI(formUrl);
        final String fullQueryString = QueryComputer.URL_ENCODING_ENABLED_QUERY_COMPUTER.computeFullQueryString(rawUrl.getQuery(), queryParams);
        final String fullUrl = URIUtils.buildURI(rawUrl.getScheme(), rawUrl.getUserInfo(), rawUrl.getHost(), rawUrl.getPort(), rawUrl.getAuthority(), rawUrl.getPath(), fullQueryString, rawUrl.getFragment());
        return fullUrl;
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PluginHostedPaymentPageFormDescriptor.Builder<T>> 
        extends HostedPaymentPageFormDescriptorImp.Builder<T> {

        public Builder() {
        }

        public Builder(final Builder that) {
            super(that);
        }

        @Override
        public Builder validate() {
            return this;
        }

        @Override
        public PluginHostedPaymentPageFormDescriptor build() {
            return new PluginHostedPaymentPageFormDescriptor(this.validate());
        }
    }
}
