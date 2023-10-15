package com.example.worklikeelon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.worklikeelon.model.Product;


@Service
public class ProductService implements IProductService {
    @Override
    public List<Product> findAll() {
        //creating an object of ArrayList  
        ArrayList<Product> products = new ArrayList<Product>();
        //adding products to the List  
        products.add(new Product(100, "Mobile", "Samsung S20 FE", 9000.00));
        products.add(new Product(101, "Smart TV", "LG", 60000.00));
        products.add(new Product(102, "Washing Machine", "Botach", 9000.00));
        products.add(new Product(103, "Laptop", "Lenova", 24000.00));
        //returns a list of product  
        return products;
    }
}
