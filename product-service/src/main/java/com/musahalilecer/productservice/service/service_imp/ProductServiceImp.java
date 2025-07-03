package com.musahalilecer.productservice.service.service_imp;

import com.musahalilecer.productservice.dao.dao_abstract.CategoryDao;
import com.musahalilecer.productservice.dao.dao_abstract.ProductDao;
import com.musahalilecer.productservice.dao.dao_imp.AdressDaoImp;
import com.musahalilecer.productservice.dao.dao_imp.BrandDaoImp;
import com.musahalilecer.productservice.dao.dao_imp.CountryDaoImp;
import com.musahalilecer.productservice.dto.request.ProductRequest;
import com.musahalilecer.productservice.dto.response.ProductResponse;
import com.musahalilecer.productservice.exception.NotFoundException;
import com.musahalilecer.productservice.mapper.ProductMapper;
import com.musahalilecer.productservice.model.Adress;
import com.musahalilecer.productservice.model.Brand;
import com.musahalilecer.productservice.model.Category;
import com.musahalilecer.productservice.model.Product;
import com.musahalilecer.productservice.repository.*;
import com.musahalilecer.productservice.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private AdressDaoImp adressDaoImp;
    @Autowired
    private BrandDaoImp brandDaoImp;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AdressRepository adressRepository;
    @Autowired
    private BrandRepository brandRepository;


    @Override
    public List<ProductResponse> getProducts() {
        List<Product> products = productDao.getAllProducts();
        var productResponses = products.stream().map(productMapper::toResponse).collect(Collectors.toList());
        return productResponses;
    }

    @Override
    public ProductResponse getProductById(int id) {
        Product product = productDao.getProductById(id);
        if(id != product.getId()){
            throw new NotFoundException("Product not found");
        }
        return productMapper.toResponse(product);
    }


    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        var category = categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(null);
        var adress = adressRepository.findById(productRequest.getAdressId()).orElseThrow(null);
        var brand = brandRepository.findById(productRequest.getAdressId()).orElseThrow(null);
        productRequest.setCategoryId(category.getId());
        productRequest.setAdressId(adress.getId());
        productRequest.setBrandId(brand.getId());
        Product newProduct = productMapper.toEntity(productRequest);
        Product saveProduct = productDao.addProduct(newProduct);
        return productMapper.toResponse(saveProduct);
    }

    @Override
    public ProductResponse updateProduct(int id, ProductRequest productRequest) {
        Product existingProduct = productDao.getProductById(id);
        Brand brand = brandRepository.findById(productRequest.getBrandId()).orElseThrow(() -> new NotFoundException("Not Found"));
        Category category = categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(() -> new NotFoundException("Not Found"));
        Adress adress = adressRepository.findById(productRequest.getAdressId()).orElseThrow(null);

        existingProduct.setAdress(adress);
        existingProduct.setBrand(brand);
        existingProduct.setCategory(category);
        existingProduct.setBarcode(productRequest.getBarcode());
        existingProduct.setDescription(productRequest.getDescription());
        existingProduct.setPrice(productRequest.getPrice());
        existingProduct.setName(productRequest.getName());

        Product product = productDao.addProduct(existingProduct);
        return productMapper.toResponse(product);
    }

    @Override
    public void deleteProduct(int id) {
        productDao.getProductById(id);
        productDao.deleteProduct(id);
    }



    /*
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductResponse> getProducts() {
        List<Product> products = productRepository.findAll();
        var product =  products.stream()
                .map(productMapper::toResponse)
                .collect(Collectors.toList());
        return product;
    }

    @Override
    public ProductResponse getProductById(int id) {
        return productRepository.findById(id)
                .map(productMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = productMapper.toEntity(productRequest);
        Product savedProduct = productRepository.save(product);
        return productMapper.toResponse(savedProduct);
    }

    @Override
    public ProductResponse updateProduct(ProductRequest productRequest) {
        return null;
    }

    @Override
    public void deleteProduct(int id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }

    public List<ProductResponse> findPrductsByBrand(String brand){
        List<Product> findProducts = productRepository.findPrductsByBrand(brand);
        return findProducts.stream()
                .map(productMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<ProductResponse> findPrductsByCategory(String category){
        List<Product> findProducts = productRepository.findProductsByCategory(category);
        return findProducts.stream()
                .map(productMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<ProductResponse> getAllProductsByPrice(Double price){
        List<Product> findProducts = productRepository.getAllProductByPriceDes(price);
        return findProducts.stream()
                .map(productMapper::toResponse)
                .collect(Collectors.toList());
    }
     */
}
