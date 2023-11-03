package com.example.hh.demo01.repository;

import com.example.hh.demo01.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByMemberId(Long memberId);
}
