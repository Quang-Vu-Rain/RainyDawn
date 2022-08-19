package com.store.rainydawn.service;

import com.store.rainydawn.entity.Categories;

import java.util.List;

public interface CategoryService {

    List<Categories> getAllCategory();
    Categories getCategoryById(int id);
    Categories saveCategory(Categories category);
    Categories updateCategory(Categories category, int id);
    void deleteCategory(int id);
}
