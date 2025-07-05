package com.musahalilecer.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "countrys")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String countryName;
    private String flag;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "adress_id")
    private List<Adress> adresses;
}
