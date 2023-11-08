package kr.hs.example.backpractice01.service;

import kr.hs.example.backpractice01.domain.Department;
import kr.hs.example.backpractice01.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public Department insertDepartment(String name) {
        Optional<Department> foundDept = departmentRepository.findByName(name);
        if (foundDept.isPresent()) {
            throw new IllegalStateException("이미 존재하는 부서이름 입니다.");
        }
        Department newDepartment = Department.createDepartment()
                .name(name)
                .build();
        return departmentRepository.save(newDepartment);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }
}

