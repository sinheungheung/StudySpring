package com.example.st03.service;

import com.example.st03.domain.Company;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    final List<Company> companies = new ArrayList<>();
    private static long indexId = 0L;


    @Override
    public String insertCompany(String name) {
        Company company = new Company();
        company = getCompany(name);
        if (company != null) {
            return company.getName() + "존재한다.";
        }
        company.setId(indexId);
        indexId++;
        company.setName(name);
        companies.add(company);
        return "등록되었습니다.";
    }

    @Override
    public Company getCompany(String name) {
        Company company = new Company();
        for (int i = 0; i < companies.size(); i++) {
            if (companies.get(i).getName() == name) {
               return companies.get(i);
            }
        }
        return null;
    }
}
