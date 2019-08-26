package com.home.onlineshop.service.interfaces.DBServices;

import com.home.onlineshop.dto.WareCategoryDto;
import com.home.onlineshop.entity.WareCategory;

public interface WareCategoryService {

    WareCategoryDto create(String wareCategory);

    Iterable<WareCategory> getAll();
}
