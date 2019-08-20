package com.yanchenko.onlineshop.repository;

import com.yanchenko.onlineshop.entity.Ware;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface WareRepository extends CrudRepository<Ware, Long> {

    Optional<Ware> getByWareName(String name);

    Ware getWareById(Long id);

    boolean existsByWareName(String name);

    boolean existsById(Long id);

    boolean existsByManufacturer(String manufacturer);

    List<Ware> findAllByManufacturer(String manufacturer);

    boolean deleteByWareName(String name);
}
