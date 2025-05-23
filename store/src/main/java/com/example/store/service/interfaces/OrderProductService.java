package com.example.store.service.interfaces;

import com.example.store.dto.OrderDTO;
import com.example.store.dto.ProductDTO;
import com.example.store.model.Product;

import java.util.List;

/***
 * Estye es un ejemplo de como no se segregan las interfaces y se incluye en una sola
 * todas las operaciones de la aplicación
 */

public interface OrderProductService {

	List<OrderDTO> getOrders();

	OrderDTO saveOrder(OrderDTO orderDTO);

	List<Product> getProducts();

	Product saveWithoutDTO(Product product);

	ProductDTO saveProduct(Product product);

}
