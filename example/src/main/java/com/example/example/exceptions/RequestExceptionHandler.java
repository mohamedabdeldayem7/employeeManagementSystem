package com.example.example.exceptions;

import com.example.example.web.response.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RequestExceptionHandler {
    @ExceptionHandler(value = {RequestException.class})
    public ResponseEntity<Object> handleRequestException(RequestException e){

        ResponseModel model = ResponseModel.builder().message(e.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value()).build();

        return new ResponseEntity<>(model, HttpStatus.NOT_FOUND);
    }
}
