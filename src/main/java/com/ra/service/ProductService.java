package com.ra.service;

import com.ra.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    List<Product> findByName(String productName);
    boolean save(Product product);
}
