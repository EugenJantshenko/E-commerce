package com.home.onlineshop.service.interfaces.DBServices;

import com.home.onlineshop.dto.WareCategoryDto;

public interface WareCategoryService {

    WareCategoryDto create(String wareCategory);

    Iterable<WareCategoryDto> getAll();

    void delete (Long id);
}
