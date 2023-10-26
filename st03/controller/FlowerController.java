package com.example.st03.controller;


import com.example.st03.domain.Flower;
import com.example.st03.service.FlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/flowers")
@RestController
public class FlowerController {
    private final FlowerService flowerService;

    // 목록
    @GetMapping("")
    public ResponseEntity<?> getFlowers() {
        List<Flower> flowers = flowerService.getFlowers();
        return ResponseEntity.ok(flowers);
    }

    // 상세
    @GetMapping("/{id}")
    public ResponseEntity<?> getFlower(@PathVariable(name = "id") Long id) {
        Flower flower = flowerService.getFlower(id);
        return ResponseEntity.ok(flower);
    }

    // 추가
    @PostMapping("")
    public ResponseEntity<?> insertFlower(@RequestBody Flower flower) {
        String result = flowerService.insertFlower(flower.getName(), flower.getPrice());
        return ResponseEntity.ok(result);
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFlower(@PathVariable(name = "id") Long id, @RequestBody Flower flower) {
        String FlowerInfo = flowerService.updateFlower(id, flower.getName());
        return ResponseEntity.ok(FlowerInfo);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFlower(@PathVariable(name = "id") Long id) {
        String delete = flowerService.deleteFlower(id);
        return ResponseEntity.ok(delete);
    }
}