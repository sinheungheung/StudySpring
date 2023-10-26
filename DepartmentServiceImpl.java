package kr.hs.study.StudySpring.service;

import kr.hs.study.StudySpring.domain.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final List<Department> departments = new ArrayList<>();
    @Override
    public Department getDepartmentByName(Long id, String name){
        Department department = new Department();
        for(int i = 0; i< departments.size(); i++){
            if(departments.get(i).getName().equals(name)){
                department = departments.get(i);
            }
        }
        if(department.getId() == null){
            return null;
        }
        return department;
    }
}
