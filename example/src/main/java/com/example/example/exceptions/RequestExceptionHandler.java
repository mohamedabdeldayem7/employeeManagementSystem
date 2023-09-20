package com.example.example.exceptions;

import com.example.example.web.response.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RequestExceptionHandler {
    @ExceptionHandler(value = {NotFoundExecption.class})
    public ResponseEntity<Object> handleRequestException(RequestException e){

        ResponseModel model = ResponseModel.builder().message(e.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value()).build();

        return new ResponseEntity<>(model, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {NotValidException.class})
    public ResponseEntity<Object> handleRequestException(NotValidException e){

        ResponseModel model = ResponseModel.builder().message(e.getMessage())
                .statusCode(HttpStatus.NOT_ACCEPTABLE.value()).build();

        return new ResponseEntity<>(model, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleRequestException(MethodArgumentNotValidException e){
        Map<String, String> errorMap = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(err -> errorMap.put(err.getField(), err.getDefaultMessage()));

        ResponseModel<Object> model = ResponseModel.builder().data(errorMap)
                .statusCode(HttpStatus.NOT_ACCEPTABLE.value()).build();

        return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
    }
}
