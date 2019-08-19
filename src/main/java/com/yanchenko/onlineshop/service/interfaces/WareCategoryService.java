package com.yanchenko.onlineshop.service.interfaces;

import com.yanchenko.onlineshop.entity.WareCategory;

import java.util.List;

public interface WareCategoryService {

    boolean createNewWareCategory(String wareCategory);

    List<WareCategory> showWareCategoryList();
}
