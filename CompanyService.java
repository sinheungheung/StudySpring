package com.example.st03.service;

import com.example.st03.domain.Company;

public interface CompanyService {
    String  createCompany(String name, int address);

    Company findCompanyByName(String name);
}
