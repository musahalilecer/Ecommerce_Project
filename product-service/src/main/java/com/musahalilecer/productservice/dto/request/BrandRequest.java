package com.musahalilecer.productservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandRequest {
    private String brandName;
    private Integer categoryId;
    private List<Integer> productIds;
}
