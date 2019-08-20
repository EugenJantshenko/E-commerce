package com.yanchenko.onlineshop.repository;

import com.yanchenko.onlineshop.entity.WareCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WareCategoryRepository extends CrudRepository<WareCategory, Long> {
    Optional<WareCategory> findById(Long id);

    WareCategory findByCategoryName(String name);

    boolean existsByCategoryName(String name);

}
