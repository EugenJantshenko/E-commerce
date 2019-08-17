package com.yanchenko.onlineshop.repository;

import com.yanchenko.onlineshop.entity.WareCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface WareCategoryRepository extends CrudRepository<WareCategory, Long> {
    Optional<WareCategory> findById(Integer id);

    WareCategory findWareCategoryByCategoryName(String name);

    boolean existsWareCategoryByCategoryName(String name);

    List<WareCategory> findAllByIdIsNotNull();
}
