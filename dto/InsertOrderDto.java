package com.example.hh.demo01.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InsertOrderDto {
    private Long memberId;
    private String itemName;
    private int count;
    private String address;
}
