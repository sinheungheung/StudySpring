package kr.hs.example.backpractice01.controller;

import kr.hs.example.backpractice01.domain.Department;
import kr.hs.example.backpractice01.dto.department.DepartmentRes;
import kr.hs.example.backpractice01.dto.department.InsertDepartmentDto;
import kr.hs.example.backpractice01.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/departments")
@RequiredArgsConstructor
@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("")
    public ResponseEntity<?> insertDepartment(@RequestBody InsertDepartmentDto params) {
        Department department = departmentService.insertDepartment(params.getName());
        return ResponseEntity.ok(department);
    }

    @GetMapping("")
    public ResponseEntity<?> getDepartment() {
        List<DepartmentRes> department = departmentService.getDepartments()
                .stream().map(DepartmentRes::new).collect(Collectors.toList());
        return ResponseEntity.ok(department);
    }
}
