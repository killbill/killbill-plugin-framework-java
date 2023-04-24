/*
 *  Generated by https://github.com/killbill/api-pojos. Do not edit!
 *
 *  Copyright 2022-2022 The Billing Project, LLC
 *
 *  The Billing Project licenses this file to you under the Apache License,
 *  version 2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at:
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 *  License for the specific language governing permissions and limitations
 *  under the License.
 */

package org.killbill.billing.invoice.plugin.api.boilerplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import java.io.IOException;
import org.killbill.billing.invoice.plugin.api.PriorInvoiceResult;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(groups = { "fast" })
public class PriorInvoiceResultImpTest {
    @Test
    public void anInstanceShouldBeEqualToItself()
    {
      PriorInvoiceResultImp a = new PriorInvoiceResultImp.Builder<>().build();
      Assert.assertTrue(a.equals(a));
    }
    @Test
    public void anInstanceShouldBeEqualToItsCopy()
    {
      PriorInvoiceResultImp a = new PriorInvoiceResultImp.Builder<>().build();
      PriorInvoiceResultImp b = new PriorInvoiceResultImp(a);

      Assert.assertTrue(a.equals(b));
    }
    @Test
    public void twoNewInstancesShouldBeEqual()
    {
      PriorInvoiceResultImp a = new PriorInvoiceResultImp.Builder<>().build();
      PriorInvoiceResultImp b = new PriorInvoiceResultImp.Builder<>().build();

      Assert.assertTrue(a.equals( b));
    }
    @Test
    public void twoNewInstancesHashcodeShouldBeEqual()
    {
      PriorInvoiceResultImp a =  new PriorInvoiceResultImp.Builder<>().build();
      PriorInvoiceResultImp b =  new PriorInvoiceResultImp.Builder<>().build();

      Assert.assertTrue(a.hashCode() == b.hashCode());
    }
    @Test
    public void twoNewInstancesStringShouldBeEqual()
    {
      PriorInvoiceResultImp a =  new PriorInvoiceResultImp.Builder<>().build();
      PriorInvoiceResultImp b =  new PriorInvoiceResultImp.Builder<>().build();

      Assert.assertTrue(a.toString().equals(b.toString()));
    }
    @Test
    public void callIssers()
    {
      PriorInvoiceResultImp a =  new PriorInvoiceResultImp.Builder<>().build();

      a.isAborted();
    }
    @Test
    public void callGetters()
    {
      PriorInvoiceResultImp a =  new PriorInvoiceResultImp.Builder<>().build();

      a.getAdjustedPluginProperties();
      a.getRescheduleDate();
    }
    @Test
    public void jsonRoundtrip()
      throws IOException,
        JsonParseException,
        JsonProcessingException,
        JsonMappingException
    {
      ObjectMapper mapper = new ObjectMapper();
      mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
      mapper.registerModule(new JodaModule());
      mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
      mapper.findAndRegisterModules();

      PriorInvoiceResultImp a =  new PriorInvoiceResultImp.Builder<>().build();
      String s =  mapper.writeValueAsString(a);;
      PriorInvoiceResult b = mapper.readValue(s, PriorInvoiceResult.class);

      Assert.assertTrue(a.equals( b));
    }
}
