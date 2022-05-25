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

package org.killbill.billing.plugin.api.core;

import java.util.Locale;
import java.util.UUID;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import org.killbill.billing.account.api.AccountData;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.account.api.boilerplate.AccountDataImp;

@JsonDeserialize( builder = PluginAccountData.Builder.class )
public class PluginAccountData extends AccountDataImp {

    public PluginAccountData(final String externalKey) {
        this(externalKey, Currency.USD, DateTimeZone.UTC, Locale.US.toString(), "US");
    }

    public PluginAccountData(final String externalKey,
            final Currency currency,
            final DateTimeZone timeZone,
            final String locale,
            final String country) {
        this(externalKey,
                null,
                null,
                null,
                currency,
                null,
                null,
                null,
                null,
                null,
                timeZone,
                locale,
                null,
                null,
                null,
                null,
                null,
                country,
                null,
                null,
                null,
                null,
                null);
    }

    public PluginAccountData(final String externalKey,
            final String email,
            final String name,
            final Integer firstNameLength,
            final Currency currency,
            final UUID parentAccountId,
            final Boolean isPaymentDelegatedToParent,
            final Integer billCycleDayLocal,
            final UUID paymentMethodId,
            final DateTime referenceTime,
            final DateTimeZone timeZone,
            final String locale,
            final String address1,
            final String address2,
            final String companyName,
            final String city,
            final String stateOrProvince,
            final String country,
            final String postalCode,
            final String phone,
            final String notes,
            final Boolean isMigrated,
            final Boolean isNotifiedForInvoices) {

                this(new Builder<>()
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
                        .validate());
    }

    protected PluginAccountData(final PluginAccountData.Builder<?> builder) {
        super(builder);
    }

    public PluginAccountData(final PluginAccountData that) {
        super(that);
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PluginAccountData.Builder<T>> 
        extends AccountDataImp.Builder<T> {

        public Builder() {
            this.withCurrency(Currency.USD);
            this.withTimeZone(DateTimeZone.UTC);
            this.withLocale(Locale.US.toString());
            this.withCountry("US");
        }

        public Builder(final Builder that) {
            super(that);
        }

        @Override
        public Builder validate() {
            return this;
        }

        @Override
        public PluginAccountData build() {
            return new PluginAccountData(this.validate());
        }
    }
}
