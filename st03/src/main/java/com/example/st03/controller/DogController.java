package com.example.st03.controller;

import com.example.st03.domain.Dog;
import com.example.st03.service.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dogs")
@RequiredArgsConstructor
@RestController
public class DogController {
    private final DogService dogService;

    // 목록
    @GetMapping("")
    public ResponseEntity<?> getDogs() {
        List<Dog> dogList = dogService.getDogs();
        return ResponseEntity.ok(dogList);
    }

    // 상세
    @GetMapping("/{id}")
    public ResponseEntity<?> getDog(@PathVariable(name = "id") Long id) {
        Dog dog = dogService.getDog(id);
        return ResponseEntity.ok(dog);
    }

    // 추가
    @PostMapping("")
    public ResponseEntity<?> insertDogs(@RequestBody Dog dogs) {
        String result = dogService.insertDog(dogs.getName());
        return ResponseEntity.ok(result);
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDogs(@PathVariable(name = "id") Long id, @RequestBody Dog dogs) {
        String result = dogService.updateDog(id, dogs.getName());
        return ResponseEntity.ok(result);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDogs(@PathVariable(name = "id") Long id) {
        String result = dogService.deleteDog(id);
        return ResponseEntity.ok(result);
    }
}
