package com.musahalilecer.productservice.dto.response;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdressResponse {

    private Integer id;
    private String adressLocation;
    private Integer countryId;
}
