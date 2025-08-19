package com.musahalilecer.customerservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class CustomerRequest {
    public @NotBlank String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank String address) {
        this.address = address;
    }

    public @Email @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotBlank String email) {
        this.email = email;
    }

    public @NotBlank String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank String phone) {
        this.phone = phone;
    }

    public @NotBlank String getUserName() {
        return userName;
    }

    public void setUserName(@NotBlank String userName) {
        this.userName = userName;
    }

    public @NotBlank String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank String password) {
        this.password = password;
    }

    public @NotNull Integer getCityId() {
        return cityId;
    }

    public void setCityId(@NotNull Integer cityId) {
        this.cityId = cityId;
    }

    public @NotNull Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(@NotNull Integer countryId) {
        this.countryId = countryId;
    }

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
