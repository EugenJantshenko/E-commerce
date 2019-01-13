package com.home.hibernate.crud.operations.service;

import java.time.LocalDateTime;

public interface WarehouseService {
    //public String searchByName(String name);

    //Administration functional
    public boolean createWare(String name, double price, Integer numberOnWarehouse, String wareType, LocalDateTime buyDate, String customer, String wareCategory);
    public boolean addWare(String name, Integer count);
    public boolean reduceWare(String name, Integer count);
    public boolean deleteWare(String name);
    public void clearWarehouse();

    //Customer functional
    public boolean addWareToCart(String name, Integer count);
    public boolean removeWareFromCart(String name);
    public boolean byWare();
}
