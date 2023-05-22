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

package org.killbill.billing.plugin.api.payment;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.api.TransactionType;
import org.killbill.billing.payment.plugin.api.PaymentPluginStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@Test(groups = { "fast" })
public class TestPluginPaymentTransactionInfoPlugin {

    private final BigDecimal amount = new BigDecimal("100000");
    private final DateTime createdDate = new DateTime("2011-11-11T11:11"); 
    private final Currency currency = Currency.USD;
    private final DateTime effectiveDate = new DateTime("2011-11-11T11:11"); 
    private final String firstPaymentReferenceId = "TestFirstPaymentReferenceId";
    private final String gatewayError = "TestGatewayError";
    private final String gatewayErrorCode = "TestGatewayErrorCode";
    private final UUID kbPaymentId = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private final UUID kbTransactionPaymentId = UUID.fromString("00000000-0000-0000-0000-000000000002");
    private final List<PluginProperty> properties = Collections.emptyList();
    private final String secondPaymentReferenceId = "TestSecondPaymentReferenceId";
    private final PaymentPluginStatus status = PaymentPluginStatus.PENDING;
    private final TransactionType transactionType  = TransactionType.CHARGEBACK;

    @Test
    void builderIsEquivalentToConstructor() {

        PluginPaymentTransactionInfoPlugin a = new PluginPaymentTransactionInfoPlugin.Builder<>()
            .withKbPaymentId(kbPaymentId)
            .withKbTransactionPaymentId(kbTransactionPaymentId)
            .withTransactionType(transactionType)
            .withAmount(amount)
            .withCurrency(currency)
            .withStatus(status)
            .withGatewayError(gatewayError)
            .withGatewayErrorCode(gatewayErrorCode)
            .withFirstPaymentReferenceId(firstPaymentReferenceId)
            .withSecondPaymentReferenceId(secondPaymentReferenceId)
            .withCreatedDate(createdDate)
            .withEffectiveDate(effectiveDate)
            .withProperties(properties)
            .build();

        PluginPaymentTransactionInfoPlugin b = new PluginPaymentTransactionInfoPlugin(
                kbPaymentId,
                kbTransactionPaymentId,
                transactionType,
                amount,
                currency,
                status,
                gatewayError,
                gatewayErrorCode,
                firstPaymentReferenceId,
                secondPaymentReferenceId,
                createdDate,
                effectiveDate,
                properties) ;

        Assert.assertTrue(a.equals(b));
    }

    @Test
    void differentInstances() {

        PluginPaymentTransactionInfoPlugin.Builder builder = new PluginPaymentTransactionInfoPlugin.Builder<>()
            .withKbPaymentId(kbPaymentId)
            .withKbTransactionPaymentId(kbTransactionPaymentId)
            .withTransactionType(transactionType)
            .withAmount(amount)
            .withCurrency(currency)
            .withStatus(status)
            .withGatewayError(gatewayError)
            .withGatewayErrorCode(gatewayErrorCode)
            .withFirstPaymentReferenceId(firstPaymentReferenceId)
            .withSecondPaymentReferenceId(secondPaymentReferenceId)
            .withCreatedDate(createdDate)
            .withEffectiveDate(effectiveDate)
            .withProperties(properties);

        Assert.assertNotEquals(builder.build(), builder.withStatus(PaymentPluginStatus.ERROR).build());
    }

    @Test
    void callAllGetters() {

        PluginPaymentTransactionInfoPlugin a = new PluginPaymentTransactionInfoPlugin.Builder<>()
            .withKbPaymentId(kbPaymentId)
            .withKbTransactionPaymentId(kbTransactionPaymentId)
            .withTransactionType(transactionType)
            .withAmount(amount)
            .withCurrency(currency)
            .withStatus(status)
            .withGatewayError(gatewayError)
            .withGatewayErrorCode(gatewayErrorCode)
            .withFirstPaymentReferenceId(firstPaymentReferenceId)
            .withSecondPaymentReferenceId(secondPaymentReferenceId)
            .withCreatedDate(createdDate)
            .withEffectiveDate(effectiveDate)
            .withProperties(properties)
            .build();

        Assert.assertEquals(a.getKbPaymentId(), kbPaymentId);
        Assert.assertEquals(a.getKbTransactionPaymentId(), kbTransactionPaymentId);
        Assert.assertEquals(a.getTransactionType(), transactionType);
        Assert.assertEquals(a.getAmount(), amount);
        Assert.assertEquals(a.getCurrency(), currency);
        Assert.assertEquals(a.getStatus(), status);
        Assert.assertEquals(a.getGatewayError(), gatewayError);
        Assert.assertEquals(a.getGatewayErrorCode(), gatewayErrorCode);
        Assert.assertEquals(a.getFirstPaymentReferenceId(), firstPaymentReferenceId);
        Assert.assertEquals(a.getSecondPaymentReferenceId(), secondPaymentReferenceId);
        Assert.assertEquals(a.getCreatedDate(), createdDate);
        Assert.assertEquals(a.getEffectiveDate(), effectiveDate);
        Assert.assertEquals(a.getProperties(), properties);
    }

    @Test 
    void roundTripJson() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
        mapper.registerModule(new JodaModule());
        mapper.findAndRegisterModules();

        PluginPaymentTransactionInfoPlugin a = new PluginPaymentTransactionInfoPlugin.Builder<>()
            .withKbPaymentId(kbPaymentId)
            .withKbTransactionPaymentId(kbTransactionPaymentId)
            .withTransactionType(transactionType)
            .withAmount(amount)
            .withCurrency(currency)
            .withStatus(status)
            .withGatewayError(gatewayError)
            .withGatewayErrorCode(gatewayErrorCode)
            .withFirstPaymentReferenceId(firstPaymentReferenceId)
            .withSecondPaymentReferenceId(secondPaymentReferenceId)
            .withCreatedDate(createdDate)
            .withEffectiveDate(effectiveDate)
            .withProperties(properties)
            .build();

        String json = mapper.writeValueAsString(a);
        PluginPaymentTransactionInfoPlugin b = mapper.readValue(json, PluginPaymentTransactionInfoPlugin.class);
        Assert.assertTrue(a.equals(b));
    }
}
