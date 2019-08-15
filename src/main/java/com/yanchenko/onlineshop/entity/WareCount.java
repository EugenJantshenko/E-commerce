package com.yanchenko.onlineshop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wareCount")
public class WareCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ware_name" /*,unique = true*/)
    private String wareName;

    @Column(name = "count")
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private WareType wareType;
    @OneToMany(mappedBy = "wareType", cascade = CascadeType.ALL)
    private List<Ware> ware;
}
