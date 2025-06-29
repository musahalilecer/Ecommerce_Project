package com.musahalilecer.productservice.mapper;

import com.musahalilecer.productservice.dto.request.AdressRequest;
import com.musahalilecer.productservice.dto.response.AdressResponse;
import com.musahalilecer.productservice.model.Adress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdressMapper {
    @Mapping(target = "country", ignore = true)
    Adress toEntity(AdressRequest adressRequest);

    @Mapping(source = "country.id", target = "countryId")
    AdressResponse toResponse(Adress adress);
}
