package com.musahalilecer.productservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "adresses")
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String adressLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;
}
