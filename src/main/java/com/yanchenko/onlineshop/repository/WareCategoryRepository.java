package com.yanchenko.onlineshop.repository;

import com.yanchenko.onlineshop.entity.WareCategory;
import com.yanchenko.onlineshop.entity.WareType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WareCategoryRepository extends CrudRepository<WareCategory, Integer> {
    WareCategory findWareCategoryByCategoryName(String name);
    boolean existsWareCategoryByCategoryName(String name);
    List<WareCategory> findAllByIdIsNotNull();
}
