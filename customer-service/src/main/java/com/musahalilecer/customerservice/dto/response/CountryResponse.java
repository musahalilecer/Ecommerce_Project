package com.musahalilecer.customerservice.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class CountryResponse {
    private Integer id;
    private String countryName;
    private String countryCode;
    private String countryFlag;

    private List<Integer> customerIds;
    private List<Integer> cityIds;
}
