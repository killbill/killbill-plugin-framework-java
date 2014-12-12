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

public class URIUtils {

    public static String buildURI(final String scheme,
                                  final String userInfo,
                                  final String host,
                                  final int port,
                                  final String authority,
                                  final String path,
                                  final String query,
                                  final String fragment) {
        final StringBuffer sb = new StringBuffer();
        if (scheme != null) {
            sb.append(scheme);
            sb.append(':');
        }
        if (host != null) {
            sb.append("//");
            if (userInfo != null) {
                sb.append(userInfo);
                sb.append('@');
            }
            final boolean needBrackets = ((host.indexOf(':') >= 0)
                                          && !host.startsWith("[")
                                          && !host.endsWith("]"));
            if (needBrackets) {
                sb.append('[');
            }
            sb.append(host);
            if (needBrackets) {
                sb.append(']');
            }
            if (port != -1) {
                sb.append(':');
                sb.append(port);
            }
        } else if (authority != null) {
            sb.append("//");
            sb.append(authority);
        }
        if (path != null) {
            sb.append(path);
        }
        if (query != null) {
            sb.append('?');
            sb.append(query);
        }
        if (fragment != null) {
            sb.append('#');
            sb.append(fragment);
        }
        return sb.toString();
    }
}
