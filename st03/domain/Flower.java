package com.example.st03.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Flower {
    private Long id;
    private String name;
    private int price;
}
