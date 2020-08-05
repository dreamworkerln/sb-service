package com.example.service.controller;

import com.example.service.dto.CustomerDto;
import com.example.service.entities.Customer;
import com.example.service.entities.Order;
import com.example.service.converter.CustomerConverter;
import com.example.service.converter.OrderConverter;
import com.example.service.services.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
@Slf4j
public class OrderController {

    private final OrderService orderService;
    private final OrderConverter orderConverter;
    private final CustomerConverter customerConverter;

    public OrderController(OrderService orderService, OrderConverter orderConverter, CustomerConverter customerConverter) {
        this.orderService = orderService;
        this.orderConverter = orderConverter;
        this.customerConverter = customerConverter;
    }


    @GetMapping
    public String get(@RequestBody String json) {
        Customer customer = customerConverter.toCustomer(json);
        List<Order> orderList = orderService.findOrderListByCustomer(customer);
        return orderConverter.toJson(orderList);
    }

    // may update existing Order, createNew - implement new method
    @PostMapping
    public String save(@RequestBody String json) {
        Order order = orderConverter.toOrder(json);
        order = orderService.save(order);
        return orderConverter.toJson(order);
    }

}
