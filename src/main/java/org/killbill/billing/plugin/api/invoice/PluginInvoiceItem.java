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

package org.killbill.billing.plugin.api.invoice;

import java.math.BigDecimal;
import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.invoice.api.InvoiceItem;
import org.killbill.billing.invoice.api.InvoiceItemType;

public class PluginInvoiceItem implements InvoiceItem {

    protected final UUID id;
    protected final InvoiceItemType invoiceItemType;
    protected final UUID invoiceId;
    protected final UUID accountId;
    protected final UUID childAccountId;
    protected final LocalDate startDate;
    protected final LocalDate endDate;
    protected final BigDecimal amount;
    protected final Currency currency;
    protected final String description;
    protected final UUID subscriptionId;
    protected final UUID bundleId;
    protected final String productName;
    protected final String prettyProductName;
    protected final String planName;
    protected final String prettyPlanName;
    protected final String phaseName;
    protected final String prettyPhaseName;
    protected final BigDecimal rate;
    protected final UUID linkedItemId;
    protected final String usageName;
    protected final String prettyUsageName;
    protected final Integer quantity;
    protected final String itemDetails;
    protected final DateTime createdDate;
    protected final DateTime updatedDate;

    public static PluginInvoiceItem createTaxItem(final InvoiceItem model,
                                                  final UUID invoiceId,
                                                  final LocalDate startDate,
                                                  final LocalDate endDate,
                                                  final BigDecimal amount,
                                                  final String description) {
        return create(model, invoiceId, startDate, endDate, amount, description, InvoiceItemType.TAX);
    }

    public static PluginInvoiceItem createAdjustmentItem(final InvoiceItem model,
                                                         final UUID invoiceId,
                                                         final LocalDate startDate,
                                                         final LocalDate endDate,
                                                         final BigDecimal amount,
                                                         final String description) {
        return create(model, invoiceId, startDate, endDate, amount, description, InvoiceItemType.ITEM_ADJ);
    }

    public static PluginInvoiceItem create(final InvoiceItem model,
                                           final UUID invoiceId,
                                           final LocalDate startDate,
                                           final LocalDate endDate,
                                           final BigDecimal amount,
                                           final String description,
                                           final InvoiceItemType invoiceItemType) {
        return new PluginInvoiceItem(UUID.randomUUID(),
                                     invoiceItemType,
                                     invoiceId,
                                     model.getAccountId(),
                                     model.getChildAccountId(),
                                     startDate,
                                     endDate,
                                     amount,
                                     model.getCurrency(),
                                     description,
                                     model.getSubscriptionId(),
                                     model.getBundleId(),
                                     model.getProductName(),
                                     model.getPrettyProductName(),
                                     model.getPlanName(),
                                     model.getPrettyPlanName(),
                                     model.getPhaseName(),
                                     model.getPrettyPhaseName(),
                                     model.getRate(),
                                     model.getId(),
                                     model.getUsageName(),
                                     model.getPrettyUsageName(),
                                     model.getQuantity(),
                                     model.getItemDetails(),
                                     model.getCreatedDate(),
                                     model.getUpdatedDate());
    }


