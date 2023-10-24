package com.example.st03.service;

import com.example.st03.domain.Computer;

import java.util.List;

public interface ComputerService {
    // 목록
    List<Computer> getComputers();

    // 상세
    String getComputer(Long id);

    // 추가
    String insertComputer(String name, String brand, int screenSize);

    // 수정
    String updateComputer(Long id, String name, String brand, int screenSize);

    // 삭제
    String deleteComputer(Long id);
}
