package com.musahalilecer.customerservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "country")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String countryName;
    private String countryCode;
    private String countryFlag;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
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

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Customer> customers;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities;
}

