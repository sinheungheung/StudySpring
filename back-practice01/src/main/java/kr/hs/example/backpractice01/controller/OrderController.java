package kr.hs.example.backpractice01.controller;

import kr.hs.example.backpractice01.dto.order.InsertOrderDto;
import kr.hs.example.backpractice01.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/orders")
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("")
    public ResponseEntity<?> buyItem(@RequestBody InsertOrderDto params) {
        orderService.buyItem(params.getItemId(), params.getMemberId(), params.getCount());
        return ResponseEntity.ok(null);
    }
}
