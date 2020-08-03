package com.example.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
HttpStatus.NOT_FOUND говорит Spring MVC отправлять обратно код HTTP статуса(404) при каждом срабатывании исключения.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends  RuntimeException{

    public CustomerNotFoundException(String customer) {
        super("could not find customer '" + customer + "'.");
    }

}
