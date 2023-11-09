package kr.hs.example.backpractice01.controller;

import kr.hs.example.backpractice01.domain.Customer;
import kr.hs.example.backpractice01.dto.customer.InsertCustomerReqDto;
import kr.hs.example.backpractice01.dto.customer.CustomerResDto;
import kr.hs.example.backpractice01.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customers")
@RequiredArgsConstructor
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<?> getCustomers() {
        List<CustomerResDto> customers = customerService.getCustomers().stream().map(CustomerResDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(customers);
    }

    @PostMapping("")
    public ResponseEntity<?> insertCustomer(@RequestBody InsertCustomerReqDto params) {
        Customer customer = customerService.insertCustomer(params.getName());
        return ResponseEntity.ok(customer);
    }
}
