package com.yanchenko.onlineshop.service.interfaces;

import com.yanchenko.onlineshop.entity.WareType;

import java.util.List;

public interface WareTypeService {

    boolean createNewWareType(String wareType, Integer category);

    List<WareType> showWareTypeList();

    public boolean changeAccess(String typeName);
}
