package com.yanchenko.onlineshop.service;

import com.yanchenko.onlineshop.entity.Ware;
import com.yanchenko.onlineshop.entity.WareCategory;
import com.yanchenko.onlineshop.entity.WareType;

import java.sql.Date;
import java.util.List;

public interface WarehouseService {

    //Administration functional

    boolean createNewWare(Ware ware);

    Ware changeWare(Ware ware);

    boolean deleteWare(String name);

    boolean deleteWare(Integer id);

    boolean createNewWareType(String wareType, Integer category);

    boolean createNewWareCategory(String wareCategory);

    List<Ware> showWareList();

    List<WareType> showWareTypeList();

    List<WareCategory> showWareCategoryList();

    List<Ware> showManufacturerList(String manufacturer);

    void setReceivedDate(Integer wareID, Date receivedDate);

    void setSealedDate(Integer wareID, Date sealedDate);

    public boolean changeAccess(String typeName);

    void clearWarehouse();

    //Customer functional

    boolean addWareToCart(String name, Integer count);

    boolean removeWareFromCart(String name);

    boolean buyWareInCart();
}
