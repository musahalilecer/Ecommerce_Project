package com.musahalilecer.productservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String barcode;

    private Integer categoryId;
    private Integer brandId;
    private Integer adressId;
    private Integer cardId;
}
