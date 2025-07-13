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
        // products to be set in service layer
        return cat;
    }

    public static CategoryResponse toResponse(Category category) {
        CategoryResponse.CategoryResponseBuilder b = CategoryResponse.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName());

        if (category.getProducts() != null) {
            b.productIds(
                    category.getProducts().stream()
                            .map(p -> p.getId())
                            .collect(Collectors.toList())
            );
        }
        return b.build();
    }
}
