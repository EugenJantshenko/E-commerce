package com.home.hibernate.crud.operations.repository;

import com.home.hibernate.crud.operations.entity.WareCategory;
import org.springframework.data.repository.CrudRepository;

public interface WareCategoryRepository extends CrudRepository<WareCategory, Integer> {
    WareCategory findWareCategoryByCategoryName(String name);

    boolean existsWareCategoryByCategoryName(String name);
}
