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
        BrandResponse.BrandResponseBuilder b = BrandResponse.builder()
                .id(brand.getId())
                .brandName(brand.getBrandName());

        if (brand.getCategory() != null) {
            b.categoryId(brand.getCategory().getId());
        }
        if (brand.getProducts() != null) {
            b.productIds(
                    brand.getProducts().stream()
                            .map(p -> p.getId())
                            .collect(Collectors.toList())
            );
        }
        return b.build();
    }
}
