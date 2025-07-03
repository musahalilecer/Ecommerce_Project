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
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryResponse>> getAllCountries() {
        try{
            List<CountryResponse> list = countryService.getAllCountries();
            if(list.isEmpty()){
                throw new NotFoundException("Not Found");
            }

            return ResponseEntity.ok(list);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<CountryResponse> getCountryById(@PathVariable int id){
        try{
            CountryResponse findCountry = countryService.getCountryById(id);
            if(findCountry == null){
                throw new NotFoundException("Not Found");
            }
            return ResponseEntity.ok(findCountry);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping
    public ResponseEntity<CountryResponse> createCountry(@RequestBody CountryRequest countryRequest){
        try{
            CountryResponse newCountry = countryService.addCountry(countryRequest);
            return ResponseEntity.ok(newCountry);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<CountryResponse> updateCountry(@PathVariable int id, @RequestBody CountryRequest countryRequest){
        try{
            CountryResponse updatedCountry = countryService.updateCountry(id, countryRequest);
            return ResponseEntity.ok(updatedCountry);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/id")
    public void deleteCountry(@PathVariable int id){
        try{
            countryService.deleteCountry(id);
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }
}
