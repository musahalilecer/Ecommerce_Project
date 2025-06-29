package com.musahalilecer.productservice.service.service;


import com.musahalilecer.productservice.dto.request.AdressRequest;
import com.musahalilecer.productservice.dto.response.AdressResponse;

import java.util.List;

public interface AdressService {
    List<AdressResponse> getAllAdresses();
    AdressResponse getAdressById(int id);
    AdressResponse addAdress(AdressRequest adressRequest);
    AdressResponse updateAdress(int id, AdressRequest adressRequest);
    void deleteAdress(int id);
}
