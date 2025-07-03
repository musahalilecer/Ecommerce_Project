package com.musahalilecer.customerservice.mapper;

import com.musahalilecer.customerservice.dto.request.CountryRequest;
import com.musahalilecer.customerservice.dto.response.CountryResponse;
import com.musahalilecer.customerservice.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    // Entity yaratılırken ilişki alanları servis katmanında set edilecek
    @Mapping(target = "customers", ignore = true)
    @Mapping(target = "cities", ignore = true)
    Country toEntity(CountryRequest request);

    // Response DTO oluşturulurken ID listeleri servis katmanında eklenecek
    @Mapping(target = "customerIds", ignore = true)
    @Mapping(target = "cityIds",     ignore = true)
    CountryResponse toResponse(Country country);
}
