package com.home.hibernate.crud.operations.service;

import com.home.hibernate.crud.operations.entity.WareCategory;

public interface WarehouseService {
    //public String searchByName(String name);

    //Administration functional
    public boolean createWare(String name, double price, Integer count, WareCategory category);
    public boolean addWare(String name, Integer count);
    public boolean reduceWare(String name, Integer count);
    public boolean deleteWare(String name);
    public void clearWarehouse();

    //Customer functional
    public boolean addWareToCart(String name, Integer count);
    public boolean byWare();
}
