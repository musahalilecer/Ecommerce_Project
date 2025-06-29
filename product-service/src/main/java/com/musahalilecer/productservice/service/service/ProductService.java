package com.musahalilecer.productservice.service.service;

import com.musahalilecer.productservice.dto.request.ProductRequest;
import com.musahalilecer.productservice.dto.response.ProductResponse;
import com.musahalilecer.productservice.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductResponse> getProducts();
    ProductResponse getProductById(int id);
    ProductResponse addProduct(ProductRequest productRequest);
    ProductResponse updateProduct(int id, ProductRequest productRequest);
    void deleteProduct(int id);

}
