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

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUTF8UrlEncoder {

    @Test(groups = "fast")
    public void testRoundTrip() throws UnsupportedEncodingException {
        verifyEncoding("abcdefghijklmnopqrstuvwxyz0123456789", "abcdefghijklmnopqrstuvwxyz0123456789");
        verifyEncoding("ïłéà", "%C3%AF%C5%82%C3%A9%C3%A0");
        verifyEncoding("http://ja.wikipedia.org/wiki/メインページ", "http%3A%2F%2Fja.wikipedia.org%2Fwiki%2F%E3%83%A1%E3%82%A4%E3%83%B3%E3%83%9A%E3%83%BC%E3%82%B8");
        verifyEncoding("http://www.someurl.com/path name/?query=par am#he llo", "http%3A%2F%2Fwww.someurl.com%2Fpath%20name%2F%3Fquery%3Dpar%20am%23he%20llo");
        verifyEncoding("http://example.com/a & b?index", "http%3A%2F%2Fexample.com%2Fa%20%26%20b%3Findex");
        verifyEncoding("http://localhost/a/b c+é", "http%3A%2F%2Flocalhost%2Fa%2Fb%20c%2B%C3%A9");
    }

    private void verifyEncoding(final String input, final String expectedEncoded) throws UnsupportedEncodingException {
        final String actualEncoded = UTF8UrlEncoder.encode(input);
        Assert.assertEquals(actualEncoded, expectedEncoded);

        final String actualDecoded = UTF8UrlDecoder.decode(actualEncoded).toString();
        Assert.assertEquals(actualDecoded, input);
    }
}
