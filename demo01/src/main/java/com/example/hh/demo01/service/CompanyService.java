package com.example.hh.demo01.service;

import com.example.hh.demo01.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> getCompanies();

    Company getCompanyById(Long id);

    List<Company> getCompanyByName(String name);

    Company insertCompany(String name);

}
