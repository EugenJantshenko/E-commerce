package com.home.onlineshop.exceptions.handlers;

import com.home.onlineshop.exceptions.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class OnlineShopExceptionHandler {

    @Data
    @AllArgsConstructor
    private static class AwesomeException {
        private String message;
    }

//    @ExceptionHandler(Exception.class)
//    public void exception(Exception e){
//        e.printStackTrace();
//        log.error(e.getMessage(), e);
//    }

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

    @ExceptionHandler(WareAlreadyExistException.class)
    protected ResponseEntity<AwesomeException> handleWareAlreadyExistException(){
        return new ResponseEntity<>(new AwesomeException("Ware with those SerialNumber already Exist"), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(EmptyCartException.class)
    protected ResponseEntity<AwesomeException> handleEmptyCartException(){
        return new ResponseEntity<>(new AwesomeException("This cart is empty!"), HttpStatus.NOT_FOUND);
    }
}
