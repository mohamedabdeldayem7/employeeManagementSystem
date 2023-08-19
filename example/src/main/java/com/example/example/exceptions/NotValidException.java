package com.example.example.exceptions;

public class NotValidException extends RequestException{

    public NotValidException(String message) {
        super(message);
    }
}
