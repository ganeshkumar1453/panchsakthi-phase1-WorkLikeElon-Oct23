package com.example.worklikeelon.model;

public class Product {
    private int productId;
    private String productMainCategory;
    private String productName;
    private double price;

    public Product(int productId, String productMainCategory, String productName, double price) {
        super();
        this.productId = productId;
        this.productMainCategory = productMainCategory;
        this.productName = productName;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductMainCategory() {
        return productMainCategory;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

}
