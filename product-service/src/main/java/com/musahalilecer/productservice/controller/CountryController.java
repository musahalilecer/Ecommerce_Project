package com.musahalilecer.productservice.controller;

import com.musahalilecer.productservice.dto.request.CountryRequest;
import com.musahalilecer.productservice.dto.response.CountryResponse;
import com.musahalilecer.productservice.exception.NotFoundException;
import com.musahalilecer.productservice.service.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryResponse>> getAll() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryResponse> getById(@PathVariable int id) {
        CountryResponse country = countryService.getCountryById(id);
        if (country == null) throw new NotFoundException("Country not found");
        return ResponseEntity.ok(country);
    }

    @PostMapping
    public ResponseEntity<CountryResponse> create(@RequestBody CountryRequest request) {
        return ResponseEntity.ok(countryService.addCountry(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryResponse> update(@PathVariable int id, @RequestBody CountryRequest request) {
        return ResponseEntity.ok(countryService.updateCountry(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        countryService.deleteCountry(id);
        return ResponseEntity.noContent().build();
    }
}
