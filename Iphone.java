package com.example.hh.demo01.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "IPHONE")
@NoArgsConstructor
@Entity
@Data
public class Iphone {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id값을 따로 할당하지 않아도 DB에서 insertSQL을 실행한다.
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SIZE")
    private int size;
}
