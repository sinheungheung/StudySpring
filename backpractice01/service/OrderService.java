package kr.hs.example.backpractice01.service;

import kr.hs.example.backpractice01.domain.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {
    Order insertOrder(Long memberId, String memberName, int count, String address);

    List<Order> getOrdersByMember(Long memberId);

    List<Order> getOrders();

}
