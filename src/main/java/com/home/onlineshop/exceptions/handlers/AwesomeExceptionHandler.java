package com.home.onlineshop.exceptions.handlers;

import com.home.onlineshop.exceptions.ThereIsNoSuchWareException;
import com.home.onlineshop.exceptions.ThereIsNoSuchWareCategoryException;
import com.home.onlineshop.exceptions.ThereIsNoSuchWareTypeException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AwesomeExceptionHandler extends ResponseEntityExceptionHandler {

    @Data
    @AllArgsConstructor
    private static class AwesomeException {
        private String message;
    }

    @ExceptionHandler(ThereIsNoSuchWareTypeException.class)
    protected ResponseEntity<AwesomeException> handleThereIsNoSuchWareTypeException(){
        return new ResponseEntity<>(new AwesomeException("There is no such ware type"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ThereIsNoSuchWareException.class)
    protected ResponseEntity<AwesomeException> handleThereIsNoSuchWareException(){
        return new ResponseEntity<>(new AwesomeException("There is no such ware"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ThereIsNoSuchWareCategoryException.class)
    protected ResponseEntity<AwesomeException> handleThereIsNoSuchWareCategoryException(){
        return new ResponseEntity<>(new AwesomeException("There is no such ware category"), HttpStatus.NOT_FOUND);
    }
}
