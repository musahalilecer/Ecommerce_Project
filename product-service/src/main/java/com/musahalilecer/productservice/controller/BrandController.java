package com.musahalilecer.productservice.controller;

import com.musahalilecer.productservice.dto.request.BrandRequest;
import com.musahalilecer.productservice.dto.response.BrandResponse;
import com.musahalilecer.productservice.exception.NotFoundException;
import com.musahalilecer.productservice.service.service.BrandService;
import com.musahalilecer.productservice.service.service_imp.BrandServiceImp;
import jakarta.ws.rs.InternalServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandServiceImp brandService;

    @GetMapping
    public ResponseEntity<List<BrandResponse>> getAllBrands() {
        try{
            if(brandService.getAllBrands().isEmpty()) {
                throw new NotFoundException("No Found");
            }
            List<BrandResponse> brands = brandService.getAllBrands();
            return ResponseEntity.ok(brands);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> getBrandById(@PathVariable int id) {
        try{
            BrandResponse brand = brandService.getBrandById(id);
            if(brandService.getBrandById(id) == null) {
                throw new NotFoundException("No Found");
            }
            return ResponseEntity.ok(brand);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }
    @PostMapping
    public ResponseEntity<BrandResponse> createBrand(@RequestBody BrandRequest brandRequest) {
        try{
            BrandResponse newBrand = brandService.addBrand(brandRequest);
            return ResponseEntity.ok(newBrand);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandResponse> updateBrand(@PathVariable int id, @RequestBody BrandRequest brandRequest) {
        try{
            if(brandService.getBrandById(id) == null) {
                throw new NotFoundException("No Found");
            }
            BrandResponse updatedBrand = brandService.updateBrand(brandRequest, id);
            return ResponseEntity.ok(updatedBrand);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping("/{id}")
    public void deleteBrand(@PathVariable int id) {
        try{
            if(brandService.getBrandById(id) == null) {
                throw new NotFoundException("No Found");
            }
            brandService.deleteBrand(id);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new InternalServerErrorException("Internal Server Error");
        }
    }
}
