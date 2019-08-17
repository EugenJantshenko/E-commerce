package com.yanchenko.onlineshop.repository;

import com.yanchenko.onlineshop.entity.WareCategory;
import com.yanchenko.onlineshop.entity.WareCount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WareCountRepository extends CrudRepository<WareCategory, Long> {
    List<WareCount> findAllByIdIsNotNull();
}
