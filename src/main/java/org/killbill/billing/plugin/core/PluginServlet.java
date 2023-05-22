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
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.killbill.billing.tenant.api.Tenant;
import org.killbill.commons.utils.Strings;
import org.killbill.commons.utils.io.ByteStreams;
import org.killbill.commons.utils.net.HttpHeaders;

public class PluginServlet extends HttpServlet {

    protected static final DateTimeFormatter DATE_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd");

    protected static final String HDR_CREATED_BY = "X-Killbill-CreatedBy";
    protected static final String HDR_REASON = "X-Killbill-Reason";
    protected static final String HDR_COMMENT = "X-Killbill-Comment";

    protected static final String TEXT_PLAIN = "text/plain";
    protected static final String TEXT_CSV = "text/csv";
    protected static final String TEXT_HTML = "text/html";
    protected static final String APPLICATION_JSON = "application/json";
    protected static final String APPLICATION_XML = "application/xml";
    protected static final String APPLICATION_JAVASCRIPT = "application/javascript";

    protected Matcher getPathMatcher(final Pattern pattern, final HttpServletRequest req) {
        final String pathInfo = req.getPathInfo();
        final Matcher matcher = pattern.matcher(pathInfo);
        return matcher.matches() ? matcher : null;
    }

    protected LocalDate getParameterAsLocalDate(final String parameterName, final ServletRequest req) {
        final String parameter = req.getParameter(parameterName);
        return Strings.emptyToNull(parameter) != null ? DATE_FORMAT.parseLocalDate(parameter) : null;
    }

    protected String getCreatedBy(final HttpServletRequest req) {
        return Objects.requireNonNullElse(req.getHeader(HDR_CREATED_BY), req.getRemoteAddr());
    }

    protected String getReason(final HttpServletRequest req) {
        return req.getHeader(HDR_REASON);
    }

    protected String getComment(final HttpServletRequest req) {
        return Objects.requireNonNullElse(req.getHeader(HDR_COMMENT), req.getRequestURI());
    }

    protected Tenant getTenant(final ServletRequest req) {
        // Set by the TenantFilter
        return (Tenant) req.getAttribute("killbill_tenant");
    }

    protected String getRequestData(final ServletRequest req) throws IOException {
        final InputStream inputStream = req.getInputStream();
        try {
            return new String(ByteStreams.toByteArray(inputStream), StandardCharsets.UTF_8);
        } finally {
            inputStream.close();
        }
    }

    protected void setTextContentType(final ServletResponse resp) {
        resp.setContentType(TEXT_PLAIN);
    }

    protected void setCSVContentType(final ServletResponse resp) {
        resp.setContentType(TEXT_CSV);
    }

    protected void setHtmlContentType(final ServletResponse resp) {
        resp.setContentType(TEXT_HTML);
    }

    protected void setJsonContentType(final ServletResponse resp) {
        resp.setContentType(APPLICATION_JSON);
    }

    protected void setXMLContentType(final ServletResponse resp) {
        resp.setContentType(APPLICATION_XML);
    }

    protected void setJavascriptContentType(final ServletResponse resp) {
        resp.setContentType(APPLICATION_JAVASCRIPT);
    }

    protected void setContentType(final String contentType, final ServletResponse resp) {
        resp.setContentType(contentType);
    }

    protected void buildOKResponse(final byte[] data, final HttpServletResponse resp) throws IOException {
        buildResponse(HttpServletResponse.SC_OK, data, resp);
    }

    protected void buildCreatedResponse(final String location, final HttpServletResponse resp) throws IOException {
        resp.setHeader(HttpHeaders.LOCATION, location);
        buildResponse(HttpServletResponse.SC_CREATED, null, resp);
    }

    protected void buildResponse(final HttpServletResponse resp) throws IOException {
        buildResponse(HttpServletResponse.SC_NO_CONTENT, null, resp);
    }

    protected void buildResponse(final int statusCode, @Nullable final byte[] data, final HttpServletResponse resp) throws IOException {
        if (data != null) {
            resp.getOutputStream().write(data);
        }
        resp.setStatus(statusCode);
    }

    protected void buildNotFoundResponse(final String message, final HttpServletResponse resp) throws IOException {
        resp.sendError(HttpServletResponse.SC_NOT_FOUND, message);
    }

    protected void buildErrorResponse(final Throwable throwable, final HttpServletResponse resp) throws IOException {
        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, throwable.getMessage());
    }
}
