package com.example.service;

import com.example.service.entities.Order;
import com.example.service.repository.OrderRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void findByCustomerTest() {
        Assertions.assertNotNull(orderRepository.findByCustomer("user1"));
    }

    @Test
    void saveCustomerTest(){
        Assertions.assertEquals("user2", orderRepository.save(new Order("user2",32)).getCustomer(),
                "user2 not saved");
    }
}