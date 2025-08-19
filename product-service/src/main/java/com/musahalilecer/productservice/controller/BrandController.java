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
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public ResponseEntity<List<BrandResponse>> getAll() {
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> getById(@PathVariable int id) {
        BrandResponse brand = brandService.getBrandById(id);
        if (brand == null) throw new NotFoundException("Brand not found");
        return ResponseEntity.ok(brand);
    }

    @PostMapping
    public ResponseEntity<BrandResponse> create(@RequestBody BrandRequest request) {
        return ResponseEntity.ok(brandService.addBrand(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandResponse> update(@PathVariable int id, @RequestBody BrandRequest request) {
        BrandResponse existing = brandService.getBrandById(id);
        if (existing == null) throw new NotFoundException("Brand not found");
        return ResponseEntity.ok(brandService.updateBrand(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        brandService.deleteBrand(id);
        return ResponseEntity.noContent().build();
    }
}
