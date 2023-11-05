package kr.hs.study.demo01.controller;

import kr.hs.study.demo01.domain.Order;
import kr.hs.study.demo01.dto.InsertOrderDto;
import kr.hs.study.demo01.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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