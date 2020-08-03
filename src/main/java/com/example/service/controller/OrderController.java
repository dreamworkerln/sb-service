package com.example.service.controller;

import com.example.service.services.OrderService;
import com.example.service.entities.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/service")
@Slf4j
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("")
    ResponseEntity<String> getObject(@RequestBody OrderDTO orderDTO) {
        log.info(orderDTO.toString());
        return new ResponseEntity<>(orderService.findOrderList(orderDTO), HttpStatus.OK);
    }

    @PutMapping("")
    ResponseEntity<String>  putObject(@RequestBody OrderDTO orderDTO) {
        log.info(orderDTO.toString());
        return new ResponseEntity<>(orderService.addOrder(orderDTO),HttpStatus.OK);

    }




}
