package com.example.st03.service;

import com.example.st03.domain.Company;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private static List<Company> companies = new ArrayList<>();

    @Override
    public Company findCompanyByName(String name) {
        for (int i = 0; i < companies.size(); i++) {
            if (companies.get(i).getName().equals(name)) {
                return companies.get(i);
            }
        }
        return null;
    }

    @Override
    public String createCompany(String name, int address) {
        Company foundCompany = findCompanyByName(name);
        if (foundCompany == null) {
            Company newCompany = new Company(name, address);
            companies.add(newCompany);
            return "잘 만들어졌씁니다";
        }
        return "중복입니다";
    }
}
