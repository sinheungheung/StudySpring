package com.example.st03.controller;

import com.example.st03.domain.Department;
import com.example.st03.service.CompanyService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyController {
    private final CompanyService companyService;
    @PostMapping("{id}/departments/")
    public ResponseEntity<?> myDepartment(@PathVariable(name="id")Long id,
                                          @PathVariable(name="")){
        String result = companyService.myDepartment(id, );
        return ResponseEntity.ok(result);
    }
}

