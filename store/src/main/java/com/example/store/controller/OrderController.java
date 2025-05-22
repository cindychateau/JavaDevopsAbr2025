package com.example.store.controller;

import com.example.store.dto.OrderDTO;
import com.example.store.service.OrderServiceImpl;
import com.example.store.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    // 1.) Recibir peticiones HTTP de Ordenes
    //  2. ) consumir servicio de productos/usuarios7-.....
    // 3.) Validar que el producto cumpla con X
    //
     //
     //
     //

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getOrders() {
        List<OrderDTO> orders = orderService.getOrders();
        //1. hay ordenes( orders.size > 0) - 2. no hay ordenes (orders.size == 0)
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO newOrder = orderService.saveOrder(orderDTO);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

}
