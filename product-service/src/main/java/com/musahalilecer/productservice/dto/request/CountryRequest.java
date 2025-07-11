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

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<Integer> getAdressIds() {
        return adressIds;
    }

    public void setAdressIds(List<Integer> adressIds) {
        this.adressIds = adressIds;
    }

    private String countryName;
    private String flag;

    private List<Integer> adressIds;
}
