package com.musahalilecer.productservice.mapper;

import com.musahalilecer.productservice.dto.request.CountryRequest;
import com.musahalilecer.productservice.dto.response.CountryResponse;
import com.musahalilecer.productservice.model.Adress;
import com.musahalilecer.productservice.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    @Mapping(target = "adresses", ignore = true)
    Country toEntity(CountryRequest request);

    @Mapping(source = "adresses", target = "adressIds")
    CountryResponse toResponse(Country country);

    default List<Integer> mapAdressListToIds(List<Adress> adresses) {
        if (adresses == null) return new ArrayList<>();
        return adresses.stream().map(Adress::getId).toList();
    }
}
