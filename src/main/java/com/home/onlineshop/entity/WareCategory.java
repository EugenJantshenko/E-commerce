package com.home.onlineshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
//@ToString
@Table(name = "ware_category")
public class WareCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="category_name")
    private String categoryName;

    @OneToMany(mappedBy = "wareCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WareType> wareTypes;
}
