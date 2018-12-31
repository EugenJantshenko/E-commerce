package com.home.hibernate.crud.operations.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "roll_number")
    private int rollNumber;

    @Column(name = "course")
    private String course;
}
