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
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
        return countryRepository.findAll().stream()
                .map(country -> {
                    CountryResponse dto = countryMapper.toResponse(country);
                    List<Integer> cityIds = country.getCities() != null
                            ? country.getCities().stream().map(City::getId).collect(Collectors.toList())
                            : List.of();
                    dto.setCityIds(cityIds);
                    List<Integer> customerIds = country.getCustomers() != null
                            ? country.getCustomers().stream().map(Customer::getId).collect(Collectors.toList())
                            : List.of();
                    dto.setCustomerIds(customerIds);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public CountryResponse getCountryById(int id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found: " + id));
        CountryResponse dto = countryMapper.toResponse(country);
        List<Integer> cityIds = country.getCities() != null
                ? country.getCities().stream().map(City::getId).collect(Collectors.toList())
                : List.of();
        dto.setCityIds(cityIds);
        List<Integer> customerIds = country.getCustomers() != null
                ? country.getCustomers().stream().map(Customer::getId).collect(Collectors.toList())
                : List.of();
        dto.setCustomerIds(customerIds);
        return dto;
    }

    @Transactional
    public CountryResponse createCountry(CountryRequest request) {
        Country country = countryMapper.toEntity(request);
        if (request.getCityIds() != null) {
            List<City> cities = cityRepository.findAllById(request.getCityIds());
            country.setCities(cities);
        }
        if (request.getCustomerIds() != null) {
            List<Customer> customers = customerRepository.findAllById(request.getCustomerIds());
            country.setCustomers(customers);
        }
        Country saved = countryRepository.save(country);
        CountryResponse dto = countryMapper.toResponse(saved);
        List<Integer> cityIds = saved.getCities() != null
                ? saved.getCities().stream().map(City::getId).collect(Collectors.toList())
                : List.of();
        dto.setCityIds(cityIds);
        List<Integer> customerIds = saved.getCustomers() != null
                ? saved.getCustomers().stream().map(Customer::getId).collect(Collectors.toList())
                : List.of();
        dto.setCustomerIds(customerIds);
        return dto;
    }

    @Transactional
    public CountryResponse updateCountry(int id, CountryRequest request) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found: " + id));
        country.setCountryName(request.getCountryName());
        country.setCountryCode(request.getCountryCode());
        country.setCountryFlag(request.getCountryFlag());
        if (request.getCityIds() != null) {
            List<City> cities = cityRepository.findAllById(request.getCityIds());
            country.setCities(cities);
        }
        if (request.getCustomerIds() != null) {
            List<Customer> customers = customerRepository.findAllById(request.getCustomerIds());
            country.setCustomers(customers);
        }
        Country saved = countryRepository.save(country);
        CountryResponse dto = countryMapper.toResponse(saved);
        List<Integer> cityIds = saved.getCities() != null
                ? saved.getCities().stream().map(City::getId).collect(Collectors.toList())
                : List.of();
        dto.setCityIds(cityIds);
        List<Integer> customerIds = saved.getCustomers() != null
                ? saved.getCustomers().stream().map(Customer::getId).collect(Collectors.toList())
                : List.of();
        dto.setCustomerIds(customerIds);
        return dto;
    }

    @Transactional
    public void deleteCountry(int id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found: " + id));
        countryRepository.delete(country);
    }
}
