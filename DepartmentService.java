package com.example.st03.service;

import com.example.st03.domain.Department;

public interface DepartmentService {
    String insertDepartment(String name);
    Department getDepart(String name);
}
