package com.home.onlineshop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ware_name")
public class WareName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="ware_name")
    private String nameId;

    @OneToMany(mappedBy = "name", cascade = CascadeType.ALL)
    private List<Ware> ware;

}
