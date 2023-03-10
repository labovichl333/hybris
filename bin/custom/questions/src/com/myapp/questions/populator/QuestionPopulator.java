package com.myapp.questions.populator;

import com.myapp.questions.data.QuestionData;
import com.myapp.questions.model.QuestionModel;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.Optional;

public class QuestionPopulator implements Populator<QuestionModel, QuestionData> {
    @Override
    public void populate(QuestionModel questionModel, QuestionData questionData) throws ConversionException {
        questionData.setQuestion(questionModel.getQuestion());
        questionData.setAnswer(questionModel.getAnswer());
        questionData.setQuestionCustomer(questionModel.getQuestionCustomer().getUid());

        Optional.ofNullable(questionModel.getAnswerCustomer())
                .ifPresent(customer -> questionData.setAnswerCustomer(customer.getUid()));
    }
}
