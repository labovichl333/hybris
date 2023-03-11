package com.stackextend.training2.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.converters.populator.SearchResultVariantProductPopulator;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;

import java.util.Optional;

public class CustomSearchResultVariantProductPopulator extends SearchResultVariantProductPopulator {
    @Override
    public void populate(SearchResultValueData source, ProductData target) {
        super.populate(source, target);
        target.setQuestionCount(Optional.ofNullable(this.<Integer>getValue(source, "questionCount")).orElse(0));
    }
}
