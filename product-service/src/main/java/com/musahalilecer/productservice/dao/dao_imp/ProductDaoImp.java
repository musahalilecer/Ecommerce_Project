package com.musahalilecer.productservice.dao.dao_imp;

import com.musahalilecer.productservice.dao.dao_abstract.ProductDao;
import com.musahalilecer.productservice.model.Product;
import com.musahalilecer.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDaoImp implements ProductDao {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product, int id) {
        getProductById(id);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        if(productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Product not found");
        }
    }
}
