package com.musahalilecer.productservice.dto.request;

import lombok.*;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryRequest {

    private String countryName;
    private String flag;

    private List<Integer> adressIds;
}
