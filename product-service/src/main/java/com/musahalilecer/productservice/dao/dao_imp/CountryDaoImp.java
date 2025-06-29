package com.musahalilecer.productservice.dao.dao_imp;

import com.musahalilecer.productservice.dao.dao_abstract.CategoryDao;
import com.musahalilecer.productservice.dao.dao_abstract.CountryDao;
import com.musahalilecer.productservice.model.Category;
import com.musahalilecer.productservice.model.Country;
import com.musahalilecer.productservice.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CountryDaoImp implements CountryDao {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        return countries;
    }

    @Override
    public Country getCountryById(int id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
        return country;
    }

    @Override
    @Transactional
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    @Transactional
    public Country updateCountry(Country country, int id) {
        getCountryById(id);
        return countryRepository.save(country);
    }

    @Override
    @Transactional
    public void deleteCountry(int id) {
        if(!countryRepository.existsById(id)) {
            throw new RuntimeException("Country not found");
        }
        countryRepository.deleteById(id);
    }
}
