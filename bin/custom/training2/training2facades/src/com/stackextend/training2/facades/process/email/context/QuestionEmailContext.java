package com.stackextend.training2.facades.process.email.context;

import com.stackextend.training2.core.model.QuestionEmailProcessModel;
import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.commerceservices.model.process.StoreFrontCustomerProcessModel;

public class QuestionEmailContext extends CustomerEmailContext{
    private String firstName;
    @Override
    public void init(StoreFrontCustomerProcessModel processModel, EmailPageModel emailPageModel) {
        super.init(processModel, emailPageModel);
        if (processModel instanceof QuestionEmailProcessModel)
        {
            setFirstName(((QuestionEmailProcessModel) processModel).getFirstName());
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
