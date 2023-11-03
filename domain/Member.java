package com.example.hh.demo01.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MEMBER")
@Data
@Entity
public class Member {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "member")
    List<Order> orders = new ArrayList<>();

    @Builder(builderMethodName = "createMember")
    public Member(String name){
        this.name = name;
    }
}

