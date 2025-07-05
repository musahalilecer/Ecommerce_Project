package com.musahalilecer.productservice.dto.request;

import lombok.*;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandRequest {

    private String brandName;
    private Integer categoryId;
    private List<Integer> productIds;
}
