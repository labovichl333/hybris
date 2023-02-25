package org.training.converter;

import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.training.model.ContactRequestModel;
import org.training.data.ContactRequestData;

public class ContactRequestConverter implements Converter<ContactRequestModel, ContactRequestData> {
    @Override
    public ContactRequestData convert(ContactRequestModel contactRequestModel) throws ConversionException {
        return convert(contactRequestModel,new ContactRequestData());
    }

    @Override
    public ContactRequestData convert(ContactRequestModel contactRequestModel, ContactRequestData contactRequestData) throws ConversionException {
        contactRequestModel.setSender(contactRequestModel.getSender());
        contactRequestModel.setMessage(contactRequestModel.getMessage());
        return contactRequestData;
    }
}
