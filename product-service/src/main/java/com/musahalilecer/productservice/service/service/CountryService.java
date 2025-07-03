package com.musahalilecer.productservice.service.service;

import com.musahalilecer.productservice.dto.request.CountryRequest;
import com.musahalilecer.productservice.dto.response.CountryResponse;

import java.util.List;

public interface CountryService {
    List<CountryResponse> getAllCountries();
    CountryResponse getCountryById(int id);
    CountryResponse addCountry(CountryRequest countryRequest);
    CountryResponse updateCountry(int id, CountryRequest countryRequest);
    CountryResponse deleteCountry(int id);
}
