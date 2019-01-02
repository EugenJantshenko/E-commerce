package com.home.hibernate.crud.operations.repository;

import com.home.hibernate.crud.operations.entity.Ware;
import org.springframework.data.repository.CrudRepository;

public interface WareRepository extends CrudRepository<Ware, Integer> {

    Ware findByWareName(String name);
    boolean existsByWareName(String name);

    void deleteWareByWareName(String name);
    void deleteByWareName(String name);

//    @Query("delete from Employee ware where WareName = ?1")
//    void deleteUsingSingleQuery(String firstName);
}
