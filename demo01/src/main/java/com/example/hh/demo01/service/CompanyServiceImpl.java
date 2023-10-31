package com.example.hh.demo01.service;

import com.example.hh.demo01.model.Company;
import com.example.hh.demo01.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).get();
    }

    @Override
    public List<Company> getCompanyByName(String name) {
        return companyRepository.findByName(name);
    }

    @Transactional
    @Override
    public Company insertCompany(String name) {
        Company insertCompany = new Company();
        insertCompany.setName(name);
        return companyRepository.save(insertCompany);
    }
}
