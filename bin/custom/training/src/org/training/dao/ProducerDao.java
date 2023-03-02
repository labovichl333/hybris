package org.training.dao;

import org.training.model.ProducerModel;

import java.util.List;

public interface ProducerDao {
    List<ProducerModel> findProducersByCode(String code);
}
