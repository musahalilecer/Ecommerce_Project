package com.musahalilecer.customerservice.mapper;

import com.musahalilecer.customerservice.dto.request.CustomerRequest;
import com.musahalilecer.customerservice.dto.response.CustomerResponse;
import com.musahalilecer.customerservice.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "city", ignore = true)
    @Mapping(target = "country", ignore = true)
    Customer toEntity(CustomerRequest dto);

    @Mapping(source = "city.id", target = "cityId")
    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "country.id", target = "countryId")
    @Mapping(source = "country.name", target = "countryName")
    CustomerResponse toResponse(Customer entity);
}


