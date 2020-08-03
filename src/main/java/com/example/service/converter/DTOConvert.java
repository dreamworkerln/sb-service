package com.example.service.converter;

import com.example.service.entities.Order;
import com.example.service.entities.OrderDTO;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DTOConvert {

//     public OrderDTO OrderToDTO(Order order) {
//        OrderDTO orderDTO = new OrderDTO(order.getCustomer(),order.getCost());
//        return orderDTO;
//    }

    public String OrderListToJson(List<Order> orderList){
        return new Gson().toJson(orderList );
    }
    public String OrderToJson(Order order){
        return new Gson().toJson(order );
    }

    public static Order DTOToOrder(OrderDTO orderDTO){
        Order order=new Order(orderDTO.getCustomer(),orderDTO.getCost());
        return order;
    }
}
