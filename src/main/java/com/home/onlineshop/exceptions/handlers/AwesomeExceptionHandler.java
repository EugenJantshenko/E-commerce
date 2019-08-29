package com.home.onlineshop.exceptions.handlers;

import com.home.onlineshop.exceptions.NoSuchWareException;
import com.home.onlineshop.exceptions.NoSuchWareCategoryException;
import com.home.onlineshop.exceptions.NoSuchWareTypeException;
import com.home.onlineshop.exceptions.NotEnoughWareException;
import com.home.onlineshop.exceptions.WareResourceNotFoundException;
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

    @ExceptionHandler(NoSuchWareTypeException.class)
    protected ResponseEntity<AwesomeException> handleThereIsNoSuchWareTypeException(){
        return new ResponseEntity<>(new AwesomeException("There is no such ware type"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchWareException.class)
    protected ResponseEntity<AwesomeException> handleThereIsNoSuchWareException(){
        return new ResponseEntity<>(new AwesomeException("There is no such ware"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchWareCategoryException.class)
    protected ResponseEntity<AwesomeException> handleThereIsNoSuchWareCategoryException(){
        return new ResponseEntity<>(new AwesomeException("There is no such ware category"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WareResourceNotFoundException.class)
    protected ResponseEntity<AwesomeException> handleWareResourceNotFoundException(){
        return new ResponseEntity<>(new AwesomeException("Ware resource not fount"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotEnoughWareException.class)
    protected ResponseEntity<AwesomeException> handleThereIsNotEnoughWareException(){
        return new ResponseEntity<>(new AwesomeException("There is not enough ware"), HttpStatus.NOT_FOUND);
    }
}
