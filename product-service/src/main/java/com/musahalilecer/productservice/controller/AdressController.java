package com.musahalilecer.productservice.controller;

import com.musahalilecer.productservice.dto.request.AdressRequest;
import com.musahalilecer.productservice.dto.response.AdressResponse;
import com.musahalilecer.productservice.exception.NotFoundException;
import com.musahalilecer.productservice.service.service.AdressService;
import com.musahalilecer.productservice.service.service_imp.AdressServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AdressController {

    @Autowired
    private AdressService adressService;

    @GetMapping
    public ResponseEntity<List<AdressResponse>> getAll() {
        return ResponseEntity.ok(adressService.getAllAdresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdressResponse> getById(@PathVariable int id) {
        AdressResponse adres = adressService.getAdressById(id);
        if (adres == null) throw new NotFoundException("Adress not found");
        return ResponseEntity.ok(adres);
    }

    @PostMapping
    public ResponseEntity<AdressResponse> create(@RequestBody AdressRequest request) {
        return ResponseEntity.ok(adressService.addAdress(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdressResponse> update(@PathVariable int id, @RequestBody AdressRequest request) {
        AdressResponse existing = adressService.getAdressById(id);
        if (existing == null) throw new NotFoundException("Adress not found");
        return ResponseEntity.ok(adressService.updateAdress(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        adressService.deleteAdress(id);
        return ResponseEntity.noContent().build();
    }
}

