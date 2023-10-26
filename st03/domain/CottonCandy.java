package com.example.st03.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CottonCandy {
    private Long id;
    private String flavor;
    private int price;
}
