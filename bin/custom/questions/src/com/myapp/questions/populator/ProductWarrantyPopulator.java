package com.myapp.questions.populator;

import de.hybris.platform.commercefacades.product.converters.populator.AbstractProductPopulator;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.Optional;

public class ProductWarrantyPopulator<SOURCE extends ProductModel, TARGET extends ProductData> extends AbstractProductPopulator<SOURCE, TARGET> {
    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        productData.setWarrantyYears(Optional.ofNullable(productModel.getWarrantyYears()).orElse(0));
    }
}
