package com.home.onlineshop.service.customer.impl;

import com.home.onlineshop.dto.WareDto;
import com.home.onlineshop.repository.WareRepository;
import com.home.onlineshop.service.customer.CustomerService;
import com.home.onlineshop.service.ware.WareCategoryService;
import com.home.onlineshop.service.ware.WareService;
import com.home.onlineshop.service.ware.WareTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final WareService wareService;
    private final WareTypeService wareTypeService;
    private final WareCategoryService wareCategoryService;
    private Map<WareDto, Long> cart;

    @Autowired
    public CustomerServiceImpl(WareService wareService, WareTypeService wareTypeService, WareCategoryService wareCategoryService, WareRepository wareRepository) {
        this.wareService = wareService;
        this.wareTypeService = wareTypeService;
        this.wareCategoryService = wareCategoryService;
        cart = new HashMap<>();
    }

    @Override
    public boolean addWareToCart(WareDto wareDto, Long count) {



        return false;
    }

}
