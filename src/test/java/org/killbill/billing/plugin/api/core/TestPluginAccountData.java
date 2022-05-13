/*
 * Copyright 2022-2022 The Billing Project, LLC
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

package org.killbill.billing.plugin.api.core;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.UUID;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import org.killbill.billing.catalog.api.Currency;

@Test(groups = { "fast" })
public class TestPluginAccountData {

    final private String address1 = "TestAddress1'";
    final private String address2 = "TestAddress2";
    final private Integer billCycleDayLocal = 1;
    final private String city = "TestCity";
    final private String companyName = "TestCompanyName";
    final private String country = "US";
    final private Currency currency = Currency.USD;
    final private String email = "Tester@nowhere.com";
    final private String externalKey = "TestExternalKey";
    final private Integer firstNameLength = 1;
    final private Boolean isMigrated = false;
    final private Boolean isPaymentDelegatedToParent = false;
    final private String locale=  Locale.US.toString();
    final private String name = "TestName";
    final private String notes = "TestNote";
    final private UUID parentAccountId =  UUID.fromString("00000000-0000-0000-0000-000000000001");
    final private UUID paymentMethodId =  UUID.fromString("00000000-0000-0000-0000-000000000002");
    final private String phone = "111-111-1111";
    final private String postalCode = "54321";
    final private DateTime referenceTime =  new DateTime("2011-11-11T11:11");
    final private String stateOrProvince = "TestProvince";
    final private DateTimeZone timeZone =  DateTimeZone.UTC;

    @Test
    void builderIsEquivalentToConstructor() {

        PluginAccountData a = new PluginAccountData.Builder<>()
            .withExternalKey(externalKey)
            .withEmail(email)
            .withName(name)
            .withFirstNameLength(firstNameLength)
            .withCurrency(currency)
            .withParentAccountId(parentAccountId)
            .withIsPaymentDelegatedToParent(isPaymentDelegatedToParent)
            .withBillCycleDayLocal(billCycleDayLocal)
            .withPaymentMethodId(paymentMethodId)
            .withReferenceTime(referenceTime)
            .withTimeZone(timeZone)
            .withLocale(locale)
            .withAddress1(address1)
            .withAddress2(address2)
            .withCompanyName(companyName)
            .withCity(city)
            .withStateOrProvince(stateOrProvince)
            .withPostalCode(postalCode)
            .withCountry(country)
            .withPhone(phone)
            .withNotes(notes)
            .withIsMigrated(isMigrated)
            .build();

        PluginAccountData b = new PluginAccountData(externalKey,
                email,
                name,
                firstNameLength,
                currency,
                parentAccountId,
                isPaymentDelegatedToParent,
                billCycleDayLocal,
                paymentMethodId,
                referenceTime,
                timeZone,
                locale,
                address1,
                address2,
                companyName,
                city,
                stateOrProvince,
                country,
                postalCode,
                phone,
                notes,
                isMigrated,
                false) ;

        Assert.assertTrue(a.equals(b));
    }

    @Test
    void differentInstances() {

     PluginAccountData.Builder builder = new PluginAccountData.Builder<>()
            .withExternalKey(externalKey)
            .withEmail(email)
            .withName(name)
            .withFirstNameLength(firstNameLength)
            .withCurrency(currency)
            .withParentAccountId(parentAccountId)
            .withIsPaymentDelegatedToParent(isPaymentDelegatedToParent)
            .withBillCycleDayLocal(billCycleDayLocal)
            .withPaymentMethodId(paymentMethodId)
            .withReferenceTime(referenceTime)
            .withTimeZone(timeZone)
            .withLocale(locale)
            .withAddress1(address1)
            .withAddress2(address2)
            .withCompanyName(companyName)
            .withCity(city)
            .withStateOrProvince(stateOrProvince)
            .withPostalCode(postalCode)
            .withCountry(country)
            .withPhone(phone)
            .withNotes(notes)
            .withIsMigrated(isMigrated);

        Assert.assertNotEquals(builder.build(), builder.withName("DifferentTestName").build());
    }

    @Test
    void callAllGetters() {

        PluginAccountData a = new PluginAccountData.Builder<>()
            .withExternalKey(externalKey)
            .withEmail(email)
            .withName(name)
            .withFirstNameLength(firstNameLength)
            .withCurrency(currency)
            .withParentAccountId(parentAccountId)
            .withIsPaymentDelegatedToParent(isPaymentDelegatedToParent)
            .withBillCycleDayLocal(billCycleDayLocal)
            .withPaymentMethodId(paymentMethodId)
            .withReferenceTime(referenceTime)
            .withTimeZone(timeZone)
            .withLocale(locale)
            .withAddress1(address1)
            .withAddress2(address2)
            .withCompanyName(companyName)
            .withCity(city)
            .withStateOrProvince(stateOrProvince)
            .withPostalCode(postalCode)
            .withCountry(country)
            .withPhone(phone)
            .withNotes(notes)
            .withIsMigrated(isMigrated)
            .build();

        Assert.assertEquals(a.getExternalKey(), externalKey);
        Assert.assertEquals(a.getEmail(), email);
        Assert.assertEquals(a.getName(), name);
        Assert.assertEquals(a.getFirstNameLength(), firstNameLength);
        Assert.assertEquals(a.getCurrency(), currency);
        Assert.assertEquals(a.getParentAccountId(), parentAccountId);
        Assert.assertEquals(a.isPaymentDelegatedToParent(), isPaymentDelegatedToParent);
        Assert.assertEquals(a.getBillCycleDayLocal(), billCycleDayLocal);
        Assert.assertEquals(a.getPaymentMethodId(), paymentMethodId);
        Assert.assertEquals(a.getReferenceTime(), referenceTime);
        Assert.assertEquals(a.getTimeZone(), timeZone);
        Assert.assertEquals(a.getLocale(), locale);
        Assert.assertEquals(a.getAddress1(), address1);
        Assert.assertEquals(a.getAddress2(), address2);
        Assert.assertEquals(a.getCompanyName(), companyName);
        Assert.assertEquals(a.getCity(), city);
        Assert.assertEquals(a.getStateOrProvince(), stateOrProvince);
        Assert.assertEquals(a.getPostalCode(), postalCode);
        Assert.assertEquals(a.getCountry(), country);
        Assert.assertEquals(a.getPhone(), phone);
        Assert.assertEquals(a.getNotes(), notes);
        Assert.assertEquals(a.isMigrated(), isMigrated);
    }

    @Test 
    void roundTripJson() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
        mapper.registerModule(new JodaModule());
        mapper.findAndRegisterModules();

        PluginAccountData a = new PluginAccountData.Builder<>()
            .withExternalKey(externalKey)
            .withEmail(email)
            .withName(name)
            .withFirstNameLength(firstNameLength)
            .withCurrency(currency)
            .withParentAccountId(parentAccountId)
            .withIsPaymentDelegatedToParent(isPaymentDelegatedToParent)
            .withBillCycleDayLocal(billCycleDayLocal)
            .withPaymentMethodId(paymentMethodId)
            .withReferenceTime(referenceTime)
            .withTimeZone(timeZone)
            .withLocale(locale)
            .withAddress1(address1)
            .withAddress2(address2)
            .withCompanyName(companyName)
            .withCity(city)
            .withStateOrProvince(stateOrProvince)
            .withPostalCode(postalCode)
            .withCountry(country)
            .withPhone(phone)
            .withNotes(notes)
            .withIsMigrated(isMigrated)
            .build();

        String json =  mapper.writeValueAsString(a);;
        PluginAccountData b = mapper.readValue(json, PluginAccountData.class);

        Assert.assertTrue(a.equals(b));
    }
}
