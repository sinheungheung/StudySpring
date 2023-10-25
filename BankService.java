package com.example.st03.service;

import com.example.st03.domain.Bank;

import java.util.List;

public interface BankService {
    List<Bank> getBanks();
    String getBank(Long id);
    String insertBank(String name, int money);
    String updateBank(Long id, String name, int money);
    String deleteBank(Long id);
}
