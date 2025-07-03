package com.musahalilecer.customerservice.dto.request;

import com.musahalilecer.customerservice.model.Customer;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class CountryRequest {
    @NotBlank
    private String countryName;

    private String countryCode;
    private String countryFlag;

    private List<Integer> customerIds;
    private List<Integer> cityIds;
}
