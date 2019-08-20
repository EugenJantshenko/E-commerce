package com.yanchenko.onlineshop.service.interfaces.DBServices;

import com.yanchenko.onlineshop.dto.WareDto;

import java.util.List;

public interface WareService {

    WareDto create(WareDto wareDto);

    WareDto update(WareDto wareDto);

    boolean delete(Long id);

    Iterable<WareDto> getAll();

    List<WareDto> getByManufacturer(String manufacturer);

    boolean existsById(Long id);
}
