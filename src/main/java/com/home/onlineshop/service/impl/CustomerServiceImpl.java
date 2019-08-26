package com.home.onlineshop.service.impl;

import com.home.onlineshop.service.interfaces.DBServices.WareCategoryService;
import com.home.onlineshop.service.interfaces.DBServices.WareCountService;
import com.home.onlineshop.service.interfaces.DBServices.WareService;
import com.home.onlineshop.service.interfaces.DBServices.WareTypeService;
import com.home.onlineshop.service.interfaces.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service

public class CustomerServiceImpl implements CustomerService {

    private final WareService wareService;
    private final WareCountService wareCountService;
    private final WareTypeService wareTypeService;
    private final WareCategoryService wareCategoryService;

    @Autowired
    public CustomerServiceImpl(WareService wareService, WareCountService wareCountService, WareTypeService wareTypeService, WareCategoryService wareCategoryService){
        this.wareService=wareService;
        this.wareCountService = wareCountService;
        this.wareTypeService = wareTypeService;
        this.wareCategoryService = wareCategoryService;
    }

    @Override
    public boolean addWareToCart(String name, Integer count) {
        return false;
    }

    @Override
    public boolean removeWareFromCart(String name) {
        return false;
    }

    @Override
    public boolean buyWareInCart() {
        return false;
    }

    @Override
    public void clearWarehouse() {

    }
}
