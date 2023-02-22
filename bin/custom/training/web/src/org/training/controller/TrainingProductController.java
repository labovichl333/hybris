package org.training.controller;

import de.hybris.platform.catalog.CatalogService;
import de.hybris.platform.core.model.product.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.service.TrainingProductService;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/trainingProduct")
public class TrainingProductController {
    @Resource
    private CatalogService catalogService;
    @Resource
    private TrainingProductService trainingProductService;


    @GetMapping
    public String showPage(@RequestParam(required = false) String code, Model model) {
        catalogService.setSessionCatalogVersion("electronicsProductCatalog", "Online");

        ProductModel product = null;
        if (code != null) {
            product = trainingProductService.getProductForCode(code);
        }
        model.addAttribute("product", product);
        return "trainingProduct";
    }
}
