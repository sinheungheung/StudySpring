package com.example.hh.demo01.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity //가 붙은 클래스는 JPA가 관리하는 것 (디비 테이블과의 매핑)
@Table()
@NoArgsConstructor
@Data
public class Friend {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

}

