package com.musahalilecer.productservice.mapper;

import com.musahalilecer.productservice.dto.request.BrandRequest;
import com.musahalilecer.productservice.dto.response.BrandResponse;
import com.musahalilecer.productservice.model.Brand;
import com.musahalilecer.productservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "products", ignore = true)
    Brand toEntity(BrandRequest request);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "products", target = "productIds")
    BrandResponse toResponse(Brand brand);

    default List<Integer> mapProductListToIds(List<Product> products) {
        if (products == null) return new ArrayList<>();
        return products.stream().map(Product::getId).toList();
    }
}
