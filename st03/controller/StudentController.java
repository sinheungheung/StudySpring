package com.example.st03.controller;

import com.example.st03.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/students")
@RequiredArgsConstructor
@RestController
public class StudentController {
    private final StudentService studentService;
}
