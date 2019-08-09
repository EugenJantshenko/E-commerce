package com.yanchenko.onlineshop.repository;

import com.yanchenko.onlineshop.entity.Ware;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WareRepository extends CrudRepository<Ware, Integer> {

    Ware findByWareName(String name);
    boolean existsByWareName(String name);

    Ware getWareById(Integer id);

    List<Ware> findAllByIdIsNotNull();

    void deleteWareByWareName(String name);

}
