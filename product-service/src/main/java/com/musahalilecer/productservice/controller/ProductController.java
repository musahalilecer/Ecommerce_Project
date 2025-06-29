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

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        if(productService.getProducts().isEmpty()){
            throw new NotFoundException("No products found");
        }
        List<ProductResponse> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(int id) {
        try{
            if(productService.getProductById(id) == null){
                throw new NotFoundException("No product found");
            }
            ProductResponse product = productService.getProductById(id);
            return ResponseEntity.ok(product);
        }
        catch(NotFoundException e){
            throw new NotFoundException("Error");
        }

    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        try{
            ProductResponse addPorduct = productService.addProduct(productRequest);
            return ResponseEntity.ok(addPorduct);
        }
        catch(NotFoundException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(int id, ProductRequest productRequest) {
        try{
            if(productService.getProductById(id) == null){
                throw new NotFoundException("No product found");
            }
            ProductResponse updateProduct = productService.updateProduct(id, productRequest);
            return ResponseEntity.ok(updateProduct);
        }
        catch (NotFoundException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        try{
            if(productService.getProductById(id) == null){
                throw new NotFoundException("No product found");
            }
            productService.getProductById(id);
        }
        catch (NotFoundException e){
            throw new NotFoundException("Error for Delete Product");
        }
    }
}
