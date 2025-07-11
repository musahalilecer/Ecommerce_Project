package com.musahalilecer.productservice.dto.response;

import com.musahalilecer.productservice.model.Country;
import lombok.*;

@Data
@Builder
@Getter
@Setter
public class AdressResponse {

    public AdressResponse(String adressLocation, Country country) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getAdressLocation() {
        return adressLocation;
    }

    public void setAdressLocation(String adressLocation) {
        this.adressLocation = adressLocation;
    }

    private Integer id;
    private String adressLocation;
    private Integer countryId;
}
