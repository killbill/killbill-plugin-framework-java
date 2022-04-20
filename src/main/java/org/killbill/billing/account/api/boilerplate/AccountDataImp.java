/* This is generated code, edit with caution! */
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

package org.killbill.billing.account.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.killbill.billing.account.api.AccountData;
import org.killbill.billing.catalog.api.Currency;

@JsonDeserialize( builder = AccountDataImp.Builder.class )
public class AccountDataImp implements AccountData {

    private static final long serialVersionUID = 0x2C6389A98E22A198L;

    protected String address1;
    protected String address2;
    protected Integer billCycleDayLocal;
    protected String city;
    protected String companyName;
    protected String country;
    protected Currency currency;
    protected String email;
    protected String externalKey;
    protected Integer firstNameLength;
    protected Boolean isMigrated;
    protected Boolean isPaymentDelegatedToParent;
    protected String locale;
    protected String name;
    protected String notes;
    protected UUID parentAccountId;
    protected UUID paymentMethodId;
    protected String phone;
    protected String postalCode;
    protected DateTime referenceTime;
    protected String stateOrProvince;
    protected DateTimeZone timeZone;

    public AccountDataImp(final AccountDataImp that) {
        this.address1 = that.address1;
        this.address2 = that.address2;
        this.billCycleDayLocal = that.billCycleDayLocal;
        this.city = that.city;
        this.companyName = that.companyName;
        this.country = that.country;
        this.currency = that.currency;
        this.email = that.email;
        this.externalKey = that.externalKey;
        this.firstNameLength = that.firstNameLength;
        this.isMigrated = that.isMigrated;
        this.isPaymentDelegatedToParent = that.isPaymentDelegatedToParent;
        this.locale = that.locale;
        this.name = that.name;
        this.notes = that.notes;
        this.parentAccountId = that.parentAccountId;
        this.paymentMethodId = that.paymentMethodId;
        this.phone = that.phone;
        this.postalCode = that.postalCode;
        this.referenceTime = that.referenceTime;
        this.stateOrProvince = that.stateOrProvince;
        this.timeZone = that.timeZone;
    }
    protected AccountDataImp(final AccountDataImp.Builder<?> builder) {
        this.address1 = builder.address1;
        this.address2 = builder.address2;
        this.billCycleDayLocal = builder.billCycleDayLocal;
        this.city = builder.city;
        this.companyName = builder.companyName;
        this.country = builder.country;
        this.currency = builder.currency;
        this.email = builder.email;
        this.externalKey = builder.externalKey;
        this.firstNameLength = builder.firstNameLength;
        this.isMigrated = builder.isMigrated;
        this.isPaymentDelegatedToParent = builder.isPaymentDelegatedToParent;
        this.locale = builder.locale;
        this.name = builder.name;
        this.notes = builder.notes;
        this.parentAccountId = builder.parentAccountId;
        this.paymentMethodId = builder.paymentMethodId;
        this.phone = builder.phone;
        this.postalCode = builder.postalCode;
        this.referenceTime = builder.referenceTime;
        this.stateOrProvince = builder.stateOrProvince;
        this.timeZone = builder.timeZone;
    }
    protected AccountDataImp() { }
    @Override
    public String getAddress1() {
        return this.address1;
    }
    @Override
    public String getAddress2() {
        return this.address2;
    }
    @Override
    public Integer getBillCycleDayLocal() {
        return this.billCycleDayLocal;
    }
    @Override
    public String getCity() {
        return this.city;
    }
    @Override
    public String getCompanyName() {
        return this.companyName;
    }
    @Override
    public String getCountry() {
        return this.country;
    }
    @Override
    public Currency getCurrency() {
        return this.currency;
    }
    @Override
    public String getEmail() {
        return this.email;
    }
    @Override
    public String getExternalKey() {
        return this.externalKey;
    }
    @Override
    public Integer getFirstNameLength() {
        return this.firstNameLength;
    }
    @Override
    @JsonGetter("isMigrated")
    public Boolean isMigrated() {
        return this.isMigrated;
    }
    @Override
    @JsonGetter("isPaymentDelegatedToParent")
    public Boolean isPaymentDelegatedToParent() {
        return this.isPaymentDelegatedToParent;
    }
    @Override
    public String getLocale() {
        return this.locale;
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public String getNotes() {
        return this.notes;
    }
    @Override
    public UUID getParentAccountId() {
        return this.parentAccountId;
    }
    @Override
    public UUID getPaymentMethodId() {
        return this.paymentMethodId;
    }
    @Override
    public String getPhone() {
        return this.phone;
    }
    @Override
    public String getPostalCode() {
        return this.postalCode;
    }
    @Override
    public DateTime getReferenceTime() {
        return this.referenceTime;
    }
    @Override
    public String getStateOrProvince() {
        return this.stateOrProvince;
    }
    @Override
    public DateTimeZone getTimeZone() {
        return this.timeZone;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final AccountDataImp that = (AccountDataImp) o;
        if( !Objects.equals(this.address1, that.address1) ) {
            return false;
        }
        if( !Objects.equals(this.address2, that.address2) ) {
            return false;
        }
        if( !Objects.equals(this.billCycleDayLocal, that.billCycleDayLocal) ) {
            return false;
        }
        if( !Objects.equals(this.city, that.city) ) {
            return false;
        }
        if( !Objects.equals(this.companyName, that.companyName) ) {
            return false;
        }
        if( !Objects.equals(this.country, that.country) ) {
            return false;
        }
        if( !Objects.equals(this.currency, that.currency) ) {
            return false;
        }
        if( !Objects.equals(this.email, that.email) ) {
            return false;
        }
        if( !Objects.equals(this.externalKey, that.externalKey) ) {
            return false;
        }
        if( !Objects.equals(this.firstNameLength, that.firstNameLength) ) {
            return false;
        }
        if( !Objects.equals(this.isMigrated, that.isMigrated) ) {
            return false;
        }
        if( !Objects.equals(this.isPaymentDelegatedToParent, that.isPaymentDelegatedToParent) ) {
            return false;
        }
        if( !Objects.equals(this.locale, that.locale) ) {
            return false;
        }
        if( !Objects.equals(this.name, that.name) ) {
            return false;
        }
        if( !Objects.equals(this.notes, that.notes) ) {
            return false;
        }
        if( !Objects.equals(this.parentAccountId, that.parentAccountId) ) {
            return false;
        }
        if( !Objects.equals(this.paymentMethodId, that.paymentMethodId) ) {
            return false;
        }
        if( !Objects.equals(this.phone, that.phone) ) {
            return false;
        }
        if( !Objects.equals(this.postalCode, that.postalCode) ) {
            return false;
        }
        if( ( this.referenceTime != null ) ? ( 0 != this.referenceTime.compareTo(that.referenceTime) ) : ( that.referenceTime != null ) ) {
            return false;
        }
        if( !Objects.equals(this.stateOrProvince, that.stateOrProvince) ) {
            return false;
        }
        if( !Objects.equals(this.timeZone, that.timeZone) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.address1);
        result = ( 31 * result ) + Objects.hashCode(this.address2);
        result = ( 31 * result ) + Objects.hashCode(this.billCycleDayLocal);
        result = ( 31 * result ) + Objects.hashCode(this.city);
        result = ( 31 * result ) + Objects.hashCode(this.companyName);
        result = ( 31 * result ) + Objects.hashCode(this.country);
        result = ( 31 * result ) + Objects.hashCode(this.currency);
        result = ( 31 * result ) + Objects.hashCode(this.email);
        result = ( 31 * result ) + Objects.hashCode(this.externalKey);
        result = ( 31 * result ) + Objects.hashCode(this.firstNameLength);
        result = ( 31 * result ) + Objects.hashCode(this.isMigrated);
        result = ( 31 * result ) + Objects.hashCode(this.isPaymentDelegatedToParent);
        result = ( 31 * result ) + Objects.hashCode(this.locale);
        result = ( 31 * result ) + Objects.hashCode(this.name);
        result = ( 31 * result ) + Objects.hashCode(this.notes);
        result = ( 31 * result ) + Objects.hashCode(this.parentAccountId);
        result = ( 31 * result ) + Objects.hashCode(this.paymentMethodId);
        result = ( 31 * result ) + Objects.hashCode(this.phone);
        result = ( 31 * result ) + Objects.hashCode(this.postalCode);
        result = ( 31 * result ) + Objects.hashCode(this.referenceTime);
        result = ( 31 * result ) + Objects.hashCode(this.stateOrProvince);
        result = ( 31 * result ) + Objects.hashCode(this.timeZone);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("address1=");
        if( this.address1 == null ) {
            sb.append(this.address1);
        }else{
            sb.append("'").append(this.address1).append("'");
        }
        sb.append(", ");
        sb.append("address2=");
        if( this.address2 == null ) {
            sb.append(this.address2);
        }else{
            sb.append("'").append(this.address2).append("'");
        }
        sb.append(", ");
        sb.append("billCycleDayLocal=").append(this.billCycleDayLocal);
        sb.append(", ");
        sb.append("city=");
        if( this.city == null ) {
            sb.append(this.city);
        }else{
            sb.append("'").append(this.city).append("'");
        }
        sb.append(", ");
        sb.append("companyName=");
        if( this.companyName == null ) {
            sb.append(this.companyName);
        }else{
            sb.append("'").append(this.companyName).append("'");
        }
        sb.append(", ");
        sb.append("country=");
        if( this.country == null ) {
            sb.append(this.country);
        }else{
            sb.append("'").append(this.country).append("'");
        }
        sb.append(", ");
        sb.append("currency=").append(this.currency);
        sb.append(", ");
        sb.append("email=");
        if( this.email == null ) {
            sb.append(this.email);
        }else{
            sb.append("'").append(this.email).append("'");
        }
        sb.append(", ");
        sb.append("externalKey=");
        if( this.externalKey == null ) {
            sb.append(this.externalKey);
        }else{
            sb.append("'").append(this.externalKey).append("'");
        }
        sb.append(", ");
        sb.append("firstNameLength=").append(this.firstNameLength);
        sb.append(", ");
        sb.append("isMigrated=").append(this.isMigrated);
        sb.append(", ");
        sb.append("isPaymentDelegatedToParent=").append(this.isPaymentDelegatedToParent);
        sb.append(", ");
        sb.append("locale=");
        if( this.locale == null ) {
            sb.append(this.locale);
        }else{
            sb.append("'").append(this.locale).append("'");
        }
        sb.append(", ");
        sb.append("name=");
        if( this.name == null ) {
            sb.append(this.name);
        }else{
            sb.append("'").append(this.name).append("'");
        }
        sb.append(", ");
        sb.append("notes=");
        if( this.notes == null ) {
            sb.append(this.notes);
        }else{
            sb.append("'").append(this.notes).append("'");
        }
        sb.append(", ");
        sb.append("parentAccountId=").append(this.parentAccountId);
        sb.append(", ");
        sb.append("paymentMethodId=").append(this.paymentMethodId);
        sb.append(", ");
        sb.append("phone=");
        if( this.phone == null ) {
            sb.append(this.phone);
        }else{
            sb.append("'").append(this.phone).append("'");
        }
        sb.append(", ");
        sb.append("postalCode=");
        if( this.postalCode == null ) {
            sb.append(this.postalCode);
        }else{
            sb.append("'").append(this.postalCode).append("'");
        }
        sb.append(", ");
        sb.append("referenceTime=").append(this.referenceTime);
        sb.append(", ");
        sb.append("stateOrProvince=");
        if( this.stateOrProvince == null ) {
            sb.append(this.stateOrProvince);
        }else{
            sb.append("'").append(this.stateOrProvince).append("'");
        }
        sb.append(", ");
        sb.append("timeZone=").append(this.timeZone);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends AccountDataImp.Builder<T>> {

        protected String address1;
        protected String address2;
        protected Integer billCycleDayLocal;
        protected String city;
        protected String companyName;
        protected String country;
        protected Currency currency;
        protected String email;
        protected String externalKey;
        protected Integer firstNameLength;
        protected Boolean isMigrated;
        protected Boolean isPaymentDelegatedToParent;
        protected String locale;
        protected String name;
        protected String notes;
        protected UUID parentAccountId;
        protected UUID paymentMethodId;
        protected String phone;
        protected String postalCode;
        protected DateTime referenceTime;
        protected String stateOrProvince;
        protected DateTimeZone timeZone;

        public Builder() { }
        public Builder(final Builder that) {
            this.address1 = that.address1;
            this.address2 = that.address2;
            this.billCycleDayLocal = that.billCycleDayLocal;
            this.city = that.city;
            this.companyName = that.companyName;
            this.country = that.country;
            this.currency = that.currency;
            this.email = that.email;
            this.externalKey = that.externalKey;
            this.firstNameLength = that.firstNameLength;
            this.isMigrated = that.isMigrated;
            this.isPaymentDelegatedToParent = that.isPaymentDelegatedToParent;
            this.locale = that.locale;
            this.name = that.name;
            this.notes = that.notes;
            this.parentAccountId = that.parentAccountId;
            this.paymentMethodId = that.paymentMethodId;
            this.phone = that.phone;
            this.postalCode = that.postalCode;
            this.referenceTime = that.referenceTime;
            this.stateOrProvince = that.stateOrProvince;
            this.timeZone = that.timeZone;
        }
        public T withAddress1(final String address1) {
            this.address1 = address1;
            return (T) this;
        }
        public T withAddress2(final String address2) {
            this.address2 = address2;
            return (T) this;
        }
        public T withBillCycleDayLocal(final Integer billCycleDayLocal) {
            this.billCycleDayLocal = billCycleDayLocal;
            return (T) this;
        }
        public T withCity(final String city) {
            this.city = city;
            return (T) this;
        }
        public T withCompanyName(final String companyName) {
            this.companyName = companyName;
            return (T) this;
        }
        public T withCountry(final String country) {
            this.country = country;
            return (T) this;
        }
        public T withCurrency(final Currency currency) {
            this.currency = currency;
            return (T) this;
        }
        public T withEmail(final String email) {
            this.email = email;
            return (T) this;
        }
        public T withExternalKey(final String externalKey) {
            this.externalKey = externalKey;
            return (T) this;
        }
        public T withFirstNameLength(final Integer firstNameLength) {
            this.firstNameLength = firstNameLength;
            return (T) this;
        }
        public T withIsMigrated(final Boolean isMigrated) {
            this.isMigrated = isMigrated;
            return (T) this;
        }
        public T withIsPaymentDelegatedToParent(final Boolean isPaymentDelegatedToParent) {
            this.isPaymentDelegatedToParent = isPaymentDelegatedToParent;
            return (T) this;
        }
        public T withLocale(final String locale) {
            this.locale = locale;
            return (T) this;
        }
        public T withName(final String name) {
            this.name = name;
            return (T) this;
        }
        public T withNotes(final String notes) {
            this.notes = notes;
            return (T) this;
        }
        public T withParentAccountId(final UUID parentAccountId) {
            this.parentAccountId = parentAccountId;
            return (T) this;
        }
        public T withPaymentMethodId(final UUID paymentMethodId) {
            this.paymentMethodId = paymentMethodId;
            return (T) this;
        }
        public T withPhone(final String phone) {
            this.phone = phone;
            return (T) this;
        }
        public T withPostalCode(final String postalCode) {
            this.postalCode = postalCode;
            return (T) this;
        }
        public T withReferenceTime(final DateTime referenceTime) {
            this.referenceTime = referenceTime;
            return (T) this;
        }
        public T withStateOrProvince(final String stateOrProvince) {
            this.stateOrProvince = stateOrProvince;
            return (T) this;
        }
        public T withTimeZone(final DateTimeZone timeZone) {
            this.timeZone = timeZone;
            return (T) this;
        }
        public T source(final AccountData that) {
            this.address1 = that.getAddress1();
            this.address2 = that.getAddress2();
            this.billCycleDayLocal = that.getBillCycleDayLocal();
            this.city = that.getCity();
            this.companyName = that.getCompanyName();
            this.country = that.getCountry();
            this.currency = that.getCurrency();
            this.email = that.getEmail();
            this.externalKey = that.getExternalKey();
            this.firstNameLength = that.getFirstNameLength();
            this.isMigrated = that.isMigrated();
            this.isPaymentDelegatedToParent = that.isPaymentDelegatedToParent();
            this.locale = that.getLocale();
            this.name = that.getName();
            this.notes = that.getNotes();
            this.parentAccountId = that.getParentAccountId();
            this.paymentMethodId = that.getPaymentMethodId();
            this.phone = that.getPhone();
            this.postalCode = that.getPostalCode();
            this.referenceTime = that.getReferenceTime();
            this.stateOrProvince = that.getStateOrProvince();
            this.timeZone = that.getTimeZone();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public AccountDataImp build() {
            return new AccountDataImp(this.validate());
        }
    }
}
