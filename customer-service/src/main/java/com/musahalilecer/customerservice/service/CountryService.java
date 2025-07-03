package com.musahalilecer.customerservice.service;

import com.musahalilecer.customerservice.dto.request.CountryRequest;
import com.musahalilecer.customerservice.dto.response.CountryResponse;
import com.musahalilecer.customerservice.mapper.CountryMapper;
import com.musahalilecer.customerservice.model.City;
import com.musahalilecer.customerservice.model.Country;
import com.musahalilecer.customerservice.model.Customer;
import com.musahalilecer.customerservice.repository.CityRepository;
import com.musahalilecer.customerservice.repository.CountryRepository;
import com.musahalilecer.customerservice.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CountryMapper countryMapper;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public List<CountryResponse> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        return countries.stream()
                .map(countryMapper::toResponse)
                .collect(Collectors.toList());
    }

    public CountryResponse getCountryById(int id) {
        var country = countryRepository.findById(id).orElseThrow(() -> new NotFoundException("Country not found"));
        return countryMapper.toResponse(country);
    }

    @Transactional
    public CountryResponse createCountry(CountryRequest countryRequest) {
        Country newCountry = countryMapper.toEntity(countryRequest);
        if(countryRequest.getCityIds() != null) {
            List<City> cities = cityRepository.findAllById(countryRequest.getCityIds());
            newCountry.setCities(cities);
        }
        if(countryRequest.getCustomerIds() != null) {
            List<Customer> customers = customerRepository.findAllById(countryRequest.getCustomerIds());
            newCountry.setCustomers(customers);
        }
        Country savedCountry = countryRepository.save(newCountry);
        CountryResponse response = countryMapper.toResponse(savedCountry);
        response.setCustomerIds(savedCountry.getCustomers().stream().map(Customer::getId).collect(Collectors.toList()));
        response.setCityIds(savedCountry.getCities().stream().map(City::getId).collect(Collectors.toList()));
        return response;
    }


}
