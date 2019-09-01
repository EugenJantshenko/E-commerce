package com.home.onlineshop.repository;

import com.home.onlineshop.entity.WareCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WareCategoryRepository extends CrudRepository<WareCategory, Long> {
    Optional<WareCategory> findById(Long id);

    boolean existsByCategoryName(String name);

}
