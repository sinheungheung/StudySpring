package com.example.st03.controller;

import com.example.st03.domain.Computer;
import com.example.st03.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/computers")
@RequiredArgsConstructor
@RestController
public class ComputerController {

    private final ComputerService computerService;

    // 목록
    @GetMapping("")
    public ResponseEntity<?> getComputers() {
        List<Computer> computers = computerService.getComputers();
        return ResponseEntity.ok(computers);
    }

    // 상세
    @GetMapping("/{id}")
    public ResponseEntity<?> getComputers(@PathVariable(name = "id") Long id) {
        String computer = computerService.getComputer(id);
        return ResponseEntity.ok(computer);

    }

    // 추가
    @PostMapping("")
    public ResponseEntity<?> insertComputer(@RequestBody Computer computer) {
        String insertComputer = computerService.insertComputer(computer.getName(), computer.getBrand(), computer.getScreenSize());

        return ResponseEntity.ok(insertComputer);
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateComputer(@PathVariable(name = "id") Long id, @RequestBody Computer computer) {
        String updateComputer = computerService.updateComputer(id, computer.getName(), computer.getBrand(), computer.getScreenSize());

        return  ResponseEntity.ok(updateComputer);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComputer(@PathVariable(name = "id") Long id) {
        String deleteComputer = computerService.deleteComputer(id);

        return ResponseEntity.ok(deleteComputer);

    }
}

