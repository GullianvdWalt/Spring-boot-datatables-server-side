package com.example.springbootdatatablesserverside.controllers;

import com.example.springbootdatatablesserverside.models.DataTableState;
import com.example.springbootdatatablesserverside.models.Product;
import com.example.springbootdatatablesserverside.services.DataTableStateService;
import com.example.springbootdatatablesserverside.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Gullian Van Der Walt
 * Created at 08:39 on Sep, 2021
 */
@Controller
public class ProductController {
    private final ProductService productService;
    private final DataTableStateService dataTableStateService;

    @Autowired
    public ProductController(ProductService productService, DataTableStateService dataTableStateService) {
        this.productService = productService;
        this.dataTableStateService = dataTableStateService;
    }

    @GetMapping(value = {"/products"})
    public ModelAndView getProductPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("products");
        model.addObject("state", dataTableStateService.getStateByProductId(productService.getProducts().get(0).getId()));
        return model;
    }

    @GetMapping("/products/get-products")
    @ResponseBody
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("/products/state_save")
    @ResponseBody
    public String saveTableState(@RequestParam("state") String state){
        Product product = productService.getProducts().get(0);
        DataTableState dataTableState = new DataTableState();
        if(product.getDataTableState() != null){
            dataTableState = product.getDataTableState();
        }
        dataTableState.setProduct(product);
        dataTableState.setStateJson(state);
        dataTableStateService.saveState(dataTableState);
        return "success";
    }

    @PostMapping("/products/state_load")
    @ResponseBody
    public String loadTableState(){
        DataTableState dataTableState = dataTableStateService.getDataTableStates().get(0);
        return dataTableState.getStateJson() != null ? dataTableState.getStateJson() : "";
    }
}
