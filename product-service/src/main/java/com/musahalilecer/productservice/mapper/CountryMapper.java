package com.musahalilecer.productservice.mapper;

import com.musahalilecer.productservice.dto.request.CountryRequest;
import com.musahalilecer.productservice.dto.response.CountryResponse;
import com.musahalilecer.productservice.model.Country;

import java.util.List;
import java.util.stream.Collectors;

public class CountryMapper {

    public static Country toEntity(CountryRequest req) {
        Country c = new Country();
        c.setCountryName(req.getCountryName());
        c.setFlag(req.getFlag());
        // adresses set in service layer
        return c;
    }

    public static CountryResponse toResponse(Country country) {
        CountryResponse.CountryResponseBuilder b = CountryResponse.builder()
                .id(country.getId())
                .countryName(country.getCountryName())
                .flag(country.getFlag());

        if (country.getAdresses() != null) {
            b.adressIds(
                    country.getAdresses().stream()
                            .map(a -> a.getId())
                            .collect(Collectors.toList())
            );
        }
        return b.build();
    }
}
