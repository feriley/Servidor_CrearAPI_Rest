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
        return productRepo.findByproductNameAndEmail(productName, productPrice);
    }

    @Override
    public void saveProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public void updateProduct(Long id, Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

}