/*
 * Copyright 2014-2019 Groupon, Inc
 * Copyright 2014-2019 The Billing Project, LLC
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

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.jooby.Sse;

public class ServletSse extends Sse {

    private final AtomicBoolean completed = new AtomicBoolean(false);

    private final ServletRequest req;

    private AsyncContext asyncContext;

    public ServletSse(final ServletRequest req) {
        this.req = req;
    }

    @Override
    protected void closeInternal() {
        if (!completed.getAndSet(true)) {
            asyncContext.complete();
        }
    }

    @Override
    protected void handshake(final Runnable handler) {
        asyncContext = req.getAsyncContext();
        asyncContext.setTimeout(0);

        final HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
        response.setStatus(200);
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Connection", "keep-alive");

        asyncContext.start(handler);
    }

    @Override
    protected CompletableFuture<Optional<Object>> send(final Optional<Object> id, final byte[] data) {
        synchronized (this) {
            final CompletableFuture<Optional<Object>> promise = new CompletableFuture<>();
            try {
                final ServletResponse response = asyncContext.getResponse();
                response.getOutputStream().write(data);
                response.getOutputStream().flush();
                promise.complete(id);
            } catch (final IOException e) {
                // Client gone?
                promise.completeExceptionally(e);
                ifClose(e.getCause() instanceof IOException ? e.getCause() : e);
            }
            return promise;
        }
    }
}
