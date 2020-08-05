package com.example.service.dto;

import com.example.service.entities.Customer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class OrderDto {

    private Long id;
    private Customer customer;
    private Integer cost;


    public OrderDto(Customer customer, Integer cost) {
        this.customer = customer;
        this.cost = cost;
    }

    public OrderDto() {}
}
