package com.musahalilecer.productservice.dao.dao_abstract;

import com.musahalilecer.productservice.dto.request.CategoryRequest;
import com.musahalilecer.productservice.model.Category;

import java.util.List;

public interface CategoryDao<T> {
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    Category addCategory(Category category);
    Category updateCategory(Category category, int id);
    void deleteCategory(int id);
}
