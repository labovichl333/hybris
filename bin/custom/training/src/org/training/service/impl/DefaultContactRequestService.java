package org.training.service.impl;

import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import org.training.dao.ContactRequestDao;
import org.training.model.ContactRequestModel;
import org.training.service.ContactRequestService;

import javax.annotation.Resource;
import java.util.List;

public class DefaultContactRequestService implements ContactRequestService {
    @Resource
    private ContactRequestDao contactRequestDao;

    public ContactRequestModel getContactRequest(final String sender) {
        final List<ContactRequestModel> result = contactRequestDao.findBySender(sender);
        final int resultCount = result.size();
        if (resultCount == 0)
        {
            throw new UnknownIdentifierException(
                    "ContactRequest with sender '" + sender + "' not found!"
            );
        }
        else if (resultCount > 1)
        {
            throw new AmbiguousIdentifierException(
                    "ContactRequest with sender '" + sender + "' is not unique, " + resultCount
                            + " requests found!"
            );
        }
        return result.get(0);
    }

}