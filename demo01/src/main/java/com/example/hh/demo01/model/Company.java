package com.example.hh.demo01.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "COMPANY")
@NoArgsConstructor
@Entity
@Data
public class Company {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name ="NAME")
    private String name;
}
