package com.yanchenko.onlineshop.service.impl;

import com.yanchenko.onlineshop.service.interfaces.DBServices.WareCategoryService;
import com.yanchenko.onlineshop.service.interfaces.DBServices.WareCountService;
import com.yanchenko.onlineshop.service.interfaces.DBServices.WareService;
import com.yanchenko.onlineshop.service.interfaces.DBServices.WareTypeService;
import com.yanchenko.onlineshop.service.interfaces.WareHouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service

public class WareHouseServiceImpl implements WareHouseService {

    private final WareService wareService;
    private final WareCountService wareCountService;
    private final WareTypeService wareTypeService;
    private final WareCategoryService wareCategoryService;

    @Autowired
    public WareHouseServiceImpl(WareService wareService, WareCountService wareCountService, WareTypeService wareTypeService, WareCategoryService wareCategoryService){
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
