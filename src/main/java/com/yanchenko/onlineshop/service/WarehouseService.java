package com.yanchenko.onlineshop.service;

import com.yanchenko.onlineshop.entity.Ware;
import com.yanchenko.onlineshop.entity.WareCategory;
import com.yanchenko.onlineshop.entity.WareType;

import java.util.List;

public interface WarehouseService {

    //Administration functional

    public boolean createNewWare(Ware ware);
    public boolean changeWare(Ware ware);
    public boolean deleteWare(String name);

    public void clearWarehouse();

    public List<Ware> showWareList();
    public List<WareType> showWareTypeList();
    public List<WareCategory> showWareCategoryList();

    void setReceievedDate();

    //Customer functional
    public boolean addWareToCart(String name, Integer count);
    public boolean removeWareFromCart(String name);
    public boolean byWare();
}
