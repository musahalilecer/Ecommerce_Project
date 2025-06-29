package com.musahalilecer.productservice.dao.dao_abstract;

import com.musahalilecer.productservice.model.Adress;
import com.musahalilecer.productservice.model.Brand;
import com.musahalilecer.productservice.repository.BrandRepository;
import jakarta.transaction.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BrandDao<T> {


    List<Brand> getAllBrands();
    Brand getBrandById(int id);
    Brand createBrand(Brand brand);
    Brand updateBrand(int id, Brand brand);

    void deleteBrand(int id);
}
