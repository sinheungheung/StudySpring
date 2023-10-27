package com.example.st03.service;

import com.example.st03.domain.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final List<Department> departments = new ArrayList<>();
    private static Long indexId = 0L;

    @Override
    public String insertDepartment(String name) {
        Department department = new Department();
        department = getDepart(name);
        if (department != null) {
            return department.getName() + "이 존재합니다.";
        }
        department.setId(indexId);
        indexId++;
        department.setName(name);
        departments.add(department);
        return "등록되었습니다";
    }

    @Override
    public Department getDepart(String name) {
        Department department = new Department();
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getName() == name) {
                return departments.get(i);
            }
        }
        return null;
    }
}
