package com.musahalilecer.productservice.dao.dao_abstract;

import com.musahalilecer.productservice.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProducts();
    Product getProductById(int id);
    Product addProduct(Product product);
    Product updateProduct(Product product, int id);
    void deleteProduct(int id);
}
