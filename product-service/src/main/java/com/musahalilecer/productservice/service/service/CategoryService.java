package com.musahalilecer.productservice.service.service;

import com.musahalilecer.productservice.dto.request.CategoryRequest;
import com.musahalilecer.productservice.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();
    CategoryResponse getCategoryById(int id);
    CategoryResponse addCategory(CategoryRequest categoryRequest);
    CategoryResponse updateCategory(int id, CategoryRequest categoryRequest);
    void deleteCategory(int id);
}
