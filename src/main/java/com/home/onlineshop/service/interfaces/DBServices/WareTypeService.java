package com.home.onlineshop.service.interfaces.DBServices;

import com.home.onlineshop.dto.WareTypeDto;

public interface WareTypeService {

    WareTypeDto create(String wareType, Long category);

    Iterable<WareTypeDto> getAll();

    boolean lock(String typeName);

    boolean unlock(String typeName);

    void delete(Long id);

}
