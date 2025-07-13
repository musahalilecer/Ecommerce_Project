package com.musahalilecer.customerservice.controller;

import com.musahalilecer.customerservice.dto.request.CountryRequest;
import com.musahalilecer.customerservice.dto.response.CountryResponse;
import com.musahalilecer.customerservice.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryResponse>> getAllCountries(){
        List<CountryResponse> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryResponse> getCountryById(@PathVariable int id){
        var country = countryService.getCountryById(id);
        return ResponseEntity.ok(country);
    }

    @PostMapping
    public ResponseEntity<CountryResponse> create(@Valid @RequestBody CountryRequest request) {
        CountryResponse created = countryService.createCountry(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryResponse> update(@PathVariable int id,
                                                  @Valid @RequestBody CountryRequest request) {
        CountryResponse updated = countryService.updateCountry(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable int id){
        countryService.deleteCountry(id);
    }
}
