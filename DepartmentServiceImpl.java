package com.example.st03.service;

import com.example.st03.domain.Company;
import com.example.st03.domain.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private static List<Department> departments = new ArrayList<>();
    private final CompanyService companyService;

    @Override
    public Department findDepartmentByName(String name) {
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getName().equals(name)) {
                return departments.get(i);
            }
        }
        return null;
    }

    @Override
    public String createDepartment(String companyName, String name) {
        Company company = companyService.findCompanyByName(companyName);
        if (company == null) {
            return "해당 이름의 회사가 없습니다";
        }

        Department department = findDepartmentByName(name);
        if (department != null) {
            return "부서 이름이 이미 존재합니다";
        }

        Department newDepartment = new Department(name, company);
        departments.add(newDepartment);

        return "만들었습니다 부서를";
    }

}
