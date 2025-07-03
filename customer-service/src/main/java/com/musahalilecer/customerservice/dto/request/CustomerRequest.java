package com.musahalilecer.customerservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class CustomerRequest {
    @NotBlank private String firstName;
    @NotBlank private String lastName;
    @Email @NotBlank private String email;
    @NotBlank private String address;
    @NotBlank private String phone;
    @NotBlank private String userName;
    @NotBlank private String password;

    @NotNull private Integer cityId;
    @NotNull private Integer countryId;
}
