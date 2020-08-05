package com.example.service.mapper;

import com.example.service.dto.OrderDto;
import com.example.service.entities.Order;
import org.mapstruct.*;

import java.util.List;


@Mapper
public interface OrderMapper {

    OrderDto toDto(Order order);
    Order toEntity(OrderDto orderDTO);

    List<OrderDto> toDtoList(List<Order> orderList);
    List<Order> toEntityList(List<OrderDto> orderDtoList);
}
