package com.home.onlineshop.service.interfaces.DBServices;

import com.home.onlineshop.dto.WareTypeDto;
import com.home.onlineshop.entity.WareType;

public interface WareTypeService {

    WareTypeDto create(String wareType, Long category);

    Iterable<WareType> getAll();

    public boolean block(String typeName);

    public boolean unblock(String typeName);

}
