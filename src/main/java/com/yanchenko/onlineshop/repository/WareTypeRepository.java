package com.yanchenko.onlineshop.repository;

import com.yanchenko.onlineshop.entity.WareType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WareTypeRepository extends CrudRepository<WareType, Integer> {
    WareType findWareTypeByTypeName(String name);
    boolean existsWareTypeByTypeName(String name);
    WareType findWareTypeById(Integer id);
    List<WareType> findAllByIdIsNotNull();
}
