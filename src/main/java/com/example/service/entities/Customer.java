package com.example.service.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy= "customer", orphanRemoval = true, cascade = CascadeType.ALL)
    @OrderBy("id ASC")
    protected List<Order> orderList = new ArrayList<>();
}
