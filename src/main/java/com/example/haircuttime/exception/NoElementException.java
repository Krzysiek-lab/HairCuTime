package com.example.haircuttime.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoElementException extends RuntimeException{
    public NoElementException(String message) {
        super(message);
    }
}
