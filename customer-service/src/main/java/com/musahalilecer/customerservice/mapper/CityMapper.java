package com.musahalilecer.customerservice.mapper;

import com.musahalilecer.customerservice.dto.request.CityRequest;
import com.musahalilecer.customerservice.dto.response.CityResponse;
import com.musahalilecer.customerservice.model.City;
import com.musahalilecer.customerservice.model.Country;
import com.musahalilecer.customerservice.model.Customer;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mapping(target = "country", ignore = true)
    @Mapping(target = "customers", ignore = true)
    City toEntity(CityRequest request);

    @Mapping(source = "country.id", target = "countryId")
    @Mapping(source = "country.cityName", target = "countryName")
    @Mapping(target = "customerIds", ignore = true)
    CityResponse toResponse(City city);


    default Integer map(Customer customer) {
        return (customer == null) ? null : customer.getId();
    }

    /**
     * Converts a list of Customer entities to a list of their IDs.
     */
    default List<Integer> mapCustomerListToIds(List<Customer> customers) {
        if (customers == null || customers.isEmpty()) {
            return Collections.emptyList();
        }
        return customers.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}


// Önemli

/*
@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mapping(target = "country", ignore = true)
    @Mapping(target = "customers", ignore = true)
    City toEntity(CityRequest request);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "cityName", target = "cityName")
    @Mapping(source = "country.id", target = "countryId")
    @Mapping(source = "country.countryName", target = "countryName")
    // customerIds will be populated in Service
    @Mapping(target = "customerIds", ignore = true)
    CityResponse toResponse(City city);
}
 */
