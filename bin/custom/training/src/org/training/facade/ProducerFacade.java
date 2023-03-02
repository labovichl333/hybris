package org.training.facade;

import org.training.data.ProducerData;

public interface ProducerFacade {
    ProducerData getProducer(String code);
}
