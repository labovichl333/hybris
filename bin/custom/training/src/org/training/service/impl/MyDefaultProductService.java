package org.training.service.impl;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.internal.service.AbstractBusinessService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

public class MyDefaultProductService extends AbstractBusinessService implements ProductService {
    @Override
    public ProductModel getProduct(String code) {
        return null;
    }

    @Override
    public ProductModel getProductForCode(String code) {
        return null;
    }

    @Override
    public ProductModel getProduct(CatalogVersionModel catalogVersion, String code) {
        return null;
    }

    @Override
    public UnitModel getOrderableUnit(ProductModel product) {
        return null;
    }

    @Override
    public UnitModel getUnit(String code) {
        return null;
    }

    @Override
    public List<ProductModel> getProducts(CategoryModel category) {
        return null;
    }

    @Override
    public List<ProductModel> getProductsForCategory(CategoryModel category) {
        return null;
    }

    @Override
    public List<ProductModel> getOnlineProductsForCategory(CategoryModel category) {
        return null;
    }

    @Override
    public List<ProductModel> getOfflineProductsForCategory(CategoryModel category) {
        return null;
    }

    @Override
    public SearchResult<ProductModel> getProducts(CategoryModel category, int start, int count) {
        return null;
    }

    @Override
    public List<ProductModel> getProductsForCategory(CategoryModel category, int start, int count) {
        return null;
    }

    @Override
    public Integer getProductsCountForCategory(CategoryModel category) {
        return null;
    }

    @Override
    public Integer getAllProductsCountForCategory(CategoryModel category) {
        return null;
    }

    @Override
    public boolean containsProductsForCategory(CategoryModel category) {
        return false;
    }

    @Override
    public ProductModel getProductForCode(CatalogVersionModel catalogVersion, String code) {
        return null;
    }

    @Override
    public List<ProductModel> getAllProductsForCatalogVersion(CatalogVersionModel catalogVersion) {
        return null;
    }
}
