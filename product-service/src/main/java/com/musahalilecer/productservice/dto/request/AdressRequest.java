package com.musahalilecer.productservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdressRequest {
    private String adressLocation;
    private Integer countryId;
}
