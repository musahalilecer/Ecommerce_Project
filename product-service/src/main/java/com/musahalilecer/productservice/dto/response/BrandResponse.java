package com.musahalilecer.productservice.dto.response;

import lombok.*;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandResponse {

    private Integer id;
    private String brandName;
    private Integer categoryId;
    private List<Integer> productIds;
}
