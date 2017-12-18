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

package org.killbill.billing.plugin.core.resources;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.Callable;

import org.jooby.Result;
import org.jooby.Results;
import org.jooby.Status;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillAPI;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillClock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.BaseEncoding;

public class BaseResource {

    private static final Logger logger = LoggerFactory.getLogger(BaseResource.class);

    protected final OSGIKillbillAPI osgiKillbillAPI;
    protected final OSGIKillbillClock osgiKillbillClock;

    public BaseResource(final OSGIKillbillAPI osgiKillbillAPI, final OSGIKillbillClock osgiKillbillClock) {
        this.osgiKillbillAPI = osgiKillbillAPI;
        this.osgiKillbillClock = osgiKillbillClock;
    }

    protected Result invalidRequest(final String message) {
        return Results.with(new ExceptionResponse(message), Status.BAD_REQUEST);
    }

    protected Result withExceptionHandling(final Callable<Result> callable) {
        try {
            return callable.call();
        } catch (final Exception exception) {
            logger.warn("Unable to process request", exception);
            return Results.with(new ExceptionResponse(exception, true), Status.SERVER_ERROR);

        }
    }

    protected void login(final String authHeader) throws UnsupportedEncodingException {
        if (authHeader == null) {
            return;
        }

        final String[] authHeaderChunks = authHeader.split(" ");
        if (authHeaderChunks.length < 2) {
            return;
        }

        final String credentials = new String(BaseEncoding.base64().decode(authHeaderChunks[1]), "UTF-8");
        final int p = credentials.indexOf(":");
        if (p == -1) {
            return;
        }

        final String login = credentials.substring(0, p).trim();
        final String password = credentials.substring(p + 1).trim();
        osgiKillbillAPI.getSecurityApi().login(login, password);
    }
}
