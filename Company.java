package com.example.st03.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company {
    private Long id;
    private String name;

    List<Company> companies = new ArrayList<>();
}
