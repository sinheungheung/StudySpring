package com.example.st03.controller;


import com.example.st03.domain.Student;
import com.example.st03.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/students")
@RestController
public class StudentController {

    private final StudentService studentService;

    // 목록
    @GetMapping("")
    public ResponseEntity<?> getStudents() {
        List<Student> studentList = studentService.getStudents();
        return ResponseEntity.ok(studentList);
    }

    //    // 상세
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable(name = "id") Long id) {
        String student = studentService.getStudent(id);
        return ResponseEntity.ok(student);
    }

    // 추가
    @PostMapping("")
    public ResponseEntity<?> insertStudent(@RequestBody Student student) {
        String result = studentService.insertStudent(student.getName());
        return ResponseEntity.ok(result);
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable(name = "id") Long id, @RequestBody Student student) {
        String studentName = studentService.updateStudent(id, student.getName());
        return ResponseEntity.ok(studentName);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(name = "id") Long id) {
        String result = studentService.deleteStudent(id);
        return ResponseEntity.ok(result);
    }
}
