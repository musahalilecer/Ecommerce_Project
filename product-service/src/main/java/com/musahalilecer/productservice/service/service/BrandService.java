package com.musahalilecer.productservice.service.service;

import com.musahalilecer.productservice.dto.request.BrandRequest;
import com.musahalilecer.productservice.dto.response.BrandResponse;
import org.hibernate.validator.constraints.CodePointLength;

import java.util.List;

public interface BrandService {
    List<BrandResponse> getAllBrands();
    BrandResponse getBrandById(int id);
    BrandResponse addBrand(BrandRequest brandRequest);
    BrandResponse updateBrand(BrandRequest brandRequest, int id);
    void deleteBrand(int id);
}
