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
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.security.GeneralSecurityException;

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
        server.start();
    }

    @AfterClass(groups = "slow")
    public void setUpAfterClass() throws Exception {
        if (server != null) {
            server.stop(0);
        }
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

    // Typical usage example (see Avatax plugin for instance)
    public class MyPluginClient extends HttpClient {

        public MyPluginClient() throws GeneralSecurityException {
            super("http://" + server.getAddress().getHostString() + ":" + server.getAddress().getPort() + "/test",
                  null,
                  null,
                  null,
                  null,
                  false);
        }

        public Car doCall(final Car car) throws Exception {
            return doCall(POST,
                          url + "/check",
                          mapper.writeValueAsString(car),
                          ImmutableMap.<String, String>of("nocache", "1"),
                          ImmutableMap.<String, String>of("X-Plugin-Client", "12345"),
                          Car.class,
                          ResponseFormat.JSON);
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