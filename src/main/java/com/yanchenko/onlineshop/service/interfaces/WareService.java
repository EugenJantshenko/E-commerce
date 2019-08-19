package com.yanchenko.onlineshop.service.interfaces;

import com.yanchenko.onlineshop.entity.Ware;

import java.sql.Date;
import java.util.List;

public interface WareService {

    boolean createNewWare(Ware ware);

    Ware updateWare(Ware ware);

    boolean deleteWare(String name);

    boolean deleteWare(Integer id);

    List<Ware> showWareList();

    List<Ware> showManufacturerList(String manufacturer);

    void setReceivedDate(Integer wareID, Date receivedDate);

    void setSealedDate(Integer wareID, Date sealedDate);

    public boolean existsWareById(Long id);
}
