package com.yanchenko.onlineshop.repository;

import com.yanchenko.onlineshop.entity.WareType;
import org.springframework.data.repository.CrudRepository;

public interface WareTypeRepository extends CrudRepository<WareType, Long> {
    WareType findByTypeName(String name);

    WareType findById(Integer id);

    boolean existsByTypeName(String name);

}
