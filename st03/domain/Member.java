package com.example.st03.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Long id;
    private String name;
    private int money = 10000;

    private List<Flower> flowerList = new ArrayList<>(); // 꽃 바구니

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
