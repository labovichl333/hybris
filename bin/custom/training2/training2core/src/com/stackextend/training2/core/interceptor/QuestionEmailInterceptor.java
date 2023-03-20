package com.stackextend.training2.core.interceptor;

import com.myapp.questions.model.QuestionModel;
import com.stackextend.training2.core.model.QuestionEmailProcessModel;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.site.BaseSiteService;
import de.hybris.platform.store.BaseStoreModel;
import de.hybris.platform.store.services.BaseStoreService;

public class QuestionEmailInterceptor implements PrepareInterceptor<QuestionModel> {
    private BusinessProcessService businessProcessService;
    private ModelService modelService;
    private BaseSiteService baseSiteService;
    private BaseStoreService baseStoreService;


    @Override
    public void onPrepare(QuestionModel questionModel, InterceptorContext interceptorContext) throws InterceptorException {
        QuestionEmailProcessModel process = businessProcessService
                .createProcess("question-" + System.currentTimeMillis(), "questionEmailProcess");
        BaseStoreModel baseStoreModel = baseStoreService.getBaseStoreForUid("electronics");
        BaseSiteModel baseSiteModel = baseSiteService.getBaseSiteForUID("electronics");
        process.setStore(baseStoreModel);
        process.setSite(baseSiteModel);
        process.setLanguage(baseSiteModel.getDefaultLanguage());
        process.setCurrency(baseStoreModel.getDefaultCurrency());
        process.setCustomer(questionModel.getQuestionCustomer());

        process.setFirstName(questionModel.getQuestionCustomer().getName());
        modelService.save(process);
        businessProcessService.startProcess(process);
    }

    public BusinessProcessService getBusinessProcessService() {
        return businessProcessService;
    }

    public void setBusinessProcessService(BusinessProcessService businessProcessService) {
        this.businessProcessService = businessProcessService;
    }

    public ModelService getModelService() {
        return modelService;
    }

    public BaseSiteService getBaseSiteService() {
        return baseSiteService;
    }

    public void setBaseSiteService(BaseSiteService baseSiteService) {
        this.baseSiteService = baseSiteService;
    }

    public BaseStoreService getBaseStoreService() {
        return baseStoreService;
    }

    public void setBaseStoreService(BaseStoreService baseStoreService) {
        this.baseStoreService = baseStoreService;
    }


    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

}
