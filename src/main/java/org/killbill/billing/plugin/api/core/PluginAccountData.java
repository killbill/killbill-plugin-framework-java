/*
 * Copyright 2014-2017 Groupon, Inc
 * Copyright 2014-2017 The Billing Project, LLC
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

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.killbill.billing.account.api.AccountData;
import org.killbill.billing.catalog.api.Currency;

public class PluginAccountData implements AccountData {

    protected final String externalKey;
    protected final String email;
    protected final String name;
    protected final Integer firstNameLength;
    protected final Currency currency;
    protected final UUID parentAccountId;
    protected final Boolean isPaymentDelegatedToParent;
    protected final Integer billCycleDayLocal;
    protected final UUID paymentMethodId;
    protected final DateTime referenceTime;
    protected final DateTimeZone timeZone;
    protected final String locale;
    protected final String address1;
    protected final String address2;
    protected final String companyName;
    protected final String city;
    protected final String stateOrProvince;
    protected final String country;
    protected final String postalCode;
    protected final String phone;
    protected final String notes;
    protected final Boolean isMigrated;
    protected final Boolean isNotifiedForInvoices;

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
        this.externalKey = externalKey;
        this.email = email;
        this.name = name;
        this.firstNameLength = firstNameLength;
        this.currency = currency;
        this.parentAccountId = parentAccountId;
        this.isPaymentDelegatedToParent = isPaymentDelegatedToParent;
        this.billCycleDayLocal = billCycleDayLocal;
        this.paymentMethodId = paymentMethodId;
        this.referenceTime = referenceTime;
        this.timeZone = timeZone;
        this.locale = locale;
        this.address1 = address1;
        this.address2 = address2;
        this.companyName = companyName;
        this.city = city;
        this.stateOrProvince = stateOrProvince;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.notes = notes;
        this.isMigrated = isMigrated;
        this.isNotifiedForInvoices = isNotifiedForInvoices;
    }

    @Override
    public String getExternalKey() {
        return externalKey;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Integer getFirstNameLength() {
        return firstNameLength;
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    @Override
    public UUID getParentAccountId() {
        return parentAccountId;
    }

    @Override
    public Boolean isPaymentDelegatedToParent() {
        return isPaymentDelegatedToParent;
    }

    @Override
    public Integer getBillCycleDayLocal() {
        return billCycleDayLocal;
    }

    @Override
    public UUID getPaymentMethodId() {
        return paymentMethodId;
    }

    @Override
    public DateTime getReferenceTime() {
        return referenceTime;
    }

    @Override
    public DateTimeZone getTimeZone() {
        return timeZone;
    }

    @Override
    public String getLocale() {
        return locale;
    }

    @Override
    public String getAddress1() {
        return address1;
    }

    @Override
    public String getAddress2() {
        return address2;
    }

    @Override
    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getStateOrProvince() {
        return stateOrProvince;
    }

    @Override
    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public Boolean isMigrated() {
        return isMigrated;
    }

    @Override
    public Boolean isNotifiedForInvoices() {
        return isNotifiedForInvoices;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PluginAccountData{");
        sb.append("externalKey='").append(externalKey).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", firstNameLength=").append(firstNameLength);
        sb.append(", currency=").append(currency);
        sb.append(", parentAccountId=").append(parentAccountId);
        sb.append(", isPaymentDelegatedToParent=").append(isPaymentDelegatedToParent);
        sb.append(", billCycleDayLocal=").append(billCycleDayLocal);
        sb.append(", paymentMethodId=").append(paymentMethodId);
        sb.append(", timeZone=").append(timeZone);
        sb.append(", locale='").append(locale).append('\'');
        sb.append(", address1='").append(address1).append('\'');
        sb.append(", address2='").append(address2).append('\'');
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", stateOrProvince='").append(stateOrProvince).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", postalCode='").append(postalCode).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", notes='").append(notes).append('\'');
        sb.append(", isMigrated=").append(isMigrated);
        sb.append(", isNotifiedForInvoices=").append(isNotifiedForInvoices);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        final PluginAccountData that = (PluginAccountData) o;

        if (billCycleDayLocal != null ? !billCycleDayLocal.equals(that.billCycleDayLocal) : that.billCycleDayLocal != null) {
            return false;
        }
        if (address1 != null ? !address1.equals(that.address1) : that.address1 != null) {
            return false;
        }
        if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) {
            return false;
        }
        if (city != null ? !city.equals(that.city) : that.city != null) {
            return false;
        }
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) {
            return false;
        }
        if (country != null ? !country.equals(that.country) : that.country != null) {
            return false;
        }
        if (currency != that.currency) {
            return false;
        }
        if (parentAccountId != null ? !parentAccountId.equals(that.parentAccountId) : that.parentAccountId != null) {
            return false;
        }
        if (isPaymentDelegatedToParent != null ? !isPaymentDelegatedToParent.equals(that.isPaymentDelegatedToParent) : that.isPaymentDelegatedToParent != null) {
            return false;
        }
        if (email != null ? !email.equals(that.email) : that.email != null) {
            return false;
        }
        if (externalKey != null ? !externalKey.equals(that.externalKey) : that.externalKey != null) {
            return false;
        }
        if (firstNameLength != null ? !firstNameLength.equals(that.firstNameLength) : that.firstNameLength != null) {
            return false;
        }
        if (isMigrated != null ? !isMigrated.equals(that.isMigrated) : that.isMigrated != null) {
            return false;
        }
        if (isNotifiedForInvoices != null ? !isNotifiedForInvoices.equals(that.isNotifiedForInvoices) : that.isNotifiedForInvoices != null) {
            return false;
        }
        if (locale != null ? !locale.equals(that.locale) : that.locale != null) {
            return false;
        }
        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        if (paymentMethodId != null ? !paymentMethodId.equals(that.paymentMethodId) : that.paymentMethodId != null) {
            return false;
        }
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) {
            return false;
        }
        if (postalCode != null ? !postalCode.equals(that.postalCode) : that.postalCode != null) {
            return false;
        }
        if (stateOrProvince != null ? !stateOrProvince.equals(that.stateOrProvince) : that.stateOrProvince != null) {
            return false;
        }
        if (timeZone != null ? !timeZone.equals(that.timeZone) : that.timeZone != null) {
            return false;
        }
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (externalKey != null ? externalKey.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (firstNameLength != null ? firstNameLength.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (parentAccountId != null ? parentAccountId.hashCode() : 0);
        result = 31 * result + (isPaymentDelegatedToParent != null ? isPaymentDelegatedToParent.hashCode() : 0);
        result = 31 * result + billCycleDayLocal;
        result = 31 * result + (paymentMethodId != null ? paymentMethodId.hashCode() : 0);
        result = 31 * result + (timeZone != null ? timeZone.hashCode() : 0);
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        result = 31 * result + (address1 != null ? address1.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (stateOrProvince != null ? stateOrProvince.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (isMigrated != null ? isMigrated.hashCode() : 0);
        result = 31 * result + (isNotifiedForInvoices != null ? isNotifiedForInvoices.hashCode() : 0);
        return result;
    }
}
