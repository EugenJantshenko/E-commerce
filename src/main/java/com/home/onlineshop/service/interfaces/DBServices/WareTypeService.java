package com.home.onlineshop.service.interfaces.DBServices;

import com.home.onlineshop.dto.WareTypeDto;

public interface WareTypeService {

    WareTypeDto create(String wareType, Long category);

    Iterable<WareTypeDto> getAll();

    boolean block(String typeName);

    boolean unblock(String typeName);

    boolean delete(Long id);

}
