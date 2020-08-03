//package com.example.service;
//
//import com.example.service.entities.OrderDTO;
//import com.example.service.services.OrderService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//public class ServiceTestInitializer implements ApplicationRunner {
//
//    private final OrderService orderService;
//
//    @Autowired
//    public ServiceTestInitializer(OrderService orderService) {
//        this.orderService = orderService;
//    }
//
//    // will run before tests
//    @Override
//    public void run(ApplicationArguments args) {
//
//        orderService.save(new OrderDTO("user1",1));
//
//    }
//}
//
