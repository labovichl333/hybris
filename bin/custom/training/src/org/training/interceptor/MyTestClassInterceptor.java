package org.training.interceptor;

import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import org.training.event.MyTestClassEvent;
import org.training.model.ContactRequestModel;

import javax.annotation.Resource;

public class MyTestClassInterceptor implements PrepareInterceptor<ContactRequestModel> {
    private static final String HEADER_TEMPLATE = "Sender is: %s;";

    private static final String CONTENT_TEMPLATE = "Message is: %s;";
    @Resource
    private EventService eventService;

    @Override
    public void onPrepare(ContactRequestModel contactRequestModel, InterceptorContext interceptorContext)
            throws InterceptorException {
        eventService.publishEvent(new MyTestClassEvent(String.format(HEADER_TEMPLATE, contactRequestModel.getSender()),
                String.format(CONTENT_TEMPLATE, contactRequestModel.getMessage())));
    }
}
