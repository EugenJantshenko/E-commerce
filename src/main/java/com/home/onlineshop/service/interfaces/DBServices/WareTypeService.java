package com.home.onlineshop.service.interfaces.DBServices;

import com.home.onlineshop.dto.WareTypeDto;

public interface WareTypeService {

    WareTypeDto create(String wareType, Long category);

    Iterable<WareTypeDto> getAll();

    public boolean block(String typeName);

    public boolean unblock(String typeName);

}
