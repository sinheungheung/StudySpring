package kr.hs.example.backpractice01.controller;


import kr.hs.example.backpractice01.domain.Clothes;
import kr.hs.example.backpractice01.dto.clothes.ClothesRes;
import kr.hs.example.backpractice01.dto.clothes.InsertClothesDto;
import kr.hs.example.backpractice01.service.ClothesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/clothes")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
public class ClothesController {
    private final ClothesService clothesService;

    @PostMapping("")
    public ResponseEntity<?> insertClothes(@RequestBody InsertClothesDto params) {
        Clothes clothes = clothesService.insertClothes(params.getName(), params.getCount());
        return ResponseEntity.ok(clothes);
    }

    @GetMapping("")
    public ResponseEntity<?> getClothes() {
        List<ClothesRes> clothes = clothesService.getClothes()
                .stream().map(ClothesRes::new).collect(Collectors.toList());
        return ResponseEntity.ok(clothes);
    }

}
