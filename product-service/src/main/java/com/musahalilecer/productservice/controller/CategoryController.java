package com.musahalilecer.productservice.controller;

import com.musahalilecer.productservice.dto.request.CategoryRequest;
import com.musahalilecer.productservice.dto.response.BrandResponse;
import com.musahalilecer.productservice.dto.response.CategoryResponse;
import com.musahalilecer.productservice.exception.NotFoundException;
import com.musahalilecer.productservice.model.Category;
import com.musahalilecer.productservice.service.service.CategoryService;
import com.musahalilecer.productservice.service.service_imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable int id) {
        CategoryResponse category = categoryService.getCategoryById(id);
        if (category == null) throw new NotFoundException("Category not found");
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest request) {
        return ResponseEntity.ok(categoryService.addCategory(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable int id, @RequestBody CategoryRequest request) {
        CategoryResponse existing = categoryService.getCategoryById(id);
        if (existing == null) throw new NotFoundException("Category not found");
        return ResponseEntity.ok(categoryService.updateCategory(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
