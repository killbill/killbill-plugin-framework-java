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

package org.killbill.billing.plugin.util.http;

import java.util.Map;

import com.google.common.base.Strings;

public enum QueryComputer {

    URL_ENCODING_ENABLED_QUERY_COMPUTER {
        private void encodeAndAppendQueryParam(final StringBuilder sb, final CharSequence name, final CharSequence value) {
            UTF8UrlEncoder.appendEncoded(sb, name);
            if (value != null) {
                sb.append('=');
                UTF8UrlEncoder.appendEncoded(sb, value);
            }
            sb.append('&');
        }

        private void encodeAndAppendQueryParams(final StringBuilder sb, final Map<String, String> queryParams) {
            for (final Map.Entry<String, String> param : queryParams.entrySet()) {
                encodeAndAppendQueryParam(sb, param.getKey(), param.getValue());
            }
        }

        // FIXME this could be improved: remove split
        private void encodeAndAppendQuery(final StringBuilder sb, final String query) {
            int pos;
            for (final String queryParamString : query.split("&")) {
                pos = queryParamString.indexOf('=');
                if (pos <= 0) {
                    final CharSequence decodedName = UTF8UrlDecoder.decode(queryParamString);
                    encodeAndAppendQueryParam(sb, decodedName, null);
                } else {
                    final CharSequence decodedName = UTF8UrlDecoder.decode(queryParamString, 0, pos);
                    final int valueStart = pos + 1;
                    final CharSequence decodedValue = UTF8UrlDecoder.decode(queryParamString, valueStart, queryParamString.length() - valueStart);
                    encodeAndAppendQueryParam(sb, decodedName, decodedValue);
                }
            }
        }

        protected final String withQueryWithParams(final String query, final Map<String, String> queryParams) {
            // concatenate encoded query + encoded query params
            final StringBuilder sb = new StringBuilder(query.length() + queryParams.size() * 16);
            encodeAndAppendQuery(sb, query);
            encodeAndAppendQueryParams(sb, queryParams);
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }

        protected final String withQueryWithoutParams(final String query) {
            // encode query
            final StringBuilder sb = new StringBuilder(query.length() + 6);
            encodeAndAppendQuery(sb, query);
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }

        protected final String withoutQueryWithParams(final Map<String, String> queryParams) {
            // concatenate encoded query params
            final StringBuilder sb = new StringBuilder(queryParams.size() * 16);
            encodeAndAppendQueryParams(sb, queryParams);
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }
    },

    URL_ENCODING_DISABLED_QUERY_COMPUTER {
        private void appendRawQueryParam(final StringBuilder sb, final String name, final String value) {
            sb.append(name);
            if (value != null) {
                sb.append('=').append(value);
            }
            sb.append('&');
        }

        private void appendRawQueryParams(final StringBuilder sb, final Map<String, String> queryParams) {
            for (final Map.Entry<String, String> param : queryParams.entrySet()) {
                appendRawQueryParam(sb, param.getKey(), param.getValue());
            }
        }

        protected final String withQueryWithParams(final String query, final Map<String, String> queryParams) {
            // concatenate raw query + raw query params
            final StringBuilder sb = new StringBuilder(query.length() + queryParams.size() * 16);
            sb.append(query);
            appendRawQueryParams(sb, queryParams);
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }

        protected final String withQueryWithoutParams(final String query) {
            // return raw query as is
            return query;
        }

        protected final String withoutQueryWithParams(final Map<String, String> queryParams) {
            // concatenate raw queryParams
            final StringBuilder sb = new StringBuilder(queryParams.size() * 16);
            appendRawQueryParams(sb, queryParams);
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }
    };

    public static QueryComputer queryComputer(final boolean disableUrlEncoding) {
        return disableUrlEncoding ? URL_ENCODING_DISABLED_QUERY_COMPUTER : URL_ENCODING_ENABLED_QUERY_COMPUTER;
    }

    protected abstract String withQueryWithParams(final String query, final Map<String, String> queryParams);

    protected abstract String withQueryWithoutParams(final String query);

    protected abstract String withoutQueryWithParams(final Map<String, String> queryParams);

    private String withQuery(final String query, final Map<String, String> queryParams) {
        return queryParams != null && !queryParams.isEmpty() ? withQueryWithParams(query, queryParams) : withQueryWithoutParams(query);
    }

    private String withoutQuery(final Map<String, String> queryParams) {
        return queryParams != null && !queryParams.isEmpty() ? withoutQueryWithParams(queryParams) : null;
    }

    public final String computeFullQueryString(final String query, final Map<String, String> queryParams) {
        return !Strings.isNullOrEmpty(query) ? withQuery(query, queryParams) : withoutQuery(queryParams);
    }
}
