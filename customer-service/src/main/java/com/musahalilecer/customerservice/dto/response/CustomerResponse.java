package com.musahalilecer.customerservice.dto.response;

import com.musahalilecer.customerservice.model.City;
import com.musahalilecer.customerservice.model.Country;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class CustomerResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private String userName;

    private Integer cityId;
    private String cityName;
    private Integer countryId;
    private String countryName;
}
