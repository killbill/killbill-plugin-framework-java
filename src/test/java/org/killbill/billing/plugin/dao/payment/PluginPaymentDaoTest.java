/*
 * Copyright 2014-2018 Groupon, Inc
 * Copyright 2014-2018 The Billing Project, LLC
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

package org.killbill.billing.plugin.dao.payment;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.joda.time.DateTime;
import org.killbill.billing.account.api.Account;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.osgi.libs.killbill.OSGIConfigPropertiesService;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillAPI;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillLogService;
import org.killbill.billing.payment.api.Payment;
import org.killbill.billing.payment.api.PaymentMethodPlugin;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.api.TransactionType;
import org.killbill.billing.payment.plugin.api.PaymentTransactionInfoPlugin;
import org.killbill.billing.plugin.TestUtils;
import org.killbill.billing.plugin.TestWithEmbeddedDBBase;
import org.killbill.billing.plugin.api.PluginProperties;
import org.killbill.billing.plugin.api.payment.PluginPaymentMethodPlugin;
import org.killbill.billing.plugin.dao.payment.gen.tables.records.TestPaymentMethodsRecord;
import org.killbill.billing.plugin.dao.payment.gen.tables.records.TestResponsesRecord;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.clock.Clock;
import org.killbill.clock.DefaultClock;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.killbill.billing.payment.plugin.api.PaymentPluginStatus.UNDEFINED;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_ADDRESS1;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_ADDRESS2;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_CC_EXPIRATION_MONTH;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_CC_EXPIRATION_YEAR;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_CC_FIRST_NAME;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_CC_ISSUE_NUMBER;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_CC_LAST_NAME;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_CC_NUMBER;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_CC_START_MONTH;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_CC_START_YEAR;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_CC_TRACK_DATA;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_CC_TYPE;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_CC_VERIFICATION_VALUE;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_CITY;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_COUNTRY;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_STATE;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_TOKEN;
import static org.killbill.billing.plugin.api.payment.PluginPaymentPluginApi.PROPERTY_ZIP;

public class PluginPaymentDaoTest extends TestWithEmbeddedDBBase {

    private TestPluginPaymentDao dao;
    private TestPaymentPluginApi api;
    private CallContext context;
    private Account account;

    @Override
    @BeforeClass(groups = "slow")
    public void setUpBeforeClass() throws Exception {
        super.setUpBeforeClass();

        this.dao = new TestPluginPaymentDao(embeddedDB.getDataSource());

        final Clock clock = new DefaultClock();

        final UUID tenantId = UUID.randomUUID();
        context = Mockito.mock(CallContext.class);
        Mockito.when(context.getTenantId()).thenReturn(tenantId);

        account = TestUtils.buildAccount(Currency.JPY, "JP");

        final OSGIKillbillAPI killbillApi = TestUtils.buildOSGIKillbillAPI(account);
        final Payment payment = TestUtils.buildPayment(account.getId(), account.getPaymentMethodId(), account.getCurrency(), killbillApi);
        final OSGIKillbillLogService logService = TestUtils.buildLogService();
        final OSGIConfigPropertiesService configPropertiesService = Mockito.mock(OSGIConfigPropertiesService.class);

        api = new TestPaymentPluginApi(killbillApi, configPropertiesService, logService, clock, dao);
        TestUtils.updateOSGIKillbillAPI(killbillApi, api);
    }

    @Test(groups = "slow")
    public void testInsertPaymentResult() throws SQLException, IOException {
        final DateTime utcNow = DateTime.now();

        final UUID kbAccountId = UUID.randomUUID();
        final UUID kbPaymentId = UUID.randomUUID();
        final UUID kbTransactionId = UUID.randomUUID();
        final TransactionType transactionType = TransactionType.AUTHORIZE;
        final BigDecimal amount = new BigDecimal("123.456");
        final Currency currency = Currency.JPY;
        final Map<String, String> additionalData = new HashMap<String, String>();
        final DateTime timestamp = utcNow.minus(utcNow.getMillisOfSecond());
        final UUID kbTenantId = UUID.randomUUID();

        additionalData.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        additionalData.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        additionalData.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        additionalData.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());

        this.dao.addResponse(kbAccountId,
                             kbPaymentId,
                             kbTransactionId,
                             transactionType,
                             amount,
                             currency,
                             additionalData,
                             timestamp,
                             kbTenantId);

        final List<TestResponsesRecord> records = this.dao.getResponses(kbPaymentId, kbTenantId);
        Assert.assertEquals(records.size(), 1, "Invalid number of records returned");

        final TestResponsesRecord record = records.get(0);
        Assert.assertEquals(record.getKbAccountId(), kbAccountId.toString(), "Wrong kbAccountId");
        Assert.assertEquals(record.getKbPaymentId(), kbPaymentId.toString(), "Wrong kbAccountId");
        Assert.assertEquals(record.getKbPaymentTransactionId(), kbTransactionId.toString(), "Wrong kbPaymentTransactionId");
        Assert.assertEquals(record.getTransactionType(), transactionType.name(), "Wrong transactionType");
        Assert.assertEquals(record.getAmount().doubleValue(), amount.doubleValue(), "Wrong amount");
        Assert.assertEquals(record.getCurrency(), currency.name(), "Wrong currency");
        Assert.assertEquals(TestUtils.buildPluginPropertiesMap(record.getAdditionalData()),
                            additionalData, "Wrong additionalData");
        Assert.assertEquals(record.getCreatedDate().getTime(), timestamp.getMillis(), "Wrong createdDate");
        Assert.assertEquals(record.getKbTenantId(), kbTenantId.toString(), "Wrong kbTenantId");

        final PaymentTransactionInfoPlugin transaction = api.buildPaymentTransactionInfoPlugin(record);
        Assert.assertEquals(transaction.getKbPaymentId(), kbPaymentId, "Wrong kbPaymentId");
        Assert.assertEquals(transaction.getKbTransactionPaymentId(), kbTransactionId, "Wrong kbTransactionPaymentId");
        Assert.assertEquals(transaction.getTransactionType(), transactionType, "Wrong transactionType");
        Assert.assertEquals(transaction.getAmount().doubleValue(), amount.doubleValue(), "Wrong amount().doubleValue");
        Assert.assertEquals(transaction.getCurrency(), currency, "Wrong currency");
        Assert.assertEquals(transaction.getStatus(), UNDEFINED, "Wrong status");
        Assert.assertEquals(transaction.getGatewayError(), null, "Wrong gatewayError");
        Assert.assertEquals(transaction.getGatewayErrorCode(), null, "Wrong gatewayErrorCode");
        Assert.assertEquals(transaction.getFirstPaymentReferenceId(), null, "Wrong firstPaymentReferenceId");
        Assert.assertEquals(transaction.getSecondPaymentReferenceId(), null, "Wrong secondPaymentReferenceId");
        Assert.assertEquals(transaction.getCreatedDate().getMillis(), timestamp.getMillis(), "Wrong createdDate().getMillis");
        Assert.assertEquals(transaction.getEffectiveDate().getMillis(), timestamp.getMillis(), "Wrong effectiveDate().getMillis");

        final List<PluginProperty> properties = transaction.getProperties();
        Assert.assertEquals(properties.size(), additionalData.size(), "Wrong properties size");
        for (final Entry<String, String> entry : additionalData.entrySet()) {
            final String value = PluginProperties.findPluginPropertyValue(entry.getKey(), properties);
            Assert.assertEquals(value, entry.getValue(), "Wrong property value for key " + entry.getKey());
        }
    }

    @Test(groups = "slow")
    public void testEmptyPaymentMethod() throws Exception {
        final PaymentMethodPlugin method = new PluginPaymentMethodPlugin(null, null, false, Collections.<PluginProperty>emptyList());

        final Iterable<PluginProperty> properties = TestUtils.toProperties(Collections.<String, String>emptyMap());

        final UUID kbPaymentMethodId = UUID.randomUUID();
        api.addPaymentMethod(account.getId(), kbPaymentMethodId, method, true, properties, context);

        final TestPaymentMethodsRecord record = dao.getPaymentMethod(kbPaymentMethodId, context.getTenantId());

        Assert.assertEquals(record.getKbPaymentMethodId(), kbPaymentMethodId.toString(), "Wrong kbPaymentMethodId");
        Assert.assertEquals(record.getKbAccountId(), account.getId().toString(), "Wrong kbAccountId");
        Assert.assertEquals(record.getKbTenantId(), context.getTenantId().toString(), "Wrong kbTenantId");
        Assert.assertEquals(record.getCcFirstName(), null, "Wrong ccFirstName");
        Assert.assertEquals(record.getCcLastName(), null, "Wrong ccLastName");
        Assert.assertEquals(record.getCcType(), null, "Wrong ccType");
        Assert.assertEquals(record.getCcExpMonth(), null, "Wrong ccExpMonth");
        Assert.assertEquals(record.getCcExpYear(), null, "Wrong ccExpYear");
        Assert.assertEquals(record.getCcNumber(), null, "Wrong ccNumber");
        Assert.assertEquals(record.getCcLast_4(), null, "Wrong ccLast_4");
        Assert.assertEquals(record.getCcStartMonth(), null, "Wrong ccStartMonth");
        Assert.assertEquals(record.getCcStartYear(), null, "Wrong ccStartYear");
        Assert.assertEquals(record.getCcIssueNumber(), null, "Wrong ccIssueNumber");
        Assert.assertEquals(record.getCcVerificationValue(), null, "Wrong ccVerificationValue");
        Assert.assertEquals(record.getCcTrackData(), null, "Wrong ccTrackData");
        Assert.assertEquals(record.getAddress1(), null, "Wrong address1");
        Assert.assertEquals(record.getAddress2(), null, "Wrong address2");
        Assert.assertEquals(record.getCity(), null, "Wrong city");
        Assert.assertEquals(record.getState(), null, "Wrong state");
        Assert.assertEquals(record.getZip(), null, "Wrong zip");
        Assert.assertEquals(record.getCountry(), null, "Wrong country");
        Assert.assertEquals(record.getToken(), null, "Wrong token");
        Assert.assertEquals(record.getAdditionalData(), null, "Wrong additionalData");
        Assert.assertEquals(record.getIsDefault().byteValue(), PluginPaymentDao.TRUE, "Wrong isDefault");
        Assert.assertEquals(record.getIsDeleted().byteValue(), PluginPaymentDao.FALSE, "Wrong isDeleted");

        Assert.assertNotNull(record.getCreatedDate(), "Wrong createdDate");
        Assert.assertNotNull(record.getUpdatedDate(), "Wrong updatedDate");

        final PaymentMethodPlugin plugin = api.buildPaymentMethodPlugin(record);
        Assert.assertEquals(plugin.getKbPaymentMethodId(), kbPaymentMethodId, "Wrong kbPaymentMethodId");
        Assert.assertEquals(plugin.getExternalPaymentMethodId(), null, "Wrong externalPaymentMethodId");
        Assert.assertEquals(plugin.isDefaultPaymentMethod(), true, "Wrong defaultPaymentMethod");
        Assert.assertNotNull(plugin.getProperties(), "Wrong properties");
        Assert.assertEquals(plugin.getProperties().size(), 0, "Wrong properties size");
    }

    @Test(groups = "slow")
    public void testNormalPaymentMethod() throws Exception {
        final List<PluginProperty> methodProperties = TestUtils.toProperties(Collections.singletonMap(PROPERTY_CC_NUMBER, "The Wrong CC number"));
        final PaymentMethodPlugin method = new PluginPaymentMethodPlugin(null, null, false, methodProperties);

        final Map<String, String> propertiesMap = new HashMap<String, String>();
        propertiesMap.put(PROPERTY_CC_FIRST_NAME, "myCcFirstName");
        propertiesMap.put(PROPERTY_CC_LAST_NAME, "myCcLAstName");
        propertiesMap.put(PROPERTY_CC_TYPE, "myCcType");
        propertiesMap.put(PROPERTY_CC_EXPIRATION_MONTH, "myCcExpMonth");
        propertiesMap.put(PROPERTY_CC_EXPIRATION_YEAR, "myCcExpYear");
        propertiesMap.put(PROPERTY_CC_NUMBER, "01234567890ABCDEF");
        propertiesMap.put(PROPERTY_CC_START_MONTH, "myCcStartMonth");
        propertiesMap.put(PROPERTY_CC_START_YEAR, "myCcStartYear");
        propertiesMap.put(PROPERTY_CC_ISSUE_NUMBER, "myCcIssueNumber");
        propertiesMap.put(PROPERTY_CC_VERIFICATION_VALUE, "myCcVerificationVal");
        propertiesMap.put(PROPERTY_CC_TRACK_DATA, "myCcTrackData");
        propertiesMap.put(PROPERTY_ADDRESS1, "myAddress1");
        propertiesMap.put(PROPERTY_ADDRESS2, "myAddress2");
        propertiesMap.put(PROPERTY_CITY, "myCity");
        propertiesMap.put(PROPERTY_STATE, "myState");
        propertiesMap.put(PROPERTY_ZIP, "myZip");
        propertiesMap.put(PROPERTY_COUNTRY, "myCountry");
        propertiesMap.put(PROPERTY_TOKEN, "myToken");

        propertiesMap.put("Foo", "myFooXX");
        propertiesMap.put("Bar", "myBarYY");
        propertiesMap.put("Baz", "myBazZZ");

        final UUID kbPaymentMethodId = UUID.randomUUID();
        api.addPaymentMethod(account.getId(), kbPaymentMethodId, method, true, TestUtils.toProperties(propertiesMap), context);

        final TestPaymentMethodsRecord record = dao.getPaymentMethod(kbPaymentMethodId, context.getTenantId());

        Assert.assertEquals(record.getKbPaymentMethodId(), kbPaymentMethodId.toString(), "Wrong kbPaymentMethodId");
        Assert.assertEquals(record.getKbAccountId(), account.getId().toString(), "Wrong kbAccountId");
        Assert.assertEquals(record.getKbTenantId(), context.getTenantId().toString(), "Wrong kbTenantId");
        Assert.assertEquals(record.getCcFirstName(), "myCcFirstName", "Wrong ccFirstName");
        Assert.assertEquals(record.getCcLastName(), "myCcLAstName", "Wrong ccLastName");
        Assert.assertEquals(record.getCcType(), "myCcType", "Wrong ccType");
        Assert.assertEquals(record.getCcExpMonth(), "myCcExpMonth", "Wrong ccExpMonth");
        Assert.assertEquals(record.getCcExpYear(), "myCcExpYear", "Wrong ccExpYear");
        Assert.assertEquals(record.getCcNumber(), "01234567890ABCDEF", "Wrong ccNumber");
        Assert.assertEquals(record.getCcLast_4(), "CDEF", "Wrong ccLast_4");
        Assert.assertEquals(record.getCcStartMonth(), "myCcStartMonth", "Wrong ccStartMonth");
        Assert.assertEquals(record.getCcStartYear(), "myCcStartYear", "Wrong ccStartYear");
        Assert.assertEquals(record.getCcIssueNumber(), "myCcIssueNumber", "Wrong ccIssueNumber");
        Assert.assertEquals(record.getCcVerificationValue(), "myCcVerificationVal", "Wrong ccVerificationValue");
        Assert.assertEquals(record.getCcTrackData(), "myCcTrackData", "Wrong ccTrackData");
        Assert.assertEquals(record.getAddress1(), "myAddress1", "Wrong address1");
        Assert.assertEquals(record.getAddress2(), "myAddress2", "Wrong address2");
        Assert.assertEquals(record.getCity(), "myCity", "Wrong city");
        Assert.assertEquals(record.getState(), "myState", "Wrong state");
        Assert.assertEquals(record.getZip(), "myZip", "Wrong zip");
        Assert.assertEquals(record.getCountry(), "myCountry", "Wrong country");
        Assert.assertEquals(record.getToken(), "myToken", "Wrong token");
        Assert.assertEquals(record.getIsDefault().byteValue(), PluginPaymentDao.TRUE, "Wrong isDefault");
        Assert.assertEquals(record.getIsDeleted().byteValue(), PluginPaymentDao.FALSE, "Wrong isDeleted");

        Assert.assertNotNull(record.getAdditionalData(), "Wrong additionalData");
        Assert.assertNotNull(record.getCreatedDate(), "Wrong createdDate");
        Assert.assertNotNull(record.getUpdatedDate(), "Wrong updatedDate");

        final PaymentMethodPlugin plugin = api.buildPaymentMethodPlugin(record);
        Assert.assertEquals(plugin.getKbPaymentMethodId(), kbPaymentMethodId, "Wrong kbPaymentMethodId");
        Assert.assertEquals(plugin.getExternalPaymentMethodId(), "myToken", "Wrong externalPaymentMethodId");
        Assert.assertEquals(plugin.isDefaultPaymentMethod(), true, "Wrong defaultPaymentMethod");
        Assert.assertNotNull(plugin.getProperties(), "Wrong properties");

        final List<PluginProperty> pluginProperties = plugin.getProperties();
        Assert.assertEquals(pluginProperties.size(), 3, "Wrong properties size");
        Assert.assertEquals(PluginProperties.getValue("Foo", null, pluginProperties), "myFooXX", "Wrong extra property Foo");
        Assert.assertEquals(PluginProperties.getValue("Bar", null, pluginProperties), "myBarYY", "Wrong extra property Bar");
        Assert.assertEquals(PluginProperties.getValue("Baz", null, pluginProperties), "myBazZZ", "Wrong extra property Baz");
    }

    @Test(groups = "slow")
    public void testSetDefaultPaymentMethod() throws Exception {
        final List<PluginProperty> methodProperties = TestUtils.toProperties(Collections.singletonMap(PROPERTY_CC_NUMBER, "The Wrong CC number"));
        final PaymentMethodPlugin account1Method1 = new PluginPaymentMethodPlugin(null, null, false, methodProperties);
        final PaymentMethodPlugin account1Method2 = new PluginPaymentMethodPlugin(null, null, false, methodProperties);
        final PaymentMethodPlugin account2Method = new PluginPaymentMethodPlugin(null, null, false, methodProperties);

        final Map<String, String> propertiesMap = new HashMap<String, String>();
        propertiesMap.put(PROPERTY_CC_FIRST_NAME, "myCcFirstName");
        propertiesMap.put(PROPERTY_CC_LAST_NAME, "myCcLAstName");
        propertiesMap.put(PROPERTY_CC_TYPE, "myCcType");
        propertiesMap.put(PROPERTY_CC_EXPIRATION_MONTH, "myCcExpMonth");
        propertiesMap.put(PROPERTY_CC_EXPIRATION_YEAR, "myCcExpYear");
        propertiesMap.put(PROPERTY_CC_NUMBER, "01234567890ABCDEF");
        propertiesMap.put(PROPERTY_CC_START_MONTH, "myCcStartMonth");
        propertiesMap.put(PROPERTY_CC_START_YEAR, "myCcStartYear");
        propertiesMap.put(PROPERTY_CC_ISSUE_NUMBER, "myCcIssueNumber");
        propertiesMap.put(PROPERTY_CC_VERIFICATION_VALUE, "myCcVerificationVal");
        propertiesMap.put(PROPERTY_CC_TRACK_DATA, "myCcTrackData");
        propertiesMap.put(PROPERTY_ADDRESS1, "myAddress1");
        propertiesMap.put(PROPERTY_ADDRESS2, "myAddress2");
        propertiesMap.put(PROPERTY_CITY, "myCity");
        propertiesMap.put(PROPERTY_STATE, "myState");
        propertiesMap.put(PROPERTY_ZIP, "myZip");
        propertiesMap.put(PROPERTY_COUNTRY, "myCountry");
        propertiesMap.put(PROPERTY_TOKEN, "myToken");

        final UUID kbPaymentMethodId1 = UUID.randomUUID();
        final UUID kbPaymentMethodId2 = UUID.randomUUID();
        final UUID kbPaymentMethodId3 = UUID.randomUUID();

        api.addPaymentMethod(account.getId(), kbPaymentMethodId1, account1Method1, true, TestUtils.toProperties(propertiesMap), context);
        api.addPaymentMethod(account.getId(), kbPaymentMethodId2, account1Method2, false, TestUtils.toProperties(propertiesMap), context);

        final Account account2 = TestUtils.buildAccount(Currency.SAR, "KSA");
        api.addPaymentMethod(account2.getId(), kbPaymentMethodId3, account2Method, true, TestUtils.toProperties(propertiesMap), context);

        dao.setDefaultPaymentMethod(account.getId(), kbPaymentMethodId2, DateTime.now(), context.getTenantId());

        final TestPaymentMethodsRecord account1Method1Record = dao.getPaymentMethod(kbPaymentMethodId1, context.getTenantId());
        final TestPaymentMethodsRecord account1Method2Record = dao.getPaymentMethod(kbPaymentMethodId2, context.getTenantId());
        final TestPaymentMethodsRecord account2Method1Record = dao.getPaymentMethod(kbPaymentMethodId3, context.getTenantId());

        Assert.assertEquals(account1Method1Record.getIsDefault().byteValue(), PluginPaymentDao.FALSE, "Wrong isDefault for account 1 method 1");
        Assert.assertEquals(account1Method2Record.getIsDefault().byteValue(), PluginPaymentDao.TRUE, "Wrong isDefault for account 1 method 2");
        Assert.assertEquals(account2Method1Record.getIsDefault().byteValue(), PluginPaymentDao.TRUE, "Wrong isDefault for account 2 method 1");
    }
}
