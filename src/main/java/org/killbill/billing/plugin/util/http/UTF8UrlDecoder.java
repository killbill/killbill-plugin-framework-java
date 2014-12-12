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

public final class UTF8UrlDecoder {

    private UTF8UrlDecoder() {
    }

    private static StringBuilder initSb(final StringBuilder sb, final String s, final int i, final int offset, final int length) {
        if (sb != null) {
            return sb;
        } else {
            final int initialSbLength = length > 500 ? length / 2 : length;
            return new StringBuilder(initialSbLength).append(s, offset, i);
        }
    }

    private static int hexaDigit(final char c) {
        return Character.digit(c, 16);
    }

    public static CharSequence decode(final String s) {
        return decode(s, 0, s.length());
    }

    public static CharSequence decode(final String s, final int offset, final int length) {

        StringBuilder sb = null;
        int i = offset;
        final int end = length + offset;

        while (i < end) {
            final char c = s.charAt(i);
            if (c == '+') {
                sb = initSb(sb, s, i, offset, length);
                sb.append(' ');
                i++;

            } else if (c == '%') {
                if (end - i < 3) // We expect 3 chars. 0 based i vs. 1 based length!
                {
                    throw new IllegalArgumentException("UTF8UrlDecoder: Incomplete trailing escape (%) pattern");
                }

                final int x;
                final int y;
                if ((x = hexaDigit(s.charAt(i + 1))) == -1 || (y = hexaDigit(s.charAt(i + 2))) == -1) {
                    throw new IllegalArgumentException("UTF8UrlDecoder: Malformed");
                }

                sb = initSb(sb, s, i, offset, length);
                sb.append((char) (x * 16 + y));
                i += 3;
            } else {
                if (sb != null) {
                    sb.append(c);
                }
                i++;
            }
        }

        return sb != null ? sb.toString() : new StringCharSequence(s, offset, length);
    }
}
