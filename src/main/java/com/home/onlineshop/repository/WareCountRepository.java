package com.home.onlineshop.repository;

import com.home.onlineshop.entity.WareCategory;
import org.springframework.data.repository.CrudRepository;

public interface WareCountRepository extends CrudRepository<WareCategory, Long> {

}
