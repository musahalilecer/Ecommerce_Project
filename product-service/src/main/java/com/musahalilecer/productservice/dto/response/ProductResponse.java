package com.musahalilecer.productservice.dto.response;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
