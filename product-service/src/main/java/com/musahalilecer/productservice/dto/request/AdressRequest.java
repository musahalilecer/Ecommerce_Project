package com.musahalilecer.productservice.dto.request;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdressRequest {

    public String getAdressLocation() {
        return adressLocation;
    }

    public void setAdressLocation(String adressLocation) {
        this.adressLocation = adressLocation;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    private String adressLocation;
    private Integer countryId;
}
