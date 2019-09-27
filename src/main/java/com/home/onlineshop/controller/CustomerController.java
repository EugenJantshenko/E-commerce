package com.home.onlineshop.controller;


import com.home.onlineshop.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public void buyWare(@PathVariable("id") Long id, @RequestParam("count") Long count){
        customerService.addToCart(id,count);
        customerService.buyWares();
    }
}
