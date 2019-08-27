package com.home.onlineshop.repository;

import com.home.onlineshop.entity.Ware;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WareRepository extends CrudRepository<Ware, Long> {

    Optional<Ware> getByWareName(String name);

    Ware getWareById(Long id);

    Ware getWareBySerialNumber(String serial);

    boolean existsByWareName(String name);

    boolean existsById(Long id);

    boolean existsByManufacturer(String manufacturer);

    Iterable<Ware> findAllByManufacturer(String manufacturer);

    boolean deleteByWareName(String name);
}
