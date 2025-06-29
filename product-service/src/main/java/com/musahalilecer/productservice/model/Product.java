package com.musahalilecer.productservice.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.smartcardio.Card;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String barcode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adress_id")
    private Adress adress;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private CardItem card;
}
