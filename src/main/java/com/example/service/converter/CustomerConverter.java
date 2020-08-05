package com.example.service.converter;

import com.example.service.entities.Customer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CustomerConverter {

    //ToDO: implement this


    public Customer toCustomer(String json) {

        throw new NotImplementedException();
    }

    public List<Customer> toCustomerList(String json) {

        throw new NotImplementedException();
    }

    // -----------------------------------------------------

    public String toJson(Customer customer) {

        throw new NotImplementedException();
    }

    public String toJson(List<Customer> customerList) {
        throw new NotImplementedException();
    }


}
