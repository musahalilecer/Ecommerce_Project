package com.musahalilecer.productservice.repository;

import com.musahalilecer.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM products GROUP BY brands ASC", nativeQuery = true)
    List<Product> findPrductsByBrand(String brand);

    @Query(value = "SELECT * FROM products GROUP BY categorys ASC", nativeQuery = true)
    List<Product> findProductsByCategory(String category);

    @Query(value = "SELECT * FROM products ORDER BY price ASC", nativeQuery = true)
    List<Product> getAllProductByPriceDes(Double price);
}
