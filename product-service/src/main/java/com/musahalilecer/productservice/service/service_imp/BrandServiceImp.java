package com.musahalilecer.productservice.service.service_imp;

import com.musahalilecer.productservice.dao.dao_imp.BrandDaoImp;
import com.musahalilecer.productservice.dto.request.BrandRequest;
import com.musahalilecer.productservice.dto.response.BrandResponse;
import com.musahalilecer.productservice.mapper.BrandMapper;
import com.musahalilecer.productservice.model.Brand;
import com.musahalilecer.productservice.model.Category;
import com.musahalilecer.productservice.model.Product;
import com.musahalilecer.productservice.repository.CategoryRepository;
import com.musahalilecer.productservice.repository.ProductRepository;
import com.musahalilecer.productservice.service.service.BrandService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImp implements BrandService {

    @Autowired
    private BrandDaoImp brandDao;
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<BrandResponse> getAllBrands() {
        List<Brand> brands = brandDao.getAllBrands();
        return brands.stream().map(brandMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public BrandResponse getBrandById(int id) {
        Brand brand = brandDao.getBrandById(id);
        return brandMapper.toResponse(brand);
    }

    @Override
    @Transactional
    public BrandResponse addBrand(BrandRequest brandRequest) {
        Brand newBrand = brandMapper.toEntity(brandRequest);
        Category category = categoryRepository.findById(brandRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        newBrand.setCategory(category);
        List<Product> products = productRepository.findAllById(brandRequest.getProductIds());
        newBrand.setProducts(products);
        Brand savedBrand = brandDao.createBrand(newBrand);
        return brandMapper.toResponse(savedBrand);
    }

    @Override
    @Transactional
    public BrandResponse updateBrand(BrandRequest brandRequest, int id) {
        Brand existingBrand = brandDao.getBrandById(id);
        existingBrand.setBrandName(brandRequest.getBrandName());

        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        existingBrand.setCategory(category);
        List<Product> products = productRepository.findAllById(brandRequest.getProductIds());
        existingBrand.setProducts(products);
        Brand updatedBrand = brandDao.updateBrand(id, existingBrand);
        return brandMapper.toResponse(updatedBrand);
    }

    @Override
    @Transactional
    public void deleteBrand(int id) {
        brandDao.getBrandById(id);
        brandDao.deleteBrand(id);
    }
}
