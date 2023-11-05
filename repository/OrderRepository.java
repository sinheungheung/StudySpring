package kr.hs.study.demo01.repository;

import kr.hs.study.demo01.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByMemerId(Long memberId);
}
