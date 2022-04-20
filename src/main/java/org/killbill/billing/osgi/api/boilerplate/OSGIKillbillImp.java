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

package org.killbill.billing.osgi.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import org.killbill.billing.account.api.AccountUserApi;
import org.killbill.billing.catalog.api.CatalogUserApi;
import org.killbill.billing.currency.api.CurrencyConversionApi;
import org.killbill.billing.entitlement.api.EntitlementApi;
import org.killbill.billing.entitlement.api.SubscriptionApi;
import org.killbill.billing.invoice.api.InvoiceUserApi;
import org.killbill.billing.osgi.api.OSGIKillbill;
import org.killbill.billing.osgi.api.PluginsInfoApi;
import org.killbill.billing.osgi.api.config.PluginConfigServiceApi;
import org.killbill.billing.overdue.api.OverdueApi;
import org.killbill.billing.payment.api.AdminPaymentApi;
import org.killbill.billing.payment.api.InvoicePaymentApi;
import org.killbill.billing.payment.api.PaymentApi;
import org.killbill.billing.security.api.SecurityApi;
import org.killbill.billing.tenant.api.TenantUserApi;
import org.killbill.billing.usage.api.UsageUserApi;
import org.killbill.billing.util.api.AuditUserApi;
import org.killbill.billing.util.api.CustomFieldUserApi;
import org.killbill.billing.util.api.ExportUserApi;
import org.killbill.billing.util.api.RecordIdApi;
import org.killbill.billing.util.api.TagUserApi;
import org.killbill.billing.util.nodes.KillbillNodesApi;

@JsonDeserialize( builder = OSGIKillbillImp.Builder.class )
public class OSGIKillbillImp implements OSGIKillbill {

    private static final long serialVersionUID = 0x95EB15ABC31DA206L;

    protected AccountUserApi accountUserApi;
    protected AdminPaymentApi adminPaymentApi;
    protected AuditUserApi auditUserApi;
    protected CatalogUserApi catalogUserApi;
    protected CurrencyConversionApi currencyConversionApi;
    protected CustomFieldUserApi customFieldUserApi;
    protected EntitlementApi entitlementApi;
    protected ExportUserApi exportUserApi;
    protected InvoicePaymentApi invoicePaymentApi;
    protected InvoiceUserApi invoiceUserApi;
    protected KillbillNodesApi killbillNodesApi;
    protected OverdueApi overdueApi;
    protected PaymentApi paymentApi;
    protected PluginConfigServiceApi pluginConfigServiceApi;
    protected PluginsInfoApi pluginsInfoApi;
    protected RecordIdApi recordIdApi;
    protected SecurityApi securityApi;
    protected SubscriptionApi subscriptionApi;
    protected TagUserApi tagUserApi;
    protected TenantUserApi tenantUserApi;
    protected UsageUserApi usageUserApi;

