package com.example.store.mapper;

import com.example.store.dto.ExpirableProductDTO;
import com.example.store.dto.ProductDTO;
import com.example.store.model.ExpirableProduct;
import com.example.store.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    //Método que reciba obj producto y transforme en dto
    public ProductDTO toDTO(Product product) {
        if(product == null) {
            return null;
        }

        String categoryName = product.getCategory() != null ? product.getCategory().getCategoryName() : null;
        
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription() + product.getDetail().getLongDescription(),
                categoryName
        );
        
    }

    //Método que reciba obj producto y transforme en dto
    public ExpirableProductDTO toDTO(ExpirableProduct product) {
        if(product == null) {
            return null;
        }

        String categoryName = product.getCategory() != null ? product.getCategory().getCategoryName() : null;
        ExpirableProductDTO expirableProductDTO = new ExpirableProductDTO(product.getExpirationDate());
        expirableProductDTO.setId(product.getId());
        expirableProductDTO.setName(product.getName());
        expirableProductDTO.setPrice(product.getPrice());
        expirableProductDTO.setDescription(product.getDescription());
        expirableProductDTO.setCategoryName(categoryName);
        return expirableProductDTO;
    }

}
