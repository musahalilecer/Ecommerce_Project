package com.musahalilecer.productservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryRequest {
    private String countryName;
    private String flag;

    private List<Integer> adressIds;
}
