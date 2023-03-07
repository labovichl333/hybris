package com.myapp.questions.populator;

import com.myapp.questions.data.QuestionData;
import com.myapp.questions.model.QuestionModel;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Converters;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import javax.annotation.Resource;

public class ProductQuestionsPopulator implements Populator<ProductModel, ProductData> {
    private Converter<QuestionModel, QuestionData> converter;

    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        productData.setQuestions(Converters.convertAll(productModel.getQuestions(), converter));
    }

    @Resource
    public void setConverter(Converter<QuestionModel, QuestionData> converter) {
        this.converter = converter;
    }
}
