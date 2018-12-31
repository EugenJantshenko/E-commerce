package com.home.hibernate.crud.operations.service.impl;

import com.home.hibernate.crud.operations.entity.Student;
import com.home.hibernate.crud.operations.repository.ProductRepository;
import com.home.hibernate.crud.operations.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("productTwo")
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public String searchByName(String name) {
        Student byStudentName = repository.findByStudentName(name);
        if (byStudentName != null) {
            return String.valueOf(byStudentName.getId());
        } else {
            return "not found";
        }
    }
}
