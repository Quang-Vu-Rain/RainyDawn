package com.store.rainydawn.API;

import com.store.rainydawn.entity.Categories;
import com.store.rainydawn.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryAPI {
    private CategoryService categoryService;

    public CategoryAPI(CategoryService categoryService) {
        super();
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Categories> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("{id}")
    public ResponseEntity<Categories> getCategoryById(@PathVariable("id") int id) {
        return new ResponseEntity<Categories>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Categories> saveCategory(@RequestBody Categories category) {
        return new ResponseEntity<Categories>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }

    @PostMapping("{id}")
    public ResponseEntity<Categories> updateCategory(@RequestBody Categories category, @PathVariable("id") int id) {
        return new ResponseEntity<Categories>(categoryService.updateCategory(category, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<String>("Category deleted successfully!", HttpStatus.OK);
    }
}
