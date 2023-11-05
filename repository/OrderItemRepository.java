package kr.hs.study.demo01.repository;

import kr.hs.study.demo01.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
