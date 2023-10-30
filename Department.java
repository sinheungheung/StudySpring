package com.example.st03.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private static Long idIndex = 0L;

    private Long id;
    private String name;
    private Company company;
    private List<Person> personList = new ArrayList<>();

    public Department(String name, Company company) {
        this.id = idIndex;
        this.name = name;
        this.company = company;
        this.personList = new ArrayList<>();
        idIndex++;
    }
}
