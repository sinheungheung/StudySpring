package com.example.st03.service;

import com.example.st03.domain.Doctor;

import java.util.List;

public interface DoctorService {
    // 목록
    List<Doctor> getDoctors();
    // 상세
    String getDoctor(Long id);
    // 추가
    String insertDoctor(String name, int age);
    // 수정
    String updateDoctor(Long id, String name, int age);
    // 삭제
    String deleteDoctor(Long id);
}
