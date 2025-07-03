package com.musahalilecer.customerservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CityRequest {
    @NotBlank
    private String cityName;

    @NotNull
    private Integer countryId;

    private List<Integer> customerIds;
}
