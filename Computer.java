package com.example.st03.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Computer {
    private Long id;
    private String name;
    private String brand;
    private int screenSize;
}
