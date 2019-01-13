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
    private Integer id;

    @Column(name="ware_name" /*,unique = true*/)
    private String wareName;

    @Column(name="serial_number")
    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private WareType wareType;

    @Column(name = "price")
    private double price;
}
