package com.example.store.service;

import com.example.store.dto.ExpirableProductDTO;
import com.example.store.dto.ProductDTO;
import com.example.store.mapper.ProductMapper;
import com.example.store.mapper.ProductMapperV2;
import com.example.store.model.ExpirableProduct;
import com.example.store.model.Product;
import com.example.store.repository.ProductRepository;
import com.example.store.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;
    private final ProductMapperV2 productMapper;
    
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    
    public Product saveWithoutDTO(Product product) {
        return productRepository.save((ExpirableProduct) product);
    }

    public ProductDTO saveProduct(ExpirableProductDTO product) {
        Product productToPersist = null;
        if(Objects.isNull(product.getExpirationDate() )){
            productToPersist = productMapper.fromDTO((ProductDTO) product);
        }else{
            productToPersist = productMapper.fromDTO(product);
        }
        ProductDTO productToReturn = null;
        Product resultDB = productRepository.save(productToPersist);
        if(resultDB instanceof ExpirableProduct){
            productToReturn = productMapper.toDTO((ExpirableProduct)resultDB);
        }else{
            productToReturn = productMapper.toDTO(resultDB);
        }
        return productToReturn;
    }
    
}
