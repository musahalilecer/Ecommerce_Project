package com.musahalilecer.productservice.mapper;

import com.musahalilecer.productservice.dto.request.ProductRequest;
import com.musahalilecer.productservice.dto.response.ProductResponse;
import com.musahalilecer.productservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "category", ignore = true)
    @Mapping(target = "brand", ignore = true)
    @Mapping(target = "adress", ignore = true)
    @Mapping(target = "cardItem", ignore = true)
    Product toEntity(ProductRequest productRequest);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "adress.id", target = "adressId")
    @Mapping(source = "cardItem.id", target = "cardId")
    ProductResponse toResponse(Product product);
}
