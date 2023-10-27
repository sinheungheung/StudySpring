package com.example.st03.service;

import com.example.st03.domain.Company;


public interface CompanyService {

    String insertCompany(String name);

    Company getCompany(String name);

}