    public PluginInvoiceItem(final UUID id,
                             final InvoiceItemType invoiceItemType,
                             final UUID invoiceId,
                             final UUID accountId,
                             final UUID childAccountId,
                             final LocalDate startDate,
                             final LocalDate endDate,
                             final BigDecimal amount,
                             final Currency currency,
                             final String description,
                             final UUID subscriptionId,
                             final UUID bundleId,
                             final String productName,
                             final String prettyProductName,
                             final String planName,
                             final String prettyPlanName,
                             final String phaseName,
                             final String prettyPhaseName,
                             final BigDecimal rate,
                             final UUID linkedItemId,
                             final String usageName,
                             final String prettyUsageName,
                             final Integer quantity,
                             final String itemDetails,
                             final DateTime createdDate,
                             final DateTime updatedDate) {
        this.id = id;
        this.invoiceItemType = invoiceItemType;
        this.invoiceId = invoiceId;
        this.accountId = accountId;
        this.childAccountId = childAccountId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
        this.subscriptionId = subscriptionId;
        this.bundleId = bundleId;
        this.productName = productName;
        this.prettyProductName = prettyProductName;
        this.planName = planName;
        this.prettyPlanName = prettyPlanName;
        this.phaseName = phaseName;
        this.prettyPhaseName = prettyPhaseName;
        this.rate = rate;
        this.linkedItemId = linkedItemId;
        this.usageName = usageName;
        this.prettyUsageName = prettyUsageName;
        this.quantity = quantity;
        this.itemDetails = itemDetails;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public InvoiceItemType getInvoiceItemType() {
        return invoiceItemType;
    }

    @Override
    public UUID getInvoiceId() {
        return invoiceId;
    }

    @Override
    public UUID getAccountId() {
        return accountId;
    }

    @Override
    public UUID getChildAccountId() {
        return childAccountId;
    }

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public UUID getSubscriptionId() {
        return subscriptionId;
    }

    @Override
    public String getProductName() {
        return this.productName;
    }

    @Override
    public String getPrettyProductName() {
        return this.prettyProductName;
    }

    @Override
    public UUID getBundleId() {
        return bundleId;
    }

    @Override
    public String getPlanName() {
        return planName;
    }

    @Override
    public String getPrettyPlanName() {
        return prettyPlanName;
    }

    @Override
    public String getPhaseName() {
        return phaseName;
    }

    @Override
    public String getPrettyPhaseName() {
        return prettyPhaseName;
    }

    @Override
    public BigDecimal getRate() {
        return rate;
    }

    @Override
    public UUID getLinkedItemId() {
        return linkedItemId;
    }

    @Override
    public String getUsageName() {
        return usageName;
    }

    @Override
    public String getPrettyUsageName() {
        return prettyUsageName;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String getItemDetails() {
        return itemDetails;
    }

    @Override
    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public DateTime getUpdatedDate() {
        return updatedDate;
    }

    @Override
    public boolean matches(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PluginInvoiceItem)) {
            return false;
        }

        final PluginInvoiceItem that = (PluginInvoiceItem) o;

        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) {
            return false;
        }
        if (childAccountId != null ? !childAccountId.equals(that.childAccountId) : that.childAccountId != null) {
            return false;
        }
        if (bundleId != null ? !bundleId.equals(that.bundleId) : that.bundleId != null) {
            return false;
        }
        if (subscriptionId != null ? !subscriptionId.equals(that.subscriptionId) : that.subscriptionId != null) {
            return false;
        }
        if (invoiceItemType != that.invoiceItemType) {
            return false;
        }
        if (safeCompareTo(startDate, that.startDate) != 0) {
            return false;
        }
        if (safeCompareTo(endDate, that.endDate) != 0) {
            return false;
        }
        if (safeCompareTo(amount, that.amount) != 0) {
            return false;
        }
        if (safeCompareTo(rate, that.rate) != 0) {
            return false;
        }
        if (currency != that.currency) {
            return false;
        }
        if (phaseName != null ? !phaseName.equals(that.phaseName) : that.phaseName != null) {
            return false;
        }
        if (prettyPhaseName != null ? !prettyPhaseName.equals(that.prettyPhaseName) : that.prettyPhaseName != null) {
            return false;
        }
        if (planName != null ? !planName.equals(that.planName) : that.planName != null) {
            return false;
        }
        if (prettyPlanName != null ? !prettyPlanName.equals(that.prettyPlanName) : that.prettyPlanName != null) {
            return false;
        }
        if (usageName != null ? !usageName.equals(that.usageName) : that.usageName != null) {
            return false;
        }
        if (prettyUsageName != null ? !prettyUsageName.equals(that.prettyUsageName) : that.prettyUsageName != null) {
            return false;
        }
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) {
            return false;
        }
        if (itemDetails != null ? !itemDetails.equals(that.itemDetails) : that.itemDetails != null) {
            return false;
        }
        return true;
    }

    protected <T> int safeCompareTo(final Comparable<T> c1, final T c2) {
        if (c1 == null && c2 == null) {
            return 0;
        } else if (c1 == null) {
            return -1;
        } else if (c2 == null) {
            return 1;
        } else {
            return c1.compareTo(c2);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PluginInvoiceItem{");
        sb.append("id=").append(id);
        sb.append(", invoiceItemType=").append(invoiceItemType);
        sb.append(", invoiceId=").append(invoiceId);
        sb.append(", accountId=").append(accountId);
        sb.append(", childAccountId=").append(childAccountId);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", amount=").append(amount);
        sb.append(", currency=").append(currency);
        sb.append(", description='").append(description).append('\'');
        sb.append(", subscriptionId=").append(subscriptionId);
        sb.append(", bundleId=").append(bundleId);
        sb.append(", planName='").append(planName).append('\'');
        sb.append(", prettyPlanName='").append(prettyPlanName).append('\'');
        sb.append(", phaseName='").append(phaseName).append('\'');
        sb.append(", prettyPhaseName='").append(prettyPhaseName).append('\'');
        sb.append(", rate=").append(rate);
        sb.append(", linkedItemId=").append(linkedItemId);
        sb.append(", usageName='").append(usageName).append('\'');
        sb.append(", prettyUsageName='").append(prettyUsageName).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", itemDetails='").append(itemDetails).append('\'');
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updatedDate=").append(updatedDate);
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
        if (!matches(o)) {
            return false;
        }

        final PluginInvoiceItem that = (PluginInvoiceItem) o;

        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) {
            return false;
        }
        if (description != null ? !description.equals(that.description) : that.description != null) {
            return false;
        }
        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (invoiceId != null ? !invoiceId.equals(that.invoiceId) : that.invoiceId != null) {
            return false;
        }
        if (linkedItemId != null ? !linkedItemId.equals(that.linkedItemId) : that.linkedItemId != null) {
            return false;
        }
        if (updatedDate != null ? !updatedDate.equals(that.updatedDate) : that.updatedDate != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (invoiceItemType != null ? invoiceItemType.hashCode() : 0);
        result = 31 * result + (invoiceId != null ? invoiceId.hashCode() : 0);
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (childAccountId != null ? childAccountId.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (subscriptionId != null ? subscriptionId.hashCode() : 0);
        result = 31 * result + (bundleId != null ? bundleId.hashCode() : 0);
        result = 31 * result + (planName != null ? planName.hashCode() : 0);
        result = 31 * result + (prettyPlanName != null ? prettyPlanName.hashCode() : 0);
        result = 31 * result + (phaseName != null ? phaseName.hashCode() : 0);
        result = 31 * result + (prettyPhaseName != null ? prettyPhaseName.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (linkedItemId != null ? linkedItemId.hashCode() : 0);
        result = 31 * result + (usageName != null ? usageName.hashCode() : 0);
        result = 31 * result + (prettyUsageName != null ? prettyUsageName.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (itemDetails != null ? itemDetails.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        return result;
    }
}
