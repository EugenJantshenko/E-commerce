package com.home.onlineshop.repository;

import com.home.onlineshop.entity.Ware;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WareRepository extends CrudRepository<Ware, Long> {

    boolean existsById(Long id);

    Iterable<Ware> findAllByManufacturerId(Long id);

    Iterable<Ware> findAllByWareNameId (Long id);

    Optional<Ware> findBySerialNumber(String serialNumber);

}
