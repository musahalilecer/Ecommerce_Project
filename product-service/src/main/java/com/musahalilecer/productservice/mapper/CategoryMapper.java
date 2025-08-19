package com.musahalilecer.productservice.mapper;

import com.musahalilecer.productservice.dto.request.CategoryRequest;
import com.musahalilecer.productservice.dto.response.CategoryResponse;
import com.musahalilecer.productservice.model.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {
    public static Category toEntity(CategoryRequest req) {
        Category cat = new Category();
        cat.setCategoryName(req.getCategoryName());
        return cat;
    }

    public static CategoryResponse toResponse(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setCategoryName(category.getCategoryName());
        response.setProductIds(
                category.getProducts() != null ?
                category.getProducts().stream()
                        .map(product -> product.getId())
                        .collect(Collectors.toList()) :
                List.of()
        );
        return response;
    }
}
