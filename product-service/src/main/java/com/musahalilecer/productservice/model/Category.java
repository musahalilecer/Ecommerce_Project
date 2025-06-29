package com.musahalilecer.productservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "Categorys")
@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categoryName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private List<Product> products;
}
