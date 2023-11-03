package com.example.hh.demo01.controller;

import com.example.hh.demo01.domain.Order;
import com.example.hh.demo01.dto.InsertOrderDto;
import com.example.hh.demo01.dto.OrderReq;
import com.example.hh.demo01.service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("")
    public ResponseEntity<?> insertOrder(@RequestBody InsertOrderDto params) {
        Order order = orderService.insertOrder(
                params.getMemberId(),
                params.getItemName(),
                params.getCount(),
                params.getAddress());
        return ResponseEntity.ok(order);
    }
}
