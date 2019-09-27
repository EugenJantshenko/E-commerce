package com.home.onlineshop.service.ware;

import com.home.onlineshop.dto.WareDto;

public interface WareService {

    WareDto create(WareDto wareDto);

    WareDto update(WareDto wareDto);

    void delete(Long id);

    Iterable<WareDto> getAll();

    Iterable<WareDto> getAllByManufacturer(Long manufacturerId);

    Iterable<WareDto> getAllByWareName(Long wareNameId);

    boolean existByNameId(Long id);

}