    public OSGIKillbillImp(final OSGIKillbillImp that) {
        this.accountUserApi = that.accountUserApi;
        this.adminPaymentApi = that.adminPaymentApi;
        this.auditUserApi = that.auditUserApi;
        this.catalogUserApi = that.catalogUserApi;
        this.currencyConversionApi = that.currencyConversionApi;
        this.customFieldUserApi = that.customFieldUserApi;
        this.entitlementApi = that.entitlementApi;
        this.exportUserApi = that.exportUserApi;
        this.invoicePaymentApi = that.invoicePaymentApi;
        this.invoiceUserApi = that.invoiceUserApi;
        this.killbillNodesApi = that.killbillNodesApi;
        this.overdueApi = that.overdueApi;
        this.paymentApi = that.paymentApi;
        this.pluginConfigServiceApi = that.pluginConfigServiceApi;
        this.pluginsInfoApi = that.pluginsInfoApi;
        this.recordIdApi = that.recordIdApi;
        this.securityApi = that.securityApi;
        this.subscriptionApi = that.subscriptionApi;
        this.tagUserApi = that.tagUserApi;
        this.tenantUserApi = that.tenantUserApi;
        this.usageUserApi = that.usageUserApi;
    }
    protected OSGIKillbillImp(final OSGIKillbillImp.Builder<?> builder) {
        this.accountUserApi = builder.accountUserApi;
        this.adminPaymentApi = builder.adminPaymentApi;
        this.auditUserApi = builder.auditUserApi;
        this.catalogUserApi = builder.catalogUserApi;
        this.currencyConversionApi = builder.currencyConversionApi;
        this.customFieldUserApi = builder.customFieldUserApi;
        this.entitlementApi = builder.entitlementApi;
        this.exportUserApi = builder.exportUserApi;
        this.invoicePaymentApi = builder.invoicePaymentApi;
        this.invoiceUserApi = builder.invoiceUserApi;
        this.killbillNodesApi = builder.killbillNodesApi;
        this.overdueApi = builder.overdueApi;
        this.paymentApi = builder.paymentApi;
        this.pluginConfigServiceApi = builder.pluginConfigServiceApi;
        this.pluginsInfoApi = builder.pluginsInfoApi;
        this.recordIdApi = builder.recordIdApi;
        this.securityApi = builder.securityApi;
        this.subscriptionApi = builder.subscriptionApi;
        this.tagUserApi = builder.tagUserApi;
        this.tenantUserApi = builder.tenantUserApi;
        this.usageUserApi = builder.usageUserApi;
    }
    protected OSGIKillbillImp() { }
    @Override
    public AccountUserApi getAccountUserApi() {
        return this.accountUserApi;
    }
    @Override
    public AdminPaymentApi getAdminPaymentApi() {
        return this.adminPaymentApi;
    }
    @Override
    public AuditUserApi getAuditUserApi() {
        return this.auditUserApi;
    }
    @Override
    public CatalogUserApi getCatalogUserApi() {
        return this.catalogUserApi;
    }
    @Override
    public CurrencyConversionApi getCurrencyConversionApi() {
        return this.currencyConversionApi;
    }
    @Override
    public CustomFieldUserApi getCustomFieldUserApi() {
        return this.customFieldUserApi;
    }
    @Override
    public EntitlementApi getEntitlementApi() {
        return this.entitlementApi;
    }
    @Override
    public ExportUserApi getExportUserApi() {
        return this.exportUserApi;
    }
    @Override
    public InvoicePaymentApi getInvoicePaymentApi() {
        return this.invoicePaymentApi;
    }
    @Override
    public InvoiceUserApi getInvoiceUserApi() {
        return this.invoiceUserApi;
    }
    @Override
    public KillbillNodesApi getKillbillNodesApi() {
        return this.killbillNodesApi;
    }
    @Override
    public OverdueApi getOverdueApi() {
        return this.overdueApi;
    }
    @Override
    public PaymentApi getPaymentApi() {
        return this.paymentApi;
    }
    @Override
    public PluginConfigServiceApi getPluginConfigServiceApi() {
        return this.pluginConfigServiceApi;
    }
    @Override
    public PluginsInfoApi getPluginsInfoApi() {
        return this.pluginsInfoApi;
    }
    @Override
    public RecordIdApi getRecordIdApi() {
        return this.recordIdApi;
    }
    @Override
    public SecurityApi getSecurityApi() {
        return this.securityApi;
    }
    @Override
    public SubscriptionApi getSubscriptionApi() {
        return this.subscriptionApi;
    }
    @Override
    public TagUserApi getTagUserApi() {
        return this.tagUserApi;
    }
    @Override
    public TenantUserApi getTenantUserApi() {
        return this.tenantUserApi;
    }
    @Override
    public UsageUserApi getUsageUserApi() {
        return this.usageUserApi;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final OSGIKillbillImp that = (OSGIKillbillImp) o;
        if( !Objects.equals(this.accountUserApi, that.accountUserApi) ) {
            return false;
        }
        if( !Objects.equals(this.adminPaymentApi, that.adminPaymentApi) ) {
            return false;
        }
        if( !Objects.equals(this.auditUserApi, that.auditUserApi) ) {
            return false;
        }
        if( !Objects.equals(this.catalogUserApi, that.catalogUserApi) ) {
            return false;
        }
        if( !Objects.equals(this.currencyConversionApi, that.currencyConversionApi) ) {
            return false;
        }
        if( !Objects.equals(this.customFieldUserApi, that.customFieldUserApi) ) {
            return false;
        }
        if( !Objects.equals(this.entitlementApi, that.entitlementApi) ) {
            return false;
        }
        if( !Objects.equals(this.exportUserApi, that.exportUserApi) ) {
            return false;
        }
        if( !Objects.equals(this.invoicePaymentApi, that.invoicePaymentApi) ) {
            return false;
        }
        if( !Objects.equals(this.invoiceUserApi, that.invoiceUserApi) ) {
            return false;
        }
        if( !Objects.equals(this.killbillNodesApi, that.killbillNodesApi) ) {
            return false;
        }
        if( !Objects.equals(this.overdueApi, that.overdueApi) ) {
            return false;
        }
        if( !Objects.equals(this.paymentApi, that.paymentApi) ) {
            return false;
        }
        if( !Objects.equals(this.pluginConfigServiceApi, that.pluginConfigServiceApi) ) {
            return false;
        }
        if( !Objects.equals(this.pluginsInfoApi, that.pluginsInfoApi) ) {
            return false;
        }
        if( !Objects.equals(this.recordIdApi, that.recordIdApi) ) {
            return false;
        }
        if( !Objects.equals(this.securityApi, that.securityApi) ) {
            return false;
        }
        if( !Objects.equals(this.subscriptionApi, that.subscriptionApi) ) {
            return false;
        }
        if( !Objects.equals(this.tagUserApi, that.tagUserApi) ) {
            return false;
        }
        if( !Objects.equals(this.tenantUserApi, that.tenantUserApi) ) {
            return false;
        }
        if( !Objects.equals(this.usageUserApi, that.usageUserApi) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.accountUserApi);
        result = ( 31 * result ) + Objects.hashCode(this.adminPaymentApi);
        result = ( 31 * result ) + Objects.hashCode(this.auditUserApi);
        result = ( 31 * result ) + Objects.hashCode(this.catalogUserApi);
        result = ( 31 * result ) + Objects.hashCode(this.currencyConversionApi);
        result = ( 31 * result ) + Objects.hashCode(this.customFieldUserApi);
        result = ( 31 * result ) + Objects.hashCode(this.entitlementApi);
        result = ( 31 * result ) + Objects.hashCode(this.exportUserApi);
        result = ( 31 * result ) + Objects.hashCode(this.invoicePaymentApi);
        result = ( 31 * result ) + Objects.hashCode(this.invoiceUserApi);
        result = ( 31 * result ) + Objects.hashCode(this.killbillNodesApi);
        result = ( 31 * result ) + Objects.hashCode(this.overdueApi);
        result = ( 31 * result ) + Objects.hashCode(this.paymentApi);
        result = ( 31 * result ) + Objects.hashCode(this.pluginConfigServiceApi);
        result = ( 31 * result ) + Objects.hashCode(this.pluginsInfoApi);
        result = ( 31 * result ) + Objects.hashCode(this.recordIdApi);
        result = ( 31 * result ) + Objects.hashCode(this.securityApi);
        result = ( 31 * result ) + Objects.hashCode(this.subscriptionApi);
        result = ( 31 * result ) + Objects.hashCode(this.tagUserApi);
        result = ( 31 * result ) + Objects.hashCode(this.tenantUserApi);
        result = ( 31 * result ) + Objects.hashCode(this.usageUserApi);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("accountUserApi=").append(this.accountUserApi);
        sb.append(", ");
        sb.append("adminPaymentApi=").append(this.adminPaymentApi);
        sb.append(", ");
        sb.append("auditUserApi=").append(this.auditUserApi);
        sb.append(", ");
        sb.append("catalogUserApi=").append(this.catalogUserApi);
        sb.append(", ");
        sb.append("currencyConversionApi=").append(this.currencyConversionApi);
        sb.append(", ");
        sb.append("customFieldUserApi=").append(this.customFieldUserApi);
        sb.append(", ");
        sb.append("entitlementApi=").append(this.entitlementApi);
        sb.append(", ");
        sb.append("exportUserApi=").append(this.exportUserApi);
        sb.append(", ");
        sb.append("invoicePaymentApi=").append(this.invoicePaymentApi);
        sb.append(", ");
        sb.append("invoiceUserApi=").append(this.invoiceUserApi);
        sb.append(", ");
        sb.append("killbillNodesApi=").append(this.killbillNodesApi);
        sb.append(", ");
        sb.append("overdueApi=").append(this.overdueApi);
        sb.append(", ");
        sb.append("paymentApi=").append(this.paymentApi);
        sb.append(", ");
        sb.append("pluginConfigServiceApi=").append(this.pluginConfigServiceApi);
        sb.append(", ");
        sb.append("pluginsInfoApi=").append(this.pluginsInfoApi);
        sb.append(", ");
        sb.append("recordIdApi=").append(this.recordIdApi);
        sb.append(", ");
        sb.append("securityApi=").append(this.securityApi);
        sb.append(", ");
        sb.append("subscriptionApi=").append(this.subscriptionApi);
        sb.append(", ");
        sb.append("tagUserApi=").append(this.tagUserApi);
        sb.append(", ");
        sb.append("tenantUserApi=").append(this.tenantUserApi);
        sb.append(", ");
        sb.append("usageUserApi=").append(this.usageUserApi);
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends OSGIKillbillImp.Builder<T>> {

        protected AccountUserApi accountUserApi;
        protected AdminPaymentApi adminPaymentApi;
        protected AuditUserApi auditUserApi;
        protected CatalogUserApi catalogUserApi;
        protected CurrencyConversionApi currencyConversionApi;
        protected CustomFieldUserApi customFieldUserApi;
        protected EntitlementApi entitlementApi;
        protected ExportUserApi exportUserApi;
        protected InvoicePaymentApi invoicePaymentApi;
        protected InvoiceUserApi invoiceUserApi;
        protected KillbillNodesApi killbillNodesApi;
        protected OverdueApi overdueApi;
        protected PaymentApi paymentApi;
        protected PluginConfigServiceApi pluginConfigServiceApi;
        protected PluginsInfoApi pluginsInfoApi;
        protected RecordIdApi recordIdApi;
        protected SecurityApi securityApi;
        protected SubscriptionApi subscriptionApi;
        protected TagUserApi tagUserApi;
        protected TenantUserApi tenantUserApi;
        protected UsageUserApi usageUserApi;

        public Builder() { }
        public Builder(final Builder that) {
            this.accountUserApi = that.accountUserApi;
            this.adminPaymentApi = that.adminPaymentApi;
            this.auditUserApi = that.auditUserApi;
            this.catalogUserApi = that.catalogUserApi;
            this.currencyConversionApi = that.currencyConversionApi;
            this.customFieldUserApi = that.customFieldUserApi;
            this.entitlementApi = that.entitlementApi;
            this.exportUserApi = that.exportUserApi;
            this.invoicePaymentApi = that.invoicePaymentApi;
            this.invoiceUserApi = that.invoiceUserApi;
            this.killbillNodesApi = that.killbillNodesApi;
            this.overdueApi = that.overdueApi;
            this.paymentApi = that.paymentApi;
            this.pluginConfigServiceApi = that.pluginConfigServiceApi;
            this.pluginsInfoApi = that.pluginsInfoApi;
            this.recordIdApi = that.recordIdApi;
            this.securityApi = that.securityApi;
            this.subscriptionApi = that.subscriptionApi;
            this.tagUserApi = that.tagUserApi;
            this.tenantUserApi = that.tenantUserApi;
            this.usageUserApi = that.usageUserApi;
        }
        public T withAccountUserApi(final AccountUserApi accountUserApi) {
            this.accountUserApi = accountUserApi;
            return (T) this;
        }
        public T withAdminPaymentApi(final AdminPaymentApi adminPaymentApi) {
            this.adminPaymentApi = adminPaymentApi;
            return (T) this;
        }
        public T withAuditUserApi(final AuditUserApi auditUserApi) {
            this.auditUserApi = auditUserApi;
            return (T) this;
        }
        public T withCatalogUserApi(final CatalogUserApi catalogUserApi) {
            this.catalogUserApi = catalogUserApi;
            return (T) this;
        }
        public T withCurrencyConversionApi(final CurrencyConversionApi currencyConversionApi) {
            this.currencyConversionApi = currencyConversionApi;
            return (T) this;
        }
        public T withCustomFieldUserApi(final CustomFieldUserApi customFieldUserApi) {
            this.customFieldUserApi = customFieldUserApi;
            return (T) this;
        }
        public T withEntitlementApi(final EntitlementApi entitlementApi) {
            this.entitlementApi = entitlementApi;
            return (T) this;
        }
        public T withExportUserApi(final ExportUserApi exportUserApi) {
            this.exportUserApi = exportUserApi;
            return (T) this;
        }
        public T withInvoicePaymentApi(final InvoicePaymentApi invoicePaymentApi) {
            this.invoicePaymentApi = invoicePaymentApi;
            return (T) this;
        }
        public T withInvoiceUserApi(final InvoiceUserApi invoiceUserApi) {
            this.invoiceUserApi = invoiceUserApi;
            return (T) this;
        }
        public T withKillbillNodesApi(final KillbillNodesApi killbillNodesApi) {
            this.killbillNodesApi = killbillNodesApi;
            return (T) this;
        }
        public T withOverdueApi(final OverdueApi overdueApi) {
            this.overdueApi = overdueApi;
            return (T) this;
        }
        public T withPaymentApi(final PaymentApi paymentApi) {
            this.paymentApi = paymentApi;
            return (T) this;
        }
        public T withPluginConfigServiceApi(final PluginConfigServiceApi pluginConfigServiceApi) {
            this.pluginConfigServiceApi = pluginConfigServiceApi;
            return (T) this;
        }
        public T withPluginsInfoApi(final PluginsInfoApi pluginsInfoApi) {
            this.pluginsInfoApi = pluginsInfoApi;
            return (T) this;
        }
        public T withRecordIdApi(final RecordIdApi recordIdApi) {
            this.recordIdApi = recordIdApi;
            return (T) this;
        }
        public T withSecurityApi(final SecurityApi securityApi) {
            this.securityApi = securityApi;
            return (T) this;
        }
        public T withSubscriptionApi(final SubscriptionApi subscriptionApi) {
            this.subscriptionApi = subscriptionApi;
            return (T) this;
        }
        public T withTagUserApi(final TagUserApi tagUserApi) {
            this.tagUserApi = tagUserApi;
            return (T) this;
        }
        public T withTenantUserApi(final TenantUserApi tenantUserApi) {
            this.tenantUserApi = tenantUserApi;
            return (T) this;
        }
        public T withUsageUserApi(final UsageUserApi usageUserApi) {
            this.usageUserApi = usageUserApi;
            return (T) this;
        }
        public T source(final OSGIKillbill that) {
            this.accountUserApi = that.getAccountUserApi();
            this.adminPaymentApi = that.getAdminPaymentApi();
            this.auditUserApi = that.getAuditUserApi();
            this.catalogUserApi = that.getCatalogUserApi();
            this.currencyConversionApi = that.getCurrencyConversionApi();
            this.customFieldUserApi = that.getCustomFieldUserApi();
            this.entitlementApi = that.getEntitlementApi();
            this.exportUserApi = that.getExportUserApi();
            this.invoicePaymentApi = that.getInvoicePaymentApi();
            this.invoiceUserApi = that.getInvoiceUserApi();
            this.killbillNodesApi = that.getKillbillNodesApi();
            this.overdueApi = that.getOverdueApi();
            this.paymentApi = that.getPaymentApi();
            this.pluginConfigServiceApi = that.getPluginConfigServiceApi();
            this.pluginsInfoApi = that.getPluginsInfoApi();
            this.recordIdApi = that.getRecordIdApi();
            this.securityApi = that.getSecurityApi();
            this.subscriptionApi = that.getSubscriptionApi();
            this.tagUserApi = that.getTagUserApi();
            this.tenantUserApi = that.getTenantUserApi();
            this.usageUserApi = that.getUsageUserApi();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public OSGIKillbillImp build() {
            return new OSGIKillbillImp(this.validate());
        }
    }
}
