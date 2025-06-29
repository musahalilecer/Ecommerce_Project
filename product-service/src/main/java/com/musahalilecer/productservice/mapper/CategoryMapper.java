package com.musahalilecer.productservice.mapper;

import com.musahalilecer.productservice.dto.request.CategoryRequest;
import com.musahalilecer.productservice.dto.response.CategoryResponse;
import com.musahalilecer.productservice.model.Category;
import com.musahalilecer.productservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "products", ignore = true)
    Category toEntity(CategoryRequest request);

    @Mapping(source = "products", target = "productIds")
    CategoryResponse toResponse(Category category);

    default List<Integer> mapProductListToIds(List<Product> products) {
        if (products == null) return new ArrayList<>();
        return products.stream().map(Product::getId).toList();
    }
}
