package kr.hs.study.StudySpring.service;

import kr.hs.study.StudySpring.domain.Company;
import kr.hs.study.StudySpring.domain.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService{
    private final List<Company> companys = new ArrayList<>();
    private final DepartmentService departmentService;

    private Company getCompany(Long id){

        Company company = new Company();
        for(int i = 0; i < companys.size(); i++){
            if(companys.get(i).getId() == id){
            company = companys.get(i);
        }
    }
    if(company.getId() == null){
        return  null;
    }
        return company;
    }
    @Override
    public String insertDepartment(Long id, String name) {
        Company foundCompany = getCompany(id);
        if (foundCompany == null) {
            return "찾은 회사가 없습니다.";
        }
        Department foundDepartment = departmentService.getDepartmentByName(id, name);
        if(name == null){
            return "찾는 부서가 없습니다.";
    }
        foundCompany.getDepartmentList().add(foundDepartment);
        return name;
    }
}
