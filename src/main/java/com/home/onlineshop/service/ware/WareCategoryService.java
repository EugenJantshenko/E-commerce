package com.home.onlineshop.service.ware;

import com.home.onlineshop.dto.WareCategoryDto;

public interface WareCategoryService {

    WareCategoryDto create(String wareCategory);

    Iterable<WareCategoryDto> getAll();

    void delete (Long id);
}
