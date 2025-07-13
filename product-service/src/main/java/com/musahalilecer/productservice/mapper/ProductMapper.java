package com.musahalilecer.productservice.mapper;

import com.musahalilecer.productservice.dto.request.ProductRequest;
import com.musahalilecer.productservice.dto.response.AdressResponse;
import com.musahalilecer.productservice.dto.response.BrandResponse;
import com.musahalilecer.productservice.dto.response.CategoryResponse;
import com.musahalilecer.productservice.dto.response.ProductResponse;
import com.musahalilecer.productservice.model.Product;

import java.util.Optional;

public class ProductMapper {

    public static Product toEntity(ProductRequest req) {
        Product product = new Product();
        product.setName(req.getName());
        product.setDescription(req.getDescription());
        product.setPrice(req.getPrice());
        product.setBarcode(req.getBarcode());
        // category, brand, adress, cardId should be set in service layer
        return product;
    }

    public static ProductResponse toResponse(Product product) {
        ProductResponse.ProductResponseBuilder b = ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .barcode(product.getBarcode());

        Optional.ofNullable(product.getCategory()).ifPresent(cat ->
                b.categoryId(cat.getId())
        );
        Optional.ofNullable(product.getBrand()).ifPresent(br ->
                b.brandId(br.getId())
        );
        Optional.ofNullable(product.getAdress()).ifPresent(ad ->
                b.adressId(ad.getId())
        );
        // cardId not available on entity
        return b.build();
    }

}
