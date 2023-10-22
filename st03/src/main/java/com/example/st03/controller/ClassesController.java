package com.example.st03.controller;

import com.example.st03.service.ClassesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ClassesController {

    private final ClassesService classesService;

    @GetMapping("/classes")
    public ResponseEntity<?> test01() {
        List<Class> class1 = new ArrayList<>();
        return null;
    }
}