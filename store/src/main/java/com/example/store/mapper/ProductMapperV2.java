package com.example.store.mapper;

import com.example.store.dto.ExpirableProductDTO;
import com.example.store.dto.ProductDTO;
import com.example.store.model.ExpirableProduct;
import com.example.store.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface ProductMapperV2 {

	ExpirableProduct fromDTO(ExpirableProductDTO expirableProductDTO);

	Product fromDTO(ProductDTO productDTO);

	ExpirableProductDTO toDTO(ExpirableProduct expirableProductDTO);

	ProductDTO toDTO(Product productDTO);
}
