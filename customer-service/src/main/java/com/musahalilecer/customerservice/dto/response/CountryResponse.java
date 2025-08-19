package com.musahalilecer.customerservice.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class CountryResponse {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<Integer> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(List<Integer> customerIds) {
        this.customerIds = customerIds;
    }

    public List<Integer> getCityIds() {
        return cityIds;
    }

    public void setCityIds(List<Integer> cityIds) {
        this.cityIds = cityIds;
    }

    private Integer id;
    private String countryName;
    private String countryCode;
    private String countryFlag;

    private List<Integer> customerIds;
    private List<Integer> cityIds;
}
