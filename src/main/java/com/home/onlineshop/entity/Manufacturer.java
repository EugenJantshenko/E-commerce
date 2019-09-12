package com.home.onlineshop.entity;


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
@Table(name = "manufacturer")
public class Manufacturer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="manufacturer_name")
    private String manufacturerName;

    @OneToMany(mappedBy = "manufacturerId", cascade = CascadeType.ALL)
    private List<Ware> ware;
}
