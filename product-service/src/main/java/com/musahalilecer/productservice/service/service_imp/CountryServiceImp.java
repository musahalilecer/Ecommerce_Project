package com.musahalilecer.productservice.service.service_imp;

import com.musahalilecer.productservice.dto.request.CountryRequest;
import com.musahalilecer.productservice.dto.response.CountryResponse;
import com.musahalilecer.productservice.service.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImp implements CountryService {
    @Override
    public List<CountryResponse> getAllCountries() {
        return List.of();
    }

    @Override
    public CountryResponse getCountryById(int id) {
        return null;
    }

    @Override
    public CountryResponse addCountry(CountryRequest countryRequest) {
        return null;
    }

    @Override
    public CountryResponse updateCountry(CountryRequest countryRequest) {
        return null;
    }

    @Override
    public CountryResponse deleteCountry(int id) {
        return null;
    }
}
