package com.yanchenko.onlineshop.service.interfaces.DBServices;

import com.yanchenko.onlineshop.dto.WareCategoryDto;

import java.util.List;

public interface WareCategoryService {

    WareCategoryDto create(String wareCategory);

    List<WareCategoryDto> getAll();
}
