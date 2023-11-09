package kr.hs.example.backpractice01.service;

import kr.hs.example.backpractice01.domain.Department;

import java.util.List;

public interface DepartmentService {

    Department insertDepartment(String name);

    List<Department> getDepartments();
}
