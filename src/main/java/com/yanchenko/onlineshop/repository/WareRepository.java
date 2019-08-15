package com.yanchenko.onlineshop.repository;

import com.yanchenko.onlineshop.entity.Ware;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WareRepository extends CrudRepository<Ware, Integer> {

    Ware findByWareName(String name);

    Ware getWareById(Integer id);

    boolean existsByWareName(String name);

    boolean existsById(Integer id);

    boolean existsByManufacturer(String manufacturer);

    List<Ware> findAllByIdIsNotNull();

    List<Ware> findAllByManufacturer(String manufacturer);

    boolean deleteWareById(Integer id);

    boolean deleteWareByWareName(String name);

}
