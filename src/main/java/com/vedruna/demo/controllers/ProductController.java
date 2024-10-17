package com.vedruna.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.demo.persistance.models.Product;
import com.vedruna.demo.services.ProductServiceI;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    
@Autowired
private ProductServiceI productMngmnt;
@GetMapping
    public List<Product> getAllProducts() {
        return productMngmnt.showAllProducts();
    }

@GetMapping("/name{productName}")
public Product showProductByProductName(@PathVariable String productName) {
    return productMngmnt.showProductByProductName(productName);
}

@GetMapping("/price{productPrice}")
public Product showProductByProductPrice(@PathVariable double productPrice) {
    return productMngmnt.showProductByProductPrice(productPrice);
}
@PostMapping("/insert")
public String postProduct(@RequestBody Product product) {
    productMngmnt.saveProduct(product);
    
    return "Product saved";
}

@PutMapping("edit/{id}")
public String editProduct(@PathVariable Long id, @RequestBody Product product) {
    productMngmnt.updateProduct(id, product);
    

    return "Product modified";
}


@DeleteMapping("delete/{id}")
public String deleteProduct(@PathVariable Long id) {
    productMngmnt.deleteProduct(id);
    return "Product deleted";
}




}
