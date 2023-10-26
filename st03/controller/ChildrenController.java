package com.example.st03.controller;

import com.example.st03.service.ChildrenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/childrens")
@RestController
public class ChildrenController {
    private final ChildrenService childrenService;
    @PostMapping("{id}/cottonCandies/{cottonCandyName}")
    public ResponseEntity<?> buyCotton(@PathVariable(name="id")Long id,
                                       @PathVariable(name = "cottonCandyName")String cottonCandyName){
        String result = childrenService.buyCottonCandy(id, cottonCandyName);
        return ResponseEntity.ok(result);
    }
}
