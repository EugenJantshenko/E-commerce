package com.home.onlineshop.repository;

import com.home.onlineshop.entity.WareCount;
import org.springframework.data.repository.CrudRepository;

public interface WareCountRepository extends CrudRepository<WareCount, Long> {
    WareCount getById(Long id);

}
