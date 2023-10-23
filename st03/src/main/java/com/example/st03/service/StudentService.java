package com.example.st03.service;

import com.example.st03.domain.Student;

import java.util.List;

public interface StudentService {

    // 목록
    List<Student> getStudents();

    // 상세
    String  getStudent(Long id);

    // 추가
    String insertStudent(String name);

    // 수정
    String updateStudent(Long id, String name);

    // 삭제
    String deleteStudent(Long id);

}
