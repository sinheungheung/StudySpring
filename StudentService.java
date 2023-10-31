package com.example.hh.demo01.service;

import com.example.hh.demo01.model.Company;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getStudents();

    Student getStudent(Long id);

    List<Student> getStudentByName(String name);

    Company insertCompany(String name, int age);
o
}
