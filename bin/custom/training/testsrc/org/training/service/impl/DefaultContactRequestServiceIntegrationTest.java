package org.training.service.impl;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Before;
import org.junit.Test;
import org.training.model.ContactRequestModel;
import org.training.service.ContactRequestService;

import javax.annotation.Resource;

@IntegrationTest
public class DefaultContactRequestServiceIntegrationTest extends ServicelayerTransactionalTest {
    @Resource
    private ContactRequestService contactRequestService;

    @Resource
    private ModelService modelService;

    private ContactRequestModel contactRequestModel;

    private static final String SENDER = "MAKS";
    private static final String MESSAGE = "Hello!";
    private final static String NOT_EXISTING_SENDER = "NotExistingSender";

    @Before
    public void setUp() {
        contactRequestModel.setSender(SENDER);
        contactRequestModel.setMessage(MESSAGE);
    }

    @Test(expected = UnknownIdentifierException.class)
    public void testFailBehavior() {
        contactRequestService.getContactRequest(NOT_EXISTING_SENDER);
    }


}
