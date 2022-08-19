package com.store.rainydawn.service.impl;

import com.store.rainydawn.dao.CategoryDAO;
import com.store.rainydawn.entity.Categories;
import com.store.rainydawn.exception.ResourceNotFoundException;
import com.store.rainydawn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO;

    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        super();
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<Categories> getAllCategory() {
        return categoryDAO.findAll();
    }

    @Override
    public Categories getCategoryById(int id) {
        return categoryDAO.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", id));
    }

    @Override
    public Categories saveCategory(Categories category) {
        return categoryDAO.save(category);
    }

    @Override
    public Categories updateCategory(Categories category, int id) {
        Categories existringCategory = categoryDAO.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", id));
        existringCategory.setName(category.getName());
        existringCategory.setProducts(category.getProducts());
        categoryDAO.save(existringCategory);
        return existringCategory;
    }

    @Override
    public void deleteCategory(int id) {
        categoryDAO.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", id));
        categoryDAO.deleteById(id);
    }
}
