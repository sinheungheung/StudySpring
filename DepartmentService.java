package kr.hs.study.StudySpring.service;

import kr.hs.study.StudySpring.domain.Department;

public interface DepartmentService {
    Department getDepartmentByName(Long id, String name);
}
