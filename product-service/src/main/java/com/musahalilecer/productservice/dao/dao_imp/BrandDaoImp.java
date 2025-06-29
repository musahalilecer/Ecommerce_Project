package com.musahalilecer.productservice.dao.dao_imp;

import com.musahalilecer.productservice.dao.dao_abstract.BrandDao;
import com.musahalilecer.productservice.exception.NotFoundException;
import com.musahalilecer.productservice.mapper.BrandMapper;
import com.musahalilecer.productservice.model.Adress;
import com.musahalilecer.productservice.model.Brand;
import com.musahalilecer.productservice.repository.BrandRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BrandDaoImp implements BrandDao<Brand> {

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getBrandById(int id) {
        return brandRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid brand"));
    }

    @Transactional
    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Transactional
    @Override
    public Brand updateBrand(int id, Brand brand) {
        getBrandById(id);
        brand.setId(id);
        return brandRepository.save(brand);
    }

    @Override
    @Transactional
    public void deleteBrand(int id) {
        if(!brandRepository.existsById(id)){
            throw new NotFoundException("Brand not found");
        }
        brandRepository.deleteById(id);
    }
}
