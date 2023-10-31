package com.example.hh.demo01.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name = "STUDENT")
@NoArgsConstructor
@Entity
@Data
public class Student {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private int age;


}
