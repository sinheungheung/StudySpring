package com.example.hh.demo01.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

// 사용자의 데이터를 나타내는 엔터티 클래스 생성
@Entity
@Data
public class UserDTO {
    @Id
    private Long id;
    private String name;
    private String address;
    private String hobby;
}
