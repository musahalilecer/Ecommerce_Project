package com.musahalilecer.customerservice.dto.request;

import com.musahalilecer.customerservice.model.Customer;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class CountryRequest {
    @NotBlank
    private String countryName;

    public List<Integer> getCityIds() {
        return cityIds;
    }

    public void setCityIds(List<Integer> cityIds) {
        this.cityIds = cityIds;
    }

    public List<Integer> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(List<Integer> customerIds) {
        this.customerIds = customerIds;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }

    public @NotBlank String getCountryName() {
        return countryName;
    }

    public void setCountryName(@NotBlank String countryName) {
        this.countryName = countryName;
    }

    private String countryCode;
    private String countryFlag;

    private List<Integer> customerIds;
    private List<Integer> cityIds;
}
