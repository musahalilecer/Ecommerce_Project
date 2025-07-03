package com.musahalilecer.customerservice.service;

import com.musahalilecer.customerservice.dto.request.CityRequest;
import com.musahalilecer.customerservice.dto.response.CityResponse;
import com.musahalilecer.customerservice.mapper.CityMapper;
import com.musahalilecer.customerservice.model.City;
import com.musahalilecer.customerservice.model.Country;
import com.musahalilecer.customerservice.model.Customer;
import com.musahalilecer.customerservice.repository.CityRepository;
import com.musahalilecer.customerservice.repository.CountryRepository;
import com.musahalilecer.customerservice.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CountryRepository countryRepository;

    public List<CityResponse> getAllCities() {
        List<City> cities = cityRepository.findAll();
        return cities.stream().map(cityMapper::toResponse)
                .collect(Collectors.toList());
    }
    public CityResponse getCityById(int id) {
        City city = cityRepository.findById(id).orElseThrow(() -> new NotFoundException("City not found"));
        return cityMapper.toResponse(city);
    }

    @Transactional
    public CityResponse createCity(CityRequest request) {
        City city = cityMapper.toEntity(request);
        Country country = countryRepository.findById(request.getCountryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found"));
        city.setCountry(country);
        if (request.getCustomerIds() != null) {
            List<Customer> custs = customerRepository.findAllById(request.getCustomerIds());
            city.setCustomers(custs);
        }
        City saved = cityRepository.save(city);
        CityResponse dto = cityMapper.toResponse(saved);
        dto.setCustomerIds(saved.getCustomers().stream().map(Customer::getId).toList());
        return dto;
    }

    @Transactional
    public CityResponse updateCity(int id, CityRequest request) {
        City city = cityRepository.findById(id).orElseThrow(() -> new NotFoundException("City not found"));
        Country country = countryRepository.findById(request.getCountryId()).orElseThrow(() -> new NotFoundException("Country not found"));
        List<Customer> customers = customerRepository.findAllById(request.getCustomerIds());
        city.setCityName(request.getCityName());
        city.setCountry(country);
        city.setCustomers(customers);
        City savedCity = cityRepository.save(city);
        return cityMapper.toResponse(savedCity);
    }

    @Transactional
    public void deleteCity(int id) {
        cityRepository.deleteById(id);
    }
}
