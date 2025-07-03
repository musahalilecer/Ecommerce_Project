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
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        if (categoryRequest.getProductIds() != null) {
            List<Product> products = productRepository.findAllById(categoryRequest.getProductIds());
            newCategory.setProducts(products);
        }
        Category saved = categoryDao.addCategory(newCategory);
        return categoryMapper.toResponse(saved);
    }

    @Override
    @Transactional
    public CategoryResponse updateCategory(int id, CategoryRequest categoryRequest) {
        Category existing = categoryDao.getCategoryById(id);
        if (existing == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
        existing.setCategoryName(categoryRequest.getCategoryName());
        if (categoryRequest.getProductIds() != null) {
            List<Product> products = productRepository.findAllById(categoryRequest.getProductIds());
            existing.setProducts(products);
        }
        Category updated = categoryDao.updateCategory(existing, id);
        return categoryMapper.toResponse(updated);
    }

    @Override
    @Transactional
    public void deleteCategory(int id) {
        getCategoryById(id);
        categoryDao.deleteCategory(id);
    }
}


/*
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
    public CategoryResponse updateCategory(int id, CategoryRequest categoryRequest) {
        Category existingCategory = categoryDao.getCategoryById(id);
        existingCategory.setCategoryName(categoryRequest.getCategoryName());
        List<Product> products = productRepository.findAllById(categoryRequest.getProductIds());
        existingCategory.setProducts(products);
        Category updatedCategory = categoryDao.updateCategory(existingCategory, id);
        return categoryMapper.toResponse(updatedCategory);
    }
 */