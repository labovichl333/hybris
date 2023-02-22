package org.training.controller;

import de.hybris.platform.catalog.CatalogService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class ProductController {
    @Resource
    private ProductService productService;
    @Resource
    private CatalogService catalogService;

    @GetMapping(value = "/product")
    public String showPage(@RequestParam(required = false) String code, Model model){
        catalogService.setSessionCatalogVersion("electronicsProductCatalog", "Online");
        ProductModel product=null;
        if (code != null)
        {
            product = productService.getProductForCode(code);
        }

        model.addAttribute("product", product);
        return "product";
    }
}
