package com.musahalilecer.productservice.controller;

import com.musahalilecer.productservice.dto.request.ProductRequest;
import com.musahalilecer.productservice.dto.response.ProductResponse;
import com.musahalilecer.productservice.exception.NotFoundException;
import com.musahalilecer.productservice.model.Product;
import com.musahalilecer.productservice.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll() {
        List<ProductResponse> list = productService.getProducts();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable int id) {
        ProductResponse product = productService.getProductById(id);
        if (product == null) throw new NotFoundException("Product not found");
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.addProduct(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable int id, @RequestBody ProductRequest request) {
        ProductResponse existing = productService.getProductById(id);
        if (existing == null) throw new NotFoundException("Product not found");
        return ResponseEntity.ok(productService.updateProduct(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        ProductResponse existing = productService.getProductById(id);
        if (existing == null) throw new NotFoundException("Product not found");
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

