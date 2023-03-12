package com.stackextend.training2.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.converters.populator.SearchResultVariantProductPopulator;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;

public class CustomSearchResultVariantProductPopulator extends SearchResultVariantProductPopulator {
    @Override
    public void populate(SearchResultValueData source, ProductData target) {
        super.populate(source, target);
        String temp=this.<String>getValue(source, "questionCount");
        target.setQuestionCount(Integer.parseInt(temp));

        //target.setQuestionCount(this.<Integer>getValue(source, "questionCount"));
    }
}