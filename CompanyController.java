package kr.hs.study.StudySpring.controller;

import kr.hs.study.StudySpring.service.CompanyService;
import kr.hs.study.StudySpring.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/companys")
@RestController
public class CompanyController {
    private final DepartmentService departmentService;

    @PostMapping("/{id}/departments/{departmentName}")
    public ResponseEntity<?> myDepartment(@PathVariable(name="id")Long id,
                                          @PathVariable(name="departmentName")String departmentName){
        String result = CompanyService.insertDepartment(id, departmentName);
        return  ResponseEntity.ok(result);
    }
}
