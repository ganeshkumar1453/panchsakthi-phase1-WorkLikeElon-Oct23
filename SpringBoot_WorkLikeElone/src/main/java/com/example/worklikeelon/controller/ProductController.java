package com.example.worklikeelon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.worklikeelon.model.Product;
import com.example.worklikeelon.service.IProductService;


@RestController
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping(value = "/product")
    public List<Product> getProduct() {
        //Get all the products  
        List<Product> products = productService.findAll();
        //returns the product list  
        return products;
    }

    @GetMapping(value = "/testapi")
    public String testAPI() {
        return "API is successfully triggered";
    }
}
