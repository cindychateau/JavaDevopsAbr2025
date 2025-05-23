package com.example.store.service;

import com.example.store.dto.OrderDTO;
import com.example.store.mapper.OrderMapper;
import com.example.store.model.Order;
import com.example.store.repository.OrderRepository;
import com.example.store.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("impl2")
@Profile("profile2")
@RequiredArgsConstructor
public class OrderServiceImplConsoleOut implements OrderService {
    
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderDTO> getOrders() {
        System.out.println("Impl2");
        return List.of();
    }
    
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        System.out.println("Impl2");
        return new OrderDTO();
    }
    
}
