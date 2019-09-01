package com.home.onlineshop.service.ware;

import com.home.onlineshop.dto.WareTypeDto;

public interface WareTypeService {

    WareTypeDto create(String wareType, Long category);

    Iterable<WareTypeDto> getAll();

    WareTypeDto lock(Long id);

    WareTypeDto unlock(Long id);

    void delete(Long id);

}
