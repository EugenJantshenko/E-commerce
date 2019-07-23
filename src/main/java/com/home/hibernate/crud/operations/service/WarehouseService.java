package com.home.hibernate.crud.operations.service;

import com.home.hibernate.crud.operations.entity.Ware;

import java.time.LocalDateTime;

public interface WarehouseService {

    //Administration functional

    public boolean createNewWare(Ware ware);
    public boolean changeWare(Ware ware);
    public boolean deleteWare(String name);

    public void clearWarehouse();

    void setReceievedDate();

    //Customer functional
    public boolean addWareToCart(String name, Integer count);
    public boolean removeWareFromCart(String name);
    public boolean byWare();
}
