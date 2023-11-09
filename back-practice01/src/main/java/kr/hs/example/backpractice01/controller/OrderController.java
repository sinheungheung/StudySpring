package kr.hs.example.backpractice01.controller;

import kr.hs.example.backpractice01.domain.Order;
import kr.hs.example.backpractice01.dto.order.InsertOrderDto;
import kr.hs.example.backpractice01.dto.order.OrderRes;
import kr.hs.example.backpractice01.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("")
    public ResponseEntity<?> insertOrder(@RequestBody InsertOrderDto params) {
        Order order = orderService.insertOrder(
                params.getMemberId(),
                params.getClothesName(),
                params.getCount(),
                params.getAddress());
        return ResponseEntity.ok(order);
    }

    @GetMapping("")
    public ResponseEntity<?> getOrders() {
        List<OrderRes> orders = orderService.getOrders()
                .stream().map(OrderRes::new).collect(Collectors.toList());
        return ResponseEntity.ok(orders);
    }
}
