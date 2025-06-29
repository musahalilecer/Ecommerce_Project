package com.musahalilecer.productservice.dao.dao_abstract;

import com.musahalilecer.productservice.model.Adress;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AdressDao<T> {
    List<Adress> getAllAdresses();
    Adress getAdressById(int id);
    Adress createAdress(Adress adress);
    Adress updateAdress(int id, Adress adress);
    void deleteAdress(int id);
    /*
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
        return adressRepository.save(adress);
    }

    @Transactional
    public void deleteAdress(int id) {
        if (!adressRepository.existsById(id)) {
            throw new NotFoundException("Adress not found with id: " + id);
        }
        adressRepository.deleteById(id);
    }
     */
}
