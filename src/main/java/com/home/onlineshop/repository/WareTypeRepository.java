package com.home.onlineshop.repository;

import com.home.onlineshop.entity.WareType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WareTypeRepository extends CrudRepository<WareType, Long> {
    WareType findByTypeName(String name);

    Optional<WareType> findById(Long id);

    boolean existsByTypeName(String name);
}
