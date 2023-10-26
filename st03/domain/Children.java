package com.example.st03.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Children {
    private Long id;
    private String name;
    private int age;
    private int money = 5000;

    private List<CottonCandy> candyList = new ArrayList<>();
}
// 클래스는 어떤 객체를 만드는 설계도
// 붕어빵 슈붕 = new 붕어빵("슈크림");
// 피자 치즈피자 = new 피자("치즈");