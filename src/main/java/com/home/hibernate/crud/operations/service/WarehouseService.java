package com.home.hibernate.crud.operations.service;

import java.sql.Date;
import java.time.LocalDateTime;

public interface WarehouseService {
    //public String searchByName(String name);

    //Administration functional
    public boolean createWare(String name, double price, String serialNumber, String wareType, LocalDateTime receivedDate, String wareCategory);
    public boolean addWare(String name, Integer count);

    public boolean deleteWare(String name);

    public boolean changeWare(String name, double price, String serialNumber, String wareType, LocalDateTime buyDate,  String wareCategory);
    public boolean changeWare(String name, double price, String serialNumber, String wareType, LocalDateTime buyDate);
    public boolean changeWare(String name, double price, String serialNumber, String wareType);
    public boolean changeWare(String name, double price, String serialNumber);
    public boolean changeWare(String name, double price);


    public void clearWarehouse();

    void setReceievedDate();

    //Customer functional
    public boolean addWareToCart(String name, Integer count);
    public boolean removeWareFromCart(String name);
    public boolean byWare();
}
