package com.home.onlineshop.repository;

import com.home.onlineshop.entity.Ware;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface WareRepository extends CrudRepository<Ware, Long> {

    boolean existsById(Long id);

    List<Ware> findAllByManufacturerId(Long manufacturerId);

    List<Ware> findAllByNameId(Long id);

    List<Ware> findAllByNameIdAndSoldIsFalse(Long id, Pageable pageable);

    List<Ware> findAllByNameIdAndSoldIsFalse(Long id);

    Optional<Ware> findBySerialNumber(String serialNumber);

    boolean existsByNameId(Long id);


}
