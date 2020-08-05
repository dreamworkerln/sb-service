package com.example.service.services;

import com.example.service.entities.Customer;
import com.example.service.entities.Order;
import com.example.service.exception.CustomerNotFoundException;
import com.example.service.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findOrderListByCustomer(Customer customer) {

        return orderRepository.findByCustomer(customer)
            .orElseThrow(()->new CustomerNotFoundException(customer));
    }

    //save Order = Convert savedOrder to Json
    public Order save(Order order) {
        return orderRepository.save(order);
    }

}
