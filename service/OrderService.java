package com.example.hh.demo01.service;

import com.example.hh.demo01.domain.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {
    Order insertOrder(Long memberId, String itemName, int count, String address);

    List<Order> getOrdersByMember(Long memberId);
}
