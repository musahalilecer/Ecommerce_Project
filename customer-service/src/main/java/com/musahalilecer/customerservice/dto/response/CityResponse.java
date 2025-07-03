package com.musahalilecer.customerservice.dto.response;

import com.musahalilecer.customerservice.model.Customer;
import lombok.Data;

import java.util.List;

@Data
public class CityResponse {
    private Integer id;
    private String cityName;

    private Integer countryId;
    private String countryName;

    private List<Integer> customerIds;
}
