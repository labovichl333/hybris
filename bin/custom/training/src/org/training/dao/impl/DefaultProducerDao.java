package org.training.dao.impl;


import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.training.dao.ProducerDao;
import org.training.model.ProducerModel;

import javax.annotation.Resource;
import java.util.List;

public class DefaultProducerDao implements ProducerDao {

    @Resource
    private FlexibleSearchService flexibleSearchService;


    @Override
    public List<ProducerModel> findProducersByCode(String code) {
        final String queryString = "SELECT {p:" + ProducerModel.PK + "} " +
                "FROM {" + ProducerModel._TYPECODE + " AS p} " +
                "WHERE {p:" + ProducerModel.CODE + "}=?code";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        query.addQueryParameter("code", code);
        return flexibleSearchService.<ProducerModel>search(query).getResult();
    }
}