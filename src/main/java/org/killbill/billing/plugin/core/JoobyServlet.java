/*
 * Copyright 2014-2017 Groupon, Inc
 * Copyright 2014-2017 The Billing Project, LLC
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jooby.servlet.ServletServletRequest;
import org.jooby.servlet.ServletServletResponse;
import org.jooby.spi.HttpHandler;
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
        try {
            dispatcher.handle(new ServletServletRequest(req, tmpdir),
                              new ServletServletResponse(req, resp));
        } catch (final Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        app.stop();
    }
}
