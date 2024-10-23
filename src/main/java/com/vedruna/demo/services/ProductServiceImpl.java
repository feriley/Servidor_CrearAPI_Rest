package com.vedruna.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.demo.persistance.models.Product;
import com.vedruna.demo.persistance.repository.ProductRepositoryI;
@Service
public class ProductServiceImpl implements ProductServiceI {
    
    @Autowired
    ProductRepositoryI productRepo;

    @Override
    public List<Product> showAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product showProductByProductName(String productName) {
        return productRepo.findByProductName(productName);
    }

    @Override
    public Product showProductByProductPrice(double productPrice) {
        return productRepo.findByProductPrice(productPrice);
    }

    @Override
    public Product showProductByProductNameAndProductPrice(String productName, double productPrice) {
        return productRepo.findByProductNameAndProductPrice(productName, productPrice); 
    }

    @Override
    public void saveProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public void updateProduct(Long id, Product product) {
        if (productRepo.existsById(id)) { 
            product.setProductId(id); 
            productRepo.save(product);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        if (productRepo.existsById(id)) { 
            productRepo.deleteById(id);
        }
    }
}
