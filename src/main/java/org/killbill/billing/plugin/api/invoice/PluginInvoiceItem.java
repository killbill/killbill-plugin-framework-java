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

package org.killbill.billing.plugin.api.invoice;

import java.math.BigDecimal;
import java.util.UUID;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.invoice.api.InvoiceItem;
import org.killbill.billing.invoice.api.InvoiceItemType;
import org.killbill.billing.invoice.api.boilerplate.InvoiceItemImp;

@JsonDeserialize( builder = PluginInvoiceItem.Builder.class )
public class PluginInvoiceItem extends InvoiceItemImp {

  public static PluginInvoiceItem createTaxItem(final InvoiceItem model,
      final UUID invoiceId,
      final BigDecimal amount,
      final String description) {
    return create(model, invoiceId, model.getStartDate(), model.getEndDate(), amount, description, InvoiceItemType.TAX);
  }

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
        model.getCatalogEffectiveDate(),
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
      final DateTime catalogEffectiveDate,
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

        this(new Builder<>()
            .withId(id)
            .withInvoiceItemType(invoiceItemType)
            .withInvoiceId(invoiceId)
            .withAccountId(accountId)
            .withChildAccountId(childAccountId)
            .withStartDate(startDate)
            .withEndDate(endDate)
            .withAmount(amount)
            .withCurrency(currency)
            .withDescription(description)
            .withSubscriptionId(subscriptionId)
            .withBundleId(bundleId)
            .withCatalogEffectiveDate(catalogEffectiveDate)
            .withProductName(productName)
            .withPrettyProductName(prettyProductName)
            .withPlanName(planName)
            .withPrettyPlanName(prettyPlanName)
            .withPhaseName(phaseName)
            .withPrettyPhaseName(prettyPhaseName)
            .withRate(rate)
            .withLinkedItemId(linkedItemId)
            .withUsageName(usageName)
            .withPrettyUsageName(prettyUsageName)
            .withQuantity(quantity)
            .withItemDetails(itemDetails)
            .withCreatedDate(createdDate)
            .withUpdatedDate(updatedDate)
            .validate()
            );
  }

  protected PluginInvoiceItem(final PluginInvoiceItem.Builder<?> builder) {
    super(builder);
  }

  public PluginInvoiceItem(final PluginInvoiceItem that) {
    super(that);
  }

  @SuppressWarnings("unchecked")
  public static class Builder<T extends PluginInvoiceItem.Builder<T>> 
    extends InvoiceItemImp.Builder<T> {

    public Builder() {
    }

    public Builder(final Builder that) {
      super(that);
    }

    @Override
    public Builder validate() {
      return this;
    }

    @Override
    public PluginInvoiceItem build() {
      return new PluginInvoiceItem(this.validate());
    }
  }
}
