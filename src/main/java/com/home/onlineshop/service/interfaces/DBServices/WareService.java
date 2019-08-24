package com.home.onlineshop.service.interfaces.DBServices;

import com.home.onlineshop.dto.WareDto;

import java.util.List;

public interface WareService {

    WareDto create(WareDto wareDto);

    WareDto update(WareDto wareDto);

    boolean delete(Long id);

    Iterable<WareDto> getAll();

    List<WareDto> getAllByManufacturer(String manufacturer);

    boolean existsById(Long id);
}
