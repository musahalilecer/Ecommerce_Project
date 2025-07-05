package com.musahalilecer.productservice.dto.response;

import lombok.*;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {
    private Integer id;
    private String categoryName;

    private List<Integer> productIds;
}
