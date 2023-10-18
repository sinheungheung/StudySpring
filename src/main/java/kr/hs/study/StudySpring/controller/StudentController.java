package kr.hs.study.StudySpring.controller;


import kr.hs.study.StudySpring.domain.Student;
import kr.hs.study.StudySpring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/student")
    public ResponseEntity<?> test01() {
        List<Student> student = studentService.getStudent();
        return ResponseEntity.ok(student);
    }
}
