package com.home.hibernate.crud.operations.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ware_type")
public class WareType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "count")
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private WareCategory wareCategory;

    @OneToMany(mappedBy = "wareType", cascade = CascadeType.ALL)
    private List<Ware> ware;

    @Column(name = "blocked", columnDefinition = "int default 0")
    private  boolean isBlocked;

    @Column(name = "price")
    private double price;
}
