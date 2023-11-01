package com.ra.serviceImp;

import com.ra.model.Categories;
import com.ra.model.Product;
import com.ra.repository.CategoriesRepository;
import com.ra.repository.ProductRepository;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByName(String productName) {
        return productRepository.findByName(productName);
    }

    @Override
    public boolean save(Product product) {
        return productRepository.save(product);
    }
}
