package com.musahalilecer.productservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdressResponse {
    private Integer id;
    private String adressLocation;
    private Integer countryId;
}
