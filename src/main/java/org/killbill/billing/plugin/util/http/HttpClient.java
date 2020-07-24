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

package org.killbill.billing.plugin.util.http;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiConsumer;

import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClientConfig;
import org.asynchttpclient.HttpResponseBodyPart;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Realm;
import org.asynchttpclient.Response;
import org.asynchttpclient.proxy.ProxyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.CharStreams;
import com.google.common.net.HttpHeaders;

public class HttpClient implements Closeable {

    private static final Logger logger = LoggerFactory.getLogger(HttpClient.class);

    protected static final String APPLICATION_JSON = "application/json";
    protected static final String APPLICATION_XML = "application/xml";
    protected static final String APPLICATION_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";

    protected static final String GET = "GET";
    protected static final String POST = "POST";
    protected static final String PUT = "PUT";
    protected static final String DELETE = "DELETE";
    protected static final String HEAD = "HEAD";
    protected static final String OPTIONS = "OPTIONS";

    protected static final String USER_AGENT = "KillBill/1.0";

    protected static final ImmutableMap<String, String> DEFAULT_OPTIONS = ImmutableMap.<String, String>of();
    protected static final int DEFAULT_HTTP_TIMEOUT_SEC = 70;
    private static final int DEFAULT_HTTP_CONNECT_TIMEOUT_SEC = 5;
    private static final int DEFAULT_HTTP_READ_TIMEOUT_SEC = 60;

    protected final String username;
    protected final String password;
    protected final String url;
    protected final String proxyHost;
    protected final Integer proxyPort;
    protected final AsyncHttpClient httpClient;
    protected final ObjectMapper mapper;

    public HttpClient(final String url,
                      final String username,
                      final String password,
                      final String proxyHost,
                      final Integer proxyPort,
                      final Boolean strictSSL) throws GeneralSecurityException {
        this.url = url;
        this.username = username;
        this.password = password;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        this.httpClient = buildAsyncHttpClient(strictSSL, DEFAULT_HTTP_READ_TIMEOUT_SEC * 1000, DEFAULT_HTTP_CONNECT_TIMEOUT_SEC * 1000);
        this.mapper = createObjectMapper();
    }

    public HttpClient(final String url,
                      final String username,
                      final String password,
                      final String proxyHost,
                      final Integer proxyPort,
                      final Boolean strictSSL,
                      final int connectTimeoutMs,
                      final int readTimeoutMs) throws GeneralSecurityException {
        this.url = url;
        this.username = username;
        this.password = password;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        this.httpClient = buildAsyncHttpClient(strictSSL, readTimeoutMs, connectTimeoutMs);
        this.mapper = createObjectMapper();
    }

    private AsyncHttpClient buildAsyncHttpClient(final Boolean strictSSL, final int readTimeoutMs, final int connectTimeoutMs)
            throws GeneralSecurityException {
        final DefaultAsyncHttpClientConfig.Builder cfg = new DefaultAsyncHttpClientConfig.Builder();
        cfg.setUserAgent(USER_AGENT)
           .setConnectTimeout(connectTimeoutMs)
           .setReadTimeout(readTimeoutMs)
           .setUseInsecureTrustManager(!strictSSL);
        return new DefaultAsyncHttpClient(cfg.build());
    }

    @Override
    public void close() throws IOException {
        httpClient.close();
    }

