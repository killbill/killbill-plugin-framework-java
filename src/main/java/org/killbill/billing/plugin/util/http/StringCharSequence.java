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

/**
 * A CharSequence String wrapper that doesn't copy the char[]
 */
public class StringCharSequence implements CharSequence {

    private final String value;
    private final int offset;
    public final int length;

    public StringCharSequence(final String value, final int offset, final int length) {
        this.value = value;
        this.offset = offset;
        this.length = length;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public char charAt(final int index) {
        return value.charAt(offset + index);
    }

    @Override
    public CharSequence subSequence(final int start, final int end) {
        final int offsetedEnd = offset + end;
        if (offsetedEnd < length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return new StringCharSequence(value, offset + start, end - start);
    }

    @Override
    public String toString() {
        return value.substring(offset, length);
    }
}
