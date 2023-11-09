package kr.hs.example.backpractice01.repository;

import kr.hs.example.backpractice01.domain.OrderCafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCafeRepository extends JpaRepository<OrderCafe, Long> {
}
