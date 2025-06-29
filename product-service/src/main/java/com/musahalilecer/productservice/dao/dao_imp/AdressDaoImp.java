package com.musahalilecer.productservice.dao.dao_imp;

import com.musahalilecer.productservice.dao.dao_abstract.AdressDao;
import com.musahalilecer.productservice.exception.NotFoundException;
import com.musahalilecer.productservice.model.Adress;
import com.musahalilecer.productservice.repository.AdressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class AdressDaoImp implements AdressDao {
    @Autowired
    private AdressRepository adressRepository;

    public List<Adress> getAllAdresses() {
        return adressRepository.findAll();
    }
    public Adress getAdressById(int id) {
        return adressRepository.findById(id).orElseThrow(() -> new RuntimeException("Adress not found"));
    }

    @Transactional
    public Adress createAdress(Adress adress) {
        return adressRepository.save(adress);
    }

    @Transactional
    public Adress updateAdress(int id, Adress adress) {
        getAdressById(adress.getId());
        adress.setId(id);
        return adressRepository.save(adress);
    }

    @Transactional
    public void deleteAdress(int id) {
        if (!adressRepository.existsById(id)) {
            throw new NotFoundException("Adress not found with id: " + id);
        }
        adressRepository.deleteById(id);
    }

}
