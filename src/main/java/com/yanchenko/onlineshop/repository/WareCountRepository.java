package com.yanchenko.onlineshop.repository;

import com.yanchenko.onlineshop.entity.WareCategory;
import org.springframework.data.repository.CrudRepository;

public interface WareCountRepository extends CrudRepository<WareCategory, Long> {

}
