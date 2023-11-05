package kr.hs.study.demo01.service;

import kr.hs.study.demo01.domain.Order;

import java.util.List;

public interface OrderService {
    Order insertOrder(Long memberId, String itemName, int count, String address);

    List<Order> getOrdersByMember(Long memberId);
}
