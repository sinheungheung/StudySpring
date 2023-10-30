package com.example.st03.service;

import com.example.st03.domain.Department;

public interface DepartmentService {
    Department findDepartmentByName(String name);

    String createDepartment(String companyName, String name);
}
