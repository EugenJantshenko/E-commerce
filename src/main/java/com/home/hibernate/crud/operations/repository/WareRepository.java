package com.home.hibernate.crud.operations.repository;

import com.home.hibernate.crud.operations.entity.Ware;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface WareRepository extends CrudRepository<Ware, Integer> {

    Ware findByWareName(String name);
    boolean existsByWareName(String name);

    Ware getWareById(Integer id);

    void deleteWareByWareName(String name);

}