    protected ObjectMapper createObjectMapper() {
        return JsonMapper.builder()
                         // Allow special characters
                         .enable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS)
                         // Write dates using a ISO-8601 compliant notation
                         .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                         // Tells the serializer to only include those parameters that are not null
                         .serializationInclusion(JsonInclude.Include.NON_NULL)
                         .build();
    }

    @Deprecated
    protected <T> T doCall(final String verb, final String uri, final String body, final Map<String, String> options,
                           final Class<T> clazz) throws InterruptedException, ExecutionException, TimeoutException, IOException, URISyntaxException, InvalidRequest {
        final String url = getUrl(this.url, uri);

        final BoundRequestBuilder builder = getBuilderWithHeaderAndQuery(verb, url, options);
        if (!GET.equals(verb) && !HEAD.equals(verb)) {
            if (body != null) {
                builder.setBody(body);
            }
        }

        return executeAndWait(builder, DEFAULT_HTTP_TIMEOUT_SEC, clazz, ResponseFormat.JSON);
    }

    protected String doCallAndReturnTextResponse(final String verb, final String uri, final String body,
                                                 final Map<String, String> queryParams,
                                                 final Map<String, String> headers) throws InvalidRequest,
                                                                                           InterruptedException,
                                                                                           ExecutionException,
                                                                                           IOException,
                                                                                           TimeoutException,
                                                                                           URISyntaxException {
        return doCall(verb, uri, body, queryParams, headers, String.class, ResponseFormat.TEXT);
    }

    protected <T> T doCall(final String verb, final String uri, final String body, final Map<String, String> queryParams,
                           final Map<String, String> headers, final Class<T> clazz, final ResponseFormat format)
            throws InterruptedException, ExecutionException, TimeoutException, IOException, URISyntaxException, InvalidRequest {
        final String url = getUrl(this.url, uri);

        final BoundRequestBuilder builder = getBuilderWithHeaderAndQuery(verb, url, headers, queryParams);
        if (!GET.equals(verb) && !HEAD.equals(verb)) {
            if (body != null) {
                builder.setBody(body);
            }
        }

        return executeAndWait(builder, DEFAULT_HTTP_TIMEOUT_SEC, clazz, format);
    }

    protected <T> T executeAndWait(final BoundRequestBuilder builder, final int timeoutSec,
                                   final Class<T> clazz, final ResponseFormat format) throws IOException, InterruptedException, ExecutionException, TimeoutException, InvalidRequest {
        final Response response;
        final ListenableFuture<Response> futureStatus = builder.execute(new AsyncCompletionHandler<Response>() {
            @Override
            public State onBodyPartReceived(final HttpResponseBodyPart content) throws Exception {
                // Useful to log the response body
                // Request and response headers can be printed out by enabling the DEBUG logger com.ning.http.client.providers.netty.handler
                if (logger.isDebugEnabled()) {
                    logger.debug(new String(content.getBodyPartBytes(), Charsets.UTF_8));
                }
                return super.onBodyPartReceived(content);
            }

            @Override
            public Response onCompleted(final Response response) throws Exception {
                return response;
            }
        });
        response = futureStatus.get(timeoutSec, TimeUnit.SECONDS);

        if (response != null && response.getStatusCode() == 401) {
            throw new InvalidRequest("Unauthorized request", response);
        } else if (response != null && response.getStatusCode() >= 400) {
            throw new InvalidRequest("Invalid request", response);
        } else if (response == null) {
            throw new InvalidRequest("No response");
        }

        return deserializeResponse(response, clazz, format);
    }

    protected <T> T deserializeResponse(final Response response, final Class<T> clazz, ResponseFormat format) throws IOException {
        InputStream in = null;
        try {
            in = response.getResponseBodyAsStream();
            switch (format) {
                case TEXT:
                    return (T) CharStreams.toString(new InputStreamReader(in, Charsets.UTF_8));
                default:
                    return mapper.readValue(in, clazz);
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    @Deprecated
    protected BoundRequestBuilder getBuilderWithHeaderAndQuery(final String verb, final String url, final Map<String, String> immutableOptions) {
        final BoundRequestBuilder builder = prepareBuilder(verb, url);

        final Map<String, String> options = new HashMap<String, String>(immutableOptions);

        if (options.get(HttpHeaders.ACCEPT) != null) {
            builder.addHeader(HttpHeaders.ACCEPT, options.remove(HttpHeaders.ACCEPT));
        }
        if (options.get(HttpHeaders.CONTENT_TYPE) != null) {
            builder.addHeader(HttpHeaders.CONTENT_TYPE, options.remove(HttpHeaders.CONTENT_TYPE));
        }

        for (final Entry<String, String> entry : options.entrySet()) {
            if (entry.getValue() != null) {
                builder.addQueryParam(entry.getKey(), entry.getValue());
            }
        }

        if (proxyHost != null && proxyPort != null) {
            final ProxyServer proxyServer = new ProxyServer.Builder(proxyHost, proxyPort).build();
            builder.setProxyServer(proxyServer);
        }

        return builder;
    }


    protected BoundRequestBuilder getBuilderWithHeaderAndQuery(final String verb,
                                                                               final String url,
                                                                               final Map<String, String> headers,
                                                                               final Map<String, String> queryParams) {
        final BoundRequestBuilder builder = prepareBuilder(verb, url);
        addHeadsOrParams(headers, (key, value) -> builder.addHeader(key, value));
        addHeadsOrParams(queryParams, (key, value) -> builder.addQueryParam(key, value));
        return builder;
    }

    private void addHeadsOrParams(final Map<String, String> options, final BiConsumer<String, String> consumer) {
        for (final Entry<String, String> entry : options.entrySet()) {
            consumer.accept(entry.getKey(), entry.getValue());
        }
    }

    private BoundRequestBuilder prepareBuilder(final String verb, final String url) {
        final BoundRequestBuilder builder;
        if (GET.equals(verb)) {
            builder = httpClient.prepareGet(url);
        } else if (POST.equals(verb)) {
            builder = httpClient.preparePost(url);
        } else if (PUT.equals(verb)) {
            builder = httpClient.preparePut(url);
        } else if (DELETE.equals(verb)) {
            builder = httpClient.prepareDelete(url);
        } else if (HEAD.equals(verb)) {
            builder = httpClient.prepareHead(url);
        } else if (OPTIONS.equals(verb)) {
            builder = httpClient.prepareOptions(url);
        } else {
            throw new IllegalArgumentException("Unrecognized verb: " + verb);
        }

        if (username != null || password != null) {
            final Realm.Builder realm = new Realm.Builder(username, password);
            // Unclear why it's now needed
            realm.setUsePreemptiveAuth(true);
            realm.setScheme(Realm.AuthScheme.BASIC);
            builder.setRealm(realm.build());
        }

        if (proxyHost != null && proxyPort != null) {
            final ProxyServer proxyServer = new ProxyServer.Builder(proxyHost, proxyPort).build();
            builder.setProxyServer(proxyServer);
        }

        return builder;
    }

    private String getUrl(final String location, final String uri) throws URISyntaxException {
        if (uri == null) {
            throw new URISyntaxException("(null)", "HttpClient URL misconfigured");
        }

        final URI u = new URI(uri);
        if (u.isAbsolute()) {
            return uri;
        } else {
            return String.format("%s%s", location, uri);
        }
    }
}
