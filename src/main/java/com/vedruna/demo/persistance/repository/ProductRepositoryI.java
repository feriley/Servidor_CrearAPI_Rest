package com.vedruna.demo.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.demo.persistance.models.Product;


@Repository
public interface ProductRepositoryI extends JpaRepository<Product, Long>{
    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    Product findByProductName(String productName);
    Product findByProductPrice(double productPrice);
    Product findByproductNameAndEmail(String productName, double productPrice);
}
