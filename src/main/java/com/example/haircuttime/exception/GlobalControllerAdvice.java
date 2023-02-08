package com.example.haircuttime.exception;

import com.example.haircuttime.exception.exceptions.ResourceNotFoundException;
import com.example.haircuttime.exception.exceptions.UniqueValueException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        String message = nonNull(ex.getMessage()) ? ex.getMessage().split(":")[0] : ex.getMessage();
        return new ResponseEntity<>(getBody(HttpStatus.BAD_REQUEST, message), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(getBody(HttpStatus.BAD_REQUEST, errors), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({UniqueValueException.class, ResourceNotFoundException.class})
    public ResponseEntity<Object> handleUniqueValueException(Exception e) {
        return new ResponseEntity<>(getBody(HttpStatus.BAD_REQUEST, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    private Map<Object, Object> getBody(HttpStatus status, Object message) {
        Map<Object, Object> body = new LinkedHashMap<>();
        body.put("time", Instant.now());
        body.put("code", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", message);
        return body;
    }

}
