package com.myapp.questions.populator;

import com.myapp.questions.data.QuestionData;
import com.myapp.questions.model.QuestionModel;
import de.hybris.platform.commercefacades.product.converters.populator.AbstractProductPopulator;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Converters;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import javax.annotation.Resource;

public class ProductQuestionsPopulator<SOURCE extends ProductModel, TARGET extends ProductData> extends AbstractProductPopulator<SOURCE, TARGET> {
    private Converter<QuestionModel, QuestionData> converter;

    @Override
    public void populate(SOURCE source, TARGET target) throws ConversionException {
        target.setQuestions(Converters.convertAll(source.getQuestions(), converter));
        target.setQuestionCount(source.getQuestions().size());
    }


    @Resource
    public void setConverter(Converter<QuestionModel, QuestionData> converter) {
        this.converter = converter;
    }
}
