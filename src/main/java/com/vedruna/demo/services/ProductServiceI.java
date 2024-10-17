package com.vedruna.demo.services;

import java.util.List;

import com.vedruna.demo.persistance.models.Product;

public interface ProductServiceI {

    List<Product>showAllProducts();
    Product showProductByProductName(String productName);
    Product showProductByProductPrice(double productPrice);
    Product showProductByProductNameAndProductPrice(String productName, double productPrice);
    void saveProduct(Product product);
    void deleteProduct(Long id);
    void updateProduct(Long id, Product product);

} 
