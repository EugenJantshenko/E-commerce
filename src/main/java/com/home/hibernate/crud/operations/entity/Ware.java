package com.home.hibernate.crud.operations.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ware")
public class Ware implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="ware_name")
    private String wareName;

    @Column(name = "price")
    private double price;

    @Column(name = "count")
    private int count;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private WareCategory wareCategory;
}
