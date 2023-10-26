package com.example.st03.service;

import com.example.st03.domain.Department;

public interface DepartmentService {
    Department getDepartmentByName(String name);
    void insertDepartment(String name);
}
