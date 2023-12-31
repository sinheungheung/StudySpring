package com.example.st03.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private static Long idIndex = 0L;

    private Long id;
    private String name;
    private int address;
    private List<Department> departmentList = new ArrayList<>();

    public Company(String name, int address) {
        this.id = idIndex;
        this.name = name;
        this.address = address;
        this.departmentList = new ArrayList<>();
        idIndex++;
    }
}
