package com.example.hh.demo01.service;

import com.example.hh.demo01.model.Company;
import com.example.hh.demo01.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getStudenByName(String name) {
        return studentRepository.findByName(name);
    }

    @Transactional
    @Override
    public Student insertStudent(String name, int age) {
        Student insertStudent = new Student();
        insertStudent.setName(name);
        insertStudent.setAge(age);
        return companyRepository.save(insertCompany);
    }
}
