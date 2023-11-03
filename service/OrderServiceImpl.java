package com.example.hh.demo01.service;

import com.example.hh.demo01.domain.Item;
import com.example.hh.demo01.domain.Member;
import com.example.hh.demo01.domain.Order;
import com.example.hh.demo01.domain.OrderItem;
import com.example.hh.demo01.repository.ItemRepository;
import com.example.hh.demo01.repository.MemberRepository;
import com.example.hh.demo01.repository.OrderItemRepository;
import com.example.hh.demo01.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final OrderItemRepository orderItemRepository;

    @Transactional
    @Override
    public Order insertOrder(Long memberId, String itemName, int count, String address) {
        Optional<Member> member = memberRepository
                .findById(memberId);

        if (member.isEmpty()) {
            throw new IllegalStateException("존재하지 않는 사용자입니다");
        }

        Optional<Item> item = itemRepository.findByName(itemName);
        if (item.isEmpty()) {
            throw new IllegalStateException("존재하지 않는 물품입니다");
        }
        if (count > item.get().getCount()) {
            throw new IllegalStateException("살 수 없는 갯 수 입니다.");
        }

        Order newOrder = orderRepository.save(
                Order.createOrder()
                        .member(member.get())
                        .count(count)
                        .address(address)
                        .build()
        );

        item.get().minusCount(count);

        orderItemRepository.save(OrderItem.createOrderItem()
                .order(newOrder)
                .item(item.get())
                .build());

        return newOrder;
    }

    @Override
    public List<Order> getOrdersByMember(Long memberId) {
        List<Order> orders = orderRepository.findByMemberId(memberId);
        return orders;
    }
}
