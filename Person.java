package com.example.st03.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    private static Long idIndex = 0L;

    private Long id;
    private int personNumber;
    private String name;
    private Department department;

    public Person(String name, int personNumber, Department department) {
        this.id = idIndex;
        this.name = name;
        this.personNumber = personNumber;
        this.department = department;
        idIndex++;
    }
}
