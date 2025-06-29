package com.musahalilecer.productservice.service.service_imp;

import com.musahalilecer.productservice.dao.dao_abstract.CategoryDao;
import com.musahalilecer.productservice.dao.dao_abstract.ProductDao;
import com.musahalilecer.productservice.dto.request.CategoryRequest;
import com.musahalilecer.productservice.dto.response.CategoryResponse;
import com.musahalilecer.productservice.mapper.CategoryMapper;
import com.musahalilecer.productservice.model.Category;
import com.musahalilecer.productservice.model.Product;
import com.musahalilecer.productservice.repository.ProductRepository;
import com.musahalilecer.productservice.service.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryDao.getAllCategories();
        return categories.stream().map(categoryMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public CategoryResponse getCategoryById(int id) {
        Category category = categoryDao.getCategoryById(id);
        return categoryMapper.toResponse(category);
    }

    @Override
    @Transactional
    public CategoryResponse addCategory(CategoryRequest categoryRequest) {
        Category newCategory = categoryMapper.toEntity(categoryRequest);
        List<Product> products = productRepository.findAllById(categoryRequest.getProductIds());
        newCategory.setProducts(products);
        Category category = categoryDao.addCategory(newCategory);
        return categoryMapper.toResponse(category);
    }

    @Override
    @Transactional
    public CategoryResponse updateCategory(CategoryRequest categoryRequest, int id) {
        Category existingCategory = categoryDao.getCategoryById(id);
        existingCategory.setCategoryName(categoryRequest.getCategoryName());
        List<Product> products = productRepository.findAllById(categoryRequest.getProductIds());
        existingCategory.setProducts(products);
        Category updatedCategory = categoryDao.updateCategory(existingCategory, id);
        return categoryMapper.toResponse(updatedCategory);
    }

    @Override
    @Transactional
    public void deleteCategory(int id) {
        getCategoryById(id);
        categoryDao.deleteCategory(id);
    }
}
