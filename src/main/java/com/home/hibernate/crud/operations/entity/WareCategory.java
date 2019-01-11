package com.home.hibernate.crud.operations.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "ware_category")
public class WareCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="category_name")
    private String categoryName;

    @OneToMany(mappedBy = "wareCategory", cascade = CascadeType.ALL)
    private List<WareType> categories;
}
