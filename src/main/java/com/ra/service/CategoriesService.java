package com.ra.service;

import com.ra.model.Categories;

import java.util.List;

public interface CategoriesService {
    List<Categories> findAll();
    Categories findById(int catalogId);
    boolean save(Categories catalog);
    boolean update(Categories catalog);
    boolean delete(int catalogId);
}
