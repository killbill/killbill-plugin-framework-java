package org.killbill.billing.plugin.dao.payment;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.killbill.billing.plugin.dao.payment.gen.Tables;
import org.killbill.billing.plugin.dao.payment.gen.tables.TestPaymentMethods;
import org.killbill.billing.plugin.dao.payment.gen.tables.TestResponses;
import org.killbill.billing.plugin.dao.payment.gen.tables.records.TestPaymentMethodsRecord;
import org.killbill.billing.plugin.dao.payment.gen.tables.records.TestResponsesRecord;

public class TestPluginPaymentDao extends PluginPaymentDao<TestResponsesRecord, TestResponses, TestPaymentMethodsRecord, TestPaymentMethods> {

    public TestPluginPaymentDao(DataSource dataSource)
    throws SQLException {
        super(Tables.TEST_RESPONSES,
              Tables.TEST_PAYMENT_METHODS,
              dataSource);
    }

}
