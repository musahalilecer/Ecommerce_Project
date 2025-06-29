package com.musahalilecer.productservice.controller;

import com.musahalilecer.productservice.service.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adres")
public class AdressController {

    @Autowired
    private AdressService adressService;


}
