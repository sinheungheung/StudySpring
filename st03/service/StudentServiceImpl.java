package com.example.st03.service;

import com.example.st03.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final List<Student> students = new ArrayList<>();

    @Override
    public Student getStudentByName(String name) {
        Student student = new Student();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) ;
            student = students.get(i);
        }
        if (student.getId() == null) {
            return null;
        }
        return student;
    }
}

