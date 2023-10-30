package com.example.st03.service;

import com.example.st03.domain.Department;
import com.example.st03.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {
    private static List<Person> people = new ArrayList<>();
    private final DepartmentService departmentService;

    @Override
    public Person findPersonByName(String name) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getName().equals(name)) {
                return people.get(i);
            }
        }
        return null;
    }

    @Override
    public Person findPersonByPersonNum(int personNum) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getPersonNumber() == personNum) {
                return people.get(i);
            }
        }
        return null;
    }

    @Override
    public String createPerson(String departmentName, int personNum, String name) {
        Department department = departmentService.findDepartmentByName(departmentName);
        if (department == null) {
            return "해당 이름의 부서가 없습니다.";
        }
        Person person = findPersonByPersonNum(personNum);
        if (person != null) {
            return "사원번호가 존재합니다.";
        }

        Person newPerson = new Person(name, personNum, department);
        people.add(newPerson);

        return "새로운 이름을 등록하였습니다.";
    }
}
