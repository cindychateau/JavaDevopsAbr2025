package com.example.store.service.interfaces;

import com.example.store.dto.OrderDTO;

import java.util.List;

public interface OrderService {

	List<OrderDTO> getOrders();

	OrderDTO saveOrder(OrderDTO orderDTO);
}
