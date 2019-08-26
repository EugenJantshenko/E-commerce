package com.home.onlineshop.service.interfaces.DBServices;

import com.home.onlineshop.dto.WareCategoryDto;

import java.util.List;

public interface WareCategoryService {

    WareCategoryDto create(String wareCategory);

    List<WareCategoryDto> getAll();
}
