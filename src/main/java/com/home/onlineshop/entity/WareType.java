package com.home.onlineshop.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ware_type")
public class WareType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "typeName")
    private String typeName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private WareCategory wareCategory;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Ware> ware;

    @Column(name = "blocked", columnDefinition = "int default 0")
    private  boolean isBlocked;
}
