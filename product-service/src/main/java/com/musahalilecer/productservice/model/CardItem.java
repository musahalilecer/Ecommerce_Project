package com.musahalilecer.productservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "card")
public class CardItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
