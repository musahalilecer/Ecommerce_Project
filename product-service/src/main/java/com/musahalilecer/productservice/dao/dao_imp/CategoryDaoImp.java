package com.musahalilecer.productservice.dao.dao_imp;

import com.musahalilecer.productservice.dao.dao_abstract.CategoryDao;
import com.musahalilecer.productservice.dto.request.CategoryRequest;
import com.musahalilecer.productservice.exception.NotFoundException;
import com.musahalilecer.productservice.mapper.CategoryMapper;
import com.musahalilecer.productservice.model.Category;
import com.musahalilecer.productservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryDaoImp implements CategoryDao<Category> {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found with id: " + id));
    }

    @Override
    @Transactional
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category updateCategory(Category category, int id) {
        getCategoryById(id);
        category.setId(id);
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategory(int id) {
        if(!categoryRepository.existsById(id)) {
            throw new NotFoundException("Category not found");
        }
        categoryRepository.deleteById(id);
    }
}
