package com.home.onlineshop.service.customer;

import com.home.onlineshop.dto.WareDto;

public interface CustomerService {
    boolean addWareToCart(WareDto wareDto, Long count);
}