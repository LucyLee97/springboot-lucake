package com.example.lucake.service;

import com.example.lucake.commen.exception.ApiStatusCodeEnum;
import com.example.lucake.commen.exception.LucakeException;
import com.example.lucake.entity.Product;
import com.example.lucake.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "Product")
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public Product createProduct(String name, Integer price, String memo, boolean active) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setMemo(memo);
        product.setActive(active);
        return productRepo.save(product);
    }

    @Cacheable(value = "product")
    public Product findById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new LucakeException(ApiStatusCodeEnum.RESULT_NOT_FOUND));
    }

    @CachePut(value = "product", key = "#id")
    public Product updatePrice(Long id, String name, Integer price, String memo, boolean active) {
        Product product = productRepo.findById(id).orElseThrow(() -> new LucakeException(ApiStatusCodeEnum.RESULT_NOT_FOUND));
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setMemo(memo);
        product.setActive(active);
        return productRepo.save(product);
    }

    public List<Product> findAllPagition(int pageNumber, int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize, Sort.by("id").ascending());
        return productRepo.findAll(page).getContent();
    }

    @CacheEvict(value = "product", key = "#id")
    public Long deleteProduct(Long id) {
        productRepo.deleteById(id);
        return id;
    }
}
