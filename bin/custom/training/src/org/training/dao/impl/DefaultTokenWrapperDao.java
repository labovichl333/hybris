package org.training.dao.impl;

import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.training.dao.TokenWrapperDao;
import org.training.model.TokenWrapperModel;

import javax.annotation.Resource;
import java.util.List;

public class DefaultTokenWrapperDao implements TokenWrapperDao {
    @Resource
    private FlexibleSearchService flexibleSearchService;

    @Override
    public TokenWrapperModel getFirst() {
        final String queryString =
                "SELECT {p:" + ItemModel.PK + "} "
                        + "FROM {" + TokenWrapperModel._TYPECODE + " AS p} ";
        List<TokenWrapperModel> tokenWrappers = flexibleSearchService.<TokenWrapperModel>search(queryString).getResult();
        return !tokenWrappers.isEmpty() ? tokenWrappers.get(0) : null;
    }
}
