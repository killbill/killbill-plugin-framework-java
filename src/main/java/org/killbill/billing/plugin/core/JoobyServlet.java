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

package org.killbill.billing.plugin.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jooby.Sse;
import org.jooby.servlet.ServletServletRequest;
import org.jooby.servlet.ServletServletResponse;
import org.jooby.servlet.ServletUpgrade;
import org.jooby.spi.HttpHandler;
import org.jooby.spi.NativeResponse;
import org.killbill.billing.plugin.core.resources.ServletSse;
import org.killbill.billing.plugin.core.resources.jooby.PluginApp;

import com.typesafe.config.Config;

public class JoobyServlet extends PluginServlet {

    private final PluginApp app;

    private final HttpHandler dispatcher;
    private final String tmpdir;

    public JoobyServlet(final PluginApp app) {
        this.app = app;
        this.app.start();

        dispatcher = app.require(HttpHandler.class);
        tmpdir = app.require(Config.class).getString("application.tmpdir");
    }

    @Override
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final ServletServletRequest request = new ServletServletRequest(req, tmpdir).with(new ServletSseUpgrade(req));
        final NativeResponse response = new ServletServletResponse(req, resp);

        try {
            dispatcher.handle(request, response);
        } catch (final Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        app.stop();
    }

    public static class ServletSseUpgrade implements ServletUpgrade {

        private final ServletRequest req;

        public ServletSseUpgrade(final ServletRequest req) {
            this.req = req;
        }

        @Override
        public <T> T upgrade(final Class<T> type) {
            if (type == Sse.class) {
                //noinspection unchecked
                return (T) new ServletSse(req);
            }
            throw new UnsupportedOperationException("#upgrade not yet supported: " + type);
        }
    }
}
