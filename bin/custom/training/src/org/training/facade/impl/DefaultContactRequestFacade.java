package org.training.facade.impl;

import org.training.converter.ContactRequestConverter;
import org.training.data.ContactRequestData;
import org.training.facade.ContactRequestFacade;
import org.training.model.ContactRequestModel;
import org.training.service.ContactRequestService;

import javax.annotation.Resource;

public class DefaultContactRequestFacade implements ContactRequestFacade {
    @Resource
    private ContactRequestService contactRequestService;
    @Resource
    private ContactRequestConverter contactRequestConverter;

    @Override
    public ContactRequestData getContactRequestDetails(String sender) {
        ContactRequestModel contactRequestModel = contactRequestService.getContactRequest(sender);
        ContactRequestData contactRequestData = contactRequestConverter.convert(contactRequestModel);
        return contactRequestData;
    }

}
