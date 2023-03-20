/*
 * Copyright 2020-2022 Equinix, Inc
 * Copyright 2014-2022 The Billing Project, LLC
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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.net.http.HttpClient.Redirect;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class TestHttpClient {

    HttpServer server;

    @BeforeClass(groups = "slow")
    public void setUpBeforeClass() throws Exception {
        System.setProperty("jdk.httpclient.HttpClient.log", "errors,requests,headers,frames[:control:data:window:all..],content,ssl,trace,channel");

        server = HttpServer.create();
        server.bind(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        server.createContext("/test/", new HttpHandler() {
            @Override
            public void handle(final HttpExchange exchange) throws IOException {
                final byte[] bytes = exchange.getRequestBody().readAllBytes();
                exchange.sendResponseHeaders(200, bytes.length == 0 ? -1 : bytes.length);
                try (final OutputStream os = exchange.getResponseBody()) {
                    os.write(bytes);
                }
            }
        });
        server.createContext("/secure/", new HttpHandler() {
            @Override
            public void handle(final HttpExchange exchange) throws IOException {
                final List<String> authorizationHeaders = exchange.getRequestHeaders().get("Authorization");
                if (authorizationHeaders.size() == 1) {
                    final String authorization = authorizationHeaders.get(0);
                    // aladdin:opensesame
                    if ("Basic YWxhZGRpbjpvcGVuc2VzYW1l".equals(authorization)) {
                        exchange.sendResponseHeaders(200, 0);
                        return;
                    }
                }
                exchange.sendResponseHeaders(401, 0);
            }
        });
        server.createContext("/redirect/source", exchange -> {
            final byte[] body = "302 - will redirect".getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(302, body.length);
            // exchange.getResponseHeaders().add("Location", "http://" + exchange.getLocalAddress().getHostName() + ":" + exchange.getLocalAddress().getPort() + "/redirect/target");
            exchange.getResponseHeaders().add("Location", "/redirect/target");
            try (final OutputStream os = exchange.getResponseBody()) {
                os.write(body);
            }
        });
        server.createContext("/redirect/target", exchange -> {
            final byte[] body = "200 - Ok".getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(200, body.length);
            try (final OutputStream os = exchange.getResponseBody()) {
                os.write(body);
            }
        });
        server.start();
    }

    @AfterClass(groups = "slow")
    public void setUpAfterClass() throws Exception {
        if (server != null) {
            server.stop(0);
        }
    }

    @Test(groups = "slow")
    public void testAuthRequest() throws Exception {
        final MyPluginClient client = new MyPluginClient();

        final InputStream response = client.doAuth();
        Assert.assertEquals(response.available(), 0);
    }

    @Test(groups = "slow")
    public void testPOSTRequest() throws Exception {
        final MyPluginClient client = new MyPluginClient();
        final Car car = new Car();
        car.color = "blue";
        car.type = "Tesla";

        final Car newCar = client.doCall(car);
        Assert.assertEquals(newCar.color, car.color);
        Assert.assertEquals(newCar.type, car.type);
    }

    @Test(groups = "slow") // Could be fast but we've never mixed groups historically in the same file
    public void testURIBuilder() throws Exception {
        final MyPluginClient client = new MyPluginClient();
        Assert.assertEquals(client.getURI("http://127.0.0.1:8080/plugins/something", Map.of()).toString(),
                            "http://127.0.0.1:8080/plugins/something");
        Assert.assertEquals(client.getURI("http://127.0.0.1:8080/plugins/something?a=", Map.of()).toString(),
                            "http://127.0.0.1:8080/plugins/something?a=");
        Assert.assertEquals(client.getURI("http://127.0.0.1:8080/plugins/something?a=b", Map.of()).toString(),
                            "http://127.0.0.1:8080/plugins/something?a=b");
        Assert.assertEquals(client.getURI("http://127.0.0.1:8080/plugins/something", Map.of("a", "")).toString(),
                            "http://127.0.0.1:8080/plugins/something?a=");
        Assert.assertEquals(client.getURI("http://127.0.0.1:8080/plugins/something", Map.of("a", "b")).toString(),
                            "http://127.0.0.1:8080/plugins/something?a=b");
        Assert.assertEquals(client.getURI("http://127.0.0.1:8080/plugins/something?a=b", Map.of("c", "d")).toString(),
                            "http://127.0.0.1:8080/plugins/something?a=b&c=d");
        Assert.assertEquals(client.getURI("http://127.0.0.1:8080/plugins/something", Map.of("a", "with space")).toString(),
                            "http://127.0.0.1:8080/plugins/something?a=with%20space");

        // Spaces in path
        Assert.assertEquals(client.getURI("http://127.0.0.1:8080/1.0/kb/tags/search/Suspends%20payments%20until%20removed.", Map.of("a", "b")).toString(),
                            "http://127.0.0.1:8080/1.0/kb/tags/search/Suspends%20payments%20until%20removed.?a=b");
        try {
            client.getURI("http://127.0.0.1:8080/1.0/kb/tags/search/Suspends payments until removed.", Map.of());
            Assert.fail("Paths must be encoded");
        } catch (final URISyntaxException e) {
            Assert.assertNotNull(e);
        }

        // For tests stability, use TreeMap (ordering)
        Assert.assertEquals(client.getURI("http://127.0.0.1:8080/plugins/something?a=b", new TreeMap<>(Map.of("c", "d", "e", "f"))).toString(),
                            "http://127.0.0.1:8080/plugins/something?a=b&c=d&e=f");
        Assert.assertEquals(client.getURI("http://127.0.0.1:8080/plugins/something", new TreeMap<>(Map.of("Atitle", "? and the Mysterians", "Csimple", ""))).toString(),
                            "http://127.0.0.1:8080/plugins/something?Atitle=%3F%20and%20the%20Mysterians&Csimple=");
        Assert.assertEquals(client.getURI("http://127.0.0.1:8080/plugins/something", new TreeMap<>(Map.of("Atitle", "? and the Mysterians", "Bdescription", "上海+中國", "Csimple", ""))).toString(),
                            "http://127.0.0.1:8080/plugins/something?Atitle=%3F%20and%20the%20Mysterians&Bdescription=%E4%B8%8A%E6%B5%B7%2B%E4%B8%AD%E5%9C%8B&Csimple=");
    }

    @Test(groups = "slow")
    public void testNotFollowRedirect() throws Exception {
        final MyPluginClient myPluginClient = new MyPluginClient();
        //MyPluginClient should not following redirect location, and return "/redirect/source" body instead.
        Assert.assertEquals(myPluginClient.doRedirect(), "302 - will redirect");
        myPluginClient.close();
    }

    @Test(groups = "slow", enabled = false, description = "Disabled, because it never worked. It should")
    public void testFollowingRedirect() throws Exception {
        final RedirectHttpClient redirectHttpClient = new RedirectHttpClient();
        // Just to make sure that /redirect/target is actually exist.
        Assert.assertEquals(redirectHttpClient.doRedirect("/redirect/target"), "200 - Ok");

        // RedirectHttpClient override httpClientBuilder so that it follows redirects.
        Assert.assertEquals(redirectHttpClient.doRedirect("/redirect/source"), "200 - Ok");
        redirectHttpClient.close();
    }


    // Typical usage example (see Avatax plugin for instance)
    public class MyPluginClient extends HttpClient {

        public MyPluginClient() throws GeneralSecurityException {
            super("http://" + server.getAddress().getHostString() + ":" + server.getAddress().getPort(),
                  "aladdin",
                  "opensesame",
                  null,
                  null,
                  false);
        }

        public Car doCall(final Car car) throws Exception {
            return doCall(POST,
                          url + "/test/check",
                          mapper.writeValueAsString(car),
                          ImmutableMap.<String, String>of("nocache", "1"),
                          ImmutableMap.<String, String>of("X-Plugin-Client", "12345"),
                          Car.class,
                          ResponseFormat.JSON);
        }

        public InputStream doAuth() throws Exception {
            return doCall(GET,
                          url + "/secure/",
                          null,
                          ImmutableMap.<String, String>of("nocache", "1"),
                          ImmutableMap.<String, String>of("X-Plugin-Client", "12345"),
                          InputStream.class,
                          ResponseFormat.RAW);
        }

        public String doRedirect() throws Exception {
            return doCall(GET, url + "/redirect/source", null, Collections.emptyMap(), Collections.emptyMap(), String.class, ResponseFormat.TEXT);
        }
    }

    public class RedirectHttpClient extends HttpClient {

        public RedirectHttpClient() throws GeneralSecurityException {
            super("http://" + server.getAddress().getHostString() + ":" + server.getAddress().getPort(),
                  "aladdin",
                  "opensesame",
                  null,
                  null,
                  false);
        }

        @Override
        public java.net.http.HttpClient.Builder httpClientBuilder(final boolean strictSSL, final int connectTimeoutMs, final String proxyHost, final Integer proxyPort) throws GeneralSecurityException {
            return super.httpClientBuilder(strictSSL, connectTimeoutMs, proxyHost, proxyPort)
                        .followRedirects(Redirect.NORMAL);
        }

        public String doRedirect(final String path) throws Exception {
            return doCall(GET, url + path, null, Collections.emptyMap(), Collections.emptyMap(), String.class, ResponseFormat.TEXT);
        }
    }

    public static class Car {

        private String color;
        private String type;

        public String getColor() {
            return color;
        }

        public void setColor(final String color) {
            this.color = color;
        }

        public String getType() {
            return type;
        }

        public void setType(final String type) {
            this.type = type;
        }
    }
}