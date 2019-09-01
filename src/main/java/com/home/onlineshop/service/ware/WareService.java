package com.home.onlineshop.service.ware;

import com.home.onlineshop.dto.WareDto;

public interface WareService {

    WareDto create(WareDto wareDto);

    WareDto update(WareDto wareDto);

    void delete(Long id);

    Iterable<WareDto> getAll();

    Iterable<WareDto> getAllByManufacturer(String manufacturer);

    Iterable<WareDto> getAllByWareName(String wareName);

}
