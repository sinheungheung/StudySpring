package com.example.st03.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private Long id;
    private String name;
    private List<Student> studentList = new ArrayList<>();

    public Team(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
