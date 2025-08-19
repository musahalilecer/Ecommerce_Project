package com.musahalilecer.customerservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CityRequest {
    @NotBlank
    private String cityName;

    public List<Integer> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(List<Integer> customerIds) {
        this.customerIds = customerIds;
    }

    public @NotNull Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(@NotNull Integer countryId) {
        this.countryId = countryId;
    }

    public @NotBlank String getCityName() {
        return cityName;
    }

    public void setCityName(@NotBlank String cityName) {
        this.cityName = cityName;
    }

    @NotNull
    private Integer countryId;

    private List<Integer> customerIds;
}
