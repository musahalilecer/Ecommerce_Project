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
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImp categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        try{
            if(categoryService.getAllCategories().isEmpty()){
                throw new NotFoundException("Category not found");
            }
            List<CategoryResponse> categoryResponseList = categoryService.getAllCategories();
            return ResponseEntity.ok(categoryResponseList);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable int id) {
        try{
            if(categoryService.getCategoryById(id) == null){
                throw new NotFoundException("Category not found");
            }
            CategoryResponse categoryResponse = categoryService.getCategoryById(id);
            return ResponseEntity.ok(categoryResponse);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }
    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {
        try{
            CategoryResponse createdCategory = categoryService.addCategory(categoryRequest);
            return ResponseEntity.ok(createdCategory);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable int id, @RequestBody CategoryRequest categoryRequest) {
        try{
            if(categoryService.getCategoryById(id) == null){
                throw new NotFoundException("Category not found");
            }
            CategoryResponse updatedCategory = categoryService.updateCategory(id, categoryRequest);
            return ResponseEntity.ok(updatedCategory);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id) {
        try{
            if(categoryService.getCategoryById(id) == null){
                throw new NotFoundException("Category not found");
            }
            categoryService.deleteCategory(id);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new NotFoundException("Internal Server Error");
        }
    }
}
