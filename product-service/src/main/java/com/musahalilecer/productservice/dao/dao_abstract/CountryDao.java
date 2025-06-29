package com.musahalilecer.productservice.dao.dao_abstract;

import com.musahalilecer.productservice.model.Country;
import com.musahalilecer.productservice.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CountryDao {
    List<Country> getAllCountries();
    Country getCountryById(int id);
    Country addCountry(Country country);
    Country updateCountry(Country country, int id);
    void deleteCountry(int id);
}
