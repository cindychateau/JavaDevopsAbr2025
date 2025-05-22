package com.example.store.service;

import com.example.store.dto.OrderDTO;
import com.example.store.mapper.OrderMapper;
import com.example.store.model.Order;
import com.example.store.repository.OrderRepository;
import com.example.store.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("impl1")
@Profile("profile1")
@Primary
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderDTO> getOrders() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.ordersToOrderDTOs(orders);
    }
    
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        Order newOrder;
        if(Objects.nonNull(orderDTO.getExpirationDate())){
            newOrder = orderMapper.expirableOrderDTOToOrder(orderDTO);
        }else{
            newOrder = orderMapper.orderDTOToOrder(orderDTO);
        }

        orderRepository.save(newOrder);
        return orderMapper.orderToOrderDTO(newOrder);
    }
    
}
