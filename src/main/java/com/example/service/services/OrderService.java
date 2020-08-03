package com.example.service.services;

import com.example.service.converter.DTOConvert;
import com.example.service.entities.Order;
import com.example.service.entities.OrderDTO;
import com.example.service.exception.CustomerNotFoundException;
import com.example.service.repository.OrderRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@Slf4j
public class OrderService {
    private OrderRepository orderRepository;
    private DTOConvert dtoConvert;

    @Autowired
    public OrderService(OrderRepository orderRepository, DTOConvert dtoConvert) {
        this.orderRepository = orderRepository;
        this.dtoConvert = dtoConvert;
    }

    public String findOrderList (OrderDTO orderDTO) {
        String customer=orderDTO.getCustomer();
        List<Order> orderList=findByCustomer(customer);
        return dtoConvert.OrderListToJson(orderList);
    }
    public List<Order> findByCustomer(String customer){
        return orderRepository.findByCustomer(customer).orElseThrow(()->new CustomerNotFoundException(customer));
    }

    public String addOrder(OrderDTO orderDTO) {
        Order order=orderRepository.save(DTOConvert.DTOToOrder(orderDTO));
        return dtoConvert.OrderToJson(order);
    }

    public Order save(Order order){
        return orderRepository.save(order);
    }

}
