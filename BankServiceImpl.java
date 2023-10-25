package com.example.st03.service;

import com.example.st03.domain.Bank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    private static Long indexId = 0L;
    private final List<Bank> banks = new ArrayList<>();

    @Override
    public List<Bank> getBanks() {
        return banks;
    }

    @Override
    public String getBank(Long id) {
        Bank bank = new Bank();
        for (int i = 0; i < banks.size(); i++) {
            if (banks.get(i).getId() == id) {
                bank = banks.get(i);
            }
        }
        if (bank.getId() == null) {
            return "아이디가 없습니다.";
        }
        return bank.toString();
    }

    @Override
    public String insertBank(String name, int money) {
        Bank bank = new Bank(indexId, name, money);
        indexId++;

        banks.add(bank);
        return "은행에 " + bank.getMoney() + "만큼의 돈이 있습니다.";
    }

    @Override
    public String updateBank(Long id, String name, int money) {
        int beforeMoney = 0;
        int afterMoney = 0;
        for (int i = 0; i < banks.size(); i++) {
            if (banks.get(i).getId() == id) {
                beforeMoney = banks.get(i).getMoney();
                banks.get(i).setMoney(money);
                afterMoney = banks.get(i).getMoney();
            }
        }
        if (banks.equals("")) {
            return "해당 아이디를 찾을 수 없습니다.";
        }
        return "은행에 넣었던 돈은 " + beforeMoney + ", 지금 넣은 돈은 " + afterMoney;
    }

    @Override
    public String deleteBank(Long id) {
        String delete = "";
        if (banks.size() == 0) {
            return "찾을 수 없습니다.";
        }
        for (int i = 0; i < banks.size(); i++) {
            if (banks.get(i).getId() == id) {
                banks.remove(banks.get(i));


            }
        }
        if (delete.equals("")) {
            return "해당 아이디를 찾을 수 없습니다.";
        }
        return delete;
    }
}
