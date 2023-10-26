package com.example.st03.service;

import com.example.st03.domain.Company;
import com.example.st03.domain.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService{
    private static Long indexId = 0L;
    private final List<Company> companys = new ArrayList<>();


    public Company myDepartment(String name){
        Company company = new Company();
        for(int i = 0; i < companys.size(); i++){
            if(companys.get(i).getName().equals(name));
            company = companys.get(i);
        }
        if(company.getId() == null){
            return null;
        }
        return company;
    }
    @Override
    public String myDepartment(Long id, String name){
        Department foundDepartment =
    }

    @Override
    public void insertCompany(String name){
        Company company = new Company(indexId, name, new ArrayList<Department>());
        indexId++;
    }

}
