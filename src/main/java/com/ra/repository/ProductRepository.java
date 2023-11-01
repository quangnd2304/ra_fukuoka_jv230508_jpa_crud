package com.ra.repository;

import com.ra.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    List<Product> findByName(String productName);
    boolean save(Product product);
}
