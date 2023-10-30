package com.example.st03.service;

import com.example.st03.domain.Person;


public interface PersonService {
    Person findPersonByName(String name);
    Person findPersonByPersonNum(int personNum);

    String createPerson(String departmentName, int personNum, String name);
}
