package com.example.store.service.interfaces;

import com.example.store.dto.ExpirableProductDTO;
import com.example.store.dto.ProductDTO;
import com.example.store.model.ExpirableProduct;
import com.example.store.model.Product;

import java.util.List;

public interface ProductService {

	List<Product> getProducts();

	Product saveWithoutDTO(Product product);

	ProductDTO saveProduct(ExpirableProductDTO product);
}
