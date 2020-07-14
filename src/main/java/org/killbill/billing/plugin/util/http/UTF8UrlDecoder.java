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

import java.io.UnsupportedEncodingException;

public final class UTF8UrlDecoder {

    private UTF8UrlDecoder() {
    }

    public static CharSequence decode(final String s) {
        return decode(s, 0, s.length());
    }

    static CharSequence decode(final String s, final int offset, final int length) {
        final int initialSbLength = length > 500 ? length / 2 : length;
        final StringBuilder sb = new StringBuilder(initialSbLength);
        int i = offset;
        final int end = length + offset;

        byte[] bytes = null;
        while (i < end) {
            char c = s.charAt(i);
            if (c == '+') {
                sb.append(' ');
                i++;
            } else if (c == '%') {
                // (numChars-i)/3 is an upper bound for the number of remaining bytes
                if (bytes == null) {
                    bytes = new byte[(end - i) / 3];
                }
                int pos = 0;

                while (i + 2 < end && c == '%') {
                    final int v = Integer.parseInt(s.substring(i + 1, i + 3), 16);
                    if (v < 0) {
                        throw new IllegalArgumentException("UTF8UrlDecoder: Illegal hex characters in escape (%) pattern - negative value");
                    }
                    bytes[pos++] = (byte) v;
                    i += 3;
                    if (i < end) {
                        c = s.charAt(i);
                    }
                }

                // A trailing, incomplete, byte encoding such as "%x" will cause an exception to be thrown
                if (i < end && c == '%') {
                    throw new IllegalArgumentException("UTF8UrlDecoder: Incomplete trailing escape (%) pattern");
                }

                try {
                    sb.append(new String(bytes, 0, pos, "UTF-8"));
                } catch (final UnsupportedEncodingException e) {
                    throw new IllegalArgumentException(e);
                }
            } else {
                sb.append(c);
                i++;
            }
        }

        return sb.toString();
    }
}
