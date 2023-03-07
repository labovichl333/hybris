package com.myapp.questions.controllers.cms;

import com.myapp.questions.model.QuestionsCMSComponentModel;
import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller("QuestionsCMSComponentController")
@RequestMapping(value="/view/QuestionsCMSComponentController")
public class QuestionsCMSComponentController extends AbstractCMSAddOnComponentController<QuestionsCMSComponentModel> {
    @Override
    protected void fillModel(HttpServletRequest request, Model model, QuestionsCMSComponentModel component) {
        model.addAttribute("fontSize", component.getFontSize());
        model.addAttribute("questionsNumber", component.getNumberOfQuestionsToShow());
    }
}
