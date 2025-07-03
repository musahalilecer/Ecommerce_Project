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
@RequestMapping("/adres")
public class AdressController {

    @Autowired
    private AdressServiceImp adressService;

    @GetMapping
    public ResponseEntity<List<AdressResponse>> getAllAdresses() {
        try{
            if(adressService.getAllAdresses().isEmpty()){
                throw new NotFoundException("No adresses found");
            }
            List<AdressResponse> adresses = adressService.getAllAdresses();
            return ResponseEntity.ok(adresses);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdressResponse> getAdressById(@PathVariable int id) {
        try{
            AdressResponse adres = adressService.getAdressById(id);
            if(adres == null){
                throw new NotFoundException("Adress not found");
            }
            return ResponseEntity.ok(adres);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }
    @PostMapping
    public ResponseEntity<AdressResponse> addAdress(@RequestBody AdressRequest adressRequest) {
        try{
            AdressResponse adres = adressService.addAdress(adressRequest);
            return ResponseEntity.ok(adres);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<AdressResponse> updateAdress(@PathVariable int id, @RequestBody AdressRequest adressRequest) {
        try{
            AdressResponse foundAdres = adressService.getAdressById(id);
            if(foundAdres == null){
                throw new NotFoundException("Adress not found");
            }
            return ResponseEntity.ok(adressService.updateAdress(id, adressRequest));
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping("/{id}")
    public void deleteAdress(@PathVariable int id) {
        try{
            adressService.deleteAdress(id);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new NotFoundException("Adress not found");
        }
    }
}
