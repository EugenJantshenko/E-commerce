package com.home.onlineshop.service.interfaces.DBServices;

import com.home.onlineshop.dto.WareDto;

public interface WareService {

    WareDto create(WareDto wareDto);

    WareDto update(WareDto wareDto);

    boolean delete(Long id);

    Iterable<WareDto> getAll();

    Iterable<WareDto> getAllByManufacturer(String manufacturer);

    boolean existsById(Long id);
}
