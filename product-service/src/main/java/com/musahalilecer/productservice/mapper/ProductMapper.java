package com.musahalilecer.productservice.mapper;

import com.musahalilecer.productservice.dto.request.ProductRequest;
import com.musahalilecer.productservice.dto.response.AdressResponse;
import com.musahalilecer.productservice.dto.response.BrandResponse;
import com.musahalilecer.productservice.dto.response.CategoryResponse;
import com.musahalilecer.productservice.dto.response.ProductResponse;
import com.musahalilecer.productservice.model.Brand;
import com.musahalilecer.productservice.model.Category;
import com.musahalilecer.productservice.model.Product;
import com.musahalilecer.productservice.service.service.CategoryService;
import com.musahalilecer.productservice.service.service_imp.AdressServiceImp;
import com.musahalilecer.productservice.service.service_imp.BrandServiceImp;
import com.musahalilecer.productservice.service.service_imp.CategoryServiceImp;

import java.util.Optional;

public class ProductMapper {

    public static ProductResponse toResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setBarcode(product.getBarcode());
        response.setAdressId(
                Optional.ofNullable(product.getAdress())
                        .map(adress -> adress.getId())
                        .orElse(null)
        );
        response.setCategoryId(
                Optional.ofNullable(product.getCategory())
                        .map(category -> category.getId())
                        .orElse(null)
        );
        response.setBrandId(
                Optional.ofNullable(product.getBrand())
                        .map(brand -> brand.getId())
                        .orElse(null)
        );
        return response;
    }

    public static Product toEntity(ProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setBarcode(request.getBarcode());
        return product;
    }
}
    /*
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

     */
