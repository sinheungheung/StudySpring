package com.example.st03.controller;

import com.example.st03.domain.Doctor;
import com.example.st03.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.xml.DocumentDefaultsDefinition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/doctors")
@RestController
public class DoctorController {
    private final DoctorService doctorService;

    // 목록
    @GetMapping("")
    public ResponseEntity<?> getDoctors() {
        List<Doctor> doctors = doctorService.getDoctors();
        return ResponseEntity.ok(doctors);
    }

    // 상세
    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctor(@PathVariable(name = "id") Long id) {
        String doctor = doctorService.getDoctor(id);
        return ResponseEntity.ok(doctor);
    }

    // 추가
    @PostMapping("")
    public ResponseEntity<?> insertDoctor(@RequestBody Doctor doctor) {
        String insertDoctor = doctorService.insertDoctor(doctor.getName(), doctor.getAge());
        return ResponseEntity.ok(insertDoctor);
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDoctor(@PathVariable(name = "id") Long id, @RequestBody Doctor doctor) {
        String updateDoctor = doctorService.updateDoctor(id, doctor.getName(), doctor.getAge());
        return ResponseEntity.ok(updateDoctor);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable(name = "id") Long id) {
        String deleteDoctor = doctorService.deleteDoctor(id);
        return ResponseEntity.ok(deleteDoctor);
    }

}
