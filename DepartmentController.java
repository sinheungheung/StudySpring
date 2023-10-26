package kr.hs.study.StudySpring.controller;

import kr.hs.study.StudySpring.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/departments")
@RequiredArgsConstructor
@RestController
public class DepartmentController {
    private final DepartmentService departmentService;
}
