package org.training.converter;

import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.training.data.ProducerData;
import org.training.model.ProducerModel;

public class ProducerConverter implements Converter<ProducerModel, ProducerData> {
    @Override
    public ProducerData convert(ProducerModel producerModel) throws ConversionException {
        return convert(producerModel, new ProducerData());
    }

    @Override
    public ProducerData convert(ProducerModel producerModel, ProducerData producerData) throws ConversionException {
        producerData.setName(producerModel.getName());
        producerData.setSurname(producerModel.getSurname());
        return producerData;
    }
}
