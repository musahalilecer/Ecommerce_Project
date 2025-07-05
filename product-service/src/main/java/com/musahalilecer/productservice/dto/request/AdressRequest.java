package com.musahalilecer.productservice.dto.request;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdressRequest {

    private String adressLocation;
    private Integer countryId;
}
