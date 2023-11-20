package kr.hs.example.backpractice01.controller;


import kr.hs.example.backpractice01.domain.Item;
import kr.hs.example.backpractice01.dto.Item.UpdateItemDto;
import kr.hs.example.backpractice01.dto.member.InsertItemDto;
import kr.hs.example.backpractice01.dto.member.ItemRes;
import kr.hs.example.backpractice01.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/items")
@RequiredArgsConstructor
@RestController
public class ItemController {
    private final ItemService itemService;

    @GetMapping("")
    public ResponseEntity<?> getItem() {
        List<ItemRes> items = itemService.getItem()
                .stream().map(ItemRes::new).collect(Collectors.toList());
        return ResponseEntity.ok(items);
    }

    @PostMapping("")
    public ResponseEntity<?> createItem(@RequestBody InsertItemDto params) {
        Item item = itemService.insertItem(params.getName(), params.getCount(), params.getPrice());
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok(null);
    }

    // UpdateItemDto : name,count,price
    @PutMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable("id") Long id, @RequestBody UpdateItemDto params) {
        itemService.updateItem(id, params.getName(), params.getCount(), params.getPrice());
        return ResponseEntity.ok(null);
    }
}