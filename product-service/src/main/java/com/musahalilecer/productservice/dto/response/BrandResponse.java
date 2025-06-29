package com.musahalilecer.productservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandResponse {
    private Integer id;
    private String brandName;
    private Integer categoryId;
    private List<Integer> productIds;
}
