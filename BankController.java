package com.example.st03.controller;


import com.example.st03.domain.Bank;
import com.example.st03.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/banks")
@RestController
public class BankController {

    private final BankService bankService;

    @GetMapping("")
    public ResponseEntity<?> getBank(){
        List<Bank> banks = bankService.getBanks();
        return ResponseEntity.ok(banks);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getBank(@PathVariable(name = "id")Long id){
        String bank = bankService.getBank(id);
        return ResponseEntity.ok(bank);
    }
    @PostMapping("")
    public ResponseEntity<?> insertBank(@RequestBody Bank bank){
        String insert = bankService.insertBank(bank.getName(), bank.getMoney());
        return ResponseEntity.ok(insert);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBank(@PathVariable(name="id")Long id, @RequestBody Bank bank){
        String update = bankService.updateBank(id, bank.getName(), bank.getMoney());
        return ResponseEntity.ok(update);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBank(@PathVariable(name="id")Long id){
        String delete = bankService.deleteBank(id);
        return ResponseEntity.ok(delete);
    }
}
