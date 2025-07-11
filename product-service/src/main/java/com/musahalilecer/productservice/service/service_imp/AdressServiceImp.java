package com.musahalilecer.productservice.service.service_imp;

import com.musahalilecer.productservice.dao.dao_abstract.AdressDao;
import com.musahalilecer.productservice.dao.dao_imp.AdressDaoImp;
import com.musahalilecer.productservice.dto.request.AdressRequest;
import com.musahalilecer.productservice.dto.response.AdressResponse;
import com.musahalilecer.productservice.exception.NotFoundException;
import com.musahalilecer.productservice.mapper.AdressMapper;
import com.musahalilecer.productservice.model.Adress;
import com.musahalilecer.productservice.repository.AdressRepository;
import com.musahalilecer.productservice.repository.CountryRepository;
import com.musahalilecer.productservice.service.service.AdressService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdressServiceImp implements AdressService {

    @Autowired
    private AdressDaoImp adressDao;
    @Autowired
    private AdressMapper adressMapper;
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private AdressRepository adressRepository;

    @Override
    public List<AdressResponse> getAllAdresses() {

        List<Adress> adresses = adressDao.getAllAdresses();
        return adresses.stream().map(adressMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public AdressResponse getAdressById(int id) {
        Adress adress = adressDao.getAdressById(id);
        return adressMapper.toResponse(adress);
    }

    @Override
    public AdressResponse addAdress(AdressRequest adressRequest) {
        Adress newAdress = adressMapper.toEntity(adressRequest);
        newAdress.setCountry(countryRepository.findById(adressRequest.getCountryId()).orElseThrow(() -> new NotFoundException("Country not found")));
        Adress savedAdress = adressDao.createAdress(newAdress);
        return adressMapper.toResponse(savedAdress);
    }

    @Override
    public AdressResponse updateAdress(int id, AdressRequest adressRequest) {
        Adress findAdress = adressDao.getAdressById(id);
        findAdress.setAdressLocation(adressRequest.getAdressLocation());
        findAdress.setCountry(countryRepository.findById(adressRequest.getCountryId()).orElseThrow(() -> new NotFoundException("Country not found")));
        Adress updatedAdress = adressDao.updateAdress(id, findAdress);
        return adressMapper.toResponse(updatedAdress);
    }

    @Override
    public void deleteAdress(int id) {
        adressDao.getAdressById(id);
        adressDao.deleteAdress(id);
    }
}
