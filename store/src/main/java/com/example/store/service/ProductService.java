package com.example.store.service;

import com.example.store.model.Product;
import com.example.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository;
    
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    
    public Product saveWithoutDTO(Product product) {
        return productRepository.save(product);
    }
    
}
