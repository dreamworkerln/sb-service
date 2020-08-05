package com.example.service.entities;

import com.example.service.exception.CustomerNotFoundException;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.NullValueCheckStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

//@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @NotNull
    private Integer cost;

    public Order(Customer customer, Integer cost) {
        this.customer = customer;
        this.cost=cost;
    }
    public Order() { }
}
