/*
 * This file is generated by jOOQ.
 */
package org.killbill.billing.plugin.dao.payment.gen.tables.records;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;
import org.killbill.billing.plugin.dao.payment.gen.tables.TestResponses;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TestResponsesRecord extends UpdatableRecordImpl<TestResponsesRecord> implements Record10<ULong, String, String, String, String, String, BigDecimal, String, String, LocalDateTime> {

    private static final long serialVersionUID = -1710320208;

    /**
     * Setter for <code>killbill.test_responses.record_id</code>.
     */
    public void setRecordId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>killbill.test_responses.record_id</code>.
     */
    public ULong getRecordId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>killbill.test_responses.kb_account_id</code>.
     */
    public void setKbAccountId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>killbill.test_responses.kb_account_id</code>.
     */
    public String getKbAccountId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>killbill.test_responses.kb_payment_id</code>.
     */
    public void setKbPaymentId(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>killbill.test_responses.kb_payment_id</code>.
     */
    public String getKbPaymentId() {
        return (String) get(2);
    }

    /**
     * Setter for <code>killbill.test_responses.kb_payment_transaction_id</code>.
     */
    public void setKbPaymentTransactionId(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>killbill.test_responses.kb_payment_transaction_id</code>.
     */
    public String getKbPaymentTransactionId() {
        return (String) get(3);
    }

    /**
     * Setter for <code>killbill.test_responses.kb_tenant_id</code>.
     */
    public void setKbTenantId(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>killbill.test_responses.kb_tenant_id</code>.
     */
    public String getKbTenantId() {
        return (String) get(4);
    }

    /**
     * Setter for <code>killbill.test_responses.transaction_type</code>.
     */
    public void setTransactionType(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>killbill.test_responses.transaction_type</code>.
     */
    public String getTransactionType() {
        return (String) get(5);
    }

    /**
     * Setter for <code>killbill.test_responses.amount</code>.
     */
    public void setAmount(BigDecimal value) {
        set(6, value);
    }

    /**
     * Getter for <code>killbill.test_responses.amount</code>.
     */
    public BigDecimal getAmount() {
        return (BigDecimal) get(6);
    }

    /**
     * Setter for <code>killbill.test_responses.currency</code>.
     */
    public void setCurrency(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>killbill.test_responses.currency</code>.
     */
    public String getCurrency() {
        return (String) get(7);
    }

    /**
     * Setter for <code>killbill.test_responses.additional_data</code>.
     */
    public void setAdditionalData(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>killbill.test_responses.additional_data</code>.
     */
    public String getAdditionalData() {
        return (String) get(8);
    }

    /**
     * Setter for <code>killbill.test_responses.created_date</code>.
     */
    public void setCreatedDate(LocalDateTime value) {
        set(9, value);
    }

    /**
     * Getter for <code>killbill.test_responses.created_date</code>.
     */
    public LocalDateTime getCreatedDate() {
        return (LocalDateTime) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<ULong, String, String, String, String, String, BigDecimal, String, String, LocalDateTime> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<ULong, String, String, String, String, String, BigDecimal, String, String, LocalDateTime> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return TestResponses.TEST_RESPONSES.RECORD_ID;
    }

    @Override
    public Field<String> field2() {
        return TestResponses.TEST_RESPONSES.KB_ACCOUNT_ID;
    }

    @Override
    public Field<String> field3() {
        return TestResponses.TEST_RESPONSES.KB_PAYMENT_ID;
    }

    @Override
    public Field<String> field4() {
        return TestResponses.TEST_RESPONSES.KB_PAYMENT_TRANSACTION_ID;
    }

    @Override
    public Field<String> field5() {
        return TestResponses.TEST_RESPONSES.KB_TENANT_ID;
    }

    @Override
    public Field<String> field6() {
        return TestResponses.TEST_RESPONSES.TRANSACTION_TYPE;
    }

    @Override
    public Field<BigDecimal> field7() {
        return TestResponses.TEST_RESPONSES.AMOUNT;
    }

    @Override
    public Field<String> field8() {
        return TestResponses.TEST_RESPONSES.CURRENCY;
    }

    @Override
    public Field<String> field9() {
        return TestResponses.TEST_RESPONSES.ADDITIONAL_DATA;
    }

    @Override
    public Field<LocalDateTime> field10() {
        return TestResponses.TEST_RESPONSES.CREATED_DATE;
    }

    @Override
    public ULong component1() {
        return getRecordId();
    }

    @Override
    public String component2() {
        return getKbAccountId();
    }

    @Override
    public String component3() {
        return getKbPaymentId();
    }

    @Override
    public String component4() {
        return getKbPaymentTransactionId();
    }

    @Override
    public String component5() {
        return getKbTenantId();
    }

    @Override
    public String component6() {
        return getTransactionType();
    }

    @Override
    public BigDecimal component7() {
        return getAmount();
    }

    @Override
    public String component8() {
        return getCurrency();
    }

    @Override
    public String component9() {
        return getAdditionalData();
    }

    @Override
    public LocalDateTime component10() {
        return getCreatedDate();
    }

    @Override
    public ULong value1() {
        return getRecordId();
    }

    @Override
    public String value2() {
        return getKbAccountId();
    }

    @Override
    public String value3() {
        return getKbPaymentId();
    }

    @Override
    public String value4() {
        return getKbPaymentTransactionId();
    }

    @Override
    public String value5() {
        return getKbTenantId();
    }

    @Override
    public String value6() {
        return getTransactionType();
    }

    @Override
    public BigDecimal value7() {
        return getAmount();
    }

    @Override
    public String value8() {
        return getCurrency();
    }

    @Override
    public String value9() {
        return getAdditionalData();
    }

    @Override
    public LocalDateTime value10() {
        return getCreatedDate();
    }

    @Override
    public TestResponsesRecord value1(ULong value) {
        setRecordId(value);
        return this;
    }

    @Override
    public TestResponsesRecord value2(String value) {
        setKbAccountId(value);
        return this;
    }

    @Override
    public TestResponsesRecord value3(String value) {
        setKbPaymentId(value);
        return this;
    }

    @Override
    public TestResponsesRecord value4(String value) {
        setKbPaymentTransactionId(value);
        return this;
    }

    @Override
    public TestResponsesRecord value5(String value) {
        setKbTenantId(value);
        return this;
    }

    @Override
    public TestResponsesRecord value6(String value) {
        setTransactionType(value);
        return this;
    }

    @Override
    public TestResponsesRecord value7(BigDecimal value) {
        setAmount(value);
        return this;
    }

    @Override
    public TestResponsesRecord value8(String value) {
        setCurrency(value);
        return this;
    }

    @Override
    public TestResponsesRecord value9(String value) {
        setAdditionalData(value);
        return this;
    }

    @Override
    public TestResponsesRecord value10(LocalDateTime value) {
        setCreatedDate(value);
        return this;
    }

    @Override
    public TestResponsesRecord values(ULong value1, String value2, String value3, String value4, String value5, String value6, BigDecimal value7, String value8, String value9, LocalDateTime value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TestResponsesRecord
     */
    public TestResponsesRecord() {
        super(TestResponses.TEST_RESPONSES);
    }

    /**
     * Create a detached, initialised TestResponsesRecord
     */
    public TestResponsesRecord(ULong recordId, String kbAccountId, String kbPaymentId, String kbPaymentTransactionId, String kbTenantId, String transactionType, BigDecimal amount, String currency, String additionalData, LocalDateTime createdDate) {
        super(TestResponses.TEST_RESPONSES);

        set(0, recordId);
        set(1, kbAccountId);
        set(2, kbPaymentId);
        set(3, kbPaymentTransactionId);
        set(4, kbTenantId);
        set(5, transactionType);
        set(6, amount);
        set(7, currency);
        set(8, additionalData);
        set(9, createdDate);
    }
}
