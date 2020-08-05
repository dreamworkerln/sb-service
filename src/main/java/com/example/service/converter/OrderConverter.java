package com.example.service.converter;

import com.example.service.dto.OrderDto;
import com.example.service.mapper.OrderMapper;
import com.example.service.entities.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static com.pivovarit.function.ThrowingSupplier.unchecked;


@Component
@Slf4j
public class OrderConverter {

    private final ObjectMapper objectMapper;
    private final OrderMapper orderMapper;

    public OrderConverter(ObjectMapper objectMapper, OrderMapper orderMapper) {
        this.objectMapper = objectMapper;
        this.orderMapper = orderMapper;
    }



    public Order toOrder(String json) {

        OrderDto orderDto = toDto(json);
        return orderMapper.toEntity(orderDto);
    }

    public List<Order> toOrderList(String json) {

        List<OrderDto> orderDtoList = toDtoList(json);
        return orderMapper.toEntityList(orderDtoList);
    }

    // -----------------------------------------------------

    public String toJson(Order order) {

        OrderDto dto = orderMapper.toDto(order);
        return unchecked(() -> objectMapper.writeValueAsString(dto)).get();
    }

    public String toJson(List<Order> orderList) {

        List<OrderDto> list = orderMapper.toDtoList(orderList);
        return unchecked(() -> objectMapper.writeValueAsString(list)).get();
    }


    // ======================================================

    private OrderDto toDto(String json) {
        return unchecked(() ->  objectMapper.readValue(json, OrderDto.class)).get();
    }


    private List<OrderDto> toDtoList(String json) {

        List<OrderDto> result;
        try {

            if (json == null) {
                throw new ValidationException("json = null");
            }
            // https://stackoverflow.com/questions/6349421/how-to-use-jackson-to-deserialise-an-array-of-objects

            //noinspection rawtypes
            Class tArrayClass = Array.newInstance(OrderDto.class, 0).getClass();
            //noinspection unchecked
            result = Arrays.asList((OrderDto[])objectMapper.readValue(json, tArrayClass));

            result.forEach(l -> {
                if (l == null) {
                    throw new ValidationException("List<OrderDto> contains null elements");
                }
            });
        }
        catch (IOException e) {
            throw new ParseException(0, "List<OrderDto> param parse error", e);
        }

        return result;
    }

    // ------------------------------------------------------------------------------

}
