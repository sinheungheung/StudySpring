package com.example.st03.service;

import com.example.st03.domain.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private static Long indexId = 0L;
    private final List<Department> departments = new ArrayList<>();
    @Override
    public Department getDepartmentByName(String name){
        Department department = new Department();
        for(int i = 0; i < departments.size(); i++){
            if(departments.get(i).getName().equals(name)){
                department = departments.get(i);
            }
        }
        if(department.getId() == null){
            return null;
        }
        return department;
    }
    @Override
    public void insertDepartment(String name){
        // 부서이름 겹치면 X
        if(getDepartmentByName(name) == null){
            Department department = new Department(indexId, name);
            indexId++;
            departments.add(department);
        }
    }
}
