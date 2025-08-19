package com.musahalilecer.productservice.mapper;

import com.musahalilecer.productservice.dto.request.BrandRequest;
import com.musahalilecer.productservice.dto.response.BrandResponse;
import com.musahalilecer.productservice.dto.response.CategoryResponse;
import com.musahalilecer.productservice.model.Brand;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BrandMapper {

    public static Brand toEntity(BrandRequest req) {
        Brand brand = new Brand();
        brand.setBrandName(req.getBrandName());
        return brand;
    }

    public static BrandResponse toResponse(Brand brand) {
        BrandResponse response = new BrandResponse();
        response.setId(brand.getId());
        response.setBrandName(brand.getBrandName());
        response.setCategoryId(
                Optional.ofNullable(brand.getCategory())
                        .map(category -> category.getId())
                        .orElse(null)
        );
        response.setProductIds(
                Optional.ofNullable(brand.getProducts())
                        .map(products -> products.stream()
                                .map(product -> product.getId())
                                .collect(Collectors.toList()))
                        .orElse(List.of())
        );
        return response;
    }
}
