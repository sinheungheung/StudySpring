package com.example.hh.demo01.controller;

import com.example.hh.demo01.domain.Item;
import com.example.hh.demo01.dto.InsertItemDto;
import com.example.hh.demo01.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/item")
@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;

    @PostMapping("")
    public ResponseEntity<?> insertItem(@RequestBody InsertItemDto params) {
        Item item = itemService.insertItem(params.getName(), params.getCount());
        return ResponseEntity.ok(item);
    }
}
