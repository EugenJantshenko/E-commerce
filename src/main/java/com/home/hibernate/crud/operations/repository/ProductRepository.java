package com.home.hibernate.crud.operations.repository;

import com.home.hibernate.crud.operations.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Student, Integer> {
    Student findByStudentName(String name);
}
