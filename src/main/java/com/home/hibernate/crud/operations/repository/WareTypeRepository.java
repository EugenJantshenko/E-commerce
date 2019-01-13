package com.home.hibernate.crud.operations.repository;

import com.home.hibernate.crud.operations.entity.WareType;
import org.springframework.data.repository.CrudRepository;

public interface WareTypeRepository extends CrudRepository<WareType, Integer> {
    WareType findWareTypeByTypeName(String name);

    boolean existsWareTypeByTypeName(String name);
}
