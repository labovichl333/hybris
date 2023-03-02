package org.training.facade.impl;

import org.training.converter.ProducerConverter;
import org.training.data.ProducerData;
import org.training.facade.ProducerFacade;
import org.training.model.ProducerModel;
import org.training.service.ProducerService;

import javax.annotation.Resource;

public class DefaultProducerFacade implements ProducerFacade {
    @Resource
    private ProducerService producerService;

    @Resource
    ProducerConverter producerConverter;

    @Override
    public ProducerData getProducer(String code) {
        ProducerModel producerModel = producerService.getProducerService(code);
        ProducerData producerData = producerConverter.convert(producerModel);
        return producerData;
    }
}
