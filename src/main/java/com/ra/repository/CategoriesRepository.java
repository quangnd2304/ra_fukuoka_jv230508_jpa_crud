package com.ra.repository;

import com.ra.model.Categories;

import java.util.List;

public interface CategoriesRepository {
    List<Categories> findAll();
    Categories findById(int catalogId);
    boolean save(Categories catalog);
    boolean update(Categories catalog);
    boolean delete(int catalogId);
}
