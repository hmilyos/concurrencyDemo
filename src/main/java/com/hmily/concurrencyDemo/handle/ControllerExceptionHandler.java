package com.hmily.concurrencyDemo.handle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> handleUserNotExistException(RuntimeException ex) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", "1001");
        result.put("message", ex.getMessage());
        return result;
    }
}
